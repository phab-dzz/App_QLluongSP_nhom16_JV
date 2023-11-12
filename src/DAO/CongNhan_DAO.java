package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.CongNhan;

public class CongNhan_DAO {

	
	public CongNhan_DAO() {
		
	}

	//Lấy danh sách theo phòng ban
		public ArrayList<CongNhan> getDanhSachCongNhan() {
		    ArrayList<CongNhan> dscn = new ArrayList<>();
		    String sql ="SELECT * FROM [QLLUONG].[dbo].[CongNhan]";

		    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		        

		        try (ResultSet resultSet = preparedStatement.executeQuery()) {
		            while (resultSet.next()) {
		                CongNhan cn = new CongNhan();
		                cn.setMaCongNhan(resultSet.getString("maCongNhan"));
		                cn.setTen(resultSet.getString("ten"));
		                cn.setsDT(resultSet.getString("sDT"));
		                cn.setChuyenMon(resultSet.getString("chuyenMon"));
		                cn.setXuong(resultSet.getString("xuong"));
		                cn.setDiaChi(resultSet.getString("diaChi"));
		                
		                // Lấy giới tính từ cột "gioiTinh" dưới dạng boolean
		                boolean gioiTinhBit = resultSet.getBoolean("gioiTinh");
		                cn.setGioiTinh(gioiTinhBit);
		                
		                // Lấy giới tính từ cột "trangThai" dưới dạng boolean
		                boolean trangThaiBit = resultSet.getBoolean("trangThai");
		                cn.setGioiTinh(trangThaiBit);

		                // Lấy ngày tham gia từ cột "ngayThamGia" dưới dạng LocalDate
		                java.sql.Date ngayThamGiaSql = resultSet.getDate("ngayThamGia");
		                if (ngayThamGiaSql != null) {
		                    cn.setNgayThamGia(ngayThamGiaSql.toLocalDate());
		                }

		             // Lấy ngày tham gia từ cột "ngaySinh" dưới dạng LocalDate
		                java.sql.Date ngaySinhSql = resultSet.getDate("ngaySinh");
		                if (ngaySinhSql != null) {
		                    cn.setNgaySinh(ngaySinhSql.toLocalDate());
		                }
		                cn.setTrinhDoChuyenMon(resultSet.getDouble("trinhDoChuyenMon"));
		                cn.setLuongPhuCap(resultSet.getDouble("luongPhuCap"));
		                
		                dscn.add(cn);
		            }
		        }
		    } catch (SQLException e) {
		        // Xử lý lỗi cụ thể thay vì chỉ ghi log
		        e.printStackTrace(); // Ghi log lỗi, bạn có thể thay thế bằng hành động xử lý lỗi cụ thể

		        // Ví dụ: Nếu trong ứng dụng GUI, bạn có thể hiển thị thông báo lỗi đến người dùng
		        // JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Lỗi truy vấn", JOptionPane.ERROR_MESSAGE);
		    }

		    return dscn;
		}


	
	//Lấy danh sách theo phòng ban
	public ArrayList<CongNhan> getDanhSachCongNhanXuong(String tenXuong) {
	    ArrayList<CongNhan> dscn = new ArrayList<>();
	    String sql = "SELECT * FROM [QLLUONG].[dbo].[CongNhan] WHERE xuong = ?"; // Sửa câu lệnh SQL

	    try (Connection connection = ConnectDB.getInstance().connect();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        // Truyền giá trị của tham số tên phòng ban
	        preparedStatement.setString(1, tenXuong);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	            	CongNhan cn = new CongNhan();
	                cn.setMaCongNhan(resultSet.getString("maCongNhan"));
	                cn.setTen(resultSet.getString("ten"));
	                cn.setsDT(resultSet.getString("sDT"));
	                cn.setChuyenMon(resultSet.getString("chuyenMon"));
	                cn.setXuong(resultSet.getString("xuong"));
	                cn.setDiaChi(resultSet.getString("diaChi"));
	                
	                // Lấy giới tính từ cột "gioiTinh" dưới dạng boolean
	                boolean gioiTinhBit = resultSet.getBoolean("gioiTinh");
	                cn.setGioiTinh(gioiTinhBit);
	                
	                // Lấy giới tính từ cột "trangThai" dưới dạng boolean
	                boolean trangThaiBit = resultSet.getBoolean("trangThai");
	                cn.setGioiTinh(trangThaiBit);

	                // Lấy ngày tham gia từ cột "ngayThamGia" dưới dạng LocalDate
	                java.sql.Date ngayThamGiaSql = resultSet.getDate("ngayThamGia");
	                if (ngayThamGiaSql != null) {
	                    cn.setNgayThamGia(ngayThamGiaSql.toLocalDate());
	                }

	             // Lấy ngày tham gia từ cột "ngaySinh" dưới dạng LocalDate
	                java.sql.Date ngaySinhSql = resultSet.getDate("ngaySinh");
	                if (ngaySinhSql != null) {
	                    cn.setNgaySinh(ngaySinhSql.toLocalDate());
	                }
	                cn.setTrinhDoChuyenMon(resultSet.getDouble("trinhDoChuyenMon"));
	                cn.setLuongPhuCap(resultSet.getDouble("luongPhuCap"));
	                
	                dscn.add(cn);
	            }
	        }
	    } catch (SQLException e) {
	        // Xử lý lỗi cụ thể thay vì chỉ ghi log
	        e.printStackTrace(); // Ghi log lỗi, bạn có thể thay thế bằng hành động xử lý lỗi cụ thể

	        // Ví dụ: Nếu trong ứng dụng GUI, bạn có thể hiển thị thông báo lỗi đến người dùng
	        // JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Lỗi truy vấn", JOptionPane.ERROR_MESSAGE);
	    }

	    return dscn;
	}



	
	// Phương thức Search trả về Nhân Viên
	public CongNhan getCongNhan(String maCongNhan) {
	    CongNhan cn = null;
	    String sql = "SELECT * FROM [QLLUONG].[dbo].[CongNhan] WHERE maCongNhan = ?";
	    
	    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, maCongNhan);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            cn = new CongNhan();
                cn.setMaCongNhan(resultSet.getString("maCongNhan"));
                cn.setTen(resultSet.getString("ten"));
                cn.setsDT(resultSet.getString("sDT"));
                cn.setChuyenMon(resultSet.getString("chuyenMon"));
                cn.setXuong(resultSet.getString("xuong"));
                cn.setDiaChi(resultSet.getString("diaChi"));
                
                // Lấy giới tính từ cột "gioiTinh" dưới dạng boolean
                boolean gioiTinhBit = resultSet.getBoolean("gioiTinh");
                cn.setGioiTinh(gioiTinhBit);
                
                // Lấy giới tính từ cột "trangThai" dưới dạng boolean
                boolean trangThaiBit = resultSet.getBoolean("trangThai");
                cn.setGioiTinh(trangThaiBit);

                // Lấy ngày tham gia từ cột "ngayThamGia" dưới dạng LocalDate
                java.sql.Date ngayThamGiaSql = resultSet.getDate("ngayThamGia");
                if (ngayThamGiaSql != null) {
                    cn.setNgayThamGia(ngayThamGiaSql.toLocalDate());
                }

             // Lấy ngày tham gia từ cột "ngaySinh" dưới dạng LocalDate
                java.sql.Date ngaySinhSql = resultSet.getDate("ngaySinh");
                if (ngaySinhSql != null) {
                    cn.setNgaySinh(ngaySinhSql.toLocalDate());
                }
                cn.setTrinhDoChuyenMon(resultSet.getDouble("trinhDoChuyenMon"));
                cn.setLuongPhuCap(resultSet.getDouble("luongPhuCap"));
	           
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ bằng cách ghi log lỗi
	    }
	    
	    return cn;
	}
	
	
	// Phương thức Add Nhân Viên
	public boolean addCongNhan(CongNhan cn) {
	    String sql = "INSERT INTO CongNhan (maCongNhan, trinhDoChuyenMon, ngaySinh, ten, gioiTinh, diaChi, ngayThamGia, trangThai, sDT, xuong, chuyenMon, luongPhuCap) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, cn.getMaCongNhan());
	        preparedStatement.setDouble(2, cn.getTrinhDoChuyenMon()); 
	        
	        if (cn.getNgaySinh() != null) {
	        	java.sql.Date ngaySinhSql = java.sql.Date.valueOf(cn.getNgaySinh());
	        	preparedStatement.setDate(3, ngaySinhSql);
	        } else {
	        	preparedStatement.setNull(3, Types.DATE);
	        }
	        preparedStatement.setString(4, cn.getTen());
	        preparedStatement.setBoolean(5, cn.isGioiTinh()); 
	        preparedStatement.setString(6, cn.getDiaChi());
	        
	        
	        
	        // Lưu ngày tham gia dưới dạng java.sql.Date
	        if (cn.getNgayThamGia() != null) {
	            java.sql.Date ngayThamGiaSql = java.sql.Date.valueOf(cn.getNgayThamGia());
	            preparedStatement.setDate(7, ngayThamGiaSql);
	        } else {
	            preparedStatement.setNull(7, Types.DATE);
	        }
	        preparedStatement.setBoolean(8, cn.isTrangThai());
	        preparedStatement.setString(9, cn.getsDT());
	        preparedStatement.setString(10, cn.getXuong());
	        preparedStatement.setString(11, cn.getChuyenMon());
	        preparedStatement.setDouble(12, cn.getLuongPhuCap());
	       
	        int rowsInserted = preparedStatement.executeUpdate();
	        return rowsInserted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ bằng cách ghi log lỗi
	        return false;
	    }
	}
	
	
	// Phương thức Delete Nhân Viên
	public boolean deleteCongNhan(String maCongNhan) {
	    String sql = "DELETE FROM [QLLUONG].[dbo].[CongNhan] WHERE maCongNhan = ?";
	    
	    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, maCongNhan);
	        int rowsDeleted = preparedStatement.executeUpdate();
	        return rowsDeleted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ bằng cách ghi log lỗi
	        return false;
	    }
	}

	
	// Phương thức Update Nhân Viên
	public boolean updateCongNhan(CongNhan cn) {
	    String sql = "UPDATE NhanVien SET trinhDoChuyenMon = ?, ngaySinh = ?, ten = ?, gioiTinh = ?, diaChi = ?, ngayThamGia = ?, trangThai = ?, sDT = ?, xuong = ?, chuyenMon = ?, luongPhuCap = ? WHERE maCongNhan = ?";
	    
	    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	    	preparedStatement.setString(12, cn.getMaCongNhan());
	        preparedStatement.setDouble(1, cn.getTrinhDoChuyenMon()); 
	        
	        if (cn.getNgaySinh() != null) {
	        	java.sql.Date ngaySinhSql = java.sql.Date.valueOf(cn.getNgaySinh());
	        	preparedStatement.setDate(2, ngaySinhSql);
	        } else {
	        	preparedStatement.setNull(2, Types.DATE);
	        }
	        preparedStatement.setString(3, cn.getTen());
	        preparedStatement.setBoolean(4, cn.isGioiTinh()); 
	        preparedStatement.setString(5, cn.getDiaChi());
	        
	        
	        
	        // Lưu ngày tham gia dưới dạng java.sql.Date
	        if (cn.getNgayThamGia() != null) {
	            java.sql.Date ngayThamGiaSql = java.sql.Date.valueOf(cn.getNgayThamGia());
	            preparedStatement.setDate(6, ngayThamGiaSql);
	        } else {
	            preparedStatement.setNull(6, Types.DATE);
	        }
	        preparedStatement.setBoolean(7, cn.isTrangThai());
	        preparedStatement.setString(8, cn.getsDT());
	        preparedStatement.setString(9, cn.getXuong());
	        preparedStatement.setString(10, cn.getChuyenMon());
	        preparedStatement.setDouble(11, cn.getLuongPhuCap());
	       
	        int rowsInserted = preparedStatement.executeUpdate();
	        return rowsInserted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ bằng cách ghi log lỗi
	        return false;
	    }
	}

}

