package modelo;

import java.io.Serializable;

public class Tecnico implements Serializable {
	private String nombre;
	public boolean libre;
	private Abonado abonado;

	public Tecnico(String nombre) {
		this.nombre = nombre;
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