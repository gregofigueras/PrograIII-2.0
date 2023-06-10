package factory;

import interfaces.IPromocion;
import modelo.Abonado;
import modelo.PromoDorada;
import modelo.PromoPlatino;
import modelo.Servicio;
import modelo.ServicioComercio;
import modelo.ServicioVivienda;

public class ServicioFactory {

	public static IPromocion dorada = new PromoDorada();
	public static IPromocion platino = new PromoPlatino();

	public void agregaServicio(Abonado abonado, String domicilio, String tipo, String promo, int cantBA,
			int cantCamaras, boolean acomp) {
		Servicio servicio = getServicio(tipo, promo, cantBA, cantCamaras, acomp);
		abonado.agregaServicio(domicilio, servicio);
	}

	public static Servicio getServicio(String tipo, String promo, int cantBA, int cantCamaras, boolean acomp) {
		Servicio respuesta = null;
		IPromocion estaPromo;

		if (promo == "Dorada") {
			estaPromo = dorada;
		} else if (promo == "Platino") {
			estaPromo = platino;
		} else
			estaPromo = null;
		if (tipo == "Comercio") {
			respuesta = new ServicioComercio(cantCamaras, cantBA, acomp, estaPromo);
		} else
			respuesta = new ServicioVivienda(cantCamaras, cantBA, acomp, estaPromo);
		return respuesta;
	}
}