package BUS;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.validation.Validator;

import DAO.PhanCongCongDoan_DAO;
import DAO.SanPham_DAO;
import DTO.CongNhan;
import DTO.PhanCongCongDoan;
import DTO.SanPham;
import MyCustom.MyDialog;

public class PhanCongCongDoan_BUS {
	private PhanCongCongDoan_DAO PhanCongDAO= new PhanCongCongDoan_DAO();
	private ArrayList<PhanCongCongDoan>  dsPhanCong= null;
	public ArrayList<PhanCongCongDoan> getAllPhanCongCD() {
        dsPhanCong=PhanCongDAO.getALLPhanCongCongDoan();
       return dsPhanCong;
   }
	public void docDanhSach() {
		this.dsPhanCong = PhanCongDAO.getALLPhanCongCongDoan();
	}
//   public int getCongNhanCount() {
//       ArrayList<CongNhan> dsCN = getAllCongNhan();
//       return dsCN.size();
//   }
	public boolean themPhanCongCongDoan(String maCN, String maSP, String maCD, int soLuongCongDoanPhanCong, LocalDate ngayBatDau) {
		if(!maCN.equals("")) {
			PhanCongCongDoan cd= new PhanCongCongDoan();
			cd.setMaCD(maCD);
			cd.setMaCN(maCN);
			cd.setMaSP(maSP);
			cd.setNgayBatDau(ngayBatDau);
			cd.setSoLuongCongDoanPhanCong(soLuongCongDoanPhanCong);
			boolean flag= PhanCongDAO.themPhanCongCongDoan(cd);
			if (!flag) {
				new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
			} else {
				new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
			}
			return flag;
			}
			else
				return false;
		}
	public boolean xoaPhanCongCongDoan(String maCN) {
		if(!maCN.equals("")) {
			boolean flag=PhanCongDAO.xoaPhanCongCD(maCN);
			
			if (!flag) {
				new MyDialog("Xóa thất bại!", MyDialog.ERROR_DIALOG);
			} else {
				new MyDialog("Xóa thành công!", MyDialog.SUCCESS_DIALOG);
			}
			return flag;
			}
			else
				return false;
	}
	public boolean updateCongDoan(PhanCongCongDoan cd) {
		if(!cd.getMaCN().equals("")) {
			boolean flag= PhanCongDAO.updateCD(cd);
			if (!flag) {
				new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
			} else {
				new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
			}
			return flag;
			}
			else
				return false;
		
	}
}
	
	


