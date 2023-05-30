package persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersistenciaXML implements IPersistencia {

	private XMLEncoder xmlEncoder;
	private XMLDecoder xmlDecoder;
	private FileOutputStream fileoutput;
	private FileInputStream fileinput;

	@Override
	public void abrirInput(String nombre) throws IOException {
		fileinput = new FileInputStream(nombre);
		xmlDecoder = new XMLDecoder(fileinput);
	}

	@Override
	public void abrirOutput(String nombre) throws IOException {
		fileoutput = new FileOutputStream(nombre);
		xmlEncoder = new XMLEncoder(fileoutput);
	}

	@Override
	public void cerrarOutput() throws IOException {
		if (this.xmlEncoder != null)
			this.xmlEncoder.close();
	}

	@Override
	public void cerrarInput() throws IOException {
		if (this.xmlDecoder != null)
			this.xmlDecoder.close();
	}

	@Override
	public void escribir(Object objeto) throws IOException {
		xmlEncoder.writeObject(objeto);
	}

	@Override
	public Object Leer() throws IOException, ClassNotFoundException {
		Object objeto = null;
		if (xmlDecoder != null)
			objeto = xmlDecoder.readObject();

		return objeto;
	}

}
