package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private JButton btnEditar;
	
	private GestorPlanta gestorPlanta = new GestorPlanta();
	
	private App app;
	
	public void armarPanel(App aux) {

		this.app = aux;
		
		this.setLayout(null);
		
		this.setBackground(Color.orange);
		
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
		this.btnEditar.addActionListener(e -> {
			crearPanelEditarPlanta(app);
		});
		this.add(btnEditar);
		
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
	
	public void crearPanelEditarPlanta(App aux) {
		
		JPanel panelEditarPlanta = new JPanel();
		panelEditarPlanta.setBounds(0, 0, 900, 560);
		panelEditarPlanta.setOpaque(true);
		
		JLabel lblIdPlanta = new JLabel("Id Planta:");
		JTextField txtIdPlanta = new JTextField(20);
		
		JLabel lblIdInsumo = new JLabel("Id Insumo:");
		JTextField txtIdInsumo = new JTextField(20);
		
		JLabel lblCantidadInsumo = new JLabel("Cantidad:");
		JTextField txtCantidadInsumo = new JTextField(20);
		
		JLabel lblPtoPedido = new JLabel("Pto Pedido:");
		JTextField txtPtoPedido = new JTextField(20);
		
		JButton btnGuardar = new JButton("Guardar");
		JButton btnCancelar = new JButton("Cancelar");
		
		panelEditarPlanta.setLayout(null);
		
		panelEditarPlanta.setBackground(Color.orange);
		
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
		
		app.setContentPane(panelEditarPlanta);
		app.pack();
		
		
	}
}
