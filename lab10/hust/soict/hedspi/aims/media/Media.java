package hust.soict.hedspi.aims.media;

import javax.swing.JOptionPane;

public class Media {
	protected String title;
	protected String category;
	protected float cost;
	protected int id;
	protected String Type;

	public Media() {
		super();

	}

	Media(String title) {
		this.title = title;

	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	Media(String title, String category) {
		this(title);
		this.category = category;

	}

	public Media(String title, String category, float cost) {
		this(title, category);
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
		System.out.printf("ID:%-2d |%-25s|%-25s|%-25s|%-7.2f$\n", this.getId(), this.getTitle(), this.getCategory(),
				this.getCost());
	}

	public boolean equals(Object anObject) {
		try {
		if (anObject instanceof Media) {
			if (((Media) anObject).getTitle().equals(null) || this.getTitle().equals(null)) {
				throw new ArithmeticException(" title is null");
			} else {
				if (((Media) anObject).getTitle() == this.getTitle()
						&& ((Media) anObject).getCost() == this.getCost()) {
					return true;
				} else {
					return false;
				}
			}

		}
		return false;
		}catch(Exception e) {
			throw new ArithmeticException("Sonthing went wrong?? may be NullPointerException or ClassCastException");
		}
	}

}
