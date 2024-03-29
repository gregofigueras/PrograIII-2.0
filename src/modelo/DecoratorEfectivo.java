package modelo;

import java.util.GregorianCalendar;
import java.util.HashMap;

import interfaces.IAbonado;

/**
 * @author Clase del patron Decorator que representa un abonado que paga en
 *         efectivo
 */
public class DecoratorEfectivo extends DecoratorPagos {

	/**
	 * Constructor de la clase DecoratorEfectivo
	 * 
	 * @param encapsulado: Encapsulado de la clase
	 */
	public DecoratorEfectivo(IAbonado encapsulado) {
		super(encapsulado);
		assert encapsulado != null : "encapsulado no valido";
	}

	/**
	 * Devuelve el costo de los servicios con un descuento del 20%
	 */
	@Override
	public double getCostoServicios() {
		return this.encapsulado.getCostoServicios() * 0.8;// Aplica promo sobre el TOTAL que debe pagar un abonado por
															// todos sus servicios
	}

	public DecoratorEfectivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Devuelve un clon de la clase DecoratorEfectivo
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		DecoratorEfectivo clonado = (DecoratorEfectivo) super.clone();
		clonado.encapsulado = (IAbonado) encapsulado.clone();
		return clonado;
	}

	@Override
	public String getFormaPago() {
		return "Efectivo";
	}

	@Override
	public HashMap<String, Servicio> getServicios() {
		return encapsulado.getServicios();
	}

	@Override
	public void pagarFactura() {
		encapsulado.pagarFactura();

	}

	@Override
	public void AgregarFactura(Factura factura) {
		encapsulado.AgregarFactura(factura);

	}

	@Override
	public GregorianCalendar getFecha() {
		return encapsulado.getFecha();
	}

	public String toString() {
		return this.getNombre() + " - " + this.getDNI();
	}

	@Override
	public String getEstado() {
		return this.encapsulado.getEstado();
	}

}
