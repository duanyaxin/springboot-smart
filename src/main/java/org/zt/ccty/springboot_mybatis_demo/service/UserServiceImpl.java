package org.zt.ccty.springboot_mybatis_demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zt.ccty.springboot_mybatis_demo.dao.IntegralDao;
import org.zt.ccty.springboot_mybatis_demo.dao.UserDAO;
import org.zt.ccty.springboot_mybatis_demo.message.ActiveMsg;
import org.zt.ccty.springboot_mybatis_demo.model.User;
import org.zt.ccty.springboot_mybatis_demo.model.UserIntegral;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDao;
    
    @Autowired
    private IntegralDao integralDao;

    public List<User> getUserInfo(){
    	List<User> users=userDao.getUserInfo();
        //User user=null;
        return users;
    }

	public User getUserInfoById(Integer id) {
		User user = userDao.getUserInfoById(id);
		return user;
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUserInfo(Integer id) {
		userDao.deleteUser(id);
	}

	@Override
	public void deleteAndAdd(User newUser) {
		String iname = newUser.getName();
		User user = userDao.getUserInfoByName(iname);
		if(user != null) {
			int uid = user.getId();
			userDao.deleteUser(uid); 
		}
		userDao.insertUser(newUser);
	}

	@Override
	public boolean userLogin(String name, String password) {
		boolean isSuccess = false;
		User user =  userDao.getUserInfoByNameAndPwd(name, password);
		if(user != null) {
			UserIntegral userIntegral = integralDao.getIntegralInfoByUid(user.getId());
			if(userIntegral == null) {
				userIntegral = new UserIntegral(user.getId(), "100", "第一次加100积分");
				ActiveMsg.getInstance().sendSynChFileMessage(userIntegral);
				/*integralDao.saveIntegral(userIntegral);*/
			}else {
				userIntegral.setIntegral((Integer.valueOf(userIntegral.getIntegral())+10)+"");
				userIntegral.setDescription("老用户每次登陆加10积分");
				ActiveMsg.getInstance().sendSynChFileMessage(userIntegral);
				/*integralDao.updateIntegral(userIntegral);*/
			}
			isSuccess = true;
		}
		return isSuccess;
	}
	
	

}
