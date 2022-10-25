
public class Product {

	private String ID;
	private String Title;
	private double Rate; // Rate is out of 5.0.
	private int NumberOfReviews;
	private int Price; // currency: Turkish Liras
	
	public Product(String id, String title, double rate, int numberofreviews, int price) {
		this.ID = id;
		this.Title = title;
		this.Rate = rate;
		this.NumberOfReviews = numberofreviews;
		this.Price = price;
	}

	public String getID() {
		return ID;
	}

	public String getTitle() {
		return Title;
	}

	public double getRate() {
		return Rate;
	}

	public int getNumberOfReviews() {
		return NumberOfReviews;
	}

	public int getPrice() {
		return Price;
	}

}