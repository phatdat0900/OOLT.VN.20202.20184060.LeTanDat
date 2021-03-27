package lab04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;

public class DateUtils {
	public static void compareDate(MyDate date1, MyDate date2) throws Exception {

		String str1;
		String str2;
		str1 = String.valueOf(date1.getDay()) + "/" + String.valueOf(date1.getMonth()) + "/"
				+ String.valueOf(date1.getYear());
		str2 = String.valueOf(date2.getDay()) + "/" + String.valueOf(date2.getMonth()) + "/"
				+ String.valueOf(date2.getYear());
		Date Date1 = new SimpleDateFormat("dd/MM/yyyy").parse(str1);
		Date Date2 = new SimpleDateFormat("dd/MM/yyyy").parse(str2);
		int n = Date1.compareTo(Date2);
		if (n == 0) {
			System.out.println("Date1 is equal to Date2");
		} else if (n > 0) {
			System.out.println("Date1 is after Date2");
		} else if (n < 0) {
			System.out.println("Date1 is before Date2");
		} else {
			throw new AssertionError("error !!!");
		}

	}

	public static void sort() {
		
		LocalDate [] randomDate = new LocalDate[10];
		LocalDate date;
		for (int i = 0; i < 10; i++) {
			 randomDate[i] = createRandomDate(2000,2021);
			
		}
		for( int i = 0 ;i<10;i++) {
			for(int j = i+1;j<10;j++) {
				int n = randomDate[i].compareTo(randomDate[j]);
				if(n>0) {
					date =randomDate[i];
					randomDate[i] =randomDate[j];
					randomDate[j]= date;
				}
				
			}
		}
		System.out.println("10 random date have been sort:");
		for (int i = 0; i < 10; i++) {
			 System.out.println(randomDate[i]);
		}
	}
	
	public static int randomBetween(int start,int end ) {
		return start +(int)Math.round(Math.random()*(end-start)); 	
	}

	public static LocalDate createRandomDate(int start,int end) {
		int day = randomBetween(1,28);
		int month =  randomBetween(1,12);
		int year =  randomBetween(start,end);
		return LocalDate.of(year,month,day);
		
	}
}
