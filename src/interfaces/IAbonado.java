package interfaces;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import excepciones.DomicilioInvalidoException;
import modelo.Factura;
import modelo.Servicio;

public interface IAbonado extends Cloneable, Runnable {
	double getCostoServicios();

	String getNombre();

	String getDNI();

	String getTipo();

	GregorianCalendar getFecha();

	void imprimeServicios();

	Object clone() throws CloneNotSupportedException;

	void agregaServicio(String domicilio, Servicio servicio);

	void quitaServicio(String domicilio) throws DomicilioInvalidoException;

	Servicio getServicio(String domicilio);

	HashMap<String, Servicio> getServicio();

	void pagarFactura();

	void AgregarFactura(Factura factura);

	ArrayList<Factura> getFactura();

	String toString();

	String getEstado();

	void simularMes(GregorianCalendar fecha);

	void sumarDia(GregorianCalendar fecha);

	double getTotalPagado();
	
	void actualizaEstado();
}
