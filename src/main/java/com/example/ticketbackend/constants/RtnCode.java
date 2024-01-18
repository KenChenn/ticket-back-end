package com.example.ticketbackend.constants;

public enum RtnCode {
	SUCCESSFUL(200, "Successful"),//���\
	PARAM_ERROR(400,"Param Error"),//�Ѽƿ��~
	ACCOUNT_NOT_FOUND(404,"Account Not Found"),//�b�����s�b
	ACCOUNT_EXISTED(400,"Account Existed"),//�b���w�s�b
	ACCOUNT_SIGNUP_ERROR(400,"Account SignUp Error"),//�b���s�إ���
	USERNAME_ALREADY_IN_USE(400,"Username Already In Use"), //�ϥΪ̦W�٤w�Q�ϥ�
	USER_DATA_UPDATE_ERROR(400,"User Data Update Error"), //�ϥΪ̭ӤH��T�ק異��
	PWD_NOT_CORRECT(400,"Password Not Correct"), //�K�X�����T
	PLEASE_ENTER_NEW_PWD(400,"Please Enter New Password"), //�s�K�X�P�±K�X�@��
	ORGANIZER_EXISTED(400,"Organizer Existed"), //�D����w�s�b
	ORGANIZER_ADD_ERROR(400,"Organizer Add Error"),//�D����s�W����
	PLEASE_LOGIN_ADMIN_ACCOUNT_FIRST(400,"Please Login Admin Account First"), //�Х��n�J�޲z���v���b��
	DATA_NOT_FOUND(400,"Data Not Found"), //�䤣����
	ORGANIZER_UPDATE_ERROR(400,"Organizer Update Error"), //�D����ק異��
	ORGANIZER_DELETE_ERROR(400,"Organizer Delete Error"), //�D����R������
	DATE_FORMAT_ERROR(400,"Data Format Error"), //����榡���~
	COMMODITY_ADD_ERROR(400,"Commodity Add Error"), //�s�W�`�إ���
	CODENAME_EXISTED(400,"Codename Existed"), //�`�إN���w�s�b
	COMMODITY_UPDATE_ERROR(400,"Commodity Update Error"), //�`�حק異��
	DATA_CHECK_ERROR(400,"Data Check Error"),// ����ˬd����
	DATA_CHECK_SUCCESSFUL(200,"Data Check Successful"), //����ˬd���\
	SESSION_ADD_ERROR(400,"Session Add Error"),//�s�W��������
	SEAT_ADD_ERROR(400,"Seat Add Error"),//�s�W�y�쥢��
	SESSION_CODENAME_NOT_MATCH_COMMODITY_CODENAME(400,"Session Codename Not Match Commodity Codename"),//������Ƹ̪��`�إN���P�`�إN�����@�P
	ALREADY_TRACKED(400,"Already Tracked"), //�w�g�l�ܤF
	NOT_TRACKGIN(400,"Not Tracking"),//�쥻�N�S�l��
	UNTRACK_ERROR(400,"Untrack Error"),//�h�l����
	COMMENT_ERROR(400,"Comment Error"),//�d������
	PLEASE_LOGIN_FIRST(400,"Please Login First"), //�Х��n�J�b��
	COMMENTER_ERROR(400,"Commenter Error"), //�D�ӯd�����d���b��
	COMMENT_DELETE_ERROR(400,"Comment Delete Error"), //�d���R������
	EXCEED_THE_UPPER_LIMIT(400,"Exceed The Upper Limit"),//�W�L�榸�i�ʶR�W��
	NOT_ENOUGH_TICKETS(400,"Not Enough Tickets"), //�S������������
	ORDER_ERROR(400,"Order Error"), //�U�q����
	PAYMENT_DEADLINE_EXCEEDED(400,"Payment Deadline Exceeded"), //�w�W�L�I�ڮɶ�
	BUYER_ERROR(400,"Buyer Error"), //�D�ӵ��q���ʶR�H
	PAYMENT_ERROR(400,"Payment Error"), //�I�ڥ���
	NOT_SELLING_DATE(400,"Not Selling Date"), //���b�I�ڴ���
	ORDER_EXPIRED(400,"Order Expired"), //�q��w�L��
	NOT_CANCEL_DATE(400,"Not Cancel Date"), //���b�����U�q����
	CANCEL_ERROR(400,"Cancel Error"), //�����q�楢��
	SESSIONS_ALREADY_SELLED(400,"Sessions Already Selled") //�����w�}��L�k�R��
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
