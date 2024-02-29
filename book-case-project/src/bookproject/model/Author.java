package bookproject.model;

import bookproject.abstracts.Person;

public class Author extends Person{
	private String country;
	private int age;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Author(String firstName, String lastName, String country, int age) {
		super(firstName, lastName);
		this.country = country;
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return getLastName() + ", " +getFirstName();
	}


	@Override
	public String toString() {
		return "Author [country=" + country + ", age=" + age + ", getFullName()=" + getFullName() + "]";
	}

}
