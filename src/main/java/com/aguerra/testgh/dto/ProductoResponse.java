package com.aguerra.testgh.dto;

import java.util.List;

import com.aguerra.testgh.entities.Producto;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Esta es una clase para representar la estructura de los datos que se transfiere entre el cliente y el servidor
 * 
 * @author Angel Guerra
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoResponse {

	private String codRespuesta;
	
	private String msjRespuesta;
	
	private List<Producto> productos;

	public String getCodRespuesta() {
		return codRespuesta;
	}

	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}

	public String getMsjRespuesta() {
		return msjRespuesta;
	}

	public void setMsjRespuesta(String msjRespuesta) {
		this.msjRespuesta = msjRespuesta;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "ProductoResponse [codRespuesta=" + codRespuesta + ", msjRespuesta=" + msjRespuesta + ", productos="
				+ productos + "]";
	}
}
