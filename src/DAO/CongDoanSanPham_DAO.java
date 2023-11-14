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
	    ArrayList<CongDoanSanPham> danhSachCD = new ArrayList<>();

	    try (Connection con = ConnectDB.getInstance().connect();
	         Statement statement = con.createStatement();
	         ResultSet rs = statement.executeQuery("SELECT * FROM CongDoanSanPham")) {

	        while (rs.next()) {
	            danhSachCD.add(new CongDoanSanPham(rs.getString("maCongDoan"), rs.getString("tenCongDoan")));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return danhSachCD;
	}

}
