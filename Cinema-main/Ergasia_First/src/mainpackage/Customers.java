package mainpackage;
import java.util.ArrayList;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.BufferedWriter;

public class Customers extends Users{
	
	ArrayList<String> filmsList = new ArrayList<>();
	
	public Customers(String name, String username, String password) {
		super(name, username, password);
		
	}
	
	public ArrayList<String> showAvailableFilms() {
		try {
			File file = new File("movies.txt");
			if(file.exists());
			{
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = "";
				while ((line = reader.readLine()) != null){
					filmsList.add(line);
	            }
				reader.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return filmsList;
	}
	
	/*public void makeReservation(filmName, seats) {
		
	}*/
	
	public void viewReservation() {
		
	}

}
