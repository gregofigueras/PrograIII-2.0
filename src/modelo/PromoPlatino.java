package modelo;

import interfaces.IPromocion;

/**
 * @author clase que representa la promocion dorada dentro del sistema
 *
 */
public class PromoPlatino implements IPromocion {

	/**
	 * aplica la pomocion dorada a un domicilio de tipo vivienda <b> <b> pre: </>
	 * costoBruto debe ser positivo <b> <b> post: </> retorna el costo bruto despues
	 * de la promocion
	 */
	@Override
	public double getPromoVivienda(double costoBruto) {
		assert costoBruto < 0 : "costo bruto no valido";
		return costoBruto * 0.7;
	}

	/**
	 * aplica la pomocion dorada a un domicionio de tipo comercio <b> <b> pre: </>
	 * costoBruto debe ser positivo <b> <b> post: </> retorna el costo bruto despues
	 * de la promocion
	 */
	@Override
	public double getPromoComercio(double costoBruto) {
		assert costoBruto < 0 : "costo bruto no valido";
		return costoBruto * 0.65;
	}

	@Override
	public String getPromoNombre() {
		return "Plateada";
	}

	public PromoPlatino() {
		super();
		// TODO Auto-generated constructor stub
	}

}
