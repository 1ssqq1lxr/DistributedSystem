package base.model;

public class  ResultModel {
	
		private String SUCCESS_CODE = "100";
		private String SUCCESS_CODE_MSG="操作成功";
		private String ERROR_CODE = "500";
		private String ERROR_CODE_MSG="操作失败";
		private boolean IS_SUCCESS=true;
		private boolean NO_IS_SUCCESS=false;
		private String code;
		
		private String msg;
		
		private Object data;
		
		private boolean success;
		
		public ResultModel(){

		}
		public ResultModel( Object data, boolean success) {
			this.success=success;
			this.data=data;
			if(success)	{
				this.code=SUCCESS_CODE;
				this.msg=SUCCESS_CODE_MSG;
			}
			else{
				this.code=ERROR_CODE;
				this.msg=ERROR_CODE_MSG;
			}
		}
		public ResultModel(String code,String msg,Object data,boolean success){
			this.code=code;
			this.msg=msg;
			this.data=data;
			this.success=success;
		}
		
		public static ResultModel success(Object object){
			ResultModel model = new ResultModel();
			model.setData(object);
			model.setCode(model.getSUCCESS_CODE());
			model.setMsg(model.getSUCCESS_CODE_MSG());
			model.setSuccess(model.isIS_SUCCESS());
			return model;
		}
		
		public static ResultModel error(Object object){
			ResultModel model = new ResultModel();
			model.setData(object);
			model.setCode(model.getERROR_CODE());
			model.setMsg(model.getERROR_CODE_MSG());
			model.setSuccess(model.isNO_IS_SUCCESS());
			return model;
		}
		
	
		



		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		

		public String getSUCCESS_CODE() {
			return SUCCESS_CODE;
		}

		public void setSUCCESS_CODE(String sUCCESS_CODE) {
			SUCCESS_CODE = sUCCESS_CODE;
		}

		public String getSUCCESS_CODE_MSG() {
			return SUCCESS_CODE_MSG;
		}

		public void setSUCCESS_CODE_MSG(String sUCCESS_CODE_MSG) {
			SUCCESS_CODE_MSG = sUCCESS_CODE_MSG;
		}

		public String getERROR_CODE() {
			return ERROR_CODE;
		}

		public void setERROR_CODE(String eRROR_CODE) {
			ERROR_CODE = eRROR_CODE;
		}

		public String getERROR_CODE_MSG() {
			return ERROR_CODE_MSG;
		}

		public void setERROR_CODE_MSG(String eRROR_CODE_MSG) {
			ERROR_CODE_MSG = eRROR_CODE_MSG;
		}

		public boolean isIS_SUCCESS() {
			return IS_SUCCESS;
		}

		public void setIS_SUCCESS(boolean iS_SUCCESS) {
			IS_SUCCESS = iS_SUCCESS;
		}

		public boolean isNO_IS_SUCCESS() {
			return NO_IS_SUCCESS;
		}

		public void setNO_IS_SUCCESS(boolean nO_IS_SUCCESS) {
			NO_IS_SUCCESS = nO_IS_SUCCESS;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}
		
		
}
