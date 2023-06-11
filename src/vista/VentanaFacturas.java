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
import javax.swing.JButton;

public class VentanaFacturas extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;
	private DefaultListModel<Factura> modeloListaFactura;
	private JTextArea textAreaDomicilio;
	private JList<Factura> listFacturas;
	private JPanel panelSur;
	private JButton btnCerrar;

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
		
		this.listFacturas = new JList<Factura>();
		this.contentPane.add(this.listFacturas, BorderLayout.CENTER);
		this.modeloListaFactura = new DefaultListModel<Factura>();
		this.listFacturas.setModel(modeloListaFactura);
		
		this.panelSur = new JPanel();
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		
		this.btnCerrar = new JButton("Cerrar");
		this.btnCerrar.setActionCommand("Cerrar");
		this.panelSur.add(this.btnCerrar);

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
