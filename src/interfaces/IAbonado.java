package interfaces;

import java.util.HashMap;

import excepciones.DomicilioInvalidoException;
import modelo.Servicio;

public interface IAbonado extends Cloneable {
	double getCostoServicios();
	String getNombre();
	String getDNI();
	String getTipo();
	void imprimeServicios();
	Object clone() throws CloneNotSupportedException;
	void agregaServicio(String domicilio, Servicio servicio);
	void quitaServicio(String domicilio) throws DomicilioInvalidoException;
	HashMap<String,Servicio> getServicio();
}
