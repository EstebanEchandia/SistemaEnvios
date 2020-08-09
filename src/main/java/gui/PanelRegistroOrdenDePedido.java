package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.App;
import dominio.Planta;
import gestor.GestorPlanta;

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
		this.add(scroll);
		
		this.btnEditar = new JButton("Editar");
		this.btnEditar.setBounds(370, 400, 100, 40);
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
			else 				
				this.crearPanelRegistrarOrdenPedido(app,atributos);
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
	
	public void crearPanelRegistrarOrdenPedido(App aux, Object [] atributos) {
		
		JPanel panelRegistrarOrdenPedido = new JPanel();
		
		panelRegistrarOrdenPedido.setBounds(0, 0, 900, 560);
		panelRegistrarOrdenPedido.setOpaque(true);
		panelRegistrarOrdenPedido.setLayout(null);
		panelRegistrarOrdenPedido.setBackground(new Color(43,167,194));
		
		JLabel lblIdPlanta = new JLabel("Planta a enviar pedido:");
		JTextField txtIdPlanta = new JTextField((String)atributos[0]);
		
		JLabel lblFechaMaxEntrega = new JLabel("Fecha max entrega:");
		JTextField txtFechaMaxEntrega = new JTextField(20);
		
		JLabel lblListaItemsPedido = new JLabel("Lista con Items pedido");
		
		JLabel lblInsumo = new JLabel("Insumo:");
		JTextField txtInsumo = new JTextField(20);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		JTextField txtCantidad = new JTextField(20);
		
		JLabel lblPrecio = new JLabel("Precio:");
		JTextField txtPrecio = new JTextField(20);
		
		JTable tblInsumos;
		DefaultTableModel modeloTablaAtributos;
		JScrollPane scroll;
		
		
		JButton btnGuardar = new JButton("Guardar");
		JButton btnCancelar = new JButton("Cancelar");
		
		txtIdPlanta.setBounds(150, 50, 100, 20);
		lblIdPlanta.setBounds(10, 50, 140, 20);
		panelRegistrarOrdenPedido.add(txtIdPlanta);
		panelRegistrarOrdenPedido.add(lblIdPlanta);
		
		txtFechaMaxEntrega.setBounds(140, 80, 100, 20);
		lblFechaMaxEntrega.setBounds(10, 80, 130, 20);
		panelRegistrarOrdenPedido.add(txtFechaMaxEntrega);
		panelRegistrarOrdenPedido.add(lblFechaMaxEntrega);
		
		lblListaItemsPedido.setBounds(10, 110, 150, 20);
		panelRegistrarOrdenPedido.add(lblListaItemsPedido);
		
		
		btnGuardar.setBounds(290, 400, 120, 40);
		panelRegistrarOrdenPedido.add(btnGuardar);
		
		btnCancelar.setBounds(420, 400, 120, 40);
		btnCancelar.addActionListener(e -> armarPanel(aux));
		panelRegistrarOrdenPedido.add(btnCancelar);
		
		lblIdPlanta.setEnabled(true);
		txtIdPlanta.setEnabled(false);
		
		/* Hacemos la tabla */
		modeloTablaAtributos = new DefaultTableModel();
		
		modeloTablaAtributos.addColumn("Insumo");
		modeloTablaAtributos.addColumn("Cantidad");
		modeloTablaAtributos.addColumn("Precio");
		
		
		
		tblInsumos = new JTable(modeloTablaAtributos);
		tblInsumos.setBounds(30, 150, 200,200);
		
		scroll = new JScrollPane(tblInsumos);
		
		scroll.setBounds(30, 150, 230,230);
		panelRegistrarOrdenPedido.add(scroll);
		
		
		
		/*----------------*/
		
		/*  Panel para agregar Insumos  */
		
			
		JPanel panelAgregarInsumos = new JPanel();
		
		JTable tblTodosInsumos;
		DefaultTableModel modeloTablaTodosInsumos;
		JScrollPane scrollTodosInsumos;
		
		JButton btnAgregar = new JButton("Agregar");
		
		int cantidad;
		
		Object [] atributosInsumo = {-1,0};
		
		panelAgregarInsumos.setBounds(400, 20, 400, 340);
		panelAgregarInsumos.setOpaque(true);
		panelAgregarInsumos.setLayout(null);
		panelAgregarInsumos.setBackground(new Color(100,167,194));
		
		modeloTablaTodosInsumos = new DefaultTableModel();
		
		modeloTablaTodosInsumos.addColumn("Insumo");
		modeloTablaTodosInsumos.addColumn("Cantidad");
		modeloTablaTodosInsumos.addColumn("Precio");
		
		tblTodosInsumos = new JTable(modeloTablaTodosInsumos);
		tblTodosInsumos.setBounds(10, 10, 380,250);
		
		scrollTodosInsumos = new JScrollPane(tblTodosInsumos);
		
		scrollTodosInsumos.setBounds(10, 10, 380,250);
		panelAgregarInsumos.add(scrollTodosInsumos);
		
		btnAgregar.setBounds(155, 280, 90, 30);
		
		btnAgregar.addActionListener( e-> {
			if(atributosInsumo[0].equals(-1))
				JOptionPane.showMessageDialog(this,"Seleccione un insumo", "Error", JOptionPane.ERROR_MESSAGE);	
			else if(JOptionPane.showInputDialog("Cantidad:")!=null)
				Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));// lo tengo que igualar a el elemento de la fila que vaya a agregar
				
		});
		panelAgregarInsumos.add(btnAgregar);
		
		panelRegistrarOrdenPedido.add(panelAgregarInsumos);
		
		//
		
		/*------------------------------*/
		
		app.setContentPane(panelRegistrarOrdenPedido);
		app.pack();
		
		
	}
}
