package servicios;

import dao.ItemPedidoDao;
import dao.ItemPedidoPostgreSQL;
import dominio.ItemPedido;

public class ItemPedidoServicio {

	ItemPedidoDao ipDao = new ItemPedidoPostgreSQL();
	 
	public void altaItemPedido(ItemPedido ip){	
		ipDao.altaItemPedido(ip);
	}
}
