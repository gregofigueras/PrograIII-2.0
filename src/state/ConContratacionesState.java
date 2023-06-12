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
	
	public void pagarFactura() {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI() + " ,quiere pagar su factura");
		this.AbonadoF.EfectuaPago();
	}
	
	public void contratarNuevoServicio(String domicilio, Servicio servicio) {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI() + "quiere contratar un nuevo servicio");
		this.AbonadoF.agregaServicio(domicilio,servicio );
	}
	
	
	public void bajaDeUnServicio(String domicilio) throws DomicilioInvalidoException {
		System.out.println("El abonado con DNI: " + this.AbonadoF.getDNI() + "quiere dar de baja un servicio");
		this.AbonadoF.quitaServicio(domicilio);
	}

	@Override
	public String getEstado() {
		return "Con contrataciones";
	}
}

