package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

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

public class PanelPlantaBuscarPlanta extends JPanel {
	
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
		
		this.setBackground(new Color(184,65,39));
		
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
				this.crearPanelEditarPlanta(app,atributos);
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
	
	public void crearPanelEditarPlanta(App aux, Object [] atributos) {
		
		JPanel panelEditarPlanta = new JPanel();
		
		panelEditarPlanta.setBounds(0, 0, 900, 560);
		panelEditarPlanta.setOpaque(true);
		
		JLabel lblIdPlanta = new JLabel("Id Planta:");
		JTextField txtIdPlanta = new JTextField((String)atributos[0]);
		
		JLabel lblIdInsumo = new JLabel("Id Insumo:");
		JTextField txtIdInsumo = new JTextField(20);
		
		JLabel lblCantidadInsumo = new JLabel("Cantidad:");
		JTextField txtCantidadInsumo = new JTextField(20);
		
		JLabel lblPtoPedido = new JLabel("Pto Pedido:");
		JTextField txtPtoPedido = new JTextField(20);
		
		JButton btnGuardar = new JButton("Guardar");
		JButton btnCancelar = new JButton("Cancelar");
		
		panelEditarPlanta.setLayout(null);
		
		panelEditarPlanta.setBackground(new Color(184,65,39));
		
		txtIdPlanta.setBounds(90, 50, 100, 20);
		lblIdPlanta.setBounds(10, 50, 100, 20);
		panelEditarPlanta.add(txtIdPlanta);
		panelEditarPlanta.add(lblIdPlanta);
		
		txtIdInsumo.setBounds(90, 80, 100, 20);
		lblIdInsumo.setBounds(10, 80, 100, 20);
		panelEditarPlanta.add(txtIdInsumo);
		panelEditarPlanta.add(lblIdInsumo);
		
		txtCantidadInsumo.setBounds(90, 110, 100, 20);
		lblCantidadInsumo.setBounds(10, 110, 100, 20);
		panelEditarPlanta.add(txtCantidadInsumo);
		panelEditarPlanta.add(lblCantidadInsumo);
		
		txtPtoPedido.setBounds(90, 140, 100, 20);
		lblPtoPedido.setBounds(10, 140, 100, 20);
		panelEditarPlanta.add(txtPtoPedido);
		panelEditarPlanta.add(lblPtoPedido);
		
		
		btnGuardar.setBounds(290, 400, 120, 40);
		panelEditarPlanta.add(btnGuardar);
		
		btnCancelar.setBounds(420, 400, 120, 40);
		btnCancelar.addActionListener(e -> armarPanel(aux));
		panelEditarPlanta.add(btnCancelar);
		
		lblIdPlanta.setEnabled(false);
		txtIdPlanta.setEnabled(false);
		
		app.setContentPane(panelEditarPlanta);
		app.pack();
		
		
	}
}
