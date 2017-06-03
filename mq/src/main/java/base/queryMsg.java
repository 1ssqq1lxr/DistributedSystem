package base;

import org.springframework.stereotype.Service;

@Service("msg")
public class queryMsg {
		public String queryMsg(String name){
			return "终于成功了"+name;
		}
}
