package com.fatec.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.gestao.model.Modelo;
import com.fatec.gestao.repository.Modelos;

@Controller
@RequestMapping("/modelos")
public class ModeloController {
	@Autowired
	private Modelos modelos;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaModelos");
		modelAndView.addObject("modelos", modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Modelo modelo) {
		this.modelos.save(modelo);
		return "redirect:/modelos";
	}
	
	@GetMapping("/remove")
	public String remover(Modelo modelo) {
		this.modelos.delete(modelo);
		return "redirect:/modelos";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Modelo modeloAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaModelo");
		modelAndView.addObject("modeloAntigo", modelos.findOne(modeloAntigo.getId()));
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Modelo modelo) {
		this.modelos.save(modelo);
		return "redirect:/modelos";
	} 
}
