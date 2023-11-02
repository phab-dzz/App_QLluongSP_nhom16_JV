package BUS;

import java.util.ArrayList;

import DAO.BangLuongCongNhan_DAO;
import DTO.BangLuongCongNhan;

public class BangLuongCongNhan_BUS {

		private BangLuongCongNhan_DAO BangLuongCNDAO= new BangLuongCongNhan_DAO();
		private ArrayList<BangLuongCongNhan> dsBangLuongCN= null;
		public BangLuongCongNhan_BUS() {
			
		}
		public void docDanhSach() {
			this.dsBangLuongCN = BangLuongCNDAO.getALLbangluongCN();
		}

		public ArrayList<BangLuongCongNhan> getDanhSachNhanVien() {
			if (this.dsBangLuongCN == null)
				docDanhSach();
			return this.dsBangLuongCN;
		}
}
