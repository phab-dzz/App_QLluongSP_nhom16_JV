package DTO;

import java.time.LocalDate;
import java.util.Objects;

public class PhieuLuong {
	private String maPhieuLuong, maBangLuong, ten, hoDem;
	private double thucLanh;
	private LocalDate ngayNhanLuong;
	public PhieuLuong(String maPhieuLuong, String maBangLuong, String ten, String hoDem, double thucLanh,
			LocalDate ngayNhanLuong) {
		super();
		this.maPhieuLuong = maPhieuLuong;
		this.maBangLuong = maBangLuong;
		this.ten = ten;
		this.hoDem = hoDem;
		this.thucLanh = thucLanh;
		this.ngayNhanLuong = ngayNhanLuong;
	}
	public PhieuLuong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaPhieuLuong() {
		return maPhieuLuong;
	}
	public void setMaPhieuLuong(String maPhieuLuong) {
		this.maPhieuLuong = maPhieuLuong;
	}
	public String getMaBangLuong() {
		return maBangLuong;
	}
	public void setMaBangLuong(String maBangLuong) {
		this.maBangLuong = maBangLuong;
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
	public double getThucLanh() {
		return thucLanh;
	}
	public void setThucLanh(double thucLanh) throws Exception {
		if(thucLanh<=0) {
			throw new Exception("Lương thực lãnh >0 ");
		}else {
			this.thucLanh = thucLanh;
		}
		
	}
	public LocalDate getNgayNhanLuong() {
		return ngayNhanLuong;
	}
	public void setNgayNhanLuong(LocalDate ngayNhanLuong) {
		this.ngayNhanLuong = ngayNhanLuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhieuLuong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuLuong other = (PhieuLuong) obj;
		return Objects.equals(maPhieuLuong, other.maPhieuLuong);
	}
	@Override
	public String toString() {
		return "PhieuLuong [maPhieuLuong=" + maPhieuLuong + ", maBangLuong=" + maBangLuong + ", ten=" + ten + ", hoDem="
				+ hoDem + ", thucLang=" + thucLanh + ", ngayNhanLuong=" + ngayNhanLuong + "]";
	}
	
}
