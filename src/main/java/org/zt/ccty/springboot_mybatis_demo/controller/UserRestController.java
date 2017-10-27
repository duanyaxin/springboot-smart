package org.zt.ccty.springboot_mybatis_demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zt.ccty.springboot_mybatis_demo.model.User;
import org.zt.ccty.springboot_mybatis_demo.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/restusers")
public class UserRestController {
	/**
	 * Collections.synchronizedMap()与ConcurrentHashMap主要区别是：
	 * Collections.synchronizedMap()和Hashtable一样，实现上在调用map所有方法时，
	 * 都对整个map进行同步，而ConcurrentHashMap的实现却更加精细，它对map中的所有桶加了锁。
	 * 所以，只要要有一个线程访问map，其他线程就无法进入map，而如果一个线程在访问ConcurrentHashMap某个桶时，
	 * 其他线程，仍然可以对map执行某些操作。这样，ConcurrentHashMap在性能以及安全性方面，
	 * 明显比Collections.synchronizedMap()更加有优势。同时，同步操作精确控制到桶，
	 * 所以，即使在遍历map时，其他线程试图对map进行数据修改，
	 * 也不会抛出ConcurrentModificationException。
	 */
	static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public List<User> getUserList() {
//		List<User> r1 = new ArrayList<User>(users.values());
		List<User> r = userService.getUserInfo();
		return r;
	}

	@CrossOrigin
	@ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postUser(@RequestBody User user) {
//		users.put(user.getId(), user);
		userService.insertUser(user);
		return "success";
	}

	
	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	/*public User getUser(@PathVariable Integer id) {*/
	public User getUser(@PathVariable Integer id) {
//		return users.get(id);
		return userService.getUserInfoById(id);
	}

	@ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Integer id, @RequestBody User user) {
//		User u = users.get(id);
		User u = userService.getUserInfoById(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
//		users.put(id, u);
		userService.updateUser(user);
		return "success";
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer id) {
//		users.remove(id);
		userService.deleteUserInfo(id); 
		return "success";
	}
}
