package com.fatec.gestao.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.gestao.model.Departamento;
import com.fatec.gestao.model.Impressora;
import com.fatec.gestao.model.Marca;
import com.fatec.gestao.model.Modelo;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Impressoras;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/impressoras")
public class ImpressoraController extends PatrimonioService{
	
	@Autowired
	private Impressoras impressoras;

	@Autowired
	private Departamentos localizacoes;
	
	@Autowired Equipamentos equipamentos;
	
	@Autowired
	private Marcas marcas;
	
	@Autowired
	private Modelos modelos;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaImpressoras");
		modelAndView.addObject("impressoras", impressoras.findAll());
		modelAndView.addObject(new Impressora());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}

	@PostMapping
	public String salvar(Impressora impressora) {
		if(!patrimonioJaExistente(equipamentos, impressora)) {
			impressora.setAtualizadoEm(Calendar.getInstance().getTime());
			this.impressoras.save(impressora);
		}
		return "redirect:/impressoras";
	}
	
	@GetMapping("/remove")
	public String remover(Impressora impressora) {
		this.impressoras.delete(impressora);
		return "redirect:/impressoras";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Impressora impressoraAntiga) {
		ModelAndView modelAndView = new ModelAndView("EditaImpressora");
		modelAndView.addObject("impressoraAntiga", impressoras.findOne(impressoraAntiga.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Impressora impressora) {
		impressora.setAtualizadoEm(Calendar.getInstance().getTime());
		this.impressoras.save(impressora);
		return "redirect:/impressoras";
	}
	
	
}
