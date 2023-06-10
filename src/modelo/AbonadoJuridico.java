package modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import excepciones.DomicilioInvalidoException;

/**
 * @author Clase que representa un abonado de tipo juridico dentro del sistema
 */
public class AbonadoJuridico extends Abonado {
	/**
	 * Constructor de la clase
	 * 
	 * @param tecnico
	 * @param nombre: nombre del abonado
	 * @param DNI:    DNI del abonado <b> pre: </b> nombre tiene que ser no vacio y
	 *                no null <br>
	 *                <b> pre: </b> DNI tiene que ser no vacio y no null <br>
	 *                <b> post: </b> Crea un objeto de tipo abonado
	 */
	public AbonadoJuridico(String nombre, String DNI) {
		super(nombre, DNI);
		assert nombre != null : "nombre no valido";
		assert nombre != "" : "nombre no valido";
		assert DNI != null : "DNI no valido";
		assert DNI != "" : "DNI no valido";
	}

	/**
	 * metodo que calcula el costo neto de todos los vervicios <b> pre: </b> HashMap
	 * debe ser no nulo <br>
	 * <b> post: </b> retorna el costo neto de los servicios de un domicilio
	 */
	@Override
	public double getCostoServicios() {
		Iterator<Entry<String, Servicio>> it = this.servicios.entrySet().iterator();
		double resultado = 0;

		if (this.servicios.size() > 3)
			for (int i = 0; i < 3; i++) {
				resultado += it.next().getValue().getCostoNeto();
			}
		while (it.hasNext())
			resultado += it.next().getValue().getCostoNeto() * 0.5; // Descuento del 50% a partir del tercero
		return resultado;
	}

	/**
	 * metodo que clona el abonado <br>
	 * el metodo siempre va a lanzar excepcion <b> post: </b> lanza excepcion
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new CloneNotSupportedException("Imposible clonar una persona juridica");
	}

	@Override
	public String getTipo() {
		return "Juridico";
	}

	@Override
	public HashMap<String, Servicio> getServicio() {
		return this.servicios;
	}

	public String toString() {
		return this.nombre + " - " + this.DNI;
	}

	@Override
	public void PagarFactura() {
		double total = 0;

		for (Factura factura : listaFacturas) {
			if (!factura.isPago()) {
				total += factura.getTotal();
				factura.setTotal(factura.getTotal());
				factura.setPago(true);
			}
		}
		System.out.println("El abonado pago un total de: " + total + " pesos");
	}

	@Override
	public void quitaServicio(Servicio servicio) throws DomicilioInvalidoException {
		// TODO Auto-generated method stub

	}

}