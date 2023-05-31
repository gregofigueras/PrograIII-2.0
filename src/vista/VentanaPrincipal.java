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

import interfaces.IAbonado;
import modelo.Tecnico;

public class VentanaPrincipal extends JFrame implements ActionListener {

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
		setBounds(100, 100, 680, 422);
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
		this.btnPagaFactura.addActionListener(this);
		this.panelPagaFactura.add(this.btnPagaFactura);
		
		this.panelContrataNServicio = new JPanel();
		this.panelAccionesAbonado.add(this.panelContrataNServicio);
		
		this.btnContrataNServicio = new JButton("Contrata nuevo servicio");
		this.btnContrataNServicio.addActionListener(this);
		this.panelContrataNServicio.add(this.btnContrataNServicio);
		
		this.panelDarDeBajaS = new JPanel();
		this.panelAccionesAbonado.add(this.panelDarDeBajaS);
		
		this.btnDarDeBajaS = new JButton("Dar de baja un servicio");
		this.btnDarDeBajaS.addActionListener(this);
		this.panelDarDeBajaS.add(this.btnDarDeBajaS);
		
		this.panelC2 = new JPanel();
		this.panelC2.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.panelCentral.add(this.panelC2);
		
		this.panelC3 = new JPanel();
		this.panelC3.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.panelCentral.add(this.panelC3);
		this.panelC3.setLayout(new BorderLayout(0, 0));
		
		this.panelTecnicos = new JPanel();
		this.panelC3.add(this.panelTecnicos, BorderLayout.SOUTH);
		
		this.btnSolicitar = new JButton("Solicitar");
		this.btnSolicitar.addActionListener(this);
		
		this.btnDarDeBaja = new JButton("Eliminar");
		this.btnDarDeBaja.addActionListener(this);
		this.btnDarDeBaja.setHorizontalAlignment(SwingConstants.LEFT);
		
		this.btnAgregar = new JButton("Agregar");
		this.btnAgregar.addActionListener(this);
		this.btnAgregar.setHorizontalAlignment(SwingConstants.RIGHT);
		this.panelTecnicos.setLayout(new BoxLayout(this.panelTecnicos, BoxLayout.X_AXIS));
		this.panelTecnicos.add(this.btnSolicitar);
		this.panelTecnicos.add(this.btnDarDeBaja);
		this.panelTecnicos.add(this.btnAgregar);
		
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

	public void actionPerformed(ActionEvent e) {
	}
}
