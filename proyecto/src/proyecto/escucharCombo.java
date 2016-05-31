package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class escucharCombo implements ActionListener {

	public void actionPerformed(ActionEvent a) {
		cine.comprobar1();
		cine.comprobar2();
		cine.proyeccion();
		cine.contar();
		cine.textoContadores();
		cine.jp99();
	}

}
