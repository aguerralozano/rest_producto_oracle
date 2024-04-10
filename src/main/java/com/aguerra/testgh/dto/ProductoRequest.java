package com.aguerra.testgh.dto;

import java.math.BigDecimal;

/**
 * Esta es una clase para representar la estructura de los datos que se transfiere entre el cliente y el servidor
 * 
 * @author Angel Guerra
 */
public class ProductoRequest {
	
	private Long idProducto;
	
	private String nombre;
	
	private BigDecimal precio;

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ProductoRequest [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
}
