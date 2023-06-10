package state;

import java.util.GregorianCalendar;

import interfaces.IState;
import modelo.AbonadoFisico;
import modelo.Servicio;

public class SinContratacionesState implements IState {
	
	private AbonadoFisico AboandoF;
	
	public SinContratacionesState (AbonadoFisico AbonadoF) {
		this.AboandoF = AbonadoF;
	}
	
	public void PagarFactura() {
		System.out.println("ERROR: el abonado con DNI: " + this.AboandoF.getDNI() + ", no puede pagar la factura debido a que no tiene contrataciones hechas");
		//no puede pagar aún”. EN LA VENTANA
	}
	
	public void ContratarNuevoServicio(String domicilio, Servicio servicio) {
		System.out.println("El abonado con DNI: " + this.AboandoF.getDNI() + "quiere contratar un nuevo servicio");
		this.AboandoF.setEstado ( new ConContratacionesState(this.AboandoF) ); 
		this.AboandoF.agregaServicio(domicilio,servicio );
	}

	public void BajaDeUnServicio(String Domicilio) {
		System.out.println("ERROR: el abonado con DNI: " + this.AboandoF.getDNI() + ", no puede dar de baja un sercivio ya que no tiene servicios contratados");
	}


	public void actua() {
		System.out.println("El abonado no tiene contrtaciones");	
	}

	@Override
	public String getEstado() {
		return "Sin contrataciones";
	}
	
}


