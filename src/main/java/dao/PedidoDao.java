package dao;

import java.util.ArrayList;

import dominio.Pedido;

public interface PedidoDao {
	
	public Integer altaPedido(Pedido p);

	public void modificarEstadoPedido(Pedido p);
	
	public ArrayList<ArrayList<String>> buscarPedidosCreados();

	ArrayList<ArrayList<String>> buscarPedidosProcesados();
}
