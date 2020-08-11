
package dominio;


/**
 * @author esteb
 *
 */
public class Planta {
	
	private Integer id;
	private String nombre;
	
	public Planta(Integer id) {
		super();
		this.id=id;
	}
	
	
	public Planta(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String[] listaAtributos(){
		String[] res = new String[] {id.toString(), nombre};
		return res;
	}
	
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

	public Integer getId() {
			return id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
