package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelInsumoDarBaja extends JPanel {
	
	private JLabel lblId = new JLabel("Id:");
	private JTextField txtId;
	
	private JButton btnGuardar;
	
	private JTextArea txtAreaExplicacion = new JTextArea("Escriba el ID del Insumo a dar de baja y oprima Dar Baja");
	
	public void PanelInsumo(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.orange);
		
		this.txtId = new JTextField(20);
		this.txtId.setBounds(60, 20, 100,20);
		this.lblId.setBounds(10,20,100,20);
		this.add(lblId);
		this.add(txtId);
		
		this.btnGuardar = new JButton("Dar Baja");
		this.btnGuardar.setBounds(370, 400, 100, 40);
		this.add(btnGuardar);
		
		this.txtAreaExplicacion.setBounds(10,60,250,200);
		this.txtAreaExplicacion.setFont(new Font("Serif", Font.BOLD, 16));
		this.txtAreaExplicacion.setLineWrap(true);
		this.txtAreaExplicacion.setWrapStyleWord(true);
		this.txtAreaExplicacion.setOpaque(false);
		this.txtAreaExplicacion.setEditable(false);
		this.add(txtAreaExplicacion);
	}
}
