package model;

import java.util.ArrayList;

import dataMapper.UserMapper;



public class UserUnitOfWork {
	
//	private static ThreadLocal current = new ThreadLocal();
	private ArrayList<User> newCustomers = new ArrayList<User>();
	private ArrayList<User> dirtyCustomers = new ArrayList<User>();
//	private ArrayList<User> deleteCustomers = new ArrayList<User>();
	
	public static void newCurrent() {
		setCurrent(new UserUnitOfWork());
	}
	
	public static void setCurrent(UserUnitOfWork uuow) {
//		current.set(uuow);
	}
	
//	public static UserUnitOfWork getCurrent() {
////		return (UserUnitOfWork) current.get();
//	}
	
	public void registerNew(User ur) {
		
		//Assert.notNull(cu.getId(), "id is null");
		//Assert.isTrue(!dirtyCustomers.contains(cu),"customer is dirty");
		//Assert.isTrue(!newCustomers.contains(cu),"customer is new");
		newCustomers.add(ur);		
	}
	
	public void registerDirty(User ur) {
		
		if(!dirtyCustomers.contains(ur)&&!newCustomers.contains(ur)) {
			dirtyCustomers.add(ur);		
		}
	}
	
	/*
	public void registerDelete(Customer cu) {
		if(newCustomers.remove(cu)) return;
		dirtyCustomers.remove(cu);
		if(!deleteCustomers.contains(cu)) {
			deleteCustomers.add(cu);
		}
		
	}
	*/
	
	public void registerClean(User ur) {
		
	}
	
	public void commit() {
		for(User ur: newCustomers) {
			UserMapper mapper = new UserMapper();
			mapper.insertUser(ur.getUser_name(), ur.get_password(), ur.get_email(),ur.getUser_contact(), ur.get_user_type());
		}
		
	}
		
	
	
	
}