package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private JButton btnCancelar;
	
	public void PanelInsumo(){
	}
	
	public void armarPanel() {
		
		this.setBackground(Color.orange);
		
		this.txtDescripcion = new JTextField(20);
		this.add(lblDescripcion);
		this.add(txtDescripcion);
		
		this.txtUnidadDeMedida = new JTextField(20);
		this.add(lblUnidadDeMedida);
		this.add(txtUnidadDeMedida);
		
		this.txtCosto = new JTextField(20);
		this.add(lblCosto);
		this.add(txtCosto);
		
		this.txtPeso = new JTextField(20);
		this.add(lblPeso);
		this.add(txtPeso);
		
		this.txtDensidad = new JTextField(20);
		this.add(lblDensidad);
		this.add(txtDensidad);
		
		this.btnGuardar = new JButton("Guardar");
		this.add(btnGuardar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.add(btnCancelar);
	}
}
