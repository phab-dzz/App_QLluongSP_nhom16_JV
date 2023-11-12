package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.BangLuongCongNhan;
import DTO.BangLuongNhanVien;
import DTO.CongNhan;
import DTO.NhanVien;
import utilities.ProcessDate;

public class BangLuongCongNhan_DAO {
	public ArrayList<BangLuongCongNhan> getALLbangluongCN(){
		ArrayList<BangLuongCongNhan> dsBangLuongCN= new ArrayList<BangLuongCongNhan>();
		try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select *\r\n"
				+ "from BangluongCongNhan l join CongNhan cn on l.MaCN= cn.maCongNhan";
		Statement statement = (Statement) con.createStatement();
		ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
		while(rs.next()) {
			
			CongNhan cn= new CongNhan(rs.getString("maCN"),rs.getString("ten"),rs.getString("sDT"),rs.getString("xuong"),rs.getString("chuyenMon"));
			LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
			dsBangLuongCN.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
					rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),
					rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),ngayTinh,cn) );
			
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dsBangLuongCN;
	}
	public ArrayList<BangLuongCongNhan> getallbangLuongCNTK(String ma){
		ArrayList<BangLuongCongNhan> dsBangLuongCNTK= new ArrayList<BangLuongCongNhan>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		String sql= "select * from BangluongCongNhan l join CongNhan nv on l.MaCN=nv.maCongNhan where maCongNhan = ? ";
		
		try {
		PreparedStatement	stmt = con.prepareStatement(sql);
		stmt.setString(1, ma);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {

				CongNhan cn= new CongNhan(rs.getString("maCN"),rs.getString("ten"),rs.getString("sDT"),rs.getString("xuong"),rs.getString("chuyenMon"));
				LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
				dsBangLuongCNTK.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
						rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),
						rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),ngayTinh,cn) );
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsBangLuongCNTK;
	
	}
	public ArrayList<BangLuongCongNhan> getalltheonam(String nam){
		ArrayList<BangLuongCongNhan> dsBLNVtheonam= new ArrayList<>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement prtm;
		try {
			prtm = con.prepareStatement("select * from BangluongCongNhan l join CongNhan nv on l.MaCN=nv.maCongNhan where year(thoiGian)= ?  ");
		
			prtm.setString(1,nam);
			ResultSet rs= prtm.executeQuery();
			while(rs.next()) {
				CongNhan cn= new CongNhan(rs.getString("maCN"),rs.getString("ten"),rs.getString("sDT"),rs.getString("xuong"),rs.getString("chuyenMon"));
				LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
				dsBLNVtheonam.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
						rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),
						rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),ngayTinh,cn) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dsBLNVtheonam;
		
	}
	public ArrayList<BangLuongCongNhan> getalltheothang(String thang){
		ArrayList<BangLuongCongNhan> dsBLNVtheothang= new ArrayList<>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement prtm;
		try {
			prtm = con.prepareStatement("select * from BangluongCongNhan l join CongNhan nv on l.MaCN=nv.maCongNhan where month(thoiGian)= ?  ");
		
			prtm.setString(1,thang);
			ResultSet rs= prtm.executeQuery();
			while(rs.next()) {
				CongNhan cn= new CongNhan(rs.getString("maCN"),rs.getString("ten"),rs.getString("sDT"),rs.getString("xuong"),rs.getString("chuyenMon"));
				LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
				dsBLNVtheothang.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
						rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),
						rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),ngayTinh,cn) );
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dsBLNVtheothang;
		
	}
}
