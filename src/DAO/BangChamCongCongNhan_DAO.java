package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.BangChamCongCongNhan;
import DTO.CongDoanSanPham;
import DTO.CongNhan;
import DTO.PhanCongCongDoan;
import DTO.SanPham;

public class BangChamCongCongNhan_DAO {
	public ArrayList<BangChamCongCongNhan> getAllBangChamCongCongNhan() throws Exception {
		ArrayList<BangChamCongCongNhan> danhSachCongNhan = new ArrayList<BangChamCongCongNhan>();
		try {
			ConnectDB cn = ConnectDB.getInstance();
			cn.connect();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT BCCC.[maBangChamCongCN], BCCC.[soNgayLamViec], CN.[maCongNhan], BCCC.[soNgayNghi], BCCC.[ngayChamCong], BCCC.[soLuongHangLamDuoc], BCCC.[coPhep], BCCC.[soGioTangCa], CN.ten AS tenCongNhan, CN.xuong, SP.tenSanPham, CDSP.tenCongDoan, PC.soLuongCongDoanPhanCong FROM BangChamCongCongNhan BCCC JOIN CongNhan CN ON BCCC.maCN = CN.maCongNhan JOIN PhanCongCongDoan PC ON PC.maCN = CN.maCongNhan JOIN CongDoanSanPham CDSP ON PC.maCD = CDSP.maCongDoan JOIN  SanPham SP ON SP.maSanPham = CDSP.maSP WHERE CN.trangThai = 1;";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String MCCC = rs.getString("maBangChamCongCN");
				String maCN = rs.getString("maCongNhan");
				String tenCN = rs.getString("tenCongNhan");
				CongNhan cnh = new CongNhan();
				cnh.setTen(tenCN);
				cnh.setXuong(rs.getString("Xuong"));

				int soNgayLamViec = rs.getInt("soNgayLamViec");
				int soNgayNghi = rs.getInt("soNgayNghi");
				int soSPLamDuoc = rs.getInt("soLuongHangLamDuoc");
				int coPhep = rs.getInt("coPhep");
				int soGioTangCa = rs.getInt("soGioTangCa");
				Date ngayChamCong = rs.getDate("ngayChamCong");
				SanPham sp = new SanPham();
				sp.setTenSanPham(rs.getString("tenSanPham"));

				CongDoanSanPham cd = new CongDoanSanPham();
				cd.setTenCongDoan(rs.getString("tenCongDoan"));

				PhanCongCongDoan pc = new PhanCongCongDoan();
				pc.setSoLuongCongDoanPhanCong(rs.getInt("soLuongCongDoanPhanCong"));

				BangChamCongCongNhan nv = new BangChamCongCongNhan(MCCC, maCN, soNgayLamViec, soNgayNghi, soSPLamDuoc,
						soGioTangCa, ngayChamCong, coPhep, cnh, pc, cd, sp);
				danhSachCongNhan.add(nv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhSachCongNhan;
	}

//	public void updateBangChamCongCongNhan(ArrayList<BangChamCongCongNhan> danhSachCongNhan) {
//		try {
//			ConnectDB cn = ConnectDB.getInstance();
//			cn.connect();
//			Connection con = ConnectDB.getConnection();
//
//			// Chuẩn bị câu lệnh SQL UPDATE với điều kiện WHERE
//			String sql = "UPDATE [dbo].[BangChamCongCongNhan] SET " + "[soNgayLamViec] = [soNgayLamViec] + ?, "
//					+ "[soNgayNghi] = [soNgayNghi] + ?, " + "[soLuongHangLamDuoc] = [soLuongHangLamDuoc] + ?, "
//					+ "[coPhep] = [coPhep] + ?, " + "[soGioTangCa] = [soSPLamDuocTrongGioTangCa] + ? "
//					+ "WHERE [maBangChamCongCN] = ?";
//
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//
//			// Lặp qua danh sách đối tượng BangChamCongCongNhan và cập nhật vào cơ sở dữ
//			// liệu
//			for (BangChamCongCongNhan cnh : danhSachCongNhan) {
//				// Thiết lập các giá trị cho các tham số
//				preparedStatement.setInt(1, cnh.getSoNgayLamViec());
//				preparedStatement.setInt(2, cnh.getSoNgayNghi());
//				preparedStatement.setDouble(3, cnh.getSoLuongSanPham());
//				preparedStatement.setInt(4, cnh.getCoPhep());
//				preparedStatement.setInt(5, cnh.getSoSPGioTangCa());
//				preparedStatement.setString(6, cnh.getMaChamCongCN());
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
	
	public void  updateBangChamCongCongNhan(ArrayList<BangChamCongCongNhan> danhSachCongNhan)  {
		try {
			ConnectDB cn = ConnectDB.getInstance();
			cn.connect();
			Connection con = ConnectDB.getConnection();

			String sqlUpdateChamCong = "UPDATE [dbo].[BangChamCongCongNhan] SET " + "[soNgayLamViec] = [soNgayLamViec] + ?, "
					+ "[soNgayNghi] = [soNgayNghi] + ?, " + "[soLuongHangLamDuoc] = [soLuongHangLamDuoc] + ?, "
					+ "[coPhep] = [coPhep] + ?, " + "[soGioTangCa] = [soGioTangCa] + ? "
					+ "WHERE [maBangChamCongCN] = ?";

			String sqlUpdateLuong = "UPDATE [dbo].[BangluongCongNhan] SET  "
					+ "thucLanh = ((BCC.soLuongHangLamDuoc * CD.donGia) * (1 + CN.trinhDoChuyenMon) + (BCC.soSPLamDuocTrongGioTangCa * CD.donGia) * 2.4 + CN.luongPhuCap - ((BCC.soLuongHangLamDuoc * CD.donGia) * (1 + CN.trinhDoChuyenMon)) + CN.luongPhuCap - (0.08 * 4500000 + 730000) - (BCC.soNgayNghi - BCC.coPhep) * 100000), "
					+ "thoiGian = ? " + "FROM CongNhan CN "
					+ "JOIN BangChamCongCongNhan BCC ON CN.maCongNhan = BCC.maCN "
					+ "JOIN PhanCongCongDoan PC ON CN.maCongNhan = PC.maCN "
					+ "JOIN CongDoanSanPham CD ON PC.maCD = CD.maCongDoan "
					+ "JOIN BangLuongCongNhan BLCN ON BCC.maCN = BLCN.MaCN "
					+ "WHERE BLCN.maCN = ? AND DATEPART(month, BLCN.thoiGian) = DATEPART(month, ?);";

			// Lặp qua danh sách đối tượng BangChamCongNhanVien và cập nhật vào cơ sở dữ
			// liệu
			
			for (BangChamCongCongNhan cnh : danhSachCongNhan) {
				try (PreparedStatement preparedStatementChamCong = con.prepareStatement(sqlUpdateChamCong)) {
					// Thiết lập các giá trị cho các tham số của bảng BangChamCongNhanVien
					preparedStatementChamCong.setInt(1, cnh.getSoNgayLamViec());
					preparedStatementChamCong.setInt(2, cnh.getSoNgayNghi());
					preparedStatementChamCong.setDouble(3, cnh.getSoLuongSanPham());
					preparedStatementChamCong.setInt(4, cnh.getCoPhep());
					preparedStatementChamCong.setInt(5, cnh.getSoSPGioTangCa());
					preparedStatementChamCong.setString(6, cnh.getMaChamCongCN());

					// Thực hiện câu lệnh SQL UPDATE
					preparedStatementChamCong.executeUpdate();
				}

				try (PreparedStatement preparedStatementLuong = con.prepareStatement(sqlUpdateLuong)) {
					// Thiết lập các giá trị cho các tham số của bảng BangLuongNhanVien
//					preparedStatementLuong.setInt(1, nv.getSoNgayLamViec());
//					preparedStatementLuong.setDouble(2, nv.getSoGioTangCa());
//					preparedStatementLuong.setDouble(3, nv.getSoNgayNghi());
//					preparedStatementLuong.setInt(4, nv.getCoPhep());
					java.util.Date ngayChamCongUtil = cnh.getNgayChamCong();
					java.sql.Date ngayChamCongSql = new java.sql.Date(ngayChamCongUtil.getTime());
					preparedStatementLuong.setDate(1, ngayChamCongSql);
					preparedStatementLuong.setString(2, cnh.getMaCongNhan());
					preparedStatementLuong.setDate(3, ngayChamCongSql);

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

//	public void updatePhanCongCongDoan(ArrayList<BangChamCongCongNhan> danhSachCongNhan) {
//		try {
//			ConnectDB cn = ConnectDB.getInstance();
//			cn.connect();
//			Connection con = ConnectDB.getConnection();
//
//			// Chuẩn bị câu lệnh SQL UPDATE với điều kiện WHERE
//			String sql = "UPDATE [dbo].[PhanCongCongDoan] SET [soLuongCongDoanPhanCong] = ? WHERE [maCN] = ?";
//
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//
//			// Lặp qua danh sách đối tượng BangChamCongCongNhan và cập nhật vào cơ sở dữ
//			// liệu
//			for (BangChamCongCongNhan cnh : danhSachCongNhan) {
//				// Thiết lập các giá trị cho các tham số
//				preparedStatement.setInt(1, cnh.getPc().getSoLuongCongDoanPhanCong());
//				preparedStatement.setString(2, cnh.getPc().getMaCN());
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
//
//	}

}
