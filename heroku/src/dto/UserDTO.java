package dto;

import com.google.gson.Gson;

public class UserDTO {
	private int id = -1;
	private String email;
	private String password;
	private String user_name;
	private String user_contact;
	private int user_type = -1;
	
	public UserDTO(int id, String email, String password, String user_name, String user_contact, int user_type) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.user_name = user_name;
		this.user_contact = user_contact;
		this.user_type = user_type;
	}

	public static String serialize(UserDTO user) {
		Gson gson = new Gson();
		return gson.toJson(user);
	}
	
	public static UserDTO deserialize(String userString) {
		Gson gson = new Gson();
		return gson.fromJson(userString, UserDTO.class);
	}
	public int getUser_id() {
		if (this.id == -1){
			load();
		}
		return id;
	}

	public void setUser_id(int user_id) {
		this.id = user_id;
	}

	public String getUser_name() {
		if (this.user_name == null){
			load();
		}
		return user_name;
	}

	public void setUser_name(String user_name) {
		if (this.user_name == null){
			load();
		}
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
		if (this.user_type == -1){
			load();
		}
		return this.user_type;
	}
	
	public void set_email(String email){
		
	}
	
	public void set_password(String password){
		
	}
	
	public void set_user_type(int user_type){
		
	}
	
	

}
