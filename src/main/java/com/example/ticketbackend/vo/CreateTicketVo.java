package com.example.ticketbackend.vo;

public class CreateTicketVo {

	private String buyNum;
	
	private int sessionsNum;
	
	private String account;
	
	private boolean payment;
	
	private String area;
	
	private int seatNum;
	
	private String realName;
	
	private String userName;

	public CreateTicketVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateTicketVo(String buyNum, int sessionsNum, String account, boolean payment, String area, int seatNum,
			String realName, String userName) {
		super();
		this.buyNum = buyNum;
		this.sessionsNum = sessionsNum;
		this.account = account;
		this.payment = payment;
		this.area = area;
		this.seatNum = seatNum;
		this.realName = realName;
		this.userName = userName;
	}

	public String getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(String buyNum) {
		this.buyNum = buyNum;
	}

	public int getSessionsNum() {
		return sessionsNum;
	}

	public void setSessionsNum(int sessionsNum) {
		this.sessionsNum = sessionsNum;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
	
}
