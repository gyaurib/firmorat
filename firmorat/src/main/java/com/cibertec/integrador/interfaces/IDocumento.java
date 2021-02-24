package com.cibertec.integrador.interfaces;

import java.util.List;

import com.cibertec.integrador.model.Documento;

public interface IDocumento {
	
	public List<Documento> listarDocumentoTrabajador(String dni);
	public List<Documento> listarDocumento();
	public Documento guardar(Documento d);
	public void actualizarArchivoDoc (String ruta,int id); 

}
