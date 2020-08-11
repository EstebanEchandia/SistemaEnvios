package gestor;

import java.util.ArrayList;

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
	
	public ArrayList<Ruta> recuperarRutas(){ 
		ArrayList<Ruta> res = new ArrayList<Ruta>();
		ArrayList<ArrayList<String>> stringRutas =  rs.recuperarRutas();
		
		for(ArrayList<String> fila: stringRutas) {
			res.add(new Ruta(fila.get(0),
					Double.parseDouble(fila.get(1)),
					Double.parseDouble(fila.get(2)),
					Double.parseDouble(fila.get(3)),
					Integer.parseInt(fila.get(4)),
					Integer.parseInt(fila.get(5)))
					);
			
		}
		return res;
	}
}
