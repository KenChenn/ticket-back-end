package com.example.ticketbackend.service.ifs;

import java.time.LocalDate;

import com.example.ticketbackend.vo.GetAllCommodity;
import com.example.ticketbackend.vo.GetCommodityDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;
import com.example.ticketbackend.vo.SearchCommodityDataRes;

public interface CommodityService {

	//檢查資料用
	public RtnCodeRes commodityDataCheck(String codename, String name, String introduction, Boolean entity,
			LocalDate startDate, LocalDate endDate, String place, String organizer);
	
	//新增節目
	public RtnCodeRes addCommodity(String codename, String name, String introduction, Boolean entity, LocalDate startDate,
			LocalDate endDate, String place, String keyvisualImg, String introduceImg1, String introduceImg2,
			String organizer);
	
	//獲取單筆節目資料
	public GetCommodityDataRes getCommodityDate(String codename);
	
	//編輯節目
	public  RtnCodeRes updateCommodity(String codename, String name, String introduction, Boolean entity, LocalDate startDate,
			LocalDate endDate,String place, String keyvisualImg, String introduceImg1, String introduceImg2,
			String organizer);
	
	public SearchCommodityDataRes searchCommodity(String name);
	
	public RtnCodeRes checkCodeName(String codename);
	
	public RtnCodeRes deleteCommodity(String codename);
	
	public GetAllCommodity getAllCommodity();
	
}
	
	
	
