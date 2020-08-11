package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.App;
import dominio.Planta;
import gestor.GestorPedido;
import gestor.GestorPlanta;

public class PanelBuscarOrdenesCreadasVerPlantasConStock extends JPanel {
	
	private JTable tblPlantas;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private Object [] atributos = {-1,0};
	
	private GestorPlanta gestorPlanta = new GestorPlanta();
	
	private GestorPedido gestorPedido = new GestorPedido();
	
	private JButton btnAtras = new JButton("Atras");
	
	private ArrayList<Planta> todasLasPlantasConStock;
	
	
	
	
	public void armarPanel(App app,Object[] atributos, ArrayList<Planta> plantas) {
		
		this.setLayout(null);
		this.setBackground(new Color(43,167,194));
		
		this.todasLasPlantasConStock = plantas;
		
		this.modeloTablaAtributos = new DefaultTableModel();
		
		this.modeloTablaAtributos.addColumn("Id");
		this.modeloTablaAtributos.addColumn("Nombre");
		
		this.recuperarPlantasConStock();
		
	
		
		this.tblPlantas = new JTable(modeloTablaAtributos);
		this.tblPlantas.setBounds(120, 20, 630,300);
		
		this.scroll = new JScrollPane(this.tblPlantas);
		
		this.scroll.setBounds(120, 20, 630,300);
		this.add(scroll);
		
		this.btnAtras.setBounds(350, 430, 130, 30);
		this.btnAtras.addActionListener(e->{
			PanelBuscarOrdenesCreadas panel = new PanelBuscarOrdenesCreadas();
			panel.armarPanel(app);
		});
		this.add(btnAtras);
		
		this.tblPlantas.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) 
			    {
			       int fila = tblPlantas.rowAtPoint(e.getPoint());
			       int columna = tblPlantas.columnAtPoint(e.getPoint());
			      
					if ((fila > -1) && (columna > -1)) {
						atributos[0] = tblPlantas.getValueAt(fila,0);
						atributos[1] = tblPlantas.getValueAt(fila,1);
					}			    
			    }
			 });
		
		
		
		app.setContentPane(this);
		app.pack();
		
		if(tblPlantas.getRowCount() == 0) {
			PanelBuscarOrdenesCreadas panel = new PanelBuscarOrdenesCreadas();
			panel.armarPanel(app);
		}
		
		
		
		
	}



	private void recuperarPlantasConStock() {
		while(this.modeloTablaAtributos.getRowCount()>0) {
			this.modeloTablaAtributos.removeRow(0);
		}
		
		ArrayList<Planta> listaPlantas = this.todasLasPlantasConStock;
		
		for(Planta p: listaPlantas) {
			String[] p1 = p.listaAtributos();
			this.modeloTablaAtributos.addRow(p1);
		}		
	}
	
	

}
