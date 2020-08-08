/**
 * 
 */
package gestor;

import java.util.ArrayList;

import dominio.Camion;
import dominio.Insumo;
import dominio.InsumoGeneral;
import dominio.InsumoLiquido;
import enums.Unidad;
import servicios.CamionServicio;
import servicios.InsumoServicio;

/**
 * @author esteb
 *
 */
public class GestorInsumo {
	
	public Insumo i;
	
	InsumoServicio is = new InsumoServicio();
	
	public void altaInsumoGeneral(String descripcion, Double costo, Unidad unidad, Double peso) {
		InsumoGeneral i = new InsumoGeneral(1, descripcion, costo, unidad, peso);
		is.altaInsumoGeneral(i);	
	}
	
	public void updateInsumoGeneral(Integer id, String descripcion, Double costo, Unidad unidad, Double peso) {
		InsumoGeneral i = new InsumoGeneral(id, descripcion, costo, unidad, peso);
		is.updateInsumoGeneral(i);
	}
	
	
	public void altaInsumoLiquido(String descripcion, Double costo, Unidad unidad, Double densidad) {
		InsumoLiquido i = new InsumoLiquido(1, descripcion, costo, unidad, densidad);
		is.altaInsumoLiquido(i);
	}
	
	public void updateInsumoLiquido(Integer id, String descripcion, Double costo, Unidad unidad, Double densidad) {
		InsumoLiquido i = new InsumoLiquido(id, descripcion, costo, unidad, densidad);
		is.updateInsumoLiquido(i);
	}

	public void bajaInsumo(Integer id) {
		is.bajaInsumo(id);
	}
	
	public ArrayList<Insumo> recuperarInsumoTodos() {
		ArrayList<Insumo> res = is.recuperarInsumoTodos();
		return res;
		
	}
	
	
}
