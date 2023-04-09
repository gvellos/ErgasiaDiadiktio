package mainpackage;
import java.util.ArrayList;

public class Users {
	
	String name;
	String username;
	String password;
	ArrayList<String> usernameList = new ArrayList<String>();
	
	public Users(String name, String username, String password) {
		this.name = name;
		this.password = password;
		this.username = username;
		//this.usernameList = usernameList;
		
		usernameList.add(username);
	}
	public Users() {
		
	}
	
	public String getName() {
	    return name;
	}
	
	public String getUsername() {
	    return username;
	}
	
	public String getPassword() {
	    return password;
	}
	
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public void setUsername(String username) {
	    this.username = username;
	}
	
	public void setPassword(String password) {
	    this.password = password;
	}
	
	public void login(String username,String password) {
		System.out.println("User " + username + " logged in succesfully!" );
		
	}
	
	public void logout(String username,String password) {
		System.out.println("User " + username + " logged out succesfully!" );
		
	}
}
