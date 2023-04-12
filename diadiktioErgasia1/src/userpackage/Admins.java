package userpackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import userpackage.Customers;



public class Admins extends Users implements Serializable{
	transient Scanner console = new Scanner(System.in);
	String nameUser, usernameUser, passwordUser;
	static ArrayList<Users> users = new ArrayList<>();
	static ArrayList<Admins> admins = new ArrayList<>();
	
	
	public Admins(String name, String username, String password) {
		super(name, username, password);
		
	}
	public Admins() {
		
	}
	
	public void createUser() {
		
		System.out.println("Enter new User's name :");
		nameUser = console.nextLine();
		System.out.println("Enter Username :");
		usernameUser = console.nextLine();
		System.out.println("Enter Password :");
		passwordUser = console.nextLine();
		Users user1 = new Customers(nameUser, usernameUser, passwordUser);
		deserialize();		
		users.add(user1);
		serialize();
		
			
		
	}
	
	public void updateUser() {
		System.out.println("Enter Username you want to update :");
		usernameUser = console.nextLine();
		boolean flag = true;
		deserialize();
		 for (Users user : users) {
			 if(user.getUsername().equals(usernameUser)) {				 
				System.out.println("Enter new User's name :");
				user.setName(console.nextLine());
				System.out.println("Enter new Password :");
				user.setPassword(console.nextLine());
				System.out.println(user.getUsername() + " has been updated");
				flag = false;
			 }
            if(flag) {
            	System.out.println(user.getUsername() + " have not been found");
            }
            
        }
		serialize();
	}
	
	public void deleteUser() {
		System.out.println("Enter Username you want to delete :");
		usernameUser = console.nextLine();
		boolean flag = true;
		deserialize();
		 for (Users user : users) {
			 if(user.getUsername().equals(usernameUser)) {
				 
				 users.remove(user);
				 System.out.println(user.getUsername() + " have been deleted");
				 flag = false;
			 }
            if(flag) {
            	System.out.println(user.getUsername() + " have not been found");
            }
            
        }
		serialize();
		
	}
	
	public void searchUser() {
		System.out.println("Enter Username you are searching for :");
		usernameUser = console.nextLine();
		boolean flag = true;
		deserialize();
		 for (Users user : users) {
			 if(user.getUsername().equals(usernameUser)) {
				 System.out.println(user.getUsername() + " have been found");
				 flag = false;
			 }
            if(flag) {
            	System.out.println(user.getUsername() + " have not been found");
            }
            
        }
	}
	
	public void viewAllUsers() {
		deserialize();
		 for (Users user : users) {
             System.out.println(user.getName()+" "+ user.getUsername());   
         }
		 for (Admins admin : admins) {
             System.out.println(admin.getName()+" "+ admin.getUsername());   
         }
		
	}
	
	public void regisrerAdmin() {
		System.out.println("Enter new Admin's name :");
		nameUser = console.nextLine();
		System.out.println("Enter Username :");
		usernameUser = console.nextLine();
		System.out.println("Enter Password :");
		passwordUser = console.nextLine();
		
		
		
		
		Admins admin = new Admins(nameUser, usernameUser, passwordUser);

		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("adminsText.dat"))) {
            admins = (ArrayList<Admins>) ois.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		admins.add(admin);
		
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("adminsText.dat"))) {
            oos.writeObject(admins);
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("Admin "+ nameUser+" was created succesfully");
	}
	
	
	protected String getUserWho() {
		return "Admin";
	}
	
	public void deserialize() {
		
		
		 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usersText.dat"))) {
	            users = (ArrayList<Users>) ois.readObject();
	            
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	}
	
	public void serialize() {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usersText.dat"))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
