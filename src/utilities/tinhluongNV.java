package utilities;

import DTO.BangChamCongNhanVien;
import DTO.BangLuongNhanVien;

public class tinhluongNV {
	public static double ThueThuThapCaNhan( BangLuongNhanVien l) {
		double thuesuat;
		double thuthapchiuthue=l.getLuongCoBan()+l.getPhuCap()-(0.08*4500000+730000);
		if(l.getLuongThang()<=5000000)
			thuesuat=0.05;
		else if(l.getLuongThang()>5000000&& l.getLuongThang()<10000000)
			thuesuat=0.1;
		else
			thuesuat=0.15;
		return thuthapchiuthue*thuesuat;
		
	}
	public static double thuclanhNV(BangLuongNhanVien l,BangChamCongNhanVien cc) {
		double TTCN=ThueThuThapCaNhan(l);
		
		double khoantru=l.getBaoHiemXH()+cc.getSoNgayNghi()*150000-TTCN;
		double khoanluong=((l.getLuongCoBan()+l.getNv().getHsLuong())/26)*cc.getSoNgayLamViec()+cc.getSoGioTangCa()*((l.getLuongCoBan()+l.getNv().getHsLuong())/26/8)*2+l.getPhuCap();
		return (khoanluong-khoantru);
	}

}
