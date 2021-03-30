package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.utils.*;

public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	private MyDate dateOrdered;
	private static int nbOrders = 0;
	public DigitalVideoDisc removeDisc;

	public Order() {

		if (nbOrders < MAX_LIMITED_ORDERS) {
			this.dateOrdered = new MyDate();
			nbOrders++;
		} else {
			System.out.println("you can make 5 orders only !!!");
			throw new ArithmeticException("Full order");
		}

	}

	public DigitalVideoDisc getitemsOrdered(int i) {
		return itemsOrdered[i];
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
				if (this.itemsOrdered[i] == null) {
					this.itemsOrdered[i] = new DigitalVideoDisc(disc.getTitle(), disc.getCategory(), disc.getDirector(),
							disc.getLength(), disc.getCost());
					this.qtyOrdered++;
					break;
				}
			}

		} else {
			throw new AssertionError("You can order 10 disc/order ");
		}

	}

	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		int max = Math.subtractExact(MAX_NUMBERS_ORDERED, this.qtyOrdered);
		if (dvdList.length > 0 && dvdList.length <= max) {

			for (int i = 0; i < dvdList.length; i++) {
				for (int j = 0; j < MAX_NUMBERS_ORDERED; j++) {
					if (this.itemsOrdered[j] == null) {
						this.itemsOrdered[j] = new DigitalVideoDisc(dvdList[i].getTitle(), dvdList[i].getCategory(),
								dvdList[i].getDirector(), dvdList[i].getLength(), dvdList[i].getCost());
						this.qtyOrdered++;
						break;
					}
				}

			}

		} else {
			throw new AssertionError("You can order 10 disc/order ");
		}

	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
				if (this.itemsOrdered[i] == null) {
					this.itemsOrdered[i] = new DigitalVideoDisc(disc1.getTitle(), disc1.getCategory(),
							disc1.getDirector(), disc1.getLength(), disc1.getCost());
					this.qtyOrdered++;
					if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
						this.itemsOrdered[i + 1] = new DigitalVideoDisc(disc2.getTitle(), disc2.getCategory(),
								disc2.getDirector(), disc2.getLength(), disc2.getCost());
					} else {
						this.removeDisc = disc2;
						System.out.println("The dvd " + disc2.getTitle() + " could not be added !!!");
					}
					break;
				}
			}

		} else {
			throw new AssertionError("You can order 10 disc/order ");
		}

	}

	public void showOrder() {
		System.out.println("***********************Order***********************");
		System.out.print("Date: ");
		this.dateOrdered.print();
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (this.itemsOrdered[i] != null) {

				System.out.println((i + 1) + ". DVD - " + this.itemsOrdered[i].getTitle() + " - "
						+ this.itemsOrdered[i].getCategory() + " - " + this.itemsOrdered[i].getDirector() + " - "
						+ this.itemsOrdered[i].getLength() + " - " + this.itemsOrdered[i].getCost());
			}
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("**************************************************");
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int j, i, n;
		n = this.itemsOrdered.length - 1;
		for (i = 0; i < this.itemsOrdered.length; i++) {
			if (this.itemsOrdered[i] != null) {
				if (disc.getTitle().equals(this.itemsOrdered[i].getTitle())) {
					this.removeDisc = this.itemsOrdered[i];

					for (j = i; j < n; j++) {
						this.itemsOrdered[j] = this.itemsOrdered[j + 1];

					}
					this.itemsOrdered[qtyOrdered - 1] = null;
					this.qtyOrdered--;
					break;
				}
				if (i == this.qtyOrdered - 1) {
					if (disc.getTitle().equals(this.itemsOrdered[i].getTitle()) == false) {
						System.out.println("You haven't order this dvd yet");
					}

				}

			}

		}

	}

	public float totalCost() {
		float count = 0f;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (this.itemsOrdered[i] != null) {
				count = count + this.itemsOrdered[i].getCost();
			}
		}
		count = (float) Math.round(count * 100) / 100;
		return count;
	}

	public DigitalVideoDisc getALuckyItem() {
		int ran=(int)( Math.random()*(this.qtyOrdered));
		System.out.println(ran);

		this.itemsOrdered[ran].setCost(0f);
		return this.itemsOrdered[ran];
	}

}
