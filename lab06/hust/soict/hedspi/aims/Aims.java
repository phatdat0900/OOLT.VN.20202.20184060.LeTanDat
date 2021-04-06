package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import hust.soict.hedspi.aims.media.*;

public class Aims {

	public static ArrayList<Media> item = new ArrayList<Media>();

	public static void showMenu() {
		System.out.println("");
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");

	}

	public static Media getItem(int id) {
		for (Media a : item) {
			if (item.indexOf(a.getMedia(id)) != -1) {
				return a;
			}
		}
		return null;
	}

	public static boolean checkId(int id) {
		for (Media a : item) {
			if (item.indexOf(a.getMedia(id)) != -1) {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);
		Book book1 = new Book("One Piece", "Action", "Oda", 18.99f);
		Book book2 = new Book("Harry Porter P1", "Adventure", "JK", 18.99f);

		item.add(dvd1);
		item.add(dvd2);
		item.add(dvd3);
		item.add(book1);
		item.add(book2);

		Order[] anOrder = new Order[5];

		Scanner scan = new Scanner(System.in);
		int idItem;
		int choice;
		int i = -1;
		Aims aim = new Aims();
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
					System.out.println("You have make an order ID:" + anOrder[i].getOrderId());
					break;
				} else {
					System.out.println("You can make 5 orders only");
					break;
				}
			case 2:
				if (i > -1) {
					System.out.println("Enter object id:");
					idItem = scan.nextInt();
					if (checkId(idItem)) {
						anOrder[i].addMedia(getItem(idItem));
						break;
					} else {
						System.out.println("Can't find this item");
						break;
					}
				} else {
					System.out.println("You haven't make an order");
					break;
				}

			case 3:
				System.out.println("Enter object id:");
				idItem = scan.nextInt();
				if (checkId(idItem)) {
					anOrder[i].removeMedia(getItem(idItem));
					break;
				} else {
					System.out.println("Can't find this item");
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
