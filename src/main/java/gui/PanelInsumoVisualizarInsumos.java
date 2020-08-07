package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PanelInsumoVisualizarInsumos extends JPanel {
	
	private JTable tblInsumos = new JTable();
	
	
	public void PanelInsumo(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.setBackground(Color.orange);
		
		this.tblInsumos = new JTable();
		this.tblInsumos.setBounds(120, 20, 630,430);
		this.add(tblInsumos);

	}
}
