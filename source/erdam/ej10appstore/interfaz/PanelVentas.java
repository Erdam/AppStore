package erdam.ej10appstore.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
/**
 * Panel con la información del dialogo para venta de licencias de juego por volumen.
 */
@SuppressWarnings("serial")
public class PanelVentas extends JPanel implements ActionListener {

	// ------- C O N S T A N T E S -------//
	/**
	 * Comando para cancelar.
	 */
	private final static String CANCELAR 		= "Cancelar";
	/**
	 * Comando para aceptar
	 */
	private final static String ACEPTAR 		= "Aceptar";
	//------- A T R I B U T O S -------//
    /**
     * Diálogo que contiene el panel.
     */
	private DialogoVentana dialogo;
	/**
	 * Etiqueta con el título.
	 */
	private JLabel 			lblTitulo;
	/**
	 * Etiqueta del juego 1.
	 */
	private JLabel 			lblJuego1;
	/**
	 * Etiqueta del juego 2.
	 */
	private JLabel 			lblJuego2;
	/**
	 * Etiqueta del juego 3.
	 */
	private JLabel 			lblJuego3;
	/**
	 * Etiqueta del juego 4.
	 */
	private JLabel 			lblJuego4;
	/**
	 * Campo de texto del juego 1.
	 */
	private JTextField      txtJuego1;
	/**
	 * Campo de texto del juego 2.
	 */
	private JTextField      txtJuego2;
	/**
	 * Campo de texto del juego 3.
	 */
	private JTextField      txtJuego3;
	/**
	 * Campo de texto del juego 4.
	 */
	private JTextField      txtJuego4;
	/**
	 * Botón para cancelar
	 */

	private JButton         btnCancelar;
	/**
	 * Botón para aceptar.
	 */
	private JButton         btnAceptar;
	
	
	//----- C O N S T R U C T O R  -----//
	/**
     * Diálogo que contiene el panel.
	 * @param pDialogo Dialogo que contiene el panel. pDialogo!=null.
	 */

	public PanelVentas(DialogoVentana pDialogo)
	{
		dialogo 		= pDialogo;
		lblJuego1 		= new JLabel("  Candy Crush");
		lblJuego2 		= new JLabel("  Flow");
		lblJuego3 		= new JLabel("  FIFA");
		lblJuego4 		= new JLabel("  Clash of Clans");
		lblTitulo 		= new JLabel("Escriba la cantidad de licencias a comprar de cada juego.");
		txtJuego1 		= new JTextField();
		txtJuego2 		= new JTextField();
		txtJuego3 		= new JTextField();
		txtJuego4 		= new JTextField();
		btnAceptar 		= new JButton(ACEPTAR);
		btnCancelar     = new JButton(CANCELAR);
		btnAceptar.setActionCommand(ACEPTAR);
		btnAceptar.addActionListener(this);
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);
		setLayout(new BorderLayout());
		JPanel panelTitulo = new JPanel();
		JPanel panelBody   = new JPanel();
		JPanel panelFooter = new JPanel();
		panelTitulo.setBorder(new TitledBorder(""));
		panelTitulo.add(lblTitulo);
		panelBody.setLayout(new GridLayout(4,2,5,5));
		panelBody.setBorder(new TitledBorder(""));
		panelBody.add(lblJuego1);
		panelBody.add(txtJuego1);
		panelBody.add(lblJuego2);
		panelBody.add(txtJuego2);
		panelBody.add(lblJuego3);
		panelBody.add(txtJuego3);
		panelBody.add(lblJuego4);
		panelBody.add(txtJuego4);
		panelFooter.setLayout(new GridLayout(1,2,5,5));
		panelFooter.add(btnAceptar);
		panelFooter.add(btnCancelar);
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelBody, BorderLayout.CENTER);
		add(panelFooter, BorderLayout.SOUTH);
	}
	//--------- M É T O D O S ----------//
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvent Evento de click sobre un botón. pEvent != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		try {
			if(command.equals(ACEPTAR))
			{
				try
	            {
	                String strCantidadJuego1 = txtJuego1.getText( );

	                if( strCantidadJuego1.equals( "" ) )
	                    strCantidadJuego1 = "0";

	                int cantidadJuego1 = Integer.parseInt( strCantidadJuego1 );
	                if( cantidadJuego1 < 0 )
	                {
	                    JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad mayor a 0.", "Ventas en volumen", JOptionPane.ERROR_MESSAGE );
	                }
	                else
	                {
	                    String strCantidadJuego2 = txtJuego2.getText( );

	                    if( strCantidadJuego2.equals( "" ) )
	                        strCantidadJuego2 = "0";

	                    int cantidadJuego2 = Integer.parseInt( strCantidadJuego2 );
	                    if( cantidadJuego2 < 0 )
	                    {
	                        JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad mayor a 0.", "Ventas en volumen", JOptionPane.ERROR_MESSAGE );
	                    }
	                    else
	                    {
	                        String strCantidadJuego3 = txtJuego3.getText( );

	                        if( strCantidadJuego3.equals( "" ) )
	                            strCantidadJuego3 = "0";

	                        int cantidadJuego3 = Integer.parseInt( strCantidadJuego3 );
	                        if( cantidadJuego3 < 0 )
	                        {
	                            JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad mayor a 0.", "EVentas en volumen", JOptionPane.ERROR_MESSAGE );
	                        }
	                        else
	                        {
	                            String strCantidadJuego4 = txtJuego4.getText( );

	                            if( strCantidadJuego4.equals( "" ) )
	                                strCantidadJuego4 = "0";

	                            int cantidadJuego4 = Integer.parseInt( strCantidadJuego4 );
	                            if( cantidadJuego4 < 0 )
	                            {
	                                JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad mayor a 0.", "Ventas en volumen", JOptionPane.ERROR_MESSAGE );
	                            }
	                            else
	                            {
	                                dialogo.aceptar( cantidadJuego1, cantidadJuego2, cantidadJuego3, cantidadJuego4 );
	                            }
	                        }
	                    }
	                }
	            }
	            catch( NumberFormatException e1 )
	            {
	                JOptionPane.showMessageDialog( this, "Ha ocurrido un error con los datos ingresados, debe ingresar valores numéricos.", "Ventas en volumen", JOptionPane.ERROR_MESSAGE );
	            }
	        }
	        else if(command.equals(CANCELAR))
			{
				dialogo.cancelar();
			}
			
				
			
		} catch (Exception e) {
			e.getStackTrace();
		}

		
	}
}
