package hust.soict.hedspi.aims;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {
	public static void main(String[] args) throws LimitExceededException {
		Aims1 aim = new Aims1();
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
	public static void unitTest2(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2, DigitalVideoDisc dvd3) throws LimitExceededException {
	
		Order order1 = new Order();
	    order1.addMedia(dvd1);
	    order1.addMedia(dvd2);
	    order1.addMedia(dvd3);
	    order1.addMedia(dvd2);
	    //order1.getALuckyItem();
	    order1.showOrder();
	    
	    Order anOrder = new Order();
		anOrder.addMedia(dvd1);
		anOrder.addMedia(dvd2);
		anOrder.addMedia(dvd2);
		anOrder.addMedia(dvd3);
		anOrder.showOrder();
		
		assert  order1.totalCost()!=anOrder.totalCost() :"something wrong";
	    
		
		
		
	}
	
	

}
