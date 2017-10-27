package org.zt.ccty.springboot_mybatis_demo.config;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * aspect 面向切面---->配置读写分离的切面
 * @author Administrator
 *
 */
@Aspect  
@Component 
public class DataSourceAop {
	private static Logger log = Logger.getLogger(DataSourceAop.class);
    @Before("execution(* org.zt.ccty.springboot_mybatis_demo.dao..*.select*(..)) || execution(* org.zt.ccty.springboot_mybatis_demo.dao..*.get*(..))")  
    public void setReadDataSourceType() {  
        DataSourceContextHolder.read();  
        log.info("dataSource切换到：Read");  
    }  
    @Before("execution(* org.zt.ccty.springboot_mybatis_demo.dao..*.insert*(..)) || execution(* org.zt.ccty.springboot_mybatis_demo.dao..*.update*(..))"
    		+ "|| execution(* org.zt.ccty.springboot_mybatis_demo.dao..*.alter*(..))|| execution(* org.zt.ccty.springboot_mybatis_demo.dao..*.modify*(..))"
    		+ "|| execution(* org.zt.ccty.springboot_mybatis_demo.dao..*.delete*(..))|| execution(* org.zt.ccty.springboot_mybatis_demo.dao..*.del*(..))"
    		)  
    public void setWriteDataSourceType() {  
        DataSourceContextHolder.write();  
        log.info("dataSource切换到：write");  
    }  
}
