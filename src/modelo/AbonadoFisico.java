package modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * @author 
 *Clase que representa un abonado de tipo fisico dentro del sistema
 */
public class AbonadoFisico extends Abonado implements Runnable{
	
	/**
	 * Constructor de la clase
	 * @param nombre: nombre del abonado
	 * @param DNI: DNI del abonado
	 * <b> pre: </b> nombre tiene que ser no vacio y no null <br> 
	 * <b> pre: </b> DNI tiene que ser no vacio y no null <br> 
	 * <b> post: </b> Crea un objeto de tipo abonado 
	 */
	public AbonadoFisico(String nombre, String DNI) {
		super(nombre, DNI);
		assert nombre != null : "nombre no valido";
		assert nombre != "" : "nombre no valido";
		assert DNI != null : "DNI no valido";
		assert DNI != "" : "DNI no valido";
	}

	/**
	 *metodo que calcula el costo neto de todos los vervicios
	 * <b> pre: </b> HashMap debe ser no nulo <br>  
	 * <b> post: </b> retorna el costo neto de los servicios de un domicilio 
	 */
	@Override
	public double getCostoServicios() {
		Iterator<Entry<String,Servicio>> it = this.servicios.entrySet().iterator();//Iterator del Set del HashMap
		double resultado = 0;
		
		while (it.hasNext())
			resultado += it.next().getValue().getCostoNeto();
		return resultado;
	}


	/**
	 *metodo que clona el abonado <br>
	 *el metodo nunca va a lanzar una excepcion 
	 *<b> post: </b> genera un clon de un abonado de tipo fisico
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		AbonadoFisico clonado= (AbonadoFisico) super.clone();
		return clonado;
	}

	@Override
	public String getTipo() {
		return "Fisico";
	}

	@Override
	public HashMap<String, Servicio> getServicio() {
		return null;
	}
	

}
