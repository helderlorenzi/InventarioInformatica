package com.fatec.gestao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cpu extends Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private String usuario;
	private String nome;
	private String contrato;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ultimaLimpeza;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ultimaFormatacao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ultimaTrocaBateria;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public Date getUltimaLimpeza() {
		return ultimaLimpeza;
	}

	public void setUltimaLimpeza(Date ultimaLimpeza) {
		this.ultimaLimpeza = ultimaLimpeza;
	}

	public Date getUltimaFormatacao() {
		return ultimaFormatacao;
	}

	public void setUltimaFormatacao(Date ultimaFormatacao) {
		this.ultimaFormatacao = ultimaFormatacao;
	}

	public Date getUltimaTrocaBateria() {
		return ultimaTrocaBateria;
	}

	public void setUltimaTrocaBateria(Date ultimaTrocaBateria) {
		this.ultimaTrocaBateria = ultimaTrocaBateria;
	}

}
