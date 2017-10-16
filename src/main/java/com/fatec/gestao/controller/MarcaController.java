package com.fatec.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.gestao.model.Marca;
import com.fatec.gestao.repository.Marcas;

@Controller
@RequestMapping("/marcas")
public class MarcaController {
	@Autowired
	private Marcas marcas;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaMarcas");
		modelAndView.addObject("marcas", marcas.findAll());
		modelAndView.addObject(new Marca());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Marca marca) {
		this.marcas.save(marca);
		return "redirect:/marcas";
	}
	
	@GetMapping("/remove")
	public String remover(Marca marca) {
		this.marcas.delete(marca);
		return "redirect:/marcas";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Marca marcaAntiga) {
		ModelAndView modelAndView = new ModelAndView("EditaMarca");
		modelAndView.addObject("marcaAntiga", marcas.findOne(marcaAntiga.getId()));
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Marca marca) {
		this.marcas.save(marca);
		return "redirect:/marcas";
	} 
}
