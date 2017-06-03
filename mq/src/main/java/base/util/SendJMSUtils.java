package base.util;


import java.io.Serializable;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
/**
 * 
 * @ClassName: SendJMSUtils
 * @Description: TODO(JMS发送消息实体类)
 * @author Administrator
 * @date 2016年10月23日 下午3:57:56
 */
public class SendJMSUtils {
  //队列名gzframe.demo
  @Resource(name="demoQueueDestination")
  private static Destination demoQueueDestination;

  //队列消息生产者
  @Resource(name="jmsQueueTemplate")
  private static JmsTemplate jmsQueueTemplate;
   
  //广播消息生产者
  @Resource(name="jmsTopicTemplate")
  
  
  private static JmsTemplate jmsTopicTemplate;
  public static void sendMessage(final Serializable object){
	  try {
		  jmsQueueTemplate.send(demoQueueDestination, new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					return session.createObjectMessage(object);
				}
			});
	} catch (Exception e) {
		// TODO: handle exception 处理异常业务
	}
  }
  
  
}
