package DAO;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.BangLuongCongNhan;
import DTO.BangLuongNhanVien;
import DTO.CongNhan;
import DTO.NhanVien;
import DTO.Thongke;
import DTO.tkluong_nam;
import utilities.ProcessDate;
import DAO.ConnectDB;

public class ThongKe_DAO {
	public Thongke getThongKe()  {
		Thongke tk= new Thongke();
		tk.setSoLuongCongDoan(getSoluongCongDoanSP());
		tk.setSoLuongCongNhan1(getSoluongCN());
		tk.setSoLuongSanPham(getSoluongSP());
		tk.setSoLuongNhanVien(getSoluongNV());
		tk.setTongLuong(getTongLuong());
		return tk;
	
	}
//	public static void main(String[] args) {
//		Thongke tk=
//	}
	private int getSoluongSP()   {
		
					
					try {
						ConnectDB.getInstance();
						Connection con = ConnectDB.getConnection();
					
						Statement 	stmt = (Statement) con.createStatement();
						
						 ResultSet rs;
						 rs = ((java.sql.Statement) stmt).executeQuery("SELECT COUNT(*) FROM SanPham");
						 
						 while(rs.next()) {
								return rs.getInt(1);
								
							}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						return -1;
					}
			
				
		return 0;
	}
	private int getSoluongNV() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("SELECT COUNT(*) FROM NhanVien");
			while(rs.next()) {
				return rs.getInt(1);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
		
		return 0;
	}
	private int getSoluongCN() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("SELECT COUNT(*) FROM CongNhan");
			while(rs.next()) {
				return rs.getInt(1);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
		return 0;
	}
	private int getSoluongCongDoanSP() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("SELECT COUNT(*) FROM CongDoanSanPham");
			while(rs.next()) {
				return rs.getInt(1);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
		return 0;
	}
	private double getTongLuong() {
		double sum=0.0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("SELECT SUM(luongThang) as tongLuong FROM BangluongNhanVien ");
			while(rs.next()) {
				sum= rs.getInt(1);
				
			}
			ResultSet rst=((java.sql.Statement) stmt).executeQuery("SELECT SUM(luongThang) as tongLuongcn FROM BangluongCongNhan ");
			while(rs.next()) {
				sum+= rst.getInt(1);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
		
		}
		return sum;
		
	}
	public ArrayList<BangLuongCongNhan> getallBangluongCNavg(){
		ArrayList<BangLuongCongNhan> dsCN= new ArrayList<>();
		ConnectDB.getInstance();
		Connection con= ConnectDB.getConnection();
		
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from BangluongCongNhan l join CongNhan cn on l.MaCN=cn.maCongNhan where luongThang >(select AVG(luongThang) from BangluongCongNhan)");
			while(rs.next()) {
				CongNhan cn= new CongNhan(rs.getString("maCN"),rs.getString("ten"),rs.getString("sDT"),rs.getString("xuong"),rs.getString("chuyenMon"));
				LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
				dsCN.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
						rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),
						rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),ngayTinh,cn) );
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsCN;
	}
	public ArrayList<BangLuongCongNhan> getalltheothang(String thang){
		ArrayList<BangLuongCongNhan> dsBLNVtheothang= new ArrayList<>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement prtm;
		try {
			prtm = con.prepareStatement("select * from BangluongCongNhan l join CongNhan nv on l.MaCN=nv.maCongNhan where month(thoiGian)= ? and thucLanh>(select avg(thucLanh) from BangluongCongNhan)  ");
		
			prtm.setString(1,thang);
			ResultSet rs= prtm.executeQuery();
			while(rs.next()) {
				CongNhan cn= new CongNhan(rs.getString("maCN"),rs.getString("ten"),rs.getString("sDT"),rs.getString("xuong"),rs.getString("chuyenMon"));
				LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
				dsBLNVtheothang.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
						rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),
						rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),ngayTinh,cn) );
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dsBLNVtheothang;
		
	}
	public ArrayList<BangLuongCongNhan> getalltheonam(String nam){
		ArrayList<BangLuongCongNhan> dsBLNVtheonam= new ArrayList<>();
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement prtm;
		try {
			prtm = con.prepareStatement("select * from BangluongCongNhan l join CongNhan nv on l.MaCN=nv.maCongNhan where year(thoiGian)= ? and thucLanh>(select avg(thucLanh) from BangluongCongNhan)");
		
			prtm.setString(1,nam);
			ResultSet rs= prtm.executeQuery();
			while(rs.next()) {
				CongNhan cn= new CongNhan(rs.getString("maCN"),rs.getString("ten"),rs.getString("sDT"),rs.getString("xuong"),rs.getString("chuyenMon"));
				LocalDate ngayTinh=ProcessDate.date2LocalDate(rs.getDate("thoiGian"));
				dsBLNVtheonam.add(new BangLuongCongNhan(rs.getString("maBangLuong"),
						rs.getDouble("luongThang"),rs.getDouble("phuCap"),rs.getDouble("tienThuong"),
						rs.getDouble("baoHiemXH"),rs.getDouble("thucLanh"),ngayTinh,cn) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dsBLNVtheonam;
		
	}
	public ArrayList<tkluong_nam> getalltkluongnam(){
		ArrayList<tkluong_nam> dstk= new ArrayList<>();
		ConnectDB.getInstance();
		Connection con= ConnectDB.getConnection();
		Statement stmt;
		try {
			stmt=con.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT \r\n"
					+ "    YEAR(thoiGian) AS nam,\r\n"
					+ "    MONTH(thoiGian) AS thang,\r\n"
					+ "    SUM(thucLanh) AS tong_luong,\r\n"
					+ "	SUM(soLuongCongDoanPhanCong) as soluong\r\n"
					+ "FROM BangluongCongNhan l join CongNhan cn on l.MaCN=cn.maCongNhan join PhanCongCongDoan pc on cn.maCongNhan=pc.maCN \r\n"
					+ "WHERE thoiGian >= DATEADD(MONTH, -12, GETDATE())\r\n"
					+ "GROUP BY YEAR(thoiGian), MONTH(thoiGian)\r\n"
					+ "ORDER BY nam asc, thang aSC;");
			while(rs.next()) {
				dstk.add(new tkluong_nam(rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getInt(4)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dstk;
	}

	
	
	
	
	
	
	

}
