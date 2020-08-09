package servicios;

import dao.StockDao;
import dao.StockDaoPostgreSQL;

public class StockServicio {

	
	private StockDao stockDao = new StockDaoPostgreSQL();
	
	public void altaStock(Stock s) {
		
		this.stockDao.altaStock(s);
		
		
		
	}
}
