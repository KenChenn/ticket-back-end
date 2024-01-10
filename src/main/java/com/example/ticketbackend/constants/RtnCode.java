package com.example.ticketbackend.constants;

public enum RtnCode {
	SUCCESSFUL(200, "Successful"),//成功
	PARAM_ERROR(400,"Param Error"),//參數錯誤
	ACCOUNT_NOT_FOUND(404,"Account Not Found"),//帳號不存在
	ACCOUNT_EXISTED(400,"Account Existed"),//帳號已存在
	ACCOUNT_SIGNUP_ERROR(400,"Account SignUp Error"),//帳號新建失敗
	USERNAME_ALREADY_IN_USE(400,"Username Already In Use"), //使用者名稱已被使用
	USER_DATA_UPDATE_ERROR(400,"User Data Update Error"), //使用者個人資訊修改失敗
	PWD_NOT_CORRECT(400,"Password Not Correct"), //密碼不正確
	PLEASE_ENTER_NEW_PWD(400,"Please Enter New Password"), //新密碼與舊密碼一樣
	ORGANIZER_EXISTED(400,"Organizer Existed"), //主辦單位已存在
	ORGANIZER_ADD_ERROR(400,"Organizer Add Error"),//主辦單位新增失敗
	PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST(400,"Please Login Admin Account First"), //新先登入管理者權限帳號
	DATA_NOT_FOUND(400,"Data Not Found"), //找不到資料
	ORGANIZER_UPDATE_ERROR(400,"Organizer Update Error"), //主辦單位修改失敗
	ORGANIZER_DELETE_ERROR(400,"Organizer Delete Error"), //主辦單位刪除失敗
	DATE_FORMAT_ERROR(400,"Data Format Error"), //日期格式錯誤
	COMMODITY_ADD_ERROR(400,"Commodity Add Error"), //新增節目失敗
	CODENAME_EXISTED(400,"Codename Existed"), //節目代號已存在
	COMMODITY_UPDATE_ERROR(400,"Commodity Update Error"), //節目修改失敗
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
