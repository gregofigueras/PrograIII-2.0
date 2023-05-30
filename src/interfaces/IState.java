package interfaces;

import java.util.GregorianCalendar;

import excepciones.DomicilioInvalidoException;
import modelo.Servicio;

public interface IState {
	void PagarFactura(GregorianCalendar fecha, double total);
	void ContratarNuevoServicio(String domicilio, Servicio servicio);
	void BajaDeUnServicio(String domicilio) throws DomicilioInvalidoException;
}
