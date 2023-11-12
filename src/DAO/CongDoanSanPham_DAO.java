package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.ConnectDB;
import DTO.CongDoanSanPham;

public class CongDoanSanPham_DAO {

	public CongDoanSanPham_DAO() {}
	
	public ArrayList<CongDoanSanPham> getAllCongDoanSanPham() {
		ArrayList<CongDoanSanPham> danhSachCD = new ArrayList<CongDoanSanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from CongDoanSanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				danhSachCD.add(new CongDoanSanPham(rs.getString("maCongDoan"),rs.getString("tenCongDoan")));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return danhSachCD;
	}
	
}
