package modelo;

import java.text.SimpleDateFormat;
import interfaces.IAbonado;

/**
 * @author Clase que representa una factura dentro del sistema
 */
public class Factura implements Cloneable {

	private IAbonado abonado;
	private String fecha;
	private double total;
	private boolean pago = false;

	/**
	 * Constructor de la clase
	 * 
	 * @param decorator: decorator para realizar la factura <b> pre: </b> decorator
	 *                   no debe ser nulo <b> post: </b> crea un objeto de tipo
	 *                   factura
	 */
	public Factura(IAbonado abonado) {
		super();
		this.abonado = abonado;
		this.total = this.abonado.getCostoServicios();
		SimpleDateFormat fechaSimple = new SimpleDateFormat("dd/MM/yyyy");
		this.fecha = fechaSimple.format(this.abonado.getFecha().getTime());
	}

	/**
	 * metodo void que imprime la informacion de la factura de un abonado
	 */
	public void getFactura() {
		System.out.println(this.abonado.getNombre() + "     " + this.abonado.getDNI() + "\n");
		this.abonado.imprimeServicios();
		total = this.abonado.getCostoServicios();
	}

	/**
	 * metodo que clona la factura <b> puede retornar una excepcion
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Factura clonada = (Factura) super.clone();
		clonada.abonado = (DecoratorPagos) abonado.clone();
		return clonada;
	}

	public void agregarServicio(String domicilio, Servicio s1) {
		abonado.agregaServicio(domicilio, s1);
	}

	public void EfectuaPago(double total) {
		this.total = total;
		this.pago = true;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		

		if (pago)
			return "[" + this.fecha + "]: $" + total;
		else
			return "[" + this.fecha + "]: $" + total + "  --ADEUDADO--";
	}

}
