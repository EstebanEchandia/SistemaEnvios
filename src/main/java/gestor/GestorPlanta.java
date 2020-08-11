package gestor;

import java.util.ArrayList;

import dominio.GrafoPlantas;
import dominio.ItemPedido;
import dominio.Planta;
import dominio.Stock;
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
	
	
	public ArrayList<ArrayList<String>> recuperarPlantasConInsumoMenorAlPtoPedido(){
		return ps.recuperarPlantasConInsumoMenorAlPtoPedido();
	}
	
	public ArrayList<Planta> listarPlantasConStockDeItems(ArrayList<ItemPedido> items){
		ArrayList<Planta> listaTodasPlantas = new ArrayList<Planta>();// recuperar todas las plantas
		ArrayList<Planta> listaPlantasSinStock = new ArrayList<Planta>();
		
		Integer cantItems = items.size();
		for(Planta plantaActual:listaTodasPlantas) {
			Boolean tieneTodosLosItemsConStock = true;
			for(int i=0; i<cantItems && tieneTodosLosItemsConStock;i++) {
				Stock stockAux = new Stock(1.0,1.0,1,1);// recuperar un stock (plantaActual.getId(),items.get(i).getIdInsumo)
				if(stockAux.getCantidad()<items.get(i).getCantidad()) {
					tieneTodosLosItemsConStock = false;
				}
			}
			if(!tieneTodosLosItemsConStock)
				listaPlantasSinStock.add(plantaActual);
		}
		listaTodasPlantas.removeAll(listaPlantasSinStock);
		return listaTodasPlantas;
	}
	

}
