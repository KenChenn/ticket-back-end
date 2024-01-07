package com.example.ticketbackend.constants;

public enum RtnCode {
	SUCCESSFUL(200, "Successful"),//成功
	PARAM_ERROR(400,"Param Error"),//參數錯誤
	ACCOUNT_NOT_FOUND(404,"Account Not Found"),//帳號不存在
	ACCOUNT_EXISTED(400,"Account Existed"),//帳號已存在
	USERNAME_ALREADY_IN_USE(400,"Username Already In Use"), //使用者名稱已被使用
	USER_DATA_UPDATE_ERROR(400,"User Data Update Error");

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
