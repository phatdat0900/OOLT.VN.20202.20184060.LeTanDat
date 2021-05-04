package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.hedspi.aims.media.*;

public class Aims {
	

	protected static int i = -1;
	protected Order[] anOrder = new Order[5];
	protected static Aims window = new Aims();
	private JButton JButton2 = new JButton("Exit");
	
	

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
	
	


	
	
	
	

	public static void main(String[] args) {
		
		
	
		
		

		
	
	
		//Aims aim = new Aims();
		//for (;;) {
			//aim.showMenu();

			/*do {
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

			}*/

		//}

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
