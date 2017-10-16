package com.fatec.gestao.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.gestao.model.Departamento;
import com.fatec.gestao.model.Marca;
import com.fatec.gestao.model.Modelo;
import com.fatec.gestao.model.Switcher;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.repository.Switches;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/switchs")
public class SwitchController extends PatrimonioService{
	
	@Autowired
	private Switches switchs;
	
	@Autowired
	private Departamentos localizacoes;
	
	@Autowired
	private Equipamentos equipamentos;
	
	@Autowired
	private Marcas marcas;
	
	@Autowired
	private Modelos modelos;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaSwitchs");
		modelAndView.addObject("switchs",switchs.findAll());
		modelAndView.addObject(new Switcher());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Switcher switcher) {
		if(!patrimonioJaExistente(equipamentos, switcher)) {
			switcher.setAtualizadoEm(Calendar.getInstance().getTime());
			this.switchs.save(switcher);
		}
		return "redirect:/switchs";
	}
	
	@GetMapping("/remove")
	public String remover(Switcher switcher) {
		this.switchs.delete(switcher);
		return "redirect:/switchs";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Switcher switcherAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaSwitcher");
		modelAndView.addObject("switcherAntigo", switchs.findOne(switcherAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Switcher switcher) {
		switcher.setAtualizadoEm(Calendar.getInstance().getTime());
		this.switchs.save(switcher);
		return "redirect:/switchs";
	}
}
