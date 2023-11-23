package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.BangChamCongCongNhan;
import DTO.BangLuongCongNhan;
import DTO.CongNhan;
import DAO.ConnectDB;
import utilities.ProcessDate;

public class BangLuongCongNhan_DAO {
    public ArrayList<BangLuongCongNhan> getALLbangluongCN() {
        ArrayList<BangLuongCongNhan> dsBangLuongCN = new ArrayList<BangLuongCongNhan>();

        try (Connection con = ConnectDB.getInstance().connect(); Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from BangluongCongNhan l join CongNhan nv on l.MaCN=nv.maCongNhan join BangChamCongCongNhan cc on l.maCN =cc.maCN ");
            while (rs.next()) {
                CongNhan cn = new CongNhan(rs.getString("maCN"), rs.getString("ten"), rs.getString("sDT"), rs.getString("xuong"), rs.getString("chuyenMon"));
//                LocalDate ngayChamCong = ProcessDate.date2LocalDate(rs.getDate("ngayChamCong"));
                BangChamCongCongNhan cc = new BangChamCongCongNhan(rs.getString("maBangChamCongCN"),
                        rs.getString("maCN"), rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"),
                        rs.getInt("SoLuongHangLamDuoc"), rs.getInt("soGioTangCa"),rs.getDate("ngayChamCong"), rs.getInt("coPhep"));
                LocalDate ngayTinh = ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
                dsBangLuongCN.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
                        rs.getDouble("luongThang"), rs.getDouble("phuCap"), rs.getDouble("tienThuong"),
                        rs.getDouble("baoHiemXH"), rs.getDouble("thucLanh"), ngayTinh, cn, cc));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsBangLuongCN;
    }

    public ArrayList<BangLuongCongNhan> getallbangLuongCNTK(String ma) {
        ArrayList<BangLuongCongNhan> dsBangLuongCNTK = new ArrayList<>();

        try (Connection con = ConnectDB.getInstance().connect();
             PreparedStatement stmt = con.prepareStatement("select * from BangluongCongNhan l join CongNhan nv on l.MaCN=nv.maCongNhan join BangChamCongCongNhan cc on l.maCN =cc.maCN where maCongNhan = ? ")) {
            stmt.setString(1, ma);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CongNhan cn = new CongNhan(rs.getString("maCN"), rs.getString("ten"), rs.getString("sDT"), rs.getString("xuong"), rs.getString("chuyenMon"));
//                LocalDate ngayChamCong = ProcessDate.date2LocalDate(rs.getDate("ngayChamCong"));
                BangChamCongCongNhan cc = new BangChamCongCongNhan(rs.getString("maBangChamCongCN"),
                        rs.getString("maCN"), rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"),
                        rs.getInt("SoLuongHangLamDuoc"), rs.getInt("soGioTangCa"), rs.getDate("ngayChamCong"), rs.getInt("coPhep"));
                LocalDate ngayTinh = ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
                dsBangLuongCNTK.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
                        rs.getDouble("luongThang"), rs.getDouble("phuCap"), rs.getDouble("tienThuong"),
                        rs.getDouble("baoHiemXH"), rs.getDouble("thucLanh"), ngayTinh, cn, cc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsBangLuongCNTK;
    }
    public ArrayList<BangLuongCongNhan> getalltheonam(String nam) {
        ArrayList<BangLuongCongNhan> dsBLNVtheonam = new ArrayList<>();

        try (Connection con = ConnectDB.getInstance().connect();
             PreparedStatement prtm = con.prepareStatement("select * from BangluongCongNhan l join CongNhan nv on l.MaCN=nv.maCongNhan join BangChamCongCongNhan cc on l.maCN =cc.maCN where year(thoiGian)= ? ")) {
            prtm.setString(1, nam);
            ResultSet rs = prtm.executeQuery();
            while (rs.next()) {
                CongNhan cn = new CongNhan(rs.getString("maCN"), rs.getString("ten"), rs.getString("sDT"), rs.getString("xuong"), rs.getString("chuyenMon"));
//                LocalDate ngayChamCong = ProcessDate.date2LocalDate(rs.getDate("ngayChamCong"));
                BangChamCongCongNhan cc = new BangChamCongCongNhan(rs.getString("maBangChamCongCN"),
                        rs.getString("maCN"), rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"),
                        rs.getInt("SoLuongHangLamDuoc"), rs.getInt("soGioTangCa"), rs.getDate("ngayChamCong"), rs.getInt("coPhep"));
                LocalDate ngayTinh = ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
                dsBLNVtheonam.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
                        rs.getDouble("luongThang"), rs.getDouble("phuCap"), rs.getDouble("tienThuong"),
                        rs.getDouble("baoHiemXH"), rs.getDouble("thucLanh"), ngayTinh, cn, cc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsBLNVtheonam;
    }

    public ArrayList<BangLuongCongNhan> getalltheothang(String thang) {
        ArrayList<BangLuongCongNhan> dsBLNVtheothang = new ArrayList<>();

        try (Connection con = ConnectDB.getInstance().connect();
             PreparedStatement prtm = con.prepareStatement("select * from BangluongCongNhan l join CongNhan nv on l.MaCN=nv.maCongNhan join BangChamCongCongNhan cc on l.maCN =cc.maCN where month(thoiGian)= ? ")) {
            prtm.setString(1, thang);
            ResultSet rs = prtm.executeQuery();
            while (rs.next()) {
                CongNhan cn = new CongNhan(rs.getString("maCN"), rs.getString("ten"), rs.getString("sDT"), rs.getString("xuong"), rs.getString("chuyenMon"));
//                LocalDate ngayChamCong = ProcessDate.date2LocalDate(rs.getDate("ngayChamCong"));
                BangChamCongCongNhan cc = new BangChamCongCongNhan(rs.getString("maBangChamCongCN"),
                        rs.getString("maCN"), rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"),
                        rs.getInt("SoLuongHangLamDuoc"), rs.getInt("soGioTangCa"), rs.getDate("ngayChamCong"), rs.getInt("coPhep"));
                LocalDate ngayTinh = ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
                dsBLNVtheothang.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
                        rs.getDouble("luongThang"), rs.getDouble("phuCap"), rs.getDouble("tienThuong"),
                        rs.getDouble("baoHiemXH"), rs.getDouble("thucLanh"), ngayTinh, cn, cc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsBLNVtheothang;
    }
    public ArrayList<BangLuongCongNhan> getallbangLuongTK(String ma) {
        ArrayList<BangLuongCongNhan> dsBangLuongCNTK = new ArrayList<>();

        try (Connection con = ConnectDB.getInstance().connect();
             PreparedStatement stmt = con.prepareStatement("select * \r\n"
             		+ "from BangluongCongNhan l join CongNhan nv on l.MaCN=nv.maCongNhan\r\n"
             		+ "join BangChamCongCongNhan cc on l.maCN =cc.maCN \r\n"
             		+ "WHERE  l.MaCN LIKE CONCAT('%', ?, '%') OR ten LIKE CONCAT('%', ?, '%') \r\n"
             		+ "OR sDT LIKE CONCAT('%', ?, '%') \r\n"
             		+ "OR chuyenMon LIKE CONCAT('%', ?, '%')  OR soNgayNghi LIKE CONCAT('%', ?, '%') \r\n"
             		+ "OR soSPLamDuocTrongGioTangCa  LIKE CONCAT('%',  ?, '%')  OR soLuongHangLamDuoc LIKE CONCAT('%',  ?, '%')\r\n"
             		+ "OR xuong LIKE CONCAT('%',  ?, '%') OR soGioTangCa LIKE CONCAT('%',  ?, '%') OR diaChi LIKE CONCAT('%',  ?, '%') ")) {
            stmt.setString(1, ma);
            stmt.setString(2, ma);
            stmt.setString(3, ma);
            stmt.setString(4, ma);
            stmt.setString(5, ma);
            stmt.setString(6, ma);
            stmt.setString(7, ma);
            stmt.setString(8, ma);
            stmt.setString(9, ma);
            stmt.setString(10, ma);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CongNhan cn = new CongNhan(rs.getString("maCN"), rs.getString("ten"), rs.getString("sDT"), rs.getString("xuong"), rs.getString("chuyenMon"));
//                LocalDate ngayChamCong = ProcessDate.date2LocalDate(rs.getDate("ngayChamCong"));
                BangChamCongCongNhan cc = new BangChamCongCongNhan(rs.getString("maBangChamCongCN"),
                        rs.getString("maCN"), rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"),
                        rs.getInt("SoLuongHangLamDuoc"), rs.getInt("soGioTangCa"), rs.getDate("ngayChamCong"), rs.getInt("coPhep"));
                LocalDate ngayTinh = ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
                dsBangLuongCNTK.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
                        rs.getDouble("luongThang"), rs.getDouble("phuCap"), rs.getDouble("tienThuong"),
                        rs.getDouble("baoHiemXH"), rs.getDouble("thucLanh"), ngayTinh, cn, cc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsBangLuongCNTK;
    }
}
