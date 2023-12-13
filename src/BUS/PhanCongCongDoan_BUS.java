package BUS;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.ConnectDB;
import DAO.PhanCongCongDoan_DAO;
import DTO.PhanCongCongDoan;
import MyCustom.MyDialog;

public class PhanCongCongDoan_BUS {
	private PhanCongCongDoan_DAO PhanCongDAO = new PhanCongCongDoan_DAO();
	private ArrayList<PhanCongCongDoan> dsPhanCong = null;

	public ArrayList<PhanCongCongDoan> getAllPhanCongCD() {
		dsPhanCong = PhanCongDAO.getALLPhanCongCongDoan();
		return dsPhanCong;
	}
	public PhanCongCongDoan getPhanCongCD(String maCN) {
		return PhanCongDAO.getPhanCong(maCN);
	}
	public ArrayList<PhanCongCongDoan> getDanhSachCanPhanCong(String chuyenMon) {
		dsPhanCong = PhanCongDAO.getDSCanPhanCong(chuyenMon);
		return dsPhanCong;
	}
	public ArrayList<PhanCongCongDoan> getDanhSachPhanCongTheoXuong(String xuong) {
		return PhanCongDAO.getDSPhanCongTheoXuong(xuong);
	}
	public int getSoLuongCongDoanPhanCong(String maCN) {
		return PhanCongDAO.getSoLuongPhanCong(maCN);
	}

	public boolean themPhanCongCongDoan(String maCN, String maSP, String maCD, int soLuongCongDoanPhanCong,
			LocalDate ngayBatDau) {
		if (!maCN.equals("")) {
			PhanCongCongDoan cd = new PhanCongCongDoan();
			cd.setMaCD(maCD);
			cd.setMaCN(maCN);
			cd.setMaSP(maSP);
			cd.setNgayBatDau(ngayBatDau);
			cd.setSoLuongCongDoanPhanCong(soLuongCongDoanPhanCong);
			boolean flag = PhanCongDAO.themPhanCongCongDoan(cd);
			if (!flag) {
				System.out.println("INSERT FAILE!");
			} else {
				System.out.println("INSERT SUCCESS!");
			}
			return flag;
		} else
			return false;
	}


	public boolean updateCongDoan(PhanCongCongDoan cd) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (!cd.getMaCN().equals("")) {
			boolean flag = PhanCongDAO.updateCD(cd);
			if (!flag) {
				System.out.println("UPDATE FAILE!");
			} else {
				System.out.println("UPDATE SUCCESS!");
			}
			return flag;
		} else
			return false;

	}
}
