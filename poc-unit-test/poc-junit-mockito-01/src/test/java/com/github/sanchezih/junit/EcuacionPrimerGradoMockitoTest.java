package com.github.sanchezih.junit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.github.sanchezih.junit.EcuacionPrimerGrado;
import com.github.sanchezih.junit.Parseador;

/**
 * Ahora, si solamente quisiéramos probar de forma unitaria el metodo
 * obtenerResultado de la clase EcuacionPrimerGrado debemos hacer uso de los
 * "dobles". Pensad en implementar estos dobles vosotros mismos sin hacer uso de
 * ningún framework. Seguramente ya estáis pensando en crear una interfaz para
 * la clase Parseador y crear métodos que permitan hacer la sustitución por un
 * objeto fake...vamos, que se complica un poco.
 * 
 * Pues para esto podemos hacer uso de Mockito. Con @InjectMocks establecemos el
 * objeto sobre el cual se realizará la inyección de los objetos marcados
 * con @Mock, es necesario inicializar estos mocks con
 * MockitoAnnotations.initMocks(this); en un método de inicialización
 * con @Before. Para establecer comportamientos del mock Parseador se utiliza
 * when, antes de realizar la ejecución del test. A continuación podéis ver el
 * ejemplo:
 * 
 * @author ihsanch
 *
 */
public class EcuacionPrimerGradoMockitoTest {

	@InjectMocks
	private EcuacionPrimerGrado ecuacionPrimerGrado;

	@Mock
	private Parseador parseador;

	@Before
	public void inicializaMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void solucionaEcuacionConMenos() {
		String ecuacion = "2x - 1 = 0";

		when(parseador.obtenerParte1(ecuacion)).thenReturn(2);
		when(parseador.obtenerParte2(ecuacion)).thenReturn(-1);
		when(parseador.obtenerParte3(ecuacion)).thenReturn(0);

		Double result = ecuacionPrimerGrado.obtenerResultado(ecuacion);

		Double valueExpected = 0.5;

		assertEquals(valueExpected, result);
	}

	@Test
	public void solucionaEcuacionConMas() {

		String ecuacion = "2x + 1 = 0";

		when(parseador.obtenerParte1(ecuacion)).thenReturn(2);
		when(parseador.obtenerParte2(ecuacion)).thenReturn(1);
		when(parseador.obtenerParte3(ecuacion)).thenReturn(0);

		Double result = ecuacionPrimerGrado.obtenerResultado(ecuacion);

		Double valueExpected = -0.5;

		assertEquals(valueExpected, result);
	}
}
