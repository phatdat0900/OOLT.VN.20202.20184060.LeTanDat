package hust.soict.hedspi.aims.media;

public class Track implements Playable ,Comparable {
	private String title;
	private int length;
	private int id;
	private static int count = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Track() {
		super();
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
		this.setId(++count);
	}

	public Track getTrack(int id) {
		if (this.getId() == id)
			return this;
		return null;
	}

	public boolean equals(Object anObject) {

		if (anObject instanceof Track) {
			if (((Track) anObject).getLength() == this.getLength()
					&& ((Track) anObject).getTitle() == this.getTitle()) {
				
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Track track1 = new Track("Forget Me Nots (12'' Version)", 7);
		Track track2 = new Track("Oh Go", 3);
		Track track3 = new Track("Casio", 4);
		Track track4 = new Track("Blank Space", 5);
		CompactDisc cd = new CompactDisc();
		System.out.println(track1.equals(track2));
	}

	@Override
	public void play() {
		System.out.println("Playing CD ");

	}

	@Override
	public int compareTo(Object o) {
		Track track = (Track) o;
		if(track != null) {
			if(this.getLength()>track.getLength()) {
				return 1;
			}else if(this.getLength()<track.getLength()) {
				return -1;
			}else return this.getTitle().compareToIgnoreCase(track.getTitle());
		}
		return -100;
	}
}
