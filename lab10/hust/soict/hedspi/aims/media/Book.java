package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Book extends Media implements Comparable<Object> {
	private String content;
	private List<String> authors = new ArrayList<String>();
	private List<String> contentTokens = new ArrayList<String>();
	Map<String, Integer> wordFrequency = new HashMap< String,Integer>();
	private static int count = 0;
	
	

	public Book() {
		super();
	

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;

	}

	public List<String> getContentTokens() {
		return contentTokens;
	}

	public void setContentTokens(List<String> contentTokens) {
		this.contentTokens = contentTokens;
	}

	public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
	}

	public void setWordFrequency(Map<String, Integer> wordFrequency) {
		this.wordFrequency = wordFrequency;
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
		this.setId(++count);
		this.Type="Book";
	}

	public void processContent() {
		
		String[] parts = this.getContent().split(" ");

		for (int i = 0; i < parts.length; i++) {
			if (!this.contentTokens.contains(parts[i])) {
				this.contentTokens.add(parts[i]);
			}
		}
		Collections.sort(this.contentTokens);
		System.out.println("List after the use of" + " Collection.sort() :\n" + this.contentTokens);
		
		 for(String str : this.contentTokens ) {
			 int count = 0;
			 for(int i = 0 ; i<parts.length ; i++) {
				 if(str.equalsIgnoreCase(parts[i])) {
					 count++; 
				 }	 
			 }
			 wordFrequency.put(str, count);
		 }
		
	        Map<String, Integer> treeMap = new TreeMap<String, Integer>(wordFrequency);
	        for (String str : treeMap.keySet()) {
	            System.out.println(str);
	        }
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
		System.out.printf("Book       ID:%-2d |%-25s|%-25s|%-25s|%-7.2f$\n", this.getId(), this.getTitle(),
				this.getCategory(), this.getAuthors(), this.getCost());
	}

	public String toString() {
		System.out.println("Title: "+this.getTitle());
		System.out.println("Category: "+this.getCategory());
		System.out.println("Cost: "+ this.getCost());
		System.out.println("Author: " );
		for(String author :this.getAuthors()) {
			System.out.println(author);
		}
		System.out.println();
		Set<String> keys = this.getWordFrequency().keySet() ;
		for(String key : keys) {
			System.out.println(key+": " + this.getWordFrequency().get(key));
		}
		return null;
	}

	@Override
	public int compareTo(Object o) {
		try {
		Book book = (Book) o;
		if (book != null) {
			if (this.getCost() > book.getCost()) {
				return 1;
			} else
				return this.getTitle().compareToIgnoreCase(book.getTitle());
		}
		return -100;
		}catch(Exception e) {
			throw new ArithmeticException("Sonthing went wrong?? may be NullPointerException or ClassCastException");
		}

	}

}
/*String str = textField.getText();
try {
	if (!textField.getText().isEmpty()) {
		int idBook = Integer.parseInt(textField.getText());

		if (item.checkIdBook(idBook)) {
			item.order.get(i).addMedia(item.getBook(idBook));
		}else {
							JOptionPane.showMessageDialog(null, "this item doesn't have in store", "Error",
									JOptionPane.ERROR_MESSAGE);

						}
	} else {
		JOptionPane.showMessageDialog(null, "You havent enter Book ID", "Error",
				JOptionPane.ERROR_MESSAGE);
	}
} catch (Exception e1) {
	JOptionPane.showMessageDialog(null, "Invalid character", "Error", JOptionPane.ERROR_MESSAGE);
}

}
});*/
