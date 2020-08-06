package dao;

import dominio.Camion;

public interface CamionDao {
	public Integer getUltimoId();
	public Camion recuperarCamion();
	public Camion updateCamion(Camion c);
	public Camion altaCamion(Camion c);
	


}
