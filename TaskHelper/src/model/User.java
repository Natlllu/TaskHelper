package model;

public class User {
	private int id;
	private String email;
	private String password;
	private String user_name;
	private String user_contact;
	private int user_type;
	
	public int getUser_id() {
		return id;
	}

	public void setUser_id(int user_id) {
		this.id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_contact() {
		return user_contact;
	}

	public void setUser_contact(String user_contact) {
		this.user_contact = user_contact;
	}
	
	public String get_email(){
		return this.email;
	}
	
	public String get_password(){
		return this.password;
	}
	
	public int get_user_type(){
		return this.user_type;
	}
	
	public void set_email(String email){
		
	}
	
	public void set_password(String password){
		
	}
	
	public void set_user_type(int user_type){
		
	}
	

}
