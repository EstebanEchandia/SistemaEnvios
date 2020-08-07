package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelInsumoEditar extends JPanel {
	
	private JLabel lblId = new JLabel("Id:");
	private JTextField txtId;
	
	private JLabel lblDescripcion = new JLabel("Descripcion:");
	private JTextField txtDescripcion;
	
	private JLabel lblUnidadDeMedida = new JLabel("Unidad de Medida:");
	private JTextField txtUnidadDeMedida;
	
	private JLabel lblCosto = new JLabel("Costo:");
	private JTextField txtCosto;
	
	private JLabel lblPeso = new JLabel("Peso:");
	private JTextField txtPeso;
	
	private JLabel lblDensidad = new JLabel("Densidad:");
	private JTextField txtDensidad;
	
	private JButton btnGuardar;
	
	private JTextArea txtAreaExplicacion = new JTextArea("Para modificar un insumo el usuario debe ingresar el ID de el Insumo\n a modificar y luego completar todos los campos que quiera modificar.\n\n Si un campo no es completado quedara con el valor anterior a la modificacion.");
	
	
	public void PanelInsumoEditar(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.orange);
		
		this.txtId = new JTextField(20);
		this.txtId.setBounds(520, 20, 100,20);
		this.lblId.setBounds(500,20,100,20);
		this.add(lblId);
		this.add(txtId);
		
		this.txtDescripcion = new JTextField(20);
		this.txtDescripcion.setBounds(90, 20, 100,20);
		this.lblDescripcion.setBounds(10,20,100,20);
		this.add(lblDescripcion);
		this.add(txtDescripcion);
		
		this.txtUnidadDeMedida = new JTextField(20);
		this.txtUnidadDeMedida.setBounds(120, 50, 100,20);
		this.lblUnidadDeMedida.setBounds(10,50,120,20);
		this.add(lblUnidadDeMedida);
		this.add(txtUnidadDeMedida);
		
		this.txtCosto = new JTextField(20);
		this.txtCosto.setBounds(55,80,100,20);
		this.lblCosto.setBounds(10,80,100,20);
		this.add(lblCosto);
		this.add(txtCosto);
		
		this.txtPeso = new JTextField(20);
		this.txtPeso.setBounds(50,110,100,20);
		this.lblPeso.setBounds(10,110,100,20);
		this.add(lblPeso);
		this.add(txtPeso);
		
		this.txtDensidad = new JTextField(20);
		this.txtDensidad.setBounds(70,140,100,20);
		this.lblDensidad.setBounds(10,140,100,20);
		this.add(lblDensidad);
		this.add(txtDensidad);
		
		this.btnGuardar = new JButton("Editar");
		this.btnGuardar.setBounds(370, 400, 100, 40);
		this.add(btnGuardar);
		
		this.txtAreaExplicacion.setBounds(500,60,250,200);
		this.txtAreaExplicacion.setFont(new Font("Serif", Font.BOLD, 16));
		this.txtAreaExplicacion.setLineWrap(true);
		this.txtAreaExplicacion.setWrapStyleWord(true);
		this.txtAreaExplicacion.setOpaque(false);
		this.txtAreaExplicacion.setEditable(false);
		this.add(txtAreaExplicacion);
	}
}
