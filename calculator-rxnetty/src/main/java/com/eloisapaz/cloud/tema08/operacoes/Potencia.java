package com.eloisapaz.cloud.tema08.operacoes;

import com.eloisapaz.cloud.tema08.interfaces.Operacao;

public class Potencia implements Operacao {
	
	private Double primeiroNumero;
	private Double segundoNumero;
	
	public Potencia(Double primeiroNumero, Double segundoNumero){
		this.primeiroNumero = primeiroNumero;
		this.segundoNumero = segundoNumero;
	}

	@Override
	public Double realizarOperacao() {
		return Math.pow(primeiroNumero, segundoNumero);
	}
	
	@Override
	public String toString() {
		return primeiroNumero + " / " + segundoNumero + " = " + realizarOperacao();
	}
}