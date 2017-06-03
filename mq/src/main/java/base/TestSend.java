package base;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TestSend {
//    //队列名gzframe.demo
//    @Resource(name="demoQueueDestination")
//    private static Destination demoQueueDestination;
//
//    //队列消息生产者
//    @Resource(name="jmsQueueTemplate")
//    private static JmsTemplate jmsQueueTemplate;
    public static void sendMessage(final JmsTemplate jmsQueueTemplate,Destination demoQueueDestination){
    	final Person person = new Person();
    	person.setId(1);
    	person.setName("zhangsna");
    	person.setPassword("123123");
    	jmsQueueTemplate.send(demoQueueDestination,new MessageCreator() {		
			public Message createMessage(Session session) throws JMSException {
				System.out.println("我已发送一个消息222");
				String str="222第一个消息222";
				return session.createObjectMessage(person);
			}
		});
    }
    public static void main(String[] args) {
    	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    	JmsTemplate jmsQueueTemplate =	(JmsTemplate) applicationContext.getBean("jmsQueueTemplate");
    	Destination demoQueueDestination = (Destination) applicationContext.getBean("demoQueueDestination");
    	sendMessage(jmsQueueTemplate,demoQueueDestination);
    }
    
}
