package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import factory.ServicioFactory;
import interfaces.IAbonado;
import modelo.Servicio;
import modelo.Sistema;
import vista.VentanaAgregaServicio;
import vista.VentanaPrincipal;

public class Controlador implements ActionListener {
	private Sistema sistema;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaAgregaServicio ventanaAgregaServicio;

	public Controlador() {
		super();
		this.sistema = Sistema.getInstance();
		this.ventanaPrincipal = new VentanaPrincipal();
		this.ventanaAgregaServicio = new VentanaAgregaServicio();
		this.ventanaPrincipal.setActionListener(this);
		this.ventanaPrincipal.setControlador(this);
		this.ventanaAgregaServicio.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Contrata nuevo servicio")) {// Crea popup
			this.ventanaAgregaServicio.setVisible(true);

		} else if (e.getActionCommand().equalsIgnoreCase("Agregar servicio")) {// Cierra el popup
			IAbonado abonado = this.ventanaPrincipal.getSelected();
			String tipo = this.ventanaAgregaServicio.getTipoServicio();
			int cantBA = this.ventanaAgregaServicio.getCantBa();
			int cantCamaras = this.ventanaAgregaServicio.getCantCamaras();
			boolean acomp = this.ventanaAgregaServicio.getAcom();
			String promo = this.ventanaAgregaServicio.getPromo();
			String domicilio = this.ventanaAgregaServicio.getDomicilio();
			ServicioFactory.agregaServicio(abonado, domicilio, tipo, promo, cantBA, cantCamaras, acomp);
			this.ventanaAgregaServicio.dispose();
			this.ventanaAgregaServicio.limpia();
			this.ventanaPrincipal.actualizaListaServicio();

		} else if (e.getActionCommand().equalsIgnoreCase("Agregar")) {
			String tipo = this.ventanaPrincipal.getTipo();
			String pago = this.ventanaPrincipal.getPago();
			String nombre = this.ventanaPrincipal.getNombre();
			String DNI = this.ventanaPrincipal.getDNI();
			sistema.creaAbonado(tipo, pago, nombre, DNI);
			this.ventanaPrincipal.actualizaListaAbonado();

		} else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
			this.sistema.eliminaAbonado(this.ventanaPrincipal.getSelected());
			this.ventanaPrincipal.actualizaListaAbonado();

		} else if (e.getActionCommand().equalsIgnoreCase("Dar de baja un servicio")) {
			IAbonado abonado = this.ventanaPrincipal.getSelected();
			// Servicio servicio = this.ventanaPrincipal.getSelected();
			// abonado.quitaServicio(servicio); //REVISAR EL QUITA SERVICIOS
			this.ventanaAgregaServicio.dispose();
			this.ventanaAgregaServicio.limpia();
			this.ventanaPrincipal.actualizaListaServicio();

		} else if (e.getActionCommand().equalsIgnoreCase("Paga Servicio")) {
			IAbonado abonado = this.ventanaPrincipal.getSelected();
			abonado.PagarFactura();
		}
	}

	public ArrayList<IAbonado> getAbonados() {
		return this.sistema.getAbonados();
	}

	public List<Servicio> getServicio() {
		IAbonado abonado = this.ventanaPrincipal.getSelected();
		abonado.imprimeServicios();
		HashMap<String, Servicio> map = abonado.getServicio();
		System.out.println(map == null);
		for (Map.Entry<String, Servicio> entry : map.entrySet()) {
			String clave = entry.getKey();
			Servicio servicio1 = entry.getValue();
			System.out.println("Clave: " + clave + ", Valor: " + servicio1);
		}
		List<Servicio> list = new ArrayList<Servicio>(map.values()); // cambiar a que imprima hashmap para poder borrar?
		return list;
	}
}
