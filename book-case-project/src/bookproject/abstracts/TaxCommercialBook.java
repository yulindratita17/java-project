package bookproject.abstracts;

import bookproject.interfaces.ITax;
import bookproject.model.Author;
import bookproject.model.Publisher;

public abstract class TaxCommercialBook extends CommercialBook implements ITax {
	private double tax;
	
	public TaxCommercialBook() {
		// TODO Auto-generated constructor stub
	}

	public TaxCommercialBook(String bookCode, String tilte, Author author, Publisher publisher, double price,
			double tax) {
		super(bookCode, tilte, author, publisher, price);
		this.tax = tax;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	
}
