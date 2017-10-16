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
import com.fatec.gestao.model.Roteador;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.repository.Roteadores;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/roteadores")
public class RoteadorController extends PatrimonioService{
	
	@Autowired
	private Roteadores roteadores;
	
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
		ModelAndView modelAndView = new ModelAndView("ListaRoteadores");
		modelAndView.addObject("roteadores",roteadores.findAll());
		modelAndView.addObject(new Roteador());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Roteador roteador) {
		if(!patrimonioJaExistente(equipamentos, roteador)) {
			roteador.setAtualizadoEm(Calendar.getInstance().getTime());
			this.roteadores.save(roteador);
		}
		return "redirect:/roteadores";
	}
	
	@GetMapping("/remove")
	public String remover(Roteador roteador) {
		this.roteadores.delete(roteador);
		return "redirect:/roteadores";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Roteador roteadorAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaRoteador");
		modelAndView.addObject("roteadorAntigo", roteadores.findOne(roteadorAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Roteador roteador) {
		roteador.setAtualizadoEm(Calendar.getInstance().getTime());
		this.roteadores.save(roteador);
		return "redirect:/roteadores";
	}
}
