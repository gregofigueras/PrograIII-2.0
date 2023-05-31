package state;

import java.util.GregorianCalendar;

import excepciones.DomicilioInvalidoException;
import interfaces.IState;
import modelo.AbonadoFisico;
import modelo.Servicio;

public class ConContratacionesState implements IState {
	
	private AbonadoFisico AbonadoF;
	
	
	public ConContratacionesState (AbonadoFisico AbonadoF) {
		this.AbonadoF = AbonadoF;
	}
	
	public void PagarFactura(GregorianCalendar fecha, double total) {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI() + ",");
		this.AbonadoF.PagarFactura(fecha,total);
	
	}
	
	public void ContratarNuevoServicio(String domicilio, Servicio servicio) {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI() + "quiere contratar un nuevo servicio");
		this.AbonadoF.agregaServicio(domicilio,servicio );
	}
	
	
	public void BajaDeUnServicio(String domicilio) throws DomicilioInvalidoException {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI() + "quiere dar de baja un servicio");
		this.AbonadoF.quitaServicio(domicilio);
	}
}

