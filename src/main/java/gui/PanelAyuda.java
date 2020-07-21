package gui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAyuda extends JPanel{
	private JLabel lblAyuda = new JLabel("Tu vieja en tanga");
	
	public void PanelAyuda(){
	}
	
	public void armarPanel() {
		this.add(lblAyuda);
	}
}
