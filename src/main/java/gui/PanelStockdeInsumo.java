package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelStockdeInsumo  extends JPanel{
	
	private JLabel lblBuscarPlanta = new JLabel("Buscar planta:");
	private JTextField txtBuscarPlanta;
	
	private JLabel lblInsumoAAgregar = new JLabel("Insumo a agregar:");
	private JTextField txtInsumoAAgregar;
	
	private JLabel lblCantidadDeInsumo = new JLabel("Cantidad de Insumo:");
	private JTextField txtCantidadDeInsumo;
	
	private JLabel lblStockMinimo = new JLabel("Stock Minimo:");
	
	private JLabel lblDistanciaEnKm = new JLabel("Distancia[km]:");
	
	private JLabel lblPesoMaximoEnKgQueSePuedenTransportar = new JLabel("Peso maximo a transportar[km]"); 
	
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	public void PanelInsumo(){
	}

	public void armarPanel() {
		
		this.setBackground(Color.orange);
		
	}
}
