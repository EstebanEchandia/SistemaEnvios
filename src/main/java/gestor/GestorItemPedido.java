package gestor;

import dominio.ItemPedido;
import servicios.ItemPedidoServicio;

public class GestorItemPedido {
	
	ItemPedidoServicio ipServicio = new ItemPedidoServicio();
	
	public void altaItemPedido(Double cantidad, Integer numeroDeOrden, Integer idInsumo) {
		
		ItemPedido ip = new ItemPedido(cantidad, numeroDeOrden, idInsumo);
		ipServicio.altaItemPedido(ip);
	}

}
