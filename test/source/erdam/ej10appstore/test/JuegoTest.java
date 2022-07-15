package erdam.ej10appstore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import erdam.ej10appstore.mundo.Categoria;
import erdam.ej10appstore.mundo.Juego;

public class JuegoTest {
	//------- A T R I B U T O S -------//
	/**
	 * Clase dónde se hará la prueba.
	 */
	private Juego juego;
	
	
	//--------- E S C E N A R I O S ----------//
	private void setupEscenario()
	{
		juego = new Juego("Juego", Categoria.ACCION, 35000, 2000, 45, "juego.jpg"); 
	}
	
	//--------- M É T O D O S  D E  P R U E B A ----------//
    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * Juego<br>
     * getCategoria<br>
     * getNombre<br>
     * getLicenciaDisponible<br>
     * getLicenciaVendida<br>
     * getTamanio<br>
     * getPrecio<br>
     * getImgJuego <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
	@Test
	public void testJego()
	{
		setupEscenario();
		assertTrue("Categoría no iniciada correctamente.",juego.getCategoria()==Categoria.ACCION);
		assertEquals("Nombre no iniciado correctamente.","Juego", juego.getNombre());
		assertEquals("Las licencias disponibles no se iniciarón correctamente.", 45,juego.getLicenciaDisponible());
		assertEquals("Licencias vendidas no se inició correctamente.", juego.getLicenciaVendida(), 0);
		assertEquals("EL tamaño no fue iniciado correctamente.", juego.getTamanio(), 35000);
		assertEquals("El precio no fue iniciado correctamente.", juego.getPrecio(), 2000, 0.1);
		assertEquals("La ruta de imagen no fue iniciada correctamente",juego.getImgJuego(),"juego.jpg");
		
	}
	//---------------------------------------------------//
	/**
     * Prueba 2 : Verifica el método comprarLicencias.<br>
     * <b> Métodos a probar: </b> <br>
     * comprarLicencia<br>
     * getLicenciaDisponible<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Aumenta correctamente la cantidad de licencias.<br>
     */
	@Test
	public void testComprarLicencia()
	{
		setupEscenario();
		juego.comprarLicencia(5);
		assertEquals("Las cantidad de licencia no coincide. .", 50,juego.getLicenciaDisponible());
	}
	//---------------------------------------------------//
	/**
     * Prueba 3: Verifica el método venderLicencias<br>
     * <b> Métodos a probar: </b> <br>
     * venderLicencia<br>
     * getLicenciaDisponible<br>
     * getLicenciaVendidas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se modifican correctamente la cantidad de licencias actual y vendidas <br>
     */
	@Test
	public void testVenderLicencia()
	{
		setupEscenario();
		assertTrue("Debería haber permitido vender licencias",juego.venderLicencia(10));
		assertEquals("Las cantidad de licencia disponibles no coincide. .", 35,juego.getLicenciaDisponible());
		assertEquals("Las cantidad de licencia vendidas no coincide. .", 10,juego.getLicenciaVendida());
		assertTrue("Debería haber permitido vender licencias",juego.venderLicencia(35));
		assertEquals("Las cantidad de licencia disponibles no coincide. .", 0,juego.getLicenciaDisponible());
		assertEquals("Las cantidad de licencia vendidas no coincide. .", 45,juego.getLicenciaVendida());
		assertFalse("Debería no haber permitido vender licencias",juego.venderLicencia(1));
		
	}
	//---------------------------------------------------//

}
