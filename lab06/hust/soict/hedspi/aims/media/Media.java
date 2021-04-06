package hust.soict.hedspi.aims.media;



public class Media {
	protected String title;
	protected String category;
	protected String director;
	protected float cost;
	protected int id;
	private static int count = 0 ;

	Media() {
		super();
		
		
	}

	Media(String title) {
		this.title = title;
		this.setId(++count);
		

	}

	Media(String title, String category) {
		this(title);
		this.category = category;
		
	}

	public Media(String title, String category, String director) {
		this(title, category);
		this.director = director;
		
	}

	public Media(String title, String category, String director, float cost) {
		this(title, category, director);
		this.cost = cost;
		
	}
		



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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media getMedia(int id) {
		if (this.getId() == id)
			return this;
		return null;
	}

	public void Print() {
		System.out.printf("ID:%-2d |%-25s|%-25s|%-25s|%-7.2f$\n",this.getId() ,this.getTitle(),this.getCategory(),this.getDirector(),this.getCost());
	}

}
