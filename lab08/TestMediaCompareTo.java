package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class TestMediaCompareTo {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);
		Book book1 = new Book("One Piece", "Action", "Oda", 18.99f);
		Book book2 = new Book("Harry Porter P1", "Adventure", "JK", 18.99f);
		CompactDisc cd1 = new CompactDisc("the Lion King", "pop", "Roger Allers", "taylor", 19.95f);
		CompactDisc cd2 = new CompactDisc(" King", "Rap", "Roger Allers", "Eminem", 19.95f);
		Track track1 = new Track("Forget Me Nots (12'' Version)", 7);
		Track track2 = new Track("Oh Go", 3);
		Track track3 = new Track("Casio", 4);
		Track track4 = new Track("Blank Space", 5);
		Collection collection = new ArrayList();
		//collection.add(book2);
		//collection.add(book1);
		//collection.add(dvd1);
		//collection.add(dvd3);
		//collection.add(dvd2);
		//collection.add(cd1);
		//collection.add(cd2);
		collection.add(track1);
		collection.add(track2);
		collection.add(track3);
		collection.add(track4);
	
		
		Iterator iterator = collection.iterator();
		System.out.println("The DVDs in the list:");
		while(iterator.hasNext()) {
		  System.out.println(((Track) iterator.next()).getTitle());
			
		}
		java.util.Collections.sort((java.util.List)collection);
		iterator = collection.iterator();
		System.out.println(" new The DVDs in the list:");
		while(iterator.hasNext()) {
		  System.out.println(((Track) iterator.next()).getTitle());
			
		}
		
		
	}

}
