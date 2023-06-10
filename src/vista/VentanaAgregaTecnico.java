package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaAgregaTecnico extends JFrame {

	private JPanel contentPane;
	private JPanel PanelArriba;
	private JPanel PanelMedio;
	private JPanel panelAbajo;
	private JButton btnAgregarTecnico;
	private JButton btnCancelarAgregar;
	private JTextField TecnicoId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregaTecnico frame = new VentanaAgregaTecnico();
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
	public VentanaAgregaTecnico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(3, 1, 0, 0));

		this.PanelArriba = new JPanel();
		this.contentPane.add(this.PanelArriba);

		this.PanelMedio = new JPanel();
		this.contentPane.add(this.PanelMedio);
		this.PanelMedio.setLayout(new BorderLayout(0, 0));

		this.TecnicoId = new JTextField();
		this.TecnicoId.setText("ID de tecnico");
		this.PanelMedio.add(this.TecnicoId, BorderLayout.CENTER);
		this.TecnicoId.setColumns(10);

		this.panelAbajo = new JPanel();
		this.contentPane.add(this.panelAbajo);
		this.panelAbajo.setLayout(new GridLayout(2, 2, 0, 0));

		this.btnAgregarTecnico = new JButton("Agregar");
		this.btnAgregarTecnico.setEnabled(false);
		this.panelAbajo.add(this.btnAgregarTecnico);

		this.btnCancelarAgregar = new JButton("Cancelar");
		this.panelAbajo.add(this.btnCancelarAgregar);
	}

}
