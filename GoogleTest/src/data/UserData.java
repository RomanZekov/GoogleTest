package data;

public class UserData {
	
	private String login;
	private String email;
	private String pass;
	
	public UserData(String login, String pass) {
		
		this.login = login;
		this.email = login + "@gmail.com";
		this.pass = pass;
	}
	
	public String getLogin(){
		
		return login;
	}
	
	public String getPass(){
		
		return pass;
	}
	
	public String getEmail(){
		
		return email;
	}

}
