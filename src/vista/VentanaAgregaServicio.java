package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
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

public class VentanaAgregaServicio extends JFrame implements ActionListener, KeyListener {

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
	private JPanel PanelMovil;
	private JPanel panelTextFieldCantCamaras;
	private final ButtonGroup buttonGroupTipoServ = new ButtonGroup();
	private final ButtonGroup buttonGroupPromo = new ButtonGroup();
	private JPanel panelRdbtnNinguna;
	private JRadioButton rdbtnNingunaPromo;
	private JPanel panelLblCC;
	private JPanel panelLblCCBA;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JCheckBox chckbxMovilAcomp;
	private JLabel lblMovilAcomp;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblDomicilio;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JTextField textFieldDomicilio;
	private JPanel panel_13;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaAgregaServicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 100, 499, 327);
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
		this.panelDetalles.setLayout(new GridLayout(4, 2, 0, 0));

		this.panelLblCC = new JPanel();
		this.panelLblCC.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.panelDetalles.add(this.panelLblCC);
		this.panelLblCC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.panel_10 = new JPanel();
		this.panelLblCC.add(this.panel_10);

		this.lblNewLabel = new JLabel("Cámaras");
		this.panel_10.add(this.lblNewLabel);
		this.lblNewLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);

		this.panelTextFieldCantCamaras = new JPanel();
		this.panelTextFieldCantCamaras.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.panelDetalles.add(this.panelTextFieldCantCamaras);
		this.panelTextFieldCantCamaras.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.panel_11 = new JPanel();
		this.panelTextFieldCantCamaras.add(this.panel_11);

		this.textFieldCantCamaras = new JTextField();
		this.panel_11.add(this.textFieldCantCamaras);
		this.textFieldCantCamaras.addKeyListener(this);
		this.textFieldCantCamaras.setEnabled(false);
		this.textFieldCantCamaras.setColumns(10);

		this.panelLblCCBA = new JPanel();
		this.panelLblCCBA.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.panelDetalles.add(this.panelLblCCBA);
		this.panelLblCCBA.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.panel_9 = new JPanel();
		this.panelLblCCBA.add(this.panel_9);

		this.lblCantBA = new JLabel("Botones antipánico");
		this.panel_9.add(this.lblCantBA);

		this.panel_7 = new JPanel();
		this.panelDetalles.add(this.panel_7);

		this.panel_12 = new JPanel();
		this.panel_7.add(this.panel_12);

		this.textFieldCantBA = new JTextField();
		this.panel_12.add(this.textFieldCantBA);
		this.textFieldCantBA.addKeyListener(this);
		this.textFieldCantBA.setEnabled(false);
		this.textFieldCantBA.setColumns(10);

		this.PanelMovil = new JPanel();
		this.PanelMovil.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		this.panelDetalles.add(this.PanelMovil);

		this.panel_8 = new JPanel();
		this.PanelMovil.add(this.panel_8);

		this.lblDomicilio = new JLabel("Domicilio");
		this.panel_8.add(this.lblDomicilio);

		this.panel_2 = new JPanel();
		this.panelDetalles.add(this.panel_2);

		this.panel_13 = new JPanel();
		this.panel_2.add(this.panel_13);

		this.textFieldDomicilio = new JTextField();
		this.textFieldDomicilio.setEnabled(false);
		this.textFieldDomicilio.addKeyListener(this);
		this.panel_13.add(this.textFieldDomicilio);
		this.textFieldDomicilio.setColumns(10);

		this.panel_4 = new JPanel();
		this.panelDetalles.add(this.panel_4);

		this.panel_3 = new JPanel();
		this.panelDetalles.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(2, 1, 0, 0));

		this.panel_5 = new JPanel();
		this.panel_3.add(this.panel_5);

		this.lblMovilAcomp = new JLabel("Movil de acompañamiento");
		this.panel_5.add(this.lblMovilAcomp);

		this.panel_6 = new JPanel();
		this.panel_3.add(this.panel_6);

		this.chckbxMovilAcomp = new JCheckBox("");
		this.panel_6.add(this.chckbxMovilAcomp);

		this.panelBtnAgregar = new JPanel();
		this.panelBtnAgregar.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		this.panelDer.add(this.panelBtnAgregar, BorderLayout.SOUTH);

		this.btnAgregar = new JButton("Agregar servicio");
		this.btnAgregar.setEnabled(false);
		this.panelBtnAgregar.add(this.btnAgregar);

	}

	public void actionPerformed(ActionEvent e) {
		boolean condicion1 = this.buttonGroupPromo.getSelection() != null;
		boolean condicion2 = this.buttonGroupTipoServ.getSelection() != null;

		this.textFieldCantBA.setEnabled(condicion1 && condicion2);
		this.textFieldCantCamaras.setEnabled(condicion2 && condicion1);
		this.textFieldDomicilio.setEnabled(condicion1 && condicion2);
	}

	public void setActionListener(ActionListener actionListener) {
		this.btnAgregar.addActionListener(actionListener);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		boolean condicion1 = false;
		boolean condicion2 = false;
		boolean condicion3 = false;
		if (this.textFieldCantBA.getText() != null) {
			condicion1 = Integer.parseInt(this.textFieldCantBA.getText()) >= 0;
		}
		if (this.textFieldCantCamaras.getText() != null) {
			condicion2 = Integer.parseInt(this.textFieldCantCamaras.getText()) >= 0;
		}
		condicion3 = !this.textFieldDomicilio.getText().equals(null);
		this.btnAgregar.setEnabled(condicion1 && condicion2 && condicion3);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void limpia() {
		this.buttonGroupPromo.clearSelection();
		this.buttonGroupTipoServ.clearSelection();
		this.textFieldCantBA.setText(null);
		this.textFieldCantCamaras.setText(null);
		this.textFieldDomicilio.setText(null);
		this.chckbxMovilAcomp.setSelected(false);
		this.textFieldCantBA.setEnabled(false);
		this.textFieldCantCamaras.setEnabled(false);
		this.btnAgregar.setEnabled(false);
	}

	public String getTipoServicio() {
		if (this.rdbtnVivienda.isSelected()) {
			return "Vivienda";

		} else
			return "Comercio";
	}

	public String getDomicilio() {
		return this.textFieldDomicilio.getText();
	}

	public int getCantBa() {
		return Integer.parseInt(this.textFieldCantBA.getText());
	}

	public int getCantCamaras() {
		return Integer.parseInt(this.textFieldCantCamaras.getText());
	}

	public boolean getAcom() {
		return this.chckbxMovilAcomp.isSelected();
	}

	public String getPromo() {
		if (this.rdbtnPromoDorada.isSelected()) {
			return "Dorada";
		} else if (this.rdbtnPromoPlatino.isSelected()) {
			return "Platino";
		} else
			return null;

	}

}
