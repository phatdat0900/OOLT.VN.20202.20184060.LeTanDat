package lab04;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTest {
	public static void main(String[] args) throws Exception {
		MyDate date1 = new MyDate();
		date1.print();
		MyDate date2 = new MyDate("Twenty-seventh","March","two thousand twenty one");
		date2.print();
		
		DateUtils.compareDate(date1, date2);
		DateUtils.sort();
	}
}