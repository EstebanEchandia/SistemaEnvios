package dominio.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import estructuras.Arista;
import estructuras.Grafo;
import estructuras.Vertice;

public class Dijkstra {
	
	
	 	private final List<Vertice> nodos;
	    private final List<Arista> aristas;
	    private Set<Vertice> nodosSeteados;
	    private Set<Vertice> nodosNoSeteados;
	    private Map<Vertice, Vertice> predecesores;
	    private Map<Vertice, Double> distancia;
	
	    public Dijkstra(Grafo grafo) {
	    	this.nodos = new ArrayList<Vertice>(grafo.getVertices());
	    	this.aristas =  new ArrayList<Arista>(grafo.getAristas());
	    }
	    
	    public void ejecutar(Vertice inicio) { //test
	    	nodosSeteados = new HashSet<Vertice>();
	    	nodosNoSeteados = new HashSet<Vertice>();
	    	distancia = new HashMap<Vertice, Double>();
	    	
	    	distancia.put(inicio, 0d);
	    	nodosNoSeteados.add(inicio);
	    	
	    	while(nodosNoSeteados.size()>0) {
	    		
	    		Vertice nodo = getMinimo(nodosNoSeteados);
	    		nodosSeteados.add(nodo);
	    		nodosNoSeteados.remove(nodo);
	    		
	    		encontrarDistanciaMasCorta(nodo); 
	    	}   
	    }
	    
	    private void encontrarDistanciaMasCorta(Vertice nodo) { //test
	    	List<Vertice> nodosAdyacentes = getAdyacentes(nodo);
	    	for(Vertice target: nodosAdyacentes) {
	    		if(getDistanciaMasCorta(target) > getDistanciaMasCorta(nodo) + getDistancia(nodo,target)) {
	    			distancia.put(target, getDistanciaMasCorta(nodo)+getDistancia(nodo,target));
	    			
	    			
	    			predecesores.put(target, nodo);//ACA RIPEA
	    			
	    			nodosNoSeteados.add(target);
	    		}
	    	}
	    }
	    
	 
	  
	        
	    
	    
	    private Double getDistancia(Vertice nodo, Vertice target) { //test
	    	for(Arista a: aristas) {
	    		if(a.getInicio().equals(nodo) && a.getFin().equals(target)) return (Double) a.getValor();
	    	}
	    	throw new RuntimeException("No deberia pasar nunca, el equals ta roto");
	    }
	    
	    private List<Vertice> getAdyacentes(Vertice nodo){ //test
	    	List<Vertice> adyacentes = new ArrayList<Vertice>();
	    	for(Arista a: aristas) {
	    		if(a.getInicio().equals(nodo) && !estaSeteado(a.getFin())) {
	    			adyacentes.add(a.getFin());
	    		}
	    	}
	    	return adyacentes;
	    }
	    
	    
	    private boolean estaSeteado(Vertice nodo) { 
	    	return nodosSeteados.contains(nodo);
	    }
	    
	    
	    private Double getDistanciaMasCorta(Vertice direccion) { //test
	    	Double d = distancia.get(direccion);
	    	if(d == null) {
	    		return  Double.MAX_VALUE;
	    	}else {
	    		return d;
	    	}
	    }
	    
	    
	    private Vertice getMinimo(Set<Vertice> vertices) { //test
	    	Vertice minimo = null;
	    	for(Vertice v: vertices) {
	    		if(minimo == null) {
	    			minimo = v;
	    		}
	    		else {
	    			if(getDistanciaMasCorta(v) < getDistanciaMasCorta(minimo)) {
	    				minimo = v;
	    			}
	    		}
	    	}
	    	return minimo;
	    }
	    
	    public LinkedList<Vertice> getCamino(Vertice target){
	    	LinkedList<Vertice> camino = new LinkedList<Vertice>();
	    	Vertice paso = target;
	    	if(predecesores.get(paso) == null) {
	    		return null;
	    	}
	    	camino.add(paso);
	    	while(predecesores.get(paso) != null) {
	    		paso = predecesores.get(paso);
	    		camino.add(paso);
	    	}
	    	Collections.reverse(camino);
	    	return camino;
	    }
	    
}
