package com.cibertec.integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.integrador.interfaces.IRol;
import com.cibertec.integrador.interfaces.IRolRep;
import com.cibertec.integrador.model.Rol;

@Service
public class RolService implements IRol {
	
	@Autowired
	private IRolRep repositorio;	

	@Override
	public List<Rol> listarRol() {
		return (List<Rol>)repositorio.findAll();
	}

}
