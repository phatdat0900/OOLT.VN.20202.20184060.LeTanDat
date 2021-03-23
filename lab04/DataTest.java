package lab04;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTest {
	public static void main(String[] args) throws Exception {
		MyDate date1 = new MyDate(2000,1,2);
		MyDate date2 = new MyDate("Third","January","two thousand");
		date1.print();
		
		DateUtils.compareDate(date1, date2);
		
	}
}