package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {
	public static void main(String[] args) {
		Aims aim = new Aims();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);
		
	    
		unitTest2(dvd1,dvd2,dvd3);
	}
	public static void unitTest1(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2, DigitalVideoDisc dvd3) {
		assert  dvd1.search("The Lion kill The King") :"false";
		assert dvd2.search("Star Wars") :"false";
		assert dvd3.search("A"):"false";
	}
	public static void unitTest2(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2, DigitalVideoDisc dvd3) {
	
		Order order1 = new Order();
	    order1.addDigitalVideoDisc(dvd1);
	    order1.addDigitalVideoDisc(dvd2);
	    order1.addDigitalVideoDisc(dvd3);
	    order1.addDigitalVideoDisc(dvd2);
	    order1.getALuckyItem();
	    order1.showOrder();
	    
	    Order anOrder = new Order();
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.showOrder();
		
		assert  order1.totalCost()!=anOrder.totalCost() :"something wrong";
	    
		
		
		
	}
	
	

}
