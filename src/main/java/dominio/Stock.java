/**
 * 
 */
package dominio;

/**
 * @author esteb
 *
 */
public class Stock {
	
	private Integer id;
	private Double cantidad;
	private Double ptoMinimoDePedido;
	private Integer insumoAsociado;
	private Integer idPlanta;
	
	
	public Stock(Double cantidad, Double ptoMinimoDePedido, Integer insumoAsociado, Integer idPlanta) {
		super();
		this.cantidad = cantidad;
		this.ptoMinimoDePedido = ptoMinimoDePedido;
		this.insumoAsociado = insumoAsociado;
		this.idPlanta = idPlanta;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPtoMinimoDePedido() {
		return ptoMinimoDePedido;
	}
	public void setPtoMinimoDePedido(Double ptoMinimoDePedido) {
		this.ptoMinimoDePedido = ptoMinimoDePedido;
	}
	public Integer getInsumoAsociado() {
		return insumoAsociado;
	}
	public void setInsumoAsociado(Integer insumoAsociado) {
		this.insumoAsociado = insumoAsociado;
	}
	public Integer getIdPlanta() {
		return idPlanta;
	}
	public void setIdPlanta(Integer idPlanta) {
		this.idPlanta = idPlanta;
	}
	
	

	
}
