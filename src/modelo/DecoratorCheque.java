package modelo;

import java.util.GregorianCalendar;
import java.util.HashMap;

import interfaces.IAbonado;

/**
 * @author
 *Clase del patron Decorator que representa un abonado que paga con cheque
 */
public class DecoratorCheque extends DecoratorPagos {

	/**
	 * Constructor de la clase DecoratorPagos
	 * @param encapsulado: Encapsulado de la clase
	 * <b>Pre:</b> El encapsulado debe ser distinto de null
	 * <b>Post:</b> Crea un objeto de tipo DecoratorCheque
	 */
	public DecoratorCheque(IAbonado encapsulado) {		
		super(encapsulado);
		assert encapsulado !=null : "encapsulado no valido";
	}

	/**
	 *Devuelve el costo de todos los servicios del encapsulado con un recargo del 10%
	 */
	@Override
	public double getCostoServicios() {
		return this.encapsulado.getCostoServicios()*1.1;//Aplica promo sobre el TOTAL que debe pagar un abonado por todos sus servicios
	}


	/**
	 *Devuelve un clon de la clase DecoratorCheque
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		DecoratorCheque clonado= (DecoratorCheque) super.clone();
		clonado.encapsulado=(IAbonado) encapsulado.clone();
		return clonado;
	}

	@Override
	public String getFormaPago() {
		return "Cheque";
	}

	@Override
	public HashMap<String, Servicio> getServicio() {
		return encapsulado.getServicio();
	}

	@Override
	public void PagarFactura() {
		encapsulado.PagarFactura();
		
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
		return this.getNombre()+" - "+this.getDNI();
	}

	@Override
	public String getEstado() {
		return this.encapsulado.getEstado();
	}
	
}
