package com.fatec.gestao.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Roteador extends Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private String usuario;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
