package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.App;

public class PanelPlantasVisualizarPlantas extends JPanel {
	
	private JTable tblPlantas;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private JButton btnDetalleOrden = new JButton("Detalle de orden");
	private JButton btnVerPlantasConStock = new JButton("Ver plantas con stock");

	public void armarPanel(App app) {
		
		this.setLayout(null);
		this.setBackground(new Color(81,232,60));
		
		this.modeloTablaAtributos.addColumn("Nombre Planta");
		this.modeloTablaAtributos.addColumn("Nombre Insumo");
		this.modeloTablaAtributos.addColumn("Stock en la Planta");
		this.modeloTablaAtributos.addColumn("Pto de Pedido");
		this.modeloTablaAtributos.addColumn("Stock en la Empresa");

		this.tblPlantas = new JTable(modeloTablaAtributos);
		this.tblPlantas.setBounds(120, 20, 630,430);
		
		this.scroll = new JScrollPane(this.tblPlantas);
		
		this.scroll.setBounds(120, 20, 630,400);
		this.add(scroll);
		
		this.btnDetalleOrden.setBounds(280, 430, 130, 30);
		this.btnVerPlantasConStock.setBounds(430, 430, 160, 30);
		this.add(btnDetalleOrden);
		this.add(btnVerPlantasConStock);
		
		app.setContentPane(this);
		app.pack();
	}
}
