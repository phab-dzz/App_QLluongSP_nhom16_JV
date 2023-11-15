package DTO;

import java.sql.Date;
import java.util.Objects;

public class CongDoanSanPham {
	private String maCongDoan, tenCongDoan;
	private SanPham sanPham;
	private Date ngayBatDau, ngayChiaCD;
	private float donGia;
	private int soLuong;

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Date getNgayChiaCD() {
		return ngayChiaCD;
	}

	public void setNgayChiaCD(Date ngayChiaCD) {
		this.ngayChiaCD = ngayChiaCD;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public CongDoanSanPham(String maCongDoan, String tenCongDoan, SanPham sanPham, Date ngayBatDau, Date ngayChiaCD,
			float donGia, int soLuong) {
		super();
		this.maCongDoan = maCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.sanPham = sanPham;
		this.ngayBatDau = ngayBatDau;
		this.ngayChiaCD = ngayChiaCD;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public CongDoanSanPham() {
		super();
	}

	public CongDoanSanPham(String maCongDoan) {
		super();
		this.maCongDoan = maCongDoan;
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
		if (tenCongDoan == null || tenCongDoan.trim().isEmpty()) {
			throw new Exception("Tên công đoạn không được trống");
		} else {
			this.tenCongDoan = tenCongDoan;
		}
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
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
		return "CongDoanSanPham [maCongDoan=" + maCongDoan + ", tenCongDoan=" + tenCongDoan + ", sanPham=" + sanPham
				+ ", ngayChiaCD=" + ngayChiaCD + ", ngayBatDau=" + ngayBatDau + ", donGia=" + donGia + "]";
	}

}
