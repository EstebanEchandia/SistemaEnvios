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
				panelEdicion.armarPanel(app, this, atributos);
			}
				
		});
		
		
		app.setContentPane(this);
		app.revalidate();
		app.pack();
		
		

	}
	
<<<<<<< HEAD
=======
	public void crearPanelEditarCamion(App aux, Object [] atributos) {
		
		JPanel panelEditarCamion = new JPanel();
		
		panelEditarCamion.setBounds(0, 0, 900, 560);
		panelEditarCamion.setOpaque(true);
		
		JLabel lblId = new JLabel("Id:");
		JTextField txtId;
		
		JLabel lblPatente = new JLabel("Patente:");
		JTextField txtPatente;
		
		JLabel lblModelo = new JLabel("Modelo:");
		JTextField txtModelo;
		
		JLabel lblFechaDeCompra = new JLabel("Fecha de  compra:");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		JFormattedTextField txtFechaCompra = new JFormattedTextField(df);	
		
		JLabel lblKmRecorridos = new JLabel("KMs recorridos:");
		JTextField txtKmRecorridos;
		
		JLabel lblCostoPorKm = new JLabel("Costo por Km:");
		JTextField txtCostoPorKm;
		
		JLabel lblCostoPorHora = new JLabel("Costo por hora:");
		JTextField txtCostoPorHora;
		
		JButton btnGuardar;

		JTextArea txtAreaExplicacion = new JTextArea("Para modificar un camion el usuario modificar los campos que desee. \n\n La fecha debe ser ingresada en el formato: aaaa-mm-dd");
		
		GestorCamion gestorCamion = new GestorCamion();
		
		JLabel imagenCamion;
		
		panelEditarCamion.setLayout(null);
	
		panelEditarCamion.setBackground(Color.yellow);
		
		txtId = new JTextField((String)atributos[0]);
		txtId.setBounds(520, 20, 100,20);
		lblId.setBounds(500,20,100,20);
		panelEditarCamion.add(lblId);
		panelEditarCamion.add(txtId);
		
		lblId.setEnabled(false);
		txtId.setEnabled(false);
		
		txtPatente = new JTextField((String)atributos[1]);
		txtPatente.setBounds(60, 20, 100,20);
		lblPatente.setBounds(10,20,100,20);
		panelEditarCamion.add(lblPatente);
		panelEditarCamion.add(txtPatente);
		
		txtModelo = new JTextField((String)atributos[2]);
		txtModelo.setBounds(60, 50, 100, 20);
		lblModelo.setBounds(10, 50, 100, 20);
		panelEditarCamion.add(lblModelo);
		panelEditarCamion.add(txtModelo);
		
		txtFechaCompra = new JFormattedTextField((String)atributos[3]);
		txtFechaCompra.setBounds(130, 80, 100, 20);
		lblFechaDeCompra.setBounds(10, 80, 120, 20);
		panelEditarCamion.add(lblFechaDeCompra);
		panelEditarCamion.add(txtFechaCompra);
		
		txtKmRecorridos = new JTextField((String)atributos[4]);
		txtKmRecorridos.setBounds(130, 110, 100, 20);
		lblKmRecorridos.setBounds(10, 110, 100, 20);
		panelEditarCamion.add(lblKmRecorridos);
		panelEditarCamion.add(txtKmRecorridos);
		
		txtCostoPorKm = new JTextField((String)atributos[5]);
		txtCostoPorKm.setBounds(130, 140, 100, 20);
		lblCostoPorKm.setBounds(10, 140, 100, 20);
		panelEditarCamion.add(lblCostoPorKm);
		panelEditarCamion.add(txtCostoPorKm);  
		
		txtCostoPorHora = new JTextField((String)atributos[6]);
		txtCostoPorHora.setBounds(130, 170, 100, 20);
		lblCostoPorHora.setBounds(10, 170, 100, 20);
		panelEditarCamion.add(lblCostoPorHora);
		panelEditarCamion.add(txtCostoPorHora);
		
		btnGuardar = new JButton("Editar");
		btnGuardar.setBounds(370, 400, 100, 40);
		
//		btnGuardar.addActionListener( e -> gestorCamion.updateCamion(Integer.parseInt(txtId.getText()), 
//				txtPatente.getText(), 
//				txtModelo.getText(), 
//				Double.parseDouble(txtKmRecorridos.getText()), 
//				Double.parseDouble(txtCostoPorHora.getText()), 
//				Double.parseDouble(txtCostoPorHora.getText()), 
//				LocalDate.parse(txtFechaCompra.getText())
//				)
//			);
//		
		panelEditarCamion.add(btnGuardar);		
		
		txtAreaExplicacion.setBounds(500,60,250,250);
		txtAreaExplicacion.setFont(new Font("Serif", Font.BOLD, 16));
		txtAreaExplicacion.setLineWrap(true);
		txtAreaExplicacion.setWrapStyleWord(true);
		txtAreaExplicacion.setOpaque(false);
		txtAreaExplicacion.setEditable(false);
		panelEditarCamion.add(txtAreaExplicacion);
		
		imagenCamion = new JLabel();
		imagenCamion.setBounds(60,300,140,140);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/camion.png"));	
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(140,140,Image.SCALE_SMOOTH)); 
		imagenCamion.setIcon(icono);
		panelEditarCamion.add(imagenCamion);
		
		app.setContentPane(panelEditarCamion);
		app.pack();
	}
>>>>>>> teclado
	
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
