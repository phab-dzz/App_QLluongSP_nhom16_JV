package utilities;

import DTO.BangLuongCongNhan;

public class tinhluongCN {
	public static Double ThucLanhCN(BangLuongCongNhan bl) {
		double tl=0;
		int soluongsp=10;
		int mucluongcongdoan=15000000;
		double  luongCa= (soluongsp*mucluongcongdoan)*(1+bl.getCongNhan().getTrinhDoChuyenMon());
		double tangca=(soluongsp *mucluongcongdoan)*2.4;
		double BHXH=luongCa*0.05;
		int songaynghi=5;
		tl=luongCa+tangca+bl.getPhuCap()-BHXH-(songaynghi*100000);
		return tl;
		
	}
	

}
