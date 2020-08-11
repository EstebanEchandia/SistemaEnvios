/**
 * 
 */
package dominio;

import java.util.ArrayList;
import java.util.LinkedList;

import dominio.utils.Dijkstra;
import estructuras.Grafo;
import estructuras.Vertice;
import gestor.GestorPlanta;
import gestor.GestorRuta;


/**
 * @author esteb
 *
 */
public class GrafoPlantasDistancia extends Grafo<Planta>{
	
	private GestorPlanta gestorPlanta = new GestorPlanta();
	private GestorRuta gestorRuta = new GestorRuta();
	
	private ArrayList<Planta> listaPlantas= new ArrayList<Planta>();
	private ArrayList<Ruta> listaRutas = new ArrayList<Ruta>();
	
	public GrafoPlantasDistancia() { 
		listaPlantas = gestorPlanta.recuperarPlantasTodas();
		
		for(Planta p: listaPlantas) {
			this.addNodo(p);
		}
		
		listaRutas = gestorRuta.recuperarRutas();
		
		for(Ruta r: listaRutas) {
			this.conectar(gestorPlanta.recuperarPlantaId(r.getPlantaOrigen()), gestorPlanta.recuperarPlantaId(r.getPlantaDestino()), r.getDistanciaEnKm());
			
		}
		System.out.println(this.getVertices());
		this.aplicarDijkstra();
	}
	
	
	public void aplicarDijkstra() {
		
		Dijkstra algoritmo = new Dijkstra(this);
		
		algoritmo.ejecutar( getNodo(gestorPlanta.recuperarPlantaId(19)) );
		
		LinkedList<Vertice> res = algoritmo.getCamino( getNodo(gestorPlanta.recuperarPlantaId(25)) );
		System.out.println(res);
		
		
	}
	
	
	
	
	

	
	
}
