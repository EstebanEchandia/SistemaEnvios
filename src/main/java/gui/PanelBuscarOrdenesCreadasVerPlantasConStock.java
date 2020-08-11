package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.App;

public class PanelBuscarOrdenesCreadasVerPlantasConStock extends JPanel {
	
	private JTable tblPlantas;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private Object [] atributos = {-1,0};
	
	
	
	public void armarPanel(App app,Object[] atributos) {
		
this.setLayout(null);
		
		this.setBackground(new Color(81,232,60));
		
		this.modeloTablaAtributos = new DefaultTableModel();
		
		this.modeloTablaAtributos.addColumn("Id");
		this.modeloTablaAtributos.addColumn("Nombre");
		
		this.recuperarPlantasConStock();
	
		
		this.tblPlantas = new JTable(modeloTablaAtributos);
		this.tblPlantas.setBounds(120, 20, 630,300);
		
		this.scroll = new JScrollPane(this.tblPlantas);
		
		this.scroll.setBounds(120, 20, 630,300);
		this.add(scroll);
		
		
		
		
		
		this.tblPlantas.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) 
			    {
			       int fila = tblPlantas.rowAtPoint(e.getPoint());
			       int columna = tblPlantas.columnAtPoint(e.getPoint());
			      
					if ((fila > -1) && (columna > -1)) {
						atributos[0] = tblPlantas.getValueAt(fila,0);
						atributos[1] = tblPlantas.getValueAt(fila,1);
					}
					
					System.out.println((String)atributos[0] + atributos[1]+ atributos[2]);
			    
			    }
			 });
		
	}



	private void recuperarPlantasConStock() {
		
	}

}
