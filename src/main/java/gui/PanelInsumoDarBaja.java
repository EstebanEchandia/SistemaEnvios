package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	
	private JLabel imagenInsumo1;
	private JLabel imagenInsumo2;
	private JLabel imagenInsumo3;
	
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
		
		this.imagenInsumo1 = new JLabel();
		this.imagenInsumo1.setBounds(550,30,100,100);
		
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/etiqueta.png"));	
		Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)); 
		this.imagenInsumo1.setIcon(icono1);
		this.add(imagenInsumo1);
		
		this.imagenInsumo2 = new JLabel();
		this.imagenInsumo2.setBounds(650,150,100,100);
		
		ImageIcon imagen2 = new ImageIcon(getClass().getResource("/imagenes/bolsa.png"));	
		Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)); 
		this.imagenInsumo2.setIcon(icono2);
		this.add(imagenInsumo2);
		
		this.imagenInsumo3 = new JLabel();
		this.imagenInsumo3.setBounds(550,270,100,100);
		
		ImageIcon imagen3 = new ImageIcon(getClass().getResource("/imagenes/canasta de compras.png"));	
		Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)); 
		this.imagenInsumo3.setIcon(icono3);
		this.add(imagenInsumo3);
	}
}
