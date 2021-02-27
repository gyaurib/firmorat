package com.cibertec.integrador.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="documento")
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_documento")
	private int id;
	
	@NotEmpty
	@Column(name="nombre")
	private String nombre;
	
	@NotEmpty
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="dni_carga",referencedColumnName="dni_trabajador" ,nullable=false)
	private Trabajador trabajadorCarga;
	
	@Column(name="doc_cargado")
	private String documentoCargado;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_carga")
	private Date fechaCarga;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="dni_firma",referencedColumnName="dni_trabajador" ,nullable=false)
	private Trabajador trabajadorFirma;		
	
	@Column(name="doc_firmado")
	private String documentoFirmado;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_firma")
	private Date fechaFirma;	
	
	@PrePersist
	public void prePersist() throws Exception {		
		fechaCarga = new Date();	
    }
	
	public Documento() {	
	}

	public Documento(int id, @NotEmpty String nombre, @NotEmpty String descripcion, String documentoCargado,
			Date fechaCarga, Trabajador trabajadorCarga, String documentoFirmado, Date fechaFirma,
			Trabajador trabajadorFirma) {		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.documentoCargado = documentoCargado;
		this.fechaCarga = fechaCarga;
		this.trabajadorCarga = trabajadorCarga;
		this.documentoFirmado = documentoFirmado;
		this.fechaFirma = fechaFirma;
		this.trabajadorFirma = trabajadorFirma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDocumentoCargado() {
		return documentoCargado;
	}

	public void setDocumentoCargado(String documentoCargado) {
		this.documentoCargado = documentoCargado;
	}

	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Trabajador getTrabajadorCarga() {
		return trabajadorCarga;
	}

	public void setTrabajadorCarga(Trabajador trabajadorCarga) {
		this.trabajadorCarga = trabajadorCarga;
	}

	public String getDocumentoFirmado() {
		return documentoFirmado;
	}

	public void setDocumentoFirmado(String documentoFirmado) {
		this.documentoFirmado = documentoFirmado;
	}

	public Date getFechaFirma() {
		return fechaFirma;
	}

	public void setFechaFirma(Date fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	public Trabajador getTrabajadorFirma() {
		return trabajadorFirma;
	}

	public void setTrabajadorFirma(Trabajador trabajadorFirma) {
		this.trabajadorFirma = trabajadorFirma;
	}
	
	
	
	


}