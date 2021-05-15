package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.*;

public class Aims1 {

	public static ArrayList<Book> bookList = new ArrayList<Book>();
	public static ArrayList<DigitalVideoDisc> DVDList = new ArrayList<DigitalVideoDisc>();
	public static ArrayList<CompactDisc> CDList = new ArrayList<CompactDisc>();
	public static ArrayList<Track> TrackList = new ArrayList<Track>();

	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		System.out.println("");

	}

	public static Book getBook(int id) {
		for (Book a : bookList) {
			if (bookList.indexOf(a.getMedia(id)) != -1) {
				return a;
			}
		}
		return null;
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

	public static Track getTrackInList() {
		Scanner scan = new Scanner(System.in);
		int id;
		id = scan.nextInt();
		System.out.println(id);
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

	public static void main(String[] args) throws LimitExceededException, PlayerException {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King", "Animation", "Roger Allers", 0, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);
		Book book1 = new Book("One Piece", "Action", "Oda", 18.99f);
		Book book2 = new Book("Harry Porter P1", "Adventure", "JK", 18.99f);
		CompactDisc cd1 = new CompactDisc("the Lion King", "pop", "Roger Allers", "taylor", 19.95f);
		CompactDisc cd2 = new CompactDisc(" King", "Rap", "Roger Allers", "Eminem", 19.95f);
		Track track1 = new Track("Forget Me Nots (12'' Version)", 0);
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
		TrackList.add(track1);
		TrackList.add(track2);
		TrackList.add(track3);
		TrackList.add(track4);
	

		Order[] anOrder = new Order[5];

		Scanner scan = new Scanner(System.in);
		int choice;
		int i = -1;
		Aims1 aim = new Aims1();
		for (;;) {
			aim.showMenu();

			do {
				System.out.println("you choose:");
				choice = scan.nextInt();
			} while (choice < 0 || choice > 4);
			switch (choice) {
			case 0:
				System.exit(0); // thoát chương trình
				break;
			case 1:
				i++;
				if (i < 5) {
					anOrder[i] = new Order();
					System.out.println(anOrder[i].nbOrders);
					System.out.println("You have make an order ID:" + anOrder[i].getOrderId());
					break;
				} else {
					System.out.println("You can make 5 orders only");
					break;
				}
			case 2:
				if (i > -1) {
					int choice2;
					System.out.println("What type of item do you want to order?");
					System.out.println("1:Book\t 2:CompactDisc\t 3:DigitalVideoDisc");
					choice2 = scan.nextInt();
					switch (choice2) {
					case 1:
						int idBook = 0;
						System.out.println("Enter object id:");
						idBook = scan.nextInt();

						if (checkIdBook(idBook)) {
							anOrder[i].addMedia(getBook(idBook));
							break;
						} else {
							System.out.println("Can't find this book");
							break;
						}
					case 2:
						int idCD = 0;
						System.out.println("Enter object id:");
						idCD = scan.nextInt();

						if (checkIdCD(idCD)) {
							anOrder[i].addMedia(getCD(idCD));
							System.out.println(getCD(idCD).getTitle());
							System.out.println("Do you want to add track??");
							System.out.println("1.Yes   2. No");
							int choice3;
							choice3 = scan.nextInt();
							if (choice3 == 1) {
								System.out.println("How many track do you want to add");
								int num;
								int j = 0;
								num = scan.nextInt();
								System.out.println("user enter track id:");
								do {

									j++;
									getCD(idCD).addTrack(getTrackInList());

								} while (j < num);

							} 
							System.out.println("Do you want to play: 1.play   2.end");
							int choice4;
							choice4 = scan.nextInt();
							if (choice4 == 1) {
								getCD(idCD).play();
							}
							break;
						} else {
							System.out.println("Can't find this CD");
							break;
						}
					case 3:
						int idDVD = 0;
						System.out.println("Enter object id:");
						idDVD = scan.nextInt();

						if (checkIdDVD(idDVD)) {
							anOrder[i].addMedia(getDVD(idDVD));
							System.out.println("Do you want to play: 1.play   2.end");
							int choice4;
							choice4 = scan.nextInt();
							if (choice4 == 1) {
								getDVD(idDVD).play();
							}
							break;
						} else {
							System.out.println("Can't find this DVD");
							break;
						}

					}

					break;

				} else {
					System.out.println("You haven't make an order");
					break;
				}

			case 3:
				if (i > -1) {
					int choice2;
					System.out.println("What type of item do you want to remove?");
					System.out.println("1:Book\t 2:CompactDisc\t 3:DigitalVideoDisc");
					choice2 = scan.nextInt();
					switch (choice2) {
					case 1:
						int idBook = 0;
						System.out.println("Enter object id:");
						idBook = scan.nextInt();

						if (checkIdBook(idBook)) {
							anOrder[i].removeMedia(getBook(idBook));
							break;
						} else {
							System.out.println("Can't find this book");
							break;
						}
					case 2:
						int idCD = 0;
						System.out.println("Enter object id:");
						idCD = scan.nextInt();

						if (checkIdCD(idCD)) {
							anOrder[i].removeMedia(getCD(idCD));
							break;
						} else {
							System.out.println("Can't find this CD");
							break;
						}
					case 3:
						int idDVD = 0;
						System.out.println("Enter object id:");
						idDVD = scan.nextInt();

						if (checkIdDVD(idDVD)) {
							anOrder[i].removeMedia(getDVD(idDVD));
							break;
						} else {
							System.out.println("Can't find this DVD");
							break;
						}

					}
					break;

				} else {
					System.out.println("You haven't make an order");
					break;
				}

			case 4:
				
				anOrder[i].showOrder();
				break;

			}

		}

	}


	/*
	 * public void unitTest1(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2,
	 * DigitalVideoDisc dvd3) { Order a = new Order(); a.addMedia(dvd1);
	 * a.showOrder();
	 * 
	 * Order b = new Order(); b.addMedia(dvd2, dvd3); b.showOrder();
	 * 
	 * Order c = new Order(); DigitalVideoDisc[] dvdList = { dvd1, dvd1, dvd1, dvd1,
	 * dvd1, dvd1, dvd1, dvd1, dvd2, dvd3 }; c.addMedia(dvdList); c.showOrder();
	 * 
	 * Order anORder = new Order(); Order anORDer = new Order(); Order anORder1 =
	 * new Order();
	 * 
	 * }
	 * 
	 * public void unitTest2(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2,
	 * DigitalVideoDisc dvd3) { Order anOrder = new Order(); anOrder.addMedia(dvd1);
	 * anOrder.addMedia(dvd1); anOrder.addMedia(dvd3); anOrder.removeMedia(dvd1);
	 * anOrder.removeMedia(dvd2); anOrder.showOrder();
	 * 
	 * }
	 * 
	 * public void unitTest3(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2,
	 * DigitalVideoDisc dvd3) {
	 * 
	 * Order anOrder = new Order(); DigitalVideoDisc[] dvdList = { dvd1, dvd1, dvd1,
	 * dvd1, dvd1, dvd1, dvd1, dvd1, dvd2 }; anOrder.addMedia(dvdList);
	 * anOrder.addMedia(dvd3, dvd1); anOrder.showOrder();
	 * 
	 * }
	 */

}
