package diadiktioErgasia1;
import java.util.Scanner;

import filmspackage.Films;
import filmspackage.Cinemas;
import userpackage.Admins;
import userpackage.ContentAdmins;
import userpackage.Customers;
import userpackage.Users;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		int response, response1;
		String password, username, name;
		Cinemas cinema1 = new Cinemas("cinema1", false, "100");
		Cinemas cinema2 = new Cinemas("cinema2", false, "100");
		Cinemas cinema3 = new Cinemas("cinema3", true, "100");
		Cinemas cinema4 = new Cinemas("cinema4", true, "100");
		
		do {
			System.out.println("Welcome!");
			System.out.println("Press number 1 if you are a Customer");
			System.out.println("Press number 2 if you are a ContentAdmin");
			System.out.println("Press number 3 if you are an Admin");
			System.out.println("Press number 4 if you want to exit the program");
			response = console.nextInt();
			console.nextLine();
			switch(response) {
			case 1:
				// Customer
				
				
				System.out.println("Enter Name :");
				name = console.nextLine();
				System.out.println("Enter Username :");
				username = console.nextLine();
				System.out.println("Enter Password :");
				password = console.nextLine();
								
				Customers user = new Customers(name, username, password);
				user.login(user.getUsername(), user.getPassword());
				
				do {
					System.out.println("What operation would you like to perform ?");
					System.out.println("Press number 1 if you want to see the Films");
					System.out.println("Press number 2 if you want to make a reservation");
					System.out.println("Press number 3 if you want to see your reservation");
					System.out.println("Press number 4 if you want to log out");
					response1 = console.nextInt();
					console.nextLine();
					switch(response1) {
					case 1:
						for (Films film : user.showAvailableFilms()) {
				            System.out.println("Film ID: " + film.getFilmId());
				            System.out.println("Title: " + film.getFilmTitle());
				            System.out.println("Category: " + film.getFilmCategory());
				            System.out.println("Description: " + film.getFilmDescription());
				            System.out.println();
				        }
						break;
					case 2:	
						// make reservation
						user.makeReservation(user.getUsername());
						break;
					case 3:
						//show reservation
						user.viewReservation(user.getUsername());
						break;
					case 4:
						user.logout(user.getUsername());
						break;
					}					
				}while(response1!=4);
				break;
			case 2:
				// contentAdmins
				System.out.println("Enter Name :");
				name = console.nextLine();
				System.out.println("Enter Username :");
				username = console.nextLine();
				System.out.println("Enter Password :");
				password = console.nextLine();
			
			
				ContentAdmins user1 = new ContentAdmins(name, username, password);
				user1.login(user1.getUsername(), user1.getPassword());
				do {
					System.out.println("What operation would you like to perform ?");
					System.out.println("Press number 1 if you want to insert a film");
					System.out.println("Press number 2 if you want to delete a film");
					System.out.println("Press number 3 if you want to assign a film into a cinema");
					System.out.println("Press number 4 if you want to log out");
					
					response1 = console.nextInt();
					console.nextLine();
					switch(response1) {
					case 1:
						user1.insertFilm();	                
		                break;					
					case 2:
						// delete film
						user1.deleteFilm();	         
						break;
						
					case 3:
						// assign films
						user1.assignFilmToCinema();
						break;
						
					case 4:
						user1.logout(user1.getUsername());
						break;
					}
				}while(response1!= 4);
				break;
			case 3:
				// administrator
				
				System.out.println("Enter Name :");
				name = console.nextLine();
				System.out.println("Enter Username :");
				username = console.nextLine();
				System.out.println("Enter Password :");
				password = console.nextLine();
			
			
				Admins user2 = new Admins(name, username, password);
				user2.login(user2.getUsername(), user2.getPassword());
				
				do {
					System.out.println("What operation would you like to perform ?");
					System.out.println("Press number 1 if you want to create a user");
					System.out.println("Press number 2 if you want to update a user");
					System.out.println("Press number 3 if you want to delete a user");
					System.out.println("Press number 4 if you want to search for a user");
					System.out.println("Press number 5 if you want to view a user");
					System.out.println("Press number 6 if you want to register an admin");
					System.out.println("Press number 7 if you want to log out");
					
					response1 = console.nextInt();
					console.nextLine();
					
					switch(response1) {
					case 1:
						user2.createUser();
						break;						
					case 2:
						user2.updateUser();
						break;
					case 3:
						user2.deleteUser();
						break;
					case 4:
						user2.searchUser();
						break;
					case 5:
						user2.viewAllUsers();
						break;
					case 6:
						user2.regisrerAdmin();
						break;
					case 7:
						user2.logout(user2.getUsername());
						break;
					
					}
				}while(response1 !=7);
				break;
			}	
		}while(response !=4);
		

		console.close();
	}

}
