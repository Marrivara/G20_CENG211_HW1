import java.sql.Date;

public class Sales {
	
	private String ID;
	private Customer CustomerID;
	private Product ProductID;
	private Date Sales_Date;
	private double Sales_Price;
	
	public Sales(String id, Customer customerid, Product productid, Date sales_date) {
		this.ID = id;
		this.CustomerID = customerid;
		this.ProductID = productid;
		this.Sales_Date = sales_date;
		
		// Sales_Price = Price + (Rate / (5.0 * 100) * NumberOfReviews)
		this.Sales_Price = productid.getPrice() + (productid.getRate()/(5.0 * 100) * productid.getNumberOfReviews());
	}

	public String getID() {
		return ID;
	}

	public String getCustomer() {
		return CustomerID.getID();
	}

	public String getProduct() {
		return ProductID.getID();
	}

	public Date getSales_Date() {
		return Sales_Date;
	}

	public double getSales_Price() {
		return Sales_Price;
	}
	
}
