package lab04;

public class Aims {
	public static void main(String[] args) {
		
		
		
		//DigitalVideoDisc[] dvdList = {dvd2};
		//anOrder.addDigitalVideoDisc(dvdList);
	   // anOrder.removeDigitalVideoDisc(dvd1);
		//anOrder.addDigitalVideoDisc(dvd1,dvd2);
		//anOrder.addDigitalVideoDisc(dvd1);
		//anOrder.addDigitalVideoDisc(dvd2);
				//anOrder.addDigitalVideoDisc(dvd2);
		//anOrder.showOrder(anOrder);
		//anOrder.addDigitalVideoDisc(dvd3);
		//assert Order.removeItem == dvd2:"error"; 
		unitTest4();
		
	
	
	}
	
	public static void unitTest1(){
		Order anOrder = new Order();
		Order AnOrder = new Order();
		Order aNOrder = new Order();
		Order anORder = new Order();
		Order anORDer = new Order();
		Order anORder1 = new Order();
	
		
	}
	public static void unitTest2(){
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King","Animation","Roger Allers",87,19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",124,24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation","John Musker",90,18.99f);
		Order anOrder = new Order();
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		
		anOrder.showOrder();
		
	}
	public static void unitTest3(){
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King","Animation","Roger Allers",87,19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("the Lion King","Science Fiction","George Lucas",124,24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation","John Musker",90,18.99f);
		
		Order anOrder = new Order();
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd2);
		
		anOrder.removeDigitalVideoDisc(dvd1);
		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		
		
		anOrder.showOrder();
		
	}
	
	public static void unitTest4(){
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King","Animation","Roger Allers",87,19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",124,24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation","John Musker",90,18.99f);
		Order anOrder = new Order();
		DigitalVideoDisc[] dvdList = {dvd1,dvd1,dvd1,dvd1,dvd1,dvd1,dvd1,dvd1,dvd2,dvd3,dvd1};
		anOrder.addDigitalVideoDisc(dvdList);
		
		anOrder.showOrder();
	}
	
	public static void unitTest5(){
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King","Animation","Roger Allers",87,19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",124,24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation","John Musker",90,18.99f);
		Order anOrder = new Order();
		DigitalVideoDisc[] dvdList = {dvd1,dvd1,dvd1,dvd1,dvd1,dvd1,dvd1,dvd1,dvd2};
		anOrder.addDigitalVideoDisc(dvdList);
		anOrder.addDigitalVideoDisc(dvd3,dvd1);
		
		
		anOrder.showOrder();
	}
	
	
	
	
	
}
