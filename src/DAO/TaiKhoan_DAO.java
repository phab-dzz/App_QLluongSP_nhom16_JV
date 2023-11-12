package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.TaiKhoan;

public class TaiKhoan_DAO {

	public TaiKhoan_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan getTaiKhoan(String maTK) {
	    TaiKhoan tk = null;
	    String sql = "SELECT * FROM [QLLUONG].[dbo].[TaiKhoan] WHERE maTK = ?";
	    
	    try (Connection connection = ConnectDB.getInstance().connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, maTK);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            tk = new TaiKhoan();
	            tk.setMaTK(resultSet.getString("maTK"));
                tk.setMatKhau(resultSet.getString("matKhau"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ bằng cách ghi log lỗi
	    }
	    
	    return tk;
	}
}
