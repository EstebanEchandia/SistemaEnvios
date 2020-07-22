package gui;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCamionDarAlta extends JPanel {
	
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
	
	public void PanelCamionesDarAlta(){
	}
	
	public void armarPanel() {
		
		this.setBackground(Color.yellow);
		
		this.txtPatente = new JTextField(20);
		this.add(lblPatente);
		this.add(txtPatente);
		
		this.txtModelo = new JTextField(50);
		this.add(lblModelo);
		this.add(txtModelo);
		
		this.txtMarca = new JTextField(50);
		this.add(lblMarca);
		this.add(txtMarca);
		
		this.txtFechaCompra = new JFormattedTextField(80);
		this.add(lblFechaDeCompra);
		this.add(txtFechaCompra);
		
		this.txtKmRecorridos = new JTextField(30);		
		this.add(lblKmRecorridos);
		this.add(txtKmRecorridos);
		
		this.txtCostoPorKm = new JTextField(30);
		this.add(lblCostoPorKm);
		this.add(txtCostoPorKm);
		
		this.txtCostoPorHora = new JTextField(30);
		this.add(lblCostoPorHora);
		this.add(txtCostoPorHora);
		
		this.btnGuardar = new JButton("Guardar");
		this.add(btnGuardar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.add(btnCancelar);

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

	public JLabel getLblMarca() {
		return lblMarca;
	}

	public void setLblMarca(JLabel lblMarca) {
		this.lblMarca = lblMarca;
	}

	public JTextField getTxtMarca() {
		return txtMarca;
	}

	public void setTxtMarca(JTextField txtMarca) {
		this.txtMarca = txtMarca;
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

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
}
