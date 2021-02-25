package com.cibertec.integrador.interfaces;

import java.util.Date;
import java.util.List;

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
	
	@Query(value="select * from trabajador where id_rol=?1 ", nativeQuery=true)
	List<Trabajador> listarTrabajadorRol (int rol);
	
	@Query(value="select a.* from trabajador a inner join usuario_trabajador b on a.dni_trabajador = b.dni_trabajador inner join usuario c on b.id_usuario = c.id_usuario where c.username =?1 ", nativeQuery=true)
	Trabajador buscarTrabajadorUsuario(String username);
	
	

}
