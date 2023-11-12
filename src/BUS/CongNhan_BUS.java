package BUS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CongNhan_DAO;
import DAO.ConnectDB;
import DTO.CongNhan;
//import MyCustom.MyDialog;
import CustomGUi.CustomDialog;
public class CongNhan_BUS {

	private CongNhan_DAO congNhanDAO;
	public CongNhan_BUS() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		congNhanDAO = new CongNhan_DAO();
	}
	
	public ArrayList<CongNhan> getDanhSachCongNhan() {
		return congNhanDAO.getDanhSachCongNhan();
	}
	public ArrayList<CongNhan> getDanhSachCongNhanXuong(String tenXuong) {
		return congNhanDAO.getDanhSachCongNhanXuong(tenXuong);
	}

	public CongNhan getCongNhan(String maCongNhan) {
		CongNhan cn = congNhanDAO.getCongNhan(maCongNhan);
		if(cn == null) {
			new CustomDialog("Không tìm thấy công nhân", CustomDialog.ERROR_DIALOG);
			return null;
		}else {
			return congNhanDAO.getCongNhan(maCongNhan);
		}
	}
	public boolean xoaCongNhan(String maCongNhan) {
		return congNhanDAO.deleteCongNhan(maCongNhan);
	}

	public boolean themCongNhan(String maCongNhan, String ten, String sDT, String xuong, String diaChi, String chuyenMon,
			double trinhDoChuyenMon, double luongPhuCap, boolean gioiTinh, boolean trangThai, LocalDate ngaySinh,
			LocalDate ngayThamGia) {

		CustomDialog validationError = validator(sDT, diaChi, ten, ngayThamGia, ngaySinh);
		if(validationError ==null) {
			//    			double heSoLuongNV = Double.parseDouble(heSoLuong);
			//    			double luongCoBanNV = Double.parseDouble(luongCoBan);
			CongNhan cn = new CongNhan();
			cn.setMaCongNhan(maCongNhan);
			cn.setTen(ten);
			cn.setGioiTinh(gioiTinh);
			cn.setTrangThai(trangThai);
			cn.setNgayThamGia(ngayThamGia);
			cn.setNgaySinh(ngaySinh);
			cn.setDiaChi(diaChi);
			cn.setsDT(sDT);
			cn.setTrinhDoChuyenMon(trinhDoChuyenMon);
			cn.setChuyenMon(chuyenMon);
			cn.setLuongPhuCap(luongPhuCap);
			cn.setXuong(xuong);
			boolean flag = congNhanDAO.addCongNhan(cn);
			if (!flag) {
				new CustomDialog("Thêm thất bại!", CustomDialog.ERROR_DIALOG);
			} else {
				new CustomDialog("Thêm thành công!", CustomDialog.SUCCESS_DIALOG);
			}
			return flag;
		}
		else
			return false;
	}
	
	
	public boolean updateCongNhan(String maCongNhan, String ten, String sDT, String xuong, String diaChi, String chuyenMon,
			double trinhDoChuyenMon, double luongPhuCap, boolean gioiTinh, boolean trangThai, LocalDate ngaySinh,
			LocalDate ngayThamGia) {
		
		CustomDialog validationError = validator(sDT, diaChi, ten, ngayThamGia, ngaySinh);
		if(validationError ==null) {
			
			
			CongNhan cn = new CongNhan();
			cn.setMaCongNhan(maCongNhan);
			cn.setTen(ten);
			cn.setGioiTinh(gioiTinh);
			cn.setTrangThai(trangThai);
			cn.setNgayThamGia(ngayThamGia);
			cn.setNgaySinh(ngaySinh);
			cn.setDiaChi(diaChi);
			cn.setsDT(sDT);
			cn.setTrinhDoChuyenMon(trinhDoChuyenMon);
			cn.setChuyenMon(chuyenMon);
			cn.setLuongPhuCap(luongPhuCap);
			cn.setXuong(xuong);
			boolean flag = congNhanDAO.updateCongNhan(cn);
			if (!flag) {
				new CustomDialog("Update thất bại!", CustomDialog.ERROR_DIALOG);
			} else {
				new CustomDialog("Update thành công!", CustomDialog.SUCCESS_DIALOG);
			}
			return flag;
		}
		else
			return false;
	}

	private CustomDialog validator(String sDT, String diaChi, String ten, LocalDate ngayThamGia, LocalDate ngaySinh) {
		if (ten.isEmpty()) {
			return new CustomDialog("Tên không được rỗng", CustomDialog.ERROR_DIALOG);
		} else if (ten.matches(".*[!@#$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/].*")) {
			return new CustomDialog("Tên không chứa kí tự đặc biệt", CustomDialog.ERROR_DIALOG);
		} 

		if (ngayThamGia == null) {
			return new CustomDialog("Ngày tham gia không được rỗng", CustomDialog.ERROR_DIALOG);
		} else if (ngayThamGia.isAfter(LocalDate.now())) {
			return new CustomDialog("Ngày tham gia không sau ngày hiện tại", CustomDialog.ERROR_DIALOG);
		}

		LocalDate eighteenYearsAgo = LocalDate.now().minusYears(18);
		if (ngaySinh == null) {
			return new CustomDialog("Ngày sinh không được rỗng", CustomDialog.ERROR_DIALOG);
		} else if (ngaySinh.isAfter(eighteenYearsAgo)) {
			return new CustomDialog("Công nhân phải đủ 18 tuổi", CustomDialog.ERROR_DIALOG);
		}

		if (sDT.isEmpty()) {
			return new CustomDialog("Số điện thoại không được rỗng", CustomDialog.ERROR_DIALOG);
		} else if (!sDT.matches("^0\\d{9}$")) {
			return new CustomDialog("Số điện thoại đủ 10 chữ số, bắt đầu bằng 0", CustomDialog.ERROR_DIALOG);
		}

		if (diaChi.isEmpty()) {
			return new CustomDialog("Địa chỉ không được rỗng", CustomDialog.ERROR_DIALOG);
		}

		return null;
	}
	public void closeConnection() {
		try {
			ConnectDB.getInstance().disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

