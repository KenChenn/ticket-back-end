package com.example.ticketbackend.service.ifs;

import java.sql.Blob;
import java.time.LocalDate;

import com.example.ticketbackend.vo.GetCommodityDataRes;
import com.example.ticketbackend.vo.RtnCodeRes;

public interface CommodityService {

	//�s�W�`��
	public RtnCodeRes addCommodity(String codename, String name, String introduction, Boolean entity, LocalDate startDate,
			LocalDate endDate, String place, String keyvisualImg, String introduceImg1, String introduceImg2,
			String organizer);
	
	//����浧�`�ظ��
	public GetCommodityDataRes getCommodityDate(String codename);
	
	//�s��`��
	public  RtnCodeRes updateCommodity(String codename, String name, String introduction, Boolean entity, LocalDate startDate,
			LocalDate endDate, String place, String keyvisualImg, String introduceImg1, String introduceImg2,
			String organizer);
	
	public GetCommodityDataRes searchCommodity(String name);
}
	
	
	
