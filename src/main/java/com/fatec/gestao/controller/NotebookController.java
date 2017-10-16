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
import com.fatec.gestao.model.Notebook;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.repository.Notebooks;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/notebooks")
public class NotebookController extends PatrimonioService{
	
	@Autowired
	private Notebooks notebooks;
	
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
		ModelAndView modelAndView = new ModelAndView("ListaNotebooks");
		modelAndView.addObject("notebooks",notebooks.findAll());
		modelAndView.addObject(new Notebook());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Notebook notebook) {
		if(!patrimonioJaExistente(equipamentos, notebook)) {
			notebook.setAtualizadoEm(Calendar.getInstance().getTime());
			this.notebooks.save(notebook);
		}
		return "redirect:/notebooks";
	}
	
	@GetMapping("/remove")
	public String remover(Notebook notebook) {
		this.notebooks.delete(notebook);
		return "redirect:/notebooks";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Notebook notebookAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaNotebook");
		modelAndView.addObject("notebookAntigo", notebooks.findOne(notebookAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Notebook notebook) {
		notebook.setAtualizadoEm(Calendar.getInstance().getTime());
		this.notebooks.save(notebook);
		return "redirect:/notebooks";
	}
}
