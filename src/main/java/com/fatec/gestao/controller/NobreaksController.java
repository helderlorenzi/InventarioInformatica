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
import com.fatec.gestao.model.Nobreak;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.repository.NoBreaks;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/nobreaks")
public class NobreaksController extends PatrimonioService{
	
	@Autowired
	private NoBreaks nobreaks;
	
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
		ModelAndView modelAndView = new ModelAndView("ListaNobreaks");
		modelAndView.addObject("nobreaks",nobreaks.findAll());
		modelAndView.addObject(new Nobreak());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Nobreak nobreak) {
		if(!patrimonioJaExistente(equipamentos, nobreak)) {
			nobreak.setAtualizadoEm(Calendar.getInstance().getTime());
			this.nobreaks.save(nobreak);
		}
		return "redirect:/nobreaks";
	}
	
	@GetMapping("/remove")
	public String remover(Nobreak nobreak) {
		this.nobreaks.delete(nobreak);
		return "redirect:/nobreaks";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Nobreak nobreakAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaNobreak");
		modelAndView.addObject("nobreakAntigo", nobreaks.findOne(nobreakAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Nobreak nobreak) {
		nobreak.setAtualizadoEm(Calendar.getInstance().getTime());
		this.nobreaks.save(nobreak);
		return "redirect:/nobreaks";
	}
}
