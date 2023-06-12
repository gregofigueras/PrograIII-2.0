package state;

import excepciones.DomicilioInvalidoException;
import interfaces.IState;
import modelo.AbonadoFisico;
import modelo.Servicio;

public class ConContratacionesState implements IState {

	private AbonadoFisico AbonadoF;

	public ConContratacionesState(AbonadoFisico AbonadoF) {
		this.AbonadoF = AbonadoF;
	}

	public void pagarFactura() {
		this.AbonadoF.EfectuaPago();
	}

	public void contratarNuevoServicio(String domicilio, Servicio servicio) {
		this.AbonadoF.agregaServicio(domicilio, servicio);
	}

	public void bajaDeUnServicio(String domicilio) throws DomicilioInvalidoException {
		this.AbonadoF.quitaServicio(domicilio);
	}

	@Override
	public String getEstado() {
		return "Con contrataciones";
	}
}
