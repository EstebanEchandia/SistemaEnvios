/**
 * 
 */
package dao;

import dominio.Insumo;

/**
 * @author esteb
 *
 */
public class InsumoDaoPostgre implements InsumoDao{

	@Override
	public Insumo altaInsumo() {
		return new Insumo();
	}

	@Override
	public Insumo modificarInsumo() {
		return new Insumo();
	}

	@Override
	public Insumo buscarInsumo() {
		return new Insumo();
	}

}
