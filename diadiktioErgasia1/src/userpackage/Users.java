package userpackage;
import java.util.ArrayList;
import java.io.Serializable;


public  abstract  class Users implements Serializable {
	
	private String name;
	private String username;
	private String password;
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
	protected abstract String getUserWho();
	
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
		String userWho = getUserWho();
		System.out.println(userWho+" " + username + " logged in succesfully!" );
		
	}
	
	public void logout(String username) {
		String userWho = getUserWho();
		System.out.println(userWho+" " + username + " logged out succesfully!" );
		
	}
}
