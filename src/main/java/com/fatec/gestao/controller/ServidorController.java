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
import com.fatec.gestao.model.Servidor;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.repository.Servidores;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/servidores")
public class ServidorController extends PatrimonioService{
	
	@Autowired
	private Servidores servidores;
	
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
		ModelAndView modelAndView = new ModelAndView("ListaServidores");
		modelAndView.addObject("servidores",servidores.findAll());
		modelAndView.addObject(new Servidor());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Servidor servidor) {
		if(!patrimonioJaExistente(equipamentos, servidor)) {
			servidor.setAtualizadoEm(Calendar.getInstance().getTime());
			this.servidores.save(servidor);
		}
		return "redirect:/servidores";
	}
	
	@GetMapping("/remove")
	public String remover(Servidor servidor) {
		this.servidores.delete(servidor);
		return "redirect:/servidores";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Servidor servidorAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaServidor");
		modelAndView.addObject("servidorAntigo", servidores.findOne(servidorAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Servidor servidor) {
		servidor.setAtualizadoEm(Calendar.getInstance().getTime());
		this.servidores.save(servidor);
		return "redirect:/servidores";
	}
}
