package com.cibertec.integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.integrador.interfaces.ITrabajador;
import com.cibertec.integrador.interfaces.ITrabajadorRep;
import com.cibertec.integrador.model.Trabajador;

@Service
public class TrabajadorService implements ITrabajador {
	
	@Autowired
	private ITrabajadorRep repositorio;

	@Override
	public Trabajador registrarTrabajador(Trabajador t) {
		return repositorio.save(t);
	}

	@Override
	public List<Trabajador> listarTrabajador() {
		return (List<Trabajador>) repositorio.findAll();
	}

	@Override
	public Trabajador buscarTrabajador(String dni) {		
		return repositorio.findById(dni).orElse(null);
	}

	@Override
	public int actualizarTrabajador(Trabajador t) {
		int val = repositorio.actualizarTrabajador(t.getDni(),t.getNombres(),t.getApellidos(),t.getDireccion(),t.getEmail(),t.getFechaNacimiento(),t.getDni());
		return val;
	}

	@Override
	public void eliminarTrabajador(String dni) {
		repositorio.deleteById(dni);
		
	}

	@Override
	public List<Trabajador> listarTrabajadorRol(int rol) {
		return repositorio.listarTrabajadorRol(rol);
	}

	@Override
	public Trabajador buscarTrabajadorUsuario(String username) {
		return repositorio.buscarTrabajadorUsuario(username);
	}
	
	
}
