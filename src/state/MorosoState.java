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

		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI()
				+ ",quiere pagar una factura. Tendra un 30% de recargo");
		this.AbonadoF.EfectuaPago();
		this.AbonadoF.setEstado(new ConContratacionesState(this.AbonadoF));
	}

	public void contratarNuevoServicio(String domicilio, Servicio servicio) {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI()
				+ " no puede contratar un servicio al estar moroso");
	}

	public void bajaDeUnServicio(String domicilio) throws DomicilioInvalidoException {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI()
				+ " no puede dar de baja un servicio porque esta moroso");
	}

	@Override
	public String getEstado() {
		return "Moroso";
	}

}
