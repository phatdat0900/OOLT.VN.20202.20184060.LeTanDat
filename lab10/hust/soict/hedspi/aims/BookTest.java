package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
	public static void main(String[] args) {
		Book book1 = new Book("One Piece", "Action", "Oda", 18.99f);

		book1.setContent("hello world hi hi");
		
		book1.processContent();
		book1.toString();

	}
}
