package dao;

import dominio.Camion;

public interface CamionDao {
	public Integer getUltimoId();
	public Camion recuperarCamion(Camion c);
	public Camion updateCamion(Camion c);
	public Camion altaCamion(Camion c);
	public Camion bajaCamion(Camion c);
	


}
