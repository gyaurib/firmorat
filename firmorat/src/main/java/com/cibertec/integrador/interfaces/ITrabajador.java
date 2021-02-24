package com.cibertec.integrador.interfaces;

import java.util.List;

import com.cibertec.integrador.model.Trabajador;

public interface ITrabajador {
	
	public Trabajador registrarTrabajador (Trabajador t);
	public Trabajador buscarTrabajador (String dni);
	public List<Trabajador> listarTrabajador();
	public void eliminarTrabajador (String dni);
	public List<Trabajador> listarTrabajadorRol (int rol);
	public int actualizarTrabajador(Trabajador t); 


}
