package dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Camion {
	private Integer id;
	private String patente;
	private String modelo;
	private Double kmRecorridos;
	private Double costoPorKm;
	private Double costoPorHora;
	private LocalDate fechaDeCompra;
	private ArrayList<Envio> envios;
	private Planta planta;
	
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getKmRecorridos() {
		return kmRecorridos;
	}
	public void setKmRecorridos(Double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	public Double getCostoPorKm() {
		return costoPorKm;
	}
	public void setCostoPorKm(Double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}
	public Double getCostoPorHora() {
		return costoPorHora;
	}
	public void setCostoPorHora(Double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}
	public LocalDate getFechaDeCompra() {
		return fechaDeCompra;
	}
	public void setFechaDeCompra(LocalDateTime fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}
	public ArrayList<Envio> getEnvios() {
		return envios;
	}
	public void setEnvios(ArrayList<Envio> envios) {
		this.envios = envios;
	}
	public Integer getPlanta() {
		return planta.getId();
	}
	public void setPlanta(Planta planta) {
		this.planta = planta;
	}
	
}
