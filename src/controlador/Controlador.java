package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.SistemaFactory;
import vista.VentanaAgregaServicio;
import vista.VentanaPrincipal;

public class Controlador implements ActionListener {
	private SistemaFactory sistema = SistemaFactory.getInstance();
	private static Controlador instance = null;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaAgregaServicio ventanaAgregaServicio;

	private Controlador(SistemaFactory sistema) {
		super();
		this.sistema = sistema;
		this.ventanaPrincipal = new VentanaPrincipal();
	}

	public static Controlador getInstance() {
		if (instance == null) {
			instance = new Controlador();
		}
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
