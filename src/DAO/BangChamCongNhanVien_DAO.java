package DAO;

public class BangChamCongNhanVien_DAO {
	public ArrayList<BangChamCongNhanVien> getAllBangChamCongCongNhan() {
		ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham";
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

}
