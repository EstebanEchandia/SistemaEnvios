/**
 * 
 */
package dao;

import dominio.Stock;

/**
 * @author esteb
 *
 */
public interface StockDao {
	
	public Stock modificarStock(Stock s);
	public void altaStock(Stock s);
	public Integer getStockDeUnInsumo(Integer idInsumo);
}
