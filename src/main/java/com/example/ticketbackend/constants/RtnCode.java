package com.example.ticketbackend.constants;

public enum RtnCode {
	SUCCESSFUL(200, "Successful"),//成功
	PARAM_ERROR(400,"Param error"),//參數錯誤
	ACCOUNT_NOT_FOUND(404,"Account not found"),//帳號不存在
	ACCOUNT_EXISTED(400,"Account existed")//帳號已存在
	;

	private int code;

	private String message;

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
