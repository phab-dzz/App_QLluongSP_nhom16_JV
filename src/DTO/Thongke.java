package DTO;

import java.util.ArrayList;

public class Thongke {
	private int soLuongNhanVien;
	private int soLuongSanPham;
	private int soLuongCongNhan;
	private int soLuongCongDoan;
	private double tongLuong;
//	private ArrayList<NhanVien> dsNV;
	public Thongke(int soLuongNhanVien, int soLuongSanPham, int soLuongCongNhan, int soLuongCongDoan, double tongLuong) {
	
		this.soLuongNhanVien = soLuongNhanVien;
		this.soLuongSanPham = soLuongSanPham;
		this.soLuongCongNhan = soLuongCongNhan;
		this.soLuongCongDoan = soLuongCongDoan;
		this.tongLuong = tongLuong;
//		this.dsNV = dsNV;
	}
	public Thongke() {
		
	}
	public int getSoLuongNhanVien() {
		return soLuongNhanVien;
	}
	public double getTongLuong() {
		return tongLuong;
	}
	public void setTongLuong(double tongLuong) {
		this.tongLuong = tongLuong;
	}
	public void setSoLuongNhanVien(int soLuongNhanVien) {
		this.soLuongNhanVien = soLuongNhanVien;
	}
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}
	public int getSoLuongCongNhan() {
		return soLuongCongNhan;
	}
	public void setSoLuongCongNhan1(int soLuongCongNhan) {
		this.soLuongCongNhan = soLuongCongNhan;
	}
	public int getSoLuongCongDoan() {
		return soLuongCongDoan;
	}
	public void setSoLuongCongDoan(int soLuongCongDoan) {
		this.soLuongCongDoan = soLuongCongDoan;
	}
//	public double getTongLuong() {
//		return tongLuong;
//	}
//	public void setTongLuong(double tongLuong) {
//		this.tongLuong = tongLuong;
//	}
//	public ArrayList<NhanVien> getDsNV() {
//		return dsNV;
//	}
//	public void setDsNV(ArrayList<NhanVien> dsNV) {
//		this.dsNV = dsNV;
//	}
	

	
	

}
