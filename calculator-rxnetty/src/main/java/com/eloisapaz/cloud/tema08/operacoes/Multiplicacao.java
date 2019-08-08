package com.eloisapaz.cloud.tema08.operacoes;

import com.eloisapaz.cloud.tema08.interfaces.Operacao;

public class Multiplicacao implements Operacao {
	
	private Double primeiroNumero;
	private Double segundoNumero;
	
	public Multiplicacao(Double primeiroNumero, Double segundoNumero) {
		this.primeiroNumero = primeiroNumero;
		this.segundoNumero = segundoNumero;
	}

	@Override
	public Double realizarOperacao() {
		return primeiroNumero * segundoNumero;
	}	
	
	@Override
	public String toString() {
		return primeiroNumero + " / " + segundoNumero + " = " + realizarOperacao();
	}
}