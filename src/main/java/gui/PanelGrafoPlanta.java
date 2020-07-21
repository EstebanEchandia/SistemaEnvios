package gui;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelGrafoPlanta extends JPanel{
	
	private JLabel lblVerGrafo = new JLabel("Aca quizas podriamos hacer que se pueda ver el grafo:");
	
	private JLabel lblPlantaOrigen = new JLabel("Planta Origen:");
	private JTextField txtPlantaOrigen;
	
	private JLabel lblPlantaDestino = new JLabel("Planta Destino:");
	private JTextField txtPlantaDestino;
	
	private JLabel lblDuracionEstimadaEnHoras = new JLabel("Duracion estimada[hs]:");
	
	private JLabel lblDistanciaEnKm = new JLabel("Distancia[km]:");
	
	private JLabel lblPesoMaximoEnKgQueSePuedenTransportar = new JLabel("Peso maximo a transportar[km]"); 
	
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	public void PanelCamiones(){
	}
	
	public void armarPanel() {
		
		this.add(lblVerGrafo);
		
		this.txtPlantaOrigen = new JTextField(20);
		this.add(lblPlantaOrigen);
		this.add(txtPlantaOrigen);
		
		this.txtPlantaDestino = new JTextField(20);
		this.add(lblPlantaDestino);
		this.add(txtPlantaDestino);
		
		this.add(lblDuracionEstimadaEnHoras);
		this.add(lblDistanciaEnKm);
		this.add(lblPesoMaximoEnKgQueSePuedenTransportar);

		this.btnGuardar = new JButton("Guardar");
		this.add(btnGuardar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.add(btnCancelar);
	}
}
