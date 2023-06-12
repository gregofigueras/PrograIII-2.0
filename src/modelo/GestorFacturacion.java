package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import interfaces.IAbonado;

public class GestorFacturacion {
	private IAbonado abonadoActual;
	private Factura factura;
	private ArrayList<IAbonado> listaAbonados;

	public GestorFacturacion(ArrayList<IAbonado> listaAbonados) {
		super();
		this.listaAbonados = listaAbonados;

	}

	public void Facturacion() {
		Iterator<IAbonado> it = listaAbonados.iterator();
		while (it.hasNext()) {
			abonadoActual = it.next();
			factura = new Factura(abonadoActual);
			factura.getFactura();
			abonadoActual.AgregarFactura(factura);
		}
	}

	public GestorFacturacion() {
		super();
	}

	public IAbonado getAbonadoActual() {
		return abonadoActual;
	}

	public void setAbonadoActual(IAbonado abonadoActual) {
		this.abonadoActual = abonadoActual;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public ArrayList<IAbonado> getListaAbonados() {
		return listaAbonados;
	}

	public void setListaAbonados(ArrayList<IAbonado> listaAbonados) {
		this.listaAbonados = listaAbonados;
	}

}
