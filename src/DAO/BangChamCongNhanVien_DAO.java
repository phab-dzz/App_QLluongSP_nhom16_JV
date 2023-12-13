package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.BangChamCongNhanVien;
import DTO.NhanVien;

public class BangChamCongNhanVien_DAO {
	public ArrayList<BangChamCongNhanVien> getAllBangChamCongNhanVien() {
		ArrayList<BangChamCongNhanVien> danhSachNhanVien = new ArrayList<BangChamCongNhanVien>();
		try {
			ConnectDB cn = ConnectDB.getInstance();
			cn.connect();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT BCNV.[maBangChamCongNV], BCNV.[maNhanVien], NV.[ten] AS [hoTenNhanVien],  NV.[phongBan],BCNV.[soNgayLamViec], BCNV.[soNgayNghi], BCNV.[ngayChamCong],BCNV.[coPhep], BCNV.[soGioTangCa]FROM [dbo].[BangChamCongNhanVien] BCNV JOIN [dbo].[NhanVien] NV ON BCNV.[maNhanVien] = NV.[maNhanVien];";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String MBCC = rs.getString("maBangChamCongNV");
				String maNV = rs.getString("maNhanVien");
				int soNgayLamViec = rs.getInt("soNgayLamViec");
				int soNgayNghi = rs.getInt("soNgayNghi");
				int coPhep = rs.getInt("coPhep");
				Double soGioTangCa = rs.getDouble("soGioTangCa");
				Date ngayChamCong = rs.getDate("ngayChamCong");
				NhanVien onv = new NhanVien();
				onv.setTen(rs.getString("hoTenNhanVien"));
				onv.setPhongBan(rs.getString("phongBan"));

				BangChamCongNhanVien nv = new BangChamCongNhanVien(MBCC, maNV, soNgayLamViec, soNgayNghi, soGioTangCa,
						ngayChamCong, coPhep, onv);
				danhSachNhanVien.add(nv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhSachNhanVien;
	}

//	public void updateBangChamCongNhanVien(ArrayList<BangChamCongNhanVien> danhSachNhanVien) {
//		try {
//			ConnectDB cn = ConnectDB.getInstance();
//			cn.connect();
//			Connection con = ConnectDB.getConnection();
//
//			// Chuẩn bị câu lệnh SQL UPDATE với điều kiện WHERE
//			String sql = "UPDATE [dbo].[BangChamCongNhanVien] SET " + "[soNgayLamViec] = [soNgayLamViec] + ?, "
//					+ "[soNgayNghi] = [soNgayNghi] + ?, " + "[soGioTangCa] = [soGioTangCa] + ?, "
//					+ "[coPhep] = [coPhep] + ? " + "WHERE [maBangChamCongNV] = ?"
//					+ "UPDATE BLNV SET thucLanh = (((NV.luongCoBan * NV.hsLuong) / 26) * (22 - ?) + ((NV.luongCoBan * NV.hsLuong) / 26 / 8) * 2 * ? - (? - ?) * 150000 - NV.ThueThuNhapCaNhan) FROM NhanVien NV JOIN BangChamCongNhanVien BCC ON NV.maNhanVien = BCC.maNhanVien JOIN BangLuongNhanVien BLNV ON BCC.maNhanVien= BLNV.MaNV WHERE BLNV.maNV = ?;";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//
//			// Lặp qua danh sách đối tượng BangChamCongNhanVien và cập nhật vào cơ sở dữ
//			// liệu
//			for (BangChamCongNhanVien nv : danhSachNhanVien) {
//				// Thiết lập các giá trị cho các tham số
//				preparedStatement.setInt(1, nv.getSoNgayLamViec());
//				preparedStatement.setInt(2, nv.getSoNgayNghi());
//				preparedStatement.setDouble(3, nv.getSoGioTangCa());
//				preparedStatement.setInt(4, nv.getCoPhep());
//				preparedStatement.setString(5, nv.getMaChamCongNV());
//				preparedStatement.setInt(6, nv.getSoNgayNghi());
//				preparedStatement.setDouble(7, nv.getSoGioTangCa());
//				preparedStatement.setDouble(8, nv.getSoGioTangCa());
//				preparedStatement.setInt(9, nv.getCoPhep());
//				preparedStatement.setString(10, nv.getMaNhanVien());
//
//				// Thực hiện câu lệnh SQL UPDATE
//				preparedStatement.executeUpdate();
//			}
//
//			// Đóng PreparedStatement và Connection
//			preparedStatement.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	public void updateBangChamCongNhanVien(ArrayList<BangChamCongNhanVien> danhSachNhanVien) {
		try {
			ConnectDB cn = ConnectDB.getInstance();
			cn.connect();
			Connection con = ConnectDB.getConnection();

			String sqlUpdateChamCong = "UPDATE [dbo].[BangChamCongNhanVien] SET "
					+ "[soNgayLamViec] = [soNgayLamViec] + ?, " + "[soNgayNghi] = [soNgayNghi] + ?, "
					+ "[soGioTangCa] = [soGioTangCa] + ?, " + "[coPhep] = [coPhep] + ?, " + "[ngayChamCong] = ? "
					+ "WHERE [maBangChamCongNV] = ?;";

			String sqlUpdateLuong = "UPDATE BangLuongNhanVien  " + "SET  "
					+ "    thucLanh = ((NV.luongCoBan * NV.hsLuong) / 26) * BCC.soNgayLamViec + ((NV.luongCoBan * NV.hsLuong) / 26 / 8) * 2 * BCC.soGioTangCa  - (BCC.soNgayNghi - BCC.coPhep) * 150000  "
					+ "    -  " + "    CASE  "
					+ "        WHEN (NV.luongCoBan + NV.luongPhuCap - (0.08 * 4500000 + 730000)) <= 5000000  "
					+ "            THEN (NV.luongCoBan + NV.luongPhuCap - (0.08 * 4500000 + 730000)) * 0.05 "
					+ "        WHEN (NV.luongCoBan + NV.luongPhuCap - (0.08 * 4500000 + 730000)) > 5000000 AND (NV.luongCoBan + NV.luongPhuCap - (0.08 * 4500000 + 730000)) <= 10000000  "
					+ "            THEN (NV.luongCoBan + NV.luongPhuCap - (0.08 * 4500000 + 730000)) * 0.1 "
					+ "        WHEN (NV.luongCoBan + NV.luongPhuCap - (0.08 * 4500000 + 730000)) > 10000000 AND (NV.luongCoBan + NV.luongPhuCap - (0.08 * 4500000 + 730000)) <= 18000000  "
					+ "            THEN (NV.luongCoBan + NV.luongPhuCap - (0.08 * 4500000 + 730000)) * 0.15 "
					+ "        ELSE 0 " + "    END, " + "    thoiGian = ?  " + "FROM  " + "    NhanVien NV  " + "JOIN  "
					+ "    BangChamCongNhanVien BCC ON NV.maNhanVien = BCC.maNhanVien  " + "JOIN  "
					+ "    BangLuongNhanVien BLNV ON BCC.maNhanVien = BLNV.MaNV  " + "WHERE  " + "    BLNV.maNV = ?  "
					+ "    AND DATEPART(month, BLNV.thoiGian) = DATEPART(month, ?)  "
					+ "    AND BCC.maBangChamCongNV = ?; ";

			// Lặp qua danh sách đối tượng BangChamCongNhanVien và cập nhật vào cơ sở dữ
			// liệu
			for (BangChamCongNhanVien nv : danhSachNhanVien) {
				try (PreparedStatement preparedStatementChamCong = con.prepareStatement(sqlUpdateChamCong)) {
					// Thiết lập các giá trị cho các tham số của bảng BangChamCongNhanVien
					preparedStatementChamCong.setInt(1, nv.getSoNgayLamViec());
					preparedStatementChamCong.setInt(2, nv.getSoNgayNghi());
					preparedStatementChamCong.setDouble(3, nv.getSoGioTangCa());
					preparedStatementChamCong.setInt(4, nv.getCoPhep());
					java.util.Date ngayChamCongUtil = nv.getNgayChamCong();
					java.sql.Date ngayChamCongSql = new java.sql.Date(ngayChamCongUtil.getTime());
					preparedStatementChamCong.setDate(5, ngayChamCongSql);
					preparedStatementChamCong.setString(6, nv.getMaChamCongNV());

					// Thực hiện câu lệnh SQL UPDATE cho BangChamCongNhanVien
					preparedStatementChamCong.executeUpdate();
				}
				try (PreparedStatement preparedStatementLuong = con.prepareStatement(sqlUpdateLuong)) {
					// Thiết lập các giá trị cho các tham số của bảng BangLuongNhanVien
//					preparedStatementLuong.setInt(1, nv.getSoNgayLamViec());
//					preparedStatementLuong.setDouble(2, nv.getSoGioTangCa());
//					preparedStatementLuong.setDouble(3, nv.getSoNgayNghi());
//					preparedStatementLuong.setInt(4, nv.getCoPhep());
					java.util.Date ngayChamCongUtil = nv.getNgayChamCong();
					java.sql.Date ngayChamCongSql = new java.sql.Date(ngayChamCongUtil.getTime());
					preparedStatementLuong.setDate(1, ngayChamCongSql);
					preparedStatementLuong.setString(2, nv.getMaNhanVien());
					preparedStatementLuong.setDate(3, ngayChamCongSql);
					preparedStatementLuong.setString(4, nv.getMaChamCongNV());

					// Thực hiện câu lệnh SQL UPDATE cho BangLuongNhanVien
					preparedStatementLuong.executeUpdate();
				}
			}

			// Đóng Connection
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
