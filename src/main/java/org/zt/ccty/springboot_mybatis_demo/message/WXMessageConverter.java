package org.zt.ccty.springboot_mybatis_demo.message;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * 消息转换器
 * @author Administrator
 *
 */
public class WXMessageConverter implements MessageConverter{

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		ObjectMessage objMessage = (ObjectMessage) message;
		return objMessage.getObject();
	}

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		return session.createObjectMessage((Serializable) object);
	}
	
}
