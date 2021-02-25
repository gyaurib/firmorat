package com.cibertec.integrador.interfaces;

import java.util.List;

import com.cibertec.integrador.model.Documento;

public interface IDocumento {
	
	public Documento buscarDocumento(int id);
	public List<Documento> listarDocumentoTrabajador(String dni);
	public List<Documento> listarDocumentoFirmante(String dni);
	public List<Documento> buscarDocumentoNombre(String nombre,String dni);
	public List<Documento> listarDocumento();
	public Documento guardar(Documento d);
	public void actualizarDocumentoCargado (String ruta,int id);
	public void actualizarDocumentoFirmado(String ruta,int id);

}
