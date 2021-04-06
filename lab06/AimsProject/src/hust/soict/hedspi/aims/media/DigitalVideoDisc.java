package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media {
	private int length;
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	public DigitalVideoDisc() {
		
	}

	public DigitalVideoDisc(String title) {
		super(title);
		
	}

	public DigitalVideoDisc(String title, String category) {
		super(title,category);
	   
	}

	public DigitalVideoDisc(String title, String category, String director) {
		super(title,category,director);
		
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,director,cost);
	}

	public DigitalVideoDisc(String title, String category, String director,int length,float cost) {
		super(title,category,director,cost);
		this.length = length;	
	}
	
	public  boolean search(String title) {
		int n =0;
		String[] str = this.getTitle().trim().split("\\s+");
		String[] SplitTitle = title.trim().split("\\s+");
		for(int i = 0; i <str.length;i++) {
			for(int j = 0;j<SplitTitle.length;j++) {
				if(str[i].toLowerCase().equals( SplitTitle[j].toLowerCase())) {
					n++;
					break;
				}
			}
		}
		if(n>=str.length) {//chua nhieu hon hoac = so token cua title
			System.out.println("true");
			return true;
		}else {
			System.out.println("false");
			return false;
		}
	}
	
	public void Print() {
		System.out.printf(" ID:%-2d |%-25s|%-25s|%-25s|%-25d|%-7.2f$\n",super.getId() ,super.getTitle(),super.getCategory(),super.getDirector(),this.getLength(),super.getCost());
	}

}
