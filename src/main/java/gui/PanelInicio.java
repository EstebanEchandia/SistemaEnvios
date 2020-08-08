package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInicio extends JPanel {
	
	private JLabel lblInicio = new JLabel("Sistema de Gestión Logística");
	
	private Image imagen = new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage();
	
	Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	
	public void PanelInicio(){
	}
	
	public void armarPanel() {
		
		this.setLayout(null);
		
		this.lblInicio.setBounds(265,55, 400, 40);
		this.lblInicio.setFont(new Font("Serif", Font.BOLD, 30));
		this.add(lblInicio);
	}
	
	public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this); 
        setOpaque(false);
        super.paint(g);
    }
}
