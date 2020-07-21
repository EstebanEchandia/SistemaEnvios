package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPlanta extends JPanel{
	private JLabel lblNombrePlanta = new JLabel("Nombre Planta:");
	private JTextField txtNombrePlanta;
	
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	public void PanelPlanta(){
	}
	
	public void armarPanel() {
		this.txtNombrePlanta = new JTextField(20);
		this.add(lblNombrePlanta);
		this.add(txtNombrePlanta);
		
		this.btnGuardar = new JButton("Guardar");
		this.add(btnGuardar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.add(btnCancelar);
	}
}
