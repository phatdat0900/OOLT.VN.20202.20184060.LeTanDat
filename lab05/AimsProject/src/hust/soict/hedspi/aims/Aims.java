package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.order.*;

public class Aims {
	public static void main(String[] args) {
		Aims aim = new Aims();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);
		
		aim.unitTest1(dvd1, dvd2, dvd3);
		System.out.println("order success");

	}

	public void unitTest1(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2, DigitalVideoDisc dvd3) {
		Order a = new Order();
		a.addDigitalVideoDisc(dvd1);
		a.showOrder();

		Order b = new Order();
		b.addDigitalVideoDisc(dvd2, dvd3);
		b.showOrder();

		Order c = new Order();
		DigitalVideoDisc[] dvdList = { dvd1, dvd1, dvd1, dvd1, dvd1, dvd1, dvd1, dvd1, dvd2, dvd3 };
		c.addDigitalVideoDisc(dvdList);
		c.showOrder();

		Order anORder = new Order();
		Order anORDer = new Order();
		Order anORder1 = new Order();

	}

	public void unitTest2(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2, DigitalVideoDisc dvd3) {
		Order anOrder = new Order();
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.showOrder();

		assert !anOrder.getitemsOrdered(1).equals(anOrder.getitemsOrdered(2)) : " mua thanh cong 2 dia giong nhau";
		assert anOrder.getitemsOrdered(0).equals(anOrder.getitemsOrdered(1)) : "mua thanh cong 2 dia khac nhau";

	}

	public void unitTest3(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2, DigitalVideoDisc dvd3) {
		Order anOrder = new Order();
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.removeDigitalVideoDisc(dvd1);
		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.showOrder();

		assert anOrder.removeDisc.equals(dvd2) : " khong xoa thanh cong dia nay";

	}

	public void unitTest4(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2, DigitalVideoDisc dvd3) {

		Order anOrder = new Order();
		DigitalVideoDisc[] dvdList = { dvd1, dvd1, dvd1, dvd1, dvd1, dvd1, dvd1, dvd1, dvd2 };
		anOrder.addDigitalVideoDisc(dvdList);
		anOrder.addDigitalVideoDisc(dvd3, dvd1);

		anOrder.showOrder();
		assert anOrder.removeDisc.equals(dvd1) : " khong xoa thanh cong dia nay";
	}

}
