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
	
	@Column(name="doc_cargado")
	private String documentoCargado;
	
	@Column(name="doc_firmado")
	private String documentoFirmado;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_carga")
	private Date fechaCarga;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_firma")
	private Date fechaFirma;
	
	@ManyToOne
	@JoinColumn(name="dni_trabajador", nullable=false)
	private Trabajador trabajador;
	
	@PrePersist
	public void prePersist() throws Exception {		
		fechaCarga = new Date();	
    }
	
	public Documento() {	
	}

	public Documento(int id, @NotEmpty String nombre, @NotEmpty String descripcion, String documentoCargado,
			String documentoFirmado, Date fechaCarga, Date fechaFirma, Trabajador trabajador) {		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.documentoCargado = documentoCargado;
		this.documentoFirmado = documentoFirmado;
		this.fechaCarga = fechaCarga;
		this.fechaFirma = fechaFirma;
		this.trabajador = trabajador;
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

	public String getDocumentoFirmado() {
		return documentoFirmado;
	}

	public void setDocumentoFirmado(String documentoFirmado) {
		this.documentoFirmado = documentoFirmado;
	}

	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Date getFechaFirma() {
		return fechaFirma;
	}

	public void setFechaFirma(Date fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
	
	
	
	
	
}
	

