package com.eloisapaz.caixaeletronico;

import com.eloisapaz.caixaeletronico.exception.SaqueException;
import com.eloisapaz.caixaeletronico.service.SaqueService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaqueTest {

	private SaqueService saqueService;

	@Before
	public void setup() {
		saqueService = new SaqueService();
	}

		@Test
	public void getSaque() {
		assertEquals("1 de R$: 20; 1 de R$: 10; " , saqueService.getSaque(30));
		assertEquals("1 de R$: 100; 1 de R$: 20; 1 de R$: 10; ", saqueService.getSaque(130));
		assertEquals("1 de R$: 50; 2 de R$: 20; ", saqueService.getSaque(90));
		assertEquals("5 de R$: 100; 1 de R$: 50; 2 de R$: 20; ", saqueService.getSaque(590));
		assertEquals("10 de R$: 100; ", saqueService.getSaque(1000));
	}

	@Test(expected = SaqueException.class)
	public void getSaqueNumero0() {
		saqueService.getSaque(0);
	}

	@Test(expected = SaqueException.class)
	public void getSaqueNumeroNegativo() {
		saqueService.getSaque(-5);
	}
}