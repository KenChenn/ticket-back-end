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
	PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST(400,"Please Login Admin Account First"), //請先登入管理者權限帳號
	DATA_NOT_FOUND(400,"Data Not Found"), //找不到資料
	ORGANIZER_UPDATE_ERROR(400,"Organizer Update Error"), //主辦單位修改失敗
	ORGANIZER_DELETE_ERROR(400,"Organizer Delete Error"), //主辦單位刪除失敗
	DATE_FORMAT_ERROR(400,"Data Format Error"), //日期格式錯誤
	COMMODITY_ADD_ERROR(400,"Commodity Add Error"), //新增節目失敗
	CODENAME_EXISTED(400,"Codename Existed"), //節目代號已存在
	COMMODITY_UPDATE_ERROR(400,"Commodity Update Error"), //節目修改失敗
	DATA_CHECK_ERROR(400,"Data Check Error"),// 資料檢查失敗
	DATA_CHECK_SUCCESSFUL(200,"Data Check Successful"), //資料檢查成功
	SESSION_ADD_ERROR(400,"Session Add Error"),//新增場次失敗
	SEAT_ADD_ERROR(400,"Seat Add Error"),//新增座位失敗
	SESSION_CODENAME_NOT_MATCH_COMMODITY_CODENAME(400,"Session Codename Not Match Commodity Codename"),//場次資料裡的節目代號與節目代號不一致
	ALREADY_TRACKED(400,"Already Tracked"), //已經追蹤了
	NOT_TRACKGIN(400,"Not Tracking"),//原本就沒追蹤
	UNTRACK_ERROR(400,"Untrack Error"),//退追失敗
	COMMENT_ERROR(400,"Comment Error"),//留言失敗
	PLEASE_LOGIN_FIRST(400,"Please Login First"), //請先登入帳號
	COMMENTER_ERROR(400,"Commenter Error"), //非該留言的留言帳號
	COMMENT_DELETE_ERROR(400,"Comment Delete Error"), //留言刪除失敗
	EXCEED_THE_UPPER_LIMIT(400,"Exceed The Upper Limit"),//超過單次可購買上限
	NOT_ENOUGH_TICKETS(400,"Not Enough Tickets"), //沒有足夠的票卷
	ORDER_ERROR(400,"Order Error"), //下訂失敗
	PAYMENT_DEADLINE_EXCEEDED(400,"Payment Deadline Exceeded"), //已超過付款時間
	BUYER_ERROR(400,"Buyer Error"), //非該筆訂單購買人
	PAYMENT_ERROR(400,"Payment Error"), //付款失敗
	NOT_SELLING_DATE(400,"Not Selling Date"), //不在付款期間
	ORDER_EXPIRED(400,"Order Expired"), //訂單已過期
	NOT_CANCEL_DATE(400,"Not Cancel Date"), //不在取消下訂期間
	CANCEL_ERROR(400,"Cancel Error"), //取消訂單失敗
	SESSIONS_ALREADY_SELLED(400,"Sessions Already Selled") //場次已開賣無法刪除
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
