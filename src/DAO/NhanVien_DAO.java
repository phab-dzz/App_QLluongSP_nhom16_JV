package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.NhanVien;

public class NhanVien_DAO {

	
	public NhanVien_DAO() {
		
	}

	//Lấy danh sách theo phòng ban
		public ArrayList<NhanVien> getDanhSachNhanVien() {
		    ArrayList<NhanVien> dsnv = new ArrayList<>();
		    String sql ="SELECT * FROM [QLLUONG].[dbo].[NhanVien]";

		    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		        

		        try (ResultSet resultSet = preparedStatement.executeQuery()) {
		            while (resultSet.next()) {
		                NhanVien nv = new NhanVien();
		                nv.setMaNhanVien(resultSet.getString("maNhanVien"));
		                nv.setTen(resultSet.getString("ten"));
		                nv.setChucDanh(resultSet.getString("chucDanh"));
		                nv.setsDT(resultSet.getString("sDT"));
		                nv.setEmail(resultSet.getString("email"));
		                nv.setPhongBan(resultSet.getString("phongBan"));
		                nv.setDiaChi(resultSet.getString("diaChi"));
		                
		             // Lấy giới tính từ cột "gioiTinh" dưới dạng boolean
		                boolean gioiTinhBit = resultSet.getBoolean("gioiTinh");
		                nv.setGioiTinh(gioiTinhBit);

		                // Lấy ngày tham gia từ cột "ngayThamGia" dưới dạng LocalDate
		                java.sql.Date ngayThamGiaSql = resultSet.getDate("ngayThamGia");
		                if (ngayThamGiaSql != null) {
		                    nv.setNgayThamGia(ngayThamGiaSql.toLocalDate());
		                }

		             // Lấy ngày tham gia từ cột "ngaySinh" dưới dạng LocalDate
		                java.sql.Date ngaySinhSql = resultSet.getDate("ngaySinh");
		                if (ngaySinhSql != null) {
		                    nv.setNgaySinh(ngaySinhSql.toLocalDate());
		                }
		                nv.setHsLuong(resultSet.getDouble("hsLuong"));
		                nv.setLuongCoBan(resultSet.getBigDecimal("luongCoBan").doubleValue());
		                nv.setLuongPhuCap(resultSet.getDouble("luongPhuCap"));
		                
		                dsnv.add(nv);
		            }
		        }
		    } catch (SQLException e) {
		        // Xử lý lỗi cụ thể thay vì chỉ ghi log
		        e.printStackTrace(); // Ghi log lỗi, bạn có thể thay thế bằng hành động xử lý lỗi cụ thể

		        // Ví dụ: Nếu trong ứng dụng GUI, bạn có thể hiển thị thông báo lỗi đến người dùng
		        // JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Lỗi truy vấn", JOptionPane.ERROR_MESSAGE);
		    }

		    return dsnv;
		}


	
	//Lấy danh sách theo phòng ban
	public ArrayList<NhanVien> getDanhSachNhanVienPhongBan(String tenPhong) {
	    ArrayList<NhanVien> dsnv = new ArrayList<>();
	    String sql = "SELECT * FROM [QLLUONG].[dbo].[NhanVien] WHERE phongBan = ?"; // Sửa câu lệnh SQL

	    try (Connection connection = ConnectDB.getInstance().connect();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        // Truyền giá trị của tham số tên phòng ban
	        preparedStatement.setString(1, tenPhong);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                NhanVien nv = new NhanVien();
	                nv.setMaNhanVien(resultSet.getString("maNhanVien"));
	                nv.setTen(resultSet.getString("ten"));
	                nv.setChucDanh(resultSet.getString("chucDanh"));
	                nv.setsDT(resultSet.getString("sDT"));
	                nv.setEmail(resultSet.getString("email"));
	                nv.setPhongBan(resultSet.getString("phongBan"));
	                nv.setDiaChi(resultSet.getString("diaChi"));
	                
	             // Lấy giới tính từ cột "gioiTinh" dưới dạng boolean
	                boolean gioiTinhBit = resultSet.getBoolean("gioiTinh");
	                nv.setGioiTinh(gioiTinhBit);

	                // Lấy ngày tham gia từ cột "ngayThamGia" dưới dạng LocalDate
	                java.sql.Date ngayThamGiaSql = resultSet.getDate("ngayThamGia");
	                if (ngayThamGiaSql != null) {
	                    nv.setNgayThamGia(ngayThamGiaSql.toLocalDate());
	                }

	             // Lấy ngày tham gia từ cột "ngaySinh" dưới dạng LocalDate
	                java.sql.Date ngaySinhSql = resultSet.getDate("ngaySinh");
	                if (ngaySinhSql != null) {
	                    nv.setNgaySinh(ngaySinhSql.toLocalDate());
	                }
	                nv.setHsLuong(resultSet.getDouble("hsLuong"));
	                nv.setLuongCoBan(resultSet.getBigDecimal("luongCoBan").doubleValue());
	                nv.setLuongPhuCap(resultSet.getDouble("luongPhuCap"));
	                
	                dsnv.add(nv);
	            }
	        }
	    } catch (SQLException e) {
	        // Xử lý lỗi cụ thể thay vì chỉ ghi log
	        e.printStackTrace(); // Ghi log lỗi, bạn có thể thay thế bằng hành động xử lý lỗi cụ thể

	        // Ví dụ: Nếu trong ứng dụng GUI, bạn có thể hiển thị thông báo lỗi đến người dùng
	        // JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Lỗi truy vấn", JOptionPane.ERROR_MESSAGE);
	    }

	    return dsnv;
	}



	
	// Phương thức Search trả về Nhân Viên
	public NhanVien getNhanVien(String maNhanVien) {
	    NhanVien nv = null;
	    String sql = "SELECT * FROM NhanVien WHERE maNhanVien = ?";
	    
	    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, maNhanVien);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            nv = new NhanVien();
	           
	            	 nv.setMaNhanVien(resultSet.getString("maNhanVien"));
	 	            nv.setTen(resultSet.getString("ten"));
	 	            nv.setChucDanh(resultSet.getString("chucDanh"));
	 	            nv.setsDT(resultSet.getString("sDT"));
	 	            nv.setEmail(resultSet.getString("email"));
	 	            nv.setPhongBan(resultSet.getString("phongBan"));
	 	            nv.setDiaChi(resultSet.getString("diaChi"));
	 	            
	 	            // Lấy giới tính từ cột "gioiTinh" dưới dạng boolean
	 	            boolean gioiTinhBit = resultSet.getBoolean("gioiTinh");
	 	            nv.setGioiTinh(gioiTinhBit);

	 	            // Lấy ngày tham gia từ cột "ngayThamGia" dưới dạng LocalDate
	 	            java.sql.Date ngayThamGiaSql = resultSet.getDate("ngayThamGia");
	 	            if (ngayThamGiaSql != null) {
	 	                nv.setNgayThamGia(ngayThamGiaSql.toLocalDate());
	 	            }
	 	            
	 	           // Lấy ngày tham gia từ cột "ngaySinh" dưới dạng LocalDate
	                java.sql.Date ngaySinhSql = resultSet.getDate("ngaySinh");
	                if (ngaySinhSql != null) {
	                    nv.setNgaySinh(ngaySinhSql.toLocalDate());
	                }
	                
	 	            nv.setHsLuong(resultSet.getDouble("hsLuong"));
	 	            nv.setLuongCoBan(resultSet.getBigDecimal("luongCoBan").doubleValue());
	 	            nv.setLuongPhuCap(resultSet.getDouble("luongPhuCap"));
				
	           
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ bằng cách ghi log lỗi
	    }
	    
	    return nv;
	}
	
	
	// Phương thức Add Nhân Viên
	public boolean addNhanVien(NhanVien nv) {
	    String sql = "INSERT INTO NhanVien (maNhanVien, luongCoBan, ngaySinh, ten, gioiTinh, diaChi, chucDanh, ngayThamGia, hsLuong, sDT, email, luongPhuCap, phongBan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, nv.getMaNhanVien());
	        preparedStatement.setDouble(2, nv.getLuongCoBan()); 
	        
	        if (nv.getNgaySinh() != null) {
	        	java.sql.Date ngaySinhSql = java.sql.Date.valueOf(nv.getNgaySinh());
	        	preparedStatement.setDate(3, ngaySinhSql);
	        } else {
	        	preparedStatement.setNull(3, Types.DATE);
	        }
	        preparedStatement.setString(4, nv.getTen());
	        preparedStatement.setBoolean(5, nv.isGioiTinh()); 
	        preparedStatement.setString(6, nv.getDiaChi());
	        
	        preparedStatement.setString(7, nv.getChucDanh());
	        
	        // Lưu ngày tham gia dưới dạng java.sql.Date
	        if (nv.getNgayThamGia() != null) {
	            java.sql.Date ngayThamGiaSql = java.sql.Date.valueOf(nv.getNgayThamGia());
	            preparedStatement.setDate(8, ngayThamGiaSql);
	        } else {
	            preparedStatement.setNull(8, Types.DATE);
	        }
	        preparedStatement.setDouble(9, nv.getHsLuong());
	        preparedStatement.setString(10, nv.getsDT());
	        preparedStatement.setString(11, nv.getEmail());
	        preparedStatement.setDouble(12, nv.getLuongPhuCap());
	        preparedStatement.setString(13, nv.getPhongBan());
	       
	        int rowsInserted = preparedStatement.executeUpdate();
	        return rowsInserted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ bằng cách ghi log lỗi
	        return false;
	    }
	}
	
	
	// Phương thức Delete Nhân Viên
	public boolean deleteNhanVien(String maNhanVien) {
	    String sql = "DELETE FROM [QLLUONG].[dbo].[NhanVien] WHERE maNhanVien = ?";
	    
	    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, maNhanVien);
	        int rowsDeleted = preparedStatement.executeUpdate();
	        return rowsDeleted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ bằng cách ghi log lỗi
	        return false;
	    }
	}

	
	// Phương thức Update Nhân Viên
	public boolean updateNhanVien(NhanVien nv) {
	    String sql = "UPDATE NhanVien SET luongCoBan = ?, ngaySinh = ?, ten = ?, gioiTinh = ?, diaChi = ?, chucDanh = ?, ngayThamGia = ?, hsLuong = ?, sDT = ?, email = ?, luongPhuCap = ?, phongBan = ? WHERE maNhanVien = ?";
	    
	    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	    	preparedStatement.setString(13, nv.getMaNhanVien());
	        preparedStatement.setDouble(1, nv.getLuongCoBan()); 
	        
	        if (nv.getNgaySinh() != null) {
	        	java.sql.Date ngaySinhSql = java.sql.Date.valueOf(nv.getNgaySinh());
	        	preparedStatement.setDate(2, ngaySinhSql);
	        } else {
	        	preparedStatement.setNull(2, Types.DATE);
	        }
	        preparedStatement.setString(3, nv.getTen());
	        preparedStatement.setBoolean(4, nv.isGioiTinh()); 
	        preparedStatement.setString(5, nv.getDiaChi());
	        
	        preparedStatement.setString(6, nv.getChucDanh());
	        
	        // Lưu ngày tham gia dưới dạng java.sql.Date
	        if (nv.getNgayThamGia() != null) {
	            java.sql.Date ngayThamGiaSql = java.sql.Date.valueOf(nv.getNgayThamGia());
	            preparedStatement.setDate(7, ngayThamGiaSql);
	        } else {
	            preparedStatement.setNull(7, Types.DATE);
	        }
	        preparedStatement.setDouble(8, nv.getHsLuong());
	        preparedStatement.setString(9, nv.getsDT());
	        preparedStatement.setString(10, nv.getEmail());
	        preparedStatement.setDouble(11, nv.getLuongPhuCap());
	        preparedStatement.setString(12, nv.getPhongBan());
	       
	        int rowsInserted = preparedStatement.executeUpdate();
	        return rowsInserted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ bằng cách ghi log lỗi
	        return false;
	    }
	}

}
