package bookproject.abstracts;

import bookproject.interfaces.ICommercialBook;
import bookproject.model.Author;
import bookproject.model.Publisher;

public abstract class CommercialBook extends Book implements ICommercialBook {
	private double price;
	
	public CommercialBook() {
		// TODO Auto-generated constructor stub
	}

	public CommercialBook(String bookCode, String tittle, Author author, Publisher publisher, double price) {
		super(bookCode, tittle, author, publisher);
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ComercialBook [price=" + price + ", getPrice()=" + getPrice() + ", getBookCode()=" + getBookCode()
				+ ", getTilte()=" + getTittle() + ", getAuthor()=" + getAuthor() + ", getPublisher()=" + getPublisher()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
