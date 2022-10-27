package FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    private String[] customers;
    private String[] products;

    private String[] sales;


    public String[] getCustomersFromFile(){

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader("src/Customers.csv"));
            String line;
            int lengthOfFile;

            lengthOfFile = getLengthOfFile("src/Customers.csv");

            customers = new String[lengthOfFile];

            for (int i = 0; i<lengthOfFile; i++) {
                customers[i] = reader.readLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occured (FileNotFoundException");
        } catch (IOException e) {
            System.out.println("An error occured (IOException");
        }


        return customers;
    }



    public String[] getProductsFromFile(String path){
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
            String line;
            int lengthOfFile;

            lengthOfFile = getLengthOfFile(path);

            products = new String[lengthOfFile];

            for (int i = 0; i<lengthOfFile; i++) {
                products[i] = reader.readLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occured (FileNotFoundException");
        } catch (IOException e) {
            System.out.println("An error occured (IOException");
        }

        return products;
    }

    public String[] getSalesFromFile(String path){
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
            String line;
            int lengthOfFile;

            lengthOfFile = getLengthOfFile(path);

            sales = new String[lengthOfFile];

            for (int i = 0; i<lengthOfFile; i++) {
                sales[i] = reader.readLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occured (FileNotFoundException");
        } catch (IOException e) {
            System.out.println("An error occured (IOException");
        }

        return sales;
    }




    public int getLengthOfFile(String path){
        int lenght = 0;

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(path));
            String lineCounter = reader.readLine();

            while(lineCounter != null) {
                lenght++;
                lineCounter = reader.readLine(); }
            return lenght;
        } catch (FileNotFoundException e) {
            System.out.println("An error occured (FileNotFoundException");
        } catch (IOException e) {
            System.out.println("An error occured (IOException");
        }

        return 0;
    }
}
