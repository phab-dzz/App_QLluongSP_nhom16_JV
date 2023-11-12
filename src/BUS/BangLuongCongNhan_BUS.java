package BUS;

import java.util.ArrayList;

import DAO.BangLuongCongNhan_DAO;
import DTO.BangLuongCongNhan;
import DTO.BangLuongNhanVien;

public class BangLuongCongNhan_BUS {

		private BangLuongCongNhan_DAO BangLuongCNDAO= new BangLuongCongNhan_DAO();
		private ArrayList<BangLuongCongNhan> dsBangLuongCN= null;
	
		public void docDanhSach() {
			this.dsBangLuongCN = BangLuongCNDAO.getALLbangluongCN();
		}

		public ArrayList<BangLuongCongNhan> getDanhSachNhanVien() {
		dsBangLuongCN= BangLuongCNDAO.getALLbangluongCN();
			return this.dsBangLuongCN;
		}
		public ArrayList<BangLuongCongNhan> timBangLuongCN(String ma){
			ArrayList<BangLuongCongNhan> dsCN=BangLuongCNDAO.getallbangLuongCNTK(ma);
			return dsCN;
		}
		public ArrayList<BangLuongCongNhan> getCNnam(String nam){
			return BangLuongCNDAO.getalltheonam(nam);
		}
		public ArrayList<BangLuongCongNhan> getCNthang(String thang){
			return BangLuongCNDAO.getalltheothang(thang);
		}
}
