package dao;

import dominio.Pedido;

public interface PedidoDao {
	
	public void altaPedido(Pedido p);

	public void modificarEstadoPedido(Pedido p);
	
	
}
