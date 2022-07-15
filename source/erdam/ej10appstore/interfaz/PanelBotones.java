package erdam.ej10appstore.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Panel para mostrar los botones Juego más vendidos y descuento por volumen.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener{
	// ------- C O N S T A N T E S -------//
	/**
	 * Comando par ver el juego más vendido.
	 */
	private static final String JUEGO_MAS_VENDIDO           = "Juego más vendido";
	/**
	 * Comando para ver el descuento por volumen.
	 */
	private static final String DESCUENTO_POR_VOLUMEN		="Descuento por volumen";
	//------- A T R I B U T O S -------//
	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazAppStore 	principal;
	/**
	 * Botón para ver el juego más vendido.
	 */
	private JButton 			btnMasVendido;
	/**
	 * Botón para ver el descuento por volumen.
	 */
	private JButton 			btnDescuentoPorVolumen;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Construye el panel botones busca el juego más vendido y el descuento por volumen.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal=null.
	 */
	public PanelBotones(InterfazAppStore pPrincipal)
	{
		principal = pPrincipal;
		setBackground(Color.WHITE);
		btnMasVendido 				= new JButton(JUEGO_MAS_VENDIDO);
		btnDescuentoPorVolumen 		= new JButton(DESCUENTO_POR_VOLUMEN);
		btnMasVendido.setActionCommand(JUEGO_MAS_VENDIDO);
		btnMasVendido.addActionListener(this);
		btnMasVendido.setBackground(new Color(203,214,210));
		btnMasVendido.setForeground(Color.BLACK);
		btnDescuentoPorVolumen.setActionCommand(DESCUENTO_POR_VOLUMEN);
		btnDescuentoPorVolumen.addActionListener(this);
		btnDescuentoPorVolumen.setBackground(new Color(203,214,210));
		btnDescuentoPorVolumen.setForeground(Color.BLACK);
		setLayout(new GridLayout(1,2,1,1));
		add(btnMasVendido);
		add(btnDescuentoPorVolumen);
	}
	//--------- M É T O D O S ----------//
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un botón. pEvento != null.
	 */

	@Override
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		try {
			if(command.equals(JUEGO_MAS_VENDIDO))
			{
				principal.masVendidos();
			}
			else if(command.equals(DESCUENTO_POR_VOLUMEN))
			{
				principal.getDialogoDescuentos();
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}

}
