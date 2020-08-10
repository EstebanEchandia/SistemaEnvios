package dao;

import dominio.Pedido;

public interface PedidoDao {
	
	public Integer altaPedido(Pedido p);

	public void modificarEstadoPedido(Pedido p);
	
	
}
