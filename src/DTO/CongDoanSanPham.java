package DTO;

import java.time.LocalDate;
import java.util.Objects;

public class CongDoanSanPham {
	private String maCongDoan, tenCongDoan, maSanPham;
	private LocalDate ngayBatDau;
	private int soLuongSanPham;
	private double donGia;
	private boolean trangThai;
	public CongDoanSanPham(String maCongDoan, String tenCongDoan, String maSanPham, LocalDate ngayBatDau,
			int soLuongSanPham, double donGia, boolean trangThai) {
		super();
		this.maCongDoan = maCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.maSanPham = maSanPham;
		this.ngayBatDau = ngayBatDau;
		this.soLuongSanPham = soLuongSanPham;
		this.donGia = donGia;
		this.trangThai = trangThai;
	}
	public CongDoanSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaCongDoan() {
		return maCongDoan;
	}
	public void setMaCongDoan(String maCongDoan) {
		this.maCongDoan = maCongDoan;
	}
	public String getTenCongDoan() {
		return tenCongDoan;
	}
	public void setTenCongDoan(String tenCongDoan) throws Exception {
		if(tenCongDoan == null || tenCongDoan.trim().isEmpty()) {
			throw new Exception("Tên công đoạn không được trống");
		}else {
			this.tenCongDoan = tenCongDoan;
		}
		
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(LocalDate ngayBatDau) throws Exception {
		if(ngayBatDau.isBefore(LocalDate.now())) {
			throw new Exception("Ngày bắt đầu phải sau ngày hiện tại");
		}else {
			this.ngayBatDau = ngayBatDau;
		}
		
	}
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) throws Exception {
		if(soLuongSanPham<=0) {
			throw new Exception("Số lượng sản phẩm >0 ");
		}else {
			this.soLuongSanPham = soLuongSanPham;
		}
	
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) throws Exception {
		if(donGia<=0) {
			throw new Exception("Đơn giá >0 ");
		}else {
			this.donGia = donGia;
		}
		
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCongDoan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongDoanSanPham other = (CongDoanSanPham) obj;
		return Objects.equals(maCongDoan, other.maCongDoan);
	}
	@Override
	public String toString() {
		return "CongDoanSanPham [maCongDoan=" + maCongDoan + ", tenCongDoan=" + tenCongDoan + ", maSanPham=" + maSanPham
				+ ", ngayBatDau=" + ngayBatDau + ", soLuongSanPham=" + soLuongSanPham + ", donGia=" + donGia
				+ ", trangThai=" + trangThai + "]";
	}
	
}	
