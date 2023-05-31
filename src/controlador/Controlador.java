package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.SistemaFactory;

public class Controlador implements ActionListener{
	 private SistemaFactory sistema = SistemaFactory.getInstance();
	 private static Controlador instance = null;
	 
	 private Controlador() {
		 
	 }
	 
	 public static Controlador getInstance() {
		 if (instance == null) {
			 instance = new Controlador();
		 }
		 return instance;
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
