package servicios;

import dao.RutaDao;
import dao.RutaDaoPostgreSQL;
import dominio.Ruta;

public class RutaServicio {
	
	private RutaDao rutaDao = new RutaDaoPostgreSQL();
	
	public void altaRuta(Ruta r) {
	
		rutaDao.altaRuta(r);
	}

}
