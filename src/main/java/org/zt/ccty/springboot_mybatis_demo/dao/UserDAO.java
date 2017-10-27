package org.zt.ccty.springboot_mybatis_demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zt.ccty.springboot_mybatis_demo.model.User;

public interface UserDAO {

	public List<User> getUserInfo();

	public User getUserInfoById(@Param("id") Integer id);
	
	public void  insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(Integer id);

	public User getUserInfoByName(String name);

	public User getUserInfoByNameAndPwd(@Param("name")String name, @Param("password")String password);
}
