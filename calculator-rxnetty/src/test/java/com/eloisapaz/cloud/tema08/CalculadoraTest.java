package com.eloisapaz.cloud.tema08;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.eloisapaz.cloud.tema08.calculadora.Calculadora;
import com.eloisapaz.cloud.tema08.interfaces.Operacao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.eloisapaz.cloud.tema08.config.CalculadoraConfig;

@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CalculadoraConfig.class})
public class CalculadoraTest {

	private ApplicationContext applicationContext;
	private Calculadora calculadora;
	
	@Before
	public void start() {
		applicationContext = new AnnotationConfigApplicationContext(CalculadoraConfig.class);
		calculadora = new Calculadora(applicationContext);
	}
	
	@Test
	public void testCalcularSoma() {
		Double resultado = calculadora.calcular(5.0, 5.0, "+");
		assertEquals(resultado, 10.0, 0.0);
	}


	@Test
	public void testCalcularSubtracao() {
		Double resultado = calculadora.calcular(10.0, 5.0, "-");
		assertEquals(resultado, 5.0, 0.0);
	}

	@Test
	public void testCalcularDivisao() {
		Double resultado = calculadora.calcular(10.0, 2.0, "/");
		assertEquals(resultado, 5.0, 0.0);
	}

	@Test
	public void testCalcularMultiplicacao() {
		Double resultado = calculadora.calcular(5.0, 2.0, "*");
		assertEquals(resultado, 10.0, 0.0);
	}

	@Test
	public void testCalcularPotencia() {
		Double resultado = calculadora.calcular(5.0, 2.0, "^");
		assertEquals(resultado, 25.0, 0.0);
	}

	@Test
	public void testMostarHistorico() {		
		calculadora.calcular(5.0, 5.0, "+");
		double resultado = 10.0;
		List<Operacao> historico = calculadora.mostrarHistorico();
		assertEquals(true, calculadora.mostrarHistorico().size() == 1);
		assertEquals(resultado, historico.get(0).realizarOperacao(), 0);
		
	}
}