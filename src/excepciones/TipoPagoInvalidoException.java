package excepciones;

public class TipoPagoInvalidoException extends Exception {
	
	public TipoPagoInvalidoException() {
	}


	@Override
	public String getMessage() {
		return "El tipo de pago no es valido";
	}
}
