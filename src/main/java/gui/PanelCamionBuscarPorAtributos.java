package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dominio.Camion;
import gestor.GestorCamion;

public class PanelCamionBuscarPorAtributos extends JPanel {
	
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
	private JButton btnMostrarTodos;
	
	private GestorCamion gestorCamion = new GestorCamion();
	
	private JTable tblAtributos;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	
	private JScrollPane scroll;
	
	private JLabel imagenCamion;
	
	public void PanelCamionBuscarPorAtributos(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.yellow);
		
		this.txtId = new JTextField(20);
		this.txtId.setBounds(30, 20, 100,20);
		this.lblId.setBounds(10,20,100,20);
		this.add(lblId);
		this.add(txtId);
		
		this.txtPatente = new JTextField(20);
		this.txtPatente.setBounds(60, 50, 100,20);
		this.lblPatente.setBounds(10,50,100,20);
		this.add(lblPatente);
		this.add(txtPatente);
		
		this.txtModelo = new JTextField(50);
		this.txtModelo.setBounds(60, 80, 100, 20);
		this.lblModelo.setBounds(10, 80, 100, 20);
		this.add(lblModelo);
		this.add(txtModelo);
		
		this.txtFechaCompra = new JFormattedTextField();
		this.txtFechaCompra.setBounds(130, 110, 100, 20);
		this.lblFechaDeCompra.setBounds(10, 110, 120, 20);
		this.add(lblFechaDeCompra);
		this.add(txtFechaCompra);
		
		this.txtKmRecorridos = new JTextField(30);
		this.txtKmRecorridos.setBounds(130, 140, 100, 20);
		this.lblKmRecorridos.setBounds(10, 140, 100, 20);
		this.add(lblKmRecorridos);
		this.add(txtKmRecorridos);
		
		this.txtCostoPorKm = new JTextField(30);
		this.txtCostoPorKm.setBounds(130, 170, 100, 20);
		this.lblCostoPorKm.setBounds(10, 170, 100, 20);
		this.add(lblCostoPorKm);
		this.add(txtCostoPorKm);  
		
		this.txtCostoPorHora = new JTextField(30);
		this.txtCostoPorHora.setBounds(130, 200, 100, 20);
		this.lblCostoPorHora.setBounds(10, 200, 100, 20);
		this.add(lblCostoPorHora);
		this.add(txtCostoPorHora);
		
		this.btnMostrarTodos = new JButton("Mostrar todos");
		this.btnMostrarTodos.setBounds(410, 400, 120, 40);
		this.add(btnMostrarTodos);
		
		this.btnGuardar = new JButton("Buscar");

		this.btnGuardar.setBounds(300, 400, 100, 40);

		this.btnGuardar.setBounds(370, 400, 100, 40);
		

		this.btnGuardar.addActionListener(e -> this.buscarCamion());

		this.add(btnGuardar);

		this.modeloTablaAtributos.addColumn("Id");
		this.modeloTablaAtributos.addColumn("Patente");
		this.modeloTablaAtributos.addColumn("Modelo");
		this.modeloTablaAtributos.addColumn("Fecha de compra");
		this.modeloTablaAtributos.addColumn("KMs recorridos");
		this.modeloTablaAtributos.addColumn("Costo por km");
		this.modeloTablaAtributos.addColumn("Costo por hora");
		
	
		
		
		this.tblAtributos = new JTable(modeloTablaAtributos);
		this.tblAtributos.setBounds(280, 20, 550,300);
		
		this.scroll = new JScrollPane(this.tblAtributos);
		
		this.scroll.setBounds(280, 20, 550,300);
		this.add(scroll);
		

		
		this.imagenCamion = new JLabel();
		this.imagenCamion.setBounds(60,300,140,140);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/camion.png"));	
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(140,140,Image.SCALE_SMOOTH)); 
		this.imagenCamion.setIcon(icono);
		this.add(imagenCamion);

	}
	
	
	public void mostrarTodosCamiones(){
		
		while(this.modeloTablaAtributos.getRowCount()>0) {
			this.modeloTablaAtributos.removeRow(0);
		}
		
		ArrayList<Camion> listaCamiones = gestorCamion.recuperarCamionTodos();
		
		for(Camion c: listaCamiones) {
			String[] p1 = c.listaAtributos();
			this.modeloTablaAtributos.addRow(p1);
		}	
		
		
	}
	
	public void buscarCamion() {
		
		Camion c = gestorCamion.recuperarCamionPatente(this.getTxtPatente().getText());
		String[] p1 = c.listaAtributos();
		this.modeloTablaAtributos.addRow(p1);
		
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