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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.App;
import dominio.Pedido;
import enums.EstadoPedido;
import gestor.GestorPedido;

public class PanelBuscarOrdenesProcesadas extends JPanel {
	
	/*Un usuario puede ingresar a una pantalla donde busque todas las ordenes en estado “PROCESDA”
	  y seleccionarlas y marcarlas como entregadas*/
	
	private JTable tblOrdenesProcesadas;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private JButton btnMarcarComoEntregada = new JButton("Marcar como entregada");
	
	private Object [] atributos = {-1,0,0,0,0,0,0};
	
	private GestorPedido gestorPedido = new GestorPedido();
	
	ArrayList<ArrayList<String>> tabla = gestorPedido.buscarPedidosProcesados();
	
	int fila;
	int columna;
	
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
		
		this.tblOrdenesProcesadas = new JTable(modeloTablaAtributos);
		this.tblOrdenesProcesadas.setBounds(120, 20, 630,430);
		
		this.scroll = new JScrollPane(this.tblOrdenesProcesadas);
		
		this.scroll.setBounds(120, 20, 630,400);
		this.add(scroll);
		
		this.btnMarcarComoEntregada.setBounds(340,450,180,20);
		this.add(btnMarcarComoEntregada);
		
		this.btnMarcarComoEntregada.addActionListener( e-> {
			if(atributos[0].equals(-1))
				JOptionPane.showMessageDialog(this,"Seleccione un pedido", "Error", JOptionPane.ERROR_MESSAGE);	
			else {
				gestorPedido.modificarEstadoPedido(new Pedido(Integer.parseInt((String)atributos[0])), EstadoPedido.ENTREGADA);
				this.modeloTablaAtributos.removeRow(fila);
			}
		});
		
		this.tblOrdenesProcesadas.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) 
			    {
			       fila = tblOrdenesProcesadas.rowAtPoint(e.getPoint());
			       columna = tblOrdenesProcesadas.columnAtPoint(e.getPoint());
			      
					if ((fila > -1) && (columna > -1)) {
						atributos[0] = tblOrdenesProcesadas.getValueAt(fila,0);
						atributos[1] = tblOrdenesProcesadas.getValueAt(fila,1);
						atributos[2] = tblOrdenesProcesadas.getValueAt(fila,2);
						atributos[3] = tblOrdenesProcesadas.getValueAt(fila,3);
						atributos[4] = tblOrdenesProcesadas.getValueAt(fila,4);
						atributos[5] = tblOrdenesProcesadas.getValueAt(fila,5);
						atributos[6] = tblOrdenesProcesadas.getValueAt(fila,6);
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
