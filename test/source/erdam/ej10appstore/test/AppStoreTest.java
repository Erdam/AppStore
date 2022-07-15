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
	 * Clase d�nde se har� la prueba.
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
	//--------- M � T O D O S  D E  P R U E B A ----------//
	/**
     * Prueba 1: Verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
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
		assertNotNull( "Al crear el juego 1, este deber�a ser v�lido.",appStore.getJuego1()); 
		assertNotNull( "Al crear el juego 2, este deber�a ser v�lido.",appStore.getJuego2()); 
		assertNotNull( "Al crear el juego 3, este deber�a ser v�lido.",appStore.getJuego3()); 
		assertNotNull( "Al crear el juego 4, este deber�a ser v�lido.",appStore.getJuego4()); 
	}

	//---------------------------------------------------//
	/**
     * Prueba 2: Verifica el m�todo buscarJuego<br>
     * <b> M�todos a probar: </b> <br>
     * buscarJuego<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego existe.<br>
     * 2. El juego no existe.<br>
     */
	@Test
	public void testBuscarJuego()
	{
		setupEscenario();
		assertNotNull("Deber�a existir el juego.", appStore.buscarJuego("Candy Crush"));
		assertNull("Deber�a no existir el juego.", appStore.buscarJuego("Street fighter"));
	
	}
	//---------------------------------------------------//
    /**
     * Prueba 3: Verifica el m�todo comprarLicencia<br>
     * <b> M�todos a probar: </b> <br>
     * getJuego1<br>
     * comprarLicencia<br>
     * <b> M�todos a probar: </b> <br>
     * 1. Aumenta la cantidad de licencias del juego.<br>
     */
	@Test
	public void testComprarLicencia()
	{
		setupEscenario();
		assertEquals("Deber�a haber 50 licencias",appStore.getJuego1().getLicenciaDisponible(),50);
		appStore.comprarLicencia("Candy Crush", 10);
		assertEquals("Deber�a haber 60 licencias",appStore.getJuego1().getLicenciaDisponible(),60);
	}
	//---------------------------------------------------//
	/**
     * Prueba 4: Verifica el m�todo venderLicencia<br>
     * <b> M�todos a probar: </b> <br>
     * venderLicencia<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El juego no existe, la venta no se realiza.<br>
     * 2. El juego existe pero la cantidad a vender es mayor a la actual y la venta no se realiza.<br>
     * 3. El juego existe y la venta se realiza.<br>
     */
	public void testVenderLicencia()
	{
		setupEscenario();
		assertFalse("El juego no existe y no deber�a realiza la venta. ",appStore.venderLicencia("Street fighter", 10));
		 assertFalse( "El juego no tiene suficientes licencias para realizar la venta.", appStore.venderLicencia( "Candy Crush", 80 ) );
		 assertTrue("El juego tiene suficientes licencias para realizar la venta.",appStore.venderLicencia( "Candy Crush", 50 ));
	}
	//---------------------------------------------------//
	  /**
     * Prueba 5: Verifica el m�todo masVendidos<br>
     * <b> M�todos a probar: </b> <br>
     * masVendidos <br>
     * <b> Casos de estudio: </b> <br>
     * 1. Ning�n juego tiene ventas.<br>
     * 2. Hay un juego con m�s ventas que los dem�s.<br>
     */
	 @Test
	    public void testObtenerJuegoMasVendido( )
	    {
	        setupEscenario();
	        assertEquals( "El juego m�s vendido deber�a ser ninguno", "Ninguno", appStore.masVendidos() );
	        appStore.venderLicencia( "Candy Crush", 10 );
	        assertEquals( "El juego m�s vendido deber�a ser el segundo", "Candy Crush", appStore.masVendidos() );
	    }


	//---------------------------------------------------//


}
