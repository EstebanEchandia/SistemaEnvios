package servicios;

import dao.StockDao;
import dao.StockDaoPostgreSQL;
import dominio.Stock;

public class StockServicio {

	
	private StockDao stockDao = new StockDaoPostgreSQL();
	
	public void altaStock(Stock s) {
		
		this.stockDao.altaStock(s);
	}
	
	public Integer getStockDeUnInsumo(Integer id) {
		return stockDao.getStockDeUnInsumo(id);
		
	}
}
