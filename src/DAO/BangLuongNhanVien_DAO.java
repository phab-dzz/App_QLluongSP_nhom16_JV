package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.BangLuongNhanVien;
import DTO.NhanVien;
import utilities.ProcessDate;

public class BangLuongNhanVien_DAO {
	public ArrayList<BangLuongNhanVien> getALLbangluongNV(){
		ArrayList<BangLuongNhanVien> dsBangLuongNV= new ArrayList<BangLuongNhanVien>();
		try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
//		String sql = "select * from BangLuongNhanVien";
		String sql="select * from BangluongNhanVien l join NhanVien nv on l.MaNV=nv.maNhanVien";
		Statement statement = (Statement) con.createStatement();
		ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
		while(rs.next()) {
			NhanVien nv=new NhanVien(rs.getString("maNhanVien"),rs.getString("ten"),rs.getString("phongBan"));
			LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
			dsBangLuongNV.add(new BangLuongNhanVien(rs.getString("maBangLuong"),rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),rs.getDouble("luongCoBan"),ngayTinh,nv));
			
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dsBangLuongNV;
	}
	public ArrayList<BangLuongNhanVien> getallbangLuongNVTK(String ma){
		ArrayList<BangLuongNhanVien> dsBangLuongNVTK= new ArrayList<BangLuongNhanVien>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		String sql= "select * from BangluongNhanVien l join NhanVien nv on l.MaNV=nv.maNhanVien where maNhanVien = ? ";
		
		try {
		PreparedStatement	stmt = con.prepareStatement(sql);
		stmt.setString(1, ma);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {
			NhanVien nv=new NhanVien(rs.getString("maNhanVien"),rs.getString("ten"),rs.getString("phongBan"));
			LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
			dsBangLuongNVTK.add(new BangLuongNhanVien(rs.getString("maBangLuong"),rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),rs.getDouble("luongCoBan"),ngayTinh,nv));
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsBangLuongNVTK;
	
	}
	public ArrayList<BangLuongNhanVien> getalltheonam(String nam){
		ArrayList<BangLuongNhanVien> dsBLNVtheonam= new ArrayList<>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement prtm;
		try {
			prtm = con.prepareStatement("select * from BangLuongNhanVien l join NhanVien nv on l.MaNV=nv.maNhanVien where year(thoiGian)= ?  ");
		
			prtm.setString(1,nam);
			ResultSet rs= prtm.executeQuery();
			while(rs.next()) {
				NhanVien nv=new NhanVien(rs.getString("maNhanVien"),rs.getString("ten"),rs.getString("phongBan"));
				LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
				dsBLNVtheonam.add(new BangLuongNhanVien(rs.getString("maBangLuong"),rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),rs.getDouble("luongCoBan"),ngayTinh,nv));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dsBLNVtheonam;
		
	}
	public ArrayList<BangLuongNhanVien> getalltheothang(String thang){
		ArrayList<BangLuongNhanVien> dsBLNVtheothang= new ArrayList<>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement prtm;
		try {
			prtm = con.prepareStatement("select * from BangLuongNhanVien l join NhanVien nv on l.MaNV=nv.maNhanVien where month(thoiGian)= ?  ");
		
			prtm.setString(1,thang);
			ResultSet rs= prtm.executeQuery();
			while(rs.next()) {
				NhanVien nv=new NhanVien(rs.getString("maNhanVien"),rs.getString("ten"),rs.getString("phongBan"));
				LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
				dsBLNVtheothang.add(new BangLuongNhanVien(rs.getString("maBangLuong"),rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),rs.getDouble("luongCoBan"),ngayTinh,nv));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dsBLNVtheothang;
		
	}
	public ArrayList<BangLuongNhanVien> getBLNV_tg(String nam,String month){
		ArrayList<BangLuongNhanVien> dsNV= new ArrayList<>();
		int thang=Integer.parseInt(month);
		String d1 = nam + "-" + thang + "-01";
        String d2 = nam + "-" + (thang + 1) + "-01";
        String sql = "SELECT * FROM BangluongNhanVien l join NhanVien nv on l.MaNV=nv.maNhanVien WHERE thoiGian BETWEEN CAST( '?' AS DATE) AND CAST('?' AS DATE)";
        ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement prtm;
		try {
			prtm = con.prepareStatement(sql);
		
			prtm.setString(1,d1);
			prtm.setString(2, d2);
			
			ResultSet rs= prtm.executeQuery();
			while(rs.next()) {
				NhanVien nv=new NhanVien(rs.getString("maNhanVien"),rs.getString("ten"),rs.getString("phongBan"));
				LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
				dsNV.add(new BangLuongNhanVien(rs.getString("maBangLuong"),rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),rs.getDouble("luongCoBan"),ngayTinh,nv));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dsNV;
        		
	}
//	public static void main(String[] args) {
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		BangLuongNhanVien_DAO nv_DAO = new BangLuongNhanVien_DAO();
//		for(BangLuongNhanVien l:nv_DAO.getALLbangluongNV()) {
//			System.out.println(l.getNv().getMaNhanVien());
//		}
//	}
}
