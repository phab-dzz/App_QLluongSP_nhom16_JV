package BUS;

import java.util.ArrayList;

import DAO.CongDoanSanPham_DAO;
import DTO.CongDoanSanPham;

public class CongDoanSanPham_BUS {
	private CongDoanSanPham_DAO CDsanPham= new DAO.CongDoanSanPham_DAO();
	private ArrayList<CongDoanSanPham> dsCongDoanSanPham;
	public ArrayList<CongDoanSanPham> getAllCongDoanSP(){
		dsCongDoanSanPham=CDsanPham.getAllCongDoanSanPham();
		return dsCongDoanSanPham;
	}
	public int dsCDSPCOUNT() {
		return dsCongDoanSanPham.size();
	}
}
