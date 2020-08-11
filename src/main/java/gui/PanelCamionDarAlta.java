package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import gestor.GestorCamion;

public class PanelCamionDarAlta extends JPanel {
	
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
	
	private GestorCamion gestorCamion = new GestorCamion();
	
	private JLabel imagenCamion;
	
	private JTextArea txtAreaExplicacion = new JTextArea("La fecha debe ser ingresada en el formato: aaaa-mm-dd");
	
	public void PanelCamionDarAlta(){
	}
	
	public void armarPanel() {
		
		
		this.setLayout(null);
		
		this.setBackground(Color.yellow);
		
		this.txtPatente = new JTextField(20);
		this.txtPatente.setBounds(130, 20, 100,20);
		this.lblPatente.setBounds(10,20,100,20);
		this.add(lblPatente);
		this.add(txtPatente);
		
		this.txtModelo = new JTextField(50);
		this.txtModelo.setBounds(130, 50, 100, 20);
		this.lblModelo.setBounds(10, 50, 100, 20);
		this.add(lblModelo);
		this.add(txtModelo);
		
		this.txtFechaCompra = new JFormattedTextField();
		this.txtFechaCompra.setBounds(130, 80, 100, 20);
		this.lblFechaDeCompra.setBounds(10, 80, 120, 20);
		this.add(lblFechaDeCompra);
		this.add(txtFechaCompra);
		
		this.txtKmRecorridos = new JTextField(30);
		this.txtKmRecorridos.setBounds(130, 110, 100, 20);
		this.lblKmRecorridos.setBounds(10, 110, 100, 20);
		this.add(lblKmRecorridos);
		this.add(txtKmRecorridos);
		
		this.txtCostoPorKm = new JTextField(30);
		this.txtCostoPorKm.setBounds(130, 140, 100, 20);
		this.lblCostoPorKm.setBounds(10, 140, 100, 20);
		this.add(lblCostoPorKm);
		this.add(txtCostoPorKm);  
		
		this.txtCostoPorHora = new JTextField(30);
		this.txtCostoPorHora.setBounds(130, 170, 100, 20);
		this.lblCostoPorHora.setBounds(10, 170, 100, 20);
		this.add(lblCostoPorHora);
		this.add(txtCostoPorHora);
		
		this.txtAreaExplicacion.setBounds(500,60,250,250);
		this.txtAreaExplicacion.setFont(new Font("Serif", Font.BOLD, 16));
		this.txtAreaExplicacion.setLineWrap(true);
		this.txtAreaExplicacion.setWrapStyleWord(true);
		this.txtAreaExplicacion.setOpaque(false);
		this.txtAreaExplicacion.setEditable(false);
		this.add(txtAreaExplicacion);
		
		this.btnGuardar = new JButton("Dar Alta");
		this.btnGuardar.addActionListener( e -> gestorCamion.altaCamion(this.getTxtPatente().getText(),
																	this.getTxtModelo().getText(),
																	Double.parseDouble(this.getTxtKmRecorridos().getText()),
																	Double.parseDouble(this.getTxtCostoPorKm().getText()),
																	Double.parseDouble(this.getTxtCostoPorHora().getText()),
																	LocalDate.parse(this.getTxtFechaCompra().getText())));
		this.btnGuardar.setBounds(370, 400, 100, 40);
		this.add(btnGuardar);
		
		this.imagenCamion = new JLabel();
		this.imagenCamion.setBounds(600,300,140,140);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/camion.png"));	
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(140,140,Image.SCALE_SMOOTH)); 
		this.imagenCamion.setIcon(icono);
		this.add(imagenCamion);

	}

	public JLabel getLblPatente() {
		return lblPatente;
	}

	public void setLblPatente(JLabel lblPatente) {
		this.lblPatente = lblPatente;
	}

	public JTextField getTxtPatente() {
		return txtPatente;
	}

	public void setTxtPatente(JTextField txtPatente) {
		this.txtPatente = txtPatente;
	}

	public JLabel getLblModelo() {
		return lblModelo;
	}

	public void setLblModelo(JLabel lblModelo) {
		this.lblModelo = lblModelo;
	}

	public JTextField getTxtModelo() {
		return txtModelo;
	}

	public void setTxtModelo(JTextField txtModelo) {
		this.txtModelo = txtModelo;
	}

	public JLabel getLblFechaDeCompra() {
		return lblFechaDeCompra;
	}

	public void setLblFechaDeCompra(JLabel lblFechaDeCompra) {
		this.lblFechaDeCompra = lblFechaDeCompra;
	}

	public DateFormat getDf() {
		return df;
	}

	public void setDf(DateFormat df) {
		this.df = df;
	}

	public JFormattedTextField getTxtFechaCompra() {
		return txtFechaCompra;
	}

	public void setTxtFechaCompra(JFormattedTextField txtFechaCompra) {
		this.txtFechaCompra = txtFechaCompra;
	}

	public JLabel getLblKmRecorridos() {
		return lblKmRecorridos;
	}

	public void setLblKmRecorridos(JLabel lblKmRecorridos) {
		this.lblKmRecorridos = lblKmRecorridos;
	}

	public JTextField getTxtKmRecorridos() {
		return txtKmRecorridos;
	}

	public void setTxtKmRecorridos(JTextField txtKmRecorridos) {
		this.txtKmRecorridos = txtKmRecorridos;
	}

	public JLabel getLblCostoPorKm() {
		return lblCostoPorKm;
	}

	public void setLblCostoPorKm(JLabel lblCostoPorKm) {
		this.lblCostoPorKm = lblCostoPorKm;
	}

	public JTextField getTxtCostoPorKm() {
		return txtCostoPorKm;
	}

	public void setTxtCostoPorKm(JTextField txtCostoPorKm) {
		this.txtCostoPorKm = txtCostoPorKm;
	}

	public JLabel getLblCostoPorHora() {
		return lblCostoPorHora;
	}

	public void setLblCostoPorHora(JLabel lblCostoPorHora) {
		this.lblCostoPorHora = lblCostoPorHora;
	}

	public JTextField getTxtCostoPorHora() {
		return txtCostoPorHora;
	}

	public void setTxtCostoPorHora(JTextField txtCostoPorHora) {
		this.txtCostoPorHora = txtCostoPorHora;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}
	public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    };
}
