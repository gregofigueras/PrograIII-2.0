package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import excepciones.TipoAbonadoInvalidoException;
import excepciones.TipoPagoInvalidoException;
import interfaces.IAbonado;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;

/**
 * @author Clase del patron factory para crear nuevos objetos de instancia
 *         IAbonado
 */
public class SistemaFactory implements Serializable {
	private ArrayList<IAbonado> abonados = new ArrayList<IAbonado>();
	IPersistencia persistencia = new PersistenciaXML();
	private static SistemaFactory instance = null;
	private SistemaTecnicos tecnicos;
	
	
	private SistemaFactory() {
		this.abonados = new ArrayList<IAbonado>();
		this.tecnicos = new SistemaTecnicos();
	}

	public void creaAbonado(String tipoAbonado, String formaPago, String nombre, String DNI) {//Para limpiar codigo y que no
		IAbonado abonado;																	  //No este el factory aca metido
		try {
			abonado = AbonadoFactory.getAbonado(tipoAbonado, formaPago, nombre, DNI);
			this.abonados.add(abonado);
		}
		catch(TipoAbonadoInvalidoException e) {
			e.getMessage();
		}
		catch(TipoPagoInvalidoException e) {
			e.getMessage();
		}
	}
	
	/**
	 * Constructor de la clase sistemaFactory
	 */
	public static SistemaFactory getInstance() {
		if (instance == null)
			instance = new SistemaFactory();
		return instance;
	}
	
	public ArrayList<IAbonado> getAbonados(){
		return this.abonados;
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
			tecnicos = (SistemaTecnicos)persistencia.Leer();
			System.out.println("Tecnicos cargados");
			persistencia.cerrarInput();
			System.out.println("Archivo de lectura cerrado");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
