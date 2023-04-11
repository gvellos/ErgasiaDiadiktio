package userpackage;
import java.util.ArrayList;
import java.util.Scanner;

import filmspackage.Films;
import filmspackage.Provoles;


import java.io.*;

public class ContentAdmins extends Users implements Serializable{
	
	static ArrayList<Provoles> provolesArrayList = new ArrayList<>();
	
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
		    System.out.println("Successfully appended to the file.\n");
		} catch (IOException e) {
		    System.out.println("An error occurred.\n");
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
		Scanner console = new Scanner(System.in);
		System.out.print("Enter movie title: ");
		String filmTitle = console.nextLine();
		boolean flag = false;
		try (Scanner scanner = new Scanner(new File("moviesAll.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String filmTitleSearch = parts[1];
                if(filmTitleSearch.equals(filmTitle)) {
                	flag = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
		if(flag) {
			System.out.print("Enter cinema id: ");
			String cinemaId = console.nextLine();
			if(cinemaId.equals("cinema1") || cinemaId.equals("cinema2") || cinemaId.equals("cinema3") || cinemaId.equals("cinema4")) {
				
				System.out.print("Insert projection ID: ");
				String provoliId = console.nextLine();
				System.out.print("Insert projection start Date: ");
				String provoliStartDate = console.nextLine();
				System.out.print("Insert projection end Date: ");
				String provoliEndDate = console.nextLine();
				
				Provoles provoli = new Provoles(provoliId, filmTitle, cinemaId, provoliStartDate, provoliEndDate, 0, true);
				//serialize();//
				deserialize();
				provolesArrayList.add(provoli);
				serialize();
				
			}else {
				System.out.print("Cinema not found \n");
			}
		}else {
			System.out.print("Movie title not found \n " );
		}
		
		
		
		
		
	
	}
	protected String getUserWho() {
		return "ContentAdmin";
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