package factory;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import modelo.Tecnico;

/**
 * @author Clase que gestiona a los técnicos dentro de un sistema
 */
public class TecnicosFactory extends Observable {
	private static ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();

	/**
	 * Método que crea a un técnico según los parámetros dados y lo agrega a la
	 * lista de técnicos
	 * 
	 * @param nombre Nombre del técnico
	 * @param id     ID del técnico <b>Pre:</b> nombre debe ser diferente de
	 *               null<br>
	 *               <b>Pre:</b> id debe ser diferente de null<br>
	 *               <b>Post:</b> Una instancia de Tecnico es creada y agregada al
	 *               ArrayList tecnicos
	 */
	public void agregaTecnico(String nombre, String id) {
		Tecnico tecnico = new Tecnico(nombre, id);
		tecnicos.add(tecnico);
	}

	/**
	 * Método que elimina un técnico dado del ArrayList tecnicos
	 * 
	 * @param tecnico Técnico a eliminar <b>Pre:</b> tecnico debe ser diferente de
	 *                null<br>
	 *                <b>Post:</b> El técnico es eliminado de la lista
	 */
	public void eliminaTecnico(Tecnico tecnico) {
		tecnicos.remove(tecnico);
	}

	/**
	 * Método que devuelve la lista de técnicos
	 * 
	 * @return ArrayList de tecnicos
	 */
	public ArrayList<Tecnico> getListaTecnicos() {
		return tecnicos;
	}

	/**
	 * Método que devuelve un solo técnico dado un índice
	 * 
	 * @param i Indice
	 * @return Referencia al técnico que ocupa el índice i en la lista <b>Pre:</b> i
	 *         debe ser mayor o igual a 0, y menor que el tamaño del ArrayList
	 *         tecnicos
	 */
	public Tecnico getTecnico(int i) {
		return tecnicos.get(i);
	}

	/**
	 * Método que elige un técnico que no este ocupado, cambia su estado a ocupado,
	 * y devuelve el índice del técnico en la lista de técnicos
	 * 
	 * @return indice del técnico seleccionado dentro del ArrayList tecnicos
	 */
	public synchronized int consultaTecnica() {
		int i;
		Random r = new Random();
		do
			i = r.nextInt(tecnicos.size());
		while (tecnicos.get(i).libre == false);
		tecnicos.get(i).libre = false;
		this.setChanged();
		this.notifyObservers();
		return i;
	}

	/**
	 * Método que representa a un técnico que termina su consulta
	 * 
	 * @param i <b>Pre:</b> i debe ser mayor o igual a 0 y menor que el tamaño de la
	 *          lista de tecnicos
	 */
	public synchronized void terminaConsulta(int i) {
		tecnicos.get(i).libre = true;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Constructor vacio de la clase<br>
	 * Requisito de persistencia mediante XML
	 */
	public TecnicosFactory() {
		super();
	}

	/**
	 * Método que devuelve la lista de tecnicos
	 * 
	 * @return ArrayList de Tecnico
	 */
	public static ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}

	/**
	 * Setter del atributo tecnicos
	 * 
	 * @param tecnicos Lista de tecnicos <b>Pre:</b> tecnicos debe ser distinto de
	 *                 null<br>
	 *                 <b>Post:</b> El atributo tecnicos referencia a una nueva
	 *                 instancia de ArrayList de Tecnico
	 */
	public static void setTecnicos(ArrayList<Tecnico> tecnicos) {
		TecnicosFactory.tecnicos = tecnicos;
	}

}
