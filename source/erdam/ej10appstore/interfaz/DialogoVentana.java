package erdam.ej10appstore.interfaz;

import javax.swing.JDialog;
/**
 * Dialogo que se muestra cuando se quiere obtener descuentos por volumen.
 */
@SuppressWarnings("serial")
public class DialogoVentana extends JDialog{

	//------- A T R I B U T O S -------//
    /**
     * Panel donde se seleccionan las cantidades de licencias a comprar.
     */
	private PanelVentas ventas;
	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazAppStore principal;
	//----- C O N S T R U C T O R  -----//
    /**
     * Crea el diálogo para consultar ventas en volumen.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
	public DialogoVentana(InterfazAppStore pPrincipal) 
	{
		principal = pPrincipal;
		setTitle("Consulta ventas en volumenes");
		setSize(400,240);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    ventas = new PanelVentas(this); 
		add(ventas);
		setModal(true);
		setLocationRelativeTo(pPrincipal);
		setResizable(false);
		
	}
	//--------- M É T O D O S ----------//
	/**
	 * Acción del botón cancelar.
	 */
	public void cancelar()
	{
		dispose();
	}
	//---------------------------------------------------//
	/**
	 * 
	 * @param cantLicenciaJuego1 Cantidad de licencias del juego1. cantLicenciaJuego1>=0.
	 * @param cantLicenciaJuego2 Cantidad de licencias del juego1. cantLicenciaJuego2>=0.
	 * @param cantLicenciaJuego3 Cantidad de licencias del juego1. cantLicenciaJuego3>=0.
	 * @param cantLicenciaJuego4 Cantidad de licencias del juego1. cantLicenciaJuego4>=0.
	 */
	public void aceptar(int cantLicenciaJuego1, int cantLicenciaJuego2, int cantLicenciaJuego3, int cantLicenciaJuego4 )
	{
		principal.consultarDescuentos(cantLicenciaJuego1, cantLicenciaJuego2, cantLicenciaJuego3, cantLicenciaJuego4);
		dispose();
	}
}
