package servicios;


import java.util.ArrayList;

import dao.PedidoDao;
import dao.PedidoDaoPostgreSQL;
import dominio.Pedido;


public class PedidoServicio {

	
	private PedidoDao pd = new PedidoDaoPostgreSQL();
	
	public Integer altaPedido(Pedido p) {
		return this.pd.altaPedido(p);
	}

	public void modificarEstadoPedido(Pedido p) {
		this.pd.modificarEstadoPedido(p);
	}
	
	public ArrayList<ArrayList<String>> buscarPedidosCreados(){
		return pd.buscarPedidosCreados();
	}
	
	public ArrayList<ArrayList <String>> buscarPedidosProcesados(){
		
		return pd.buscarPedidosProcesados();
	}
}
