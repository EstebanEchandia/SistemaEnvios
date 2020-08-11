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
    private final List<Vertice> nodes;
    private final List<Arista> Aristas;
    private Set<Vertice> settledNodes;
    private Set<Vertice> unSettledNodes;
    private Map<Vertice, Vertice> predecessors;
    private Map<Vertice, Double> distance;

	
    public Dijkstra(Grafo graph) {
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<Vertice>(graph.getVertices());
        this.Aristas = new ArrayList<Arista>(graph.getAristas());
    }

    public void execute(Vertice source) {
        settledNodes = new HashSet<Vertice>();
        unSettledNodes = new HashSet<Vertice>();
        distance = new HashMap<Vertice, Double>();
        predecessors = new HashMap<Vertice, Vertice>();
        distance.put(source, 0d);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Vertice node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Vertice node) {
        List<Vertice> adjacentNodes = getNeighbors(node);
        for (Vertice target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    private Double getDistance(Vertice node, Vertice target) {
        for (Arista Arista : Aristas) {
            if (Arista.getInicio().equals(node)
                    && Arista.getFin().equals(target)) {
                return (Double) Arista.getValor();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertice> getNeighbors(Vertice node) {
        List<Vertice> neighbors = new ArrayList<Vertice>();
        for (Arista Arista : Aristas) {
            if (Arista.getInicio().equals(node)
                    && !isSettled(Arista.getFin())) {
                neighbors.add(Arista.getFin());
            }
        }
        return neighbors;
    }

    private Vertice getMinimum(Set<Vertice> Verticees) {
        Vertice minimum = null;
        for (Vertice Vertice : Verticees) {
            if (minimum == null) {
                minimum = Vertice;
            } else {
                if (getShortestDistance(Vertice) < getShortestDistance(minimum)) {
                    minimum = Vertice;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertice Vertice) {
        return settledNodes.contains(Vertice);
    }

    private Double getShortestDistance(Vertice destination) {
        Double d = distance.get(destination);
        if (d == null) {
            return Double.MAX_VALUE;
        } else {
            return d;
        }
    }
    
    public LinkedList<Vertice> getPath(Vertice target) {
        LinkedList<Vertice> path = new LinkedList<Vertice>();
        Vertice step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
    
}
