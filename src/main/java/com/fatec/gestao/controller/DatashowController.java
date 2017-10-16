
package com.fatec.gestao.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.gestao.model.Datashow;
import com.fatec.gestao.model.Departamento;
import com.fatec.gestao.model.Marca;
import com.fatec.gestao.model.Modelo;
import com.fatec.gestao.repository.Datashows;
import com.fatec.gestao.repository.Departamentos;
import com.fatec.gestao.repository.Equipamentos;
import com.fatec.gestao.repository.Marcas;
import com.fatec.gestao.repository.Modelos;
import com.fatec.gestao.service.PatrimonioService;

@Controller
@RequestMapping("/datashows")
public class DatashowController extends PatrimonioService{
	
	@Autowired
	private Datashows datashows;
	
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
		ModelAndView modelAndView = new ModelAndView("ListaDatashows");
		modelAndView.addObject("datashows",datashows.findAll());
		modelAndView.addObject(new Datashow());
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject(new Departamento());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject(new Marca());
		modelAndView.addObject("modelos",modelos.findAll());
		modelAndView.addObject(new Modelo());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Datashow datashow) {
		if(!patrimonioJaExistente(equipamentos, datashow)) {
			datashow.setAtualizadoEm(Calendar.getInstance().getTime());
			this.datashows.save(datashow);
		}
		return "redirect:/datashows";
	}
	
	@GetMapping("/remove")
	public String remover(Datashow datashow) {
		this.datashows.delete(datashow);
		return "redirect:/datashows";
	}
	
	@GetMapping("/populaForm")
	public ModelAndView populaForm(Datashow datashowAntigo) {
		ModelAndView modelAndView = new ModelAndView("EditaDatashow");
		modelAndView.addObject("datashowAntigo", datashows.findOne(datashowAntigo.getId()));
		modelAndView.addObject("localizacoes",localizacoes.findAll());
		modelAndView.addObject("marcas",marcas.findAll());
		modelAndView.addObject("modelos",modelos.findAll());
		return modelAndView;
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Datashow datashow) {
		datashow.setAtualizadoEm(Calendar.getInstance().getTime());
		this.datashows.save(datashow);
		return "redirect:/datashows";
	}
}
