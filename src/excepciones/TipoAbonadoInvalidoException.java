package excepciones;

public class TipoAbonadoInvalidoException extends Exception {
		
		
	public TipoAbonadoInvalidoException() {

	}


	@Override
	public String getMessage() {
		return "El tipo de abonado no es valido";
	}
	
}
