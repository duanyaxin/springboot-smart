package org.zt.ccty.springboot_mybatis_demo.redis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.zt.ccty.springboot_mybatis_demo.model.User;
import org.zt.ccty.springboot_mybatis_demo.service.UserService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Repository(value="redisService")
public class RedisService {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
//	@Autowired
//	private RedisService userRedis;
	
	@Autowired
	private UserService userService;
	
	
	public void addUser(String key,Long time,User user){
		Gson gson = new Gson();
		redisTemplate.opsForValue().set(key, gson.toJson(user),time,TimeUnit.MINUTES);
	}
	
	public void addUserList(String key,Long time,List<User> userList){
		Gson gson = new Gson();
		redisTemplate.opsForValue().set(key, gson.toJson(userList),time,TimeUnit.MINUTES);
	}
	
	public User getUserByKey(String key){
		Gson gson = new Gson();
		User user = null;
		String userJson = redisTemplate.opsForValue().get(key);
		if(StringUtils.isNotEmpty(userJson)){
			user =  gson.fromJson(userJson, User.class);
		}
		return user;
	}
	
	public List<User> getUserListByKey(String key){
		Gson gson = new Gson();
		List<User> userList = null;
		String userJson = redisTemplate.opsForValue().get(key);
		if(StringUtils.isNotEmpty(userJson)){
			userList =  gson.fromJson(userJson, new TypeToken<List<User>>(){}.getType()	);
		}
		return userList;
	}
	
	public void deleteByKey(String key){
		redisTemplate.opsForValue().getOperations().delete(key);
	}
	
	/**
	 * 清空redis
	 */
	public void clear() {
		
	}
	
	public void redisInitData(String string) {
		User user = userService.getUserInfoById(1);
		/*userRedis.*/addUser(string, 3000L, user);
	}
	
	
//	如下是redis的一些基础操作------插入/获取/清楚/判断是有这个key
	/**
	 * Redis 通过key获取值
	 * @param key
	 * @return
	 */
	public Object getData(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	/**
	 * Redis 判断key 是否存在
	 * @param key
	 * @return
	 */
	public boolean keyExistsData(String key) {
		return redisTemplate.hasKey(key);
	}
	
	/**
	 * Redis 删除key
	 * @param key
	 */
	public void deleteData(String key) {
		redisTemplate.delete(key);
	}
	
	/**
	 * Redis 插入数据
	 * @param key
	 * @param val
	 */
	public  void putData(String key,String val) {
		redisTemplate.opsForValue().set(key, val,3000L,TimeUnit.MINUTES);
	}
	
	
}
