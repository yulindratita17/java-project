package bookproject.model;

import bookproject.abstracts.CommercialBook;

public class EBook extends CommercialBook {
	
	public EBook() {
		// TODO Auto-generated constructor stub
	}

	public EBook(String bookCode, String tilte, Author author, Publisher publisher, double price) {
		super(bookCode, tilte, author, publisher, price);
		// TODO Auto-generated constructor stub
		calculatePrice();
	}

	@Override
	public void calculatePrice() {
		double result = getPublisher().getProductionCost() * RATES_E_BOOK;
		setPrice(result);
	}

}
