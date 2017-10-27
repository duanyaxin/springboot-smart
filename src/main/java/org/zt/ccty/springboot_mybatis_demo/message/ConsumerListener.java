package org.zt.ccty.springboot_mybatis_demo.message;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zt.ccty.springboot_mybatis_demo.dao.IntegralDao;
import org.zt.ccty.springboot_mybatis_demo.model.UserIntegral;

/**
 * 我是消费者
 * @author Administrator
 *
 */
public class ConsumerListener implements MessageListener{
	private static Log log = LogFactory.getLog(ConsumerListener.class);
	
	@Autowired
	private IntegralDao integralDao;
	
	/*@Resource(name = "SynchFileDao")
	private ISynchFile syncfile;
	@Resource(name = "PUSHDao")
	private IPUSHImpl push;*/
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
       if(message instanceof ObjectMessage){
			
    	   ObjectMessage objMessage = (ObjectMessage) message;
			try {

//				Object obj = objMessage.getObject();
				
//				用户登录之后---积分系统/**和日志系统**/的消息就会做出处理
				UserIntegral userIntegral = (UserIntegral) objMessage.getObject();
				if(userIntegral.getId() != null) {
					integralDao.updateIntegral(userIntegral);
				}else {
					UserIntegral temp = new UserIntegral(userIntegral.getUid(), userIntegral.getIntegral(), userIntegral.getDescription());
					boolean b1 = temp == userIntegral;
					boolean b2 = temp.equals(userIntegral);
 					integralDao.saveIntegral(temp);
				}
				
				
				/*RetenUserBean rub = (RetenUserBean) objMessage.getObject();

				if(rub.getImei()!=null||rub.getImei().length()>12)
				{
					rub.setRetentable(Common.getDest3TableName(Common.tb_retenuser, String.valueOf(rub.getImei().hashCode())));
					//rub.setRetentable(Common.getDest3TableName(Common.tb_retenuser, rub.getExtraimei()));
					if (false == (push.checkUserTable(Common.getDest3TableName(Common.tb_retenuser, String.valueOf(rub.getImei().hashCode())), "sdk"))) 
					{
						push.createUserTable(Common.getDest3TableName(Common.tb_retenuser, String.valueOf(rub.getImei().hashCode())),Common.tb_retenuser);
					}
					SynchFile sf = new SynchFile();
					Integer retenid = push.queryRentenID(rub.getExtraimei(), rub.getChannelid().toString(), rub.getRetentable());
					if(retenid!=null&&retenid.intValue()>0)
					{
						rub.setId(retenid);
						sf = push.updateRetenUser(rub);
					}else
					{
						sf = push.addRetentUser(rub);
					}
					if(syncfile.Checkfile(sf)==false)
					{
						syncfile.addSynchFile(sf);
					}
				}*/
//			String tbulb.getExtraimei().hashCode();
				
				
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
	/*public ISynchFile getSyncfile() {
		return syncfile;
	}
	public void setSyncfile(ISynchFile syncfile) {
		this.syncfile = syncfile;
	}*/
}
