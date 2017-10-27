package org.zt.ccty.springboot_mybatis_demo.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 普通的类，也可以通过SpringUtil的getApplicationContext()获取spring容器中附有@Bean的bean对象
 * @author Administrator
 *
 */
@Component
@Service
//@Configuration
public class SpringUtils implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(SpringUtils.applicationContext == null) {
			SpringUtils.applicationContext = applicationContext;
		}
		
		System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("--------------org.zt.ccty.springboot_mybatis_demo.common.SpringUtil------------------------------------------------------");
        System.out.println("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+SpringUtils.applicationContext+"========");
        System.out.println("---------------------------------------------------------------------");
		
	}
	
//	获取applicationContext
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
			
//	通过name获取bean
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
	
//	通过class获取bean
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}
	
//	通过name，以及Clazz返回指定的Bean
	public static <T> T getBean(String name,Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}
	
}
