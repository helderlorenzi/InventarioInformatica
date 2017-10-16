package com.fatec.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.gestao.model.LocalizacaoSprite;
import com.fatec.gestao.repository.LocalizacoesSprites;

@Controller
@RequestMapping("/localizacoesSprites")
public class LocalizacaoSpriteController {
	@Autowired
	private LocalizacoesSprites localizacoesSprites;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaLocalizacoes");
		modelAndView.addObject("localizacoesSprites", localizacoesSprites.findAll());
		modelAndView.addObject(new LocalizacaoSprite());
		return modelAndView;
	}

	@PostMapping
	public String salvar(LocalizacaoSprite localizacaoSprite) {
		this.localizacoesSprites.save(localizacaoSprite);
		return "redirect:/localizacoesSprites";
	}
}
