package DTO;

import java.time.LocalDate;

public class PhanCongCongDoan {
	private String maCN;
	private String maSP;

	private String maCD;
	private int soLuongCongDoanPhanCong;
	private LocalDate ngayBatDau;

	public PhanCongCongDoan(String maCN, String maSP, String maCD, int soLuongCongDoanPhanCong, LocalDate ngayBatDau) {
		super();
		this.maCN = maCN;
		this.maSP = maSP;
		this.maCD = maCD;
		this.soLuongCongDoanPhanCong = soLuongCongDoanPhanCong;
		this.ngayBatDau = ngayBatDau;
	}

	public PhanCongCongDoan() {
		super();
	}

	public int getSoLuongCongDoanPhanCong() {
		return soLuongCongDoanPhanCong;
	}

	public void setSoLuongCongDoanPhanCong(int soLuongCongDoanPhanCong) {
		this.soLuongCongDoanPhanCong = soLuongCongDoanPhanCong;
	}

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getMaCN() {
		return maCN;
	}

	public void setMaCN(String maCN) {
		this.maCN = maCN;
	}

	public String getMaCD() {
		return maCD;
	}

	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}

}
