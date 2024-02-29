package bookproject.model;

import java.util.ArrayList;
import java.util.List;

import bookproject.abstracts.Book;
import bookproject.abstracts.CommercialBook;
import bookproject.interfaces.ICommercialBook;

public class SearchData {
	
	public static List<Author> getAllAuthorByCountry(List<CommercialBook> listAllBook, String country){
		List<Author> listAuthor = new ArrayList<Author>();
		
		//validasi dan filtering data
		for (CommercialBook book : listAllBook) {
			if (book.getAuthor() instanceof Mangaka) {
				if (book.getAuthor().getCountry().equalsIgnoreCase(country)) {
					if (!(listAuthor.contains(book.getAuthor()))) {
						listAuthor.add(book.getAuthor());
					}			
				}
			}
			
		}
		
		return listAuthor;
	}
}
