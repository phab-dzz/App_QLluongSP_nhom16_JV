package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.BangChamCongNhanVien;
import DTO.BangLuongNhanVien;
import DTO.NhanVien;
import utilities.ProcessDate;

public class BangLuongNhanVien_DAO {
	public ArrayList<BangLuongNhanVien> getALLbangluongNV() {
		ArrayList<BangLuongNhanVien> dsBangLuongNV = new ArrayList<BangLuongNhanVien>();
		try (Connection con = ConnectDB.getInstance().connect()) {
			String sql = "select  * from BangluongNhanVien l join NhanVien nv on l.MaNV=nv.maNhanVien join BangChamCongNhanVien cc  on l.thoiGian=cc.ngayChamCong AND l.MaNV = cc.maNhanVien";
			try (Statement statement = con.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
				while (rs.next()) {
					NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("ten"),
							rs.getString("phongBan"));

					// Xử lý ngày tháng để tránh NullPointerException
					LocalDate ngayTinh = getLocalDate(rs, "thoiGian");
//	                LocalDate ngayChamCong = getLocalDate(rs, "ngayChamCong");

					BangChamCongNhanVien cc = new BangChamCongNhanVien(rs.getString("maBangChamCongNV"),
							rs.getString("maNhanVien"), rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"),
							rs.getDouble("soGioTangCa"), rs.getDate("ngayChamCong"), rs.getInt("coPhep"));

					dsBangLuongNV.add(new BangLuongNhanVien(rs.getString("maBangLuong"), rs.getDouble("luongThang"),
							rs.getDouble("phuCap"), rs.getDouble("tienThuong"), rs.getDouble("baoHiemXH"),
							rs.getDouble("thucLanh"), rs.getDouble("luongCoBan"), ngayTinh, nv, cc));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsBangLuongNV;
	}

	private LocalDate getLocalDate(ResultSet rs, String columnName) throws SQLException {
		java.sql.Date dateSql = rs.getDate(columnName);
		return (dateSql != null) ? ProcessDate.date2LocalDate(dateSql) : null;
	}

	public ArrayList<BangLuongNhanVien> getallbangLuongNVTK(String ma) {
		ArrayList<BangLuongNhanVien> dsBangLuongNVTK = new ArrayList<>();
		try (Connection con = ConnectDB.getInstance().connect()) {
			String sql = "SELECT * FROM BangluongNhanVien l JOIN NhanVien nv ON l.MaNV=nv.maNhanVien JOIN BangChamCongNhanVien cc ON l.MaNV = cc.maNhanVien WHERE MaNV = ?";
			try (PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, ma);
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("ten"),
								rs.getString("phongBan"));
						LocalDate ngayTinh = getLocalDate(rs, "thoiGian");
//	                    LocalDate ngayChamCong = getLocalDate(rs, "ngayChamCong");
						BangChamCongNhanVien cc = new BangChamCongNhanVien(rs.getString("maBangChamCongNV"),
								rs.getString("maNhanVien"), rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"),
								rs.getDouble("soGioTangCa"), rs.getDate("ngayChamCong"), rs.getInt("coPhep"));
						dsBangLuongNVTK
								.add(new BangLuongNhanVien(rs.getString("maBangLuong"), rs.getDouble("luongThang"),
										rs.getDouble("phuCap"), rs.getDouble("tienThuong"), rs.getDouble("baoHiemXH"),
										rs.getDouble("thucLanh"), rs.getDouble("luongCoBan"), ngayTinh, nv, cc));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsBangLuongNVTK;
	}

	public ArrayList<BangLuongNhanVien> getalltheonam(String nam) {
		ArrayList<BangLuongNhanVien> dsBLNVtheonam = new ArrayList<>();
		try (Connection con = ConnectDB.getInstance().connect()) {
			String sql = "SELECT * FROM BangLuongNhanVien l JOIN NhanVien nv ON l.MaNV=nv.maNhanVien JOIN BangChamCongNhanVien cc ON l.MaNV = cc.maNhanVien WHERE YEAR(thoiGian) = ?";
			try (PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, nam);
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("ten"),
								rs.getString("phongBan"));
						LocalDate ngayTinh = getLocalDate(rs, "thoiGian");
//	                    LocalDate ngayChamCong = getLocalDate(rs, "ngayChamCong");
						BangChamCongNhanVien cc = new BangChamCongNhanVien(rs.getString("maBangChamCongNV"),
								rs.getString("maNhanVien"), rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"),
								rs.getDouble("soGioTangCa"), rs.getDate("ngayChamCong"), rs.getInt("coPhep"));
						dsBLNVtheonam.add(new BangLuongNhanVien(rs.getString("maBangLuong"), rs.getDouble("luongThang"),
								rs.getDouble("phuCap"), rs.getDouble("tienThuong"), rs.getDouble("baoHiemXH"),
								rs.getDouble("thucLanh"), rs.getDouble("luongCoBan"), ngayTinh, nv, cc));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsBLNVtheonam;
	}

	public ArrayList<BangLuongNhanVien> getalltheothang(String thang) {
		ArrayList<BangLuongNhanVien> dsBLNVtheothang = new ArrayList<>();
		try (Connection con = ConnectDB.getInstance().connect()) {
			String sql = "SELECT * FROM BangLuongNhanVien l JOIN NhanVien nv ON l.MaNV=nv.maNhanVien JOIN BangChamCongNhanVien cc ON l.MaNV = cc.maNhanVien WHERE MONTH(thoiGian) = ?";
			try (PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, thang);
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("ten"),
								rs.getString("phongBan"));
						LocalDate ngayTinh = getLocalDate(rs, "thoiGian");
						LocalDate ngayChamCong = getLocalDate(rs, "ngayChamCong");
						BangChamCongNhanVien cc = new BangChamCongNhanVien(rs.getString("maBangChamCongNV"),
								rs.getString("maNhanVien"), rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"),
								rs.getDouble("soGioTangCa"), rs.getDate("ngayChamCong"), rs.getInt("coPhep"));
						dsBLNVtheothang
								.add(new BangLuongNhanVien(rs.getString("maBangLuong"), rs.getDouble("luongThang"),
										rs.getDouble("phuCap"), rs.getDouble("tienThuong"), rs.getDouble("baoHiemXH"),
										rs.getDouble("thucLanh"), rs.getDouble("luongCoBan"), ngayTinh, nv, cc));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsBLNVtheothang;
	}

	public ArrayList<BangLuongNhanVien> getallbangLuongtk(String text) {
		ArrayList<BangLuongNhanVien> dsBangLuongNVTK = new ArrayList<>();
		try (Connection con = ConnectDB.getInstance().connect()) {
//	        String sql = "SELECT * FROM BangluongNhanVien l JOIN NhanVien nv ON l.MaNV=nv.maNhanVien JOIN BangChamCongNhanVien cc ON l.MaNV = cc.maNhanVien WHERE MaNV = ?";

			String sql = "select  * \r\n" + "from BangluongNhanVien l join NhanVien nv on l.MaNV=nv.maNhanVien \r\n"
					+ "join BangChamCongNhanVien cc  on l.thoiGian=cc.ngayChamCong AND l.MaNV = cc.maNhanVien\r\n"
					+ "\r\n"
					+ "WHERE MaNV LIKE CONCAT('%', ?, '%') OR ten LIKE CONCAT('%', ?, '%') OR sDT LIKE CONCAT('%', ?, '%') OR chucDanh LIKE CONCAT('%', ?, '%')  OR email LIKE CONCAT('%', ?, '%') OR phongBan LIKE CONCAT('%',  ?, '%')  OR soGioTangCa  LIKE CONCAT('%',  ?, '%') OR soNgayNghi LIKE CONCAT('%',  ?, '%')";
			try (PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, text);
				stmt.setString(2, text);
				stmt.setString(3, text);

				stmt.setString(4, text);
				stmt.setString(5, text);
				stmt.setString(6, text);
				stmt.setString(7, text);
				stmt.setString(8, text);
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("ten"),
								rs.getString("phongBan"));
						LocalDate ngayTinh = getLocalDate(rs, "thoiGian");
//	                    LocalDate ngayChamCong = getLocalDate(rs, "ngayChamCong");
						BangChamCongNhanVien cc = new BangChamCongNhanVien(rs.getString("maBangChamCongNV"),
								rs.getString("maNhanVien"), rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"),
								rs.getDouble("soGioTangCa"), rs.getDate("ngayChamCong"), rs.getInt("coPhep"));
						dsBangLuongNVTK
								.add(new BangLuongNhanVien(rs.getString("maBangLuong"), rs.getDouble("luongThang"),
										rs.getDouble("phuCap"), rs.getDouble("tienThuong"), rs.getDouble("baoHiemXH"),
										rs.getDouble("thucLanh"), rs.getDouble("luongCoBan"), ngayTinh, nv, cc));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsBangLuongNVTK;
	}

//	public ArrayList<BangLuongNhanVien> getBLNV_tg(String nam, String month) {
//	    ArrayList<BangLuongNhanVien> dsNV = new ArrayList<>();
//	    int thang = Integer.parseInt(month);
//	    String d1 = nam + "-" + thang + "-01";
//	    String d2 = nam + "-" + (thang + 1) + "-01";
//	    String sql = "SELECT * FROM BangluongNhanVien l JOIN NhanVien nv ON l.MaNV=nv.maNhanVien JOIN BangChamCongNhanVien cc ON l.MaNV = cc.maNhanVien WHERE thoiGian BETWEEN CAST( ? AS DATE) AND CAST(? AS DATE)";
//	    try (Connection con = ConnectDB.getInstance().connect(); PreparedStatement stmt = con.prepareStatement(sql)) {
//	        stmt.setString(1, d1);
//	        stmt.setString(2, d2);
//	        try (ResultSet rs = stmt.executeQuery()) {
//	            while (rs.next()) {
//	                NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("ten"), rs.getString("phongBan"));
//	                LocalDate ngayTinh = getLocalDate(rs, "thoiGian");
//	                LocalDate ngayChamCong = getLocalDate(rs, "ngayChamCong");
//	                BangChamCongNhanVien cc = new BangChamCongNhanVien(rs.getString("maBangChamCongNV"), rs.getString("maNhanVien"),
//	                        rs.getInt("soNgayLamViec"), rs.getInt("soNgayNghi"), rs.getDouble("soGioTangCa"), ngayChamCong, rs.getInt("coPhep"));
//	                dsNV.add(new BangLuongNhanVien(rs.getString("maBangLuong"), rs.getDouble("luongThang"), rs.getDouble("phuCap"), rs.getDouble("tienThuong"), rs.getDouble("baoHiemXH"), rs.getDouble("thucLanh"), rs.getDouble("luongCoBan"), ngayTinh, nv, cc));
//	            }
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return dsNV;
//	}

//	public static void main(String[] args) {
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		BangLuongNhanVien_DAO nv_DAO = new BangLuongNhanVien_DAO();
//		for(BangLuongNhanVien l:nv_DAO.getALLbangluongNV()) {
//			System.out.println(l.getNv().getMaNhanVien());
//		}
//	}
}
