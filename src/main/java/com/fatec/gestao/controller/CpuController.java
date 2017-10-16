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
import com.fatec.gestao.repository.Cpus;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/cpus")
public class CpuController extends PatrimonioService{
	
	@Autowired
	private Cpus cpus;
	
	@Autowired
	private	Departamentos localizacoes;
	
	@Autowired
	private Equipamentos equipamentos;
	
	@Autowired
	private Marcas marcas;
	
	@Autowired
	private Modelos modelos;
		
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaCpus");
		modelAndView.addObject("cpus",cpus.findAll());
		modelAndView.addObject(new Cpu());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Cpu cpu) {
		if(!patrimonioJaExistente(equipamentos, cpu)) {
			cpu.setAtualizadoEm(Calendar.getInstance().getTime());
			this.cpus.save(cpu);
		}
		return "redirect:/cpus";
	}
	
	@GetMapping("/remove")
	public String remover(Cpu cpu) {
		this.cpus.delete(cpu);
		return "redirect:/cpus";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Cpu cpuAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaCpu");
		modelAndView.addObject("cpuAntigo", cpus.findOne(cpuAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Cpu cpu) {
		cpu.setAtualizadoEm(Calendar.getInstance().getTime());
		this.cpus.save(cpu);
		return "redirect:/cpus";
	}
	
	

}
