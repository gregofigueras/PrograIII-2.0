package interfaces;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import excepciones.DomicilioInvalidoException;
import modelo.Factura;
import modelo.Servicio;

public interface IState {
	void pagarFactura();
	void contratarNuevoServicio(String domicilio, Servicio servicio);
	void bajaDeUnServicio(String domicilio) throws DomicilioInvalidoException;
	String getEstado();
}
