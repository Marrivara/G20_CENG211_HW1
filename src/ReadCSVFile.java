import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 *  This class contains a method which is for read a specific line in csv file
 *  
 */

public class ReadCSVFile {

	public static String[] readcsvfile(String path, int lineIWant){
		
		String[] datas;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String specificLine;
			
			for (int i = 0; i<lineIWant; i++)
				reader.readLine();
			specificLine = reader.readLine();
			datas = specificLine.split(",");
			return datas;
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occured (FileNotFoundException");
		} catch (IOException e) {
			System.out.println("An error occured (IOException");
		}
		
		return null;
	}
	
	
	// This method is for learn how much line do we have in our csv file.
	public static int getLenght(String path){
		int lenght = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String howMuchLine = reader.readLine();
			
			while(howMuchLine != null) {
				lenght++;
				howMuchLine = reader.readLine(); }
			return lenght;
		} catch (FileNotFoundException e) {
			System.out.println("An error occured (FileNotFoundException");
		} catch (IOException e) {
			System.out.println("An error occured (IOException");
		}
		
		return 0;
	}
}
