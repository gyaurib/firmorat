package com.cibertec.integrador.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cibertec.integrador.model.Documento;

public interface IDocumentoRep extends CrudRepository<Documento, Integer> {
	
	@Query(value="select * from documento where dni_trabajador=?1", nativeQuery=true)
	List<Documento> listarDocumentoTrabajador(String dni);

}
