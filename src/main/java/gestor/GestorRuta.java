package gestor;

import dominio.Ruta;
import servicios.RutaServicio;

public class GestorRuta {
	
	private RutaServicio rs = new RutaServicio();
	
	public void altaRuta(String sigla, Double distanciaEnKm, Double duracionEnHoras, 
			Double cantMaxMaterialesATransportarEnKG,
			Integer plantaOrigen, Integer plantaDestino) {
		
		Ruta r = new Ruta(sigla,distanciaEnKm,duracionEnHoras,cantMaxMaterialesATransportarEnKG,plantaOrigen,plantaDestino);
		
		rs.altaRuta(r);
		
	}
}
