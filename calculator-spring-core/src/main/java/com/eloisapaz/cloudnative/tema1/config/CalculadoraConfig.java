package com.eloisapaz.cloudnative.tema1.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.eloisapaz.cloudnative.tema1.calculadora.Calculadora;
import com.eloisapaz.cloudnative.tema1.operacoes.Divisao;
import com.eloisapaz.cloudnative.tema1.operacoes.Multiplicacao;
import com.eloisapaz.cloudnative.tema1.operacoes.Potencia;
import com.eloisapaz.cloudnative.tema1.operacoes.Soma;
import com.eloisapaz.cloudnative.tema1.operacoes.Subtracao;

@Configuration
@ComponentScan(basePackages = "com.eloisapaz.cloudnative.tema1.config")

public class CalculadoraConfig {

	@Bean("+")
	@Scope("prototype")
	public Soma somar(Double primeiroNum, Double segundoNum) {
		return new Soma(primeiroNum, segundoNum);
	}
	
	@Bean("-")
	@Scope("prototype")
	public Subtracao subtrair(Double primeiroNum, Double segundoNum) {
		return new Subtracao(primeiroNum, segundoNum);
	}
	
	@Bean("/")
	@Scope("prototype")
	public Divisao dividir(Double primeiroNum, Double segundoNum) {
		return new Divisao(primeiroNum, segundoNum);
	}
	
	@Bean("*")
	@Scope("prototype")
	public Multiplicacao multiplicar(Double primeiroNum, Double segundoNum) {
		return new Multiplicacao(primeiroNum, segundoNum);
	}
	
	@Bean("^")
	@Scope("prototype")
	public Potencia calcularPotencia(Double primeiroNum, Double segundoNum) {
		return new Potencia(primeiroNum, segundoNum);
	}
	
	@Bean
	public Calculadora criarCalculadora(ApplicationContext ac) {
		return new Calculadora(ac);
	}
}