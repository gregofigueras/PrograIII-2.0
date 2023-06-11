package factory;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import modelo.Abonado;
import modelo.Tecnico;

public class TecnicosFactory extends Observable {
	private static ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
	private Random r;
	private String abonado;

	public void agregaTecnico(String nombre, String id) {
		Tecnico tecnico = new Tecnico(nombre, id);
		tecnicos.add(tecnico);
	}

	public void eliminaTecnico(Tecnico tecnico) {
		tecnicos.remove(tecnico);
	}

	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public synchronized int ConsultaTecnica(Abonado abonado) {
		int i;
		do
			i = r.nextInt(20);
		while (tecnicos.get(i).libre == false);

		System.out.println("El tecnico " + tecnicos.get(i).getNombre() + "esta asistiendo a " + this.abonado);
		tecnicos.get(i).libre = false;
		this.setChanged();
		this.notifyObservers(this);
		return i;
	}

	public synchronized void TerminaConsulta(Abonado abonado, int i) {
		System.out.println("El tecnico " + tecnicos.get(i).getNombre() + " ahora esta libre");
		tecnicos.get(i).libre = true;
	}

}
