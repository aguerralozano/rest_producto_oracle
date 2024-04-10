package com.aguerra.testgh.repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aguerra.testgh.dto.ProductoRequest;
import com.aguerra.testgh.dto.ProductoResponse;
import com.aguerra.testgh.entities.Producto;
import com.aguerra.testgh.util.Constantes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

/**
 * Esta es una clase que maneja la interacción con la base de datos
 * 
 * @author Angel Guerra
 */
@Repository
public class ProductoRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductoRepository.class);

    @Autowired
    private EntityManager entityManager;

    public ProductoResponse callSP_InsertProducto(ProductoRequest newProducto, Date fechaRegistro) {
    	ProductoResponse response = new ProductoResponse();
    	
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("INSERTAR_PRODUCTO");
        storedProcedure.registerStoredProcedureParameter("P_ID_PRODUCTO", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_PRECIO", BigDecimal.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_FECHA_REGISTRO", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("P_CURSOR", ResultSet.class, ParameterMode.REF_CURSOR); // Cursor de salida
        storedProcedure.registerStoredProcedureParameter("P_CODIGO", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("P_MENSAJE", String.class, ParameterMode.OUT);
        storedProcedure.setParameter("P_ID_PRODUCTO", newProducto.getIdProducto());
        storedProcedure.setParameter("P_NOMBRE", newProducto.getNombre());
        storedProcedure.setParameter("P_PRECIO", newProducto.getPrecio());
        storedProcedure.setParameter("P_FECHA_REGISTRO", fechaRegistro);
        storedProcedure.execute();

        String codRespuesta = (String) storedProcedure.getOutputParameterValue("P_CODIGO");
        String msjRespuesta = (String) storedProcedure.getOutputParameterValue("P_MENSAJE");

        response.setCodRespuesta(codRespuesta);
        response.setMsjRespuesta(msjRespuesta);
        
        if(codRespuesta.equals(Constantes.DB_COD_OK)) {
            ResultSet cursor = (ResultSet) storedProcedure.getOutputParameterValue("P_CURSOR");
            // Procesar el cursor de salida
            response.setProductos(new ArrayList<>());
            if (cursor != null) {
                try {
                    while (cursor.next()) {
                        Producto producto = new Producto();
                        // Mapear los datos del cursor a objetos Producto
                        producto.setIdProducto(cursor.getLong("ID_PRODUCTO"));
                        producto.setNombre(cursor.getString("NOMBRE"));
                        producto.setPrecio(cursor.getBigDecimal("PRECIO"));
                        producto.setFechaRegistro(cursor.getString("FECHA_REGISTRO"));
                        producto.setActivo(cursor.getString("ACTIVO"));
                        response.getProductos().add(producto);
                    }
                } catch (SQLException e) {
                	logger.error("Error en obtener datos del cursor");
                    response.setCodRespuesta(Constantes.DB_COD_ERROR);
                    response.setMsjRespuesta(e.getMessage());
                }
            }
        }
        
        return response;

    }
}
