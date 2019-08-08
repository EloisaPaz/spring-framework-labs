package com.eloisapaz.cloudnative.tema1.operacoes;

import com.eloisapaz.cloudnative.tema1.interfaces.Operacao;

public class Subtracao implements Operacao{
	
	private Double primeiroNumero;
	private Double segundoNumero;
	
	public Subtracao(Double primeiroNumero, Double segundoNumero) {
		this.primeiroNumero = primeiroNumero;
		this.segundoNumero = segundoNumero;
	}

	@Override
	public Double realizarOperacao() {
		return primeiroNumero - segundoNumero;
	}
	
	@Override
	public String toString() {
		return primeiroNumero + " / " + segundoNumero + " = " + realizarOperacao();
	}
}