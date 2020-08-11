package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.App;
import gestor.GestorPlanta;

public class PanelPlantasVisualizarPlantas extends JPanel {
	
	private JTable tblPlantas;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private GestorPlanta gp = new GestorPlanta();
	private ArrayList<ArrayList<String>> tabla = gp.recuperarPlantasConInsumoMenorAlPtoPedido();

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
		this.scroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Plantas con algun stock menor al punto de pedido"));
		this.scroll.setBackground(new Color(81,232,60));
		this.add(scroll);
		this.armarTabla();

		
		app.setContentPane(this);
		app.pack();
	}
	
	public void armarTabla() {
		for(ArrayList<String> fila:  tabla ){			
				modeloTablaAtributos.addRow(fila.toArray());	
		}

	}
}
