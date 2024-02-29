package bookproject.model;

import bookproject.abstracts.TaxCommercialBook;

public class Comic extends TaxCommercialBook {
	private boolean isVolumeSeries;
	
	public Comic() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Comic(String bookCode, String tilte, Mangaka author, Publisher publisher, double price, double tax,
			boolean isVolumeSeries) {
		super(bookCode, tilte, author, publisher, price, tax);
		this.isVolumeSeries = isVolumeSeries;
		//langsung hitung price
		calculatePrice();
		//hitung tax
		calculateTax();
	}

	@Override
	public void calculateTax() {
		double result = RATES_TAX * getPrice();
		setTax(result);
	}

	@Override
	public void calculatePrice() {
		double rates = 0;
		double result = 0;
		
		if (isVolumeSeries) {
			rates = RATES_RATING_MANGAKA_WITH_SERIES.get(((Mangaka)getAuthor()).getRating().toUpperCase());
		}else {
			rates = RATES_RATING_MANGAKA_WITH_NO_SERIES.get(((Mangaka)getAuthor()).getRating().toUpperCase());
		}
		
		result = rates * getPublisher().getProductionCost();
		
		setPrice(result);
	}


	public boolean isVolumeSeries() {
		return isVolumeSeries;
	}


	public void setVolumeSeries(boolean isVolumeSeries) {
		this.isVolumeSeries = isVolumeSeries;
	}
	
	
}
