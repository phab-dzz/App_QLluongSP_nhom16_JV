package DTO;

import java.time.LocalDate;
import java.util.Objects;

public class CongNhan {
	private String maCongNhan, ten, sDT, xuong, diaChi, chuyenMon;
	private double trinhDoChuyenMon, luongPhuCap;
	private boolean gioiTinh, trangThai;
	private LocalDate ngaySinh, ngayThamGia;
	public CongNhan(String maCongNhan, String ten, String sDT, String xuong, String diaChi, String chuyenMon,
			double trinhDoChuyenMon, double luongPhuCap, boolean gioiTinh, boolean trangThai, LocalDate ngaySinh,
			LocalDate ngayThamGia) {
		super();
		this.maCongNhan = maCongNhan;
		this.ten = ten;
		this.sDT = sDT;
		this.xuong = xuong;
		this.diaChi = diaChi;
		this.chuyenMon = chuyenMon;
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
	public CongNhan(String maCongNhan, String ten, String sDT, String chuyenMon, double luongPhuCap) {
		super();
		this.maCongNhan = maCongNhan;
		this.ten = ten;
		this.sDT = sDT;
		this.chuyenMon = chuyenMon;
		this.luongPhuCap = luongPhuCap;
	}
	public CongNhan(String maCongNhan, String ten, String sDT, String xuong, String chuyenMon) {
		super();
		this.maCongNhan = maCongNhan;
		this.ten = ten;
		this.sDT = sDT;
		this.xuong = xuong;
		this.chuyenMon = chuyenMon;
	}
	public String getMaCongNhan() {
		return maCongNhan;
	}
	public void setMaCongNhan(String maCongNhan) {
		this.maCongNhan = maCongNhan;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getXuong() {
		return xuong;
	}
	public void setXuong(String xuong) {
		this.xuong = xuong;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChuyenMon() {
		return chuyenMon;
	}
	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}
	public double getTrinhDoChuyenMon() {
		return trinhDoChuyenMon;
	}
	public void setTrinhDoChuyenMon(double trinhDoChuyenMon) {
		this.trinhDoChuyenMon = trinhDoChuyenMon;
	}
	public double getLuongPhuCap() {
		return luongPhuCap;
	}
	public void setLuongPhuCap(double luongPhuCap) {
		this.luongPhuCap = luongPhuCap;
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
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public LocalDate getNgayThamGia() {
		return ngayThamGia;
	}
	public void setNgayThamGia(LocalDate ngayThamGia) {
		this.ngayThamGia = ngayThamGia;
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
		return "CongNhan [maCongNhan=" + maCongNhan + ", ten=" + ten + ", sDT=" + sDT + ", xuong=" + xuong + ", diaChi="
				+ diaChi + ", chuyenMon=" + chuyenMon + ", trinhDoChuyenMon=" + trinhDoChuyenMon + ", luongPhuCap="
				+ luongPhuCap + ", gioiTinh=" + gioiTinh + ", trangThai=" + trangThai + ", ngaySinh=" + ngaySinh
				+ ", ngayThamGia=" + ngayThamGia + "]";
	}
	
	
}
