package org.zt.ccty.springboot_mybatis_demo.message;

import java.io.Serializable;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;
import org.zt.ccty.springboot_mybatis_demo.common.SpringUtils;

public class ActiveMsg {
	/**
     * @param args
     * jmsTemplate和destination都是在spring配置文件中进行配制的
     * Sender只使用了配置文件中的jmsFactory，jmsTemplate，还有destination这三个属性
     */
	private static ActiveMsg activeMsg = null;
	private static JmsTemplate jmsTemplate;
	private static Destination destination;
	
	public static ActiveMsg getInstance() {
		if(activeMsg == null)
		{
			activeMsg = new ActiveMsg();
			if (jmsTemplate == null) {
				jmsTemplate = (JmsTemplate) SpringUtils.getBean("jmsTemplate");
			}
			if (destination == null) {
				destination = (Destination) SpringUtils.getBean("destination");
			}
		}
		return activeMsg;
	}
	
	//发送消息对象
    public  void sendSynChFileMessage(final Serializable obj) {
    	jmsTemplate.convertAndSend(destination, obj);
    	
    	
    	/*
    	jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(obj);
            }
        });
        */
    	
    }
	
}
