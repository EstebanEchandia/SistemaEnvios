package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.App;
import gestor.GestorPedido;

public class PanelBuscarOrdenesCreadas extends JPanel{
	/* 
	 * Ver el detalle de la orden.
		• Ver todas las plantas donde hay disponible STOCK de los ítems solicitados. Si no existe una planta que tenga disponible stock de todos los productos se mostrará un mensaje de error y el pedido pasa a estado CANCELADO
		• De cada una de las posibles plantas se debe calcular y visualizar las posibles rutas siguiendo 2 alternativas:
				o La más corta en KM
				o La más rápida en Tiempo
		• Si hay más de una ruta con la misma duración o distancia se visualizarán todas y el usuario debe seleccionar 1 de estas rutas para asignársela al pedido.
		• Automáticamente el pedido queda asociado a este envío, que se realizará siguiente esta ruta.
		• Al pedido se le asigna automáticamente el primer camión disponible de la cola de prioridad de camiones disponibles. (los camiones se almacenan en memoria en una cola de prioridad, y se asigna aquel que tenga la menor cantidad de KM recorridos). Un camión a su vez está disponible si no está asignado a ninguna orden de pedido que esté en estado “PROCESADA”
		• Cada vez que se asigna un camión a un pedido, se actualizan la cantidad de km recorridos del camión.
		• El detalle del envío calcula el costo de envío sumando:
				o Costo por KM del camión asignado por cantidad de KM a recorrer
				o Costo por HORA del camión asignado por cantidad de horas que lleva el recorrido.
*/
	
	private JTable tblOrdenesCreadas;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private Object [] atributos = {-1,0,0,0,0,0,0};
	
	private JButton btnDetalleOrden = new JButton("Detalle de orden");
	private JButton btnVerPlantasConStock = new JButton("Ver plantas con stock");
	
	private GestorPedido gestorPedido = new GestorPedido();
	
	ArrayList<ArrayList<String>> tabla = gestorPedido.buscarPedidosCreados();
	
	public void armarPanel(App app) {
		
		this.setLayout(null);
		this.setBackground(new Color(43,167,194));
		
		this.modeloTablaAtributos.addColumn("Numero de Orden");
		this.modeloTablaAtributos.addColumn("Fecha Solicitud");
		this.modeloTablaAtributos.addColumn("Fecha Entrega");
		this.modeloTablaAtributos.addColumn("Estado");
		this.modeloTablaAtributos.addColumn("Planta Destino");
		this.modeloTablaAtributos.addColumn("Planta Origen");
		this.modeloTablaAtributos.addColumn("Envio");
		
	
		
		this.armarTabla();
		
		this.tblOrdenesCreadas = new JTable(modeloTablaAtributos);
		this.tblOrdenesCreadas.setBounds(120, 20, 630,430);
		
		this.scroll = new JScrollPane(this.tblOrdenesCreadas);
		
		this.scroll.setBounds(120, 20, 630,400);
		this.add(scroll);
		
		this.btnDetalleOrden.setBounds(280, 430, 130, 30);
		this.btnVerPlantasConStock.setBounds(430, 430, 160, 30);
		this.add(btnDetalleOrden);
		this.add(btnVerPlantasConStock);
		
		this.btnDetalleOrden.addActionListener( e-> {
			if(atributos[0].equals(-1))
				JOptionPane.showMessageDialog(this,"Seleccione un pedido", "Error", JOptionPane.ERROR_MESSAGE);	
			else {
				PanelBuscarOrdenesCreadasDetallePedido panel = new PanelBuscarOrdenesCreadasDetallePedido();
				panel.armarPanel(app, this,Integer.parseInt((String) atributos[0]));
			}
		});
		
		this.btnVerPlantasConStock.addActionListener( e-> {
			if(atributos[0].equals(-1))
				JOptionPane.showMessageDialog(this,"Seleccione un pedido", "Error", JOptionPane.ERROR_MESSAGE);	
			else {
				PanelBuscarOrdenesCreadasVerPlantasConStock panelPlantasConStock = new PanelBuscarOrdenesCreadasVerPlantasConStock();
				panelPlantasConStock.armarPanel(app,atributos);
			}
		});
		
		this.tblOrdenesCreadas.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) 
			    {
			       int fila = tblOrdenesCreadas.rowAtPoint(e.getPoint());
			       int columna = tblOrdenesCreadas.columnAtPoint(e.getPoint());
			      
					if ((fila > -1) && (columna > -1)) {
						atributos[0] = tblOrdenesCreadas.getValueAt(fila,0);
						atributos[1] = tblOrdenesCreadas.getValueAt(fila,1);
						atributos[2] = tblOrdenesCreadas.getValueAt(fila,2);
						atributos[3] = tblOrdenesCreadas.getValueAt(fila,3);
						atributos[4] = tblOrdenesCreadas.getValueAt(fila,4);
						atributos[5] = tblOrdenesCreadas.getValueAt(fila,5);
						atributos[6] = tblOrdenesCreadas.getValueAt(fila,6);
					}
					
					System.out.println((String)atributos[0] + atributos[1]+ atributos[2]);
			    
			    }
			 });
		
		app.setContentPane(this);
		app.revalidate();
		app.pack();
		
	}
	
	public void armarTabla() {
		for(ArrayList<String> fila:  tabla ){			
				modeloTablaAtributos.addRow(fila.toArray());	
		}

	}
}
