package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import interfaces.IAbonado;
import modelo.Servicio;
import modelo.Tecnico;

public class VentanaPrincipal extends JFrame implements KeyListener, MouseListener {

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
	private JTextArea textAreaInfo;
	private JButton btnSolicitarTecnico;
	private JButton btnEliminarTecnico;
	private JButton btnAgregarTecnico;
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
	private Controlador controlador ;
	private JScrollPane scrollPaneDer;
	private JList listServicios;
	private JPanel panelDer;
	private JPanel panel;


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
		this.panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Abonado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelPrincipal.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.panelIzq = new JScrollPane();
		this.panel.add(this.panelIzq);
		
		this.listAbonados = new JList<IAbonado>();
		this.panelIzq.setViewportView(this.listAbonados);
		this.modeloListaAbonado = new DefaultListModel<IAbonado>();
		this.listAbonados.setModel(modeloListaAbonado);
		
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
		this.panelSolicitar.add(this.btnSolicitarTecnico);
		
		this.panelEliminarTecnico = new JPanel();
		this.panelTecnicos.add(this.panelEliminarTecnico);
		
		this.btnEliminarTecnico = new JButton("Eliminar");
		this.panelEliminarTecnico.add(this.btnEliminarTecnico);
		this.btnEliminarTecnico.setHorizontalAlignment(SwingConstants.LEFT);
		
		this.panelAgregarTecnico = new JPanel();
		this.panelTecnicos.add(this.panelAgregarTecnico);
		
		this.btnAgregarTecnico = new JButton("Agregar");
		this.panelAgregarTecnico.add(this.btnAgregarTecnico);
		this.btnAgregarTecnico.setHorizontalAlignment(SwingConstants.RIGHT);
		
		this.lblAccionesTecnico = new JLabel("Acciones de tecnico");
		this.panelC3.add(this.lblAccionesTecnico, BorderLayout.NORTH);
		
		this.listTecnicos = new JList<Tecnico>();
		this.panelC3.add(this.listTecnicos, BorderLayout.CENTER);
		
		this.panelSur = new JPanel();
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		this.panelSur.setLayout(new BorderLayout(0, 0));
		
		this.textAreaInfo = new JTextArea();
		this.panelSur.add(this.textAreaInfo);
		this.panelSur.setPreferredSize(new Dimension(50, 40));
		
		this.modeloListaAbonado = new DefaultListModel<IAbonado>();
		this.modeloListaTecnico = new DefaultListModel<Tecnico>();
		this.listTecnicos.setModel(modeloListaTecnico);
		this.listAbonados.setModel(modeloListaAbonado);
		
		this.panelDer = new JPanel();
		this.panelDer.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelPrincipal.add(this.panelDer);
		this.panelDer.setLayout(new BorderLayout(0, 0));
		
		this.scrollPaneDer = new JScrollPane();
		this.panelDer.add(this.scrollPaneDer);
		
		this.listServicios = new JList<Servicio>();
		this.scrollPaneDer.setViewportView(this.listServicios);
		
		this.setVisible(true);
		
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		String nombre=  this.nombre.getText();
		String dni= this.dni.getText();
		boolean condicion = !(nombre.equals("") || nombre.equals(null))&& !(dni.equals("")|| dni.equals(null));
		if (!condicion){
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
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		boolean condicion1= (rdbtnJuridico.isSelected() || rdbtnFisico.isSelected()) && (rdbtnJuridico.isEnabled() && rdbtnFisico.isEnabled());
		rdbtnCheque.setEnabled(condicion1);
		rdbtnEfectivo.setEnabled(condicion1);
		rdbtnCredito.setEnabled(condicion1);
		boolean condicion2= rdbtnCheque.isSelected() || rdbtnCredito.isSelected() || rdbtnEfectivo.isSelected();
		btnAgregarAbonado.setEnabled(condicion2);
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
		this.actionListener=actionListener;
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
		}
		else
			return "Fisico";
	}
	
	public String getPago() {
		if (this.rdbtnCheque.isSelected()) {
			return "Cheque";
		}
		else if (this.rdbtnCredito.isSelected()) {
			return "Credito";
		}
		else
			return "Efectivo";
	}
	
	public void actualizaLista() {
		Iterator<IAbonado> it = this.controlador.getAbonados().iterator();
		
		this.modeloListaAbonado.clear();
		while (it.hasNext()) {
			this.modeloListaAbonado.addElement(it.next());
		}
		this.repaint();
	}
	
	public IAbonado getSelected() {
		return this.listAbonados.getSelectedValue();
	}
}
