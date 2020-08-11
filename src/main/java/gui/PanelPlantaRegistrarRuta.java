package gui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gestor.GestorRuta;

public class PanelPlantaRegistrarRuta extends JPanel{
	
	private JLabel lblSigla = new JLabel("Sigla:");
	private JTextField txtSigla;
	
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
	
	private GestorRuta gestorRuta = new GestorRuta();

	public void PanelCamiones(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(new Color(81,232,60));
		
		this.txtSigla = new JTextField(20);
		this.txtSigla.setBounds(200, 20, 100,20);
		this.lblSigla.setBounds(10,20,100,20);
		this.add(lblSigla);
		this.add(txtSigla);
		
		this.txtPlantaOrigen = new JTextField(20);
		this.txtPlantaOrigen.setBounds(200, 50, 100,20);
		this.lblPlantaOrigen.setBounds(10,50,100,20);
		this.add(lblPlantaOrigen);
		this.add(txtPlantaOrigen);
		
		this.txtPlantaDestino = new JTextField(20);
		this.txtPlantaDestino.setBounds(200, 80, 100,20);
		this.lblPlantaDestino.setBounds(10,80,100,20);
		this.add(lblPlantaDestino);
		this.add(txtPlantaDestino);
		
		this.txtDuracionEstimadaEnHoras = new JTextField(20);
		this.txtDuracionEstimadaEnHoras.setBounds(200, 110, 100,20);
		this.lblDuracionEstimadaEnHoras.setBounds(10,110,150,20);
		this.add(lblDuracionEstimadaEnHoras);
		this.add(txtDuracionEstimadaEnHoras);
		
		this.txtDistanciaEnKm = new JTextField(20);
		this.txtDistanciaEnKm.setBounds(200, 140, 100,20);
		this.lblDistanciaEnKm.setBounds(10,140,100,20);
		this.add(lblDistanciaEnKm);
		this.add(txtDistanciaEnKm);
		
		this.txtPesoMaximoEnKgQueSePuedenTransportar = new JTextField(20);
		this.txtPesoMaximoEnKgQueSePuedenTransportar.setBounds(200, 170, 100,20);
		this.lblPesoMaximoEnKgQueSePuedenTransportar.setBounds(10,170,190,20);
		this.add(lblPesoMaximoEnKgQueSePuedenTransportar);
		this.add(txtPesoMaximoEnKgQueSePuedenTransportar);


		this.btnGuardar = new JButton("Registrar");
		this.btnGuardar.setBounds(370, 400, 100, 40);
		this.btnGuardar.addActionListener( e -> gestorRuta.altaRuta(this.getTxtSigla().getText(),
																			Double.parseDouble(this.getTxtDistanciaEnKm().getText()),
																		  Double.parseDouble(this.getTxtDuracionEstimadaEnHoras().getText()), 
																		  Double.parseDouble(this.getTxtPesoMaximoEnKgQueSePuedenTransportar().getText()), 
																		  Integer.parseInt(this.getTxtPlantaOrigen().getText()), 
																		  Integer.parseInt(this.getTxtPlantaDestino().getText())));
		this.add(btnGuardar);

	}
	
	
	public JTextField getTxtSigla() {
		return txtSigla;
	}

	public void setTxtSigla(JTextField txtSigla) {
		this.txtSigla = txtSigla;
	}

	public JTextField getTxtPlantaOrigen() {
		return txtPlantaOrigen;
	}

	public void setTxtPlantaOrigen(JTextField txtPlantaOrigen) {
		this.txtPlantaOrigen = txtPlantaOrigen;
	}

	public JTextField getTxtPlantaDestino() {
		return txtPlantaDestino;
	}

	public void setTxtPlantaDestino(JTextField txtPlantaDestino) {
		this.txtPlantaDestino = txtPlantaDestino;
	}

	public JTextField getTxtDuracionEstimadaEnHoras() {
		return txtDuracionEstimadaEnHoras;
	}

	public void setTxtDuracionEstimadaEnHoras(JTextField txtDuracionEstimadaEnHoras) {
		this.txtDuracionEstimadaEnHoras = txtDuracionEstimadaEnHoras;
	}

	public JTextField getTxtDistanciaEnKm() {
		return txtDistanciaEnKm;
	}

	public void setTxtDistanciaEnKm(JTextField txtDistanciaEnKm) {
		this.txtDistanciaEnKm = txtDistanciaEnKm;
	}

	public JTextField getTxtPesoMaximoEnKgQueSePuedenTransportar() {
		return txtPesoMaximoEnKgQueSePuedenTransportar;
	}

	public void setTxtPesoMaximoEnKgQueSePuedenTransportar(JTextField txtPesoMaximoEnKgQueSePuedenTransportar) {
		this.txtPesoMaximoEnKgQueSePuedenTransportar = txtPesoMaximoEnKgQueSePuedenTransportar;
	}
	

}
