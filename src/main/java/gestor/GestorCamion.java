package gestor;

import java.time.LocalDate;

import dao.CamionDao;
import dao.CamionDaoPostgreSQL;
import dominio.Camion;
import servicios.CamionServicio;

public class GestorCamion {
	
	private CamionDao camionDao = new CamionDaoPostgreSQL();
	
	public void alta(String patente, String modelo, Double kmrecorridos, Double costoporkm, 
			Double costoporhora, LocalDate fechadecompra, Integer idplanta) {
			
			Integer ultimoIdCamion = camionDao.getUltimoId();
			
			Camion c = new Camion(ultimoIdCamion,patente,modelo,kmrecorridos,costoporkm,costoporhora,fechadecompra,idplanta);
			
			CamionServicio cs = new CamionServicio();
			
			cs.altaCamion(c);
		
		
		
	}
	
	public Camion updateCamion(Integer id, String patente, String modelo, Double kmrecorridos, Double costoporkm, 
			Double costoporhora, LocalDate fechadecompra, Integer idplanta) {
		
		
		 		return null;
	}
	
	
	public Camion recuperarCamion() {
		return null;
	}

}
