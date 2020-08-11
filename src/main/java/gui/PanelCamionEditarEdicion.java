package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import app.App;
import gestor.GestorCamion;

public class PanelCamionEditarEdicion  extends JPanel{
	
	private JPanel panelEditarCamion = new JPanel();
		
	private JLabel lblId = new JLabel("Id:");
	private JTextField txtId;
	
	private JLabel lblPatente = new JLabel("Patente:");
	private JTextField txtPatente;
	
	private JLabel lblModelo = new JLabel("Modelo:");
	private JTextField txtModelo;
	
	private JLabel lblFechaDeCompra = new JLabel("Fecha de  compra:");
	private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	private JFormattedTextField txtFechaCompra = new JFormattedTextField(df);	
	
	private JLabel lblKmRecorridos = new JLabel("KMs recorridos:");
	private JTextField txtKmRecorridos;
	
	private JLabel lblCostoPorKm = new JLabel("Costo por Km:");
	private JTextField txtCostoPorKm;
	
	private JLabel lblCostoPorHora = new JLabel("Costo por hora:");
	private JTextField txtCostoPorHora;
	
	private JButton btnGuardar;
	private JButton btnCancelar;

	private JTextArea txtAreaExplicacion = new JTextArea("Para modificar un camion el usuario modificar los campos que desee. \n\n La fecha debe ser ingresada en el formato: aaaa-mm-dd");
	
	private GestorCamion gestorCamion = new GestorCamion();
	
	private JLabel imagenCamion;
	
	public void armarPanel(App app,Object[] atributos) {
		
		
		this.setLayout(null);
		this.setBackground(Color.yellow);
		
		this.setBounds(0, 0, 900, 560);
		this.setOpaque(true);
		
		txtId = new JTextField((String)atributos[0]);
		txtId.setBounds(520, 20, 100,20);
		lblId.setBounds(500,20,100,20);
		this.add(lblId);
		this.add(txtId);
		
		lblId.setEnabled(false);
		txtId.setEnabled(false);
		
		txtPatente = new JTextField((String)atributos[1]);
		txtPatente.setBounds(60, 20, 100,20);
		lblPatente.setBounds(10,20,100,20);
		this.add(lblPatente);
		this.add(txtPatente);
		
		txtModelo = new JTextField((String)atributos[2]);
		txtModelo.setBounds(60, 50, 100, 20);
		lblModelo.setBounds(10, 50, 100, 20);
		this.add(lblModelo);
		this.add(txtModelo);
		
		txtFechaCompra = new JFormattedTextField((String)atributos[3]);
		txtFechaCompra.setBounds(130, 80, 100, 20);
		lblFechaDeCompra.setBounds(10, 80, 120, 20);
		this.add(lblFechaDeCompra);
		this.add(txtFechaCompra);
		
		txtKmRecorridos = new JTextField((String)atributos[4]);
		txtKmRecorridos.setBounds(130, 110, 100, 20);
		lblKmRecorridos.setBounds(10, 110, 100, 20);
		this.add(lblKmRecorridos);
		this.add(txtKmRecorridos);
		
		txtCostoPorKm = new JTextField((String)atributos[5]);
		txtCostoPorKm.setBounds(130, 140, 100, 20);
		lblCostoPorKm.setBounds(10, 140, 100, 20);
		this.add(lblCostoPorKm);
		this.add(txtCostoPorKm);  
		
		txtCostoPorHora = new JTextField((String)atributos[6]);
		txtCostoPorHora.setBounds(130, 170, 100, 20);
		lblCostoPorHora.setBounds(10, 170, 100, 20);
		this.add(lblCostoPorHora);
		this.add(txtCostoPorHora);
		
		btnGuardar = new JButton("Editar");
		btnGuardar.setBounds(310, 400, 100, 40);
		
		btnGuardar.addActionListener( e -> {
			gestorCamion.updateCamion(Integer.parseInt(txtId.getText()), 
					txtPatente.getText(), 
					txtModelo.getText(), 
					Double.parseDouble(txtKmRecorridos.getText()), 
					Double.parseDouble(txtCostoPorKm.getText()), 
					Double.parseDouble(txtCostoPorHora.getText()), 
					LocalDate.parse(txtFechaCompra.getText()));
			PanelCamionEditar panelCamionEditar = new PanelCamionEditar();
			panelCamionEditar.armarPanel(app);
		});
		
		this.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(420, 400, 100, 40);
		btnCancelar.addActionListener( e -> {
			PanelCamionEditar panelCamionEditar = new PanelCamionEditar();
			panelCamionEditar.armarPanel(app);
		});
		
		this.add(btnCancelar);
		
		txtAreaExplicacion.setBounds(500,60,250,250);
		txtAreaExplicacion.setFont(new Font("Serif", Font.BOLD, 16));
		txtAreaExplicacion.setLineWrap(true);
		txtAreaExplicacion.setWrapStyleWord(true);
		txtAreaExplicacion.setOpaque(false);
		txtAreaExplicacion.setEditable(false);
		this.add(txtAreaExplicacion);
		
		imagenCamion = new JLabel();
		imagenCamion.setBounds(60,300,140,140);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/camion.png"));	
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(140,140,Image.SCALE_SMOOTH)); 
		imagenCamion.setIcon(icono);
		this.add(imagenCamion);
		
		app.setContentPane(this);
		app.pack();
	}
	
	
}
