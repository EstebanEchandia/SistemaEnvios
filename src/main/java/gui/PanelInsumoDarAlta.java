package gui;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelInsumoDarAlta extends JPanel {
	
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
	
	private ButtonGroup grupoRb = new ButtonGroup();
	
	private JRadioButton rbGeneral = new JRadioButton("General");
	private JRadioButton rbLiquido = new JRadioButton("Liquido");
	
	public void PanelInsumo(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.orange);
		
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
		
		this.btnGuardar = new JButton("Dar Alta");
		this.btnGuardar.setBounds(370, 400, 100, 40);
		this.add(btnGuardar);
		
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
