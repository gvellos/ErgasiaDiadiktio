package userpackage;
import java.util.ArrayList;
import java.util.Scanner;

import filmspackage.Films;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.BufferedWriter;

public class Customers extends Users{
	
//	ArrayList<String> filmsList = new ArrayList<>();
//	ArrayList<Films> test = new ArrayList<>();
	
	public Customers(String name, String username, String password) {
		super(name, username, password);
		
	}
	
	public ArrayList<Films> showAvailableFilms() {

		
		ArrayList<Films> films = new ArrayList<>();	
		try (Scanner scanner = new Scanner(new File("moviesAll.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String filmId = parts[0];
                String filmTitle = parts[1];
                String filmCategory = parts[2];
                String filmDescription = parts[3];
                Films film = new Films(filmId, filmTitle, filmCategory, filmDescription);
                films.add(film);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } 		
		return films; 
	}
	
	/*public void makeReservation(filmName, seats) {
		
	}*/
	
	public void viewReservation() {
		
	}
	protected String getUserWho() {
		return "Customers";
	}

}
