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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;


import gui.*;
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
	JMenuItem menuItemCamionBuscarPorAtributos;
	
	JMenuItem menuItemInsumoAlta;
	JMenuItem menuItemInsumoEditar;
	JMenuItem menuItemInsumoBaja;
	JMenuItem menuItemInsumoStock;
	JMenuItem menuItemInsumoVisualizarInsumos;
	
	JMenuItem menuItemPlantaAniadirPlanta;
	JMenuItem menuItemPlantaRegistrarRuta;
	JMenuItem menuItemPlantaBuscarPlanta;
	
	JButton inicio;
	
	Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	
	private void armarMenuCamion() {
		/*	Panel AltaCamion  */
		this.menuItemCamionAlta = new JMenuItem("Alta Camion");
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
			a.armarPanel(this);
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
		
		/*	Panel BuscarPorAtributos CAMION  */
		this.menuItemCamionBuscarPorAtributos = new JMenuItem("Buscar Por Atributos");
		this.menuItemCamionBuscarPorAtributos.addActionListener( e -> {
			PanelCamionBuscarPorAtributos a = new PanelCamionBuscarPorAtributos();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuCamion.add(menuItemCamionBuscarPorAtributos);
	}
	private void armarMenuPlanta() {
		
		/*  Panel Planta  */
		this.menuItemPlantaAniadirPlanta = new JMenuItem("Añadir Planta");
		this.menuItemPlantaAniadirPlanta.addActionListener( e -> {
			PanelPlantaAniadirPlanta a = new PanelPlantaAniadirPlanta();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuPlanta.add(menuItemPlantaAniadirPlanta);
		
		
		/*  Panel RegistrarRuta  */
		this.menuItemPlantaRegistrarRuta = new JMenuItem("Registrar Ruta entre dos Plantas");
		this.menuItemPlantaRegistrarRuta.addActionListener( e -> {
			PanelPlantaRegistrarRuta a = new PanelPlantaRegistrarRuta();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuPlanta.add(menuItemPlantaRegistrarRuta);
		
		/*  Panel BuscarPlantas  */
		this.menuItemPlantaBuscarPlanta = new JMenuItem("Buscar Plantas");
		this.menuItemPlantaBuscarPlanta.addActionListener( e -> {
			PanelPlantaBuscarPlanta a = new PanelPlantaBuscarPlanta();
			a.armarPanel(this);
		});

		this.menuPlanta.add(menuItemPlantaBuscarPlanta);
		
	}
	private void armarMenuInsumo() {
		
		/*  Panel AltaInsumo  */
		this.menuItemInsumoAlta = new JMenuItem("Alta Insumo");
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
		
		
		/*  Panel VisualizarInsumos  */
		this.menuItemInsumoVisualizarInsumos = new JMenuItem("Visualizar insumos");
		this.menuItemInsumoVisualizarInsumos.addActionListener( e -> {
			PanelInsumoVisualizarInsumos a = new PanelInsumoVisualizarInsumos();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});

		this.menuInsumo.add(menuItemInsumoVisualizarInsumos);
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
		
		this.inicio = new JButton("Inicio");
		this.inicio.addActionListener( e -> {
			this.remove(this.getContentPane());
			PanelInicio a = new PanelInicio();
			a.armarPanel();
			this.setContentPane(a);
			this.pack();
		});


		armarMenuCamion();
		armarMenuPlanta();
		armarMenuInsumo();
		armarMenuEnvio();
		armarMenuAyuda();
		

		/*  Añadimos los menus a la barra de menus   */
		menuBar.add(this.inicio);
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
		
		
		PanelInicio a = new PanelInicio();
		a.armarPanel();
		this.setContentPane(a);
		this.pack();
	}
	
	public static void main(String[] args) throws SQLException {
		App app = new App();
		app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		app.armarApp();
		app.setPreferredSize(new Dimension(900, 560));
		app.setSize(900, 560);
		app.setLocation(app.centro.x - (int) app.getSize().getWidth()/2,app.centro.y - (int)app.getSize().getHeight()/2);
		app.setIconImage(new ImageIcon(app.getClass().getResource("/imagenes/COVID19.png")).getImage());
		app.setResizable(false);
		app.setVisible(true);
	}
}
