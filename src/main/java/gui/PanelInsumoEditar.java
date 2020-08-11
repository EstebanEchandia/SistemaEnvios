package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.App;
import dominio.Insumo;
import enums.Unidad;
import gestor.GestorCamion;
import gestor.GestorInsumo;
import gestor.GestorPlanta;

public class PanelInsumoEditar extends JPanel {
	
	private JTable tblInsumos;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private JButton btnEditar;
	
	private GestorInsumo gestorInsumo = new GestorInsumo();
	
	private Object[] atributos = {-1,0,0,0,0,0};
	
	public void PanelInsumoEditar(){
	}
	
	public void armarPanel(App app) {
		
		this.setLayout(null);
		this.setBackground(Color.orange);
		
		this.modeloTablaAtributos.addColumn("id");
		this.modeloTablaAtributos.addColumn("Descripcion");
		this.modeloTablaAtributos.addColumn("Costo");
		this.modeloTablaAtributos.addColumn("Unidad de Medida");
		this.modeloTablaAtributos.addColumn("Peso");
		this.modeloTablaAtributos.addColumn("Densidad");
		
		
		this.mostrarTodosInsumos();	
		
		this.btnEditar = new JButton("Editar");
		this.btnEditar.setBounds(380, 410, 90, 40);
		this.add(btnEditar);
		
		
		this.tblInsumos = new JTable(modeloTablaAtributos);
		this.tblInsumos.setBounds(120, 20, 630,370);
		
		this.scroll = new JScrollPane(this.tblInsumos);
		this.scroll.setBounds(120, 20, 630,370);
		this.scroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Insumos"));
		this.scroll.setBackground(Color.orange);
		this.add(scroll);
		
		tblInsumos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) 
		    {
		       int fila = tblInsumos.rowAtPoint(e.getPoint());
		       int columna = tblInsumos.columnAtPoint(e.getPoint());
		      
				if ((fila > -1) && (columna > -1)) {
		       		atributos[0] = tblInsumos.getValueAt(fila,0);
					atributos[1] = tblInsumos.getValueAt(fila,1);
					atributos[2] = tblInsumos.getValueAt(fila,2);
					atributos[3] = tblInsumos.getValueAt(fila,3);
					atributos[4] = tblInsumos.getValueAt(fila,4);
					atributos[5] = tblInsumos.getValueAt(fila,5);
				}
				
				System.out.println((String)atributos[0] + atributos[1]);
		    
		    }
		 });
		
		btnEditar.addActionListener( e-> {
			if(atributos[0].equals(-1))
				JOptionPane.showMessageDialog(this,"Seleccione un insumo", "Error", JOptionPane.ERROR_MESSAGE);	
			else {
				PanelInsumoEditarEdicion panelEdicion = new PanelInsumoEditarEdicion();
				panelEdicion.armarPanel(app,this,atributos);
			}
				
		});
		
		
		app.setContentPane(this);
		app.pack();
		
	}
	
	public void mostrarTodosInsumos(){
			
			while(this.modeloTablaAtributos.getRowCount()>0) {
				this.modeloTablaAtributos.removeRow(0);
			}
			
			ArrayList<Insumo> listaInsumos = gestorInsumo.recuperarInsumoTodos();
			
			for(Insumo i: listaInsumos) {
				
				String[] p1 = i.listaAtributos();
				p1 = addElement(p1);
	
				this.modeloTablaAtributos.addRow(p1);
			}	
			
	
	
	}
	static String[] addElement(String []a) {
		return a;
	}
}
