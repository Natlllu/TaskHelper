package model;


import java.sql.Timestamp;

public class Task {
	private int task_id;
	private int customer_id;
	private int expert_id;
	private String task_name;
	private Timestamp task_time;
	private String location;
    private String contact;
    private String task_description;
    private float task_budget;
    private int task_status;
//    private User user;
    
    public Task(int task_id, int customer_id, int expert_id, String task_name, Timestamp task_time,
			String location, String contact, String task_description, float task_budget, int task_status) {
		super();
		this.task_id = task_id;
		this.customer_id = customer_id;
		this.expert_id = expert_id;
		this.task_name = task_name;
//		this.task_date = task_date;
//		this.task_time = task_time;
		this.task_time = task_time;
		this.location = location;
		this.contact = contact;
		this.task_description = task_description;
		this.task_budget = task_budget;
		this.task_status = task_status;
	}
      
    public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}  
	public int getUser_id() {
		return customer_id;
	}
	public void setUser_id(int user_id) {
		this.customer_id = user_id;
	}
	public int getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(int expert_id) {
		this.expert_id = expert_id;
	}
    public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
//	public Date getTask_date() {
//		return task_date;
//	}
//	public void setTask_date(Date task_date) {
//		this.task_date = task_date;
//	}
//	public Time getTask_time() {
//		return task_time;
//	}
//	public void setTask_time(Time task_time) {
//		this.task_time = task_time;
//	}
	public Timestamp getTask_time() {
		return task_time;
	}
	public void setTask_time(Timestamp task_time) {
		this.task_time = task_time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTask_description() {
		return task_description;
	}
	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}
	public float getTask_budget() {
		return task_budget;
	}
	public void setTask_budget(float task_budget) {
		this.task_budget = task_budget;
	}
	public int getTask_status() {
		return task_status;
	}
	public void setTask_status(int task_status) {
		this.task_status = task_status;
	}
    
//    void load(){
//    	 
//    	
//    	if (this.lastName == null) {
//    		this.lastName = record.get("last_name"); }
//    		if (this.firstName == null) {
//    		this.firstName = record.get("first_name");
//    		}
//    		if (this.numberOfDependents == -1) {
//    		this.numberOfDependents = Integer.parseInt(record.get("number_of_dependents");
//    		}
//    }

}
