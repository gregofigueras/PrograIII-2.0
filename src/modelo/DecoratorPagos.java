package modelo;

import excepciones.DomicilioInvalidoException;
import interfaces.IAbonado;

/**
 * @author
 * Clase abstracta del patron Decorator que representa de que manera va a pagar el encapsulado
 *
 */
public abstract class DecoratorPagos implements IAbonado, Cloneable{
	protected IAbonado encapsulado;

	/**
	 * Constructor de la clase DecoratorPagos
	 * @param encapsulado: Encapsulado de tipo IAbonado<br>
	 * <b>Pre:</b> El encapsulado debe ser distinto de null
	 * <b>Post:</b> Crea un objeto de tipo DecoratorPagos
	 */
	public DecoratorPagos(IAbonado encapsulado) {
		this.encapsulado = encapsulado;
		assert encapsulado !=null : "encapsulado no valido";
	}
	
	public String getNombre() {
		return this.encapsulado.getNombre();
	}
	
	public String getDNI(){
		return this.encapsulado.getDNI();
	}
	
	public void imprimeServicios() {
		encapsulado.imprimeServicios();
	}

	/**
	 *Metodo que clona el decorator
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		DecoratorPagos clonado;
		
		clonado = (DecoratorPagos)super.clone();
		try {
			clonado.encapsulado = (IAbonado)this.encapsulado.clone();
			return clonado;
		}
		catch (CloneNotSupportedException e) {
			throw e;
		}
	}

	/**
	 *Metodo que quita un servicio del encapsulado segun su domicilio<br>
	 *<b>Pre:</b>El domicilio debe estar en el HashMap de servicios del encapsulado
	 *<b>Post:</b> Quita el servicio del HashMap con el domcilio
	 * @throws DomicilioInvalidoException 
	 */
	@Override
	public void quitaServicio(String domicilio) throws DomicilioInvalidoException {
		assert encapsulado.getServicio().containsKey(domicilio) : "Domicilio no existente";
		this.encapsulado.quitaServicio(domicilio);	
	}

	/**
	 *Calcula el costo de los servicios del encapsulado
	 */
	@Override
	public double getCostoServicios() {
		return this.encapsulado.getCostoServicios();
	}

	/**
	 *Agrega un servicio al HashMap servicios del encapsulado
	 *<b> Pre: </b> domicilio no nulo y no vacio
	 *<b> Pre: </b> servicio no null
	 *<b> Pre: </b> domicilio no null y no vacio
	 *<b> Post: </b> se agrega el servicio al domicilio en el HashMap
	 */
	@Override
	public void agregaServicio(String domicilio, Servicio servicio) {
		assert domicilio != null : "domicilio no valido";
		assert domicilio != "" : "domicilio no valido";
		assert servicio != null : "servicio no valido";
		this.encapsulado.agregaServicio(domicilio, servicio);
	}

	/**
	 *Devuelve un String con el tipo de abonado del encapsulado
	 */
	@Override
	public String getTipo() {
		return this.encapsulado.getTipo();
	}
	
	/**
	 * Devuelve la forma de pago del Decorator
	 * @return: String que describe de que manera va a pagar el encapsulado
	 */
	public abstract String getFormaPago();
	
}
