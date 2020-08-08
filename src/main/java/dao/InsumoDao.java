/**
 * 
 */
package dao;

import java.util.ArrayList;

import dominio.Insumo;
import dominio.InsumoGeneral;
import dominio.InsumoLiquido;

/**
 * @author esteb
 *
 */
public interface InsumoDao {
	
	
	
	public InsumoGeneral altaInsumoGeneral(InsumoGeneral i);
	public InsumoGeneral updateInsumoGeneral(InsumoGeneral i);

	public InsumoLiquido altaInsumoLiquido(InsumoLiquido i);
	public InsumoLiquido updateInsumoLiquido(InsumoLiquido i);

	public void bajaInsumo(Integer id);
	public ArrayList<Insumo> recuperarInsumoTodos();

	
	
	
	


}
