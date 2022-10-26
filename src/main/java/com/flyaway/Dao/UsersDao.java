package com.flyaway.Dao;

import java.util.List;

import com.flyaway.entities.Users;

public interface UsersDao {
	
	void addUser(Users user);
	void changePassword(String username,String password);
	void deleteUser(int uno);
	List<Users> getUser(String Username);

}
