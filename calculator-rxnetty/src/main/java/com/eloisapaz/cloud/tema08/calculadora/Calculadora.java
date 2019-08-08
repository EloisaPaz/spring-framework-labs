package com.eloisapaz.cloud.tema08.calculadora;

import java.util.LinkedList;
import java.util.List;

import com.eloisapaz.cloud.tema08.interfaces.Operacao;
import org.springframework.context.ApplicationContext;

public class Calculadora {
	
	private ApplicationContext applicationContext;

	private List<Operacao> resultados = new LinkedList<>();
	
	public Calculadora(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	public Double calcular(Double primeiroNumero, Double segundoNumero, String simbolo) {
		Operacao operacao = (Operacao) applicationContext.getBean(simbolo, primeiroNumero, segundoNumero);
		Double resultado = operacao.realizarOperacao();
		resultados.add(operacao);
		return resultado;
	}
	
	public List<Operacao> mostrarHistorico() {
		return resultados;
	}
}