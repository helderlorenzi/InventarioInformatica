package com.fatec.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.gestao.model.Equipamento;
import com.fatec.gestao.repository.Equipamentos;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {
	
	@Autowired
	private Equipamentos equipamentos;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaEquipamentos");
		modelAndView.addObject("equipamentos",equipamentos.findAll());
		modelAndView.addObject(new Equipamento());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Equipamento equipamento) {
		this.equipamentos.save(equipamento);
		return "redirect:/equipamentos";
	}
}
