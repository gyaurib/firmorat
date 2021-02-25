package com.cibertec.integrador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.integrador.interfaces.IPlan;
import com.cibertec.integrador.interfaces.IPlanRep;
import com.cibertec.integrador.model.Plan;

@Service
public class PlanService implements IPlan {
	
	@Autowired
	private IPlanRep repositorio;

	@Override
	public Plan buscarPlan(int id) {
		return repositorio.buscarPlan(id);		
	}

}
