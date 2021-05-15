package hust.soict.hedspi.aims;

import javax.swing.JOptionPane;

public class PlayerException extends Exception {

	public PlayerException(String string) {
		super(string);
		JOptionPane.showMessageDialog(null,string ,"Error", JOptionPane.ERROR_MESSAGE);
	}

}
