package modelo;

import java.util.ArrayList;
import java.util.Random;

public class SistemaTecnicos {
	private static ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
	private Random r;
	private String abonado;

	public void setTecnico(String nombre) {
		Tecnico tecnico = new Tecnico(nombre);
		tecnicos.add(tecnico);
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
		return i;
	}

	public synchronized void TerminaConsulta(Abonado abonado, int i) {
		System.out.println("El tecnico " + tecnicos.get(i).getNombre() + " ahora esta libre");
		tecnicos.get(i).libre = true;
	}

}
