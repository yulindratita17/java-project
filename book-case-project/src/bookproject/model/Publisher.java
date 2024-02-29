package bookproject.model;

public class Publisher {
	private String publisherName;
	private String country;
	private double productionCost;
	
	public Publisher() {
		// TODO Auto-generated constructor stub
	}

	public Publisher(String publisherName, String country, double productionCost) {
		super();
		this.publisherName = publisherName;
		this.country = country;
		this.productionCost = productionCost;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getProductionCost() {
		return productionCost;
	}

	public void setProductionCost(double productionCost) {
		this.productionCost = productionCost;
	}
	
	
}
