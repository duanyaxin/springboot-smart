package org.zt.ccty.springboot_mybatis_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * redis数据库配置
 * @author Administrator
 *
 */
@Configuration
public class RedisConfiguration {
	@Bean("redisTemplate")  //新家的这个注解 10-26 12:06
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisFactory){
		StringRedisTemplate template = new StringRedisTemplate(redisFactory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new 
				Jackson2JsonRedisSerializer(Object.class);
		
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}
}
