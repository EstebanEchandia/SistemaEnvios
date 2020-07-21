/**
 * 
 */
package dominio;

import java.util.ArrayList;


/**
 * @author esteb
 *
 */
public class Planta {
	
	private String id;
	private String nombre;
	private ArrayList<Insumo> listaInsumos = new ArrayList<Insumo>();
	private ArrayList<Pedido> listaPedidosEntrantes = new ArrayList<Pedido>();
	private ArrayList<Pedido> listaPedidosSalientes = new ArrayList<Pedido>();
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
