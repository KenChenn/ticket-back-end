package com.example.ticketbackend.constants;

public enum RtnCode {
	SUCCESSFUL(200, "Successful"),//���\
	PARAM_ERROR(400,"Param error"),//�Ѽƿ��~
	ACCOUNT_NOT_FOUND(404,"Account not found"),//�b�����s�b
	ACCOUNT_EXISTED(400,"Account existed"),//�b���w�s�b
	USERNAME_ALREADY_IN_USE(400,"Username already in use") //�ϥΪ̦W�٤w�Q�ϥ�
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
