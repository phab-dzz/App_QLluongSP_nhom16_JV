package BUS;

import java.util.ArrayList;

import DTO.CongDoanSanPham;

public class CongDoanSanPham_DAO {
	private DAO.CongDoanSanPham_DAO CDsanPham= new DAO.CongDoanSanPham_DAO();
	private ArrayList<CongDoanSanPham> dsCongDoanSanPham=null;
	public CongDoanSanPham_DAO() {
		DocDanhSach();
	}
	public void DocDanhSach() {
		this.dsCongDoanSanPham= CDsanPham.getAllCongDoanSanPham();
		
	}
	public ArrayList<CongDoanSanPham> getdsCongDoanSP() {
		if(this.dsCongDoanSanPham==null)
			DocDanhSach();
		return this.dsCongDoanSanPham;
			
	}
}
