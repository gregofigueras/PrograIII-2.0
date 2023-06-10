package modelo;

import interfaces.IPromocion;

/**
 * @author Clase que representa un servicio a una vivienda
 */
public class ServicioVivienda extends Servicio {

	/**
	 * Constructor de la clase ServicioVivienda
	 * 
	 * @param cantCamaras: Cantidad de camaras del servicio
	 * @param cantBotonAP: Cantidad de botones antipanico
	 * @param movilAcomp:  Booleano que indica verdadero si el servicio posee movil
	 *                     de acompanamiento, falso en caso contrario
	 * @param promo:       Promo del servicio<br>
	 *                     <b>Pre:</b> cantCamaras debe ser mayor o igual que 0<br>
	 *                     <b>Pre:</b> cantBotonAP debe ser mayor o igual que 0<br>
	 *                     <b>Post:</b> Crea un objeto instancia de la clase
	 *                     ServicioComercio
	 */
	public ServicioVivienda(int cantCamaras, int cantBotonAP, boolean movilAcomp, IPromocion promo) {
		super(8500, cantCamaras, cantBotonAP, movilAcomp, promo);
		assert cantCamaras >= 0 : "cantidad de camaras no valida";
		assert cantBotonAP >= 0 : "cantidad de botones antipanico invalida";
	}

	/**
	 * Calcula el costo neto del servicio teniendo en cuenta el atributo promo
	 */
	@Override
	public double getCostoNeto() {
		if (this.promo != null)
			return promo.getPromoVivienda(this.getCostoBruto());
		else
			return this.getCostoBruto();
	}

	@Override
	public String toString() {
		if (promo != null) {
			return "Servicio a Vivienda : Precio base:" + precioBase + "$, Cantidad de camaras:" + cantCamaras
					+ ", Cantidad de" + " botones antipanico:" + cantBotonAP + ", Movil de acompanamiento:" + movilAcomp
					+ ", Id del servicio=" + numId + ", Promo:" + promo.getPromoNombre();
		} else {
			return "Servicio a Vivienda : Precio base:" + precioBase + "$, Cantidad de camaras:" + cantCamaras
					+ ", Cantidad de" + " botones antipanico:" + cantBotonAP + ", Movil de acompanamiento:" + movilAcomp
					+ ", Id del servicio=" + numId;
		}
	}

}
