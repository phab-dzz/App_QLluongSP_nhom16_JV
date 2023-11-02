package BUS;

import java.util.ArrayList;

import DAO.BangChamCongNhanVien_DAO;
import DAO.BangLuongNhanVien_DAO;
import DTO.BangLuongNhanVien;

public class BangLuongNhanVien_BUS {
	private BangLuongNhanVien_DAO BangLuongNVDAO= new BangLuongNhanVien_DAO();
	private ArrayList<BangLuongNhanVien> dsBangLuongNV=null;
	 public BangLuongNhanVien_BUS() {
		 
		// TODO Auto-generated constructor stub
	 
		docDanhSach();
	}

	public void docDanhSach() {
		this.dsBangLuongNV = BangLuongNVDAO.getALLbangluongNV();
	}

	public ArrayList<BangLuongNhanVien> getDsBangLuongNhanVien() {
		if (this.dsBangLuongNV == null)
			docDanhSach();
		return this.dsBangLuongNV;
	}
}
