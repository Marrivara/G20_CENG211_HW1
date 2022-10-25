
public class Customer {
	
	private String ID;
	private String Name;
	private String Email;
	private String Country;
	private String Address;
	
	public Customer(String id, String name, String email, String country, String address) {
		this.ID = id;
		this.Name = name;
		this.Email = email;
		this.Country = country;
		this.Address = address;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return Name;
	}
	
	public String getEmail() {
		return Email;
	}

	public String getCountry() {
		return Country;
	}

	public String getAddress() {
		return Address;
	}

}
