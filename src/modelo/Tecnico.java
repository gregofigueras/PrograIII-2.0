package modelo;

import java.io.Serializable;
import java.util.Random;

public class Tecnico implements Serializable {
	protected String nombre;
	private Abonado abonado; 
	
	public Tecnico(String nombre) {
		this.nombre = nombre;
		this.abonado = null;
		
	}
	
	public void run(Abonado abonado) { 
		this.abonado = abonado;
		this.abonado.ConsultaTecnica(this); 
		Random r = new Random(); 
		int q = r.nextInt(60); 
		try {
			Thread.sleep(q);
			this.abonado.TerminaConsulta(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
