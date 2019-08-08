package com.eloisapaz.cloud.tema08.config;

import com.eloisapaz.cloud.tema08.calculadora.Calculadora;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.eloisapaz.cloud.tema08.operacoes.Divisao;
import com.eloisapaz.cloud.tema08.operacoes.Multiplicacao;
import com.eloisapaz.cloud.tema08.operacoes.Potencia;
import com.eloisapaz.cloud.tema08.operacoes.Soma;
import com.eloisapaz.cloud.tema08.operacoes.Subtracao;

@Configuration
@ComponentScan(basePackages = "com.eloisapaz.cloud.tema08.config")

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