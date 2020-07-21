package app;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import gui.PanelAyuda;
import gui.PanelCamion;
import gui.PanelInsumo;
import gui.PanelPlanta;

public class App extends JFrame{
	JMenuBar menuBar;
	JMenu menuEntidades;
	JMenu menuAyuda;
	JMenuItem menuItemAyuda;
	JMenuItem menuItemCamion;
	JMenuItem menuItemPlanta;
	JMenuItem menuItemInsumo;

	private void armarApp() {
		this.menuBar = new JMenuBar();
		/*  Panel Camion  */
		this.menuEntidades = new JMenu("Entidades");
		this.menuItemCamion = new JMenuItem("Camion");
		this.menuItemCamion.addActionListener( e -> {
			System.out.println("LISTENER 1");
			PanelCamion a = new PanelCamion();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuEntidades.add(menuItemCamion);
		
		/*  Panel Planta  */
		this.menuItemPlanta = new JMenuItem("Planta");
		this.menuItemPlanta.addActionListener( e -> {
			System.out.println("LISTENER 1");
			PanelPlanta a = new PanelPlanta();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuEntidades.add(menuItemPlanta);
		
		
		/*  Panel Insumo  */
		this.menuItemInsumo = new JMenuItem("Insumo");
		this.menuItemInsumo.addActionListener( e -> {
			System.out.println("LISTENER 1");
			PanelInsumo a = new PanelInsumo();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuEntidades.add(menuItemInsumo);
		
		/*  Panel Ayuda  */
		this.menuAyuda = new JMenu("Ayuda");
		this.menuItemAyuda = new JMenuItem("Manual");
		this.menuItemAyuda.addActionListener( e -> {
			System.out.println("LISTENER 1");
			PanelAyuda a = new PanelAyuda();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});
		this.menuItemAyuda.setMnemonic(KeyEvent.VK_F1);
		this.menuAyuda.add(menuItemAyuda);

		/*  Aniadimos los menus a la barra de menus   */
		menuBar.add(this.menuEntidades );
		menuBar.add(this.menuAyuda);
		this.setJMenuBar(menuBar);
		this.addWindowListener( new WindowAdapter() {
			public void windowIconified(WindowEvent e) {
				System.out.println("AHORA SI");
			};
		});
	}
	public static void main(String[] args) {
		App app = new App();
		app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		app.armarApp();
		app.setPreferredSize(new Dimension(1020, 750));
		app.setSize(1020, 750);
		app.setVisible(true);
		System.out.println("app creada");
	}
}
