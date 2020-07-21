/**
 * 
 */
package dao;

import dominio.Stock;

/**
 * @author esteb
 *
 */

public class StockDaoPostgreSQL implements StockDao{

	@Override
	public Stock modificarStock() {
		
		return new Stock();
	}
	
	
}
