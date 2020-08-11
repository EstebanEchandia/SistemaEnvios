package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import enums.Unidad;
import gestor.GestorInsumo;

public class PanelInsumoDarAlta extends JPanel {
	
	private JLabel lblDescripcion = new JLabel("Descripcion:");
	private JTextField txtDescripcion;
	
	private JLabel lblUnidadDeMedida = new JLabel("Unidad de Medida:");
	private JComboBox cmbUnidad = new JComboBox();
	
	private JLabel lblCosto = new JLabel("Costo:");
	private JTextField txtCosto;
	
	private JLabel lblPeso = new JLabel("Peso[kg]:");
	private JTextField txtPeso;
	
	private JLabel lblDensidad = new JLabel("Densidad[kg/m3]:");
	private JTextField txtDensidad;
	
	private JButton btnGuardar;
	
	private ButtonGroup grupoRb = new ButtonGroup();
	
	private JRadioButton rbGeneral = new JRadioButton("General");
	private JRadioButton rbLiquido = new JRadioButton("Liquido");
	
	private JLabel imagenInsumo1;
	private JLabel imagenInsumo2;
	private JLabel imagenInsumo3;
	
	private GestorInsumo gestorInsumo = new GestorInsumo();
	
	public void PanelInsumo(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.orange);
		
		this.txtDescripcion = new JTextField(20);
		this.txtDescripcion.setBounds(120, 20, 100,20);
		this.lblDescripcion.setBounds(10,20,100,20);
		this.add(lblDescripcion);
		this.add(txtDescripcion);
		

		this.cmbUnidad.setBounds(120, 50, 100,20);
		cmbUnidad.addItem(Unidad.GRAMO);
		cmbUnidad.addItem(Unidad.KILO);
		cmbUnidad.addItem(Unidad.LITRO);
		cmbUnidad.addItem(Unidad.M2);
		cmbUnidad.addItem(Unidad.M3);
		cmbUnidad.addItem(Unidad.PIEZA);
		this.lblUnidadDeMedida.setBounds(10,50,120,20);
		this.add(lblUnidadDeMedida);
		this.add(cmbUnidad);
		
		this.txtCosto = new JTextField(20);
		this.txtCosto.setBounds(120,80,100,20);
		this.lblCosto.setBounds(10,80,100,20);
		this.add(lblCosto);
		this.add(txtCosto);
		
		this.txtPeso = new JTextField(20);
		this.txtPeso.setBounds(70,140,100,20);
		this.lblPeso.setBounds(10,140,100,20);
		this.add(lblPeso);
		this.add(txtPeso);
		
		this.txtDensidad = new JTextField(20);
		this.txtDensidad.setBounds(285,140,100,20);
		this.lblDensidad.setBounds(180,140,100,20);
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
			
			//Borramos todos los ActionListeners asociados a guardar
			for(ActionListener al: this.btnGuardar.getActionListeners()) {
				btnGuardar.removeActionListener(al);
			}
			
			//Creamos el actionListener que vamos a usar
			this.btnGuardar.addActionListener( f -> gestorInsumo.altaInsumoGeneral(this.getTxtDescripcion().getText(),
					Double.parseDouble(this.getTxtCosto().getText()),
					(Unidad) this.cmbUnidad.getSelectedItem(),			
					Double.parseDouble(this.getTxtPeso().getText()))
					);
		
		});
		
		this.rbLiquido.setBounds(170,110,70,20 );
		this.rbLiquido.setBackground(Color.orange);
		
		this.rbLiquido.addActionListener(e -> {
			this.txtPeso.setEnabled(false);
			this.lblPeso.setEnabled(false);
			this.txtDensidad.setEnabled(true);
			this.lblDensidad.setEnabled(true);
			
			for(ActionListener al: this.btnGuardar.getActionListeners()) {
				btnGuardar.removeActionListener(al);
			}
			
			this.btnGuardar.addActionListener( f -> gestorInsumo.altaInsumoLiquido(this.getTxtDescripcion().getText(),
					Double.parseDouble(this.getTxtCosto().getText()),
					(Unidad)this.cmbUnidad.getSelectedItem(),			
					Double.parseDouble(this.getTxtDensidad().getText()))
					);
			
				
			
		});
		
		this.add(rbGeneral);
		this.add(rbLiquido);
		
		this.imagenInsumo1 = new JLabel();
		this.imagenInsumo1.setBounds(550,30,100,100);
		
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/etiqueta.png"));	
		Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)); 
		this.imagenInsumo1.setIcon(icono1);
		this.add(imagenInsumo1);
		
		this.imagenInsumo2 = new JLabel();
		this.imagenInsumo2.setBounds(650,150,100,100);
		
		ImageIcon imagen2 = new ImageIcon(getClass().getResource("/imagenes/bolsa.png"));	
		Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)); 
		this.imagenInsumo2.setIcon(icono2);
		this.add(imagenInsumo2);
		
		this.imagenInsumo3 = new JLabel();
		this.imagenInsumo3.setBounds(550,270,100,100);
		
		ImageIcon imagen3 = new ImageIcon(getClass().getResource("/imagenes/canasta de compras.png"));	
		Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)); 
		this.imagenInsumo3.setIcon(icono3);
		this.add(imagenInsumo3);
		
	
		
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextField txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}


	public JTextField getTxtCosto() {
		return txtCosto;
	}

	public void setTxtCosto(JTextField txtCosto) {
		this.txtCosto = txtCosto;
	}

	public JTextField getTxtPeso() {
		return txtPeso;
	}

	public void setTxtPeso(JTextField txtPeso) {
		this.txtPeso = txtPeso;
	}

	public JTextField getTxtDensidad() {
		return txtDensidad;
	}

	public void setTxtDensidad(JTextField txtDensidad) {
		this.txtDensidad = txtDensidad;
	}
}
