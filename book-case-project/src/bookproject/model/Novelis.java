package bookproject.model;

public class Novelis extends Author {
	private String rating;
	private boolean isSerial;
	
	public Novelis() {
		// TODO Auto-generated constructor stub
	}

	public Novelis(String firstName, String lastName, String country, int age, String rating, boolean isSerial) {
		super(firstName, lastName, country, age);
		this.rating = rating;
		this.isSerial = isSerial;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public boolean isSerial() {
		return isSerial;
	}

	public void setSerial(boolean isSerial) {
		this.isSerial = isSerial;
	}
	
	
}
