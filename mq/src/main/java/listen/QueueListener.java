package listen;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import base.Person;
import base.util.AcceptJMSUtils;

public class QueueListener implements MessageListener {

	public void onMessage(Message msessage) {
		Person person = AcceptJMSUtils.getObject(Person.class, msessage);
		System.out.println("接受到消息"+"...."+person.getName());
	}

}
