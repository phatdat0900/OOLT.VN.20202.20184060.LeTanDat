package lap03;

import javax.swing.JOptionPane;
import java.util.Date;
public class DataTest {
public static void main(String[] args) {
	Date d=null;
	Object[] options = { "1", "2" };
	int choice = JOptionPane.showOptionDialog(null,
			"1:getPresentDate   - 2:InputDate  ", "Option",
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	JOptionPane.showMessageDialog(null, "choice: " + (choice == JOptionPane.YES_OPTION ? "1" : "2"));
	
	if(choice==0) {
		MyDate Date = new MyDate(d);
		MyDate.print(Date);
	}
	else {
	MyDate.accept();
	}
}

}
