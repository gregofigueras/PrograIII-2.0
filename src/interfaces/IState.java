package interfaces;

import excepciones.DomicilioInvalidoException;
import modelo.Servicio;

public interface IState {
	void PagarFactura();
	void ContratarNuevoServicio(String domicilio, Servicio servicio);
	void BajaDeUnServicio(String domicilio) throws DomicilioInvalidoException;
}
