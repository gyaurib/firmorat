package com.cibertec.integrador.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	/*
	 *73114622
	 *
	 */
	
	@GetMapping("/cargar")
	public String cargarDocumento(Model model) {
		Documento documento = new Documento();
		List<Documento> listadoDocumentos = documentoService.listarDocumentoTrabajador(dni);
		List<Trabajador> listadoFirmante = trabajadorService.listarTrabajadorRol(1);		
		model.addAttribute("documento", documento);
		model.addAttribute("listadoDocumentos", listadoDocumentos);
		model.addAttribute("listadoFirmante", listadoFirmante);
		return "cargar-documento";
	}
	
	@PostMapping("/cargar")
	public String grabarDocumento(@Valid @ModelAttribute("documento")Documento d,BindingResult result,RedirectAttributes redirect,Model model,
			@RequestParam("file") MultipartFile pdf) throws Exception{
		
		if(result.hasErrors()) {
			List<Documento> listadoDocumentos = documentoService.listarDocumentoTrabajador(dni);
			model.addAttribute("listadoDocumentos", listadoDocumentos);
			return "cargar-documento";
		}
		
		if (pdf.isEmpty()){
			redirect.addFlashAttribute("error", "Se debe cargar documento");
			return "redirect:/doc/cargar";
		}		
		
		if (!(pdf.getOriginalFilename().contains(".pdf")||pdf.getOriginalFilename().contains(".PDF"))) {
			redirect.addFlashAttribute("error", "Solo se permite extensión PDF");
			return "redirect:/doc/cargar";
		}		
		
		Trabajador trabajador = trabajadorService.buscarTrabajador(dni);
		d.setTrabajador(trabajador);		
		Documento documento = documentoService.guardar(d);		
		
		Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
		String rootPath = directorioRecursos.toFile().getAbsolutePath();
		try {
			byte[] bytes = pdf.getBytes();
			Path rutaCompleta = Paths.get(rootPath + "//"+documento.getId()+"-"+pdf.getOriginalFilename());
			Files.write(rutaCompleta,bytes);	
			documentoService.actualizarArchivoDoc(documento.getId()+"-"+pdf.getOriginalFilename(), documento.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (documento!=null) {
			redirect.addFlashAttribute("success", "Documento registrado");
		}else {
			redirect.addFlashAttribute("error", "Error al grabar");
		}
		
		return "redirect:/doc/cargar";
	}
	
	@GetMapping("/firmar")
	public String firmarDocumento(Model model) {		
		List<Documento> listadoDocumentos = documentoService.listarDocumento();		
		model.addAttribute("listadoDocumentos", listadoDocumentos);		
		return "firmar-documento";
	}
	
	@SuppressWarnings("resource")
	@GetMapping("/archivo/{file}")
	@ResponseBody
	public void mostrar(@PathVariable("file") String file,HttpServletResponse response) {
		
		String ruta = "src//main//resources//static/uploads/";
		
		response.setContentType("aplication/pdf");
		response.setHeader("Content-Disposition", "attachment; filename ="+file);
		response.setHeader("Content-Transfer-Encoding","binary");
		
		try {
			BufferedOutputStream buffer = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fileInput = new FileInputStream(ruta+file);
			int len;
			byte[] buf = new byte[1024];
			while((len=fileInput.read(buf))>0) {
				buffer.write(buf,0,len);
			}
			buffer.close();
			response.flushBuffer();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	

}

