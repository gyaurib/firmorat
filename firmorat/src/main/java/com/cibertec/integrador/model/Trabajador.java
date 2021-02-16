package com.cibertec.integrador.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="trabajador")
public class Trabajador {
	
	@Id
	@Column(name="dni_trabajador")
	private String dni;
	@NotEmpty
	@Column(name="nombres")
	private String nombres;
	@NotEmpty
	@Column(name="apellidos")	
	private String apellidos;
	
	@Column(name="fecha_nac")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@Column(name="direccion")
	private String direccion;
	@Column(name="correo")
	private String email;
		
	@ManyToOne
	@JoinColumn(name="id_rol", nullable=false)
	private Rol rol;	

	public Trabajador() {		
	}
	public Trabajador(String dni, @NotEmpty String nombres, @NotEmpty String apellidos, Date fechaNacimiento,
			String direccion, String email, Rol rol) {		
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.email = email;
		this.rol = rol;
	}
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	

		
}