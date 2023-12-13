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
			while (rs.next()) {
				String maCD = rs.getString("maCongDoan");
				String tenCD = rs.getString("tenCongDoan");
				String maSP = rs.getString("maSP");
				Date ngayChiaCD = rs.getDate("ngayChiaCongDoan");
				Date ngayThucHien = rs.getDate("ngayBatDau");
				Float donGia = rs.getFloat("donGia");
				int soLuongSanPhamCD = rs.getInt("soLuongSanPham");
				String chuyenMon = rs.getString("chuyenMon");
				boolean trangThai = rs.getBoolean("trangThai");
				boolean trangThaiPhanCong = rs.getBoolean("trangThaiPhanCong");
				int soLuongHoanThanh = rs.getInt("soLuongHoanThanh");
				int doUuTien = rs.getInt("doUuTien");
				SanPham sp = new SanPham(maSP);
				CongDoanSanPham congDoanSP = new CongDoanSanPham(maCD, tenCD, sp, ngayThucHien, ngayChiaCD, donGia,
						soLuongSanPhamCD, chuyenMon, trangThai, soLuongHoanThanh, doUuTien, trangThaiPhanCong);
				danhSachCD.add(congDoanSP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhSachCD;
	}

	public ArrayList<Boolean> getTrangThaiCongDoanTruocDo(String maSanPham, int doUuTien) {
		ArrayList<Boolean> dsTrangThai = new ArrayList<Boolean>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT trangThai FROM [QLLUONG].[dbo].[CongDoanSanPham] WHERE maSP = ? AND doUuTien = ?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maSanPham);
			statement.setInt(2, doUuTien);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				boolean trangThai = rs.getBoolean("trangThai");
				dsTrangThai.add(trangThai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTrangThai;
	}

	public boolean getTrangThaiPhanCong(String maCongDoan) {
		boolean trangThai = false;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT trangThaiPhanCong FROM [QLLUONG].[dbo].[CongDoanSanPham] " + "WHERE maCongDoan = ?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maCongDoan);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				trangThai = rs.getBoolean("trangThaiPhanCong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trangThai;
	}

	public int getSoLuongHoanThanh(String maCongDoan) {
		int soLuongHoanThanh = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT soLuongHoanThanh FROM [QLLUONG].[dbo].[CongDoanSanPham] " + "WHERE maCongDoan = ?;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maCongDoan);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				soLuongHoanThanh = rs.getInt("soLuongHoanThanh");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soLuongHoanThanh;
	}

	public CongDoanSanPham getCongDoanSanPham(String maCongDoan) {
		CongDoanSanPham cd = new CongDoanSanPham();

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from CongDoanSanPham where maCongDoan = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maCongDoan);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String maCD = rs.getString("maCongDoan");
				String tenCD = rs.getString("tenCongDoan");
				String maSP = rs.getString("maSP");
				Date ngayChiaCD = rs.getDate("ngayChiaCongDoan");
				Date ngayThucHien = rs.getDate("ngayBatDau");
				Float donGia = rs.getFloat("donGia");
				int soLuongSanPhamCD = rs.getInt("soLuongSanPham");
				String chuyenMon = rs.getString("chuyenMon");
				boolean trangThai = rs.getBoolean("trangThai");
				boolean trangThaiPhanCong = rs.getBoolean("trangThaiPhanCong");
				int soLuongHoanThanh = rs.getInt("soLuongHoanThanh");
				int doUuTien = rs.getInt("doUuTien");
				SanPham sp = new SanPham(maSP);
				CongDoanSanPham congDoanSP = new CongDoanSanPham(maCD, tenCD, sp, ngayThucHien, ngayChiaCD, donGia,
						soLuongSanPhamCD, chuyenMon, trangThai, soLuongHoanThanh, doUuTien, trangThaiPhanCong);
				cd = congDoanSP;
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
		return cd;
	}

	public boolean create(CongDoanSanPham cd) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = ConnectDB.getConnection();
				PreparedStatement statement = con.prepareStatement(
						"INSERT INTO CongDoanSanPham (maCongDoan, tenCongDoan, ngayBatDau, soLuongSanPham, donGia, trangThai, maSP, ngayChiaCongDoan, chuyenMon, trangThaiPhanCong, soLuongHoanThanh, doUuTien) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

			statement.setString(1, cd.getMaCongDoan());
			statement.setString(2, cd.getTenCongDoan());
			statement.setDate(3, cd.getNgayBatDau());
			statement.setInt(4, cd.getSoLuong());
			statement.setDouble(5, cd.getDonGia());
			statement.setBoolean(6, cd.isTrangThai());
			statement.setString(7, cd.getSanPham().getMaSanPham());
			statement.setDate(8, cd.getNgayChiaCD());
			statement.setString(9, cd.getChuyenMon());
			statement.setBoolean(10, cd.isTrangThaiPhanCong());
			statement.setInt(11, cd.getSoLuongHoanThanh());
			statement.setInt(12, cd.getDoUuTien());
			int n = statement.executeUpdate();
			return n > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean update(CongDoanSanPham cd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"update CongDoanSanPham set tenCongDoan = ?, maSP = ?, ngayChiaCongDoan = ?, ngayBatDau = ?, donGia = ?, soLuongSanPham = ?, chuyenMon = ?, doUuTien = ? where maCongDoan = ?");
			statement.setString(1, cd.getTenCongDoan());
			statement.setString(2, cd.getSanPham().getMaSanPham());
			statement.setDate(3, cd.getNgayChiaCD());
			statement.setDate(4, cd.getNgayBatDau());
			statement.setFloat(5, (float) cd.getDonGia());
			statement.setInt(6, (Integer) cd.getSoLuong());
			statement.setString(7, cd.getChuyenMon());
			statement.setInt(8, cd.getDoUuTien());
			statement.setString(9, cd.getMaCongDoan());
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

	public boolean updateTrangThaiPhanCongCD(String maCD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("update CongDoanSanPham set trangThaiPhanCong = ? where maCongDoan = ?");
			statement.setBoolean(1, true);
			statement.setString(2, maCD);
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

	public ArrayList<CongDoanSanPham> getCongDoanTheoMaSanPham(String sortMa) {
		ArrayList<CongDoanSanPham> danhSachCongDoanTheoSanPham = new ArrayList<CongDoanSanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(
					"select * from [dbo].[CongDoanSanPham] join [dbo].[SanPham] on [maSP] = [maSanPham] where [maSanPham] = ?");
			statement.setString(1, sortMa);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maCD = rs.getString("maCongDoan");
				String tenCD = rs.getString("tenCongDoan");
				String maSP = rs.getString("maSP");
				Date ngayChiaCD = rs.getDate("ngayChiaCongDoan");
				Date ngayThucHien = rs.getDate("ngayBatDau");
				Float donGia = rs.getFloat("donGia");
				int soLuongSanPhamCD = rs.getInt("soLuongSanPham");
				Boolean tthai = rs.getBoolean("trangThai");
				String cMon = rs.getString("chuyenMon");
				int uuTien = rs.getInt("doUuTien");
				SanPham sp = new SanPham(maSP);
				Boolean tthaipc = rs.getBoolean("trangThaiPhanCong");
				CongDoanSanPham congDoanSP = new CongDoanSanPham(maCD, tenCD, sp, ngayThucHien, ngayChiaCD, donGia,
						soLuongSanPhamCD, cMon, tthai, 0, uuTien, tthaipc);
				danhSachCongDoanTheoSanPham.add(congDoanSP);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return danhSachCongDoanTheoSanPham;
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
