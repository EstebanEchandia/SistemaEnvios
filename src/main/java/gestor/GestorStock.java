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
		
		
	}
	Stock modificarStock() {
		
		return new Stock();
	}

}
