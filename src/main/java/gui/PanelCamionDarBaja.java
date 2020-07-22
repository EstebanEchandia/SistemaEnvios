package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCamionDarBaja extends JPanel {
	private JLabel lblDarDeBajaCamion = new JLabel("Dar de baja camion:");
	
	public void PanelAyuda(){
	}
	
	public void armarPanel() {
		
		this.setBackground(Color.yellow);
		
		this.add(lblDarDeBajaCamion);
	}
}
