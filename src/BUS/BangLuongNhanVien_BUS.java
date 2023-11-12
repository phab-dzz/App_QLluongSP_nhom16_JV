package BUS;

import java.util.ArrayList;

import DAO.BangChamCongNhanVien_DAO;
import DAO.BangLuongNhanVien_DAO;
import DTO.BangLuongNhanVien;

public class BangLuongNhanVien_BUS {
	private BangLuongNhanVien_DAO BangLuongNVDAO= new BangLuongNhanVien_DAO();
	private ArrayList<BangLuongNhanVien> dsBangLuongNV=null;
	public ArrayList<BangLuongNhanVien> getDsBangLuongNhanVien() {
		dsBangLuongNV=BangLuongNVDAO.getALLbangluongNV();
		return dsBangLuongNV;
	}

	public void docDanhSach() {
		this.dsBangLuongNV = BangLuongNVDAO.getALLbangluongNV();
	}
//	public ArrayList<BangLuongNhanVien> getdsbangLuongNVTK_ma(String ma){
//		dsBangLuongNV=BangLuongNVDAO.getallbangLuongNVTK(ma);
//		return dsBangLuongNV;
//	}
	public ArrayList<BangLuongNhanVien> timBangLuongNV(String ma){
		ArrayList<BangLuongNhanVien> dsNV=BangLuongNVDAO.getallbangLuongNVTK(ma);
		return dsNV;
	}
	public ArrayList<BangLuongNhanVien> getNVnam(String nam){
		return BangLuongNVDAO.getalltheonam(nam);
	}
	public ArrayList<BangLuongNhanVien> getNVthang(String thang){
		return BangLuongNVDAO.getalltheothang(thang);
	}
	public ArrayList<BangLuongNhanVien> getNV_namThang(String nam, String thang){
		return BangLuongNVDAO.getBLNV_tg(nam, thang);
	}
	
	

}
