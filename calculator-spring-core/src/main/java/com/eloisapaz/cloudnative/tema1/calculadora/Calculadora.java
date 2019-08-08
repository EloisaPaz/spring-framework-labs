package com.eloisapaz.cloudnative.tema1.calculadora;

import java.util.LinkedList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import com.eloisapaz.cloudnative.tema1.interfaces.Operacao;

public class Calculadora {
	
	private ApplicationContext ac;

	private List<Operacao> resultados = new LinkedList<>();
	
	public Calculadora(ApplicationContext ac) {
		this.ac = ac;
	}
	
	public Double calcular(Double primeiroNumero, Double segundoNumero, String simbolo) {
		Operacao operacao = (Operacao) ac.getBean(simbolo, primeiroNumero, segundoNumero);
		Double resultado = operacao.realizarOperacao();
		resultados.add(operacao);
		return resultado;
	}
	
	public List<Operacao> mostrarHistorico() {
		return resultados;
	}
}