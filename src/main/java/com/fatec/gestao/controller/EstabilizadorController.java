package com.fatec.gestao.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.gestao.model.Departamento;
import com.fatec.gestao.model.Estabilizador;
import com.fatec.gestao.model.Marca;
import com.fatec.gestao.model.Modelo;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Estabilizadores;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/estabilizadores")
public class EstabilizadorController extends PatrimonioService{
	
	@Autowired
	private Estabilizadores estabilizadores;
	
	@Autowired
	private Departamentos localizacoes;

	@Autowired Equipamentos equipamentos;

	@Autowired
	private Marcas marcas;
	
	@Autowired
	private Modelos modelos;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaEstabilizadores");
		modelAndView.addObject("estabilizadores", estabilizadores.findAll());
		modelAndView.addObject(new Estabilizador());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Estabilizador estabilizador) {
		if(!patrimonioJaExistente(equipamentos, estabilizador)) {
			estabilizador.setAtualizadoEm(Calendar.getInstance().getTime());
			this.estabilizadores.save(estabilizador);
		}
		return "redirect:/estabilizadores";
	}
	@GetMapping("/remove")
	public String remover(Estabilizador estabilizador) {
		this.estabilizadores.delete(estabilizador);
		return "redirect:/estabilizadores";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Estabilizador estabilizadorAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaEstabilizador");
		modelAndView.addObject("estabilizadorAntigo", estabilizadores.findOne(estabilizadorAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Estabilizador estabilizador) {
		estabilizador.setAtualizadoEm(Calendar.getInstance().getTime());
		this.estabilizadores.save(estabilizador);
		return "redirect:/estabilizadores";
	}
}
