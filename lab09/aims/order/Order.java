package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	

	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private MyDate dateOrdered;
	private static int nbOrders = 0;
	private int orderId = 0;
	private static int count = 0 ;


	public Order() {

		if (nbOrders < MAX_LIMITED_ORDERS) {
			this.dateOrdered = new MyDate();
			nbOrders++;
		    this.setOrderId(++count);
		} else {
			System.out.println("you can make 5 orders only !!!");
			throw new ArithmeticException("Full order");
		}

	}
	
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(ArrayList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public static int getNbOrders() {
		return nbOrders;
	}

	public static void setNbOrders(int nbOrders) {
		Order.nbOrders = nbOrders;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int id) {
		this.orderId = id;
	}
	


	public void addMedia(Media obj) {
		this.itemsOrdered.add(obj);
		assert this.itemsOrdered.size() <= MAX_NUMBERS_ORDERED : "You can order 10 medias/order ";

	}

	public void addMedia(Media... dvdList) {
		for (int i = 0; i < dvdList.length; i++) {
			this.itemsOrdered.add(dvdList[i]);
			assert this.itemsOrdered.size() <= MAX_NUMBERS_ORDERED : "You can order 10 medias/order ";
		}

	}

	public void addMedia(Media obj1, Media obj2) {
		this.itemsOrdered.add(obj1);
		assert this.itemsOrdered.size() <= MAX_NUMBERS_ORDERED : "You can order 10 medias/order ";

		if (this.itemsOrdered.size() + 1 <= MAX_NUMBERS_ORDERED) {
			this.itemsOrdered.add(obj1);
		} else {
			System.out.println("Can't add more !!!");
			assert this.itemsOrdered.size() <= MAX_NUMBERS_ORDERED : "You can order 10 medias/order ";
		}

	}

	public void removeMedia(Media obj) {
		int n = this.itemsOrdered.indexOf(obj);
		if (n != -1) {
			this.itemsOrdered.remove(itemsOrdered.indexOf(obj));
		} else {
			System.out.println("this object doesn't exists");
		}

	}

	

	public void showOrder() {
		int i = 0;
		
		System.out.println("***********************Order***********************");
		for (Media a : this.itemsOrdered) {
			i++;
			System.out.printf(i+". ");
			a.Print();
		}
		System.out.println(this.totalCost());

		System.out.println("***************************************************");
	}

	public float totalCost() {
		float count = 0f;
		for (Media a : this.itemsOrdered) {
			count = count + a.getCost();

		}
		count = (float) Math.round(count * 100) / 100;
		return count;
	}
	
		

}
