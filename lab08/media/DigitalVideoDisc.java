package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable, Comparable {
	private static int count = 0;

	public DigitalVideoDisc() {
		super();
	}

	public DigitalVideoDisc(String title) {
		super(title);

	}

	public DigitalVideoDisc(String title, String category) {
		super(title, category);

	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);

	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);

	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		this.setId(++count);

	}

	public boolean search(String title) {
		int n = 0;
		String[] str = this.getTitle().trim().split("\\s+");
		String[] SplitTitle = title.trim().split("\\s+");
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < SplitTitle.length; j++) {
				if (str[i].toLowerCase().equals(SplitTitle[j].toLowerCase())) {
					n++;
					break;
				}
			}
		}
		if (n >= str.length) {// chua nhieu hon hoac = so token cua title
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}

	public void Print() {
		System.out.printf("DVD    ID:%-2d |%-25s|%-25s|%-25s|%-25d|%-7.2f$\n", super.getId(), super.getTitle(),
				super.getCategory(), this.getDirector(), this.getLength(), super.getCost());
	}
	
	


	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());

	}

	@Override
	public int compareTo(Object o) {
		DigitalVideoDisc dvd = (DigitalVideoDisc) o;
		if (dvd != null) {
			if (this.getCost() > dvd.getCost()) {
				return 1;
			} else if (this.getCost() < dvd.getCost()) {
				return -1;
			}
			if (this.getLength() > dvd.getLength()) {
				return 1;
			} else if (this.getLength() < dvd.getLength()) {
				return -1;
			} else
				return this.getTitle().compareToIgnoreCase(dvd.getTitle());
		}
		return -100;
	}

}
