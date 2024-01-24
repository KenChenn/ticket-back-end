package com.example.ticketbackend.vo;

import java.time.LocalDateTime;
import java.util.List;

public class UpdateSessionReq {

	private int num;

	private String commodity_codename;

	private LocalDateTime showDateTime;

	private LocalDateTime startSellDateTime;

	private LocalDateTime endSellDateTime;

	private List<SeatReq> seatData;

	public UpdateSessionReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateSessionReq(int num, String commodity_codename, LocalDateTime showDateTime,
			LocalDateTime startSellDateTime, LocalDateTime endSellDateTime, List<SeatReq> seatData) {
		super();
		this.num = num;
		this.commodity_codename = commodity_codename;
		this.showDateTime = showDateTime;
		this.startSellDateTime = startSellDateTime;
		this.endSellDateTime = endSellDateTime;
		this.seatData = seatData;
	}
	
	public UpdateSessionReq(int num, String commodity_codename, LocalDateTime showDateTime,
			LocalDateTime startSellDateTime, LocalDateTime endSellDateTime) {
		super();
		this.num = num;
		this.commodity_codename = commodity_codename;
		this.showDateTime = showDateTime;
		this.startSellDateTime = startSellDateTime;
		this.endSellDateTime = endSellDateTime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCommodity_codename() {
		return commodity_codename;
	}

	public void setCommodity_codename(String commodity_codename) {
		this.commodity_codename = commodity_codename;
	}

	public LocalDateTime getShowDateTime() {
		return showDateTime;
	}

	public void setShowDateTime(LocalDateTime showDateTime) {
		this.showDateTime = showDateTime;
	}

	public LocalDateTime getStartSellDateTime() {
		return startSellDateTime;
	}

	public void setStartSellDateTime(LocalDateTime startSellDateTime) {
		this.startSellDateTime = startSellDateTime;
	}

	public LocalDateTime getEndSellDateTime() {
		return endSellDateTime;
	}

	public void setEndSellDateTime(LocalDateTime endSellDateTime) {
		this.endSellDateTime = endSellDateTime;
	}

	public List<SeatReq> getSeatData() {
		return seatData;
	}

	public void setSeatData(List<SeatReq> seatData) {
		this.seatData = seatData;
	}

}
