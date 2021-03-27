package lab04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

	public MyDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		this.day = Integer.parseInt(strDate.substring(0,2));
		this.month = Integer.parseInt(strDate.substring(3,5));
		this.year = Integer.parseInt(strDate.substring(6, 10));

	}

	public MyDate(String date) {// DD/MM/YYYY
		Pattern pattern = Pattern.compile("\\d{2}[/]\\d{2}[/]\\d{4}");
		Matcher matcher = pattern.matcher(date);
		if (matcher.matches()) {
			this.year = Integer.parseInt(date.substring(6, 10));
			this.month = Integer.parseInt(date.substring(3, 5));
			this.day = Integer.parseInt(date.substring(0, 2));
			if(checkDate(this)== 0) {
				throw new AssertionError("Invalid date");
			}
		}
		
	}

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		if(checkDate(this)== 0) {
			throw new AssertionError("Invalid date");
		}
		
	}

	public MyDate(String day, String month, String year) {
		convertStringtoNumber con = new convertStringtoNumber();
		this.day=con.convertDay(day);
		this.month=con.convertMonth(month);
		this.year=con.convertYear(year);
		if(checkDate(this)== 0) {
			throw new AssertionError("Invalid date");
		}

	}

	public  int checkDate(MyDate Date) {
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

	
	public  void print() {
		String str;
		str = String.valueOf(this.day) + "/" + String.valueOf(this.month) + "/"
				+ String.valueOf(this.year);
		System.out.println(str);
	}

}
