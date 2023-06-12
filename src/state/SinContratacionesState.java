package state;

import interfaces.IState;
import modelo.AbonadoFisico;
import modelo.Servicio;

public class SinContratacionesState implements IState {

	private AbonadoFisico AboandoF;

	public SinContratacionesState(AbonadoFisico AbonadoF) {
		this.AboandoF = AbonadoF;
	}

	public void pagarFactura() {
		// no puede pagar aún”. EN LA VENTANA
	}

	public void contratarNuevoServicio(String domicilio, Servicio servicio) {
		this.AboandoF.setEstado(new ConContratacionesState(this.AboandoF));
		this.AboandoF.agregaServicio(domicilio, servicio);
	}

	public void bajaDeUnServicio(String Domicilio) {
	}

	@Override
	public String getEstado() {
		return "Sin contrataciones";
	}

}
