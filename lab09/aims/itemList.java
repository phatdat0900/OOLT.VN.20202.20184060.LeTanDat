package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

public class itemList {
	public static ArrayList<Order> order = new ArrayList<Order>();
	public static ArrayList<Book> bookList = new ArrayList<Book>();
	public static ArrayList<DigitalVideoDisc> DVDList = new ArrayList<DigitalVideoDisc>();
	public static ArrayList<CompactDisc> CDList = new ArrayList<CompactDisc>();
	public static ArrayList<Track> TrackList = new ArrayList<Track>();
	
	public void addOrder(Order or) {
		 order.add(or);
	}
	
	public static DigitalVideoDisc getDVD(int id) {
		for (DigitalVideoDisc a : DVDList) {
			if (DVDList.indexOf(a.getMedia(id)) != -1) {
				return a;
			}
		}
		return null;
	}

	public static CompactDisc getCD(int id) {
		for (CompactDisc a : CDList) {
			if (CDList.indexOf(a.getMedia(id)) != -1) {
				return a;
			}
		}
		return null;
	}
	
	public static Book getBook(int id) {
		for (Book a : bookList) {
			if (bookList.indexOf(a.getMedia(id)) != -1) {
				return a;
			}
		}
		return null;
	}
	public static Track getTrackInList(int id) {
		for (Track a : TrackList) {
			if (TrackList.indexOf(a.getTrack(id)) != -1) {
				return a;
			}
		}
		return null;
	}

	public static boolean checkIdBook(int id) {
		for (Book a : bookList) {
			if (bookList.indexOf(a.getMedia(id)) != -1) {
				return true;
			}
		}
		return false;

	}

	public static boolean checkIdDVD(int id) {
		for (DigitalVideoDisc a : DVDList) {
			if (DVDList.indexOf(a.getMedia(id)) != -1) {
				return true;
			}
		}
		return false;

	}

	public static boolean checkIdCD(int id) {
		for (CompactDisc a : CDList) {
			if (CDList.indexOf(a.getMedia(id)) != -1) {
				return true;
			}
		}
		return false;

	}
	
	public itemList() {
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		addOrder(order1);
		addOrder(order2);
		addOrder(order3);
		
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
		// cd1.addTrack(track1);

		DVDList.add(dvd1);
		DVDList.add(dvd2);
		DVDList.add(dvd3);
		bookList.add(book1);
		bookList.add(book2);
		CDList.add(cd1);
		CDList.add(cd2);
		TrackList.add(track1);
		TrackList.add(track2);
		TrackList.add(track3);
		TrackList.add(track4);
	}
	

}
