package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.SanPham;

public class SanPham_DAO {

	public SanPham_DAO() {
	}

	public ArrayList<SanPham> getAllSanPham() {
		ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham";
//			 try (Connection con = ConnectDB.getInstance().connect(); Statement statement = con.createStatement()) {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maSP = rs.getString("maSanPham");
				String tenSP = rs.getString("tenSanPham");
				int slCongDoan = rs.getInt("soLuongCongDoan");
				int slSanPham = rs.getInt("soLuong");
				Boolean tthai = rs.getBoolean("trangThai");
				SanPham sp = new SanPham(maSP, tenSP, slCongDoan, slSanPham, tthai);
				danhSachSanPham.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhSachSanPham;
	}

	public ArrayList<SanPham> getSanPhamTheoMa(String id) {
		ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from SanPham where maSanPham = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String maSP = rs.getString("maSanPham");
				String tenSP = rs.getString("tenSanPham");
				int slSanPham = rs.getInt("soLuong");
				int slCongDoan = rs.getInt("soLuongCongDoan");
				Boolean tthai = rs.getBoolean("trangThai");
				SanPham sp = new SanPham(maSP, tenSP, slSanPham, slCongDoan, tthai);
				danhSachSanPham.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return danhSachSanPham;
	}

	public boolean create(SanPham sp) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {

			statement = con.prepareStatement("insert into SanPham values(?,?,?,?,?)");
			statement.setString(1, sp.getMaSanPham());
			statement.setString(2, sp.getTenSanPham());
			statement.setInt(3, sp.getSoLuong());
			statement.setInt(4, sp.getSoLuongCongDoan());
			statement.setBoolean(5, sp.isTrangThaiSP());
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean update(SanPham sp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"update SanPham set tenSanPham = ?, soLuong = ?, soLuongCongDoan=?, trangThai = ? where maSanPham = ?");
			statement.setString(1, sp.getTenSanPham());
			statement.setInt(2, sp.getSoLuong());
			statement.setInt(3, sp.getSoLuongCongDoan());
			statement.setBoolean(4, sp.isTrangThaiSP());
			statement.setString(5, sp.getMaSanPham());

			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean delete(SanPham sp) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {

			statement = con.prepareStatement("delete from SanPham where maSanPham=?");
			statement.setString(1, sp.getMaSanPham());
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public String phatSinhMaSanPhamMoi() {
		String maCuoiSanPham = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "  SELECT TOP 1 SUBSTRING(maSanPham, 3, LEN(maSanPham) - 2) AS maCuoi FROM SanPham ORDER BY maSanPham DESC";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				maCuoiSanPham = rs.getString("maCuoi").trim(); // Trim to remove leading/trailing whitespaces
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Check if the string is not empty or contains only whitespace
		if (!maCuoiSanPham.isEmpty() && !maCuoiSanPham.isBlank()) {
			try {
				int soCuoi = Integer.parseInt(maCuoiSanPham);
				soCuoi++;

				// Format the new number
				maCuoiSanPham = String.format("%03d", soCuoi);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				// Handle the case where maCuoiSanPham is not a valid integer
			}
		}

		return "SP" + maCuoiSanPham;
	}

}
