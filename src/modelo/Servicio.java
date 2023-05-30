package modelo;

import interfaces.IPromocion;

/**
 * @author
 *Clase abstracta que representa un Servicio 
 */
public abstract class Servicio implements Cloneable{
	protected float precioBase;
	protected int cantCamaras;
	protected int cantBotonAP;
	protected boolean movilAcomp;
	protected static int sigNumId = 0;
	protected int numId;	//Identificacion de servicio (unica)
	protected IPromocion promo;
	
	/**
	 * Constructor de la clase Servicio
	 * @param precioBase: Precio base del servicio
	 * @param cantCamaras: Cantidad de camaras
	 * @param cantBotonAP: Cantidad de botones antipanico
	 * @param movilAcomp: Booleano que indica verdadero si el servicio posee movil de acompanamiento, falso en caso contrario
	 * @param promo: Promo del servicio<br>
	 * <b>Pre:</b> precioBase debe ser mayor que 0<br>
	 * <b>Pre:</b> cantCamaras debe ser mayor o igual que 0<br>
	 * <b>Pre:</b> cantBontonAP debe ser mayor o igual a 0<br>
	 * <b>Post:</b> Crea un objeto instancia de la clase servicio
	 */
	public Servicio(float precioBase, int cantCamaras, int cantBotonAP, boolean movilAcomp, IPromocion promo) {
		assert precioBase > 0 : "precio base no es valido";
		assert cantCamaras >= 0 : "cantidad de camaras no valida";
		assert cantBotonAP >= 0 : "cantidad de botones antipanico invalida";
		//de promo?
		this.precioBase = precioBase;
		this.cantCamaras = cantCamaras;
		this.cantBotonAP = cantBotonAP;
		this.movilAcomp = movilAcomp;
		sigNumId++;
		this.numId = sigNumId;
		this.promo = promo;
		assert this.precioBase==precioBase : "fallo postcondicion";
		assert this.cantCamaras == cantCamaras : "fallo postcondicion";
		assert this.cantBotonAP == cantBotonAP : "fallo postcondicion";
		assert this.movilAcomp == movilAcomp : "fallo postcondicion";
		assert this.numId == sigNumId : "fallo postcondicion";
		assert this.promo == promo : "fallo postcondicion";
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public int getCantCamaras() {
		return cantCamaras;
	}

	public int getCantBotonAP() {
		return cantBotonAP;
	}

	public boolean isMovilAcomp() {
		return movilAcomp;
	}

	public int getNumId() {
		return numId;
	}
	
	public IPromocion getPromo() {
		return promo;
	}

	/**
	 * Calcula el costo bruto (sin promociones aplicadas) de un servicio
	 * @return Devuelve un double que representa el costo bruto de un servicio
	 */
	public double getCostoBruto() {
		if (this.movilAcomp)
			return this.precioBase+3000*this.cantCamaras+2000*this.cantBotonAP+7500;
		else
			return this.precioBase+3000*this.cantCamaras+2000*this.cantBotonAP;
	}
	
	/**
	 * Metodo abstracto que calcula el costo neto (con promociones aplicadas) de un servicio
	 * @return Devuelve un double que represetna el costo neto de un servicio
	 */
	public abstract double getCostoNeto();//Double dispatch
	
	/**
	 *Metodo que clona un objeto de tipo servicio
	 */
	public Object clone()throws CloneNotSupportedException {
		Servicio clonado;
		
		clonado = (Servicio)super.clone();//Superficial
		return clonado;
	}
	
	

}
