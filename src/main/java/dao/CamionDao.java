package dao;

import dominio.Camion;

public interface CamionDao {
	public Camion recuperarCamion();
	public Camion altaOModificacionCamion(Camion c);

}
