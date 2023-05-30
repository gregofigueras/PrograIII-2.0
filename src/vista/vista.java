package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class vista extends JFrame {

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
	private JButton btnSolicitaTec;
	private JButton btnNewButton;
	private JLabel lblAccionesTecnico;
	private JList listTecnicos;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JScrollPane panelIzq;
	private JList listAbonados;
	private JLabel lblAbonados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista frame = new vista();
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
	public vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 422);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(1, 3, 0, 0));
		
		this.panelIzq = new JScrollPane();
		this.panelPrincipal.add(this.panelIzq);
		
		this.listAbonados = new JList();
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
		this.panelPagaFactura.add(this.btnPagaFactura);
		
		this.panelContrataNServicio = new JPanel();
		this.panelAccionesAbonado.add(this.panelContrataNServicio);
		
		this.btnContrataNServicio = new JButton("Contrata nuevo servicio");
		this.panelContrataNServicio.add(this.btnContrataNServicio);
		
		this.panelDarDeBajaS = new JPanel();
		this.panelAccionesAbonado.add(this.panelDarDeBajaS);
		
		this.btnDarDeBajaS = new JButton("Dar de baja un servicio");
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
		
		this.btnSolicitaTec = new JButton("Solicitar tecnico");
		this.panelTecnicos.add(this.btnSolicitaTec);
		
		this.btnNewButton = new JButton("Dar de alta");
		this.panelTecnicos.add(this.btnNewButton);
		
		this.lblAccionesTecnico = new JLabel("Acciones de tecnico");
		this.panelC3.add(this.lblAccionesTecnico, BorderLayout.NORTH);
		
		this.listTecnicos = new JList();
		this.panelC3.add(this.listTecnicos, BorderLayout.CENTER);
		
		this.panelDer = new JPanel();
		this.panelPrincipal.add(this.panelDer);
		
		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane, BorderLayout.SOUTH);
		
		this.textArea = new JTextArea();
		this.scrollPane.setViewportView(this.textArea);
	}

}
