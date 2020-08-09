/**
 * 
 */
package gestor;

import dominio.Stock;
import servicios.StockServicio;

/**
 * @author esteb
 *
 */
public class GestorStock {
	private StockServicio stockServicio = new StockServicio();
	

	public void altaStock(Double cantidad, Double ptoMinimoDePedido, Integer insumoAsociado, Integer idPlanta) {
		
		Stock s = new Stock(cantidad, ptoMinimoDePedido, insumoAsociado, idPlanta);
		
		stockServicio.altaStock(s);
		
		
	}
	
	public Integer getStockDeUnInsumo(Integer id) {
		return stockServicio.getStockDeUnInsumo(id);
		
	}
	
	Stock modificarStock() {
		
		return new Stock();
	}

}
