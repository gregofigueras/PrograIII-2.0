package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import interfaces.IAbonado;

public class GestorFacturacion {
	private IAbonado abonadoActual;
	private ArrayList<IAbonado> listaAbonados;
	private Factura factura;

	public GestorFacturacion(ArrayList<IAbonado> listaAbonados) {
		super();
		this.listaAbonados = listaAbonados;
	}

	public void Facturacion () {
		Iterator<IAbonado> it=listaAbonados.iterator();
		while (it.hasNext()) {
		abonadoActual=it.next();
		factura= new Factura (abonadoActual);
		factura.getFactura();
		abonadoActual.AgregarFactura(factura);
		}
	}
	
}
