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

import DAO.NhanVien_DAO;
import DAO.ConnectDB;
import DTO.NhanVien;
//import MyCustom.MyDialog;
import CustomGUi.CustomDialog;
public class NhanVien_BUS {

	private NhanVien_DAO nhanVienDAO;
	public NhanVien_BUS() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nhanVienDAO = new NhanVien_DAO();
	}

	public ArrayList<NhanVien> getDanhSachNhanVien() {
		return nhanVienDAO.getDanhSachNhanVien();
	}
	public ArrayList<NhanVien> getDanhSachNhanVienPhongBan(String tenPhong) {
		return nhanVienDAO.getDanhSachNhanVienPhongBan(tenPhong);
	}

	public NhanVien getNhanVien(String maNhanVien) {
		NhanVien nv = nhanVienDAO.getNhanVien(maNhanVien);
		if(nv == null) {
			new CustomDialog("Không tìm thấy nhân viên", CustomDialog.ERROR_DIALOG);
			return null;
		}else {
			return nhanVienDAO.getNhanVien(maNhanVien);
		}
	}
	public boolean xoaNhanVien(String maNhanVien) {
		return nhanVienDAO.deleteNhanVien(maNhanVien);
	}

	public boolean themNhanVien(String maNhanVien, String ten, String chucDanh, String sDT, String email,
			String phongBan, String diaChi, double luongCoBan, double hsLuong,
			double luongPhuCap, boolean gioiTinh, LocalDate ngayThamGia, LocalDate ngaySinh) {

		CustomDialog validationError = validator(sDT, diaChi, ten, ngayThamGia, email, luongCoBan, ngaySinh);
		if(validationError ==null) {
			//    			double heSoLuongNV = Double.parseDouble(heSoLuong);
			//    			double luongCoBanNV = Double.parseDouble(luongCoBan);
			NhanVien nv = new NhanVien();
			nv.setMaNhanVien(maNhanVien);
			nv.setTen(ten);
			nv.setGioiTinh(gioiTinh);
			nv.setNgayThamGia(ngayThamGia);
			nv.setNgaySinh(ngaySinh);
			nv.setDiaChi(diaChi);
			nv.setsDT(sDT);
			nv.setHsLuong(hsLuong);
			nv.setLuongCoBan(luongCoBan);
			nv.setEmail(email);
			nv.setChucDanh(chucDanh);
			nv.setLuongPhuCap(luongPhuCap);
			nv.setPhongBan(phongBan);
			boolean flag = nhanVienDAO.addNhanVien(nv);
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
	
	
	public boolean updateNhanVien(String maNhanVien, String ten, String chucDanh, String sDT, String email,
			String phongBan, String diaChi, double luongCoBan, double hsLuong,
			double luongPhuCap, boolean gioiTinh, LocalDate ngayThamGia, LocalDate ngaySinh) {
		
		CustomDialog validationError = validator(sDT, diaChi, ten, ngayThamGia, email, luongCoBan, ngaySinh);
		if(validationError ==null) {
			//    			double heSoLuongNV = Double.parseDouble(heSoLuong);
			//    			double luongCoBanNV = Double.parseDouble(luongCoBan);
			NhanVien nv = new NhanVien();
			nv.setMaNhanVien(maNhanVien);
			nv.setTen(ten);
			nv.setGioiTinh(gioiTinh);
			nv.setNgayThamGia(ngayThamGia);
			nv.setNgaySinh(ngaySinh);
			nv.setDiaChi(diaChi);
			nv.setsDT(sDT);
			nv.setHsLuong(hsLuong);
			nv.setLuongCoBan(luongCoBan);
			nv.setEmail(email);
			nv.setChucDanh(chucDanh);
			nv.setLuongPhuCap(luongPhuCap);
			nv.setPhongBan(phongBan);
			boolean flag = nhanVienDAO.updateNhanVien(nv);
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

	private CustomDialog validator(String sDT, String diaChi, String ten, LocalDate ngayThamGia, String email, double luongCoBan, LocalDate ngaySinh) {
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
			return new CustomDialog("Nhân viên phải đủ 18 tuổi", CustomDialog.ERROR_DIALOG);
		}


		if (email.isEmpty()) {
			return new CustomDialog("Email không được rỗng", CustomDialog.ERROR_DIALOG);
		} else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			return new CustomDialog("Email không chứa kí tự đặc biệt và có tiền tố @", CustomDialog.ERROR_DIALOG);
		}

		if (sDT.isEmpty()) {
			return new CustomDialog("Số điện thoại không được rỗng", CustomDialog.ERROR_DIALOG);
		} else if (!sDT.matches("^0\\d{9}$")) {
			return new CustomDialog("Số điện thoại đủ 10 chữ số, bắt đầu bằng 0", CustomDialog.ERROR_DIALOG);
		}

		if(String.valueOf(luongCoBan).isBlank()) {
			return new CustomDialog("Lương cơ bản không được rỗng", CustomDialog.ERROR_DIALOG);
		}else if(luongCoBan <=0) {
			return new CustomDialog("Lương cơ bản không <=0", CustomDialog.ERROR_DIALOG);
		}else if(!kiemTraLuongCoBan(String.format("%.0f",luongCoBan))) {
			return new CustomDialog("Lương cơ bản phải thuộc kiểu số", CustomDialog.ERROR_DIALOG);
			
		}
		
		if (diaChi.isEmpty()) {
			return new CustomDialog("Địa chỉ không được rỗng", CustomDialog.ERROR_DIALOG);
		}

		return null;
	}
	public boolean kiemTraLuongCoBan(String luongCoBan) {
		char charSTK;
		for(int i=0; i<luongCoBan.length(); i++) {
			charSTK = luongCoBan.charAt(i);
			if(!Character.isDigit(charSTK)) {
				return false;
			}	
		}
		return true;
		
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
