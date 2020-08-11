package dao;

import java.util.ArrayList;

import dominio.Ruta;

public interface RutaDao {
	
	public Ruta altaRuta(Ruta r);

	ArrayList<ArrayList<String>> recuperarRutas();



}
