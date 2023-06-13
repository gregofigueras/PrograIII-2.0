package modelo;

import java.util.ArrayList;
import java.util.Calendar;
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
 * @author Clase abstracta que representa un abonado dentro de un sistema
 */

public abstract class Abonado extends Thread implements IAbonado {
	protected String nombre;
	protected String DNI;
	private TecnicosFactory tecnicosFactory;
	protected HashMap<String, Servicio> servicios; // Hashmap asi no hay domicilios repetidos
	protected ArrayList<Factura> listaFacturas;
	protected GregorianCalendar fecha;
	protected int mesPago;
	protected Tecnico tecnico = null;
	protected double totalPagado;

	/**
	 * Constructor de la clase
	 * @param nombre Nombre del abonado
	 * @param DNI DNI del abonado
	 * @param fecha Fecha 
	 * @param tecnicosFactory Referencia al sistema de tecnicos (Abonado es el recurso compartido)
	 */
	public Abonado(String nombre, String DNI, GregorianCalendar fecha, TecnicosFactory tecnicosFactory) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.tecnicosFactory = tecnicosFactory;
		this.servicios = new HashMap<String, Servicio>();
		this.fecha = fecha;
		this.mesPago = fecha.get(Calendar.MONTH);
		this.listaFacturas = new ArrayList<Factura>();
		this.totalPagado = 0;
	}

	/**
	 *Método que devuelve el último total pagado
	 */
	public double getTotalPagado() {
		return totalPagado;
	}

	/**
	 *Método que devuelve la fecha de facturación
	 */
	public GregorianCalendar getFecha() {
		return fecha;
	}

	/**
	 *Método que devuelve el nombre del abonado
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 *Método que devuelve el DNI del abonado
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 *Método que devuelve los servicios que tiene el abonado
	 */
	public HashMap<String, Servicio> getServicios() {
		return servicios;
	}

	/**
	 * Método que agrega un servicio al abonado dado un domicilio
	 * 
	 * @param domicilio Domicilio del servicio
	 * @param servicio  Servicio a agregar
	 * <b>Pre:</b> domicilio tiene que ser no nulo y diferente de null <br>
	 * <b>Pre:</b> servicio tiene que ser no nulo y diferente de null<br>
	 * <b>Post:</b> Agrega servicio al hashmap de domicilios
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
	 * Método que quita un servicio del abonado dado el domcilio del servicio
	 * @param domicilio Domicilio del servicio<br>
	 * <b>Pre:</b> domicilio tiene que ser no nulo y diferente de null<br>
	 * <b>Post:</b> Elimina un servicio del HashMap de servicios
	 */

	public abstract void quitaServicio(String domicilio) throws DomicilioInvalidoException;

	/**
	 * Método que imprime por pantalla cada uno de los servicios de un abonado
	 * <b>Post:</b> Imprime por pantalla los servicios de un abonado
	 */

	public void imprimeServicios() {
		Iterator<Entry<String, Servicio>> it = this.servicios.entrySet().iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	/**
	 *Método que devuelve un servicio dado su domicilio
	 *@param domicilio domicilio donde se encuentra asociado el servicio
	 *<b>Pre:</b> domicilio debe ser distinto de null
	 */
	public Servicio getServicio(String domicilio) {
		return this.servicios.get(domicilio);
	}

	/**
	 * Método abstracto que calcula el costo de todos los servicios de un cliente
	 */
	public abstract double getCostoServicios();

	/**
	 * Método que clona a un abonado <br>
	 * Puede lanzar una excepcion en caso que el abonado sea juridico<br>
	 * <b>Post:</b> Genera un clon de abonado
	 */
	public Object clone() throws CloneNotSupportedException {
		Abonado clonado;
		Iterator<Entry<String, Servicio>> it = this.servicios.entrySet().iterator();

		try {
			clonado = (Abonado) super.clone();
			clonado.servicios = (HashMap<String,Servicio>) servicios.clone();
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

	/**
	 *Método abstracto que representa que el abonado pagó su factura
	 */
	public abstract void pagarFactura();

	/**
	 * Método que agrega una factura a la lista de facturas
	 * @param factura Factura a agregar
	 * <b>Pre:</b> factura debe ser distinto de null<br>
	 * <b>Post:</b> Agrega la factura al ArrayList listaFacturas
	 */
	public void AgregarFactura(Factura factura) {
		listaFacturas.add(factura);
	}

	/**
	 *Método perteneciente a la clase Thread<br>
	 *En este caso simula que un abonado pide la visita de un técnico al azar
	 */
	@Override
	public void run() {
		int i;
		if (this.tecnico == null) {
			i = this.tecnicosFactory.consultaTecnica();
			this.tecnico = this.tecnicosFactory.getTecnico(i);
			Random r = new Random();
			int q = r.nextInt(2000);
			try {
				Thread.sleep(q);
				this.tecnicosFactory.terminaConsulta(i);
				this.tecnico = null;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *Método que simula un mes a la fecha y agrega una nueva factura a la lista de facturas
	 *@param fecha Nueva fecha
	 *<b>Pre:</b> fecha debe ser distinto de null
	 *<b>Post:</b> Simula un día al atributo fecha
	 */
	@Override
	public void simularMes(GregorianCalendar fecha) {
		this.fecha = fecha;
		if (this.servicios != null) {
			if (this.fecha.get(Calendar.MONTH) - this.mesPago != 0) {
				this.mesPago = this.fecha.get(Calendar.MONTH);
				Factura factura = new Factura(this);
				this.AgregarFactura(factura);
			}
		}

	}

	/**
	 *Método que simula un día a la fecha y agrega una factura a la lista de facturas de ser necesario
	 *@param fecha Nueva fecha
	 *<b>Pre:</b> fecha debe ser distinto de null
	 *<b>Post:</b> Simula un día al atributo fecha
	 */
	@Override
	public void sumarDia(GregorianCalendar fecha) {
		this.fecha = fecha;
		if (this.servicios != null) {
			if (this.fecha.get(Calendar.MONTH) - this.mesPago != 0) {
				this.mesPago = this.fecha.get(Calendar.MONTH);
				Factura factura = new Factura(this);
				this.AgregarFactura(factura);
			}
		}
	}

	/**
	 * Constructor vacio de la clase<br>
	 * Requisito de persistencia mediante XML
	 */
	public Abonado() {
		super();
	}

	/**
	 *Método que devuelve la lista de facturas
	 *@return ArrayList de Factura
	 */
	public ArrayList<Factura> getFactura() {
		return this.listaFacturas;
	}

	/**
	 * Método que devuelve el gestor de técnicos
	 * @return referencia de tipo TecnicosFactory
	 */
	public TecnicosFactory getTecnicosFactory() {
		return tecnicosFactory;
	}

	/**
	 * Setter del atributo tecnicosFactory
	 * @param tecnicosFactory Nueva referencia de tecnicosFactory a cambiar
	 * <b>Pre:</b> tecnicosFactory debe ser distinto de null<br>
	 * <b>Post:</b> El atributo tecnicosFactory cambia
	 */
	public void setTecnicosFactory(TecnicosFactory tecnicosFactory) {
		this.tecnicosFactory = tecnicosFactory;
	}

	/**
	 * Setter del atributo servicios
	 * @param tecnicosFactory Nueva referencia de servicios a cambiar
	 * <b>Pre:</b> tecnicosFactory debe ser distinto de null<br>
	 * <b>Post:</b> El atributo servicios cambia
	 */
	public void setServicios(HashMap<String, Servicio> servicios) {
		this.servicios = servicios;
	}

	/**
	 * Método que devuelve la lista de facturas
	 * @return ArrayList de Factura
	 */
	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}

	/**
	 * Setter del atributo listaFacturas
	 * @param tecnicosFactory Nueva referencia de tecnicosFactory a cambiar
	 * <b>Pre:</b> tecnicosFactory debe ser distinto de null<br>
	 * <b>Post:</b> El atributo tecnicosFactory cambia
	 */
	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public int getMesPago() {
		return mesPago;
	}

	public void setMesPago(int mesPago) {
		this.mesPago = mesPago;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public void setTotalPagado(double totalPagado) {
		this.totalPagado = totalPagado;
	}

}
