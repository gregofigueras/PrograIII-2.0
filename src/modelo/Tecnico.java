package modelo;

import controlador.Controlador;

public class Tecnico {
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

	public Tecnico() {
		super();
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}