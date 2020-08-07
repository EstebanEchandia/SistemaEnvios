package servicios;

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
	
	public Camion bajaCamion(Camion c) {
		
		return this.camionDao.bajaCamion(c);
	}
	
	public Camion recuperarCamion(Camion c) {
		
		return this.camionDao.recuperarCamion(c);
	}
}
