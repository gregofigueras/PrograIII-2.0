package state;

import excepciones.DomicilioInvalidoException;
import interfaces.IState;
import modelo.AbonadoFisico;
import modelo.Servicio;

public class MorosoState implements IState {

	private AbonadoFisico AbonadoF;

	public MorosoState(AbonadoFisico AbonadoF) {
		this.AbonadoF = AbonadoF;
	}

	public void pagarFactura() {

		this.AbonadoF.EfectuaPago();
		this.AbonadoF.setEstado(new ConContratacionesState(this.AbonadoF));
	}

	public void contratarNuevoServicio(String domicilio, Servicio servicio) {
	}

	public void bajaDeUnServicio(String domicilio) throws DomicilioInvalidoException {
	}

	@Override
	public String getEstado() {
		return "Moroso";
	}

}
