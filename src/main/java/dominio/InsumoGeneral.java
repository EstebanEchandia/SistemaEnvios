/**
 * 
 */
package dominio;

import enums.Unidad;

/**
 * @author esteb
 *
 */
public class InsumoGeneral extends Insumo {
	
	private Double peso;
	
	

	public InsumoGeneral(Integer id, String descripcion, Double costo, Unidad unidad, Double peso) {
		
		this.id = id;
		this.descripcion = descripcion;
		this.costo = costo;
		this.unidad = unidad;
		this.peso = peso;
		
		
	}

	public InsumoGeneral(Integer id) {
		this.id=id;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	
	public String[] listaAtributos(){
		String[] res = new String[] {id.toString(), descripcion, costo.toString(),unidad.toString(),peso.toString(),"No corresponde"};
		return res;
		
	}

}
