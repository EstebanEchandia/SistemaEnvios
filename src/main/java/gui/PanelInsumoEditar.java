package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	
	private JTextArea txtAreaExplicacion = new JTextArea("Para modificar un insumo el usuario debe ingresar el ID de el Insumo\n a modificar y luego completar todos los campos que quiera modificar.\n\n Todos los campos deben ser completados.");
	
	private ButtonGroup grupoRb = new ButtonGroup();
	
	private JRadioButton rbGeneral = new JRadioButton("General");
	private JRadioButton rbLiquido = new JRadioButton("Liquido");
	
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
		this.txtPeso.setBounds(50,140,100,20);
		this.lblPeso.setBounds(10,140,100,20);
		this.add(lblPeso);
		this.add(txtPeso);
		
		this.txtDensidad = new JTextField(20);
		this.txtDensidad.setBounds(230,140,100,20);
		this.lblDensidad.setBounds(170,140,100,20);
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
		
		this.grupoRb.add(rbGeneral);
		this.grupoRb.add(rbLiquido);
		
		this.rbGeneral.setBounds(10,110,70,20);
		this.rbGeneral.setBackground(Color.orange);
		this.rbGeneral.addActionListener(e -> {
			this.txtPeso.setEnabled(true);
			this.lblPeso.setEnabled(true);
			this.txtDensidad.setEnabled(false);
			this.lblDensidad.setEnabled(false);
		});
		
		this.rbLiquido.setBounds(170,110,70,20 );
		this.rbLiquido.setBackground(Color.orange);
		this.rbLiquido.addActionListener(e -> {
			this.txtPeso.setEnabled(false);
			this.lblPeso.setEnabled(false);
			this.txtDensidad.setEnabled(true);
			this.lblDensidad.setEnabled(true);
			
		});
		
		this.add(rbGeneral);
		this.add(rbLiquido);
	}
}
