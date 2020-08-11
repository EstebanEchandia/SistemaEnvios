package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.App;
import dominio.Insumo;
import gestor.GestorInsumo;
import gestor.GestorStock;

public class PanelRegistroOrdenDePedidoTodosInsumos extends JPanel {
	
	private JPanel panelAgregarInsumos = new JPanel();
	
	private  JTable tblTodosInsumos;
	private  DefaultTableModel modeloTablaTodosInsumos;
	private  JScrollPane scrollTodosInsumos;
	
	private  JButton btnAgregar = new JButton("Agregar");
	
	private  GestorInsumo gestorInsumo = new GestorInsumo();
	private  GestorStock gestorStock = new GestorStock();
	
	private int cantidad;
	
	private  Object [] atributosInsumo = {-1,0,0,0,0,0,0,0};
	
	public void armarPanel(PanelRegistroOrdenDePedidoIntermedio panel) {
		
		this.setPreferredSize(new Dimension(400, 340));
		this.setOpaque(true);
		this.setLayout(null);
		this.setBackground(new Color(100,167,194));
		
		this.modeloTablaTodosInsumos = new DefaultTableModel();
		
		this.modeloTablaTodosInsumos.addColumn("id");
		this.modeloTablaTodosInsumos.addColumn("Descripcion");
		this.modeloTablaTodosInsumos.addColumn("Costo");
		this.modeloTablaTodosInsumos.addColumn("Unidad de Medida");
		this.modeloTablaTodosInsumos.addColumn("Peso");
		this.modeloTablaTodosInsumos.addColumn("Densidad");
		this.modeloTablaTodosInsumos.addColumn("Stock");
		
		
		this.recuperarInsumosTodos();
			
		
		this.tblTodosInsumos = new JTable(modeloTablaTodosInsumos);
		this.tblTodosInsumos.setBounds(10, 10, 380,250);
		
		this.scrollTodosInsumos = new JScrollPane(tblTodosInsumos);
		this.scrollTodosInsumos.setBounds(10, 10, 380,250);
		this.scrollTodosInsumos.setBorder(javax.swing.BorderFactory.createTitledBorder("Todos los insumos"));
		this.scrollTodosInsumos.setBackground(new Color(100,167,194));
		this.add(scrollTodosInsumos);
		
		this.btnAgregar.setBounds(155, 280, 90, 30);
		this.add(btnAgregar);
		
		this.tblTodosInsumos.addMouseListener(new MouseAdapter() {
			
		public void mouseClicked(MouseEvent e) 
		    {
		       int fila = tblTodosInsumos.rowAtPoint(e.getPoint());
		       int columna = tblTodosInsumos.columnAtPoint(e.getPoint());
		      
				if ((fila > -1) && (columna > -1)) {
					atributosInsumo[0] = tblTodosInsumos.getValueAt(fila,0);
					atributosInsumo[1] = tblTodosInsumos.getValueAt(fila,1);
					atributosInsumo[2] = tblTodosInsumos.getValueAt(fila,2);
					atributosInsumo[3] = tblTodosInsumos.getValueAt(fila,3);
					atributosInsumo[4] = tblTodosInsumos.getValueAt(fila,4);
					atributosInsumo[5] = tblTodosInsumos.getValueAt(fila,5);
					atributosInsumo[6] = tblTodosInsumos.getValueAt(fila,6);
				}
				
				System.out.println((String)atributosInsumo[0] + atributosInsumo[1]+ atributosInsumo[2]);
		    
		    }
		 });
		
		this.btnAgregar.addActionListener( e-> {
			if(atributosInsumo[0].equals(-1))
				JOptionPane.showMessageDialog(this,"Seleccione un insumo", "Error", JOptionPane.ERROR_MESSAGE);	
			else {
				Object cantidadSeleccionada = (JOptionPane.showInputDialog("Cantidad:","1"));
				if(cantidadSeleccionada!=null) {
					this.atributosInsumo[7] = Integer.parseInt((String) cantidadSeleccionada);
					String [] a = devolver();
					panel.addFila(a);
				}
			}
		});
	}
		
	

	static String[] addElement(String []a, Integer e) {
		a = Arrays.copyOf(a, a.length+1);
		a[a.length - 1 ] = e.toString();
		return a;
	}
	public void recuperarInsumosTodos() {
		while(this.modeloTablaTodosInsumos.getRowCount()>0) {
			this.modeloTablaTodosInsumos.removeRow(0);
		}
		
		ArrayList<Insumo> listaInsumos = gestorInsumo.recuperarInsumoTodos();
		
		for(Insumo i: listaInsumos) {
			
			String[] p1 = i.listaAtributos();
			p1 = addElement(p1, gestorStock.getStockDeUnInsumo(i.getId()));

			modeloTablaTodosInsumos.addRow(p1);
	}
}
	public String calcularCosto() {
		Double aux = Double.parseDouble((String) this.atributosInsumo[2]) * (int)this.atributosInsumo[7];
		return aux.toString();
	}
	public String [] devolver(){
		String [] a = {this.atributosInsumo[0].toString(),this.atributosInsumo[7].toString(),this.calcularCosto()};
		return a;
	}
}
