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
import gui.PanelCamionDarAlta;
import gui.PanelCamionDarBaja;
import gui.PanelCamionEditar;
import gui.PanelGrafoPlanta;
import gui.PanelInsumo;
import gui.PanelPlanta;

public class App extends JFrame{
	JMenuBar menuBar;
	JMenu menuEntidades;
	JMenu menuCamion;
	JMenu menuPedido;
	JMenu menuInsumo;
	JMenu menuEnvio;
	JMenu menuAyuda;
	JMenuItem menuItemAyuda;
	
	JMenuItem menuItemCamionAlta;
	JMenuItem menuItemCamionEditar;
	JMenuItem menuItemCamionBaja;
	
	JMenuItem menuItemPlanta;
	JMenuItem menuItemInsumo;

	private void armarApp() {
		this.menuBar = new JMenuBar();
		/*  Creo todos los menus desplegables de la barra  */
		this.menuEntidades = new JMenu("Entidades");
		this.menuCamion = new JMenu("Camion");
		this.menuAyuda = new JMenu("Ayuda");


		
		/*	Panel AltaCamion  */
		this.menuItemCamionAlta = new JMenuItem("Dar de alta Camion");
		this.menuItemCamionAlta.addActionListener( e -> {
			System.out.println("Panel alta Camion");
			PanelCamionDarAlta a = new PanelCamionDarAlta();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuCamion.add(menuItemCamionAlta);
		
		
		/*	Panel EditarCamion  */
		this.menuItemCamionEditar = new JMenuItem("Editar Camion");
		this.menuItemCamionEditar.addActionListener( e -> {
			System.out.println("Panel editar Camion");
			PanelCamionEditar a = new PanelCamionEditar();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuCamion.add(menuItemCamionEditar);
		
		/*	Panel BajaCamion  */
		this.menuItemCamionBaja = new JMenuItem("Baja Camion");
		this.menuItemCamionBaja.addActionListener( e -> {
			System.out.println("Panel baja Camion");
			PanelCamionDarBaja a = new PanelCamionDarBaja();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuCamion.add(menuItemCamionBaja);
		
		
		/*  Panel Planta  */
		this.menuItemPlanta = new JMenuItem("Planta");
		this.menuItemPlanta.addActionListener( e -> {
			System.out.println("Panel Planta");
			PanelPlanta a = new PanelPlanta();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuEntidades.add(menuItemPlanta);
		
		
		/*  Panel Insumo  */
		this.menuItemInsumo = new JMenuItem("Insumo");
		this.menuItemInsumo.addActionListener( e -> {
			System.out.println("Panel Insumo");
			PanelInsumo a = new PanelInsumo();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuEntidades.add(menuItemInsumo);
		
		
		/*  Panel GrafoPlanta  */
		this.menuItemInsumo = new JMenuItem("Grafo Plantas");
		this.menuItemInsumo.addActionListener( e -> {
			System.out.println("Panel GrafoPlanta");
			PanelGrafoPlanta a = new PanelGrafoPlanta();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuEntidades.add(menuItemInsumo);
		
		/*  Panel Ayuda  */
		this.menuItemAyuda = new JMenuItem("Manual");
		this.menuItemAyuda.addActionListener( e -> {
			System.out.println("Panel Ayuda");
			PanelAyuda a = new PanelAyuda();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});
		this.menuItemAyuda.setMnemonic(KeyEvent.VK_F1);
		this.menuAyuda.add(menuItemAyuda);

		/*  Aniadimos los menus a la barra de menus   */
		menuBar.add(this.menuEntidades);
		menuBar.add(this.menuCamion);
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
