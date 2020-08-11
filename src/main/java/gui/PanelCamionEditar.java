package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.App;
import dominio.Camion;
import gestor.GestorCamion;
import gestor.GestorPlanta;

public class PanelCamionEditar extends JPanel {
	
	private JTable tblCamiones;
	private DefaultTableModel modeloTablaAtributos;
	private JScrollPane scroll;
	
	private JButton btnEditar;
	
	private GestorPlanta gestorPlanta = new GestorPlanta();
	
	private GestorCamion gestorCamion = new GestorCamion();
	
	public void PanelAyuda(){
	}
	
	public void armarPanel(App app) {
		
		Object [] atributos = {-1,0,0,0,0,0,0};
		
		this.setLayout(null);
		
		this.setBackground(Color.yellow);
		
		this.modeloTablaAtributos = new DefaultTableModel();
		
		this.modeloTablaAtributos.addColumn("Id");
		this.modeloTablaAtributos.addColumn("Patente");
		this.modeloTablaAtributos.addColumn("Modelo");
		this.modeloTablaAtributos.addColumn("Fecha de compra");
		this.modeloTablaAtributos.addColumn("KMs recorridos");
		this.modeloTablaAtributos.addColumn("Costo por km");
		this.modeloTablaAtributos.addColumn("Costo por hora");
		
		this.mostrarTodosCamiones();// recuperar todos los camiones
			
		
		this.tblCamiones = new JTable(modeloTablaAtributos);
		this.tblCamiones.setBounds(120, 20, 630,300);
		
		this.scroll = new JScrollPane(this.tblCamiones);
		this.scroll.setBounds(120, 20, 630,300);
		this.scroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Camiones"));
		this.scroll.setBackground(Color.yellow);
		this.add(scroll);
		
		this.btnEditar = new JButton("Editar");
		this.btnEditar.setBounds(370, 400, 100, 40);
		this.add(btnEditar);
		
		
		tblCamiones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) 
		    {
		       int fila = tblCamiones.rowAtPoint(e.getPoint());
		       int columna = tblCamiones.columnAtPoint(e.getPoint());
		      
				if ((fila > -1) && (columna > -1)) {
		       		atributos[0] = tblCamiones.getValueAt(fila,0);
					atributos[1] = tblCamiones.getValueAt(fila,1);
					atributos[2] = tblCamiones.getValueAt(fila,2);
					atributos[3] = tblCamiones.getValueAt(fila,3);
					atributos[4] = tblCamiones.getValueAt(fila,4);
					atributos[5] = tblCamiones.getValueAt(fila,5);
					atributos[6] = tblCamiones.getValueAt(fila,6);
				}
				
				System.out.println((String)atributos[0] + atributos[1]+atributos[2] + atributos[3]+atributos[4] + atributos[5]+atributos[6]);
		    
		    }
		 });
		
		btnEditar.addActionListener( e-> {
			if(atributos[0].equals(-1))
				JOptionPane.showMessageDialog(this,"Seleccione un camion", "Error", JOptionPane.ERROR_MESSAGE);	
			else {
				PanelCamionEditarEdicion panelEdicion = new PanelCamionEditarEdicion();
				panelEdicion.armarPanel(app, atributos);
			}
				
		});
		
		
		app.setContentPane(this);
		app.revalidate();
		app.pack();
		
		

	}
	public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    };
    
	public void mostrarTodosCamiones(){
		
		while(this.modeloTablaAtributos.getRowCount()>0) {
			this.modeloTablaAtributos.removeRow(0);
		}
		
		ArrayList<Camion> listaCamiones = gestorCamion.recuperarCamionTodos();
		
		for(Camion c: listaCamiones) {
			String[] p1 = c.listaAtributos();
			this.modeloTablaAtributos.addRow(p1);
		}		
	}

}
