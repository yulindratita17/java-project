package bookproject.model;

import java.util.HashMap;
import java.util.Map;

import bookproject.abstracts.CommercialBook;

public class Novel extends CommercialBook {
	private String genre;
	
	public Novel() {
		// TODO Auto-generated constructor stub
	}

	public Novel(String bookCode, String tilte, Novelis author, Publisher publisher, double price, String genre) {
		super(bookCode, tilte, author, publisher, price);
		this.genre = genre;
		calculatePrice();
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public void calculatePrice() {
		double rates = RATES_RATING_NOVELIS.get(((Novelis)getAuthor()).getRating().toUpperCase());		
		double result = rates * getPublisher().getProductionCost();
		setPrice(result);
	}

}
