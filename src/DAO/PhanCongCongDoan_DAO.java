package DAO;

import java.util.ArrayList;

import DTO.CongDoanSanPham;

public class PhanCongCongDoan_DAO {
	public ArrayList<PhanCongCongDoan> dsPhanCongCD= new ArrayList<PhanCongCongDoan>();
	try {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from PhanCongCongDoan";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String maSP = rs.getString("maSanPham");
			String tenSP = rs.getString("tenSanPham");
			int slCongDoan = rs.getInt("soLuongCongDoan");
			int slSanPham = rs.getInt("soLuong");
			SanPham sp = new SanPham(maSP, tenSP, slCongDoan, slSanPham);
			danhSachSanPham.add(sp);
		}
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return danhSachSanPham;

}
