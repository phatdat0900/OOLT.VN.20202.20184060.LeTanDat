package lap02;

import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class showdate {
	public static void main(String[] args) {
		String strYear, str;
		strYear = JOptionPane.showInputDialog(null, "", "Input year:", JOptionPane.INFORMATION_MESSAGE);
		int year = Integer.parseInt(strYear);
		Pattern pattern = Pattern.compile("\\d*");// check number
		int num = 0;
		String m;
		String month[] = new String[12];
		month[0] = "01 , January , Jan. , Jan";
		month[1] = "02 , February , Feb. , Feb";
		month[2] = "03 , March , Mar. , Mar";
		month[3] = "04 , April , Apr. , Apr";
		month[4] = "05 , May , May , May";
		month[5] = "06 , June , June , Jun";
		month[6] = "07 , July , July , Jul";
		month[7] = "08 , August , Aug. , Aug";
		month[8] = "09 , September , Sept. , Sep";
		month[9] = "10 , October , Oct. , Oct";
		month[10] = "11 , November , Nov. , Nov";
		month[11] = "12 , December , Dec. , Dec";

		String strMonth = JOptionPane.showInputDialog(null, "", "Input month:", JOptionPane.INFORMATION_MESSAGE);
		Matcher matcher = pattern.matcher(strMonth);
		if (matcher.matches()) {// if input is number
			num = Integer.parseInt(strMonth);
		} else {
			for (int i = 0; i < 12; i++) {
				if (month[i].contains(strMonth)) {
					m = month[i].substring(0, 2);
					num = Integer.parseInt(m);
				}
			}
		}
		
		str =strMonth + "/" + strYear + " have : ";
		if(num>=1 && num <=12) {

		if (num == 1 || num == 3 || num == 5 || num == 7 || num == 8 || num == 10 || num == 12) {
			str += "31"+ "days";
			JOptionPane.showInternalMessageDialog(null, str, "Show days of month", JOptionPane.INFORMATION_MESSAGE);
		}
		if (num == 4 || num == 6 || num == 9 || num == 11) {
			str += "30"+ "days";;
			JOptionPane.showInternalMessageDialog(null, str, "Show days of month", JOptionPane.INFORMATION_MESSAGE);
		}
		if (num == 2) {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				str += "29"+ "days";;
				JOptionPane.showInternalMessageDialog(null, str, "Show days of month", JOptionPane.INFORMATION_MESSAGE);
			} else {
				str += "28"+ "days";;
				JOptionPane.showInternalMessageDialog(null, str, "Show days of month", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		}else {
			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

	}

}
