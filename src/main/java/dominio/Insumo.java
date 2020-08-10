/**
 * 
 */
package dominio;

import enums.Unidad;

/**
 * @author esteb
 *
 */
public abstract class Insumo {
	
	protected Integer id;
	protected  String descripcion;
	protected  Double costo;
	protected  Unidad unidad;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public Unidad getUnidad() {
		return unidad;
	}
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	public Double pesoPorUnidad() {
		return 0.0;
	}
	
	public String[] listaAtributos(){
		return null;
	}
	
}
