package pc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.parent.api.TestServer;

public class Test {
		public static void main(String[] args) {
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
				TestServer server =	(TestServer) context.getBean("testService");
				String msg = server.getMsg();
		
		}
}
