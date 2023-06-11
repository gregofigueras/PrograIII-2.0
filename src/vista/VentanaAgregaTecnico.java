package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class VentanaAgregaTecnico extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JPanel panelAbajo;
	private JButton btnAgregarTecnico;
	private JButton btnCancelarAgregar;
	private JPanel panel;
	private JLabel lblNombreTecnico;
	private JLabel lblNewLabel;
	private JTextField textFieldIDTecnico;
	private JTextField textFieldNombreTecnico;

	public VentanaAgregaTecnico() {
		setTitle("Nuevo Tecnico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(2, 1, 0, 0));

		this.panel = new JPanel();
		this.panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Informacion Tecnico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.contentPane.add(this.panel);
		this.panel.setLayout(new GridLayout(4, 1, 0, 0));

		this.lblNombreTecnico = new JLabel("Nombre del tecnico");
		this.panel.add(this.lblNombreTecnico);

		this.textFieldNombreTecnico = new JTextField();
		this.panel.add(this.textFieldNombreTecnico);
		this.textFieldNombreTecnico.setColumns(10);

		this.lblNewLabel = new JLabel("ID de tecnico");
		this.panel.add(this.lblNewLabel);

		this.textFieldIDTecnico = new JTextField();
		this.textFieldIDTecnico.setColumns(10);
		this.panel.add(this.textFieldIDTecnico);

		this.panelAbajo = new JPanel();
		this.contentPane.add(this.panelAbajo);
		this.panelAbajo.setLayout(new GridLayout(2, 2, 0, 0));

		this.btnAgregarTecnico = new JButton("agregarTecnico");
		this.btnAgregarTecnico.setEnabled(false);
		this.panelAbajo.add(this.btnAgregarTecnico);

		this.btnCancelarAgregar = new JButton("Cancelar");
		this.panelAbajo.add(this.btnCancelarAgregar);

		this.btnCancelarAgregar.addActionListener(this);
		this.textFieldNombreTecnico.addKeyListener(this);
		this.textFieldIDTecnico.addKeyListener(this);

		this.setVisible(false);
	}

	public void setActionListener(ActionListener actionListener) {
		this.btnAgregarTecnico.addActionListener(actionListener);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		boolean condicion1 = (!this.textFieldNombreTecnico.getText().equals(null)
				&& !this.textFieldNombreTecnico.getText().equals(""));
		boolean condicion2 = (!this.textFieldIDTecnico.getText().equals(null)
				&& !this.textFieldIDTecnico.getText().equals(""));

		this.btnAgregarTecnico.setEnabled(condicion1 && condicion2);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void limpia() {
		this.textFieldNombreTecnico.setText(null);
		this.textFieldIDTecnico.setText(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("cancelar")) {
			this.setVisible(false);
			this.limpia();
		}
	}

	public String getNombreTecnico() {
		return this.textFieldNombreTecnico.getText();
	}

	public String getIDTecnico() {
		return this.textFieldIDTecnico.getText();
	}
}