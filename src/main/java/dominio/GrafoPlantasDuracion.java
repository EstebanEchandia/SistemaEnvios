/**
 * 
 */
package dominio;

import java.util.ArrayList;

import estructuras.Grafo;
import gestor.GestorPlanta;
import gestor.GestorRuta;

/**
 * @author esteb
 *
 */
public class GrafoPlantasDuracion extends Grafo<Planta>{
	
	private GestorPlanta gestorPlanta = new GestorPlanta();
	private GestorRuta gestorRuta = new GestorRuta();
	
	private ArrayList<Planta> listaPlantas= new ArrayList<Planta>();
	private ArrayList<Ruta> listaRutas = new ArrayList<Ruta>();
	
	public GrafoPlantasDuracion() { 
		listaPlantas = gestorPlanta.recuperarPlantasTodas();
		
		for(Planta p: listaPlantas) {
			this.addNodo(p);
		}
		
		listaRutas = gestorRuta.recuperarRutas();
		
		for(Ruta r: listaRutas) {
			this.conectar(gestorPlanta.recuperarPlantaId(r.getPlantaOrigen()), gestorPlanta.recuperarPlantaId(r.getPlantaDestino()), r.getDuracionEnHoras());
		}
	}
	
	
	
	
	

	
	
}