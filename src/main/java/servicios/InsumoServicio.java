package servicios;

import java.util.ArrayList;

import dao.InsumoDao;
import dao.InsumoDaoPostgreSQL;
import dominio.Camion;
import dominio.Insumo;
import dominio.InsumoGeneral;
import dominio.InsumoLiquido;

public class InsumoServicio {

	private InsumoDao insumoDao = new InsumoDaoPostgreSQL();
	
	public InsumoGeneral altaInsumoGeneral(InsumoGeneral i) {
		return this.insumoDao.altaInsumoGeneral(i);	
	}
	
	public InsumoGeneral updateInsumoGeneral(InsumoGeneral i) {
		return this.insumoDao.updateInsumoGeneral(i);	
	}
	
	
	public InsumoLiquido altaInsumoLiquido (InsumoLiquido i) {
		
		return this.insumoDao.altaInsumoLiquido(i);	
	}
	
	public InsumoLiquido updateInsumoLiquido(InsumoLiquido i) {
		return this.insumoDao.updateInsumoLiquido(i);	
	}

	public void bajaInsumo(Integer id) {
		this.insumoDao.bajaInsumo(id);	
	}

	
	public ArrayList<Insumo> recuperarInsumoTodos() {
		return this.insumoDao.recuperarInsumoTodos();
		}
	
	
}
