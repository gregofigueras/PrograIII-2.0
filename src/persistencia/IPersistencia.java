package persistencia;

import java.io.IOException;

public interface IPersistencia {
	void abrirInput(String nombre) throws IOException;

	void abrirOutput(String nombre) throws IOException;

	void cerrarOutput() throws IOException;

	void cerrarInput() throws IOException;

	void escribir(Object objeto) throws IOException;

	Object Leer() throws IOException, ClassNotFoundException;
}
