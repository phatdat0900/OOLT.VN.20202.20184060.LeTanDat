package hust.soict.hedspi.aims;



import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

public class test {
	public static void main(String[] args) {
		Media media = new Media("a","c",40f);
		Book book1 ;
		media = new Book();
		book1=(Book) media;
		System.out.println(book1.getTitle());
		//System.out.println(book1.getTitle());
		
	
		Media m = new Book();
		
		m.setTitle("a");

		// This parameter is not accessible
		// p.id = 1;
		System.out.println(m.getTitle());
		

		// Trying to Downcasting Implicitly
		// Child c = new Parent(); - > compile time error

		// Downcasting Explicitly
		Book c = (Book) m;

		
		System.out.println(c.getTitle());
	}

}
