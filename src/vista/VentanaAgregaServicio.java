package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class VentanaAgregaServicio extends JFrame implements KeyListener, ActionListener {

	private JPanel contentPane;
	private JLabel lblNuevoS;
	private JPanel panelPrinc;
	private JPanel panelIzq;
	private JPanel panelDer;
	private JPanel panelTipoS;
	private JPanel panelPromos;
	private JLabel lblTipoS;
	private JPanel panelRdbtnTipoS;
	private JPanel panelVivienda;
	private JPanel panelComercio;
	private JRadioButton rdbtnVivienda;
	private JRadioButton rdbtnComercio;
	private JPanel panel;
	private JPanel panelRdbtnPromos;
	private JPanel panelPromoDorada;
	private JPanel panelRdbtnPromoPlatino;
	private JRadioButton rdbtnPromoDorada;
	private JRadioButton rdbtnPromoPlatino;
	private JLabel lblPromo;
	private JPanel panelDetalles;
	private JPanel panelBtnAgregar;
	private JButton btnAgregar;
	private JLabel lblNewLabel;
	private JTextField textFieldCantCamaras;
	private JLabel lblCantBA;
	private JTextField textFieldCantBA;
	private JLabel lblMovilAcomp;
	private JCheckBox chckbxMovilAcomp;
	private JPanel PanelMovil;
	private JPanel panelTextFieldCantCamaras;
	private JPanel panelTextFieldCantBA;
	private final ButtonGroup buttonGroupTipoServ = new ButtonGroup();
	private final ButtonGroup buttonGroupPromo = new ButtonGroup();
	private JPanel panelRdbtnNinguna;
	private JRadioButton rdbtnNingunaPromo;
	private JPanel panelLblCC;
	private JPanel panelLblCCBA;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregaServicio frame = new VentanaAgregaServicio();
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
	public VentanaAgregaServicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.lblNuevoS = new JLabel("Ingrese los datos del nuevo servicio");
		this.contentPane.add(this.lblNuevoS, BorderLayout.NORTH);

		this.panelPrinc = new JPanel();
		this.contentPane.add(this.panelPrinc, BorderLayout.CENTER);
		this.panelPrinc.setLayout(new GridLayout(0, 2, 0, 0));

		this.panelIzq = new JPanel();
		this.panelIzq.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.panelPrinc.add(this.panelIzq);
		this.panelIzq.setLayout(new GridLayout(2, 0, 0, 0));

		this.panelTipoS = new JPanel();
		this.panelTipoS.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		this.panelIzq.add(this.panelTipoS);
		this.panelTipoS.setLayout(new GridLayout(2, 2, 0, 0));

		this.panel_1 = new JPanel();
		this.panelTipoS.add(this.panel_1);

		this.lblTipoS = new JLabel("Tipo de servicio:");
		this.panel_1.add(this.lblTipoS);

		this.panelRdbtnTipoS = new JPanel();
		this.panelTipoS.add(this.panelRdbtnTipoS);
		this.panelRdbtnTipoS.setLayout(new GridLayout(0, 2, 0, 0));

		this.panelVivienda = new JPanel();
		this.panelRdbtnTipoS.add(this.panelVivienda);

		this.rdbtnVivienda = new JRadioButton("Vivienda");
		this.rdbtnVivienda.addActionListener(this);
		buttonGroupTipoServ.add(this.rdbtnVivienda);
		this.panelVivienda.add(this.rdbtnVivienda);

		this.panelComercio = new JPanel();
		this.panelRdbtnTipoS.add(this.panelComercio);

		this.rdbtnComercio = new JRadioButton("Comercio");
		this.rdbtnComercio.addActionListener(this);
		buttonGroupTipoServ.add(this.rdbtnComercio);
		this.panelComercio.add(this.rdbtnComercio);

		this.panelPromos = new JPanel();
		this.panelIzq.add(this.panelPromos);
		this.panelPromos.setLayout(new GridLayout(2, 2, 0, 0));

		this.panel = new JPanel();
		this.panelPromos.add(this.panel);

		this.lblPromo = new JLabel("Promo del servicio");
		this.panel.add(this.lblPromo);

		this.panelRdbtnPromos = new JPanel();
		this.panelPromos.add(this.panelRdbtnPromos);
		this.panelRdbtnPromos.setLayout(new GridLayout(0, 3, 0, 0));

		this.panelPromoDorada = new JPanel();
		this.panelRdbtnPromos.add(this.panelPromoDorada);

		this.rdbtnPromoDorada = new JRadioButton("Dorada");
		this.rdbtnPromoDorada.addActionListener(this);
		buttonGroupPromo.add(this.rdbtnPromoDorada);
		this.panelPromoDorada.add(this.rdbtnPromoDorada);

		this.panelRdbtnPromoPlatino = new JPanel();
		this.panelRdbtnPromos.add(this.panelRdbtnPromoPlatino);

		this.rdbtnPromoPlatino = new JRadioButton("Platino");
		this.rdbtnPromoPlatino.addActionListener(this);
		buttonGroupPromo.add(this.rdbtnPromoPlatino);
		this.panelRdbtnPromoPlatino.add(this.rdbtnPromoPlatino);

		this.panelRdbtnNinguna = new JPanel();
		this.panelRdbtnPromos.add(this.panelRdbtnNinguna);

		this.rdbtnNingunaPromo = new JRadioButton("Ninguna");
		this.rdbtnNingunaPromo.addActionListener(this);
		buttonGroupPromo.add(this.rdbtnNingunaPromo);
		this.panelRdbtnNinguna.add(this.rdbtnNingunaPromo);

		this.panelDer = new JPanel();
		this.panelPrinc.add(this.panelDer);
		this.panelDer.setLayout(new BorderLayout(0, 0));

		this.panelDetalles = new JPanel();
		this.panelDer.add(this.panelDetalles, BorderLayout.CENTER);
		this.panelDetalles.setLayout(new GridLayout(0, 1, 0, 0));

		this.panelLblCC = new JPanel();
		this.panelLblCC.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.panelDetalles.add(this.panelLblCC);

		this.lblNewLabel = new JLabel("Cantidad de camaras");
		this.panelLblCC.add(this.lblNewLabel);

		this.panelTextFieldCantCamaras = new JPanel();
		this.panelTextFieldCantCamaras.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.panelDetalles.add(this.panelTextFieldCantCamaras);

		this.textFieldCantCamaras = new JTextField();
		this.textFieldCantCamaras.addKeyListener(this);
		this.panelTextFieldCantCamaras.add(this.textFieldCantCamaras);
		this.textFieldCantCamaras.setColumns(10);

		this.panelLblCCBA = new JPanel();
		this.panelLblCCBA.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.panelDetalles.add(this.panelLblCCBA);

		this.lblCantBA = new JLabel("Cantidad de botones antipánico");
		this.panelLblCCBA.add(this.lblCantBA);

		this.panelTextFieldCantBA = new JPanel();
		this.panelTextFieldCantBA.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.panelDetalles.add(this.panelTextFieldCantBA);

		this.textFieldCantBA = new JTextField();
		this.panelTextFieldCantBA.add(this.textFieldCantBA);
		this.textFieldCantBA.setColumns(10);
		this.textFieldCantBA.addKeyListener(this);

		this.PanelMovil = new JPanel();
		this.PanelMovil.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		this.panelDetalles.add(this.PanelMovil);

		this.lblMovilAcomp = new JLabel("Movil de acompañamiento");
		this.PanelMovil.add(this.lblMovilAcomp);

		this.chckbxMovilAcomp = new JCheckBox("");
		this.PanelMovil.add(this.chckbxMovilAcomp);

		this.panelBtnAgregar = new JPanel();
		this.panelBtnAgregar.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		this.panelDer.add(this.panelBtnAgregar, BorderLayout.SOUTH);

		this.btnAgregar = new JButton("Agregar servicio");
		this.panelBtnAgregar.add(this.btnAgregar);
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		int cantCamaras = 0;
		int cantBotAntiPanico = 0;

		try {
			cantCamaras = Integer.parseInt(this.textFieldCantCamaras.getText());
			cantBotAntiPanico = Integer.parseInt(this.textFieldCantBA.getText());
		} catch (NumberFormatException exc) {

		}
		boolean condicion = cantCamaras >= 0 && cantBotAntiPanico >= 0;
		this.btnAgregar.setEnabled(condicion);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		boolean condicion1 = this.buttonGroupPromo.getSelection() != null;
		boolean condicion2 = this.buttonGroupTipoServ.getSelection() != null;

		this.btnAgregar.setEnabled(condicion1 && condicion2);
	}
	
	public void setActionListener(ActionListener actionListener) {
		this.btnAgregar.addActionListener(actionListener);
	}
}
