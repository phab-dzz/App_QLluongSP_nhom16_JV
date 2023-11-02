package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.NhanVien;
import utilities.ProcessDate;
import DAO.ConnectDB;
public class NhanVien_DAO {

	public ArrayList<NhanVien> getAllNhanVien(){
	ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
	try {
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	
	String sql=" select * from NhanVien";
	Statement statement= (Statement) con.createStatement();
	ResultSet rs= ((java.sql.Statement) statement).executeQuery(sql);
	while(rs.next()) {
		LocalDate ngaySinh = ProcessDate.date2LocalDate(rs.getDate("ngaySinh"));
		LocalDate ngayThamGia = ProcessDate.date2LocalDate(rs.getDate("ngayThamGia"));
		
		dsNhanVien.add(new NhanVien(rs.getString("maNhanVien"),rs.getString("hoDem"),rs.getString("ten"),
				rs.getString("chucDanh"),rs.getString("sDT"),rs.getString("email"),rs.getString("phongBan"),
				rs.getString("diaChi"),rs.getString("maBangLuong"),rs.getString("maChamCong"),rs.getString("maChamcong"),
				rs.getString("maPhieuLuong"),rs.getDouble("luongCoBan"),rs.getDouble("hsLuong"),rs.getDouble("thueThuNhapCaNhan"),rs.getDouble("luongPhuCap")
				,rs.getBoolean("gioiTinh"),ngaySinh,ngayThamGia));
	}
	}catch(SQLException e) {
		
	}
	return dsNhanVien;
}
}
