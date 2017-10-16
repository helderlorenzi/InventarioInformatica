package com.fatec.gestao.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.gestao.model.Cpu;
import com.fatec.gestao.model.Departamento;
import com.fatec.gestao.model.Marca;
import com.fatec.gestao.model.Modelo;
import com.fatec.gestao.model.Monitor;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.repository.Monitores;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/monitores")
public class MonitorController extends PatrimonioService{
	
	@Autowired
	private Monitores monitores;
	
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
		ModelAndView modelAndView = new ModelAndView("ListaMonitores");
		modelAndView.addObject("monitores",monitores.findAll());
		modelAndView.addObject(new Monitor());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Monitor monitor) {
		if(!patrimonioJaExistente(equipamentos, monitor)) {
			monitor.setAtualizadoEm(Calendar.getInstance().getTime());
			this.monitores.save(monitor);
		}
		return "redirect:/monitores";
	}
	
	@GetMapping("/remove")
	public String remover(Monitor monitor) {
		this.monitores.delete(monitor);
		return "redirect:/monitores";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Cpu monitorAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaMonitor");
		modelAndView.addObject("monitorAntigo", monitores.findOne(monitorAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Monitor monitor) {
		monitor.setAtualizadoEm(Calendar.getInstance().getTime());
		this.monitores.save(monitor);
		return "redirect:/monitores";	}
}
