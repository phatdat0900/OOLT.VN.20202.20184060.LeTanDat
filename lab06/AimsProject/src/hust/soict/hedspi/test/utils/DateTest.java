package hust.soict.hedspi.test.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {
	public static void main(String[] args) throws Exception {
		MyDate date1 = new MyDate();
		date1.print();
		MyDate date2 = new MyDate("Twenty-seventh", "March", "two thousand twenty one");
		date2.print();

		DateUtils.compareDate(date1, date2);
		DateUtils.sort();
	}
}