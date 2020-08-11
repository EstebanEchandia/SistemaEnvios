package app;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;


import gui.*;

@SuppressWarnings("serial")
public class App extends JFrame{
	
	JMenuBar menuBar;
	JMenu menuCamion;
	JMenu menuPlanta;
	JMenu menuInsumo;
	JMenu menuOrdenPedido;
	
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
	JMenuItem menuItemPlantaVisualizarPlantasConAlgunInsumoConStockMenorAlPuntoDePedido;
	
	JMenuItem menuItemRegistrarOrdenPedido;
	JMenuItem menuItemOrdenPedidoProcesada;
	JMenuItem menuItemOrdenPedidoCreada;
	
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
		this.menuItemPlantaBuscarPlanta = new JMenuItem("Añadir stock");
		this.menuItemPlantaBuscarPlanta.addActionListener( e -> {
			PanelPlantaBuscarPlanta a = new PanelPlantaBuscarPlanta();
			a.armarPanel(this);
		});

		this.menuPlanta.add(menuItemPlantaBuscarPlanta);
		
		/*  Panel  VisualizarPlantas */
		this.menuItemPlantaVisualizarPlantasConAlgunInsumoConStockMenorAlPuntoDePedido = new JMenuItem("Visualizar plantas con algun insumo con stock menor al punto de pedido");
		this.menuItemPlantaVisualizarPlantasConAlgunInsumoConStockMenorAlPuntoDePedido.addActionListener( e -> {
			PanelPlantasVisualizarPlantas a = new PanelPlantasVisualizarPlantas();
			a.armarPanel(this);
		});

		this.menuPlanta.add(menuItemPlantaVisualizarPlantasConAlgunInsumoConStockMenorAlPuntoDePedido);
		
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
			a.armarPanel(this);
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
	private void armarMenuOrdenPedido() {
		
		/*  Panel RegistrarOrdenPedido  */
		this.menuItemRegistrarOrdenPedido = new JMenuItem("Registrar Orden Pedido");
		this.menuItemRegistrarOrdenPedido.addActionListener( e -> {
			PanelRegistroOrdenDePedido a = new PanelRegistroOrdenDePedido();
			a.armarPanel(this);
		});

		this.menuOrdenPedido.add(menuItemRegistrarOrdenPedido);
		
		/*  Panel BuscarOrdenesCreadas  */
		this.menuItemRegistrarOrdenPedido = new JMenuItem("Buscar Ordenes creadas");
		this.menuItemRegistrarOrdenPedido.addActionListener( e -> {
			PanelBuscarOrdenesCreadas a = new PanelBuscarOrdenesCreadas();
			a.armarPanel(this);
		});

		this.menuOrdenPedido.add(menuItemRegistrarOrdenPedido);
		
		/*  Panel BuscarOrdenesProcesadas  */
		this.menuItemRegistrarOrdenPedido = new JMenuItem("Buscar Ordenes procesadas");
		this.menuItemRegistrarOrdenPedido.addActionListener( e -> {
			PanelBuscarOrdenesProcesadas a = new PanelBuscarOrdenesProcesadas();
			a.armarPanel(this);
		});

		this.menuOrdenPedido.add(menuItemRegistrarOrdenPedido);
	}

	private void armarApp() {
		
		this.menuBar = new JMenuBar();
		/*  Creo todos los menus desplegables de la barra  */
		this.menuCamion = new JMenu("Camion");
		this.menuPlanta = new JMenu("Planta");
		this.menuInsumo = new JMenu("Insumo");
		this.menuOrdenPedido = new JMenu("Orden de Pedido");
	
		
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
		armarMenuOrdenPedido();
	
		

		/*  Añadimos los menus a la barra de menus   */
		menuBar.add(this.inicio);
		menuBar.add(this.menuCamion);
		menuBar.add(this.menuPlanta);
		menuBar.add(this.menuInsumo);
		menuBar.add(this.menuOrdenPedido);
		
		
		this.setJMenuBar(menuBar);
		
		
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
