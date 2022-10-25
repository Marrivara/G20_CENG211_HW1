
public class DropshippingApp {

	public static void main(String[] args) {
		
		// Costumer
		int CustomerLenght = ReadCSVFile.getLenght("src/Customers.csv");
		Customer[] customerArray = new Customer[CustomerLenght]; 			// Our customers will be in this Array
		String[] Customer_adder;
		
		for (int index=1; index < CustomerLenght; index++) {
			Customer_adder = ReadCSVFile.readcsvfile("src/Customers.csv", index);
			Customer customer = new Customer(Customer_adder[0], Customer_adder[1], Customer_adder[2], Customer_adder[3], Customer_adder[4]);
			customerArray[index] = customer;
			System.out.println(customer.getCountry());
			}
	}

}