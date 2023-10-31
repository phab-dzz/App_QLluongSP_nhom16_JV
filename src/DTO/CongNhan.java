package DTO;

import java.time.LocalDate;
import java.util.Objects;

public class CongNhan {
	private String maCongNhan, hoDem, ten, sDT, xuong, diaChi;
	private double trinhDoChuyenMon, luongPhuCap;
	private boolean gioiTinh, trangThai;
	private LocalDate ngaySinh, ngayThamGia;
	public CongNhan(String maCongNhan, String hoDem, String ten, String sDT, String xuong, String diaChi,
			double trinhDoChuyenMon, double luongPhuCap, boolean gioiTinh, boolean trangThai, LocalDate ngaySinh,
			LocalDate ngayThamGia) {
		super();
		this.maCongNhan = maCongNhan;
		this.hoDem = hoDem;
		this.ten = ten;
		this.sDT = sDT;
		this.xuong = xuong;
		this.diaChi = diaChi;
		this.trinhDoChuyenMon = trinhDoChuyenMon;
		this.luongPhuCap = luongPhuCap;
		this.gioiTinh = gioiTinh;
		this.trangThai = trangThai;
		this.ngaySinh = ngaySinh;
		this.ngayThamGia = ngayThamGia;
	}
	public CongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaCongNhan() {
		return maCongNhan;
	}
	public void setMaCongNhan(String maCongNhan) {
		this.maCongNhan = maCongNhan;
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
	public String getXuong() {
		return xuong;
	}
	public void setXuong(String xuong) throws Exception {
		if(ten == null || ten.trim().isEmpty()) {
			throw new Exception("Xưởng không được để trống");
		}else {
			this.xuong = xuong;
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
	public double getTrinhDoChuyenMon() {
		return trinhDoChuyenMon;
	}
	public void setTrinhDoChuyenMon(double trinhDoChuyenMon) throws Exception {
		if(trinhDoChuyenMon <=0) {
			throw new Exception("Trình độ chuyên môn >0");
		}else {
			this.trinhDoChuyenMon = trinhDoChuyenMon;
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
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
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
		return Objects.hash(maCongNhan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongNhan other = (CongNhan) obj;
		return Objects.equals(maCongNhan, other.maCongNhan);
	}
	@Override
	public String toString() {
		return "CongNhan [maCongNhan=" + maCongNhan + ", hoDem=" + hoDem + ", ten=" + ten + ", sDT=" + sDT + ", Xuong="
				+ xuong + ", diaChi=" + diaChi + ", trinhDoChuyenMon=" + trinhDoChuyenMon + ", luongPhuCap="
				+ luongPhuCap + ", gioiTinh=" + gioiTinh + ", trangThai=" + trangThai + ", ngaySinh=" + ngaySinh
				+ ", ngayThamGia=" + ngayThamGia + "]";
	}
	
}
