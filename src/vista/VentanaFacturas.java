package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Factura;

public class VentanaFacturas extends JFrame {

	private JPanel contentPane;
	private JScrollBar scrollBar;
	private Controlador controlador;
	private Object modeloListaFactura;
	private JTextArea textAreaDomicilio;
	private JTextArea textAreaFacturas;

	public VentanaFacturas() {
		setTitle("Facturas - Domicilio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.scrollBar = new JScrollBar();
		this.contentPane.add(this.scrollBar, BorderLayout.EAST);

		this.textAreaDomicilio = new JTextArea();
		this.contentPane.add(this.textAreaDomicilio, BorderLayout.NORTH);

		this.textAreaFacturas = new JTextArea();
		this.contentPane.add(this.textAreaFacturas, BorderLayout.CENTER);

		this.setVisible(false);

	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void ActualizaListaFacturas() {
		String domicilio = this.controlador.getDomicilioValue();
		this.textAreaDomicilio.setText(domicilio);
		ArrayList<Factura> listaFacturas = controlador.getFacturas();
		for (Factura elemento : listaFacturas)
			this.textAreaFacturas.append(elemento.toString());
	}

	public void limpia() {
		this.textAreaDomicilio.setText(null);
		this.textAreaFacturas.setText(null);
	}

}
