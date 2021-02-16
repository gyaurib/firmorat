package com.cibertec.integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.integrador.model.Rol;
import com.cibertec.integrador.model.Trabajador;
import com.cibertec.integrador.service.RolService;
import com.cibertec.integrador.service.TrabajadorService;

@RequestMapping("/mantenimiento-trabajadores")
@Controller
public class TrabajadorController {
	
	@Autowired
	private TrabajadorService trabajadorService;
	
	@Autowired
	private RolService rolService;
	
	@GetMapping("/listar")
	public String listarTrabajador(Model model) {		
		List<Trabajador> listaTrabajadores = trabajadorService.listarTrabajador();
		model.addAttribute("listaTrabajadores", listaTrabajadores);		
		return "listar-trabajador";		
	}
	
	@GetMapping("/crear")
	public String crearTrabajador(Model model) {		
		Trabajador trabajador = new Trabajador();
		List<Rol> listadoRol = rolService.listarRol();
		model.addAttribute("trabajador", trabajador);
		model.addAttribute("listadoRol", listadoRol);
		model.addAttribute("titulo", "Crear Trabajador");
		return "crear-trabajador";		
	}
	
	@GetMapping("/editar/{dni}")
	public String editarTrabajador(@PathVariable String dni,Model model) {		
		Trabajador trabajador = trabajadorService.buscarTrabajador(dni);
		List<Rol> listadoRol = rolService.listarRol();		
		model.addAttribute("trabajador", trabajador);
		model.addAttribute("listadoRol", listadoRol);
		model.addAttribute("titulo", "Editar Trabajador");
		return "editar-trabajador";		
	}
	
	@GetMapping("/eliminar/{dni}")
	public String eliminarTrabajador(@PathVariable String dni,RedirectAttributes redirect) {
		trabajadorService.eliminarTrabajador(dni);
		redirect.addFlashAttribute("success", "Trabajador Eliminado");
		return "redirect:/mantenimiento-trabajadores/listar";		
	}
	
	@PostMapping("/grabar")
	public String grabarTrabajador(Trabajador t,@RequestParam (required = false) Integer valid,RedirectAttributes redirect) {
		
		switch (valid) {
		case 1 :
			Trabajador trabajador= trabajadorService.registrarTrabajador(t);
			if (trabajador != null) {
				redirect.addFlashAttribute("success", "Trabajador Registrado");
			}else {
				redirect.addFlashAttribute("error", "Error actualizando");
			}
			break;
		case 2:
			int update = trabajadorService.actualizarTrabajador(t);
			if (update != 0) {
				redirect.addFlashAttribute("success", "Trabajador Actualizado");
			}else {
				redirect.addFlashAttribute("error", "Error actualizando");
			}	
			break;
		}		
		return "redirect:/mantenimiento-trabajadores/listar";
	}

}
