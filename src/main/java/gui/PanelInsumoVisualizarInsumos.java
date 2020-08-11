package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Insumo;
import gestor.GestorInsumo;
import gestor.GestorStock;

public class PanelInsumoVisualizarInsumos extends JPanel {
	
	private JTable tblInsumos;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	GestorInsumo gestorInsumo = new GestorInsumo();
	GestorStock gestorStock = new GestorStock();
	
	public void PanelInsumo(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.orange);
		

		this.modeloTablaAtributos.addColumn("id");
		this.modeloTablaAtributos.addColumn("Descripcion");
		this.modeloTablaAtributos.addColumn("Costo");
		this.modeloTablaAtributos.addColumn("Unidad de Medida");
		this.modeloTablaAtributos.addColumn("Peso");
		this.modeloTablaAtributos.addColumn("Densidad");
		this.modeloTablaAtributos.addColumn("Stock");
		
		
		this.mostrarTodosInsumos();	
		
		
		this.tblInsumos = new JTable(modeloTablaAtributos);
		this.tblInsumos.setBounds(120, 20, 630,430);
		
		this.scroll = new JScrollPane(this.tblInsumos);
		
		this.scroll.setBounds(120, 20, 630,430);
		this.add(scroll);


	}
	
	public void mostrarTodosInsumos(){
		
		while(this.modeloTablaAtributos.getRowCount()>0) {
			this.modeloTablaAtributos.removeRow(0);
		}
		
		ArrayList<Insumo> listaInsumos = gestorInsumo.recuperarInsumoTodos();
		
		for(Insumo i: listaInsumos) {
			
			String[] p1 = i.listaAtributos();
			p1 = addElement(p1, gestorStock.getStockDeUnInsumo(i.getId()));

			this.modeloTablaAtributos.addRow(p1);
		}	
		
		
	}
	
	static String[] addElement(String []a, Integer e) {
		a = Arrays.copyOf(a, a.length+1);
		a[a.length - 1 ] = e.toString();
		return a;
	}
}
