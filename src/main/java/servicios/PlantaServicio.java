package servicios;

import dao.PlantaDao;
import dao.PlantaDaoPostgreSQL;
import dominio.Planta;

public class PlantaServicio {
	
	private PlantaDao pd = new PlantaDaoPostgreSQL();
	public Planta altaPlanta(Planta p) {
		return this.pd.altaPlanta(p);
	}

}
