package org.zt.ccty.springboot_mybatis_demo.controller;

import java.net.Authenticator.RequestorType;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zt.ccty.springboot_mybatis_demo.common.ResponseBean;
import org.zt.ccty.springboot_mybatis_demo.model.User;
import org.zt.ccty.springboot_mybatis_demo.service.UserService;
import org.zt.ccty.springboot_mybatis_demo.service.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wordnik.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiImplicitParam;



@Controller
@RequestMapping("/users")
public class UsersController {



    private Logger logger = Logger.getLogger(UsersController.class);

    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    @ResponseBody
    public String loginToSystem(@RequestParam("name")String name,@RequestParam("password")String password) {
    	boolean isLoginSuccess = userService.userLogin(name,password);
    	String result = isLoginSuccess?"用户成功登陆，已经领取积分！":"该用户登陆失败!";
    	return result;
    }

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo() {
    	List<User> users = userService.getUserInfo();
        if(users!=null){
            System.out.println(JSON.toJSON(users));
            logger.info("user.getAge():"+JSON.toJSON(users));
        }
        return users;
    }
    @RequestMapping("/getUserInfoById")
    @ResponseBody
    public User getUserInfoById(HttpServletRequest request,Integer id) {
    	User user = userService.getUserInfoById(id);
        if(user != null){
            System.out.println(JSON.toJSON(user));
            logger.info("user.getAge():"+user.getAge());
        }
        return user;
    }
    
    /*@ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
           users.put(user.getId(), user);
           return "success";
    }*/
    
    
    @RequestMapping("/addUserInfo")
    @ResponseBody
    public String addUser(@RequestParam("name")String name,@RequestParam("sex")String sex,
    		@RequestParam("age")Integer age,@RequestParam("phone")String phone,
    		@RequestParam("password")String password) {
    	try {
			User user = new User(name,sex,age,phone,password);
			userService.insertUser(user);
			return "信息添加成功!";
		} catch (Exception e) {
			e.printStackTrace();
			return "添加失败！";
		}
    }
    
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public String updateUser(String name,String sex,Integer age,String phone,Integer id) {
    	User user = null;
    	String result = null;
    	ResponseBean responseBean = null;
    	try {
    		user = userService.getUserInfoById(id);
    		user.setName(name);
    		user.setSex(sex);
    		user.setAge(age);
    		user.setPhone(phone);
    		userService.updateUser(user);
    		responseBean = new ResponseBean(200,true,"用户信息修改成功!",null);
    		result = JSON.toJSONString(responseBean,SerializerFeature.WriteMapNullValue);
    		
//    		SerializerFeature -- 结果输出形式，如数字为空，值为null的各种情况
    		
    		
    		return result;
    	}/*catch (SQLDataException e) {
    		e.printStackTrace();
    		return "修改失败";
    	}*/catch (Exception e) {
    		responseBean = new ResponseBean(200,true,"用户信息修改失败!","参数错误或内部异常!");
    		result = JSON.toJSONString(responseBean,SerializerFeature.WriteMapNullValue);
    		e.printStackTrace();
    		return result;
		}
    }
    
    @RequestMapping("/deleteUser")
    @ResponseBody
//    public String deleteUserInfoById(@PathVariable("id")Integer id) {
    public String deleteUserInfoById(@RequestParam("id")Integer id) {
    	String result = null;
    	ResponseBean responseBean = null;
    	try {
    		final User tempUser = userService.getUserInfoById(id);
    		String name = tempUser.getName();
    		userService.deleteUserInfo(id);
    		responseBean = new ResponseBean(200,true,"用户"+name+"删除成功!",null);
    		result = JSON.toJSONString(responseBean, SerializerFeature.WriteMapNullValue);
    		return result;
    	}catch (Exception e) {
    		e.printStackTrace();
    		responseBean = new ResponseBean(200,true,"删除失败!","原因不明!");
    		result = JSON.toJSONString(responseBean, SerializerFeature.WriteMapNullValue);
    		return result;
    	}
    }
    
    @RequestMapping(value="/delAndAdd",method=RequestMethod.GET)
    @ResponseBody
//    @ResponseBody
    /*public String delAndAddUser(@RequestParam("name")String name,@RequestParam("sex")String sex,
    		@RequestParam("age")int age,@RequestParam("phone")String phone)*/ 
    public String delAndAddUser(String name,String sex, int age,String phone,String password){
    	String result = null;
    	ResponseBean responseBean = null;
    	try {
	    	User newUser = new User(name,sex,age,phone,password);
	    	userService.deleteAndAdd(newUser);
//	    	responseBean = new ResponseBean(200,true,"用户删除并添加成功",null);
	    	responseBean = new ResponseBean(200,true,"用户删除并添加成功","none");
	    	result = JSON.toJSONString(responseBean, SerializerFeature.WriteMapNullValue);
	    	return result;
    	}catch(Exception e) {
    		e.printStackTrace();
    		responseBean = new ResponseBean(200,true,"删除失败!","原因不明!");
    		result = JSON.toJSONString(responseBean, SerializerFeature.WriteMapNullValue);
    		return result;
    	} 
    }

}
