package com.cibertec.integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.integrador.model.Plan;
import com.cibertec.integrador.service.PlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {
	
	@Autowired
	private PlanService planService;
	
	@GetMapping("/comprar")
	public String comprarPlanes(Model model) {
		Plan plan_1 = planService.buscarPlan(3);		
		
		String descripcion = plan_1.getDescripcion();
		int cantidad = plan_1.getCantidad();
		double precio = plan_1.getPrecio();
		
		model.addAttribute("plan1", plan_1);		
		model.addAttribute("desc", descripcion);
		model.addAttribute("cant", cantidad);
		model.addAttribute("pre", precio);
		
		
		return "comprar-planes";
	}	
	

}

