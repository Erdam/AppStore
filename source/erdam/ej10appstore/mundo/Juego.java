package erdam.ej10appstore.mundo;
/**
 * Juego de la AppStore
 */
public class Juego {
	//------- A T R I B U T O S -------//
	/**
	 * Nombre del Juego.
	 */
	private String nombre;
	/**
	 * Categor�a del juego.
	 */
	private Categoria categoria;
    /**
     * Tama�o en KB del juego.
     */
	private int tamanio;
	/**
	 * Precio del juego.
	 */
	private double precio;
	/**
	 * Cantidad de licencia disponible.
	 */
	private int licenciaDisponible;
	/**
	 * Cantidad de licencia vendida.
	 */
	private int licenciaVendida;
	/**
	 * Ruta de la imagen.
	 */
	private String imgJuego;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Construye un nuevo juego con los valores dados por par�metro. <br>
     * <b>post: </b> El nombre, la categor�a, el precio, el tama�o, la cantidad de licencias y la ruta de la imagen fueron inicializados <br>
     * con los valores dados por par�metro. La cantidad de licencias vendidas fue inicializada en 0. 
	 * @param pNombre Nombre del juego. pNombre!=null && pNombre="".
	 * @param pCategoria Categor�a del juego. pCategoria!=null. 
	 * @param pTamanio Tama�o en kb del juego. pTamanio>0.
	 * @param pPrecio Precio del juego. pPrecio>0. 
	 * @param pLicenciaDisponible Licencia disponible del juego. pLicenciaDisponible>=0.
	 * @param pImagenJuego Ruta de la imagen del juego. pImagenJuego!=null && pImagenJuego!="".
	 */

	public Juego(String pNombre, Categoria pCategoria, int pTamanio, double pPrecio, int pLicenciaDisponible, String pImagenJuego)
	{
			nombre 				= pNombre;
			categoria 			= pCategoria;
			tamanio             = pTamanio;
			precio              = pPrecio;
			licenciaDisponible  = pLicenciaDisponible;
			imgJuego            = pImagenJuego;
			licenciaVendida     = 0;
	
	}
//--------- M � T O D O S ----------//
    /**
     * Retorna el nombre del juego.
     * @return nombre.
     */
	public String getNombre() {
		return nombre;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la categor�a del juego.
	 * @return categor�a.
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el tama�o del juego.
	 * @return tama�o.
	 */
	public int getTamanio() {
		return tamanio;
	}
	//---------------------------------------------------//
	/**
	 * Retorna el precio del juego.
	 * @return precio.
	 */
	public double getPrecio() {
		return precio;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la cantidad de licencia disponible.
	 * @return licencias disponibles.
	 */
	public int getLicenciaDisponible() {
		return licenciaDisponible;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la cantidad de licencias vendidas
	 * @return licencia vendidas.
	 */
	public int getLicenciaVendida() {
		return licenciaVendida;
	}
	//---------------------------------------------------//
	/**
	 * Retorna la ruta de la imagen.
	 * @return ruta de la imagen.
	 */
	public String getImgJuego() {
		return imgJuego;
	}

   //---------------------------------------------------//
	/**
	 * Compra una cantidad dada de licencias. <br>
     * <b>post: </b> Se aument� la cantidad actual de licencias del juego en la cantidad dada.
	 * @param pCantidad Cantidad que se quiere comprar. pCantidad>0.
	 */
	public void comprarLicencia(int pCantidad)
	{
		licenciaDisponible+= pCantidad;
	}
	 //---------------------------------------------------//
	/**
	 * Vende una cantidad dada de licencias, si cuenta con la cantidad suficiente. <br>
     * <b>post: </b> Disminuy� la cantidad actual de licencias del juego y aument� la cantidad de licencias vendidas.  <br>
	 * @param pCantidad Cantidad que se quere vender. pCantidad>0.
	 * @return Retorna true si logra realizar la venta, false de lo contrario.
	 */
	public boolean venderLicencia(int pCantidad)
	{
		boolean vendidas = false;
		if (licenciaDisponible>=pCantidad)
		{
			licenciaDisponible-=pCantidad;
			licenciaVendida+=pCantidad;
			vendidas = true;
			
		}
		
		return vendidas;
	}
}
