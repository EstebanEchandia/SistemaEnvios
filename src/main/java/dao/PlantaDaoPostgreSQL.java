package dao;

import dominio.Planta;

public class PlantaDaoPostgreSQL implements PlantaDao{
	
	
	
	
	@Override
	public Planta saveOrUpdatePlanta() {
		return new Planta();
		
	};
	
	@Override
	public Planta buscarPlanta() {
		return new Planta();
		
	};

}
