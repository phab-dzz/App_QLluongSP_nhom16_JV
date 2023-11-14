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
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        try (Connection con = ConnectDB.getInstance().connect();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM SanPham")) {

            while (rs.next()) {
                String maSP = rs.getString("maSanPham");
                String tenSP = rs.getString("tenSanPham");
                int slCongDoan = rs.getInt("soLuongCongDoan");
                int slSanPham = rs.getInt("soLuong");
                SanPham sp = new SanPham(maSP, tenSP, slCongDoan, slSanPham);
                danhSachSanPham.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachSanPham;
    }

    public ArrayList<SanPham> getSanPhamTheoMa(String id) {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();

        try (Connection con = ConnectDB.getInstance().connect();
             PreparedStatement statement = con.prepareStatement("SELECT * FROM SanPham WHERE maSanPham = ?")) {

            statement.setString(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String maSP = rs.getString("maSanPham");
                    String tenSP = rs.getString("tenSanPham");
                    int slCongDoan = rs.getInt("soLuongCongDoan");
                    int slSanPham = rs.getInt("soLuong");
                    SanPham sp = new SanPham(maSP, tenSP, slCongDoan, slSanPham);
                    danhSachSanPham.add(sp);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachSanPham;
    }

    public boolean create(SanPham sp) {
        int n = 0;
        try (Connection con = ConnectDB.getInstance().connect();
             PreparedStatement statement = con.prepareStatement("INSERT INTO SanPham VALUES (?, ?, ?, ?)")) {

            statement.setString(1, sp.getMaSanPham());
            statement.setString(2, sp.getTenSanPham());
            statement.setInt(3, sp.getSoLuongCongDoan());
            statement.setInt(4, sp.getSoLuong());
            n = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    public boolean update(SanPham sp) {
        int n = 0;
        try (Connection con = ConnectDB.getInstance().connect();
             PreparedStatement statement = con.prepareStatement(
                     "UPDATE SanPham SET tenSanPham = ?, soLuongCongDoan = ?, soLuong = ? WHERE maSanPham = ?")) {

            statement.setString(1, sp.getTenSanPham());
            statement.setInt(2, sp.getSoLuongCongDoan());
            statement.setInt(3, sp.getSoLuong());
            statement.setString(4, sp.getMaSanPham());
            n = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    public boolean delete(SanPham sp) {
        int n = 0;
        try (Connection con = ConnectDB.getInstance().connect();
             PreparedStatement statement = con.prepareStatement("DELETE FROM SanPham WHERE maSanPham = ?")) {

            statement.setString(1, sp.getMaSanPham());
            n = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }

}
