package BusinessLayer;

import FileIO.FileReader;

import javax.xml.xpath.XPath;
import java.util.StringTokenizer;

public class DropShippingAppInitializer {

    Customer[] customers;

    public void initializeTheApp(){
        customers = setCustomerArray();
        Supplier[] suppliers = new Supplier[3];

        suppliers[0] = new Supplier(setProductArray("src/S1_Products.csv"));
        suppliers[1] = new Supplier(setProductArray("src/S2_Products.csv"));
        suppliers[2] = new Supplier(setProductArray("src/S3_Products.csv"));

        setSalesArray("src/S1_Sales.csv",suppliers[0].getProducts());
        setSalesArray("src/S2_Sales.csv",suppliers[1].getProducts());
        setSalesArray("src/S3_Sales.csv",suppliers[2].getProducts());
    }



    private Customer[] setCustomerArray(){
        FileReader file = new FileReader();
        String[] customersFromFile = file.getCustomersFromFile();

        Customer[] customers = new Customer[customersFromFile.length];

        for (int index = 1; index< customersFromFile.length; index++) {
            StringTokenizer line = new StringTokenizer(customersFromFile[index],",");
            customers[index - 1] = new Customer(line.nextToken(), line.nextToken(), line.nextToken(), line.nextToken(), line.nextToken());
        }
        return customers;
    }

    private Product[] setProductArray(String path){
        FileReader file = new FileReader();
        String[] productsFromFile = file.getProductsFromFile(path);

        Product[] products = new Product[productsFromFile.length];

        for (int index = 1; index< productsFromFile.length; index++) {
            StringTokenizer line = new StringTokenizer(productsFromFile[index],",");
            products[index - 1] = new Product(line.nextToken(), line.nextToken(), Double.parseDouble(line.nextToken()), Integer.parseInt(line.nextToken()), Double.parseDouble(line.nextToken()));
        }

        return products;
    }

    private void setSalesArray(String path, Product[] products) {
        FileReader file = new FileReader();
        String[] salesFromFile = file.getSalesFromFile(path);

        Sales[] sales = new Sales[salesFromFile.length];

        for (int index = 1; index< salesFromFile.length; index++) {
            StringTokenizer line = new StringTokenizer(salesFromFile[index],",");
            sales[index - 1] = new Sales(line.nextToken(), findCustomerById(line.nextToken()), findProductById(line.nextToken(),products), line.nextToken());
            System.out.println(sales[index - 1]);
        }
    }

    private Customer findCustomerById(String id) {
        Customer customer;

        for(int index =0; index < customers.length; index++){
            if (customers[index].getId().equals(id)){
                customer = customers[index];
                return customer;
            }
        }

        return null;
    }

    private Product findProductById(String id, Product[] products){
        Product product;
        for(int index = 0; index <products.length;index++ ) {
            if (products[index].getId().equals(id)) {
                product = products[index];
                return product;
            }
        }
        return null;
    }

}
