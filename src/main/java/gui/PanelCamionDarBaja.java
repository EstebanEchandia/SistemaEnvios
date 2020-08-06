package gui;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCamionDarBaja extends JPanel {
	
	private JLabel lblId = new JLabel("Id:");
	private JTextField txtId;
	
	private JLabel lblPatente = new JLabel("Patente:");
	private JTextField txtPatente;
	
	private JLabel lblModelo = new JLabel("Modelo:");
	private JTextField txtModelo;
	
	private JLabel lblMarca = new JLabel("Marca:");
	private JTextField txtMarca;
	
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
	
	public void PanelCamionDarBaja(){
	}
	
	public void armarPanel() {
		
		
		this.setLayout(null);
		
		this.setBackground(Color.yellow);
		
		this.txtId = new JTextField(20);
		this.txtPatente.setBounds(400, 20, 100,20);
		this.lblId.setBounds(350,20,100,20);
		this.add(lblId);
		this.add(txtId);
		
		this.txtPatente = new JTextField(20);
		this.txtPatente.setBounds(60, 20, 100,20);
		this.lblPatente.setBounds(10,20,100,20);
		this.add(lblPatente);
		this.add(txtPatente);
		
		this.txtModelo = new JTextField(50);
		this.txtModelo.setBounds(60, 50, 100, 20);
		this.lblModelo.setBounds(10, 50, 100, 20);
		this.add(lblModelo);
		this.add(txtModelo);
		
		this.txtMarca = new JTextField(50);
		this.txtMarca.setBounds(60, 80, 100, 20);
		this.lblMarca.setBounds(10, 80, 100, 20);
		this.add(lblMarca);
		this.add(txtMarca);
		
		this.txtFechaCompra = new JFormattedTextField(80);
		this.txtFechaCompra.setBounds(130, 120, 100, 20);
		this.lblFechaDeCompra.setBounds(10, 120, 120, 20);
		this.add(lblFechaDeCompra);
		this.add(txtFechaCompra);
		
		this.txtKmRecorridos = new JTextField(30);
		this.txtKmRecorridos.setBounds(130, 150, 100, 20);
		this.lblKmRecorridos.setBounds(10, 150, 100, 20);
		this.add(lblKmRecorridos);
		this.add(txtKmRecorridos);
		
		this.txtCostoPorKm = new JTextField(30);
		this.txtCostoPorKm.setBounds(130, 180, 100, 20);
		this.lblCostoPorKm.setBounds(10, 180, 100, 20);
		this.add(lblCostoPorKm);
		this.add(txtCostoPorKm);
		
		this.txtCostoPorHora = new JTextField(30);
		this.txtCostoPorHora.setBounds(130, 210, 100, 20);
		this.lblCostoPorHora.setBounds(10, 210, 100, 20);
		this.add(lblCostoPorHora);
		this.add(txtCostoPorHora);
		
		this.btnGuardar = new JButton("Dar Baja");
		this.btnGuardar.setBounds(300, 400, 100, 40);
		this.add(btnGuardar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(430, 400, 100, 40);
		this.add(btnCancelar);

	}
}
