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
	public void actualizarArchivoDoc(String ruta, int id) {
		repositorio.actualizarArchivoDoc(ruta, id);
		
	}

	@Override
	public List<Documento> listarDocumento() {
		return (List<Documento>)repositorio.findAll();
	}

}
