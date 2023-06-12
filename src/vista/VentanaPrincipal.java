package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controlador.Controlador;
import interfaces.IAbonado;
import modelo.Servicio;
import modelo.Tecnico;

public class VentanaPrincipal extends JFrame
		implements KeyListener, MouseListener, ListSelectionListener, ActionListener {

	private ActionListener actionListener;
	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JPanel panelCentral;
	private JPanel panelC1;
	private JPanel panelC2;
	private JPanel panelC3;
	private JLabel lblAccionesAbonado;
	private JPanel panelAccionesAbonado;
	private JButton btnPagaFactura;
	private JPanel panelPagaFactura;
	private JButton btnContrataNServicio;
	private JPanel panelContrataNServicio;
	private JButton btnDarDeBajaS;
	private JPanel panelDarDeBajaS;
	private JPanel panelTecnicos;
	private JLabel lblAccionesTecnico;
	private JList<Tecnico> listTecnicos;
	private JScrollPane panelIzq;
	private JList<IAbonado> listAbonados;
	private JPanel panelSur;
	private JButton btnSolicitarTecnico;
	private JButton btnEliminarTecnico;
	private JButton btnAgregarTecnico;
	private DefaultListModel<IAbonado> modeloListaAbonado;
	private DefaultListModel<Tecnico> modeloListaTecnico;
	private DefaultListModel<String> modeloListaDomicilio;
	private JTextField nombre;
	private JLabel lblNewLabel_1;
	private JTextField dni;
	private JPanel panelTexto1;
	private JPanel panelDNI;
	private JLabel lblNewLabel;
	private JPanel panelNombre;
	private JRadioButton rdbtnJuridico;
	private JPanel panelTexto2;
	private JPanel panelBotonesTipo;
	private JPanel panelBotonesPago;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panelEliminarAbonado;
	private JRadioButton rdbtnFisico;
	private JRadioButton rdbtnCheque;
	private JRadioButton rdbtnEfectivo;
	private JRadioButton rdbtnCredito;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnEliminarAbonado;
	private JButton btnAgregarAbonado;
	private JPanel panelAgregarAbonado;
	private JPanel panelSolicitar;
	private JPanel panelEliminarTecnico;
	private JPanel panelAgregarTecnico;
	private Controlador controlador;
	private JScrollPane scrollPanelDomicilio;
	private JList<String> listDomicilio;
	private JPanel panelDer;
	private JPanel panel;
	private JScrollPane scrollPanelServicios;
	private JPanel Domicilio;
	private JPanel Servicio;
	private JTextArea textAreaServicio;
	private JButton btnIniciaJornada;
	private JPanel panelAdicionales;
	private JButton btnSimularMes;
	private JButton btnFinalizaJornada;
	private JPanel panelIniciaJornada;
	private JPanel panelSimularMes;
	private JPanel panelFinalizaJornada;
	private JPanel panelMuestraFactura;
	private JButton btnMuestraFactura;
	private JScrollPane scrollPane;
	private JTextArea textAreaConsola;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 575);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(1, 3, 0, 0));

		this.panel = new JPanel();
		this.panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Abonado",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelPrincipal.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));

		this.panelIzq = new JScrollPane();
		this.panel.add(this.panelIzq);

		this.listAbonados = new JList<IAbonado>();
		this.listAbonados.addListSelectionListener(this);
		this.panelIzq.setViewportView(this.listAbonados);
		this.modeloListaAbonado = new DefaultListModel<IAbonado>();
		this.listAbonados.setModel(modeloListaAbonado);
		this.listAbonados.setEnabled(false);

		this.panelCentral = new JPanel();
		this.panelPrincipal.add(this.panelCentral);
		this.panelCentral.setLayout(new GridLayout(3, 1, 0, 0));

		this.panelC1 = new JPanel();
		this.panelC1.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.panelCentral.add(this.panelC1);
		this.panelC1.setLayout(new BorderLayout(0, 0));

		this.lblAccionesAbonado = new JLabel("Acciones de abonado");
		this.panelC1.add(this.lblAccionesAbonado, BorderLayout.NORTH);

		this.panelAccionesAbonado = new JPanel();
		this.panelC1.add(this.panelAccionesAbonado, BorderLayout.CENTER);
		this.panelAccionesAbonado.setLayout(new GridLayout(3, 1, 0, 0));

		this.panelPagaFactura = new JPanel();
		this.panelAccionesAbonado.add(this.panelPagaFactura);

		this.btnPagaFactura = new JButton("Paga servicios");
		this.btnPagaFactura.setEnabled(false);
		this.panelPagaFactura.add(this.btnPagaFactura);

		this.panelContrataNServicio = new JPanel();
		this.panelAccionesAbonado.add(this.panelContrataNServicio);

		this.btnContrataNServicio = new JButton("Contrata nuevo servicio");
		this.btnContrataNServicio.setEnabled(false);
		this.btnContrataNServicio.addMouseListener(this);
		this.panelContrataNServicio.add(this.btnContrataNServicio);

		this.panelDarDeBajaS = new JPanel();
		this.panelAccionesAbonado.add(this.panelDarDeBajaS);

		this.btnDarDeBajaS = new JButton("Dar de baja un servicio");
		this.btnDarDeBajaS.setEnabled(false);
		this.panelDarDeBajaS.add(this.btnDarDeBajaS);

		this.panelC2 = new JPanel();
		this.panelC2
				.setBorder(new TitledBorder(null, "Crear Abonado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCentral.add(this.panelC2);
		this.panelC2.setLayout(new GridLayout(4, 2, 0, 0));

		this.panelNombre = new JPanel();
		this.panelC2.add(this.panelNombre);

		this.lblNewLabel = new JLabel("Nombre:");
		this.panelNombre.add(this.lblNewLabel);
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));

		this.panelTexto1 = new JPanel();
		this.panelC2.add(this.panelTexto1);

		this.nombre = new JTextField();
		this.nombre.setEnabled(false);
		this.nombre.addKeyListener(this);
		this.panelTexto1.add(this.nombre);
		this.nombre.setColumns(10);

		this.panelDNI = new JPanel();
		this.panelC2.add(this.panelDNI);

		this.lblNewLabel_1 = new JLabel("DNI:");
		this.panelDNI.add(this.lblNewLabel_1);
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));

		this.panelTexto2 = new JPanel();
		this.panelC2.add(this.panelTexto2);

		this.dni = new JTextField();
		this.dni.setEnabled(false);
		this.dni.addKeyListener(this);
		this.panelTexto2.add(this.dni);
		this.dni.setColumns(10);

		this.panelBotonesTipo = new JPanel();
		this.panelC2.add(this.panelBotonesTipo);
		this.panelBotonesTipo.setLayout(new GridLayout(2, 1, 0, 0));

		this.rdbtnJuridico = new JRadioButton("Juridico");
		this.rdbtnJuridico.addMouseListener(this);
		this.rdbtnJuridico.setEnabled(false);
		buttonGroup.add(this.rdbtnJuridico);
		this.panelBotonesTipo.add(this.rdbtnJuridico);

		this.rdbtnFisico = new JRadioButton("Fisico");
		this.rdbtnFisico.addMouseListener(this);
		this.rdbtnFisico.setEnabled(false);
		buttonGroup.add(this.rdbtnFisico);
		this.panelBotonesTipo.add(this.rdbtnFisico);

		this.panelBotonesPago = new JPanel();
		this.panelC2.add(this.panelBotonesPago);
		this.panelBotonesPago.setLayout(new GridLayout(0, 1, 0, 0));

		this.rdbtnCheque = new JRadioButton("Cheque");
		this.rdbtnCheque.addMouseListener(this);
		this.rdbtnCheque.setEnabled(false);
		buttonGroup_1.add(this.rdbtnCheque);
		this.panelBotonesPago.add(this.rdbtnCheque);

		this.rdbtnEfectivo = new JRadioButton("Efectivo");
		this.rdbtnEfectivo.addMouseListener(this);
		this.rdbtnEfectivo.setEnabled(false);
		buttonGroup_1.add(this.rdbtnEfectivo);
		this.panelBotonesPago.add(this.rdbtnEfectivo);

		this.rdbtnCredito = new JRadioButton("Credito");
		this.rdbtnCredito.addMouseListener(this);
		this.rdbtnCredito.setEnabled(false);
		buttonGroup_1.add(this.rdbtnCredito);
		this.panelBotonesPago.add(this.rdbtnCredito);

		this.panelEliminarAbonado = new JPanel();
		this.panelC2.add(this.panelEliminarAbonado);

		this.btnEliminarAbonado = new JButton("Eliminar");
		this.btnEliminarAbonado.setEnabled(false);
		this.panelEliminarAbonado.add(this.btnEliminarAbonado);

		this.panelAgregarAbonado = new JPanel();
		this.panelC2.add(this.panelAgregarAbonado);

		this.btnAgregarAbonado = new JButton("Agregar");
		this.btnAgregarAbonado.setEnabled(false);
		this.panelAgregarAbonado.add(this.btnAgregarAbonado);

		this.panelC3 = new JPanel();
		this.panelC3.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.panelCentral.add(this.panelC3);
		this.panelC3.setLayout(new BorderLayout(0, 0));

		this.panelTecnicos = new JPanel();
		this.panelC3.add(this.panelTecnicos, BorderLayout.SOUTH);
		this.panelTecnicos.setLayout(new GridLayout(0, 3, 0, 0));

		this.panelSolicitar = new JPanel();
		this.panelTecnicos.add(this.panelSolicitar);

		this.btnSolicitarTecnico = new JButton("Solicitar");
		this.btnSolicitarTecnico.setEnabled(false);
		this.panelSolicitar.add(this.btnSolicitarTecnico);

		this.panelEliminarTecnico = new JPanel();
		this.panelTecnicos.add(this.panelEliminarTecnico);

		this.btnEliminarTecnico = new JButton("Eliminar");
		this.btnEliminarTecnico.setActionCommand("EliminarTecnico");
		this.btnEliminarTecnico.setEnabled(false);
		this.panelEliminarTecnico.add(this.btnEliminarTecnico);
		this.btnEliminarTecnico.setHorizontalAlignment(SwingConstants.LEFT);

		this.panelAgregarTecnico = new JPanel();
		this.panelTecnicos.add(this.panelAgregarTecnico);

		this.btnAgregarTecnico = new JButton("Agregar");
		this.btnAgregarTecnico.setEnabled(false);
		this.btnAgregarTecnico.setActionCommand("AgregarNuevoTecnico");
		this.panelAgregarTecnico.add(this.btnAgregarTecnico);
		this.btnAgregarTecnico.setHorizontalAlignment(SwingConstants.RIGHT);

		this.lblAccionesTecnico = new JLabel("Acciones de tecnico");
		this.panelC3.add(this.lblAccionesTecnico, BorderLayout.NORTH);

		this.listTecnicos = new JList<Tecnico>();
		this.listTecnicos.setEnabled(false);
		this.panelC3.add(this.listTecnicos, BorderLayout.CENTER);

		this.panelSur = new JPanel();
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		this.panelSur.setLayout(new GridLayout(0, 2, 0, 0));

		this.scrollPane = new JScrollPane();
		this.panelSur.add(this.scrollPane);

		this.textAreaConsola = new JTextArea();
		this.textAreaConsola.setEditable(false);
		this.scrollPane.setViewportView(this.textAreaConsola);
		this.panelSur.setPreferredSize(new Dimension(50, 40));

		this.panelAdicionales = new JPanel();
		this.panelSur.add(this.panelAdicionales);
		this.panelAdicionales.setLayout(new GridLayout(0, 3, 0, 0));

		this.panelIniciaJornada = new JPanel();
		this.panelIniciaJornada.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		this.panelAdicionales.add(this.panelIniciaJornada);

		this.btnIniciaJornada = new JButton("Inicia jornada");
		this.btnIniciaJornada.addActionListener(this);
		this.btnIniciaJornada.setActionCommand("Inicia jornada");
		this.panelIniciaJornada.add(this.btnIniciaJornada);

		this.panelSimularMes = new JPanel();
		this.panelSimularMes.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.panelAdicionales.add(this.panelSimularMes);

		this.btnSimularMes = new JButton("Simular mes");
		this.btnSimularMes.setEnabled(false);
		this.btnSimularMes.addActionListener(this);
		this.panelSimularMes.add(this.btnSimularMes);

		this.panelFinalizaJornada = new JPanel();
		this.panelFinalizaJornada.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		this.panelAdicionales.add(this.panelFinalizaJornada);

		this.btnFinalizaJornada = new JButton("Finaliza jornada");
		this.btnFinalizaJornada.addActionListener(this);
		this.btnFinalizaJornada.setActionCommand("Finalizar jornada");
		this.btnFinalizaJornada.setEnabled(false);
		this.panelFinalizaJornada.add(this.btnFinalizaJornada);

		this.modeloListaAbonado = new DefaultListModel<IAbonado>();
		this.modeloListaTecnico = new DefaultListModel<Tecnico>();
		this.listTecnicos.setModel(modeloListaTecnico);
		this.listAbonados.setModel(modeloListaAbonado);

		this.panelMuestraFactura = new JPanel();
		this.panel.add(this.panelMuestraFactura, BorderLayout.SOUTH);

		this.btnMuestraFactura = new JButton("Mostrar facturas");
		this.panelMuestraFactura.add(this.btnMuestraFactura);
		this.listTecnicos.addListSelectionListener(this);
		this.btnMuestraFactura.setEnabled(false);

		this.panelDer = new JPanel();
		this.panelPrincipal.add(this.panelDer);
		this.panelDer.setLayout(new GridLayout(2, 1, 0, 0));

		this.Domicilio = new JPanel();
		this.Domicilio.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Domicilio",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelDer.add(this.Domicilio);
		this.Domicilio.setLayout(new BorderLayout(0, 0));

		this.scrollPanelDomicilio = new JScrollPane();
		this.Domicilio.add(this.scrollPanelDomicilio);

		this.listDomicilio = new JList<String>();
		this.listDomicilio.setEnabled(false);
		this.scrollPanelDomicilio.setViewportView(this.listDomicilio);
		this.modeloListaDomicilio = new DefaultListModel<String>();
		this.listDomicilio.setModel(modeloListaDomicilio);
		this.listDomicilio.addListSelectionListener(this);

		this.Servicio = new JPanel();
		this.Servicio.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Servicio",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelDer.add(this.Servicio);
		this.Servicio.setLayout(new BorderLayout(0, 0));

		this.scrollPanelServicios = new JScrollPane();
		this.Servicio.add(this.scrollPanelServicios);

		this.textAreaServicio = new JTextArea();
		this.textAreaServicio.setEnabled(false);
		this.scrollPanelServicios.setViewportView(this.textAreaServicio);
		this.textAreaServicio.setEditable(false);

		this.setVisible(true);

	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		String nombre = this.nombre.getText();
		String dni = this.dni.getText();
		boolean condicion = !(nombre.equals("") || nombre.equals(null)) && !(dni.equals("") || dni.equals(null));
		if (!condicion) {
			this.rdbtnCheque.setEnabled(condicion);
			this.rdbtnEfectivo.setEnabled(condicion);
			this.rdbtnCredito.setEnabled(condicion);
			this.btnAgregarAbonado.setEnabled(condicion);
		}
		this.rdbtnFisico.setEnabled(condicion);
		this.rdbtnJuridico.setEnabled(condicion);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == listDomicilio && e.getClickCount() == 2) {
			System.out.println("hola");
			this.abreFacturas();
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		boolean condicion1 = (rdbtnJuridico.isSelected() || rdbtnFisico.isSelected())
				&& (rdbtnJuridico.isEnabled() && rdbtnFisico.isEnabled());
		this.rdbtnCheque.setEnabled(condicion1);
		this.rdbtnEfectivo.setEnabled(condicion1);
		this.rdbtnCredito.setEnabled(condicion1);
		boolean condicion2 = rdbtnCheque.isSelected() || rdbtnCredito.isSelected() || rdbtnEfectivo.isSelected();
		this.btnAgregarAbonado.setEnabled(condicion2);

	}

	public void valueChanged(ListSelectionEvent e) {

		if (e.getSource() == this.listAbonados) {
			if (this.listAbonados.getSelectedValue() != null) {
				this.actualizaListaDomicilio();
				this.listDomicilio.clearSelection();
				this.textAreaServicio.setText(null);
				this.btnMuestraFactura.setEnabled(true);
			}
		}
		if (e.getSource() == this.listDomicilio) {
			if (this.listDomicilio.getSelectedValue() != null && this.listAbonados.getSelectedValue() != null)
				this.actualizaServicios();
		}

		if (e.getSource() == this.listTecnicos) {
			boolean condicion5 = !this.listTecnicos.isSelectionEmpty();
			this.btnEliminarTecnico.setEnabled(condicion5);
		}

		boolean condicion3 = !this.listAbonados.isSelectionEmpty();
		this.btnContrataNServicio.setEnabled(condicion3);
		this.btnEliminarAbonado.setEnabled(condicion3);
		boolean condicion4 = !this.listDomicilio.isSelectionEmpty();
		this.btnDarDeBajaS.setEnabled(condicion3 && condicion4);
		this.btnPagaFactura.setEnabled(condicion3 || this.listDomicilio.isSelectionEmpty());
		boolean condicion6 = this.modeloListaTecnico.size() > 0;
		boolean condicion7 = this.modeloListaDomicilio.size() > 0;
		this.btnSolicitarTecnico.setEnabled(condicion3 && condicion6 && condicion7);

	}

	public void setActionListener(ActionListener actionListener) {
		this.btnPagaFactura.addActionListener(actionListener);
		this.btnDarDeBajaS.addActionListener(actionListener);
		this.btnContrataNServicio.addActionListener(actionListener);
		this.btnAgregarAbonado.addActionListener(actionListener);
		this.btnAgregarTecnico.addActionListener(actionListener);
		this.btnEliminarAbonado.addActionListener(actionListener);
		this.btnEliminarTecnico.addActionListener(actionListener);
		this.btnSolicitarTecnico.addActionListener(actionListener);
		this.btnIniciaJornada.addActionListener(actionListener);
		this.btnSimularMes.addActionListener(actionListener);
		this.btnFinalizaJornada.addActionListener(actionListener);
		this.btnMuestraFactura.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public String getNombre() {
		return this.nombre.getText();
	}

	public String getDNI() {
		return this.dni.getText();
	}

	public String getTipo() {
		if (this.rdbtnJuridico.isSelected()) {
			return "Juridico";
		} else
			return "Fisico";
	}

	public String getPago() {
		if (this.rdbtnCheque.isSelected()) {
			return "Cheque";
		} else if (this.rdbtnCredito.isSelected()) {
			return "Credito";
		} else
			return "Efectivo";
	}

	public void actualizaListaAbonado() {
		Iterator<IAbonado> it = this.controlador.getAbonados().iterator();

		this.modeloListaAbonado.clear();
		while (it.hasNext()) {
			this.modeloListaAbonado.addElement(it.next());
		}
		this.repaint();
	}

	public void actualizaListaDomicilio() {
		Iterator<String> it = this.controlador.getDomicilios().iterator();
		this.modeloListaDomicilio.clear();
		while (it.hasNext()) {
			this.modeloListaDomicilio.addElement(it.next());
		}
		this.repaint();
	}

	public void actualizaTecnicos() {
		Iterator<Tecnico> it = this.controlador.getTecnicos().iterator();
		this.modeloListaTecnico.clear();
		while (it.hasNext()) {
			this.modeloListaTecnico.addElement(it.next());
		}
		this.repaint();
	}

	public void actualizaServicios() {

		Servicio servicio = this.controlador.getServicio(this.listDomicilio.getSelectedValue(),
				this.listAbonados.getSelectedValue());
		this.textAreaServicio.setText(servicio.toString());

	}

	public void abreFacturas() {
		this.controlador.abreFacturas();
	}

	public IAbonado getSelectedAbonado() {
		return this.listAbonados.getSelectedValue();
	}

	public String getSelectedDomicilio() {
		return this.listDomicilio.getSelectedValue();
	}

	public Tecnico getSelectedTecnico() {
		return this.listTecnicos.getSelectedValue();
	}

	public void limpiaTextAreaServicio() {
		this.textAreaServicio.setText(null);
	}

	public void escribirConsola(String string) {
		this.textAreaConsola.append(string + "\n");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Inicia jornada")) {
			this.btnIniciaJornada.setEnabled(false);
			this.nombre.setEnabled(true);
			this.dni.setEnabled(true);
			this.btnFinalizaJornada.setEnabled(true);
			this.btnSimularMes.setEnabled(true);
			this.btnAgregarTecnico.setEnabled(true);
			this.btnSolicitarTecnico.setEnabled(false);
			this.btnMuestraFactura.setEnabled(false);
			this.listAbonados.setEnabled(true);
			this.listDomicilio.setEnabled(true);
			this.listTecnicos.setEnabled(true);
			this.textAreaServicio.setEnabled(true);
			this.textAreaConsola.setText(null);
			this.textAreaConsola.setText("Se inicio la jornada\n");
		} else if (e.getActionCommand().equalsIgnoreCase("Finalizar jornada")) {
			this.btnIniciaJornada.setEnabled(true);
			this.nombre.setEnabled(false);
			this.dni.setEnabled(false);
			this.btnFinalizaJornada.setEnabled(false);
			this.btnSimularMes.setEnabled(false);
			this.btnAgregarTecnico.setEnabled(false);
			this.btnSolicitarTecnico.setEnabled(false);
			this.btnEliminarTecnico.setEnabled(false);
			this.btnMuestraFactura.setEnabled(false);
			this.listAbonados.clearSelection();
			this.listDomicilio.clearSelection();
			this.listAbonados.setEnabled(false);
			this.listDomicilio.setEnabled(false);
			this.listTecnicos.setEnabled(false);
			this.textAreaServicio.setEnabled(false);
			this.btnPagaFactura.setEnabled(false);
			this.textAreaConsola.setText("Se finalizo la jornada\n");
		}
	}
}
