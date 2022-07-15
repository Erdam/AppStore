package erdam.ej10appstore.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import erdam.ej10appstore.mundo.Juego;

/**
 * Panel que muestra la informaci�n de los juegos.
 *
 */
@SuppressWarnings("serial")
public class PanelJuegos extends JPanel implements ActionListener{

	// ------- C O N S T A N T E S -------//
	/**
	 * Compando para el bot�n comprar.
	 */
	private static final String COMPRAR 	= "Comprar";
	/**
	 * Comando para el bot�n vender.
	 */
	private static final String VENDER 		= "Vender";
	//------- A T R I B U T O S -------//
	/**
	 * Ventana principal de la aplicaci�n.
	 */
	private InterfazAppStore principal;
	/**
	 * Juego que atualmente se presenta en el panel.
	 */
	private Juego 			juego;
	/**
	 * Etiqueta contenedora de la im�gen del producto.
	 */
	private JLabel 			lblImagen;
	/**
	 * Etiqueta categor�a del juego.
	 */
	private JLabel 			lblCategoria;
	/**
	 * Etiqueta tama�o del juego en KB.
	 */
	private JLabel 			lblTamanio;
	/**
	 * Etiqueta precio del juego. 
	 */
	private JLabel 			lblPrecio;
	/**
	 * Etiqueta de juegos disponibles.
	 */
	private JLabel 			lblDisponibilidad;
	/**
	 * Etiqueta de las ventas.
	 */
	private JLabel 			lblVendidas;
	/**
	 * Campo de texto que muesta la categor�a del jego.
	 */
	private JTextField		txtCategoria;
	/**
	 * Campo de texto que muestra el tama�o en KB.
	 */
	private JTextField		txtTamanio;
	/**
	 * Campo de texto que muestra el precio del juego.
	 */
	private JTextField		txtPrecio;
	/**
	 * Campo de texto que muestra la cantidad de licencias disponibles de ese juego.
	 */
	private JTextField		txtDisponibilidad;
	/**
	 * Campo de texto que muestra la cantidad de licencias vendidas de ese juego.
	 */
	private JTextField		txtVendidas;
	/**
	 * Bot�n para comprar una licencia de un juego.
	 */
	private JButton         btnComprar;
	/**
	 * Bot�n para vender una licencia de un juego.
	 */
	private JButton         btnVender;
	
	
	//----- C O N S T R U C T O R  -----//
	/**
	 * Construye el panel con la informaci�n del juego.
	 * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal!=null.
	 */
	public PanelJuegos(InterfazAppStore pPrincipal) {
		principal = pPrincipal;
		setLayout(new BorderLayout());
		JPanel panelPrincipal 					= new JPanel();
		JPanel panelBotones 					= new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBorder(new TitledBorder("Juegos"));
		panelPrincipal.setLayout(new GridLayout(5, 1, 0, 5));
		panelBotones.setLayout(new GridLayout(1, 2));
		lblCategoria 								= new JLabel("Categor�a: ");
		lblTamanio 									= new JLabel("Tama�o en KB: ");
		lblPrecio 									= new JLabel("Precio: ");
		lblDisponibilidad 							= new JLabel("Disponibles: ");
		lblVendidas									= new JLabel("Vendidas: ");
		lblImagen 									= new JLabel(new ImageIcon("data/imagenes/CandyCrush.jpg"));
		txtCategoria								= new JTextField(15);
		txtCategoria.setEditable(false);
		txtTamanio				 					= new JTextField(15);
		txtTamanio.setEditable(false);
		txtPrecio									= new JTextField(15);
		txtPrecio.setEditable(false);
		txtDisponibilidad	 						= new JTextField(15);
		txtDisponibilidad.setEditable(false);
		txtVendidas			 						= new JTextField(15);
		txtVendidas.setEditable(false);
		btnComprar		 							= new JButton(COMPRAR);
		btnComprar.setActionCommand(COMPRAR);
		btnComprar.addActionListener(this);
		btnVender = new JButton(VENDER);
		btnVender.setActionCommand(VENDER);
		btnVender.addActionListener(this);
		panelPrincipal.add(lblCategoria);
		panelPrincipal.add(txtCategoria);
		panelPrincipal.add(lblTamanio);
		panelPrincipal.add(txtTamanio);
		panelPrincipal.add(lblPrecio);
		panelPrincipal.add(txtPrecio);
		panelPrincipal.add(lblDisponibilidad);
		panelPrincipal.add(txtDisponibilidad);
		panelPrincipal.add(lblVendidas);
		panelPrincipal.add(txtVendidas);
		panelBotones.add(btnComprar);
		panelBotones.add(btnVender);
		add(panelPrincipal, BorderLayout.CENTER);
		add(lblImagen, BorderLayout.WEST);
		add(panelBotones, BorderLayout.SOUTH);
	
	}
	//--------- M � T O D O S ----------//
    /**
     * Actualiza la informaci�n del panel con la informaci�n dada.
     * @param pJuego Juego para actualizar la informaci�n. pJuego != null.
     */
	public void actualizarDatos(Juego pJuego)
	{
		juego = pJuego;
		String categoria = juego.getCategoria().toString();
		DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
		df.applyPattern( "$ ###,###.##" );
		setBorder(new TitledBorder(juego.getNombre()));
		lblImagen.setIcon(new ImageIcon(juego.getImgJuego()));
		txtCategoria.setHorizontalAlignment(JTextField.CENTER);
		txtCategoria.setText(categoria.charAt(0) + categoria.substring(1, categoria.length()).toLowerCase());
		txtDisponibilidad.setHorizontalAlignment(JTextField.CENTER);
		txtDisponibilidad.setText(Integer.toString(juego.getLicenciaDisponible()));
		txtPrecio.setHorizontalAlignment(JTextField.CENTER);
		txtPrecio.setText(df.format(juego.getPrecio()));
		txtTamanio.setHorizontalAlignment(JTextField.CENTER);
		txtTamanio.setText(Integer.toString(juego.getTamanio()));
		txtVendidas.setHorizontalAlignment(JTextField.CENTER);
		txtVendidas.setText(Integer.toString(juego.getLicenciaVendida()));
		
	}
	//---------------------------------------------------//
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un bot�n. pEvento != null.
	 */

	@Override
	public void actionPerformed(ActionEvent pEvento) {
		String command = pEvento.getActionCommand();
		try {
			switch (command) {
			case COMPRAR:
				principal.comprarLicencia(juego.getNombre());;
				
				break;

			case VENDER:
				principal.venderLicencia(juego.getNombre());
				break;
				
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		
	}

}
