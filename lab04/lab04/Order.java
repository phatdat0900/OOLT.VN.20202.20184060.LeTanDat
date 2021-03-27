package lab04;

public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	private  DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
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
	
	public DigitalVideoDisc getitemsOrdered(int i){
		return itemsOrdered[i];	
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
				if (itemsOrdered[i] == null) {
					itemsOrdered[i] = disc;
					qtyOrdered++;
					break;
				}
			}

		} else {
			throw new AssertionError("You can order 10 disc/order ");
		}

	}

	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		int max = Math.subtractExact(MAX_NUMBERS_ORDERED, qtyOrdered);
		if (dvdList.length > 0 && dvdList.length <= max) {

			for (int i = 0; i < dvdList.length; i++) {
				for (int j = 0; j < MAX_NUMBERS_ORDERED; j++) {
					if (itemsOrdered[j] == null) {
						itemsOrdered[j] = dvdList[i];
						qtyOrdered++;
						break;
					}
				}

			}

		} else {
			throw new AssertionError("You can order 10 disc/order ");
		}

	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
				if (itemsOrdered[i] == null) {
					itemsOrdered[i] = disc1;
					qtyOrdered++;
					if (qtyOrdered < MAX_NUMBERS_ORDERED) {
						itemsOrdered[i + 1] = disc2;
					}
					else {
						removeDisc=disc2;
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
			if (itemsOrdered[i] != null) {
				
				System.out.println((i+1)+". DVD - " + this.itemsOrdered[i].getTitle() + " - " + this.itemsOrdered[i].getCategory() + " - "
						+ this.itemsOrdered[i].getDirector() + " - " + this.itemsOrdered[i].getLength() + " - "
						+ this.itemsOrdered[i].getCost());
			}
		}
		System.out.println("Total cost: "+ this.totalCost());
		System.out.println("**************************************************");
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int j, i, n;
		n = itemsOrdered.length - 1;
		for (i = 0; i < itemsOrdered.length; i++) {
			if (itemsOrdered[i] != null) {
				if (disc.getTitle().equals(itemsOrdered[i].getTitle())) {
					removeDisc= itemsOrdered[i];
					
					for (j = i; j < n; j++) {
						itemsOrdered[j] = itemsOrdered[j + 1];

					}
					itemsOrdered[qtyOrdered - 1] = null;
					qtyOrdered--;
					break;
				}
				if (i == qtyOrdered - 1) {
					if (disc.getTitle().equals(itemsOrdered[i].getTitle()) == false) {
						System.out.println("You haven't order this dvd yet");
					}

				}

			}

		}

	}

	public float totalCost() {
		float count = 0f;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null) {
				count = count + itemsOrdered[i].getCost();
			}
		}
		count = (float) Math.round(count * 100) / 100;
		return count;
	}

}
