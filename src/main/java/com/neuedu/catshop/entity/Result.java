package com.neuedu.catshop.entity;

public class Result {
	private Boolean success = Boolean.FALSE;
	private String errorMsg;

	public Result() {
		super();
	}

	public Result(Boolean success, String errorMsg) {
		super();
		this.success = success;
		this.errorMsg = errorMsg;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", errorMsg=" + errorMsg + "]";
	}

	
}
