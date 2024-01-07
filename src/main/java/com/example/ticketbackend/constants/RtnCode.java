package com.example.ticketbackend.constants;

public enum RtnCode {
	SUCCESSFUL(200, "Successful"),//���\
	PARAM_ERROR(400,"Param Error"),//�Ѽƿ��~
	ACCOUNT_NOT_FOUND(404,"Account Not Found"),//�b�����s�b
	ACCOUNT_EXISTED(400,"Account Existed"),//�b���w�s�b
	USERNAME_ALREADY_IN_USE(400,"Username Already In Use"), //�ϥΪ̦W�٤w�Q�ϥ�
	USER_DATA_UPDATE_ERROR(400,"User Data Update Error"), //�ϥΪ̭ӤH��T�ק異��
	PWD_NOT_CORRECT(400,"Password Not Correct"), //�K�X�����T
	PLEASE_ENTER_NEW_PWD(400,"Please Enter New Password") //�s�K�X�P�±K�X�@��
	;
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
