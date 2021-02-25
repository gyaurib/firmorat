package com.cibertec.integrador.interfaces;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cibertec.integrador.model.Plan;

public interface IPlanRep extends CrudRepository<Plan, Integer> {
	
	@Query(value="select * from venta_firmas where id_venta_firmas = ?1", nativeQuery=true)
	Plan buscarPlan(int id);

}
