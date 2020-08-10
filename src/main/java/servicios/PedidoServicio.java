package servicios;


import dao.PedidoDao;
import dao.PedidoDaoPostgreSQL;
import dominio.Pedido;


public class PedidoServicio {

	
	private PedidoDao pd = new PedidoDaoPostgreSQL();
	
	public void altaPedido(Pedido p) {
		this.pd.altaPedido(p);
	}

	public void modificarEstadoPedido(Pedido p) {
		this.pd.modificarEstadoPedido(p);
	}
	
}
