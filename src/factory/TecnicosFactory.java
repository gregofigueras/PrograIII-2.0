package factory;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import modelo.Abonado;
import modelo.Tecnico;

public class TecnicosFactory extends Observable {
	private static ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
	private String abonado;

	public void agregaTecnico(String nombre, String id) {
		Tecnico tecnico = new Tecnico(nombre, id);
		tecnicos.add(tecnico);
	}

	public void eliminaTecnico(Tecnico tecnico) {
		tecnicos.remove(tecnico);
	}

	public ArrayList<Tecnico> getListaTecnicos() {
		return tecnicos;
	}

	public Tecnico getTecnico(int i) {
		return tecnicos.get(i);
	}

	public synchronized int ConsultaTecnica(Abonado abonado) {
		int i;
		Random r = new Random();
		do
			i = r.nextInt(tecnicos.size());
		while (tecnicos.get(i).libre == false);

		System.out.println("Tecnico ID:" + tecnicos.get(i).getID() + "esta asistiendo a " + abonado.getNombre());
		tecnicos.get(i).libre = false;
		this.setChanged();
		this.notifyObservers();
		return i;
	}

	public synchronized void TerminaConsulta(Abonado abonado, int i) {
		System.out.println("El tecnico " + tecnicos.get(i).getNombre() + " ahora esta libre");
		tecnicos.get(i).libre = true;
		this.setChanged();
		this.notifyObservers();
	}

}
