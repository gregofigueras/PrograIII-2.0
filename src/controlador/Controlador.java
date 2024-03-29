package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JOptionPane;

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

/**
 * @author 
 * Clase que representa el controlador del patron Model View Controller
 *
 */
public class Controlador implements ActionListener, Observer {
	private Sistema sistema;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaAgregaServicio ventanaAgregaServicio;
	private VentanaAgregaTecnico ventanaAgregaTecnico;
	private VentanaFacturas ventanaFacturas;

	/**
	 * Constructor de la clase
	 */
	public Controlador() {
		super();
		this.sistema = Sistema.getInstance();
		this.ventanaPrincipal = new VentanaPrincipal();
		this.ventanaPrincipal.setActionListener(this);
		this.ventanaPrincipal.setControlador(this);
		this.ventanaPrincipal.setControlador(this);

		this.ventanaAgregaTecnico = new VentanaAgregaTecnico();
		this.ventanaAgregaServicio = new VentanaAgregaServicio();
		this.ventanaAgregaServicio.setActionListener(this);
		this.ventanaAgregaTecnico.setActionListener(this);

		this.ventanaFacturas = new VentanaFacturas();
		this.ventanaFacturas.setControlador(this);

		this.sistema.getTecnicoFactory().addObserver(this);
	}

	/**
	 *Metodo que indica qué debe hacer el modelo según la acción que selecciono el usuario en la interfaz gráfica
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Contrata nuevo servicio")) {// Crea popup
			boolean condicion1;
			IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();
			if (abonado.getTipo().equals("Fisico")) {
				if (abonado.getEstado().equals("Moroso")) {
					condicion1 = false;
					this.ventanaPrincipal.escribirConsola("No puede agregar servicio por ser moroso");
					;

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
			this.ventanaPrincipal.escribirConsola("Servicio agregado correctamente");

		} else if (e.getActionCommand().equalsIgnoreCase("Agregar")) {
			String tipo = this.ventanaPrincipal.getTipo();
			String pago = this.ventanaPrincipal.getPago();
			String nombre = this.ventanaPrincipal.getNombre();
			String DNI = this.ventanaPrincipal.getDNI();
			sistema.creaAbonado(tipo, pago, nombre, DNI);
			this.ventanaPrincipal.actualizaListaAbonado();
			this.ventanaPrincipal.limpiaAbonado();
		} else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
			this.sistema.eliminaAbonado(this.ventanaPrincipal.getSelectedAbonado());
			this.ventanaPrincipal.actualizaListaAbonado();

		} else if (e.getActionCommand().equalsIgnoreCase("Dar de baja un servicio")) {
			IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();
			String domicilio = this.ventanaPrincipal.getSelectedDomicilio();

			if (abonado.getTipo().equalsIgnoreCase("Fisico") && abonado.getEstado().equalsIgnoreCase("Moroso")) {
				this.ventanaPrincipal.escribirConsola("No se puede agregar un servicio por ser moroso");
			} else {
				try {
					abonado.quitaServicio(domicilio);
				} catch (DomicilioInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.ventanaPrincipal.limpiaTextAreaServicio();
				this.ventanaAgregaServicio.limpia();
				this.ventanaPrincipal.actualizaListaDomicilio();
			}

		} else if (e.getActionCommand().equalsIgnoreCase("Paga Servicios")) {
			IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();
			if (abonado.getFactura().size() == 0) {
				JOptionPane.showMessageDialog(ventanaPrincipal, "El abonado no puede pagar aun");
			} else {
				abonado.pagarFactura();
				this.ventanaPrincipal.escribirConsola(
						"El abonado " + abonado.getNombre() + " pago un total de $" + abonado.getTotalPagado());
			}

		} else if (e.getActionCommand().equalsIgnoreCase("Simular mes")) {
			sistema.simularMes();

		} else if (e.getActionCommand().equalsIgnoreCase("Finalizar jornada")) {
			sistema.sumarDia();
			sistema.finalizaJornada();

		} else if (e.getActionCommand().equalsIgnoreCase("Inicia jornada")) {
			sistema.iniciaJornada();

		} else if (e.getActionCommand().equalsIgnoreCase("Solicitar")) {
			IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();
			this.ventanaPrincipal.escribirConsola("El usuario " + abonado.getNombre() + "  esta siendo atendido");
			Thread thread = new Thread(abonado);
			thread.start();

		} else if (e.getActionCommand().equalsIgnoreCase("EliminarTecnico")) {
			Tecnico tecnico = this.ventanaPrincipal.getSelectedTecnico();
			this.sistema.eliminaTecnico(tecnico);
			this.ventanaPrincipal.actualizaTecnicos();

		} else if (e.getActionCommand().equalsIgnoreCase("agregarTecnico")) { // Cierra el popup de facturas
			String nombre = this.ventanaAgregaTecnico.getNombreTecnico();
			String ID = this.ventanaAgregaTecnico.getIDTecnico();
			this.ventanaAgregaTecnico.limpia();
			sistema.agregaTecnico(nombre, ID);
			this.ventanaAgregaTecnico.dispose();
			this.ventanaAgregaTecnico.limpia();
			this.ventanaPrincipal.actualizaTecnicos();

		} else if (e.getActionCommand().equalsIgnoreCase("AgregarNuevoTecnico")) { // Abre el popup de facturas
			this.ventanaAgregaTecnico.setVisible(true);

		} else if (e.getActionCommand().equalsIgnoreCase("Mostrar facturas")) { // Abre popup de facturas
			if (this.ventanaPrincipal.getSelectedAbonado().getFactura().size() != 0) {
				this.ventanaFacturas.ActualizaListaFacturas();
				this.ventanaFacturas.setVisible(true);
			} else
				JOptionPane.showMessageDialog(ventanaPrincipal, "El abonado no tiene facturas para mostrar");
		} else if (e.getActionCommand().equalsIgnoreCase("Cerrar")) { // Cierra el popup de facturas
			this.ventanaAgregaTecnico.setVisible(false);
			this.ventanaAgregaTecnico.limpia();
		}
	}

	/**
	 * Método que devuelve los técnicos que tiene el sistema
	 * @return ArrayList de técnicos
	 */
	public ArrayList<Tecnico> getTecnicos() {
		return this.sistema.getTecnicos();
	}

	/**
	 * Método que devuelve los abonados que tiene el sistema
	 * @return ArrayList de abonados
	 */
	public ArrayList<IAbonado> getAbonados() {
		return this.sistema.getAbonados();
	}

	/**
	 * Método que los domicilios de cada servicio de un único abonado seleccionado en la interfaz gráfica
	 * @return Set de String con cada domicilio
	 */
	public Set<String> getDomicilios() {
		IAbonado abonado = this.ventanaPrincipal.getSelectedAbonado();

		HashMap<String, Servicio> map = abonado.getServicios();

		Set<String> set = map.keySet();
		return set;
	}

	/**
	 * Método que devuelve un único servicio de un abonado seleccionado, dado un domicilio
	 * @param domicilio El domicilio seleccionado en la interfaz gráfica<b>
	 * <b>Pre:</b> Debe ser distinto de null, no vacío y pertenecer al HashMap<String,Servicio> del abonado
	 * @param abonado El abonado seleccionado en la interfaz gráfica<br>
	 * <b>Pre:</b> Debe ser distinto de null
	 * @return Variable de tipo Servicio
	 */
	public Servicio getServicio(String domicilio, IAbonado abonado) {
		return abonado.getServicio(domicilio);
	}

	/**
	 *Método perteneciente el patrón Observer-Observable<br>
	 *<b>Pre:</b> El observable debe ser distinto de null<br>
	 *<b>Pre:</b> El atributo ventanaPrincipal de tipo VentanaPrincipal debe ser distinto de null<br>
	 *<b>Post:</b> Actualiza la lista de técnicos de la interfaz gráfica
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.ventanaPrincipal.actualizaTecnicos();
	}

	/**
	 * Método que hace visible la ventana que muestra las facturas<br>
	 * <b>Pre:</b> El atributo ventanaFacturas de tipo VentanaFacturas debe ser distinto de null<br>
	 * <b>Post:</b> La ventana de facturas es visible 
	 */
	public void abreFacturas() {
		this.ventanaFacturas.setVisible(true);
	}

	/**
	 * Método que devuelve una lista de facturas de un abonado seleccionado en la ventana principal<br>
	 * <b>Pre: </b> El atributo ventanaPrincipal de tipo VentanaPrincipal debe ser distinto de null
	 * @return ArrayList de Factura
	 */
	public ArrayList<Factura> getFacturas() {
		return this.ventanaPrincipal.getSelectedAbonado().getFactura();
	}

	/**
	 * Método que devuelve un domicilio que fue seleccionado en la ventana principal
	 * <b>Pre: </b> El atributo ventanaPrincipal de tipo VentanaPrincipal debe ser distinto de null
	 * @return String con el domicilio
	 */
	public String getDomicilioValue() {
		return this.ventanaPrincipal.getSelectedDomicilio();
	}

}
