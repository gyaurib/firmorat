package com.cibertec.integrador.interfaces;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cibertec.integrador.model.Trabajador;

public interface ITrabajadorRep extends CrudRepository<Trabajador, String> {
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update trabajador set dni_trabajador=?1,nombres=?2,apellidos=?3,direccion=?4,correo=?5,fecha_nac=?6 where dni_trabajador=?7", nativeQuery = true)
	int actualizarTrabajador(String dni,String nombres,String apellidos,String direccion,String correo,Date fechanac,String dni2);

}
