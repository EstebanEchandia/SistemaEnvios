package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelInsumoVisualizarInsumos extends JPanel {
	
	private JTable tblInsumos;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	
	
	public void PanelInsumo(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.orange);
		
		
		this.modeloTablaAtributos.addColumn("Descripcion");
		this.modeloTablaAtributos.addColumn("Unidad de Medida");
		this.modeloTablaAtributos.addColumn("Costo");
		this.modeloTablaAtributos.addColumn("Peso");
		this.modeloTablaAtributos.addColumn("Densidad");
		this.modeloTablaAtributos.addColumn("Stock");
		
		String[] p1 = {"Carton duro","cm3","13","50","","10"};
		String[] p2 = {"Tornillo Phillips","cm","5","3","","600"};
		String[] p3 = {"Tornillo tipo Allen","cm","6","4","","465"};
		
		this.modeloTablaAtributos.addRow(p1);
		this.modeloTablaAtributos.addRow(p2);
		this.modeloTablaAtributos.addRow(p3);		
		
		this.tblInsumos = new JTable(modeloTablaAtributos);
		this.tblInsumos.setBounds(120, 20, 630,430);
		
		this.scroll = new JScrollPane(this.tblInsumos);
		
		this.scroll.setBounds(120, 20, 630,430);
		this.add(scroll);


	}
}
