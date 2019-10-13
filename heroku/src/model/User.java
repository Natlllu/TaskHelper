package model;

import dataMapper.UserMapper;

public class User {
	private int id = -1;
	private String email;
	private String password;
	private String user_name;
	private String user_contact;
	private int user_type = -1;
	
	public User(int id, String email, String password, String user_name, String user_contact, int user_type) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.user_name = user_name;
		this.user_contact = user_contact;
		this.user_type = user_type;
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
	
	void load(){
		User user = UserMapper.ExtractUserObject(this.email, this.password);	
			if (this.id == -1) {
			this.id = user.getUser_id();
			}
			if (this.user_type == -1) {
			this.user_type = user.get_user_type();
			}
			if (this.user_contact == null) {
			this.user_contact = user.getUser_contact();
			}
			if (this.user_name == null) {
			this.user_name = user.getUser_name();
			}
	}


	public static User getUser(String email) {
		// TODO Auto-generated method stub
		User user=UserMapper.ExtractUserObjectByEmail(email);
		return user;
		
	}
	
	public static void toXML(UserDTO userDTO, OutputStream outputStream) {
        XMLEncoder encoder = new XMLEncoder(outputStream);
        encoder.writeObject(userDTO);
        encoder.close();
    }
    
    public static UserDTO fromXML(InputStream inputStream) {
        XMLDecoder decoder = new XMLDecoder(inputStream);
        UserDTO result = (UserDTO)decoder.readObject();
        decoder.close();
        return result;
    }

}
