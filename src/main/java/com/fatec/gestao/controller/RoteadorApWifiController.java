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
import com.fatec.gestao.model.RoteadorApWifi;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.repository.RoteadoresApWifi;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/roteadoresApWifi")
public class RoteadorApWifiController extends PatrimonioService{
	
	@Autowired
	private RoteadoresApWifi roteadoresApWifi;
	
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
		ModelAndView modelAndView = new ModelAndView("ListaRoteadoresApWifi");
		modelAndView.addObject("roteadoresApWifi",roteadoresApWifi.findAll());
		modelAndView.addObject(new RoteadorApWifi());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(RoteadorApWifi roteadorApWifi) {
		if(!patrimonioJaExistente(equipamentos, roteadorApWifi)) {
			roteadorApWifi.setAtualizadoEm(Calendar.getInstance().getTime());
			this.roteadoresApWifi.save(roteadorApWifi);
		}
		return "redirect:/roteadoresApWifi";
	}
	
	@GetMapping("/remove")
	public String remover(RoteadorApWifi roteadorApWifi) {
		this.roteadoresApWifi.delete(roteadorApWifi);
		return "redirect:/roteadoresApWifi";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(RoteadorApWifi roteadorApWifiAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaRoteadorApWifi");
		modelAndView.addObject("roteadorApWifiAntigo", roteadoresApWifi.findOne(roteadorApWifiAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(RoteadorApWifi roteadorApWifi) {
		roteadorApWifi.setAtualizadoEm(Calendar.getInstance().getTime());
		this.roteadoresApWifi.save(roteadorApWifi);
		return "redirect:/roteadoresApWifi";
	}
}
