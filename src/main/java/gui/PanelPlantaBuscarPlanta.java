package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelPlantaBuscarPlanta extends JPanel {
	
	private JTable tblPlantas;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private JButton btnEditar;
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.orange);
		
		this.modeloTablaAtributos.addColumn("Id");
		this.modeloTablaAtributos.addColumn("Nombre");
		
		//this.modeloTablaAtributos.addRow(p1);
	
		
		this.tblPlantas = new JTable(modeloTablaAtributos);
		this.tblPlantas.setBounds(120, 20, 630,430);
		
		this.scroll = new JScrollPane(this.tblPlantas);
		
		this.scroll.setBounds(120, 20, 630,430);
		this.add(scroll);
		
		this.btnEditar = new JButton("Editar");
		this.btnEditar.setBounds(370, 400, 100, 40);
		this.add(btnEditar);

	}
}
