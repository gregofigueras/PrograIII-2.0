package interfaces;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import excepciones.DomicilioInvalidoException;
import modelo.Factura;
import modelo.Servicio;

public interface IState {
	void PagarFactura();
	void ContratarNuevoServicio(String domicilio, Servicio servicio);
	void BajaDeUnServicio(String domicilio) throws DomicilioInvalidoException;
	void actua();
}
