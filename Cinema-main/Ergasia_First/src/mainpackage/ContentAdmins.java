package mainpackage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class ContentAdmins extends Users{
	
	public ContentAdmins(String name, String username, String password) {
		super(name, username, password);
	}
	public ContentAdmins() {
		
	}
	
	
	public void insertFilm() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter film ID: ");
		String filmId = scanner.nextLine();
		System.out.print("Enter film title: ");
		String filmTitle = scanner.nextLine();
		System.out.print("Enter film category: ");
		String filmCategory = scanner.nextLine();
		System.out.print("Enter film description: ");
		String filmDescription = scanner.nextLine();
		Films film = new Films(filmId, filmTitle, filmCategory, filmDescription);
		        
		try {
		    FileWriter writer = new FileWriter("moviesAll.txt", true);
		    writer.write(film.getFilmId() + "," + film.getFilmTitle() + "," + film.getFilmCategory() + "," + film.getFilmDescription());
		    writer.write(System.lineSeparator()); // add a newline character
		    writer.close();
		    System.out.println("Successfully appended to the file.");
		} catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();	                
		}        
		        
		

	}

	
	public void deleteFilm() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter film ID that you want to delete: ");
		String filmId = scanner.nextLine();
		boolean flag = true;
	    try {
	        File inputFile = new File("moviesAll.txt");
	        File tempFile = new File("moviesAll_temp.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

	        String currentLine;

	        while ((currentLine = reader.readLine()) != null) {
	            if (currentLine.startsWith(filmId + ",")) {
	            	flag = false;
	                continue;	                
	            }
	            
	            writer.println(currentLine);
	        }
	        writer.close();
	        reader.close();
	        
	        // delete the original file
	        inputFile.delete();

	        // rename the temporary file to the original file
	        tempFile.renameTo(inputFile);
	        if(flag) {
	        	System.out.println("Film with ID " + filmId + " has not been found.");
	        }else {
	        	System.out.println("Film with ID " + filmId + " has been deleted.");
	        }
	    } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
		
	}

	public void assignFilmToCinema() {
	
	}
	protected String getUserWho() {
		return "ContentAdmin";
	}

	
}