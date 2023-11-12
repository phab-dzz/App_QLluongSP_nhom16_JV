package BUS;

import java.sql.SQLException;

import CustomGUi.CustomDialog;
import DAO.ConnectDB;
import DAO.TaiKhoan_DAO;
import DTO.TaiKhoan;

public class TaiKhoan_BUS {
	
	private TaiKhoan_DAO taiKhoanDAO;
	public TaiKhoan_BUS() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		taiKhoanDAO = new TaiKhoan_DAO();
	}
	
	public int kiemTraPhanQuyen(String maTK) {
		int type;
		if(maTK.startsWith("KT")) {
			type = 1;
		}else if(maTK.startsWith("TP")) {
			type = 2;
		}else if(maTK.startsWith("XT")) {
			type = 3;
		}else {
			type = 4;
		}
		return type;
	}
	
	public boolean KiemTraTaiKhoan(String maTK, String matKhau) {
		TaiKhoan tk = taiKhoanDAO.getTaiKhoan(maTK);
		if(tk == null || !matKhau.equals(tk.getMatKhau())) {
			return false;
		}else {
			return true;
		}
	}
}
