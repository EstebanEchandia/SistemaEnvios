/**
 * 
 */
package dominio;

import enums.Unidad;

/**
 * @author esteb
 *
 */
public class InsumoLiquido extends Insumo {

	

	private Double densidad;
	
	public InsumoLiquido(Integer id, String descripcion, Double costo, Unidad unidad, Double densidad) {
		
		this.id = id;
		this.descripcion = descripcion;
		this.costo = costo;
		this.unidad = unidad;
		this.densidad = densidad;
		
		
	}
	
	public InsumoLiquido(Integer id) {
		this.id=id;
	}

	public Double getDensidad() {
		return densidad;
	}

	public void setDensidad(Double densidad) {
		this.densidad = densidad;
	}
	
	public String[] listaAtributos(){
		String[] res = new String[] {id.toString(), descripcion, costo.toString(),unidad.toString(),"No corresponde",densidad.toString()};
		return res;
		
	}
	@Override
	public Double pesoPorUnidad() {
		return 0.0;
	}

	
}
