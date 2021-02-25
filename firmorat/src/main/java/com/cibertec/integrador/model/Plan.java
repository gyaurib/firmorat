package com.cibertec.integrador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venta_firmas")
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_venta_firmas")
	private int id;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="duracion")
	private String duración;
	@Column(name="precio")
	private double precio;	
	@Column(name="cantidad")
	private int cantidad;
	
	public Plan() {	
	}

	public Plan(int id, String descripcion, String duración, double precio, int cantidad) {		
		this.id = id;
		this.descripcion = descripcion;
		this.duración = duración;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDuración() {
		return duración;
	}
	public void setDuración(String duración) {
		this.duración = duración;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
