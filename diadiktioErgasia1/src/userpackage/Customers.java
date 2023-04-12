package userpackage;
import java.util.ArrayList;
import java.util.Scanner;

import filmspackage.Films;
import filmspackage.Provoles;
import java.io.Serializable;


import java.io.*;

public class Customers extends Users implements Serializable{
	
	static ArrayList<Provoles> provolesArrayList = new ArrayList<>();
	int seats;
	String confirmation;
	
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
	
//	public void makeReservation(String username) {
//		Scanner console = new Scanner(System.in);
//		int seats;
//		int availableSeats = -1;
//		deserialize();
//		System.out.print("What's the provoliID of the film that you would like to see? \n");
//		String provoliId = console.nextLine();// to change it
//		
//		for (Provoles provoli : provolesArrayList) {
//			if(provoli.getProvoliIsAvailable()) {
//				availableSeats = 100-provoli.getProvoliNumberOfReservations();
//				System.out.println(provoli.getProvoliID()+" " + provoli.getProvoliFilm()+" " + provoli.getProvoliCinema()+" " + provoli.getProvoliStartDate()+" " + provoli.getProvoliEndDate()+" " + availableSeats+" \n");
//				
//				boolean flag = false;
//				for (Provoles temp : provolesArrayList) {
//					if(provoliId.equals(temp.getProvoliID())) {
//						flag = true;
//						break;
//					}			
//				}
//				if(flag) {
//					System.out.print("How many seats would you like to book? \n");
//					seats = console.nextInt();
//					console.nextLine();
//					if(seats<= availableSeats) {
//						provoli.setProvoliNumberOfReservations(seats);
//						String reservation = username+","+ provoli.getProvoliID()+"," + provoli.getProvoliFilm()+"," + provoli.getProvoliCinema()+"," + provoli.getProvoliStartDate()+"," + provoli.getProvoliEndDate();
//						try {
//						    FileWriter writer = new FileWriter("reservations.txt", true);
//						    writer.write(reservation);
//						    writer.write(System.lineSeparator()); 
//						    writer.close();
//							System.out.print("Υour reservation has been confirmed.\n");
//						} catch (IOException e) {
//						    System.out.println("An error occurred.\n");
//						    e.printStackTrace();	                
//						}
//					}
//				}
//			}			
//		}
//
//		
//			
//		
//	}
	
	
	public void makeReservation(String username) {
		Scanner console = new Scanner(System.in);
		int seats;
		int availableSeats = -1;
		deserialize();
		for (Provoles provoli : provolesArrayList) {
			if(provoli.getProvoliIsAvailable()) {
				availableSeats = 100-provoli.getProvoliNumberOfReservations();
				System.out.println(provoli.getProvoliID()+" " + provoli.getProvoliFilm()+" " + provoli.getProvoliCinema()+" " + provoli.getProvoliStartDate()+" " + provoli.getProvoliEndDate()+" " + availableSeats+" \n");
			}			
		}
		System.out.print("What's the provoliID of the film that you would like to see? \n");
		String provoliId = console.nextLine();
		boolean flag = false;
		for (Provoles temp : provolesArrayList) {
			if(provoliId.equals(temp.getProvoliID())) {
				flag = true;
				if(flag) {
					availableSeats = 100 - temp.getProvoliNumberOfReservations();
					System.out.print("How many seats would you like to book? \n");
					seats = console.nextInt();
					console.nextLine();
					if(seats<= availableSeats) {
						temp.setProvoliNumberOfReservations(temp.getProvoliNumberOfReservations() + seats);
						String reservation = username+","+ temp.getProvoliID()+"," + temp.getProvoliFilm()+"," + temp.getProvoliCinema()+"," + temp.getProvoliStartDate()+"," + temp.getProvoliEndDate()+"," +temp.getProvoliNumberOfReservations();
						try {
						    FileWriter writer = new FileWriter("reservations.txt", true);
						    writer.write(reservation);
						    writer.write(System.lineSeparator()); 
						    writer.close();
							System.out.print("Υour reservation has been confirmed.\n");
						} catch (IOException e) {
						    System.out.println("An error occurred.\n");
						    e.printStackTrace();	                
						}
					}
				}	
				break;				
			}			
		}
	}
	
	public void viewReservation(String confirmation) {
		Scanner console = new Scanner(System.in);
		
		try (Scanner scanner = new Scanner(new File("reservations.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String username = parts[0];
                String provoliId = parts[1];
                String provoliFilm = parts[2];
                String provoliCinema = parts[3];
                String provoliSD = parts[4];
                String provoliED = parts[5];
                int provoliSeats = Integer.parseInt(parts[6]);
                if(username.equals(confirmation)) {
                	String response = "The user "+username+" has booked the projection with the ID " + provoliId +" in "+provoliCinema+ " to watch "+provoliFilm+" at "+provoliSD+" until "+ provoliED+" for "+provoliSeats+" seat/seats \n";
                	 System.out.println(response);
                }
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
		
		
	}
	protected String getUserWho() {
		return "Customers";
	}
	
	public void deserialize() {
		
		
		 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("provoles.dat"))) {
			 provolesArrayList = (ArrayList<Provoles>) ois.readObject();
	            
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	}
	
	public void serialize() {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("provoles.dat"))) {
          oos.writeObject(provolesArrayList);
      } catch (IOException e) {
          e.printStackTrace();
      }
	}

}
