package dao;


import java.util.ArrayList;

import dominio.Planta;

public interface PlantaDao {
	
	public Planta updatePlanta(Planta p);
	public Planta altaPlanta(Planta p);
	public Planta bajaPlanta(Planta p);
	
	public ArrayList<Planta> recuperarPlantasTodas();
	
	public ArrayList<ArrayList<String>> recuperarPlantasConInsumoMenorAlPtoPedido();
	
	

}
