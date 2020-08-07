package exepciones;

public class CampoVacioException extends Exception {
	
	

	public CampoVacioException(String campo) {
		super("El campo " + campo + "esta vacio y es obligatorio");
	}
}
