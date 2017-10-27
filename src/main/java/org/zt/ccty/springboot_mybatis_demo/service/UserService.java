package org.zt.ccty.springboot_mybatis_demo.service;

import java.util.List;

import org.zt.ccty.springboot_mybatis_demo.model.User;

public interface UserService {

	public List<User> getUserInfo();
	
	public User getUserInfoById(Integer id);
	
	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUserInfo(Integer id);
	
	public void deleteAndAdd(User newUser);

	public boolean userLogin(String name, String password);
	
}
