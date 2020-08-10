package dominio;

public class ItemPedido {
	
	Integer id;
	Double cantidad;
	Integer numeroDeOrden;
	Integer idInsumo;
	
	
	
	public ItemPedido(Double cantidad, Integer numeroDeOrden, Integer idInsumo) {
		super();
		this.cantidad = cantidad;
		this.numeroDeOrden = numeroDeOrden;
		this.idInsumo = idInsumo;
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
	public Integer getNumeroDeOrden() {
		return numeroDeOrden;
	}
	public void setNumeroDeOrden(Integer numeroDeOrden) {
		this.numeroDeOrden = numeroDeOrden;
	}
	public Integer getIdInsumo() {
		return idInsumo;
	}
	public void setIdInsumo(Integer idInsumo) {
		this.idInsumo = idInsumo;
	}
	
	
	

}
