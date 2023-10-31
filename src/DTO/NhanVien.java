package DTO;

import java.time.LocalDate;
import java.util.Objects;

public class NhanVien {
	private String maNhanVien, hoDem, ten, chucDanh, sDT, email, phongBan, diaChi, maBangLuong, maChamCongNV, maPhieuLuong;
	private double luongCoBan, hsLuong, thueThuNhapCaNhan, luongPhuCap;
	private boolean gioiTinh;
	private LocalDate ngaySinh, ngayThamGia;

	
	public NhanVien(String maNhanVien, String hoDem, String ten, String chucDanh, String sDT, String email,
			String phongBan, String diaChi, String maBangLuong, String maChamCongNV, String maPhieuLuong,
			double luongCoBan, double hsLuong, double thueThuNhapCaNhan, double luongPhuCap, boolean gioiTinh,
			LocalDate ngaySinh, LocalDate ngayThamGia) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoDem = hoDem;
		this.ten = ten;
		this.chucDanh = chucDanh;
		this.sDT = sDT;
		this.email = email;
		this.phongBan = phongBan;
		this.diaChi = diaChi;
		this.maBangLuong = maBangLuong;
		this.maChamCongNV = maChamCongNV;
		this.maPhieuLuong = maPhieuLuong;
		this.luongCoBan = luongCoBan;
		this.hsLuong = hsLuong;
		this.thueThuNhapCaNhan = thueThuNhapCaNhan;
		this.luongPhuCap = luongPhuCap;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.ngayThamGia = ngayThamGia;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaBangLuong() {
		return maBangLuong;
	}

	public void setMaBangLuong(String maBangLuong) {
		this.maBangLuong = maBangLuong;
	}

	public String getMaChamCongNV() {
		return maChamCongNV;
	}

	public void setMaChamCongNV(String maChamCongNV) {
		this.maChamCongNV = maChamCongNV;
	}

	public String getMaPhieuLuong() {
		return maPhieuLuong;
	}

	public void setMaPhieuLuong(String maPhieuLuong) {
		this.maPhieuLuong = maPhieuLuong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoDem() {
		
		return hoDem;
	}

	public void setHoDem(String hoDem) throws Exception {
		if(hoDem == null || hoDem.trim().isEmpty()) {
			throw new Exception("Họ không được để trống");
		}else {
			this.hoDem = hoDem;
		}
		
	}

	public String getTen() {
		
		return ten;
	}

	public void setTen(String ten) throws Exception {
		if(ten == null || ten.trim().isEmpty()) {
			throw new Exception("Tên không được để trống");
		}else {
			this.ten = ten;
		}
		
	}

	public String getChucDanh() {
		return chucDanh;
	}

	public void setChucDanh(String chucDanh) throws Exception {
		if(chucDanh == null || chucDanh.trim().isEmpty()) {
			throw new Exception("Chức danh không được để trống");
		}else {
			this.chucDanh = chucDanh;
		}
		
	}

	public String getsDT() {
		return sDT;
	}
	
	public void setsDT(String sDT) throws Exception {
		if (sDT == null || sDT.trim().isEmpty()) {
            throw new Exception("Số điện thoại không được để trống");
        }else if (!sDT.matches("^0\\d{9}$")) {
            throw new Exception("Số điện thoại không hợp lệ");
        }else {
        	this.sDT = sDT;
        }
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		if (email == null || email.trim().isEmpty()) {
            throw new Exception("Email không được để trống");
        }else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new Exception("Email không hợp lệ");
        }else {
        	this.email = email;
        }
		
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) throws Exception {
		if(phongBan == null || phongBan.trim().isEmpty()) {
			throw new Exception("Phòng ban không được để trống");
		}else {
			this.phongBan = phongBan;
		}
		
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) throws Exception {
		if(diaChi == null || diaChi.trim().isEmpty()) {
			throw new Exception("Địa chỉ không được để trống");
		}else {
			this.diaChi = diaChi;
		}
		
	}

	public double getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) throws Exception {
		if(luongCoBan <=0) {
			throw new Exception("Lương cơ bản >0");
		}else {
			this.luongCoBan = luongCoBan;
		}
		
	}

	public double getHsLuong() {
		return hsLuong;
	}

	public void setHsLuong(double hsLuong) throws Exception {
		if(hsLuong <=0) {
			throw new Exception("Hệ số lương >0");
		}else {
			this.hsLuong = hsLuong;
		}
		
	}

	public double getThueThuNhapCaNhan() {
		return thueThuNhapCaNhan;
	}

	

	public void setThueThuNhapCaNhan(double thueThuNhapCaNhan) throws Exception {
		if(thueThuNhapCaNhan<=0) {
			throw new Exception("Thuế thu nhập cá nhân >0 ");
		}else {
			this.thueThuNhapCaNhan = thueThuNhapCaNhan;
		}
		
	}

	public double getLuongPhuCap() {
		return luongPhuCap;
	}

	public void setLuongPhuCap(double luongPhuCap) throws Exception {
		if(luongPhuCap<=0) {
			throw new Exception("Lương phụ cấp >0 ");
		}else {
			this.luongPhuCap = luongPhuCap;
		}
		
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) throws Exception {
		LocalDate eighteenYearsAgo = LocalDate.now().minusYears(18);
	    if (ngaySinh.isAfter(eighteenYearsAgo)) {
	    	throw new Exception("Ngày sinh phải là người có ít nhất 18 tuổi.");
	    }else {
	    	this.ngaySinh = ngaySinh;
	    }
		
	}

	public LocalDate getNgayThamGia() {
		return ngayThamGia;
	}

	public void setNgayThamGia(LocalDate ngayThamGia) throws Exception {
		if(ngayThamGia.isAfter(LocalDate.now())) {
			throw new Exception("Ngày tham gia không được sau ngày hiện tại!");
		}else {
			this.ngayThamGia = ngayThamGia;
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}
	
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoDem=" + hoDem + ", Ten=" + ten + ", chucDanh=" + chucDanh
				+ ", sDT=" + sDT + ", email=" + email + ", phongBan=" + phongBan + ", diaChi=" + diaChi
				+ ", luongCoBan=" + luongCoBan + ", hsLuong=" + hsLuong + ", thueThuNhapCaNhan=" + thueThuNhapCaNhan
				+ ", luongPhuCap=" + luongPhuCap + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh
				+ ", ngayThamGia=" + ngayThamGia + "]";
	}
	
}
