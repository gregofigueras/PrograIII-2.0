package modelo;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import excepciones.DomicilioInvalidoException;
import factory.TecnicosFactory;
import interfaces.IState;
import state.ConContratacionesState;
import state.MorosoState;
import state.SinContratacionesState;

/**
 * @author Clase que representa un abonado de tipo fisico dentro del sistema
 */
public class AbonadoFisico extends Abonado {

	private IState estado;

	/**
	 * Constructor de la clase
	 * 
	 * @param sistemaTecnicos
	 * 
	 * @param nombre:         nombre del abonado
	 * @param DNI:            DNI del abonado <b> pre: </b> nombre tiene que ser no
	 *                        vacio y no null <br>
	 *                        <b> pre: </b> DNI tiene que ser no vacio y no null
	 *                        <br>
	 *                        <b> post: </b> Crea un objeto de tipo abonado
	 */

	public AbonadoFisico(String nombre, String DNI, GregorianCalendar fecha, TecnicosFactory sistemaTecnicos) {
		super(nombre, DNI, fecha, sistemaTecnicos);
		this.estado = new SinContratacionesState(this);

		assert nombre != null : "nombre no valido";
		assert nombre != "" : "nombre no valido";
		assert DNI != null : "DNI no valido";
		assert DNI != "" : "DNI no valido";
	}

	public AbonadoFisico() {
		super();
	}

	/**
	 * metodo que calcula el costo neto de todos los vervicios <b> pre: </b> HashMap
	 * debe ser no nulo <br>
	 * <b> post: </b> retorna el costo neto de los servicios de un domicilio
	 */
	@Override
	public double getCostoServicios() {
		Iterator<Entry<String, Servicio>> it = this.servicios.entrySet().iterator();// Iterator del Set del HashMap
		double resultado = 0;

		while (it.hasNext())
			resultado += it.next().getValue().getCostoNeto();
		return resultado;
	}

	public void quitaServicio(String domicilio) throws DomicilioInvalidoException {
		assert domicilio != null : "domicilio no valido";
		assert domicilio != "" : "domicilio no valido";

		if (this.servicios.containsKey(domicilio)) {
			servicios.remove(domicilio);
			if (servicios.isEmpty())
				this.estado = new SinContratacionesState(this);
		} else
			throw new DomicilioInvalidoException(domicilio);
		assert servicios.containsKey(domicilio) : "fallo en el postcodigo";
	}

	/**
	 * metodo que clona el abonado <br>
	 * el metodo nunca va a lanzar una excepcion <b> post: </b> genera un clon de un
	 * abonado de tipo fisico
	 */

	@Override
	public Object clone() throws CloneNotSupportedException {
		AbonadoFisico clonado = (AbonadoFisico) super.clone();
		return clonado;
	}

	public String getTipo() {
		return "Fisico";
	}

	@Override
	public HashMap<String, Servicio> getServicio() {
		return this.servicios;
	}

	public void agregaServicio(String domicilio, Servicio servicio) {
		assert domicilio != null : "domicilio no valido";
		assert domicilio != "" : "domicilio no valido";
		assert servicio != null : "servicio no valido";
		assert servicio.numId != 0 : "servicio no valido";

		servicios.put(domicilio, servicio);

		this.estado = new ConContratacionesState(this);

		assert servicios.get(domicilio) == servicio : "fallo en la postcondicion";
		assert servicios.isEmpty() == true : "fallo invariante";

	}

	public void setEstado(IState estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado.getEstado();
	}

	public void pagarFactura() {
		this.estado.pagarFactura();
	}

	public void EfectuaPago() {
		int i = this.listaFacturas.size() - 1;

		double d = 1.0;
		this.totalPagado = 0;

		while (i >= 0 && !this.listaFacturas.get(i).isPago()) {

			if (i < this.listaFacturas.size() - 2) {
				d = 1.3;
			}
			this.totalPagado += this.listaFacturas.get(i).getTotal() * d;
			this.listaFacturas.get(i).setPago(true);
			i--;
		}
	}

	public void ContratarNuevoServicio(String domicilio, Servicio s) {
		this.estado.contratarNuevoServicio(domicilio, s);
	}

	public void BajaDeUnServicio(String domicilio) throws DomicilioInvalidoException {
		this.estado.bajaDeUnServicio(domicilio);
	}

	public String toString() {
		return this.nombre + " - " + this.DNI;
	}

	@Override
	public void actualizaEstado() {
		Iterator<Factura> it = this.listaFacturas.iterator();
		int i = 0;

		if (this.listaFacturas.isEmpty()) {
			this.estado = new SinContratacionesState(this);
		} else {
			while (it.hasNext()) {
				if (!it.next().isPago()) {
					i++;
				}
			}
		}
		if (i > 2) {
			this.estado = new MorosoState(this);
		}
	}

}
