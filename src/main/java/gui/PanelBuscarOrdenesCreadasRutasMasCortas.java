package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import app.App;
import dominio.Camion;
import dominio.GrafoPlantasDistancia;
import dominio.GrafoPlantasDuracion;
import dominio.ItemPedido;
import dominio.Planta;
import dominio.Ruta;
import estructuras.Vertice;
import gestor.GestorPedido;
import gestor.GestorPlanta;

public class PanelBuscarOrdenesCreadasRutasMasCortas extends JPanel {

	private JTable tblRutas;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private Object [] atributos = {-1};
	
	private JButton btnSeleccionar = new JButton("Seleccionar");
	private JButton btnCancelar = new JButton("Cancelar");
	
	private JComboBox cmbElegirRuta = new JComboBox();
	
	private GestorPedido gestorPedido = new GestorPedido();
	
	private GestorPlanta gestorPlanta = new GestorPlanta();
	
	private GrafoPlantasDistancia grafoPlantasDistancias = new GrafoPlantasDistancia();
	//private GrafoPlantasDuracion grafoPlantasDuracion = new GrafoPlantasDuracion();
	
	private int fila;
	private int columna;
	
	private int cantidadOpciones=3;
	
	private JTextArea txtExplicacion = new JTextArea("Para elegir el trayecto debera seleccionar una a travez de la lista desplegable.\n En la tabla se muestran las siglas de todas las rutas del trayecto.");
	
	public void armarPanel(App app,PanelBuscarOrdenesCreadasVerPlantasConStock panel,Object idPlantaDestino,Object idPlantaOrigen){
		
		this.setLayout(null);
		this.setBackground(new Color(43,167,194));
		
		this.modeloTablaAtributos.addColumn("Sigla");
			
		this.tblRutas = new JTable(modeloTablaAtributos);
		this.tblRutas.setBounds(120, 20, 50,430);
		
		this.scroll = new JScrollPane(this.tblRutas);
		
		this.scroll.setBounds(600, 40, 80,240);
		this.add(scroll);
		
		this.scroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Rutas"));
		this.scroll.setBackground(new Color(43,167,194));
		
		this.cmbElegirRuta.setBounds(450,40,120,20);
		this.add(cmbElegirRuta);
		
		this.txtExplicacion.setBounds(30,60,250,200);
		this.txtExplicacion.setFont(new Font("Serif", Font.BOLD, 16));
		this.txtExplicacion.setLineWrap(true);
		this.txtExplicacion.setWrapStyleWord(true);
		this.txtExplicacion.setOpaque(false);
		this.txtExplicacion.setEditable(false);
		this.add(txtExplicacion);
		
		for(int i=0;i<cantidadOpciones;i++) {
			this.cmbElegirRuta.addItem(i+1);
		}
		
		this.cmbElegirRuta.addActionListener(e->{
			
		});
		
		this.btnSeleccionar.setBounds(280, 430, 120, 30);
		this.btnCancelar.setBounds(430, 430, 90, 30);
		this.add(btnSeleccionar);
		this.add(btnCancelar);
		
		this.btnCancelar.addActionListener( e-> {
				app.setContentPane(panel);
				app.pack();

		});
		
		this.btnSeleccionar.addActionListener( e-> {
			if(atributos[0].equals(-1))
				JOptionPane.showMessageDialog(this,"Seleccione una ruta", "Error", JOptionPane.ERROR_MESSAGE);	
			else {

			}
		});
		
		this.tblRutas.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) 
			    {
			       fila = tblRutas.rowAtPoint(e.getPoint());
			       columna = tblRutas.columnAtPoint(e.getPoint());
			      
					if ((fila > -1) && (columna > -1)) {
						atributos[0] = tblRutas.getValueAt(fila,0);
						atributos[1] = tblRutas.getValueAt(fila,1);
					}		    
			    }
			 });
		
		
		refrescarTabla(Integer.parseInt((String) idPlantaOrigen) , Integer.parseInt((String) idPlantaDestino) );
		
		app.setContentPane(this);
		app.revalidate();
		app.pack();
		
	}
	
	public void refrescarTabla(Integer idOrigen, Integer idDestino) {

		while(this.modeloTablaAtributos.getRowCount()>0) {
			this.modeloTablaAtributos.removeRow(0);
		}
		
		LinkedList<Vertice> res = this.grafoPlantasDistancias.aplicarDijkstra(idOrigen, idDestino);
		System.out.println(res);

		for(Vertice<Planta> v: res) {
			String[] p1 = {v.getValor().getNombre()};
			this.modeloTablaAtributos.addRow(p1);
		}		
		
		
	}
}
