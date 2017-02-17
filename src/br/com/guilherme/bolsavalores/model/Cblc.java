package br.com.guilherme.bolsavalores.model;

import java.util.Calendar;

public class Cblc {
	
	private Calendar data;
	private int numeroContratos;
	private int qtdAcoes;
	private double valor;
	private double doador;
	private	double tomador;
	private double cotacaoMedia;
	private double taxaMediaTresDias;
	private double posicaoEmAberto;
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public int getNumeroContratos() {
		return numeroContratos;
	}
	
	public void setNumeroContratos(int numeroContratos) {
		this.numeroContratos = numeroContratos;
	}
	
	public int getQtdAcoes() {
		return qtdAcoes;
	}
	
	public void setQtdAcoes(int qtdAcoes) {
		this.qtdAcoes = qtdAcoes;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getDoador() {
		return doador;
	}
	
	public void setDoador(double doador) {
		this.doador = doador;
	}
	
	public double getTomador() {
		return tomador;
	}
	
	public void setTomador(double tomador) {
		this.tomador = tomador;
	}
	
	public double getCotacaoMedia() {
		return cotacaoMedia;
	}
	
	public void setCotacaoMedia(double cotacaoMedia) {
		this.cotacaoMedia = cotacaoMedia;
	}
	
	public double getTaxaMediaTresDias() {
		return taxaMediaTresDias;
	}
	
	public void setTaxaMediaTresDias(double taxaMediaTresDias) {
		this.taxaMediaTresDias = taxaMediaTresDias;
	}
	
	public double getPosicaoEmAberto() {
		return posicaoEmAberto;
	}
	
	public void setPosicaoEmAberto(double posicaoEmAberto) {
		this.posicaoEmAberto = posicaoEmAberto;
	}

}
