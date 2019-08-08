package com.eloisapaz.cloudnative.tema1.operacoes;

import com.eloisapaz.cloudnative.tema1.interfaces.Operacao;

public class Divisao implements Operacao{
	
	private Double primeiroNumero;
	private Double segundoNumero;
	
	public Divisao(Double primeiroNumero, Double segundoNumero) {
		this.primeiroNumero = primeiroNumero;
		this.segundoNumero = segundoNumero;
	}

	@Override
	public Double realizarOperacao() throws IllegalArgumentException{
		if(segundoNumero == 0) {
			throw new IllegalArgumentException("Primeiro número não pode ser divido por 0!");
		}
		return (primeiroNumero / segundoNumero);
	}

	@Override
	public String toString() {
		return primeiroNumero + " / " + segundoNumero + " = " + realizarOperacao();
	}
}