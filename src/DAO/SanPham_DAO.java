package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.ConnectDB;
import DTO.SanPham;

public class SanPham_DAO {
	
	public SanPham_DAO() {}
	
	public ArrayList<SanPham> getAllSanPham() {
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
	
	public ArrayList<SanPham> getSanPhamTheoMa(String id){
		ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from SanPham where maSanPham = ?";
			statement= con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String maSP = rs.getString("maSanPham");
				String tenSP = rs.getString("tenSanPham");
				int slCongDoan = rs.getInt("soLuongCongDoan");
				int slSanPham = rs.getInt("soLuong");
				SanPham sp = new SanPham(maSP, tenSP, slCongDoan, slSanPham);
				danhSachSanPham.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return danhSachSanPham;
	}
	
	public boolean create(SanPham sp) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n=0;
		try {

			statement= con.prepareStatement("insert into SanPham values(?,?,?,?)");
			statement.setString(1, sp.getMaSanPham());
			statement.setString(2, sp.getTenSanPham());
			statement.setInt(3, sp.getSoLuongCongDoan());
			statement.setInt(4, sp.getSoLuong());
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return n>0;
	}
	
	public boolean update(SanPham sp) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n=0;
		try {

			statement= con.prepareStatement("update SanPham set tenSanPham =? , soLuongCongDoan=?,soLuong=? "
					+ "						where maSanPham=?");
			
			statement.setString(1, sp.getMaSanPham());
			statement.setString(2, sp.getTenSanPham());
			statement.setInt(3, sp.getSoLuongCongDoan());
			statement.setInt(4, sp.getSoLuong());
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();		
		}
		finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return n>0;
	}
	
	public boolean delete(SanPham sp) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n=0;
		try {

			statement= con.prepareStatement("delete from SanPham where maSanPham=?");
			statement.setString(1, sp.getMaSanPham());	
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return n>0;
	}

}
