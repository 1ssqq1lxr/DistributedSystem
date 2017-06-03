package common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapUtils {
	/**
	 * 封装参数为对象
	 * @param paraMap
	 * @param t
	 * @return
	 */
		public static <T> T jsonToBean(Map<String,Object> paraMap,Class<T> t){
		
			try {
				T newInstance = t.newInstance();
				if(paraMap!=null && t!=null){
					Set<String> keySet = paraMap.keySet();
					if(keySet.size()>0){
						for(String key: keySet){
							Field declaredField = t.getDeclaredField(key);
							if(declaredField!=null){
								String methodName = "set"+key.substring(0,1).toUpperCase()+key.substring(1);
								Method declaredMethod = t.getDeclaredMethod(methodName, declaredField.getType());
								 declaredMethod.invoke(newInstance, paraMap.get(key));
							}
						}
					}
				}
				else{
					throw new RuntimeException("class or paraMap is not null");
				}
				return newInstance;
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("param to bean error");
			}
						
		}
		

}
