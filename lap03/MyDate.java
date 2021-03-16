package lap03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.text.ParseException;

public class MyDate {
	private int year;
	private int month;
	private int day;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public MyDate(Date date) {
		date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		this.day = Integer.parseInt(strDate.substring(0, 2));
		this.month = Integer.parseInt(strDate.substring(3, 5));
		this.year = Integer.parseInt(strDate.substring(6, 10));

	}

	public MyDate(String date) {// DD/MM/YYYY
		Pattern pattern = Pattern.compile("\\d{2}[/]\\d{2}[/]\\d{4}");
		Matcher matcher = pattern.matcher(date);
		if(matcher.matches()) {
		this.year = Integer.parseInt(date.substring(6, 10));
		this.month = Integer.parseInt(date.substring(3, 5));
		this.day = Integer.parseInt(date.substring(0, 2));
		}
	}

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	
	public static int checkDate(MyDate Date) {
		int check = 0;
		if (Date.getMonth() >= 1 && Date.getMonth() <= 12) {
			if (Date.getMonth() == 1 || Date.getMonth() == 3 || Date.getMonth() == 5 || Date.getMonth() == 7
					|| Date.getMonth() == 8 || Date.getMonth() == 10 || Date.getMonth() == 12) {
				if (Date.getDay() >= 1 && Date.getDay() <= 31) {
					check = 1;
				} else {
					check = 0;
				}
			}
			if (Date.getMonth() == 4 || Date.getMonth() == 6 || Date.getMonth() == 9 || Date.getMonth() == 11) {
				if (Date.getDay() >= 1 && Date.getDay() <= 30) {
					check = 1;
				} else {
					check = 0;
				}
			}
			if (Date.getMonth() == 2) {
				if (Date.getYear() % 4 == 0 && Date.getYear() % 100 != 0 || Date.getYear() % 400 == 0) {
					if (Date.getDay() >= 1 && Date.getDay() <= 29) {
						check = 1;
					} else {
						check = 0;
					}
				} else {
					if (Date.getDay() >= 1 && Date.getDay() <= 28) {
						check = 1;
					} else {
						check = 0;
					}
				}
			}
		} else {
			check = 0;
		}

		return check;
	}
	
	
	

	public static void accept() {
		String str;
		str = JOptionPane.showInputDialog(null, "", "following this form dd/MM/yyyy :",
				JOptionPane.INFORMATION_MESSAGE);
		Pattern pattern = Pattern.compile("\\d{2}[/]\\d{2}[/]\\d{4}");
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			MyDate Date = new MyDate(str);
			if (checkDate(Date) == 1) {
				print(Date);
			} else {
				JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	

	public static void print(MyDate Date) {
		String str;
		str = String.valueOf(Date.getDay()) + "/" + String.valueOf(Date.getMonth()) + "/"
				+ String.valueOf(Date.getYear());
		JOptionPane.showInternalMessageDialog(null, str, "Show Date", JOptionPane.INFORMATION_MESSAGE);
	}

}
