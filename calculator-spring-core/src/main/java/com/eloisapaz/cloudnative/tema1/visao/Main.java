package com.eloisapaz.cloudnative.tema1.visao;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eloisapaz.cloudnative.tema1.calculadora.Calculadora;
import com.eloisapaz.cloudnative.tema1.config.CalculadoraConfig;

public class Main {
	private static ApplicationContext ac;
	private static Calculadora calculadora;
	public static void main(String[] args) {
		gerarMenu();
	}
	
	public static void gerarMenu() {
		ac = new AnnotationConfigApplicationContext(CalculadoraConfig.class);
		calculadora = (Calculadora) ac.getBean("criarCalculadora");
		Scanner scan = new Scanner(System.in);
		int menu;
		printarMenu();
		menu = scan.nextInt();
		
		try {
			switch(menu) {
			case 1:
				calcularSoma();
			break;
			
			case 2:
				calcularSubtracao();
			break;
			
			case 3:
				calcularDivisao();
			break;
			
			case 4:
				calcularMultiplicacao();
			break;
			
			case 5:
				calcularPotencia();
			break;
			
			case 6:
				System.out.println(calculadora.mostrarHistorico());
			}
		}catch (Exception e) {
			System.out.println("Opção inválida! Favor escolher uma opção válida:");
			gerarMenu();
		}
		((AnnotationConfigApplicationContext)ac).close();
		scan.close();
	}
	
	public static void voltarMenu() {
		Scanner scan = new Scanner(System.in);
		int opcao;
		System.out.println("Deseja fazer voltar ao menu?");
		System.out.println("1 - SIM");
		System.out.println("2 - NÃO");
		opcao = scan.nextInt();
		if (opcao == 1) {
			gerarMenu();
		} else {
			System.exit(0);
		}
		scan.close();
	}
	
	public static void printarMenu() {
		System.out.println("***** Bem vindo a calculadora *****");
		System.out.println("Insira a opção escolhida:");
		System.out.println("1 - Somar");
		System.out.println("2 - Subtrair");
		System.out.println("3 - Dividir");
		System.out.println("4 - Multiplicar");
		System.out.println("5 - Potencia");
		System.out.println("6 - Exibir resultados");
		System.out.println("0 - Sair");
	}
	
	public static void calcularSoma() {
		Scanner scan = new Scanner(System.in);
		Double primeiroNum = 0.0;
		Double segundoNum = 0.0;
		System.out.println("Insira o primeiro número:");
		primeiroNum = scan.nextDouble();
		System.out.println("Insira o segundo número:");
		segundoNum = scan.nextDouble();
		System.out.println(calculadora.calcular(primeiroNum, segundoNum, "+"));
		voltarMenu();
	}
	
	public static void calcularSubtracao() {
		Scanner scan = new Scanner(System.in);
		Double primeiroNum = 0.0;
		Double segundoNum = 0.0;
		System.out.println("Insira o primeiro número:");
		primeiroNum = scan.nextDouble();
		System.out.println("Insira o segundo número:");
		segundoNum = scan.nextDouble();
		System.out.println(calculadora.calcular(primeiroNum, segundoNum, "-"));
		voltarMenu();
	}
	
	public static void calcularDivisao() {
		Scanner scan = new Scanner(System.in);
		Double primeiroNum = 0.0;
		Double segundoNum = 0.0;
		try {
			System.out.println("Insira o primeiro número:");
			primeiroNum = scan.nextDouble();
			System.out.println("Insira o segundo número:");
			segundoNum = scan.nextDouble();
			System.out.println(calculadora.calcular(primeiroNum, segundoNum, "/"));
			voltarMenu();
		}catch (InputMismatchException e) {
			if(segundoNum == 0) {
				System.out.println("Primeiro número não pode ser divido por 0! Insira um número válido!");
				segundoNum = scan.nextDouble();
				System.out.println(calculadora.calcular(primeiroNum, segundoNum, "/"));
				voltarMenu();
			}
		}
	}
	
	public static void calcularMultiplicacao() {
		Scanner scan = new Scanner(System.in);
		Double primeiroNum = 0.0;
		Double segundoNum = 0.0;
		System.out.println("Insira o primeiro número:");
		primeiroNum = scan.nextDouble();
		System.out.println("Insira o segundo número:");
		segundoNum = scan.nextDouble();
		System.out.println(calculadora.calcular(primeiroNum, segundoNum, "*"));
		voltarMenu();
	}
	
	public static void calcularPotencia() {
		Scanner scan = new Scanner(System.in);
		Double primeiroNum = 0.0;
		Double segundoNum = 0.0;
		System.out.println("Insira o primeiro número:");
		primeiroNum = scan.nextDouble();
		System.out.println("Insira o segundo número:");
		segundoNum = scan.nextDouble();
		System.out.println(calculadora.calcular(primeiroNum, segundoNum, "^"));
		voltarMenu();
	}
}
