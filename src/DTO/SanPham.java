package DTO;

import java.util.Objects;

public class SanPham {
	private String maSanPham, tenSanPham;
	private int soLuongCongDoan, soLuong;
	public SanPham(String maSanPham, String tenSanPham, int soLuongCongDoan, int soLuong) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuongCongDoan = soLuongCongDoan;
		this.soLuong = soLuong;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) throws Exception {
		if(tenSanPham == null || tenSanPham.trim().isEmpty()) {
			throw new Exception("Tên sản phẩm không được trống");
		}else {
			this.tenSanPham = tenSanPham;
		}
		
	}
	public int getSoLuongCongDoan() {
		return soLuongCongDoan;
	}
	public void setSoLuongCongDoan(int soLuongCongDoan) throws Exception {
		if(soLuongCongDoan<=0) {
			throw new Exception("Số lượng công đoạn >0 ");
		}else {
			this.soLuongCongDoan = soLuongCongDoan;
		}
		
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) throws Exception {
		if(soLuong<=0) {
			throw new Exception("Số lượng >0 ");
		}else {
			this.soLuong = soLuong;
		}
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", soLuongCongDoan=" + soLuongCongDoan
				+ ", soLuong=" + soLuong + "]";
	}
	
}
