
package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.PhieuLuong;
import utilities.ProcessDate;

public class PhieuLuong_DAO {
//	private java.sql.Statement statement;
//
//	public ArrayList<PhieuLuong> getALLPhieuluong(){
//		ArrayList<PhieuLuong> dsPhieuLuong= new ArrayList<PhieuLuong>();
//		try {
//			ConnectDB.getInstance();
//			Connection con =ConnectDB.getConnection();
//			Statement sta = (Statement) con.createStatement();
//			
//			ResultSet rs= statement.executeQuery("select * from PhieuLuong");
//			while(rs.next()) {
//				LocalDate ngayNhanLuong = ProcessDate.date2LocalDate(rs.getDate("ngayNhanLuong"));
//				dsPhieuLuong.add(new PhieuLuong(rs.getString("maPhieuLuong"),rs.getString("maBnagLuong"),rs.getString("ten"),rs.getString("hoDem"),rs.getDouble("thucLanh"),ngayNhanLuong));
//			}
//					
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//		return dsPhieuLuong;
//	}

}
