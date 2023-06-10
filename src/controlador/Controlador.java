package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import interfaces.IAbonado;
import modelo.SistemaFactory;
import vista.VentanaAgregaServicio;
import vista.VentanaPrincipal;

public class Controlador implements ActionListener {
	private SistemaFactory sistema;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaAgregaServicio ventanaAgregaServicio;

	public Controlador() {
		super();
		this.sistema = SistemaFactory.getInstance();
		this.ventanaPrincipal = new VentanaPrincipal();
		this.ventanaAgregaServicio = new VentanaAgregaServicio();
		this.ventanaPrincipal.setActionListener(this);
		this.ventanaPrincipal.setControlador(this);
		this.ventanaAgregaServicio.setActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Contrata nuevo servicio")) {//Crea popup
			this.ventanaAgregaServicio = new VentanaAgregaServicio();
		}
		else if (e.getActionCommand().equalsIgnoreCase("Agregar servicio")) {//Cierra el popup
			this.ventanaAgregaServicio.dispose();
			this.ventanaAgregaServicio = null;
		}
		else if (e.getActionCommand().equalsIgnoreCase("Agregar")) {
			String tipo = this.ventanaPrincipal.getTipo();
			String pago = this.ventanaPrincipal.getPago();
			String nombre = this.ventanaPrincipal.getNombre();
			String DNI = this.ventanaPrincipal.getDNI();
			sistema.creaAbonado(tipo, pago, nombre, DNI);
			this.ventanaPrincipal.actualizaLista();
		}
		else if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
			this.sistema.eliminaAbonado(this.ventanaPrincipal.getSelected());
			this.ventanaPrincipal.actualizaLista();
		}
	}
	
	public ArrayList<IAbonado> getAbonados(){
		return this.sistema.getAbonados();
	}
}
