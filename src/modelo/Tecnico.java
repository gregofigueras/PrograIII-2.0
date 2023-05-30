package modelo;

public class Tecnico {
	private String nombre;
	private boolean libre = true;
	
	public Tecnico(String nombre) {
		this.nombre = nombre;
	}

	public synchronized void ConsultaTecnica(Abonado abonado) {
		while (libre == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("El tecnico "+ this.nombre + "esta asistiendo a " + abonado.nombre);
		this.libre = false; 
	}

	public synchronized void TerminaConsulta(Abonado abonado) {
		System.out.println("El tecnico "+ this.nombre + " ahora esta libre");
		this.libre = true;
		notifyAll();
	}
}
