package bookproject.abstracts;

import bookproject.model.Author;
import bookproject.model.Publisher;

public abstract class Book {
	private String bookCode;
	private String tittle;
	private Author author;
	private Publisher publisher;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String bookCode, String tittle, Author author, Publisher publisher) {
		super();
		this.bookCode = bookCode;
		this.tittle = tittle;
		this.author = author;
		this.publisher = publisher;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
	
}
