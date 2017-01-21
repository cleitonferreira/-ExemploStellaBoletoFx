package br.com.nuvemapp.exemplostellaboletofx.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public abstract class VisualizarPDF {

	public static void mostrarNaTela(File arquivo) {
		Desktop desktop = Desktop.getDesktop();

		// arquivo = arquivo.renameTo(new File(""));
		// desktop.edit(arquivo);

		try {
			desktop.open(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
