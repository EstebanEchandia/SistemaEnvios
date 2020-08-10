package gestor;

import java.time.LocalDate;
import dominio.Pedido;
import enums.EstadoPedido;
import servicios.PedidoServicio;

public class GestorPedido {
	
	private PedidoServicio pedidoServicio = new PedidoServicio();
	
	public void altaPedido(Integer numeroDeOrden, LocalDate fechaSolicitud, LocalDate fechaEntrega, EstadoPedido estado,
			Integer plantaDestino, Integer plantaOrigen, Integer envio) {
		
		Pedido p = new Pedido(1,  fechaSolicitud,  fechaEntrega,  estado,
				 plantaDestino,  plantaOrigen,  envio);
		
		pedidoServicio.altaPedido(p);
		
		
	}
	
	public void modificarEstadoPedido(Pedido p, EstadoPedido e) {
		p.setEstado(e);
		pedidoServicio.modificarEstadoPedido(p);
	
	}
}
