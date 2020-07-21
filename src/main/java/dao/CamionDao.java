package dao;

import dominio.Camion;

public interface CamionDao {
	public Camion altaCamion();
	public Camion recuperarCamion();
	public Camion modificarCamion();
}
