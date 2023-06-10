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

	public void PagarFactura() {

		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI()
				+ ",quiere pagar una factura. Tendra un 30% de recargo");
		this.AbonadoF.EfectuaPago(1.3);
		this.AbonadoF.setEstado(new ConContratacionesState(this.AbonadoF));
	}

	public void ContratarNuevoServicio(String domicilio, Servicio servicio) {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI()
				+ "quiere contratar un nuevo servicio pero no puede ya que debe una factura");
	}

	public void BajaDeUnServicio(String domicilio) throws DomicilioInvalidoException {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI()
				+ "quiere dar de baja un servicio pero no puede ya que debe una factura");
	}

	public void actua() {
		System.out.println("El abonado se encuentra en estado MOROSO");
	}

	@Override
	public String getEstado() {
		return "Moroso";
	}

}
