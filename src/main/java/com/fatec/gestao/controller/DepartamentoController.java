package com.fatec.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.gestao.model.Departamento;
import com.fatec.gestao.repository.Departamentos;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	@Autowired
	private Departamentos departamentos;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaDepartamentos");
		modelAndView.addObject("departamentos", departamentos.findAll());
		modelAndView.addObject(new Departamento());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Departamento departamento) {
		this.departamentos.save(departamento);
		return "redirect:/departamentos";
	}
	
	@GetMapping("/remove")
	public String remover(Departamento departamento) {
		this.departamentos.delete(departamento);
		return "redirect:/departamentos";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Departamento departamentoAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaDepartamento");
		modelAndView.addObject("departamentoAntigo", departamentos.findOne(departamentoAntigo.getId()));
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Departamento departamento) {
		this.departamentos.save(departamento);
		return "redirect:/departamentos";
	} 
}
