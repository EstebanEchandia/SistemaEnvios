package servicios;

import java.util.ArrayList;

import dao.CamionDao;
import dao.CamionDaoPostgreSQL;
import dominio.Camion;

public class CamionServicio {
	
	private CamionDao camionDao = new CamionDaoPostgreSQL();

	public Camion altaCamion(Camion c) {
	
		return this.camionDao.altaCamion(c);
	}
	
	public Camion updateCamion(Camion c) {
		
		return this.camionDao.updateCamion(c);
	}
	
	public Camion updateKmCamion(Camion c) {
		
		return this.camionDao.updateKmCamion(c);
	}
	
	public Camion bajaCamion(Camion c) {
		 
		return this.camionDao.bajaCamion(c);
	}
	
	public Camion recuperarCamionId(Camion c) {
		
		return this.camionDao.recuperarCamionId(c);
	}
	
	public Camion recuperarCamionPatente(Camion c) {
		
		return this.camionDao.recuperarCamionPatente(c);
	}
	
	public ArrayList<Camion> recuperarCamionTodos() {
	
		return this.camionDao.recuperarCamionTodos();
	}

}
