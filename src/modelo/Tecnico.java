package modelo;

import java.io.Serializable;

public class Tecnico implements Serializable {
	private String nombre;
	public boolean libre;
	private Abonado abonado;
	private int id;

	public Tecnico(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
		this.abonado = null;
		this.libre = true;
	}

	public Abonado getAbonado() {
		return abonado;
	}

	public void setAbonado(Abonado abonado) {
		this.abonado = abonado;
	}

	public String getNombre() {
		return nombre;
	}

}