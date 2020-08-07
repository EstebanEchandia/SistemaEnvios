package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPlantaRegistrarRuta extends JPanel{
	
	private JLabel lblPlantaOrigen = new JLabel("Planta Origen:");
	private JTextField txtPlantaOrigen;
	
	private JLabel lblPlantaDestino = new JLabel("Planta Destino:");
	private JTextField txtPlantaDestino;
	
	private JLabel lblDuracionEstimadaEnHoras = new JLabel("Duracion estimada[hs]:");
	private JTextField txtDuracionEstimadaEnHoras;
	
	private JLabel lblDistanciaEnKm = new JLabel("Distancia[km]:");
	private JTextField txtDistanciaEnKm;
	
	private JLabel lblPesoMaximoEnKgQueSePuedenTransportar = new JLabel("Peso maximo a transportar[km]"); 
	private JTextField txtPesoMaximoEnKgQueSePuedenTransportar;
	
	private JButton btnGuardar;

	public void PanelCamiones(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(new Color(184,65,39));
		
		this.txtPlantaOrigen = new JTextField(20);
		this.txtPlantaOrigen.setBounds(100, 20, 100,20);
		this.lblPlantaOrigen.setBounds(10,20,100,20);
		this.add(lblPlantaOrigen);
		this.add(txtPlantaOrigen);
		
		this.txtPlantaDestino = new JTextField(20);
		this.txtPlantaDestino.setBounds(100, 50, 100,20);
		this.lblPlantaDestino.setBounds(10,50,100,20);
		this.add(lblPlantaDestino);
		this.add(txtPlantaDestino);
		
		this.txtDuracionEstimadaEnHoras = new JTextField(20);
		this.txtDuracionEstimadaEnHoras.setBounds(150, 80, 100,20);
		this.lblDuracionEstimadaEnHoras.setBounds(10,80,150,20);
		this.add(lblDuracionEstimadaEnHoras);
		this.add(txtDuracionEstimadaEnHoras);
		
		this.txtDistanciaEnKm = new JTextField(20);
		this.txtDistanciaEnKm.setBounds(100, 110, 100,20);
		this.lblDistanciaEnKm.setBounds(10,110,100,20);
		this.add(lblDistanciaEnKm);
		this.add(txtDistanciaEnKm);


		this.btnGuardar = new JButton("Registrar");
		this.btnGuardar.setBounds(370, 400, 100, 40);
		this.add(btnGuardar);

	}
}
