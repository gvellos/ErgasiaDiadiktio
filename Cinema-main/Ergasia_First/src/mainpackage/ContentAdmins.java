package mainpackage;
import java.io.File;
import java.util.ArrayList;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class ContentAdmins extends Users{
	
	public ContentAdmins(String name, String username, String password) {
		super(name, username, password);
	}
	
	
	public void insertFilm(int movieId, String movieName, String movieCategory, String movieDescription) {
		try {
			File file = new File("id.txt");
			if(file.exists());
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter("id.txt", true));
				writer.write(Integer.toString(movieId));
				writer.newLine();
				writer.close();
				System.out.println("Id " + movieId + " inserted Succesfully!");
			}
		}
			catch (IOException e) {
				e.printStackTrace();
			}
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("movies.txt", true));
			writer.write(movieName);
			writer.newLine();
			writer.close();
			System.out.println("Movie " + movieName + " inserted Succesfully!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			File file = new File("category.txt");
			if(file.exists());
			{
			BufferedWriter writer = new BufferedWriter(new FileWriter("category.txt", true));
			writer.write(movieCategory);
			writer.newLine();
			writer.close();
			System.out.println("Category " + movieCategory + " inserted Succesfully!");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			File file = new File("category.txt");
			if(file.exists());
			{
			BufferedWriter writer = new BufferedWriter(new FileWriter("description.txt", true));
			writer.write(movieDescription);
			writer.newLine();
			writer.close();
			System.out.println("Description " + movieDescription + " inserted Succesfully!");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteFilm() {
		
	}

	public void assignFilmToCinema() {
	
	}

	
}
