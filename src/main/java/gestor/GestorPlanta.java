package gestor;

import java.util.ArrayList;

import dominio.GrafoPlantas;
import dominio.Planta;
import servicios.PlantaServicio;

public class GestorPlanta {
	
	
	private Planta p;
	private GrafoPlantas grafo;
	private PlantaServicio ps = new PlantaServicio();
	
	
	public void altaPlanta(String nombre) {
		
		Planta p = new Planta(1,nombre);
		
		
		ps.altaPlanta(p);
		
	}
	
	Planta buscarPlanta(String id) {
	
		return p;
	}
	
	Double getFlujoMaximo(Planta pA, Planta pB) {
		
			return 0.0;
	}
	
	ArrayList<Planta> getListaPlantasOrdenadasPorPageRank() {
		
		return new ArrayList<Planta>();
	}
	
	public ArrayList<Planta> recuperarPlantasTodas() {
		return this.ps.recuperarPlantasTodas();
	}
	

}
