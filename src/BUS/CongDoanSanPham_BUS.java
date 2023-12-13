package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CongDoanSanPham_DAO;
import DAO.ConnectDB;
import DTO.CongDoanSanPham;

public class CongDoanSanPham_BUS {
	private CongDoanSanPham_DAO CDsanPham = new DAO.CongDoanSanPham_DAO();
	private ArrayList<CongDoanSanPham> dsCongDoanSanPham;

	public ArrayList<CongDoanSanPham> getAllCongDoanSP() {
		dsCongDoanSanPham = CDsanPham.getAllCongDoanSanPham();
		return dsCongDoanSanPham;
	}

	public boolean updateTrangThaiPhanCongCD(String maCD) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return CDsanPham.updateTrangThaiPhanCongCD(maCD);
	}

	public ArrayList<Boolean> getTrangThaiCongDoanTruocDo(String maSanPham, int doUuTien) {
		return CDsanPham.getTrangThaiCongDoanTruocDo(maSanPham, doUuTien);
	}

	public CongDoanSanPham getCongDoanSanPham(String maCongDoan) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return CDsanPham.getCongDoanSanPham(maCongDoan);
	}

	public int dsCDSPCOUNT() {
		return dsCongDoanSanPham.size();
	}
}
