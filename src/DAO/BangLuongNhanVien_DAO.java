package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.BangLuongNhanVien;

public class BangLuongNhanVien_DAO {
	public ArrayList<BangLuongNhanVien> getALLbangluongNV(){
		ArrayList<BangLuongNhanVien> dsBangLuongNV= new ArrayList<BangLuongNhanVien>();
		try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from BangLuongNhanVien";
		Statement statement = (Statement) con.createStatement();
		ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
		while(rs.next()) {
			dsBangLuongNV.add(new BangLuongNhanVien(rs.getString("maBangLuong"),rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),rs.getDouble("LuongCoBan")) );
			
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dsBangLuongNV;
	}

}
