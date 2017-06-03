package base.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import base.exception.BusinessException;
import base.exception.PropertyPlaceholder;
import base.model.ResultModel;

public class BaseController {
		
	private Map<String, Object>  paraMap = new HashMap<String, Object>();
	
	private static final Logger logger = Logger.getLogger(BaseController.class);
	private ResultModel model =null;
	
	/**
	 * 处理自定义异常
	 * @param e
	 * @return
	 */
	public ResultModel processException(Exception  e){
		if(e instanceof BusinessException)
		{
			if(StringUtils.isNotBlank(e.getMessage())){
				String value = PropertyPlaceholder.getProperty(e.getMessage());
				if(StringUtils.isNotBlank(value)){
					model= new ResultModel(e.getMessage(), value, null, false);
				}
			}
			
		}
		else{
			model = new ResultModel(null,false);
			logger.info(e.getMessage());;
		}
		return model;
	}
	
	
}
