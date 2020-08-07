package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPlantaAniadirPlanta extends JPanel{
	private JLabel lblNombrePlanta = new JLabel("Nombre Planta:");
	private JTextField txtNombrePlanta;
	
	private JButton btnGuardar;
	
	public void PanelPlanta(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(new Color(184,65,39));
		
		this.txtNombrePlanta = new JTextField(20);
		this.txtNombrePlanta.setBounds(110, 20, 100,20);
		this.lblNombrePlanta.setBounds(10,20,100,20);
		this.add(lblNombrePlanta);
		this.add(txtNombrePlanta);
		
		this.btnGuardar = new JButton("Añadir Planta");
		this.btnGuardar.setBounds(370, 400, 120, 40);
		this.add(btnGuardar);
	}
}
