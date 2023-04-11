package mainpackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Admins extends Users implements Serializable{
	Scanner console = new Scanner(System.in);
	String nameUser, usernameUser, passwordUser;
	 static ArrayList<Users> users = new ArrayList<>();
	
	
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
			 if(user.username.equals(usernameUser)) {				 
				System.out.println("Enter new User's name :");
				user.name = console.nextLine();
				System.out.println("Enter new Password :");
				user.password = console.nextLine();
				System.out.println(user.username + " has been updated");
				flag = false;
			 }
            if(flag) {
            	System.out.println(user.username + " have not been found");
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
			 if(user.username.equals(usernameUser)) {
				 
				 users.remove(user);
				 System.out.println(user.username + " have been deleted");
				 flag = false;
			 }
            if(flag) {
            	System.out.println(user.username + " have not been found");
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
			 if(user.username.equals(usernameUser)) {
				 System.out.println(user.username + " have been found");
				 flag = false;
			 }
            if(flag) {
            	System.out.println(user.username + " have not been found");
            }
            
        }
	}
	
	public void viewAllUsers() {
		deserialize();
		 for (Users user : users) {
             System.out.println(user.name+" "+ user.username);
             
         }
		
	}
	
	public void regisrerAdmin() {
		
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