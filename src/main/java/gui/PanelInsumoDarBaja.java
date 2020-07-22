package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInsumoDarBaja extends JPanel {
	
	private JLabel lblInsumoId = new JLabel("Insumo Id:");
	private JTextField txtInsumoId;
	
	private JLabel lblDescripcion = new JLabel("Se debera poner el Id del Insumo a dar de baja y luego apretar el boton 'Dar de baja'");
	
	private JButton btnDarDeBaja;
	private JButton btnCancelar;
	
	public void PanelInsumo(){
	}
	
	public void armarPanel() {
		
		this.setBackground(Color.orange);
		
		this.txtInsumoId = new JTextField(20);
		this.add(lblInsumoId);
		this.add(txtInsumoId);
		
		this.add(lblDescripcion);

		this.btnDarDeBaja = new JButton("Dar de baja");
		this.add(btnDarDeBaja);
		
		this.btnCancelar = new JButton("Cancelar");
		this.add(btnCancelar);
	}
}
