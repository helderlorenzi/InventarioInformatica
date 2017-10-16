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
import com.fatec.gestao.model.Modem;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.repository.Modens;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/modems")
public class ModemController extends PatrimonioService{
	
	@Autowired
	private Modens modems;
	
	@Autowired
	private Departamentos localizacoes;

	@Autowired Equipamentos equipamentos;
	
	@Autowired
	private Marcas marcas;
	
	@Autowired
	private Modelos modelos;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaModems");
		modelAndView.addObject("modems", modems.findAll());
		modelAndView.addObject(new Modem());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Modem modem) {
		if(!patrimonioJaExistente(equipamentos, modem)) {
			modem.setAtualizadoEm(Calendar.getInstance().getTime());
			this.modems.save(modem);
		}
		return "redirect:/modems";
	}
	
	@GetMapping("/remove")
	public String remover(Modem modem) {
		this.modems.delete(modem);
		return "redirect:/modems";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Cpu modemAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaModem");
		modelAndView.addObject("modemAntigo", modems.findOne(modemAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Modem modem) {
		modem.setAtualizadoEm(Calendar.getInstance().getTime());
		this.modems.save(modem);
		return "redirect:/modems";
	}
}
