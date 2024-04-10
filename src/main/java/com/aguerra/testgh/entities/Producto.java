package com.aguerra.testgh.entities;

import java.math.BigDecimal;

/**
 * Esta clase representa una tabla Producto en una base de datos 
 * 
 * @author Angel Guerra
 */
public class Producto {
	
	private Long idProducto;

	private String nombre;
	
	private BigDecimal precio;
	
	private String fechaRegistro;
	
	private String activo;

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

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", fechaRegistro="
				+ fechaRegistro + ", activo=" + activo + "]";
	}
}
