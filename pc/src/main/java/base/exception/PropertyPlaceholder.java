package base.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import base.controller.BaseController;
/**
 * lxr
 * @author Administrator
 * 处理properties文件数据
 */
public class PropertyPlaceholder extends PropertyPlaceholderConfigurer  {
	
	private static final Logger logger = Logger.getLogger(PropertyPlaceholder.class);
	 private static Map<String, String> propertyMap  = new HashMap<String, String>();;

	    @Override
	    public void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
	            throws BeansException {
	        super.processProperties(beanFactoryToProcess, props);
	       
	        for (Object key : props.keySet()) {
	            String keyStr = key.toString();
	            String value = props.getProperty(keyStr);
	            propertyMap.put(keyStr, value);
	        }
	        logger.info("base.exception.PropertyPlaceholder【初始化配置信息成功】");
	        
	    }
	    // static method for accessing context properties
	    public static String getProperty(String name) {
	        return propertyMap.get(name);
	    }
}
