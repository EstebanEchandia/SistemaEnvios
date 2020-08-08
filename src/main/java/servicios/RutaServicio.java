package servicios;

import dao.RutaDao;
import dao.RutaDaoPostgreSql;
import dominio.Ruta;

public class RutaServicio {
	
	private RutaDao rutaDao = new RutaDaoPostgreSql();
	
	public void altaRuta(Ruta r) {
	
		rutaDao.altaRuta(r);
	}

}
