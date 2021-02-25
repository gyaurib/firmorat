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
		Plan plan_1 = planService.buscarPlan(1);
		Plan plan_2 = planService.buscarPlan(2);
		Plan plan_3 = planService.buscarPlan(3);
		
		model.addAttribute("plan1", plan_1);
		model.addAttribute("plan2", plan_2);
		model.addAttribute("plan3", plan_3);		
		
		
		return "comprar-planes";
	}	
	

}

