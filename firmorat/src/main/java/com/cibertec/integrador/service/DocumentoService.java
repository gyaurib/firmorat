package com.cibertec.integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.integrador.interfaces.IDocumento;
import com.cibertec.integrador.interfaces.IDocumentoRep;
import com.cibertec.integrador.model.Documento;

@Service
public class DocumentoService implements IDocumento {
	
	@Autowired
	private IDocumentoRep repositorio;

	@Override
	public List<Documento> listarDocumentoTrabajador(String dni) {		
		return (List<Documento>)repositorio.listarDocumentoTrabajador(dni); 
	}

	@Override
	public Documento guardar(Documento d) {	
		return repositorio.save(d);
	}

	@Override
	public void actualizarDocumentoCargado(String ruta, int id) {
		repositorio.actualizarDocumentoCargado(ruta, id);
		
	}

	@Override
	public List<Documento> listarDocumento() {
		return (List<Documento>)repositorio.findAll();
	}

	@Override
	public List<Documento> listarDocumentoFirmante(String dni) {
		return (List<Documento>) repositorio.listarDocumentoFirmante(dni);
	}

	@Override
	public List<Documento> buscarDocumentoNombre(String nombre,String dni) {
		return (List<Documento>) repositorio.buscarDocumentoNombre(nombre,dni);
	}

	@Override
	public void actualizarDocumentoFirmado(String ruta, int id) {
		repositorio.actualizarDocumentoFirmado(ruta, id);
		
	}

	@Override
	public Documento buscarDocumento(int id) {
		return repositorio.findById(id).orElse(null);
	}

}
