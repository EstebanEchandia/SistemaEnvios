package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.App;

public class PanelBuscarOrdenesCreadasDetallePedido extends JPanel {
	
	private JTable tblDetallePedido;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private JButton btnAtras = new JButton("Atras");
	
	public void armarPanel(App app,PanelBuscarOrdenesCreadas panel) {
		
		this.setLayout(null);
		this.setBackground(new Color(43,167,194));
		
		this.modeloTablaAtributos.addColumn("Id Item Pedido");
		this.modeloTablaAtributos.addColumn("Cantidad");
		this.modeloTablaAtributos.addColumn("Id Insumo");
		
	
		this.insertarElementosTabla();
		
		this.tblDetallePedido = new JTable(modeloTablaAtributos);
		this.tblDetallePedido.setBounds(120, 20, 630,430);
		
		this.scroll = new JScrollPane(this.tblDetallePedido);
		
		this.scroll.setBounds(120, 20, 630,400);
		this.add(scroll);
		
		this.btnAtras.setBounds(350, 430, 130, 30);
		this.add(btnAtras);
		
		this.btnAtras.addActionListener(e -> {
			app.setContentPane(panel);
			app.pack();
		});
		
		app.setContentPane(this);
		app.pack();
	}
	
	public void insertarElementosTabla() {
		
	}
}
