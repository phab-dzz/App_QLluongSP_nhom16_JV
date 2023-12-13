package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import DTO.PhanCongCongDoan;
import utilities.ProcessDate;

public class PhanCongCongDoan_DAO {
	public ArrayList<PhanCongCongDoan> getALLPhanCongCongDoan() {
		ArrayList<PhanCongCongDoan> dsPhanCongCD = new ArrayList<PhanCongCongDoan>();
		String sql = "SELECT * FROM PhanCongCongDoan";

		try (Connection connection = ConnectDB.getInstance().connect();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				LocalDate ngayBatDau = ProcessDate.date2LocalDate(resultSet.getDate("ngayBatDau"));
				dsPhanCongCD.add(new PhanCongCongDoan(resultSet.getString("maCN"), resultSet.getString("maSP"),
						resultSet.getString("maCD"), resultSet.getInt("soLuongCongDoanPhanCong"), ngayBatDau));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dsPhanCongCD;
	}
	public PhanCongCongDoan getPhanCong(String maCN) {
		String sql = " SELECT * FROM [QLLUONG].[dbo].[PhanCongCongDoan] where maCN= ?";
		PhanCongCongDoan pc = null;
		try (Connection connection = ConnectDB.getInstance().connect();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			
			preparedStatement.setString(1, maCN);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	            	LocalDate ngayBatDau = ProcessDate.date2LocalDate(resultSet.getDate("ngayBatDau"));
	            	pc = new PhanCongCongDoan(resultSet.getString("maCN"), resultSet.getString("maSP"),
							resultSet.getString("maCD"), resultSet.getInt("soLuongCongDoanPhanCong"), ngayBatDau);
	            }
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pc;
	}
	public ArrayList<PhanCongCongDoan> getDSPhanCongTheoXuong(String xuong) {
		ArrayList<PhanCongCongDoan> dsPhanCongCD = new ArrayList<PhanCongCongDoan>();
		String sql = " SELECT [dbo].[PhanCongCongDoan].ngayBatDau,[dbo].[PhanCongCongDoan].soLuongCongDoanPhanCong, [dbo].[CongNhan].maCongNhan, [dbo].[PhanCongCongDoan].maSP, [dbo].[PhanCongCongDoan].maCD FROM [dbo].[CongNhan] JOIN [dbo].[PhanCongCongDoan] ON [dbo].[CongNhan].maCongNhan = [dbo].[PhanCongCongDoan].maCN where [dbo].[CongNhan].xuong = ?";
		
		try (Connection connection = ConnectDB.getInstance().connect();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			
			preparedStatement.setString(1, xuong);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				LocalDate ngayBatDau = ProcessDate.date2LocalDate(resultSet.getDate("ngayBatDau"));
				dsPhanCongCD.add(new PhanCongCongDoan(resultSet.getString("maCongNhan"), resultSet.getString("maSP"),
						resultSet.getString("maCD"), resultSet.getInt("soLuongCongDoanPhanCong"), ngayBatDau));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhanCongCD;
	}
	public ArrayList<PhanCongCongDoan> getDSCanPhanCong(String chuyenMon) {
		ArrayList<PhanCongCongDoan> dsPhanCongCD = new ArrayList<PhanCongCongDoan>();
		String sql = " SELECT [dbo].[PhanCongCongDoan].ngayBatDau,[dbo].[PhanCongCongDoan].soLuongCongDoanPhanCong, [dbo].[CongNhan].maCongNhan, [dbo].[PhanCongCongDoan].maSP, [dbo].[PhanCongCongDoan].maCD FROM [dbo].[CongNhan] LEFT JOIN [dbo].[PhanCongCongDoan] ON [dbo].[CongNhan].maCongNhan = [dbo].[PhanCongCongDoan].maCN where [dbo].[CongNhan].chuyenMon = ?";

		try (Connection connection = ConnectDB.getInstance().connect();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

			preparedStatement.setString(1, chuyenMon);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				dsPhanCongCD.add(new PhanCongCongDoan(resultSet.getString("maCongNhan"), resultSet.getString("maSP"),
						resultSet.getString("maCD"), resultSet.getInt("soLuongCongDoanPhanCong"), LocalDate.now()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhanCongCD;
	}

	public int getSoLuongPhanCong(String maCN) {
		int sl = -1;
		String sql = "SELECT soLuongCongDoanPhanCong FROM PhanCongCongDoan WHERE maCN = ?";

		try (Connection connection = ConnectDB.getInstance().connect();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, maCN);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					sl = resultSet.getInt("soLuongCongDoanPhanCong");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Xử lý ngoại lệ bằng cách ghi log lỗi
		}

		return sl;
	}

	public boolean themPhanCongCongDoan(PhanCongCongDoan cd) {
		boolean result = false;

		String sql = "INSERT INTO PhanCongCongDoan (soLuongCongDoanPhanCong,maPCCD, maCD, maCN, ngayBatDau, maSP) VALUES (?,?, ?, ?, ?, ?)";
		try (Connection connection = ConnectDB.getInstance().connect();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			int so = new Random().nextInt(1000, 9999);
			String maPC = "PCCD" + so;
			stmt.setInt(1, cd.getSoLuongCongDoanPhanCong());
			stmt.setString(2, maPC);
			stmt.setString(3, cd.getMaCD());
			stmt.setString(4, cd.getMaCN());

			// Chuyển LocalDate thành java.sql.Date
			java.sql.Date ngay = java.sql.Date.valueOf(cd.getNgayBatDau());
			stmt.setDate(5, ngay);

			stmt.setString(6, cd.getMaSP());

			result = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean updateCD(PhanCongCongDoan cd) {

		String sql = "update PhanCongCongDoan set ngayBatDau=?,soLuongCongDoanPhanCong=?, maSP = ?, maCD =? where maCN=?";
		boolean result = false;

		try (Connection connection = ConnectDB.getInstance().connect();
				PreparedStatement stmt = connection.prepareStatement(sql)) {

//			stmt.setDate(1,ProcessDate.localDate2Date(cd.getNgayBatDau()));
			// Chuyển LocalDate thành java.sql.Date
			java.sql.Date ngay = java.sql.Date.valueOf(cd.getNgayBatDau());
			stmt.setDate(1, ngay);

			stmt.setInt(2, cd.getSoLuongCongDoanPhanCong());
			stmt.setString(3, cd.getMaSP());
			stmt.setString(4, cd.getMaCD());
			stmt.setString(5, cd.getMaCN());
			result = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public boolean xoaPhanCongCD(String ma) {
//		ConnectDB.getInstance();
//		Connection con= ConnectDB.getConnection();
//		PreparedStatement stmt=null;
		boolean result = false;
		String sql = "delete from PhanCongCongDoan where maCN=?";

		try (Connection connection = ConnectDB.getInstance().connect();
				PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, ma);
			result = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
