package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public Book() {

	}

	public Book(String title) {
		super(title);
	}

	public Book(String title, String category) {
		super(title, category);
	}

	public Book(String title, String category, String authors) {
		super(title, category);
		this.addAuthor(authors);
	}

	public Book(String title, String category, String authors, float cost) {
		this(title, category);
		this.addAuthor(authors);
		this.cost = cost;
	}

	

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		authors.add(authorName);
	}

	public void removeAuthor(String authorName) {
		authors.remove(authorName);

	}
	public void Print() {
		System.out.printf(" ID:%-2d |%-25s|%-25s|%-25s|%-7.2f$\n",this.getId() ,this.getTitle(),this.getCategory(),this.getAuthors(),this.getCost());
	}

}
