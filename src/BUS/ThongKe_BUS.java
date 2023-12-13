package BUS;

import java.util.ArrayList;

import DAO.ThongKe_DAO;
import DTO.BangLuongCongNhan;
import DTO.Thongke;
import DTO.tkluong_nam;

public class ThongKe_BUS {
	private ThongKe_DAO tkDAO = new ThongKe_DAO();

	public Thongke thongke() {
		return tkDAO.getThongKe();
	}

	public ArrayList<BangLuongCongNhan> getALLblcnAVG() {
		ArrayList<BangLuongCongNhan> dCN = new ArrayList<>();
		dCN = tkDAO.getallBangluongCNavg();
		return dCN;
	}

	public ArrayList<BangLuongCongNhan> getCNnam(String nam) {
		return tkDAO.getalltheonam(nam);
	}

	public ArrayList<BangLuongCongNhan> getCNthang(String thang) {
		return tkDAO.getalltheothang(thang);
	}

	public ArrayList<tkluong_nam> gettkNam() {
		return tkDAO.getalltkluongnam();
	}
}
