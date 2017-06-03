package base.util;

import java.io.Serializable;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import base.Person;
/**
 * 
 * @ClassName: AcceptJMSUtils
 * @Description: TODO(JMS消费者工具类)
 * @author Administrator
 * @date 2016年10月23日 下午3:57:12
 */
public class AcceptJMSUtils{
		public static <T> T  getObject(Class<? extends Serializable> t,Message message){
			try {
				Serializable T = t.newInstance();
				Person person =new Person();
				  if(message instanceof ObjectMessage){
			         ObjectMessage objectMessage=(ObjectMessage)message;
				  }
				  ObjectMessage objectMsessage=(ObjectMessage)message;
				  T obj =(T)objectMsessage.getObject();
				  return obj;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;			
		}

}
