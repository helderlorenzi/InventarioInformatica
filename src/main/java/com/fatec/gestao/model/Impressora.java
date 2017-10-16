package com.fatec.gestao.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Impressora extends Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigoOuNome;
	private String numIpOuCompCompart;
	private String modeloCartuchoOuTonner;

	public String getCodigoOuNome() {
		return codigoOuNome;
	}

	public void setCodigoOuNome(String codigoOuNome) {
		this.codigoOuNome = codigoOuNome;
	}

	public String getNumIpOuCompCompart() {
		return numIpOuCompCompart;
	}

	public void setNumIpOuCompCompart(String numIpOuCompCompart) {
		this.numIpOuCompCompart = numIpOuCompCompart;
	}

	public String getModeloCartuchoOuTonner() {
		return modeloCartuchoOuTonner;
	}

	public void setModeloCartuchoOuTonner(String modeloCartuchoOuTonner) {
		this.modeloCartuchoOuTonner = modeloCartuchoOuTonner;
	}

}
