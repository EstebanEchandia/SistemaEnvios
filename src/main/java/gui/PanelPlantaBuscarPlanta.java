package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Planta;
import gestor.GestorPlanta;

public class PanelPlantaBuscarPlanta extends JPanel {
	
	private JTable tblPlantas;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private JButton btnEditar;
	
	private GestorPlanta gestorPlanta = new GestorPlanta();
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.orange);
		
		this.modeloTablaAtributos.addColumn("Id");
		this.modeloTablaAtributos.addColumn("Nombre");
		
		this.recuperarPlantasTodas();
		
		//this.modeloTablaAtributos.addRow(p1);
	
		
		this.tblPlantas = new JTable(modeloTablaAtributos);
		this.tblPlantas.setBounds(120, 20, 630,300);
		
		this.scroll = new JScrollPane(this.tblPlantas);
		
		this.scroll.setBounds(120, 20, 630,300);
		this.add(scroll);
		
		this.btnEditar = new JButton("Editar");
		this.btnEditar.setBounds(370, 400, 100, 40);
		this.add(btnEditar);

	}
	
	public void recuperarPlantasTodas(){
		
		while(this.modeloTablaAtributos.getRowCount()>0) {
			this.modeloTablaAtributos.removeRow(0);
		}
		
		ArrayList<Planta> listaPlantas = gestorPlanta.recuperarPlantasTodas();
		
		for(Planta p: listaPlantas) {
			String[] p1 = p.listaAtributos();
			this.modeloTablaAtributos.addRow(p1);
		}		
	}
}
