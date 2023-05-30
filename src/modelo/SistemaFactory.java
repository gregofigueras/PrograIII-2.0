package modelo;

import java.io.Serializable;
import java.util.ArrayList;

import excepciones.TipoAbonadoInvalidoException;
import excepciones.TipoPagoInvalidoException;
import interfaces.IAbonado;

/**
 * @author Clase del patron factory para crear nuevos objetos de instancia
 *         IAbonado
 */
public class SistemaFactory implements Serializable {
	static ArrayList<IAbonado> abonados = new ArrayList<IAbonado>();
	static ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();

	/**
	 * Constructor de la clase sistemaFactory
	 */
	public SistemaFactory() {
		super();
	}

	/**
	 * Metodo que devuelve una nueva instancia segun los parametros dados
	 * 
	 * @param tipoAbonado: Tipo de abonado de la nueva instancia
	 * @param formaPago:   Forma de pago del abonado
	 * @param nombre:      Nombre del abonado
	 * @param DNI:         DNI del abonado
	 * @return: Devuelve una nueva instancia del tipo IAbonado <b>Pre: <b> el tipo
	 *          de abonado debe ser distinto de null y no vacio <br>
	 *          <b> Pre: <b> la forma de pago debe ser distinta de null y no vacia
	 *          <b> <b>Pre:</b> nombre debe ser distinto de null y no vacio<br>
	 *          <b>Pre:</b> DNI debe ser distinto de null y no vacio <b> Post: </b>
	 *          se crea una instancia de abonado
	 * @throws TipoAbonadoInvalidoException
	 */
	public static IAbonado getAbonado(String tipoAbonado, String formaPago, String nombre, String DNI)
			throws TipoAbonadoInvalidoException, TipoPagoInvalidoException {
		assert tipoAbonado != null : "tipo de abonado no valido";
		assert tipoAbonado != "" : "tipo de abonado no valido";
		assert formaPago != null : "forma de pago no valida";
		assert formaPago != "" : "forma de pago no valida";
		assert nombre != null : "nombre no valido";
		assert nombre != "" : "nombre no valido";
		assert DNI != null : "DNI no valido";
		assert DNI != "" : "DNI no valido";
		IAbonado encapsulado = null;
		DecoratorPagos respuesta = null;

		if (tipoAbonado.equalsIgnoreCase("Fisico"))
			encapsulado = new AbonadoFisico(nombre, DNI);
		else if (tipoAbonado.equalsIgnoreCase("Juridico"))
			encapsulado = new AbonadoJuridico(nombre, DNI);
		else
			throw new TipoAbonadoInvalidoException();

		if (encapsulado != null) {
			if (formaPago.equalsIgnoreCase("Cheque"))
				respuesta = new DecoratorCheque(encapsulado);
			else if (formaPago.equalsIgnoreCase("Credito"))
				respuesta = new DecoratorCredito(encapsulado);
			else if (formaPago.equalsIgnoreCase("Efectivo"))
				respuesta = new DecoratorEfectivo(encapsulado);
			else
				new TipoPagoInvalidoException();
		}
		assert encapsulado.getNombre() == nombre : "fallo en el postcondicion";
		assert encapsulado.getDNI() == DNI : "fallo en el postcondicion";
		assert encapsulado.getTipo().equalsIgnoreCase(tipoAbonado) : "fallo en el postcondicion";
		assert respuesta.getFormaPago().equalsIgnoreCase(formaPago) : "fallo en el postcondicion";

		abonados.add(encapsulado);

		return respuesta;
	}

	public static Tecnico getTecnico() {

	}
}
