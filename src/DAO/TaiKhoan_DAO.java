package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.TaiKhoan;

public class TaiKhoan_DAO {
	public ArrayList<TaiKhoan> getALLTaiKhoan(){
		ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
		try{
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from TaiKhoan";
			Statement statement= (Statement) con.createStatement();
			ResultSet rs=((java.sql.Statement) statement).executeQuery(sql);
			while(rs.next()) {
				dsTaiKhoan.add(new TaiKhoan(rs.getString("maTK"),rs.getString("matKhau")));
				
			}
	
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return dsTaiKhoan;
	}

}
