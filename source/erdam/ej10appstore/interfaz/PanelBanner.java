package erdam.ej10appstore.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel con la imagen del banner.
 */
public class PanelBanner extends JPanel {
	//------- A T R I B U T O S -------//
	private JLabel contenedor;
	private ImageIcon ruta;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor del Panel <br>
	 * <b>post:</b> El panel qued? iniciado
	 */
	public PanelBanner()
	{
		contenedor = new JLabel();
		ruta = new ImageIcon("data/imagenes/Encabezado.png");
		contenedor.setIcon(ruta);
		add(contenedor);
	}

}
