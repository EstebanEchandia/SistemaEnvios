package dao;

import dominio.Pedido;

public interface PedidoDao {
	public Pedido altaPedido();
	public Pedido bajaPedido();
	public Pedido modificarPedido();
}
