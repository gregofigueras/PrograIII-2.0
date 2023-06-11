package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import excepciones.DomicilioInvalidoException;
import factory.TecnicosFactory;
import interfaces.IAbonado;

/**
 * @author clase abstracta que representa un abonado dentro de un sistema
 */
public abstract class Abonado extends Thread implements IAbonado, Serializable {
	protected String nombre;
	protected String DNI;
	private TecnicosFactory sistemaTecnicos;
	protected HashMap<String, Servicio> servicios; // Hashmap asi no hay domicilios repetidos
	protected ArrayList<Factura> listaFacturas;
	protected GregorianCalendar fecha;
	protected GregorianCalendar fechaInicial;

	/**
	 * constructor de la clase
	 * 
	 * @param sistemaTecnicos
	 * 
	 * @param nombre:         es el nombre del abonado
	 * @param DNI:            DNI del abonado <b> pre: </b> nombre tiene que ser no
	 *                        vacio y no null <br>
	 *                        <b> pre: </b> DNI tiene que ser no vacio y no null
	 *                        <br>
	 *                        <b> post: </b> Crea un objeto de tipo abonado
	 */
	public Abonado(String nombre, String DNI, GregorianCalendar fecha, TecnicosFactory sistemaTecnicos) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.sistemaTecnicos = sistemaTecnicos;
		this.servicios = new HashMap<String, Servicio>();
		this.fecha = fecha;
		this.fechaInicial = fecha;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public HashMap<String, Servicio> getServicio() {
		return servicios;
	}

	/**
	 * metodo void que agrega un determinado domicilio y tipo de servicio al hashmap
	 * de servicios
	 * 
	 * @param domicilio: domicilio del servicio
	 * @param servicio:  parametro que representa a un tipo de servicio <b> pre:
	 *                   </b> domicilio tiene que ser no nulo y no vacio <br>
	 *                   <b> pre: </b> servicio tiene que ser no nulo y no vacio
	 *                   <br>
	 *                   <b> post: </b> agrega servicio al hashmap de domicilios
	 */

	public void agregaServicio(String domicilio, Servicio servicio) {
		assert domicilio != null : "domicilio no valido";
		assert domicilio != "" : "domicilio no valido";
		assert servicio != null : "servicio no valido";
		assert servicio.numId != 0 : "servicio no valido";
		servicios.put(domicilio, servicio);

		assert servicios.get(domicilio) == servicio : "fallo en la postcondicion";
		assert servicios.isEmpty() == true : "fallo invariante";

	}

	/**
	 * metodo void que quita un determinado servicio de un domicilio en el hashmap
	 * de servicios
	 * 
	 * @param domicilio: domicilio del servicio <b> pre: </b> domicilio tiene que
	 *                   ser no nulo y no vacio <br>
	 *                   <b> post: </b> elimina un servicio del hashmap de
	 *                   domicilios
	 */

	public abstract void quitaServicio(String domicilio) throws DomicilioInvalidoException;

	/**
	 * metodo void que imprime por pantalla cada uno de los servicios de un abonado
	 * <b> post: </b> imprime por pantalla los servicios de un abonado
	 */

	public void imprimeServicios() {
		Iterator<Entry<String, Servicio>> it = this.servicios.entrySet().iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	public Servicio getServicio(String domicilio) {
		return this.servicios.get(domicilio);
	}

	/**
	 * metodo abstracto que calcula el costo de todos los servicios de un cliente
	 */
	public abstract double getCostoServicios();

	/**
	 * metodo que clona el abonado <br>
	 * puede lanzar una excepcion en caso que el abonado sea juridico <b> post: </b>
	 * genera un clon de abonado
	 */
	public Object clone() throws CloneNotSupportedException {
		Abonado clonado;
		Iterator<Entry<String, Servicio>> it = this.servicios.entrySet().iterator();

		try {
			clonado = (Abonado) super.clone();
			clonado.servicios = (HashMap<String, Servicio>) servicios.clone();
			while (it.hasNext()) {
				Map.Entry<String, Servicio> entry = it.next();
				clonado.servicios.put(entry.getKey(), (Servicio) entry.getValue().clone());
			}
			return clonado;
		} catch (CloneNotSupportedException e) {
			e.getMessage();
			throw e;
		}
	}

	public abstract void PagarFactura();

	public void AgregarFactura(Factura factura) {
		listaFacturas.add(factura);
	}

	@Override
	public void run() {
		System.out.println("corriendo");
		int i;
		i = this.sistemaTecnicos.ConsultaTecnica(this);
		Random r = new Random();
		int q = r.nextInt(60);
		try {
			Thread.sleep(q);
			this.sistemaTecnicos.TerminaConsulta(this, i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void simularMes(GregorianCalendar fecha) {
		this.fecha = fecha;
		if (this.fecha.DAY_OF_YEAR - this.fechaInicial.DAY_OF_YEAR > 29) {
			this.fechaInicial = this.fecha;
			Factura factura = new Factura(this);
			this.AgregarFactura(factura);
		}

	}

	@Override
	public void sumarDia(GregorianCalendar fecha) {
		this.fecha = fecha;
		if (this.fecha.DAY_OF_YEAR - this.fechaInicial.DAY_OF_YEAR > 29) {
			this.fechaInicial = this.fecha;
			Factura factura = new Factura(this);
			this.AgregarFactura(factura);
		}
	}
	
	public ArrayList<Factura> getFactura(){
		return this.listaFacturas;
	}

}
