package com.fatec.gestao.service;

import org.springframework.data.domain.Example;

import com.fatec.gestao.model.Equipamento;
import com.fatec.gestao.repository.Equipamentos;

public class PatrimonioService {
	
	public boolean patrimonioJaExistente(Equipamentos equipamentos, Equipamento equipamento) {
		Equipamento e = new Equipamento();
		e.setPatrimonio(equipamento.getPatrimonio());
		Example<Equipamento> example = Example.of(e);
		return equipamentos.exists(example);
	}
	
}
