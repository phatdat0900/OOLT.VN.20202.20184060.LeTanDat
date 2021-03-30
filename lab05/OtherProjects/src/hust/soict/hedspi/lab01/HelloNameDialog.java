package hust.soict.hedspi.lab01;
import javax.swing.JOptionPane;
public class HelloNameDialog {
public static void main(String[] args) {
	String r;
	r = JOptionPane.showInputDialog("Please enter your name:");
	JOptionPane.showInternalMessageDialog(null,"Hi "+r+"!");
	System.exit(0);
 }
}
	