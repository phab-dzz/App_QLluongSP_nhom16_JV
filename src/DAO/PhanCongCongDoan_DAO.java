package DAO;

import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CongDoanSanPham;
import DTO.PhanCongCongDoan;
import utilities.ProcessDate;

public class PhanCongCongDoan_DAO {
	public ArrayList<PhanCongCongDoan> getALLPhanCongCongDoan(){
	ArrayList<PhanCongCongDoan> dsPhanCongCD= new ArrayList<PhanCongCongDoan>();
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from PhanCongCongDoan";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			LocalDate ngayBatDau = ProcessDate.date2LocalDate(rs.getDate("ngayBatDau"));
			 dsPhanCongCD.add(new PhanCongCongDoan(rs.getString("maCN"),rs.getString("maSP"),rs.getString("maCD"),rs.getInt("soLuongCongDoanPhanCong"), ngayBatDau));
		}
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return dsPhanCongCD;
	}
	public boolean themPhanCongCongDoan(PhanCongCongDoan cd) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement stmt=null;
	boolean result=false;
		
		try {
			stmt= con.prepareStatement("insert into PhanCongCongDoan values(?,?,?,?,?)");
			stmt.setInt(1,cd.getSoLuongCongDoanPhanCong());
			stmt.setString(2,cd.getMaSP());
			stmt.setString(3,cd.getMaCD());
			stmt.setString(4,cd.getMaCN());
			stmt.setDate(5,ProcessDate.localDate2Date(cd.getNgayBatDau()));
			result=stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
		
	}
	public boolean updateCD(PhanCongCongDoan cd) {
		ConnectDB.getInstance();
		Connection con= ConnectDB.getConnection();
		PreparedStatement stmt=null;
		boolean result=false;
		
		try {
			stmt=con.prepareStatement("update PhanCongCongDoan set ngayBatDau=?,soLuongCongDoanPhanCong=?,maSP=?,maCD=? where maCN=?");
			stmt.setDate(1,ProcessDate.localDate2Date(cd.getNgayBatDau()));
			stmt.setInt(2,cd.getSoLuongCongDoanPhanCong());
			stmt.setString(3, cd.getMaSP());
			stmt.setString(4,cd.getMaCD());
			stmt.setString(5, cd.getMaCN());
			result= stmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	return result;
	}
	public boolean xoaPhanCongCD (String ma) {
		ConnectDB.getInstance();
		Connection con= ConnectDB.getConnection();
		PreparedStatement stmt=null;
		boolean result=false;
		
		try {
			stmt=con.prepareStatement("delete from PhanCongCongDoan where maCN=?");
			stmt.setString(1,ma);
			result= stmt.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return result;
	}


}
