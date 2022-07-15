package erdam.ej10appstore.interfaz;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import erdam.ej10appstore.mundo.AppStore;
/**
 * Ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazAppStore extends JFrame {
	//------- A T R I B U T O S -------//
	/**
	 * Clase principal del mundo.
	 */
	private AppStore		appStore;
	/**
	 * Panel contenedor del banner
	 */
	private PanelBanner 	banner;
	/**
	 * Panel con el juego 1.
	 */
	private PanelJuegos 	juegos1;
	/**
	 * Panel con el juego 2.
	 */
	private PanelJuegos 	juegos2;
	/**
	 * Panel con el juego 3.
	 */
	private PanelJuegos 	juegos3;
	/**
	 * Panel con el juego 4.
	 */
	private PanelJuegos 	juegos4;
	/**
	 * Panel contenedor de los botones.
	 */
	private PanelBotones 	botones;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor de la interfaz.<br>
	 * <b>post: </b> Se inicializarón todos los paneles.
	 */
	public InterfazAppStore()
	{

		setTitle("AppStore");
		setSize(800,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel centro = new JPanel();
		centro.setLayout(new GridLayout(2, 2));
		appStore            = new AppStore();
		banner 				= new PanelBanner();
		juegos1			 	= new PanelJuegos(this);
		juegos2 			= new PanelJuegos(this);
		juegos3 			= new PanelJuegos(this);
		juegos4 			= new PanelJuegos(this);
		botones 			= new PanelBotones(this);
		centro.add(juegos1);
		centro.add(juegos2);
		centro.add(juegos3);
		centro.add(juegos4);
		add(banner, BorderLayout.NORTH);
		add(centro, BorderLayout.CENTER);
		add(botones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setResizable(false);
		actualizarPaneles();
		
		
	}

	//--------- M É T O D O S ----------//
	//---------------------------------------------------//
	/**
	 * Comprar una cantidad de licencia del juego con el nombre dado por parámetro.
	 * 
	 * @param pNombre Nombre del juego. pNombre!=null && pNombre=!"".
	 */
	public void comprarLicencia(String pNombre)
	{
		String pCant = JOptionPane.showInputDialog(this,"Cantidad de licencia a comprar","Comprar licencia", JOptionPane.QUESTION_MESSAGE);
		if(pCant!=null)
		{
			try {
				int cantidad = Integer.parseInt(pCant);
				if(cantidad>0)
				{
					appStore.comprarLicencia(pNombre, cantidad);
					actualizarPaneles();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "La cantidad ingresada debe ser mayor a cero","Comprar licencia", JOptionPane.ERROR_MESSAGE);
				}
				
				
			} catch (NumberFormatException e) {
				 JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un valor numérico.", "Comprar licencias", JOptionPane.ERROR_MESSAGE );
			}
			
		}
		
	}
	//---------------------------------------------------//
	/**
	 * Vende una cantidad de licencias del juego con el nombre dado por parámetro.
	 * @param pNombre Nombre del juego. pNombre!=null && pNombre=!"".
	 */
	public void venderLicencia(String pNombre)
	{
		String pCant = JOptionPane.showInputDialog(this,"Cantidad de licencia a vender", "Vender licencia", JOptionPane.QUESTION_MESSAGE);
		if(pCant!=null)
		{
			try {
				int cantidad = Integer.parseInt(pCant);
				if(cantidad>0)
				{
					boolean vendido = appStore.venderLicencia(pNombre, cantidad);
					if(vendido)
					{
						actualizarPaneles();
					}
					else
					{
						JOptionPane.showMessageDialog(this, "El juego no tiene suficientes licencias para concretar la venta", "Vender licencia", JOptionPane.ERROR_MESSAGE);
					}
				
				}
				else
				{
					JOptionPane.showMessageDialog(this, "La cantidad ingresada debe ser mayor a cero ", "Vender licencia",JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"El valor ingresado debe ser un valor numérico.", "Vender licencia", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

	// ---------------------------------------------------//
	/**
	 * Muestra el juego más vendido.
	 */
	public void masVendidos()
	{
		JOptionPane.showMessageDialog(this, "El juego más vendido es: "+appStore.masVendidos(),"Juego más vendido", JOptionPane.INFORMATION_MESSAGE);
	}
	//---------------------------------------------------//
    /**
     * Muestra el dialogo para seleccionar la cantidad de juegos para consultar una venta por volumen.
     */
	public void getDialogoDescuentos()
	{
		DialogoVentana dialogo = new DialogoVentana(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
	}
	//---------------------------------------------------//
	public void consultarDescuentos(int pCantidadLicenciasJuego1,int pCantidadLicenciasJuego2,int pCantidadLicenciasJuego3,int pCantidadLicenciasJuego4)
	{
		JOptionPane.showMessageDialog(this,"\n"+appStore.calcularVentaPorVolumen(pCantidadLicenciasJuego1, pCantidadLicenciasJuego2, pCantidadLicenciasJuego3, pCantidadLicenciasJuego4),"Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
	//---------------------------------------------------//
	private void actualizarPaneles() {
		juegos1.actualizarDatos(appStore.getJuego1());
		juegos2.actualizarDatos(appStore.getJuego2());
		juegos3.actualizarDatos(appStore.getJuego3());
		juegos4.actualizarDatos(appStore.getJuego4());

	}
	// ---------------------------------------------------//
	/**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
	 */
	public static void main(String[] pArgs) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			InterfazAppStore principal = new InterfazAppStore();
			principal.setVisible(true);
		} catch (Exception e) {
			 e.printStackTrace();
		}

	}
}
