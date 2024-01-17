package com.example.ticketbackend.vo;

public class BuyReq {
	
	private int sessionNum;
	
	private String area;
	
	private int buyPieces;

	public BuyReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyReq(int sessionNum, String area, int buyPieces) {
		super();
		this.sessionNum = sessionNum;
		this.area = area;
		this.buyPieces = buyPieces;
	}

	public int getSessionNum() {
		return sessionNum;
	}

	public void setSessionNum(int sessionNum) {
		this.sessionNum = sessionNum;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getBuyPieces() {
		return buyPieces;
	}

	public void setBuyPieces(int buyPieces) {
		this.buyPieces = buyPieces;
	}
	
	
	
	

}
