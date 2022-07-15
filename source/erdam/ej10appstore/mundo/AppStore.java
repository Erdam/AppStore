package erdam.ej10appstore.mundo;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Tienda virtual del juego
 */
public class AppStore {
	// ------- C O N S T A N T E S -------//
	/**
	 * Representa la cnatidad mínima de licencia de juego de rompecabeza.
	 */
	private final static int CANT_MIN_ROMPECABEZA	 	= 25;
	/**
	 * Representa la cnatidad mínima de licencia de juego de deporte.
	 */
	private final static int CANT_MIN_DEPORTE  		 	= 20;
	/**
	 * Representa la cnatidad mínima de licencia de juego de acción.
	 */
	private final static int CANT_MIN_ACCION			= 15;
	/**
	 * Representa el descuento del 20%.
	 */
	private final static double DESCUENTO_1         	= 0.20;
	/**
	 * Representa el descuento del 15%.
	 */
	private final static double DESCUENTO_2         	= 0.15;

	//------- A T R I B U T O S -------//
	/**
	 * Juego uno de la AppStore.
	 */
     private Juego juego1;
	/**
	 * Juego dos de la AppStore.
	 */
	private Juego juego2;
	/**
	 * Juego tres de la AppStore.
	 */
	private Juego juego3;
	/**
	 * Juego cuatro de la AppStore.
	 */
	private Juego juego4;
	
	//----- C O N S T R U C T O R  -----//

    /**
     * Crea la AppStore con sus 4 juegos. <br>
     * <b>post: </b> Los juegos fueron inicializados con los siguientes valores: <br>
     * Juego1 - Nombre: Candy Crush, Categoría: Rompecabezas, Precio: 3000, Tamaño (en KB): 300, Cantidad de licencias: 50, Imagen: CandyCrush.jpg. <br>
     * Juego2 - Nombre: Flow, Categoría: Rompecabezas, Precio: 5500, Tamaño (en KB): 250, Cantidad de licencias: 15, Imagen: Flow.jpg. <br>
     * Juego3 - Nombre: FIFA, Categoría: Deporte, Precio: 7500, Tamaño (en KB): 850, Cantidad de licencias: 80, Imagen: FIFA.jpg. <br>
     * Juego4 - Nombre: Clash of Clans, Categoría: Acción, Precio: 2000, Tamaño (en KB): 1000, Cantidad de licencias: 36, Imagen: ClashOfClans.jpg. <br>
     */
	public AppStore()
	{
		juego1 = new Juego("Candy Crush", Categoria.ROMPECABEZA, 300, 3000 ,50,"data/imagenes/CandyCrush.jpg");
		juego2 = new Juego("Flow", Categoria.ROMPECABEZA, 250, 5500 ,15,"data/imagenes/flow.jpg");
		juego3 = new Juego("FIFA", Categoria.DEPORTE, 850, 7500 ,80,"data/imagenes/FIFA.jpg");
		juego4 = new Juego("clash of clans", Categoria.ACCION, 1000, 2000 ,36,"data/imagenes/ClashOfClans.jpg");
		
	}
	//--------- M É T O D O S ----------//
	/**
	 * Retorna le juego uno.
	 * @return juego 1.
	 */
	public Juego getJuego1() {
		return juego1;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el juego dos.
	 * @return juego 2.
	 */

	public Juego getJuego2() {
		return juego2;
	}
	//---------------------------------------------------//

	/**
	 * Retorna el juego tres 
	 * @return juego 3.
	 */
	public Juego getJuego3() {
		return juego3;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el juego cuatro
	 * @return
	 */

	public Juego getJuego4() {
		return juego4;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el juego con el nombre pasado por parámetros.
	 * @param pJuego Nombre del juego buscado. pNombre !=null && pNombre !="".
	 * @return juego con el nombre pasado por parámetro, null si no lo encuentra.
	 */
	public Juego buscarJuego(String pJuego)
	{
		Juego buscado = null;

		if(pJuego.equals(juego1.getNombre())) 
		{
			buscado =juego1;
		} 
		else if(pJuego.equals(juego2.getNombre()))
		{
			buscado = juego2;
		}
		else if(pJuego.equals(juego3.getNombre()))
		{
			buscado = juego3;
		}
		else if(pJuego.equals(juego4.getNombre()))
		{
			buscado = juego4;
		}
		return buscado;
	}
	
	//---------------------------------------------------//
	/**
	 * Registra la venta de una licencia de un juego determinado por su nombre y la cantidad de licencias a vender<br>
	 * <b>post: </b> Aumentó la cantidad de licencias vendidas del juego. <br>
     * Si la cantidad de juegos a vender era mayor que la cantidad de existencias del juego, la venta no se realizó.
	 * @param pJuego Nombre del juego a buscar. pJuego!=null && pJuego!="".
	 * @param pCantidad Cantidad de licencias a vender. pCantidad>0.  
	 * @return Retorna true si se hizo una venta de lo contrario retorna false.
	 */
	public boolean venderLicencia(String pJuego, int pCantidad)
	{
		boolean vendida = false;
		if(buscarJuego(pJuego)!=null)
		{
			vendida = buscarJuego(pJuego).venderLicencia(pCantidad);

		}
				
		return vendida;
	}
	//---------------------------------------------------//
	/**
	 * Registra la compra du una licencia de un juego determinado por su nombre y cantidad de licencias a comprar.<br>
	 * <b>post: </b> Aumentó la cantidad de licencias del juego.
	 * @param pJuego Nombre del juego a buscar. pJuego!=null && pJuego!="".
	 * @param pCantidad  pCantidad>0.  
	 */
	public void comprarLicencia(String pJuego, int pCantidad)
	{
		if(buscarJuego(pJuego)!=null)
		{
			buscarJuego(pJuego).comprarLicencia(pCantidad);
		}
	}
	//---------------------------------------------------//
    /**
     * Retorna el nombre del juego con más unidades vendidas. <br>
     * En caso de que se haya vendido la misma cantidad de licencias para varios juegos y esta sea la mayor cantidad, se retorna el nombre del primero <br>
     * de los juegos que cumpla con la condición.
     * @return Nombre del juego que ha vendido una mayor cantidad de licencias o "Ninguno" en caso en el que ningún juego haya vendido licencias.
     */
	public String masVendidos()
    {
        String masVendido = "Ninguno";
        int cantidadMasVendida = 0;
        if( juego1.getLicenciaVendida( ) > cantidadMasVendida )
        {
            masVendido = juego1.getNombre( );
            cantidadMasVendida = juego1.getLicenciaVendida( );
        }
        if( juego2.getLicenciaVendida( ) > cantidadMasVendida )
        {
            masVendido = juego2.getNombre( );
            cantidadMasVendida = juego2.getLicenciaVendida( );
        }
        if( juego3.getLicenciaVendida( )> cantidadMasVendida )
        {
            masVendido = juego3.getNombre( );
            cantidadMasVendida = juego3.getLicenciaVendida( );
        }
        if( juego4.getLicenciaVendida( ) > cantidadMasVendida )
        {
            masVendido = juego4.getNombre( );
            cantidadMasVendida = juego4.getLicenciaVendida( );
        }

        return masVendido;
    }
	
	//---------------------------------------------------//
    /**
     * Retorna una cadena de texto con el descuento por ventas de juegos en volumen teniendo en cuenta las siguientes reglas: <br>
     * - Si se quieren comprar mínimo 25 licencias de juegos de rompecabezas se dará un descuento del 20% sobre el valor total. <br>
     * - Si se quieren comprar al menos 20 licencias de juegos de deportes y 15 licencias de juegos de acción se dará un descuento del 15% sobre el valor total. <br>
     * Cuando en una venta se cumplen las dos condiciones anteriores, sólo se aplica el primer descuento.
     * @param pCantidadLicenciasJuego1 Cantidad de licencias que se pretenden vender del juego1.
     * @param pCantidadLicenciasJuego2 Cantidad de licencias que se pretenden vender del juego2.
     * @param pCantidadLicenciasJuego3 Cantidad de licencias que se pretenden vender del juego3.
     * @param pCantidadLicenciasJuego4 Cantidad de licencias que se pretenden vender del juego4.
     * @return Cadena de texto que informa el precio total de las licencias de juego a vender antes del descuento, el valor del descuento y el precio final con el descuento.
     */
	public String calcularVentaPorVolumen(int pCantidadLicenciasJuego1, int pCantidadLicenciasJuego2, int pCantidadLicenciasJuego3, int pCantidadLicenciasJuego4 )
	{
        int cantRompecab 	= 0;
        int cantDeporte 	= 0;
        int cantAccion 		= 0;
		
		switch( juego1.getCategoria() )
        {
            case ROMPECABEZA:
            {
                cantRompecab += pCantidadLicenciasJuego1;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego1;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego1;
                break;
            }
        }
        switch( juego2.getCategoria() )
        {
            case ROMPECABEZA:
            {
                cantRompecab += pCantidadLicenciasJuego2;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego2;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego2;
                break;
            }
        }
        switch( juego3.getCategoria() )
        {
            case ROMPECABEZA:
            {
                cantRompecab += pCantidadLicenciasJuego3;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego3;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego3;
                break;
            }
        }
        switch( juego4.getCategoria() )
        {
            case ROMPECABEZA:
            {
                cantRompecab += pCantidadLicenciasJuego4;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego4;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego4;
                break;
            }
        }

        double totalVenta = ( juego1.getPrecio() * pCantidadLicenciasJuego1 ) + ( juego2.getPrecio() * pCantidadLicenciasJuego2 ) + ( juego3.getPrecio() * pCantidadLicenciasJuego3 ) + ( juego4.getPrecio() * pCantidadLicenciasJuego4 );
        double descuento = 0;

        if( cantRompecab >= CANT_MIN_ROMPECABEZA )
        {
            descuento = totalVenta * DESCUENTO_1;
        }
        else if( cantDeporte >= CANT_MIN_DEPORTE && cantAccion >= CANT_MIN_ACCION )
        {
            descuento = totalVenta * DESCUENTO_2;
        }
        else
        {
            descuento = 0;
        }

        double totalConDescuento = totalVenta - descuento;
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
		df.applyPattern( "$ ###,###.##" );

        String mensaje = "El precio total de la venta sería:  " + df.format(totalVenta) + "\n" + "El descuento sería de:  " + df.format(descuento) + "\n" + "El precio con descuento sería:  " + df.format(totalConDescuento) ;

        return mensaje;
	}
	

}
