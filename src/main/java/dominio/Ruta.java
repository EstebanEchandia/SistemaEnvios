/**
 * 
 */
package dominio;

import estructuras.Arista;

/**
 * @author esteb
 *
 */
public class Ruta  extends Arista{
	
	private String sigla;
	private Double distanciaEnKm;
	private Double duracionEnHoras;
	private Double CantMaxMaterialesATransportarEnKG;
	private Integer plantaOrigen;
	private Integer plantaDestino;
	
	public Ruta(String sigla, Double distanciaEnKm, Double duracionEnHoras, 
			Double cantMaxMaterialesATransportarEnKG,
			Integer plantaOrigen, Integer plantaDestino) {
		
		super();
		this.sigla = sigla;
		this.distanciaEnKm = distanciaEnKm;
		this.duracionEnHoras = duracionEnHoras;
		CantMaxMaterialesATransportarEnKG = cantMaxMaterialesATransportarEnKG;
		this.plantaOrigen = plantaOrigen;
		this.plantaDestino = plantaDestino;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Double getDistanciaEnKm() {
		return distanciaEnKm;
	}

	public void setDistanciaEnKm(Double distanciaEnKm) {
		this.distanciaEnKm = distanciaEnKm;
	}

	public Double getDuracionEnHoras() {
		return duracionEnHoras;
	}

	public void setDuracionEnHoras(Double duracionEnHoras) {
		this.duracionEnHoras = duracionEnHoras;
	}

	public Double getCantMaxMaterialesATransportarEnKG() {
		return CantMaxMaterialesATransportarEnKG;
	}

	public void setCantMaxMaterialesATransportarEnKG(Double cantMaxMaterialesATransportarEnKG) {
		CantMaxMaterialesATransportarEnKG = cantMaxMaterialesATransportarEnKG;
	}

	public Integer getPlantaOrigen() {
		return plantaOrigen;
	}

	public void setPlantaOrigen(Integer plantaOrigen) {
		this.plantaOrigen = plantaOrigen;
	}

	public Integer getPlantaDestino() {
		return plantaDestino;
	}

	public void setPlantaDestino(Integer plantaDestino) {
		this.plantaDestino = plantaDestino;
	}
	
	
	
}
