package base.exception;
/**
 * 自定义处理异常信息
 * @author lxr
 *
 */
public class BusinessException extends Exception{
	public BusinessException(String message) {
		super(message);
	}
		
}
