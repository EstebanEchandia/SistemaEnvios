package dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Camion {
	private String patente;
	private String modelo;
	private Double kmRecorridos;
	private Double costoPorKm;
	private Double costoPorHora;
	private LocalDateTime fechaDeCompra;
	private ArrayList<Envio> envios;
	private Planta planta;
}
