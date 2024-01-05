package com.example.ticketbackend.constants;

public enum RtnCode {
	SUCCESSFUL(200, "Successful"),//���\
	PARAM_ERROR(400,"Param error"),//�Ѽƿ��~
	ACCOUNT_NOT_FOUND(404,"Account not found"),//�b�����s�b
	ACCOUNT_EXISTED(400,"Account existed")//�b���w�s�b
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
