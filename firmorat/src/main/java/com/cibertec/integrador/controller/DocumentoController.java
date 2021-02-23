package com.cibertec.integrador.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.integrador.model.Documento;
import com.cibertec.integrador.model.Trabajador;
import com.cibertec.integrador.service.DocumentoService;
import com.cibertec.integrador.service.TrabajadorService;

@Controller
@RequestMapping("/doc")
public class DocumentoController {
	
	@Autowired
	private DocumentoService documentoService;
	
	@Autowired
	private TrabajadorService trabajadorService;
	
	final static String dni = "73114622";
	
	@GetMapping("/cargar")
	public String cargarDocumento(Model model) {		
		List<Documento> listadoDocumentos = documentoService.listarDocumentoTrabajador(dni);
		Documento documento = new Documento();
		model.addAttribute("documento", documento);
		model.addAttribute("listadoDocumentos", listadoDocumentos);		
		return "cargar-documento";
	}
	
	@PostMapping("/cargar")
	public String grabarDocumento(@Valid @ModelAttribute("documento")Documento d,BindingResult result,RedirectAttributes redirect,Model model,
			@RequestParam("file") MultipartFile pdf) {
		
		if(result.hasErrors()) {
			List<Documento> listadoDocumentos = documentoService.listarDocumentoTrabajador(dni);
			model.addAttribute("listadoDocumentos", listadoDocumentos);
			return "cargar-documento";
		}
		
		if (pdf.isEmpty()){
			redirect.addFlashAttribute("error", "Se debe cargar documento");
			return "redirect:/doc/cargar";
		}
		
		Trabajador trabajador = trabajadorService.buscarTrabajador(dni);
		d.setTrabajador(trabajador);		
		Documento documento = documentoService.guardar(d);
		
		if (documento!=null) {
			redirect.addFlashAttribute("success", "Documento registrado");
		}else {
			redirect.addFlashAttribute("error", "Error al grabar");
		}
		
		return "redirect:/doc/cargar";
	}
	
	

}
