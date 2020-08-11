package dao;

import java.util.ArrayList;

import dominio.Camion;

public interface CamionDao {
	public Integer getUltimoId();
	public Camion recuperarCamionId(Camion c);
	public Camion recuperarCamionPatente(Camion c);
	public Camion updateCamion(Camion c);
	public Camion altaCamion(Camion c);
	public Camion bajaCamion(Camion c);
	public ArrayList<Camion> recuperarCamionTodos();
	public Camion updateKmCamion(Camion c);
	


}
