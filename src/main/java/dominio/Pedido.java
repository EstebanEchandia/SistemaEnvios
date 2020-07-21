package dominio;

import java.time.LocalDateTime;

import enums.EstadoPedido;

public class Pedido {
	private String numeroDeOrden;
	private LocalDateTime fechaSolicitud;
	private LocalDateTime fechaEntrega;
	private EstadoPedido estado;
	private Planta plantaDestino;
	private Planta plantaOrigen;
	private Envio envio;
}
