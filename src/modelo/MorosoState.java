package modelo;

import excepciones.DomicilioInvalidoException;
import interfaces.IState;

public class MorosoState implements IState {
	
	
private AbonadoFisico AbonadoF;
	
	
	public MorosoState (AbonadoFisico AbonadoF) {
		this.AbonadoF = AbonadoF;
	}
	
	public void PagarFactura() {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI() + ",quiere pagar una factura");
		
	}
	
	public void ContratarNuevoServicio(String domicilio, Servicio servicio) {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI() + "quiere contratar un nuevo servicio pero no puede ya que debe una factura");
	}
	
	
	public void BajaDeUnServicio(String domicilio) throws DomicilioInvalidoException {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI() + "quiere dar de baja un servicio pero no puede ya que debe una factura");
	}
	
}
