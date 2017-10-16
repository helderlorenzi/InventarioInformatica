package com.fatec.gestao.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class RoteadorApWifi extends Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeAp;
	private String enderecoMac;
	private String ipWan;
	private String mascara;
	private String gateway;
	private String dnsPrimario;
	private String dnsSecundario;
	private String ipLanAtual;
	private String ipLanAntigo;
	private String mascaraLan;
	private String gatewayLan;
	private String dnsPrimarioLan;
	private String dnsSecundarioLan;
	private String usuario;
	private String senha;
	private String rangeIpDispDhcp;
	private String ssid;
	private String senhaSsid;
	private String modoOperacao;
	private String canalWireless;
	private String leaseTime;

	public String getNomeAp() {
		return nomeAp;
	}

	public void setNomeAp(String nomeAp) {
		this.nomeAp = nomeAp;
	}

	public String getEnderecoMac() {
		return enderecoMac;
	}

	public void setEnderecoMac(String enderecoMac) {
		this.enderecoMac = enderecoMac;
	}

	public String getIpWan() {
		return ipWan;
	}

	public void setIpWan(String ipWan) {
		this.ipWan = ipWan;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getDnsPrimario() {
		return dnsPrimario;
	}

	public void setDnsPrimario(String dnsPrimario) {
		this.dnsPrimario = dnsPrimario;
	}

	public String getDnsSecundario() {
		return dnsSecundario;
	}

	public void setDnsSecundario(String dnsSecundario) {
		this.dnsSecundario = dnsSecundario;
	}

	public String getIpLanAtual() {
		return ipLanAtual;
	}

	public void setIpLanAtual(String ipLanAtual) {
		this.ipLanAtual = ipLanAtual;
	}

	public String getIpLanAntigo() {
		return ipLanAntigo;
	}

	public void setIpLanAntigo(String ipLanAntigo) {
		this.ipLanAntigo = ipLanAntigo;
	}

	public String getMascaraLan() {
		return mascaraLan;
	}

	public void setMascaraLan(String mascaraLan) {
		this.mascaraLan = mascaraLan;
	}

	public String getGatewayLan() {
		return gatewayLan;
	}

	public void setGatewayLan(String gatewayLan) {
		this.gatewayLan = gatewayLan;
	}

	public String getDnsPrimarioLan() {
		return dnsPrimarioLan;
	}

	public void setDnsPrimarioLan(String dnsPrimarioLan) {
		this.dnsPrimarioLan = dnsPrimarioLan;
	}

	public String getDnsSecundarioLan() {
		return dnsSecundarioLan;
	}

	public void setDnsSecundarioLan(String dnsSecundarioLan) {
		this.dnsSecundarioLan = dnsSecundarioLan;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRangeIpDispDhcp() {
		return rangeIpDispDhcp;
	}

	public void setRangeIpDispDhcp(String rangeIpDispDhcp) {
		this.rangeIpDispDhcp = rangeIpDispDhcp;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getSenhaSsid() {
		return senhaSsid;
	}

	public void setSenhaSsid(String senhaSsid) {
		this.senhaSsid = senhaSsid;
	}

	public String getModoOperacao() {
		return modoOperacao;
	}

	public void setModoOperacao(String modoOperacao) {
		this.modoOperacao = modoOperacao;
	}

	public String getCanalWireless() {
		return canalWireless;
	}

	public void setCanalWireless(String canalWireless) {
		this.canalWireless = canalWireless;
	}

	public String getLeaseTime() {
		return leaseTime;
	}

	public void setLeaseTime(String leaseTime) {
		this.leaseTime = leaseTime;
	}

}
