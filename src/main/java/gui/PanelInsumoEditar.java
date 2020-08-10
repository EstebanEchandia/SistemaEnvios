package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import enums.Unidad;
import gestor.GestorInsumo;

public class PanelInsumoEditar extends JPanel {
	
	private JLabel lblId = new JLabel("Id:");
	private JTextField txtId;
	
	private JLabel lblDescripcion = new JLabel("Descripcion:");
	private JTextField txtDescripcion;
	
	private JLabel lblUnidadDeMedida = new JLabel("Unidad de Medida:");
	private JTextField txtUnidadDeMedida;
	
	private JLabel lblCosto = new JLabel("Costo:");
	private JTextField txtCosto;
	
	private JLabel lblPeso = new JLabel("Peso[kg]:");
	private JTextField txtPeso;
	
	private JLabel lblDensidad = new JLabel("Densidad[kg/m3]:");
	private JTextField txtDensidad;
	
	private JButton btnGuardar;
	
	private JTextArea txtAreaExplicacion = new JTextArea("Para modificar un insumo el usuario debe ingresar el ID de el Insumo\n a modificar y luego completar todos los campos que quiera modificar.\n\n Todos los campos deben ser completados.");
	
	private ButtonGroup grupoRb = new ButtonGroup();
	
	private JRadioButton rbGeneral = new JRadioButton("General");
	private JRadioButton rbLiquido = new JRadioButton("Liquido");
	
	private JLabel imagenInsumo1;
	private JLabel imagenInsumo2;
	private JLabel imagenInsumo3;
	
	private GestorInsumo gestorInsumo = new GestorInsumo();
	
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
		this.txtPeso.setBounds(70,140,100,20);
		this.lblPeso.setBounds(10,140,100,20);
		this.add(lblPeso);
		this.add(txtPeso);
		
		this.txtDensidad = new JTextField(20);
		this.txtDensidad.setBounds(285,140,100,20);
		this.lblDensidad.setBounds(180,140,100,20);
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
			
			//Borramos todos los ActionListeners asociados a guardar
			for(ActionListener al: this.btnGuardar.getActionListeners()) {
				btnGuardar.removeActionListener(al);
			}
			
			//Creamos el actionListener que vamos a usar
			this.btnGuardar.addActionListener( f -> gestorInsumo.updateInsumoGeneral(
					Integer.parseInt(this.getTxtId().getText()),
					this.getTxtDescripcion().getText(),
					Double.parseDouble(this.getTxtCosto().getText()),
					Unidad.valueOf(this.getTxtUnidadDeMedida().getText()),			
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
			
			this.btnGuardar.addActionListener( f -> gestorInsumo.updateInsumoLiquido(
					Integer.parseInt(this.getTxtId().getText()),
					this.getTxtDescripcion().getText(),
					Double.parseDouble(this.getTxtCosto().getText()),
					Unidad.valueOf(this.getTxtUnidadDeMedida().getText()),			
					Double.parseDouble(this.getTxtDensidad().getText()))
					);
			
		});
		
		this.add(rbGeneral);
		this.add(rbLiquido);
		
		this.imagenInsumo1 = new JLabel();
		this.imagenInsumo1.setBounds(150,300,100,100);
		
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagenes/etiqueta.png"));	
		Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)); 
		this.imagenInsumo1.setIcon(icono1);
		this.add(imagenInsumo1);
		
		this.imagenInsumo2 = new JLabel();
		this.imagenInsumo2.setBounds(375,220,100,100);
		
		ImageIcon imagen2 = new ImageIcon(getClass().getResource("/imagenes/bolsa.png"));	
		Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)); 
		this.imagenInsumo2.setIcon(icono2);
		this.add(imagenInsumo2);
		
		this.imagenInsumo3 = new JLabel();
		this.imagenInsumo3.setBounds(600,300,100,100);
		
		ImageIcon imagen3 = new ImageIcon(getClass().getResource("/imagenes/canasta de compras.png"));	
		Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)); 
		this.imagenInsumo3.setIcon(icono3);
		this.add(imagenInsumo3);
		
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextField txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public JTextField getTxtUnidadDeMedida() {
		return txtUnidadDeMedida;
	}

	public void setTxtUnidadDeMedida(JTextField txtUnidadDeMedida) {
		this.txtUnidadDeMedida = txtUnidadDeMedida;
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
