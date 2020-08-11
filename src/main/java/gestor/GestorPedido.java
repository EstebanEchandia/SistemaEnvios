package gestor;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.Pedido;
import enums.EstadoPedido;
import servicios.PedidoServicio;

public class GestorPedido {
	
	private PedidoServicio pedidoServicio = new PedidoServicio();
	
	public Integer altaPedido(LocalDate fechaEntrega, Integer plantaDestino) {
		
		Pedido p = new Pedido(fechaEntrega,  plantaDestino);
		return pedidoServicio.altaPedido(p);
		
		
	}
	
	public void modificarEstadoPedido(Pedido p, EstadoPedido e) {
		p.setEstado(e);
		pedidoServicio.modificarEstadoPedido(p);
	
	}
	
	public ArrayList<ArrayList<String>> buscarPedidosCreados(){
		return pedidoServicio.buscarPedidosCreados();
	}
	public ArrayList<ArrayList <String>> buscarPedidosProcesados(){
		return pedidoServicio.buscarPedidosProcesados();
		}
	
	public ArrayList<ArrayList <String>> verDetalleOrden(Integer nroOrden){
		return pedidoServicio.verDetalleOrden(nroOrden);
		}
}
