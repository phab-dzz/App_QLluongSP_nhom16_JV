package BUS;

import java.util.ArrayList;

import DAO.SanPham_DAO;
import DTO.SanPham;

public class SanPham_BUS {
	private SanPham_DAO spDAO= new SanPham_DAO();
	private ArrayList<SanPham>  dsSanPham= null;
	public SanPham_BUS() {
		DocDanhSach();
	}
	public void DocDanhSach() {
		this.dsSanPham= spDAO.getAllSanPham();
	}
	public ArrayList<SanPham> getlistSanPham(){
		if(this.dsSanPham==null)
				DocDanhSach();
		return this.dsSanPham;
	}
	
}
