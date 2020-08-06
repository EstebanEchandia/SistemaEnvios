package gestor;

import java.time.LocalDate;

import dao.CamionDao;
import dao.CamionDaoPostgreSQL;
import died.ejemplos.gui.PanelCamiones;
import dominio.Camion;
import gui.PanelCamionDarAlta;
import servicios.CamionServicio;

public class GestorCamion {
	
	private CamionDao camionDao = new CamionDaoPostgreSQL();
	
	public void altaCamion(String patente, String modelo, Double kmrecorridos, Double costoporkm, 
			Double costoporhora, LocalDate fechadecompra, Integer idplanta) {
			
			//Integer ultimoIdCamion = camionDao.getUltimoId();
			
			Camion c = new Camion(1,patente,modelo,kmrecorridos,costoporkm,costoporhora,fechadecompra);
			
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
