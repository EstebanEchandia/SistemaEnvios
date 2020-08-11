package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.App;
import dominio.Insumo;
import dominio.Planta;
import gestor.GestorInsumo;
import gestor.GestorPlanta;
import gestor.GestorStock;

public class PanelRegistroOrdenDePedido extends JPanel{
	/*
	 * Un usuario puede seleccionar una planta y registrar una orden de pedido donde se indique:
		• Planta a la que hay que enviar el pedido (la planta seleccionada)
		• Fecha máxima de entrega.
		• Una lista con los ítems del pedido. Por cada ítem se indica
				a. Insumo solicitado
				b. Cantidad (en la unidad de medida del insumo)
				c. El sistema automáticamente calculará el precio del item del pedido (precio del insumo * cantidad) y lo mostrará en pantalla.
		• Luego de registrar la orden la misma quedará en el sistema con el estado “CREADA”*/


	
	private JTable tblPlantas;
	private DefaultTableModel modeloTablaAtributos;
	private JScrollPane scroll;
	
	private JButton btnEditar;
	
	private GestorPlanta gestorPlanta = new GestorPlanta();
	
	private App app;
	
	public void armarPanel(App aux) {
		Object [] atributos = {-1,0};

		this.app = aux;
		
		this.setLayout(null);
		
		this.setBackground(new Color(43,167,194));
		
		this.modeloTablaAtributos = new DefaultTableModel();
		
		this.modeloTablaAtributos.addColumn("Id");
		this.modeloTablaAtributos.addColumn("Nombre");
		
		this.recuperarPlantasTodas();
		
		//this.modeloTablaAtributos.addRow(p1);
	
		
		this.tblPlantas = new JTable(modeloTablaAtributos);
		this.tblPlantas.setBounds(120, 20, 630,300);
		
		this.scroll = new JScrollPane(this.tblPlantas);
		this.scroll.setBounds(120, 20, 630,300);
		this.scroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Plantas"));
		this.scroll.setBackground(new Color(43,167,194));
		this.add(scroll);
		
		this.btnEditar = new JButton("Seleccionar Planta");
		this.btnEditar.setBounds(350, 390, 150, 30);
		this.add(btnEditar);
		
		
		tblPlantas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) 
		    {
		       int fila = tblPlantas.rowAtPoint(e.getPoint());
		       int columna = tblPlantas.columnAtPoint(e.getPoint());
		      
				if ((fila > -1) && (columna > -1)) {
		       		atributos[0] = tblPlantas.getValueAt(fila,0);
					atributos[1] = tblPlantas.getValueAt(fila,1);
				}
				
				System.out.println((String)atributos[0] + atributos[1]);
		    
		    }
		 });
		
		btnEditar.addActionListener( e-> {
			if(atributos[0].equals(-1))
				JOptionPane.showMessageDialog(this,"Seleccione una planta", "Error", JOptionPane.ERROR_MESSAGE);	
			else {
				PanelRegistroOrdenDePedidoIntermedio panel = new PanelRegistroOrdenDePedidoIntermedio();
				panel.crearPanel(aux,atributos);
			}
				
		});
		
		
		app.setContentPane(this);
		app.revalidate();
		app.pack();

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
