package lap03;

public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	private static DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    static int n = 0;
    static DigitalVideoDisc removeItem  ;

	static void addDigitalVideoDisc(DigitalVideoDisc disc) {
		itemsOrdered[n++] = disc;
	}

	static void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int j, i;

		for (i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null) {
				if (disc == itemsOrdered[i]) {
					if (disc.getTitle().equals(itemsOrdered[i].getTitle())) {
						for (j = i; j < n; j++) {
							 removeItem = itemsOrdered[j];
							itemsOrdered[j] = itemsOrdered[j + 1];
						System.out.println(removeItem.getTitle());
						}

					}

				}
			}

		}
	}

	static float totalCost() {
		float count = 0;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null) {
				count += itemsOrdered[i].getCost();
			}	
		}
		return count;
	}
}
