package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable,Comparable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	private static int count = 0 ;
	
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public CompactDisc() {
		super();
		
		
	}

	public CompactDisc(String title) {
		super(title);
		
	}

	public CompactDisc(String title, String category) {
		super(title, category);
		

	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		

	}

	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		
	}

	
	public CompactDisc(String title, String category, String director,String artist, float cost) {
		super(title, category, director, cost);
		this.artist=artist;
		this.setId(++count);
	}
	
	public void addTrack(Track track) {
		tracks.add(track);
	}

	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
		tracks.remove(track);
		}else {
			System.out.println("This track haven't been added");
		}

	}
	
	
	public int getLength() {
		int sum = 0;
		for(Track track : tracks) {
			sum = sum +track.getLength();
		}
		this.length=sum;
		return this.length;
		
	}
	
	public void Print() {
		System.out.printf("CD    ID:%-2d |%-25s|%-25s|%-25s|%-25d|%-7.2f$\n", super.getId(), super.getTitle(),
				super.getCategory(), this.getArtist(),this.getLength(), super.getCost());
		
	
	}


	
	public static void main(String[] args) {
		Track track1 = new Track("Forget Me Nots (12'' Version)",7);
		Track track2 = new Track("Oh Go",3);
		Track track3 = new Track("Casio",4);
		Track track4 = new Track("Blank Space",5);
		
		CompactDisc cd = new CompactDisc("the Lion King", "pop", "Roger Allers","taylor" , 19.95f);
		cd.addTrack(track1);
		cd.addTrack(track2);
		cd.addTrack(track3);
		cd.addTrack(track4);
		cd.Print();
		CompactDisc cd1 = new CompactDisc("the Lion King", "pop", "Roger Allers","taylor" , 19.95f);
		cd1.addTrack(track1);
		
		System.out.println(cd1.compareTo(cd));
		
		
		
		
	}

	@Override
	public void play() {
		for(Track track : tracks) {
			track.play();
		}
		
	}

	@Override
	public int compareTo(Object o) {
		
		CompactDisc cd = (CompactDisc) o;
		Object []track1 = this.tracks.toArray();
		Object []track2 = cd.tracks.toArray();
		if (cd != null) {
			if (track1.length > track2.length) {
				return 1;
			} else if (track1.length < track2.length) {
				return -1;
			}
			if (this.getLength() > cd.getLength()) {
				return 1;
			} else if (this.getLength() < cd.getLength()) {
				return -1;
			} else
				return this.getTitle().compareToIgnoreCase(cd.getTitle());
		}
		return -100;
		
	}
	
	

}
