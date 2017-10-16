package com.fatec.gestao.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Notebook extends Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private String usuario;
	private String contrato;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

}
