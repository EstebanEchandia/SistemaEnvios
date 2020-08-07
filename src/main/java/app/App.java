package app;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
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
import gui.PanelInsumoDarAlta;
import gui.PanelInsumoDarBaja;
import gui.PanelInsumoEditar;
import gui.PanelPlanta;
import gui.PanelStockdeInsumo;
import dao.utils.DB;

public class App extends JFrame{
	JMenuBar menuBar;
	JMenu menuCamion;
	JMenu menuPlanta;
	JMenu menuInsumo;
	JMenu menuEnvio;
	JMenu menuAyuda;
	JMenuItem menuItemAyuda;
	
	JMenuItem menuItemCamionAlta;
	JMenuItem menuItemCamionEditar;
	JMenuItem menuItemCamionBaja;
	
	JMenuItem menuItemInsumoAlta;
	JMenuItem menuItemInsumoEditar;
	JMenuItem menuItemInsumoBaja;
	JMenuItem menuItemInsumoStock;
	
	JMenuItem menuItemPlanta;
	JMenuItem menuItemPlantaGrafo;
	
	Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	
	private void armarMenuCamion() {
		/*	Panel AltaCamion  */
		this.menuItemCamionAlta = new JMenuItem("Dar de alta Camion");
		this.menuItemCamionAlta.addActionListener( e -> {
			PanelCamionDarAlta a = new PanelCamionDarAlta();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuCamion.add(menuItemCamionAlta);
		
		
		/*	Panel EditarCamion  */
		this.menuItemCamionEditar = new JMenuItem("Editar Camion");
		this.menuItemCamionEditar.addActionListener( e -> {
			PanelCamionEditar a = new PanelCamionEditar();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuCamion.add(menuItemCamionEditar);
		
		/*	Panel BajaCamion  */
		this.menuItemCamionBaja = new JMenuItem("Baja Camion");
		this.menuItemCamionBaja.addActionListener( e -> {
			PanelCamionDarBaja a = new PanelCamionDarBaja();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuCamion.add(menuItemCamionBaja);
	}
	
	private void armarMenuPlanta() {
		
		/*  Panel Planta  */
		this.menuItemPlanta = new JMenuItem("Planta");
		this.menuItemPlanta.addActionListener( e -> {
			PanelPlanta a = new PanelPlanta();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuPlanta.add(menuItemPlanta);
		
		
		/*  Panel GrafoPlanta  */
		this.menuItemPlantaGrafo = new JMenuItem("Grafo Plantas");
		this.menuItemPlantaGrafo.addActionListener( e -> {
			PanelGrafoPlanta a = new PanelGrafoPlanta();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuPlanta.add(menuItemPlantaGrafo);
		
	}
	private void armarMenuInsumo() {
		
		/*  Panel AltaInsumo  */
		this.menuItemInsumoAlta = new JMenuItem("Dar de alta Insumo");
		this.menuItemInsumoAlta.addActionListener( e -> {
			PanelInsumoDarAlta a = new PanelInsumoDarAlta();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuInsumo.add(menuItemInsumoAlta);
		
		
		/*	Panel EditarInsumo  */
		this.menuItemInsumoEditar = new JMenuItem("Editar Insumo");
		this.menuItemInsumoEditar.addActionListener( e -> {
			PanelInsumoEditar a = new PanelInsumoEditar();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuInsumo.add(menuItemInsumoEditar);
		
		/*	Panel BajaInsumo  */
		this.menuItemInsumoBaja = new JMenuItem("Baja Insumo");
		this.menuItemInsumoBaja.addActionListener( e -> {
			PanelInsumoDarBaja a = new PanelInsumoDarBaja();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuInsumo.add(menuItemInsumoBaja);
		
		
		/*  Panel StockInsumo  */
		this.menuItemInsumoStock = new JMenuItem("Cambiar el stock de un insumo en todas las platas");
		this.menuItemInsumoStock.addActionListener( e -> {
			PanelStockdeInsumo a = new PanelStockdeInsumo();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuInsumo.add(menuItemInsumoStock);
	}
	private void armarMenuEnvio() {
		
	}
	private void armarMenuAyuda() {
		/*  Panel Ayuda  */
		this.menuItemAyuda = new JMenuItem("Manual");
		this.menuItemAyuda.addActionListener( e -> {
			PanelAyuda a = new PanelAyuda();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});
		this.menuItemAyuda.setMnemonic(KeyEvent.VK_F1);
		this.menuAyuda.add(menuItemAyuda);
	}

	private void armarApp() {
		this.menuBar = new JMenuBar();
		/*  Creo todos los menus desplegables de la barra  */
		this.menuCamion = new JMenu("Camion");
		this.menuPlanta = new JMenu("Planta");
		this.menuInsumo = new JMenu("Insumo");
		this.menuEnvio = new JMenu("Envio");
		this.menuAyuda = new JMenu("Ayuda");


		armarMenuCamion();
		armarMenuPlanta();
		armarMenuInsumo();
		armarMenuEnvio();
		armarMenuAyuda();
		

		/*  Añadimos los menus a la barra de menus   */
		menuBar.add(this.menuCamion);
		menuBar.add(this.menuPlanta);
		menuBar.add(this.menuInsumo);
		menuBar.add(this.menuEnvio);
		menuBar.add(this.menuAyuda);
		this.setJMenuBar(menuBar);
		this.addWindowListener( new WindowAdapter() {
			public void windowIconified(WindowEvent e) {
				System.out.println("AHORA SI");
			};
		});
	}
	public static void main(String[] args) throws SQLException {
		App app = new App();
		app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		app.armarApp();
		app.setPreferredSize(new Dimension(900, 560));
		app.setSize(900, 600);
		app.setLocation(app.centro.x - (int) app.getSize().getWidth()/2,app.centro.y - (int)app.getSize().getHeight()/2);
		app.setIconImage(new ImageIcon(app.getClass().getResource("/imagenes/COVID19.png")).getImage());
		app.setVisible(true);
		

		
		
	}
}
