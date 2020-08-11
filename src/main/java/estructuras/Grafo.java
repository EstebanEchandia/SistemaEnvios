package estructuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class Grafo<T> {
	private List<Arista<T>> aristas;
	private List<Vertice<T>> vertices;

	public Grafo(){
		this.aristas = new ArrayList<Arista<T>>();
		this.vertices = new ArrayList<Vertice<T>>();
	}
	
	
	

	public List<Arista<T>> getAristas() {
		return aristas;
	}




	public void setAristas(List<Arista<T>> aristas) {
		this.aristas = aristas;
	}




	public List<Vertice<T>> getVertices() {
		return vertices;
	}




	public void setVertices(List<Vertice<T>> vertices) {
		this.vertices = vertices;
	}




	public void addNodo(T nodo){
		this.addNodo(new Vertice<T>(nodo));
	}

	private void addNodo(Vertice<T> nodo){
		this.vertices.add(nodo);
	}
	
	public void conectar(T n1,T n2){
		this.conectar(getNodo(n1), getNodo(n2), 0.0);
	}

	public void conectar(T n1,T n2,Number valor){
		this.conectar(getNodo(n1), getNodo(n2), valor);
	}

	private void conectar(Vertice<T> nodo1,Vertice<T> nodo2,Number valor){
		this.aristas.add(new Arista<T>(nodo1,nodo2,valor));
	}
	
	public Vertice<T> getNodo(T valor){
		return this.vertices.get(this.vertices.indexOf(new Vertice<T>(valor)));
	}

	public List<T> getAdyacentes(T valor){ 
		Vertice<T> unNodo = this.getNodo(valor);
		List<T> salida = new ArrayList<T>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin().getValor());
			}
		}
		return salida;
	}
	

	private List<Vertice<T>> getAdyacentes(Vertice<T> unNodo){ 
		List<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin());
			}
		}
		return salida;
	}
	
	private List<Vertice<T>> getAdyacentesMayorCero(Vertice<T> unNodo){ 
		List<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Arista<T> enlace : this.aristas){
			if((int) (enlace.getValor())>0 && enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin());
			}
		}
		return salida;
	}
	
	public void imprimirAristas(){
		System.out.println(this.aristas.toString());
	}

	public Integer gradoEntrada(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getFin().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getInicio().equals(vertice)) ++res;
		}
		return res;
	}

	public List<T> recorridoAnchura(Vertice<T> inicio){
		List<T> resultado = new ArrayList<T>();
		//estructuras auxiliares
		Queue<Vertice<T>> pendientes = new LinkedList<Vertice<T>>();
		HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
		marcados.add(inicio);
		pendientes.add(inicio);
		
		while(!pendientes.isEmpty()){
			Vertice<T> actual = pendientes.poll();
			List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<T> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.add(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
	
	public List<T> recorridoProfundidad(Vertice<T> inicio){
		List<T> resultado = new ArrayList<T>();
		Stack<Vertice<T>> pendientes = new Stack<Vertice<T>>();
		HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
		marcados.add(inicio);
		pendientes.push(inicio);
		
		while(!pendientes.isEmpty()){
			Vertice<T> actual = pendientes.pop();
			List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<T> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.push(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
 	
	public List<T> recorridoTopologico(){
		List<T> resultado = new ArrayList<T>();
		Map<Vertice<T>,Integer> gradosVertice = new HashMap<Vertice<T>,Integer>();
		for(Vertice<T> vert : this.vertices){
			gradosVertice.put(vert, this.gradoEntrada(vert));
		}
		while(!gradosVertice.isEmpty()){
		
			List<Vertice<T>> nodosSinEntradas = gradosVertice.entrySet()
							.stream()
							.filter( x -> x.getValue()==0)
							.map( p -> p.getKey())
							.collect( Collectors.toList());
			
            if(nodosSinEntradas.isEmpty()) System.out.println("TIENE CICLOS");
            
			for(Vertice<T> v : nodosSinEntradas){
            	resultado.add(v.getValor());
            	gradosVertice.remove(v);
            	for(Vertice<T> ady: this.getAdyacentes(v)){
            		gradosVertice.put(ady,gradosVertice.get(ady)-1);
            	}
            }
		}
		
		System.out.println(resultado);
		return resultado;
 	}
        
    private boolean esAdyacente(Vertice<T> v1,Vertice<T> v2){
    	List<Vertice<T>> ady = this.getAdyacentes(v1);
        for(Vertice<T> unAdy : ady){
        	if(unAdy.equals(v2)) return true;
        }
        return false;
    }
    

    public Boolean hayCamino(Vertice<T> v1,Vertice<T> v2) {
    	List<Vertice<T>> adyacentes = getAdyacentes(v1);
    	for(Vertice<T> vAdy : adyacentes) {
    		if(vAdy.equals(v2)) {
    			return true;
    		} else {
    			return hayCamino(vAdy, v2);
    		}
    	}
    	return false;
    }
    
    public Boolean hayCaminoMayorCero(Vertice<T> v1,Vertice<T> v2) {
    	List<Vertice<T>> adyacentes = getAdyacentesMayorCero(v1);
    	for(Vertice<T> vAdy : adyacentes) {
    		if(vAdy.equals(v2)) {
    			return true;
    		} else {
    			return hayCaminoMayorCero(vAdy, v2);
    		}
    	}
    	return false;
    }
    
    public List<Arista<T>> caminoEntreVertices(Vertice<T> v1,Vertice<T> v2, List<Arista<T>> aux) {
    	List<Arista<T>> aux2 = aux;
    	List<Vertice<T>> adyacentes = getAdyacentesMayorCero(v1);
    	for(Vertice<T> vAdy : adyacentes) {
    		if(vAdy.equals(v2)) {
    			return aux2;
    		} else {
    			for(Arista<T> enlace : this.aristas){
    				if(enlace.getInicio().equals(v1) && enlace.getFin().equals(vAdy))
    					aux2.add(enlace);
    				return caminoEntreVertices(vAdy, v2,aux2);
    			}
    		}
    	}
		return null;
    }    
    
    
	/**
     * Implementacion de flujo maximo
     *
     * @return El flujo maximo entre la fuente y el sumidero de la red.
     * @throws IllegalStateException En caso de no ser valida la red.
     */
    public Double flujoMaximo(Vertice<T> origen, Vertice<T> destino) throws IllegalStateException{
	
    	Grafo aux = this;
    	
        // Validamos que haya un camino desde el origen al destino
        if(!aux.hayCamino(origen, destino))
            throw new IllegalStateException("Red invalida");

        // Flujo maximo de la red
        Double flujoMaximo = 0.0;
        
        // Creo una lista de aristas para guardar el camino de aristas que puede recorrer el flujo y un caminoVacio como varAux
        List<Arista<T>> camino;
        List<Arista<T>> caminoVacio = new ArrayList<Arista<T>>();
        
        // Mientras haya caminos donde pueda pasar flujo
        while ((hayCaminoMayorCero(origen, destino))){
        	
        	// Le asigno a "camino" un camino entre los vertices origen y destino
        	camino = caminoEntreVertices(origen,destino,caminoVacio);
            
            Double flujoMenor = camino.stream()
                    				.mapToDouble(e-> (Double) e.getValor())
                    				.min() 
                    				.getAsDouble();

            camino.forEach(e -> e.setValor((Double) e.getValor() - flujoMenor));
            flujoMaximo += flujoMenor;
        }

        return flujoMaximo;
    }
    
    public Double [] pageRank(){
    	int tamanio = this.aristas.size();
    	List<Vertice<T>> listaVerticesPageRank = new ArrayList<Vertice<T>>();
		Double [] listaValoresPageRank = new Double[tamanio] ;
    	
    	for(int i=0;i<tamanio;i++)
    		listaValoresPageRank[i] = 1.0;
    	
    	for(int i=0;i<30;i++) {
    		int indice = 0;
    		for(Vertice<T> aux:listaVerticesPageRank) {
    			this.pageRank(aux);
    			listaValoresPageRank[indice] = this.pageRank(aux);
    		}
    	}
    	return listaValoresPageRank;
    }
    
    public Double pageRank(Vertice<T> nodo) {
    	Double d = 0.5;
    	Double pr = 0.0;
    	Double prAux = (1-d) + d;
    	for(Vertice<T> aux:this.getAdyacentes(nodo)) {
    		pr += (pageRank(aux))/this.gradoSalida(aux);
    	};
    	
    	return pr*prAux;
    }
    
    /* Floyd-Warshall  */
    static int[][] P;
	static final int N = 4;
/*
	public static void main(String[] args) {
		int[][] M = { { 0, 5, 999, 999 }, { 50, 0, 15, 5 }, { 30, 999, 0, 15 },
				{ 15, 999, 5, 0 } };
		P = new int[N][N];
		System.out.println("Matrix to find the shortest path of.");
		printMatrix(M);
		System.out.println("Shortest Path Matrix.");
		printMatrix(FloydAlgo(M));
		System.out.println("Path Matrix");
		printMatrix(P);
	}
*/
	public static int[][] FloydAlgo(int[][] M) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// to keep track.;
					if (M[i][k] + M[k][j] < M[i][j]) {
						M[i][j] = M[i][k] + M[k][j];
						P[i][j] = k;
					}
				}
			}
		}
		return M;
	}

	public static int min(int i, int j) {
		if (i > j) {
			return j;
		}
		return i;
	}

	public static void printMatrix(int[][] Matrix) {
		System.out.print("\n\t");
		for (int j = 0; j < N; j++) {
			System.out.print(j + "\t");
		}
		System.out.println();
		for (int j = 0; j < 35; j++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(i + " |\t");
			for (int j = 0; j < N; j++) {
				System.out.print(Matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		System.out.println("\n");
	}
}
    

