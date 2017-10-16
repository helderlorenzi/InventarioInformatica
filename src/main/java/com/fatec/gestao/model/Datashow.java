package com.fatec.gestao.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Datashow extends Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricaoDaSala;
	private String controleRemoto;

	public String getDescricaoDaSala() {
		return descricaoDaSala;
	}

	public void setDescricaoDaSala(String descricaoDaSala) {
		this.descricaoDaSala = descricaoDaSala;
	}

	public String getControleRemoto() {
		return controleRemoto;
	}

	public void setControleRemoto(String controleRemoto) {
		this.controleRemoto = controleRemoto;
	}

}
