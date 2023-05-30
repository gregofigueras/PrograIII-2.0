package modelo;

import java.util.GregorianCalendar;

import interfaces.IAbonado;

/**
 * @author 
 *Clase que representa una factura dentro del sistema
 */
public class Factura implements Cloneable{ 
	private IAbonado abonado;
	private GregorianCalendar fecha;
	private double total;

	/**
	 * Constructor de la clase
	 * @param decorator: decorator para realizar la factura
	 * <b> pre: </b> decorator no debe ser nulo 
	 * <b> post: </b> crea un objeto de tipo factura
	 */
	public Factura(IAbonado abonado) {
		super();
		this.abonado = abonado;
		this.total = this.abonado.getCostoServicios();
	}
	
	/**
	 * metodo void que imprime la informacion de la factura de un abonado  
	 */
	public void getFactura() {
		System.out.println(this.abonado.getNombre() + "     " + this.abonado.getDNI() + "\n");
		this.abonado.imprimeServicios();
		total=this.abonado.getCostoServicios();
		this.fecha=abonado.getFecha();
	}

	/**
	 *metodo que clona la factura <b> 
	 * puede retornar una excepcion 
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Factura clonada= (Factura) super.clone();
		clonada.abonado= (DecoratorPagos) abonado.clone();
		return clonada;
	}
	
	public void agregarServicio(String domicilio,Servicio s1) {
		abonado.agregaServicio(domicilio, s1);
		
	}
}
