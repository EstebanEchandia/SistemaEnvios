package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCamionEditar extends JPanel {

	private JLabel lblEditarCamion = new JLabel("Editar camion:");
	
	public void PanelAyuda(){
	}
	
	public void armarPanel() {
		
		this.setBackground(Color.yellow);
		
		this.add(lblEditarCamion);
	}		

}
