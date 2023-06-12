package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import excepciones.TipoAbonadoInvalidoException;
import excepciones.TipoPagoInvalidoException;
import factory.AbonadoFactory;
import factory.TecnicosFactory;
import interfaces.IAbonado;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

/**
 * @author Clase del patron factory para crear nuevos objetos de instancia
 *         IAbonado
 */
public class Sistema implements Serializable {
	private ArrayList<IAbonado> abonados = new ArrayList<IAbonado>();
	IPersistencia persistencia = new PersistenciaXML();
	private static Sistema instance = null;
	private TecnicosFactory tecnicos;
	private GregorianCalendar fecha = new GregorianCalendar();

	private Sistema() {
		this.abonados = new ArrayList<IAbonado>();
		this.tecnicos = new TecnicosFactory();
	}

	public void creaAbonado(String tipoAbonado, String formaPago, String nombre, String DNI) {// Para limpiar codigo y
																								// que no
		IAbonado abonado; // No este el factory aca metido
		try {
			abonado = AbonadoFactory.getAbonado(tipoAbonado, formaPago, nombre, DNI, fecha, tecnicos);
			this.abonados.add(abonado);
		} catch (TipoAbonadoInvalidoException e) {
			e.getMessage();
		} catch (TipoPagoInvalidoException e) {
			e.getMessage();
		}
	}

	public void agregaTecnico(String nombre, String id) {
		tecnicos.agregaTecnico(nombre, id);
	}

	public void eliminaTecnico(Tecnico tecnico) {
		tecnicos.eliminaTecnico(tecnico);
	}

	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos.getListaTecnicos();
	}

	public TecnicosFactory getTecnicoFactory() {
		return this.tecnicos;
	}

	/**
	 * Constructor de la clase sistemaFactory
	 */
	public static Sistema getInstance() {
		if (instance == null)
			instance = new Sistema();
		return instance;
	}

	public ArrayList<IAbonado> getAbonados() {
		return this.abonados;
	}

	public void eliminaAbonado(IAbonado abonado) {
		this.abonados.remove(abonado);
	}

	public void finalizaJornada() {
		try {
			persistencia.abrirOutput("listaAsociada.xml");
			System.out.println("Archivo de escritura creado");
			persistencia.escribir(abonados);
			System.out.println("Lista de abonados cargada");
			persistencia.escribir(tecnicos);
			System.out.println("Lista de tecnicos cargada");
			persistencia.cerrarOutput();
			System.out.println("Archivo de escritura cerrado");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void iniciaJornada() {
		try {
			persistencia.abrirInput("listaAsociada.xml");
			System.out.println("Archivo de lectura abierto");
			abonados = (ArrayList<IAbonado>) persistencia.Leer();
			System.out.println("Abonados cargados");
			tecnicos = (TecnicosFactory) persistencia.Leer();
			System.out.println("Tecnicos cargados");
			persistencia.cerrarInput();
			System.out.println("Archivo de lectura cerrado");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void simularMes() {
		Iterator<IAbonado> it = this.abonados.iterator();
		this.fecha.add(Calendar.MONTH, +1);
		while (it.hasNext()) {
			IAbonado abonadoActual = it.next();
			abonadoActual.simularMes(this.fecha);
			abonadoActual.actualizaEstado();
		}
	}

	public void sumarDia() {
		Iterator<IAbonado> it = this.abonados.iterator();
		this.fecha.add(Calendar.DAY_OF_YEAR, +1);
		while (it.hasNext()) {
			IAbonado abonadoActual = it.next();
			abonadoActual.sumarDia(this.fecha);
			abonadoActual.actualizaEstado();

		}
	}
}
