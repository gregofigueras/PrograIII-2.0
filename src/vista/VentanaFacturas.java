package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.Factura;

public class VentanaFacturas extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;
	private DefaultListModel<Factura> modeloListaFactura;
	private JTextArea textAreaDomicilio;
	private JScrollBar scrollBar;
	private JList<Factura> listFacturas;

	public VentanaFacturas() {
		setTitle("Facturas - Domicilio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new TitledBorder(null, "Facturas", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.textAreaDomicilio = new JTextArea();
		this.contentPane.add(this.textAreaDomicilio, BorderLayout.NORTH);
		
		this.scrollBar = new JScrollBar();
		this.contentPane.add(this.scrollBar, BorderLayout.EAST);
		
		this.listFacturas = new JList<Factura>();
		this.contentPane.add(this.listFacturas, BorderLayout.CENTER);
		this.modeloListaFactura = new DefaultListModel<Factura>();
		this.listFacturas.setModel(modeloListaFactura);

		this.setVisible(false);

	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void ActualizaListaFacturas() {
		String domicilio = this.controlador.getDomicilioValue();
		this.textAreaDomicilio.setText(domicilio);
		ArrayList<Factura> listaFacturas = controlador.getFacturas();
		Iterator<Factura> it = listaFacturas.iterator();
		while (it.hasNext()) {
			this.modeloListaFactura.addElement(it.next());
		}
		this.listFacturas.repaint();
	}

	public void limpia() {
		this.textAreaDomicilio.setText(null);
		this.modeloListaFactura.clear();
		this.listFacturas.repaint();
	}

}
