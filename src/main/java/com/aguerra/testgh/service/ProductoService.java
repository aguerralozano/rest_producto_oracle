package com.aguerra.testgh.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguerra.testgh.dto.ProductoRequest;
import com.aguerra.testgh.dto.ProductoResponse;
import com.aguerra.testgh.repository.ProductoRepository;

/**
 * Esta es una clase implementa la lógica de negocio de Producto
 * 
 * @author Angel Guerra
 */
@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepo;
	
	public ProductoResponse insertarProducto(ProductoRequest newProducto){
		ProductoResponse response = null;
		
		response = productoRepo.callSP_InsertProducto(newProducto, new Date());
		
		return response;
	}
}
