package dominio;

import java.time.LocalDate;
import enums.EstadoPedido;

public class Pedido {
	private Integer numeroDeOrden;
	private LocalDate fechaSolicitud;
	private LocalDate fechaEntrega;
	private EstadoPedido estado;
	private Integer plantaDestino;
	private Integer plantaOrigen;
	private Integer envio;
	
	
	
	
	public Pedido(Integer numeroDeOrden, LocalDate fechaSolicitud, LocalDate fechaEntrega, EstadoPedido estado,
			Integer plantaDestino, Integer plantaOrigen, Integer envio) {
		
		super();
		this.numeroDeOrden = numeroDeOrden;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.plantaDestino = plantaDestino;
		this.plantaOrigen = plantaOrigen;
		this.envio = envio;
	}
	
	
	
	public Integer getNumeroDeOrden() {
		return numeroDeOrden;
	}
	public void setNumeroDeOrden(Integer numeroDeOrden) {
		this.numeroDeOrden = numeroDeOrden;
	}
	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public EstadoPedido getEstado() {
		return estado;
	}
	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	public Integer getPlantaDestino() {
		return plantaDestino;
	}
	public void setPlantaDestino(Integer plantaDestino) {
		this.plantaDestino = plantaDestino;
	}
	public Integer getPlantaOrigen() {
		return plantaOrigen;
	}
	public void setPlantaOrigen(Integer plantaOrigen) {
		this.plantaOrigen = plantaOrigen;
	}
	public Integer getEnvio() {
		return envio;
	}
	public void setEnvio(Integer envio) {
		this.envio = envio;
	}
	
	
}
