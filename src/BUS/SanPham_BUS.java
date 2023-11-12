package BUS;

import java.util.ArrayList;

import DAO.CongNhan_DAO;
import DAO.SanPham_DAO;
import DTO.CongNhan;
import DTO.SanPham;

public class SanPham_BUS {
	private SanPham_DAO spDAO= new SanPham_DAO();
	private ArrayList<SanPham>  dsSanPham;
	 
	public ArrayList<SanPham> getAllSanPham() {
         dsSanPham = spDAO.getAllSanPham();
        return dsSanPham;
    }

    public int getSanPhamCount() {
       
        return dsSanPham.size();
    }

	
}
