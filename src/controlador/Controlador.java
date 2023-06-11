package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import excepciones.DomicilioInvalidoException;
import factory.ServicioFactory;
import interfaces.IAbonado;
import modelo.Factura;
import modelo.Servicio;
import modelo.Sistema;
import modelo.Tecnico;
import vista.VentanaAgregaServicio;
import vista.VentanaAgregaTecnico;
import vista.VentanaFacturas;
import vista.VentanaPrincipal;

public class Controlador implements ActionListener, Observer {
	private Sistema sistema;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaAgregaServicio ventanaAgregaServicio;
	private VentanaAgregaTecnico ventanaAgregaTecnico;
	private VentanaFacturas ventanaFacturas;

	public Controlador() {
		super();
		this.sistema = Sistema.getInstance();
		this.ventanaPrincipal = new VentanaPrincipal();
		this.ventanaAgregaTecnico = new VentanaAgregaTecnico();
		this.ventanaAgregaServicio = new VentanaAgregaServicio();
		this.ventanaFacturas = new VentanaFacturas();
		this.ventanaPrincipal.setActionListener(this);
		this.ventanaPrincipal.setControlador(this);
		this.ventanaAgregaServicio.setActionListener(this);
		this.ventanaAgregaTecnico.setActionListener(this);
		this.sistema.getTecnicoFactory().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Contrata nuevo servicio")) {// Crea popup
			boolean condicion1;
			IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();
			if (abonado.getTipo().equals("Fisico")) {
				if (abonado.getEstado().equals("Moroso")) {
					condicion1 = false;
					this.ventanaPrincipal.Moroso();

				} else
					condicion1 = true;
			} else
				condicion1 = true;
			if (condicion1) {
				this.ventanaAgregaServicio.setVisible(true);
			}

		} else if (e.getActionCommand().equalsIgnoreCase("Agregar servicio")) {// Cierra el popup
			IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();
			String tipo = this.ventanaAgregaServicio.getTipoServicio();
			int cantBA = this.ventanaAgregaServicio.getCantBa();
			int cantCamaras = this.ventanaAgregaServicio.getCantCamaras();
			boolean acomp = this.ventanaAgregaServicio.getAcom();
			String promo = this.ventanaAgregaServicio.getPromo();
			String domicilio = this.ventanaAgregaServicio.getDomicilio();

			ServicioFactory.agregaServicio(abonado, domicilio, tipo, promo, cantBA, cantCamaras, acomp);
			this.ventanaAgregaServicio.dispose();
			this.ventanaAgregaServicio.limpia();
			this.ventanaPrincipal.actualizaListaDomicilio();

		} else if (e.getActionCommand().equalsIgnoreCase("Agregar")) {
			String tipo = this.ventanaPrincipal.getTipo();
			String pago = this.ventanaPrincipal.getPago();
			String nombre = this.ventanaPrincipal.getNombre();
			String DNI = this.ventanaPrincipal.getDNI();
			sistema.creaAbonado(tipo, pago, nombre, DNI);
			this.ventanaPrincipal.actualizaListaAbonado();

		} else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
			this.sistema.eliminaAbonado(this.ventanaPrincipal.getSelectedAbonado());
			this.ventanaPrincipal.actualizaListaAbonado();

		} else if (e.getActionCommand().equalsIgnoreCase("Dar de baja un servicio")) {
			IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();
			String domicilio = this.ventanaPrincipal.getSelectedDomicilio();
			try {
				abonado.quitaServicio(domicilio);
			} catch (DomicilioInvalidoException e1) {
				e1.printStackTrace();
			}
			this.ventanaPrincipal.limpiaTextAreaServicio();
			this.ventanaAgregaServicio.limpia();
			this.ventanaPrincipal.actualizaListaDomicilio();

		} else if (e.getActionCommand().equalsIgnoreCase("Paga Servicio")) {
			IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();
			abonado.PagarFactura();

		} else if (e.getActionCommand().equalsIgnoreCase("Simular mes")) {
			sistema.simularMes();

		} else if (e.getActionCommand().equalsIgnoreCase("Finalizar jornada")) {
			sistema.sumarDia();

		} else if (e.getActionCommand().equalsIgnoreCase("Solicitar")) {
			IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();
			Thread thread = new Thread(abonado);
			thread.start();

		} else if (e.getActionCommand().equalsIgnoreCase("EliminarTecnico")) {
			Tecnico tecnico = this.ventanaPrincipal.getSelectedTecnico();
			this.sistema.eliminaTecnico(tecnico);
			this.ventanaPrincipal.actualizaTecnicos();

		} else if (e.getActionCommand().equalsIgnoreCase("agregarTecnico")) { // cierra popup
			String nombre = this.ventanaAgregaTecnico.getNombreTecnico();
			String ID = this.ventanaAgregaTecnico.getIDTecnico();
			this.ventanaAgregaTecnico.limpia();
			sistema.agregaTecnico(nombre, ID);
			this.ventanaAgregaTecnico.dispose();
			this.ventanaAgregaTecnico.limpia();
			this.ventanaPrincipal.actualizaTecnicos();

		} else if (e.getActionCommand().equalsIgnoreCase("AgregarNuevoTecnico")) { // abre popup
			this.ventanaAgregaTecnico.setVisible(true);

		}
	}

	public ArrayList<Tecnico> getTecnicos() {
		return this.sistema.getTecnicos();
	}

	public ArrayList<IAbonado> getAbonados() {
		return this.sistema.getAbonados();
	}

	public Set<String> getDomicilios() {
		IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();

		HashMap<String, Servicio> map = abonado.getServicio();

		Set<String> set = map.keySet();
		return set;
	}

	public Servicio getServicio(String domicilio, IAbonado abonado) {
		return abonado.getServicio(domicilio);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("actualizanding");
		this.ventanaPrincipal.actualizaTecnicos();
	}

	public void abreFacturas() {
		this.ventanaFacturas.setVisible(true);
	}

	public ArrayList<Factura> getFacturas() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDomicilioValue() {
		this.ventanaPrincipal.getSelectedDomicilio();
		return null;
	}

}
