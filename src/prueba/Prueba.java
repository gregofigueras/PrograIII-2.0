package prueba;

import excepciones.DomicilioInvalidoException;
import excepciones.TipoAbonadoInvalidoException;
import excepciones.TipoPagoInvalidoException;
import interfaces.IAbonado;
import interfaces.IPromocion;
import modelo.AbonadoFactory;
import modelo.Factura;
import modelo.PromoDorada;
import modelo.PromoPlatino;
import modelo.Servicio;
import modelo.ServicioComercio;
import modelo.ServicioVivienda;

public class Prueba {
	public static void main(String[] args) {
		final IPromocion dorada= new PromoDorada();
		final IPromocion platino= new PromoPlatino();
		
		Servicio sC1= new ServicioComercio(2,1,true,null);
		Servicio sC2 = new ServicioComercio(15,1,false,platino);
		Servicio sC3 = new ServicioComercio(0,2,true, dorada);
		Servicio sV1= new ServicioVivienda(2,1,true,dorada);
		Servicio sV2= new ServicioVivienda(2,3,false,platino);
		Servicio sV3= new ServicioVivienda(6,3,false,dorada);
		
		
		IAbonado a1 = null;
		IAbonado a2 = null;
		IAbonado a3 = null;
		IAbonado a4 = null;
		
		try {
			a1 = AbonadoFactory.getAbonado("Fisico","Cheque","Gregorio","43509237");
			a2 = AbonadoFactory.getAbonado("Fisico", "Credito", "Nahuel", "43184902");
			a3 = AbonadoFactory.getAbonado("Juridico", "Efectivo", "Julieta", "43689912");
			a4 = AbonadoFactory.getAbonado("Juridico", "Credito", "Guido", "43459862");
		} catch (TipoAbonadoInvalidoException | TipoPagoInvalidoException e) {
			
			System.out.println(e.getMessage());
		} 
		
		a1.agregaServicio("Santiago del Estero 2200", sC1);
		a2.agregaServicio("jujuy 560", sC2);
		a3.agregaServicio("La quiaca", sV1);
		a4.agregaServicio("Chile 986", sV2);
		try {
			a1.quitaServicio("Santiago del Estero 2200");
		} catch (DomicilioInvalidoException e) {
			System.out.println(e.getMessage());
		}
		a4.agregaServicio("Francia 560", sV3);
		
		
		Factura f1= new Factura(a1);
		Factura f3= new Factura(a2);
		Factura f4= new Factura(a3);
		Factura f5= new Factura(a4);
		
		f1.getFactura();
		f3.getFactura();
		f4.getFactura();
		f5.getFactura();
		
		try {
			Factura f2= (Factura) f1.clone();
			f2.getFactura();
			f2.agregarServicio("Paso 2200", sC3);
			f2.getFactura();
		} catch (CloneNotSupportedException e) {
			e.getMessage();
		}
	}
}
