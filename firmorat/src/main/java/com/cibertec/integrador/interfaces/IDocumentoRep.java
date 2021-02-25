package com.cibertec.integrador.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cibertec.integrador.model.Documento;

public interface IDocumentoRep extends CrudRepository<Documento, Integer> {
	
	@Query(value="select * from documento where dni_carga=?1", nativeQuery=true)
	List<Documento> listarDocumentoTrabajador(String dni);
	
	@Query(value="select * from documento where dni_firma=?1 and doc_firmado is null", nativeQuery=true)
	List<Documento> listarDocumentoFirmante(String dni);
	
	@Query(value="select * from documento where nombre like %?1% and dni_firma =?2 and doc_firmado is null", nativeQuery=true)
	List<Documento> buscarDocumentoNombre(String nombre,String dni);	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update documento set doc_cargado=?1 where cod_documento=?2", nativeQuery=true)
	void actualizarDocumentoCargado (String ruta,int id);
			
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update documento set doc_firmado=?1 ,fecha_firma = curdate() where cod_documento =?2", nativeQuery=true)
	void actualizarDocumentoFirmado(String ruta,int id);

}
