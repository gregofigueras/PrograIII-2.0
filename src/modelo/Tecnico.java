package modelo;

import java.io.Serializable;

import controlador.Controlador;

public class Tecnico implements Serializable {
	private String nombre;
	public boolean libre;
	private Abonado abonado;
	private String id;
	public Controlador controlador;

	public Tecnico(String nombre, String id) {
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

	public String getID() {
		return id;
	}

	@Override
	public String toString() {
		if (libre)
			return "[" + id + "] " + nombre;
		else
			return "[" + id + "] " + nombre + " [ocupado]";
	}
}