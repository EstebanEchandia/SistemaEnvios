package dominio;

import java.util.ArrayList;

import gestor.GestorCamion;

public class Envio {
	private Double costo;
	private Integer id;
	private ArrayList<Ruta> rutas;
	private Integer idCamion;
	private Integer idPedido;
	public Envio(ArrayList<Ruta> rutas, Integer idCamion, Integer idPedido) {
		super();
		this.rutas = rutas;
		this.idCamion = idCamion;
		this.idPedido = idPedido;
		//this.costo = this.calcularCosto();
	}
	
	
//	Double calcularCosto() {
//		
//		GestorCamion gc = new GestorCamion();
//		Camion c = gc.recuperarCamionId(idCamion);
//		
//		
//		return c.getCostoPorHora() * Horas + c.getCostoPorKm() * KmEnLaRuta ;
//	}
}
