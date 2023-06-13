package factory;

import interfaces.IAbonado;
import interfaces.IPromocion;
import modelo.PromoDorada;
import modelo.PromoPlatino;
import modelo.Servicio;
import modelo.ServicioComercio;
import modelo.ServicioVivienda;

/**
 * @author
 * Clase perteneciente al patrón creacional Factory<br>
 * Crea instancias de la clase Servicio
 *
 */
public class ServicioFactory {

	public static IPromocion dorada = new PromoDorada();
	public static IPromocion platino = new PromoPlatino();

	/**
	 * Método void que crea una instancia de la clase Servicio, y la agrega al mapa de servicios de un abonado
	 * @param abonado Referencia que representa el abonado al cual agregar el servicio creado
	 * @param domicilio Domicilio del servicio
	 * @param tipo Tipo de servicio
	 * @param promo Promo del servicio
	 * @param cantBA Cantidad de botones antipánico
	 * @param cantCamaras Cantidad de camaras
	 * @param acomp Movil de acompañamiento
	 * <b>Pre:</b> abonado debe ser distinto de null<br>
	 * <b>Pre:</b> el atributo de abonado servicios debe ser distinto de null<br>
	 * <b>Pre:</b> domicilio debe ser distinto de null<br>
	 * <b>Pre:</b> tipo debe ser "Comercio" o "Vivienda"<br>
	 * <b>Pre:</b> cantBA debe ser mayor o igual a 0<br>
	 * <b>Pre:</b> cantCamaras debe ser mayor o igual a 0<br>
	 * <b>Post</b> Agrega una nueva instancia de servicio al HashMap servicios del abonado
	 */
	public static void agregaServicio(IAbonado abonado, String domicilio, String tipo, String promo, int cantBA,
			int cantCamaras, boolean acomp) {
		Servicio servicio = getServicio(tipo, promo, cantBA, cantCamaras, acomp);
		abonado.agregaServicio(domicilio, servicio);
	}

	/**
	 * Método principal del patrón factory que crea y devuelve una instancia de la clase Servicio con los parametros dados
	 * @param tipo Tipo de servicio
	 * @param promo Promo del servicio
	 * @param cantBA Cantidad de botones antipánico
	 * @param cantCamaras Cantidad de cámaras
	 * @param acomp Móvil de acompañamient
	 * @return Nueva instancia de la clase Servicio con los parametros dados
	 */
	public static Servicio getServicio(String tipo, String promo, int cantBA, int cantCamaras, boolean acomp) {
		Servicio respuesta = null;
		IPromocion estaPromo;

		if (promo == "Dorada") {
			estaPromo = dorada;
		} else if (promo == "Platino") {
			estaPromo = platino;
		} else
			estaPromo = null;

		if (tipo.equalsIgnoreCase("Comercio")) {
			respuesta = new ServicioComercio(cantCamaras, cantBA, acomp, estaPromo);
		} else
			respuesta = new ServicioVivienda(cantCamaras, cantBA, acomp, estaPromo);
		return respuesta;
	}
}
