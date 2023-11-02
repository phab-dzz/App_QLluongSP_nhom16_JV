package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.BangLuongCongNhan;
import DTO.BangLuongNhanVien;

public class BangLuongCongNhan_DAO {
	public ArrayList<BangLuongCongNhan> getALLbangluongCN(){
		ArrayList<BangLuongCongNhan> dsBangLuongCN= new ArrayList<BangLuongCongNhan>();
		try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from BangLuongNhanVien";
		Statement statement = (Statement) con.createStatement();
		ResultSet rs = ((java.sql.Statement) statement).executeQuery(sql);
		while(rs.next()) {
			dsBangLuongCN.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
					rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),
					rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh")) );
			
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dsBangLuongCN;
	}
}
