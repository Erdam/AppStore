package erdam.ej10appstore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import erdam.ej10appstore.mundo.AppStore;

public class AppStoreTest {
	//------- A T R I B U T O S -------//
	/**
	 * Clase dónde se hará la prueba.
	 */
	private AppStore appStore;
	//--------- E S C E N A R I O S ----------//
    /**
     * Construye una nueva AppStore con 4 juegos.
     */
	private void setupEscenario()
	{
		appStore = new AppStore();
	}
	//--------- M É T O D O S  D E  P R U E B A ----------//
	/**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * AppStore<br>
     * getJuego1<br>
     * getJuego2<br>
     * getJuego3<br>
     * getJuego4<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se crearon los 4 juegos en la appstore.
     */
	@Test
	public void testAppStore()
	{
		setupEscenario();
		assertNotNull( "Al crear el juego 1, este debería ser válido.",appStore.getJuego1()); 
		assertNotNull( "Al crear el juego 2, este debería ser válido.",appStore.getJuego2()); 
		assertNotNull( "Al crear el juego 3, este debería ser válido.",appStore.getJuego3()); 
		assertNotNull( "Al crear el juego 4, este debería ser válido.",appStore.getJuego4()); 
	}

	//---------------------------------------------------//
	/**
     * Prueba 2: Verifica el método buscarJuego<br>
     * <b> Métodos a probar: </b> <br>
     * buscarJuego<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego existe.<br>
     * 2. El juego no existe.<br>
     */
	@Test
	public void testBuscarJuego()
	{
		setupEscenario();
		assertNotNull("Debería existir el juego.", appStore.buscarJuego("Candy Crush"));
		assertNull("Debería no existir el juego.", appStore.buscarJuego("Street fighter"));
	
	}
	//---------------------------------------------------//
    /**
     * Prueba 3: Verifica el método comprarLicencia<br>
     * <b> Métodos a probar: </b> <br>
     * getJuego1<br>
     * comprarLicencia<br>
     * <b> Métodos a probar: </b> <br>
     * 1. Aumenta la cantidad de licencias del juego.<br>
     */
	@Test
	public void testComprarLicencia()
	{
		setupEscenario();
		assertEquals("Debería haber 50 licencias",appStore.getJuego1().getLicenciaDisponible(),50);
		appStore.comprarLicencia("Candy Crush", 10);
		assertEquals("Debería haber 60 licencias",appStore.getJuego1().getLicenciaDisponible(),60);
	}
	//---------------------------------------------------//
	/**
     * Prueba 4: Verifica el método venderLicencia<br>
     * <b> Métodos a probar: </b> <br>
     * venderLicencia<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El juego no existe, la venta no se realiza.<br>
     * 2. El juego existe pero la cantidad a vender es mayor a la actual y la venta no se realiza.<br>
     * 3. El juego existe y la venta se realiza.<br>
     */
	public void testVenderLicencia()
	{
		setupEscenario();
		assertFalse("El juego no existe y no debería realiza la venta. ",appStore.venderLicencia("Street fighter", 10));
		 assertFalse( "El juego no tiene suficientes licencias para realizar la venta.", appStore.venderLicencia( "Candy Crush", 80 ) );
		 assertTrue("El juego tiene suficientes licencias para realizar la venta.",appStore.venderLicencia( "Candy Crush", 50 ));
	}
	//---------------------------------------------------//
	  /**
     * Prueba 5: Verifica el método masVendidos<br>
     * <b> Métodos a probar: </b> <br>
     * masVendidos <br>
     * <b> Casos de estudio: </b> <br>
     * 1. Ningún juego tiene ventas.<br>
     * 2. Hay un juego con más ventas que los demás.<br>
     */
	 @Test
	    public void testObtenerJuegoMasVendido( )
	    {
	        setupEscenario();
	        assertEquals( "El juego más vendido debería ser ninguno", "Ninguno", appStore.masVendidos() );
	        appStore.venderLicencia( "Candy Crush", 10 );
	        assertEquals( "El juego más vendido debería ser el segundo", "Candy Crush", appStore.masVendidos() );
	    }


	//---------------------------------------------------//


}
