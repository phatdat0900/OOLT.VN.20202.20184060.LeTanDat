package lab04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
public static void compareDate(MyDate date1,MyDate date2)  throws Exception {
		
		String str1;
		String str2;
		str1 = String.valueOf(date1.getDay()) + "/" + String.valueOf(date1.getMonth()) + "/"
				+ String.valueOf(date1.getYear());
		str2 = String.valueOf(date2.getDay()) + "/" + String.valueOf(date2.getMonth()) + "/"
				+ String.valueOf(date2.getYear());
		Date Date1 = new SimpleDateFormat("dd/MM/yyyy").parse(str1);
		Date Date2 = new SimpleDateFormat("dd/MM/yyyy").parse(str2);
		int n = Date1.compareTo(Date2);
		if(n==0) {
		    System.out.println("Date1 is equal to Date2");
        } else if (n > 0) {
            System.out.println("Date1 is after Date2");
        } else if (n < 0) {
            System.out.println("Date1 is before Date2");
        } else {
        	throw new AssertionError("error !!!");
        }
      
		
	}

}
