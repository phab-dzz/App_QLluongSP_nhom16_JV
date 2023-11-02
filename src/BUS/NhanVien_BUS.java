package BUS;

import java.util.ArrayList;

import DAO.NhanVien_DAO;
import DTO.NhanVien;

public class NhanVien_BUS {
	private NhanVien_DAO nvDAO= new NhanVien_DAO();
	private ArrayList<NhanVien> dsNhanVien=null;
	 public NhanVien_BUS() {
		// TODO Auto-generated constructor stub
	 
		docDanhSach();
	}

	public void docDanhSach() {
		this.dsNhanVien = nvDAO.getAllNhanVien();
	}

	public ArrayList<NhanVien> getDanhSachNhanVien() {
		if (this.dsNhanVien == null)
			docDanhSach();
		return this.dsNhanVien;
	}

}
