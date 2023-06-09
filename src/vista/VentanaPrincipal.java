package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.Controlador;
import interfaces.IAbonado;
import modelo.Tecnico;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JPanel panelCentral;
	private JPanel panelDer;
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
	private JLabel lblAbonados;
	private JPanel panelSur;
	private JTextArea textAreaInfo;
	private JButton btnSolicitar;
	private JButton btnDarDeBaja;
	private JButton btnAgregar;
	private DefaultListModel<IAbonado> modeloListaAbonado;
	private DefaultListModel<Tecnico> modeloListaTecnico;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		this.panelIzq = new JScrollPane();
		this.panelPrincipal.add(this.panelIzq);
		
		this.listAbonados = new JList<IAbonado>();
		this.panelIzq.setViewportView(this.listAbonados);
		
		this.lblAbonados = new JLabel("Abonados");
		this.panelIzq.setColumnHeaderView(this.lblAbonados);
		
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
		
		this.btnPagaFactura = new JButton("Paga servicio");
		this.btnPagaFactura.addActionListener(Controlador.getInstance());
		this.panelPagaFactura.add(this.btnPagaFactura);
		
		this.panelContrataNServicio = new JPanel();
		this.panelAccionesAbonado.add(this.panelContrataNServicio);
		
		this.btnContrataNServicio = new JButton("Contrata nuevo servicio");
		this.btnContrataNServicio.addActionListener(Controlador.getInstance());
		this.panelContrataNServicio.add(this.btnContrataNServicio);
		
		this.panelDarDeBajaS = new JPanel();
		this.panelAccionesAbonado.add(this.panelDarDeBajaS);
		
		this.btnDarDeBajaS = new JButton("Dar de baja un servicio");
		this.btnDarDeBajaS.addActionListener(Controlador.getInstance());
		this.panelDarDeBajaS.add(this.btnDarDeBajaS);
		
		this.panelC2 = new JPanel();
		this.panelC2.setBorder(new TitledBorder(null, "Crear Abonado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		this.panelTexto2.add(this.dni);
		this.dni.setColumns(10);
		
		this.panelBotonesTipo = new JPanel();
		this.panelC2.add(this.panelBotonesTipo);
		this.panelBotonesTipo.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.rdbtnJuridico = new JRadioButton("Juridico");
		buttonGroup.add(this.rdbtnJuridico);
		this.panelBotonesTipo.add(this.rdbtnJuridico);
		
		this.rdbtnFisico = new JRadioButton("Fisico");
		buttonGroup.add(this.rdbtnFisico);
		this.panelBotonesTipo.add(this.rdbtnFisico);
		
		this.panelBotonesPago = new JPanel();
		this.panelC2.add(this.panelBotonesPago);
		this.panelBotonesPago.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.rdbtnCheque = new JRadioButton("Cheque");
		buttonGroup_1.add(this.rdbtnCheque);
		this.panelBotonesPago.add(this.rdbtnCheque);
		
		this.rdbtnEfectivo = new JRadioButton("Efectivo");
		buttonGroup_1.add(this.rdbtnEfectivo);
		this.panelBotonesPago.add(this.rdbtnEfectivo);
		
		this.rdbtnCredito = new JRadioButton("Credito");
		buttonGroup_1.add(this.rdbtnCredito);
		this.panelBotonesPago.add(this.rdbtnCredito);
		
		this.panelEliminarAbonado = new JPanel();
		this.panelC2.add(this.panelEliminarAbonado);
		
		this.btnEliminarAbonado = new JButton("Eliminar");
		this.panelEliminarAbonado.add(this.btnEliminarAbonado);
		
		this.panelAgregarAbonado = new JPanel();
		this.panelC2.add(this.panelAgregarAbonado);
		
		this.btnAgregarAbonado = new JButton("Agregar");
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
		
		this.btnSolicitar = new JButton("Solicitar");
		this.panelSolicitar.add(this.btnSolicitar);
		this.btnSolicitar.addActionListener(Controlador.getInstance());
		
		this.panelEliminarTecnico = new JPanel();
		this.panelTecnicos.add(this.panelEliminarTecnico);
		
		this.btnDarDeBaja = new JButton("Eliminar");
		this.panelEliminarTecnico.add(this.btnDarDeBaja);
		this.btnDarDeBaja.addActionListener(Controlador.getInstance());
		this.btnDarDeBaja.setHorizontalAlignment(SwingConstants.LEFT);
		
		this.panelAgregarTecnico = new JPanel();
		this.panelTecnicos.add(this.panelAgregarTecnico);
		
		this.btnAgregar = new JButton("Agregar");
		this.panelAgregarTecnico.add(this.btnAgregar);
		this.btnAgregar.addActionListener(Controlador.getInstance());
		this.btnAgregar.setHorizontalAlignment(SwingConstants.RIGHT);
		
		this.lblAccionesTecnico = new JLabel("Acciones de tecnico");
		this.panelC3.add(this.lblAccionesTecnico, BorderLayout.NORTH);
		
		this.listTecnicos = new JList<Tecnico>();
		this.panelC3.add(this.listTecnicos, BorderLayout.CENTER);
		
		this.panelDer = new JPanel();
		this.panelPrincipal.add(this.panelDer);
		
		this.panelSur = new JPanel();
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		this.panelSur.setLayout(new BorderLayout(0, 0));
		
		this.textAreaInfo = new JTextArea();
		this.panelSur.add(this.textAreaInfo);
		this.panelSur.setPreferredSize(new Dimension(50, 40));
		
		this.modeloListaAbonado = new DefaultListModel<IAbonado>();
		this.listAbonados.setModel(modeloListaAbonado);
		this.modeloListaTecnico = new DefaultListModel<Tecnico>();
		this.listTecnicos.setModel(modeloListaTecnico);
		
	}
	
}
