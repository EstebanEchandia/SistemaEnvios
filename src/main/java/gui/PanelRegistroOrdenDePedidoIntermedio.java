package gui;

import java.awt.Color;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.App;
import dominio.ItemPedido;
import gestor.GestorItemPedido;
import gestor.GestorPedido;

public class PanelRegistroOrdenDePedidoIntermedio extends JPanel {
	
	private JLabel lblIdPlanta = new JLabel("Planta a enviar pedido:");
	private JTextField txtIdPlanta;
	
	private JLabel lblFechaMaxEntrega = new JLabel("Fecha max entrega:");
	private JTextField txtFechaMaxEntrega = new JTextField(20);
	
	private JLabel lblListaItemsPedido = new JLabel("Lista con Items pedido");
	
	private JLabel lblInsumo = new JLabel("Insumo:");
	private JTextField txtInsumo = new JTextField(20);
	
	private JLabel lblCantidad = new JLabel("Cantidad:");
	private JTextField txtCantidad = new JTextField(20);
	
	private JLabel lblPrecio = new JLabel("Precio:");
	private JTextField txtPrecio = new JTextField(20);
	
	private JTable tblInsumos;
	private DefaultTableModel modeloTablaAtributos;
	private JScrollPane scroll;
	
	
	private JButton btnGuardar = new JButton("Guardar");
	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnEliminarItems = new JButton("Eliminar Items");
	
	private GestorPedido gestorPedido = new GestorPedido();
	private GestorItemPedido gestorItemPedido = new GestorItemPedido();


	public void crearPanel(App app, Object [] atributos) {
		
		
		this.setBounds(0, 0, 900, 560);
		this.setOpaque(true);
		this.setLayout(null);
		this.setBackground(new Color(43,167,194));
		
		
		this.txtIdPlanta = new JTextField((String)atributos[0]);
		
		this.txtIdPlanta.setBounds(150, 50, 100, 20);
		this.lblIdPlanta.setBounds(10, 50, 140, 20);
		this.add(txtIdPlanta);
		this.add(lblIdPlanta);
		
		this.txtFechaMaxEntrega.setBounds(140, 80, 100, 20);
		this.lblFechaMaxEntrega.setBounds(10, 80, 130, 20);
		this.add(txtFechaMaxEntrega);
		this.add(lblFechaMaxEntrega);
		
		this.lblListaItemsPedido.setBounds(10, 110, 150, 20);
		this.add(lblListaItemsPedido);
		
		
		this.btnGuardar.setBounds(290, 400, 120, 40);
		this.btnGuardar.addActionListener( e -> cargarDatos());
		
		this.add(btnGuardar);
		
		this.btnCancelar.setBounds(420, 400, 120, 40);
		
		this.btnCancelar.addActionListener(e -> {
			PanelRegistroOrdenDePedido panelRegistroDePedido = new PanelRegistroOrdenDePedido();
			panelRegistroDePedido.armarPanel(app);
		});
		this.add(btnCancelar);
		
		this.btnEliminarItems.setBounds(80, 380, 130, 20);
		this.btnEliminarItems.addActionListener(e -> this.eliminarItems());
		this.add(btnEliminarItems);
		
		this.lblIdPlanta.setEnabled(true);
		this.txtIdPlanta.setEnabled(false);
		
		/* Hacemos la tabla */
		this.modeloTablaAtributos = new DefaultTableModel();
		
		this.modeloTablaAtributos.addColumn("Insumo");
		this.modeloTablaAtributos.addColumn("Cantidad");
		this.modeloTablaAtributos.addColumn("Precio");
		
		
		
		this.tblInsumos = new JTable(modeloTablaAtributos);
		this.tblInsumos.setBounds(30, 150, 200,200);
		
		this.scroll = new JScrollPane(tblInsumos);
		
		this.scroll.setBounds(30, 150, 230,230);
		this.add(scroll);
		
		
		
		/*----------------*/
		
		/*  Panel para agregar Insumos  */
		
		PanelRegistroOrdenDePedidoTodosInsumos panelAgregarInsumos = new PanelRegistroOrdenDePedidoTodosInsumos();
		panelAgregarInsumos.armarPanel(this);
		panelAgregarInsumos.setBounds(400,10,400, 340);
		
		this.add(panelAgregarInsumos);
	
		
		/*------------------------------*/
		
		app.setContentPane(this);
		app.pack();
	}
	
	public void cargarDatos() {
		
		Integer nroOrden = gestorPedido.altaPedido(LocalDate.parse(this.getTxtFechaMaxEntrega().getText()), Integer.parseInt(this.getTxtIdPlanta().getText()));
		
		while(this.modeloTablaAtributos.getRowCount()>0) {
			Double cantidad = Double.parseDouble((String) this.tblInsumos.getValueAt(0,1));
			Integer idInsumo = Integer.parseInt((String) this.tblInsumos.getValueAt(0,0));
			
			gestorItemPedido.altaItemPedido(cantidad, nroOrden, idInsumo);
			
			this.modeloTablaAtributos.removeRow(0);
		}
		
		
	}
	
	public JTextField getTxtIdPlanta() {
		return txtIdPlanta;
	}

	public void setTxtIdPlanta(JTextField txtIdPlanta) {
		this.txtIdPlanta = txtIdPlanta;
	}

	public JTextField getTxtFechaMaxEntrega() {
		return txtFechaMaxEntrega;
	}

	public void setTxtFechaMaxEntrega(JTextField txtFechaMaxEntrega) {
		this.txtFechaMaxEntrega = txtFechaMaxEntrega;
	}

	public JTextField getTxtInsumo() {
		return txtInsumo;
	}

	public void setTxtInsumo(JTextField txtInsumo) {
		this.txtInsumo = txtInsumo;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(JTextField txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public void setTxtPrecio(JTextField txtPrecio) {
		this.txtPrecio = txtPrecio;
	}

	public void addFila(String [] a) {
		this.modeloTablaAtributos.addRow(a);
	}
	public void eliminarItems() {
		while(this.modeloTablaAtributos.getRowCount()>0) {
			this.modeloTablaAtributos.removeRow(0);
		}
	}
}
