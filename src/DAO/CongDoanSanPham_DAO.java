package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CongDoanSanPham;
import DTO.SanPham;

public class CongDoanSanPham_DAO {

//	public CongDoanSanPham_DAO() {
//	}

	public ArrayList<CongDoanSanPham> getAllCongDoanSanPham() {
		ArrayList<CongDoanSanPham> danhSachCD = new ArrayList<CongDoanSanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from CongDoanSanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//
//        try (Connection con = ConnectDB.getInstance().connect(); Statement stmt = con.createStatement()) {
//            ResultSet rs = stmt.executeQuery("Select * from CongDoanSanPham");
			while (rs.next()) {
				String maCD = rs.getString("maCongDoan");
				String tenCD = rs.getString("tenCongDoan");
				String maSP = rs.getString("maSP");
				Date ngayChiaCD = rs.getDate("ngayChiaCongDoan");
				Date ngayThucHien = rs.getDate("ngayBatDau");
				Float donGia = rs.getFloat("donGia");
				int soLuongSanPhamCD = rs.getInt("soLuongSanPham");

				SanPham sp = new SanPham(maSP);
				CongDoanSanPham congDoanSP = new CongDoanSanPham(maCD, tenCD, sp, ngayThucHien, ngayChiaCD, donGia,
						soLuongSanPhamCD);
				danhSachCD.add(congDoanSP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhSachCD;
	}

//	public ArrayList<CongDoanSanPham> getCongDoanTheoMa(String maCD) {
//		ArrayList<CongDoanSanPham> danhSachCongDoan = new ArrayList<CongDoanSanPham>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//			String sql = "Select * from CongDoanSanPham where maCongDoan = ?";
//			statement = con.prepareStatement(sql);
//			statement.setString(1, maCD);
//			ResultSet rs = statement.executeQuery();
//			
//			while (rs.next()) {
////				String maCD = rs
//				
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return danhSachCongDoan;
//	}

	public boolean create(CongDoanSanPham cd) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("insert into CongDoanSanPham values(?,?,?,?,?,?,?,?)");
			statement.setString(1, cd.getMaCongDoan());
			statement.setString(2, cd.getTenCongDoan());
			statement.setDate(3, cd.getNgayBatDau());
			statement.setInt(4, cd.getSoLuong());
			statement.setDouble(5, cd.getDonGia());
			statement.setBoolean(6, true);
			statement.setString(7, cd.getSanPham().getMaSanPham());
			statement.setDate(8, cd.getNgayChiaCD());

			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean update(CongDoanSanPham cd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"update CongDoanSanPham set tenCongDoan = ?, maSP = ?, ngayChiaCongDoan = ?, ngayBatDau = ?, donGia = ?, soLuongSanPham = ? where maCongDoan = ?");
			statement.setString(1, cd.getTenCongDoan());
			statement.setString(2, cd.getSanPham().getMaSanPham());
			statement.setDate(3, cd.getNgayChiaCD());
			statement.setDate(4, cd.getNgayBatDau());
			statement.setFloat(5, (float) cd.getDonGia());
			statement.setInt(6, (Integer) cd.getSoLuong());
			statement.setString(7, cd.getMaCongDoan());

			n = statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public String maSPtheomaCD(String maCD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		String maSP = null;
		try {
			;
			statement = con.prepareStatement("select maSP from CongDoanSanPham where maCongDoan = ?");
			statement.setString(1, maCD);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				maSP = rs.getString("maSP");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maSP;
	}

	public String phatSinhMaCongDoan() {
		String maCuoiCongDoan = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "\n"
					+ "  SELECT TOP 1 SUBSTRING(maCongDoan, 3, LEN(maCongDoan) - 2) AS maCuoi FROM CongDoanSanPham ORDER BY maCongDoan DESC";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				maCuoiCongDoan = rs.getString("maCuoi");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Check if the string is not empty or contains only whitespace
		if (!maCuoiCongDoan.isEmpty() && !maCuoiCongDoan.isBlank()) {
			try {
				int soCuoi = Integer.parseInt(maCuoiCongDoan);
				soCuoi++;

				// Format the new number
				maCuoiCongDoan = String.format("%03d", soCuoi);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				// Handle the case where maCuoiCongDoan is not a valid integer
			}
		}

		return "CD" + maCuoiCongDoan;
	}

}
