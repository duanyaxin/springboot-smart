package org.zt.ccty.springboot_mybatis_demo.redis;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.zt.ccty.springboot_mybatis_demo.common.SpringUtils;
import org.zt.ccty.springboot_mybatis_demo.config.RedisConfiguration;
import org.zt.ccty.springboot_mybatis_demo.model.User;
import org.zt.ccty.springboot_mybatis_demo.service.UserService;



@Configuration
@Service
@ContextConfiguration(classes = {RedisConfiguration.class,RedisService.class} )
public class RedisManager {
	
	private Logger logger = LoggerFactory.getLogger(RedisManager.class);
	
	/*@Resource(name="redisTemplate")*/
	
	
	private static RedisManager redisManager;
	
//	@Autowired
	/*@Resource(name="redisService")
	RedisService redisService;*/

	@Autowired
	RedisService redisService;
	
	public RedisManager() {
		
	}
	
	/*public RedisManager() {
		if (redisManager == null) {
//			redisManager = (RedisManager) SpringUtils
//					.getBean("redisManager");
			redisManager = (RedisManager) SpringUtils.getBean(RedisManager.class);
		}
	}*/
	
	@Bean(name="redisManager")
	public static RedisManager getInstance() {
		if (redisManager == null) {
			/*redisManager = (RedisManager) SpringUtils
					.getBean("redisManager");*/
			redisManager = new RedisManager();
		}
		return redisManager;
	}
	
	public void clear() {
		redisService.deleteByKey("2134234");
	}

	public void redisInitData(String string) {
		System.out.println("看看有没有到这里。。。");
		redisService.redisInitData(string);
	}
	
//	如下是redis的一些基础操作------插入/获取/清楚/判断是有这个key
	/**
	 * Redis 通过key获取值
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return redisService.getData(key);
	}
	
	/**
	 * Redis 判断key 是否存在
	 * @param key
	 * @return
	 */
	public boolean keyExists(String key) {
		return redisService.keyExistsData(key);
	}
	
	/**
	 * Redis 删除key
	 * @param key
	 */
	public void delete(String key) {
		redisService.deleteData(key);
	}
	
	/**
	 * Redis 插入数据
	 * @param key
	 * @param val
	 */
	public  void put(String key,String val) {
		redisService.putData(key, val);
	}
	
	public static void main(String[] args) {
		System.out.println("开始测试");
		
		/*RedisManager manager = new RedisManager();
		manager.put("didi", "滴滴答答");*/
		RedisManager.getInstance().put("didi", "滴滴答答");
		System.out.println("结束测试");
	}
	
}
