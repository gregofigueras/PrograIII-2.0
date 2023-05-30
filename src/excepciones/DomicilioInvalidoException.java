package excepciones;

public class DomicilioInvalidoException extends Exception{
	private String domicilio;
	
	
	public DomicilioInvalidoException(String domicilio) {
		this.domicilio=domicilio;
	}


	@Override
	public String getMessage() {
		return "El domicilio "+this.domicilio+" es invalido";
	}

	
}
