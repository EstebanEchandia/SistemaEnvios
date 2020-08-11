package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dominio.Camion;
import gestor.GestorCamion;

public class PanelCamionBuscarPorAtributos extends JPanel {
	
	private JLabel lblId = new JLabel("Id:");
	private JTextField txtId;
	
	private JLabel lblPatente = new JLabel("Patente:");
	private JTextField txtPatente;
	
	private JButton btnGuardar;
	private JButton btnMostrarTodos;
	
	private JButton btnBuscarPorId;
	private JButton btnBuscarPorPatente;
	
	private GestorCamion gestorCamion = new GestorCamion();
	
	private JTable tblAtributos;
	private DefaultTableModel modeloTablaAtributos = new DefaultTableModel();
	private JScrollPane scroll;
	
	private JLabel imagenCamion;
	
	public void PanelCamionBuscarPorAtributos(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.yellow);
		
		this.txtId = new JTextField(20);
		this.txtId.setBounds(95, 370, 100,20);
		this.lblId.setBounds(75,370,100,20);
		this.add(lblId);
		this.add(txtId);
		
		this.txtPatente = new JTextField(20);
		this.txtPatente.setBounds(400, 370, 100,20);
		this.lblPatente.setBounds(350,370,100,20);
		this.add(lblPatente);
		this.add(txtPatente);
		
		this.btnMostrarTodos = new JButton("Mostrar todos");
		this.btnMostrarTodos.setBounds(630, 400, 120, 20);
		this.btnMostrarTodos.addActionListener(e -> this.mostrarTodosCamiones());
		this.add(btnMostrarTodos);
		
		this.btnBuscarPorId = new JButton("Buscar por Id");
		this.btnBuscarPorId.setBounds(80, 400, 110, 20);
		this.btnBuscarPorId.addActionListener(e -> this.buscarCamion());
		this.add(btnBuscarPorId);
		
		this.btnBuscarPorPatente = new JButton("Buscar por Patente");
		this.btnBuscarPorPatente.setBounds(350, 400, 150, 20);
		this.btnBuscarPorPatente.addActionListener(e -> this.buscarCamion());
		this.add(btnBuscarPorPatente);

		this.modeloTablaAtributos.addColumn("Id");
		this.modeloTablaAtributos.addColumn("Patente");
		this.modeloTablaAtributos.addColumn("Modelo");
		this.modeloTablaAtributos.addColumn("Fecha de compra");
		this.modeloTablaAtributos.addColumn("KMs recorridos");
		this.modeloTablaAtributos.addColumn("Costo por km");
		this.modeloTablaAtributos.addColumn("Costo por hora");
		
	
		this.tblAtributos = new JTable(modeloTablaAtributos);
		this.tblAtributos.setBounds(220, 20, 550,300);
		
		this.scroll = new JScrollPane(this.tblAtributos);
		this.scroll.setBounds(180, 20, 550,300);
		this.scroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Camiones"));
		this.scroll.setBackground(Color.yellow);
		this.add(scroll);
		

		
		this.imagenCamion = new JLabel();
		this.imagenCamion.setBounds(20,100,140,140);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/camion.png"));	
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(130,130,Image.SCALE_SMOOTH)); 
		this.imagenCamion.setIcon(icono);
		this.add(imagenCamion);

	}
	
	
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
	
	public void buscarCamion() {
	
		Camion c = gestorCamion.recuperarCamionPatente(this.getTxtPatente().getText());
		System.out.println(c.getPatente());
		String[] p1 = c.listaAtributos();
		this.modeloTablaAtributos.addRow(p1);
		
	}
	

	public JLabel getLblPatente() {
		return lblPatente;
	}

	public void setLblPatente(JLabel lblPatente) {
		this.lblPatente = lblPatente;
	}

	public JTextField getTxtPatente() {
		return txtPatente;
	}

	public void setTxtPatente(JTextField txtPatente) {
		this.txtPatente = txtPatente;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    };
}