package BUS;

import DAO.BangChamCongCongNhan_DAO;

public class BangChamCongCongNhan_BUS {
	private BangChamCongCongNhan_DAO BangChamCongCNDAO= new BangChamCongCongNhan_DAO();
	private ArrayList<BangChamCong> dsBangCCCN=null;
	public BangChamCongCongNhan_BUS() {
		// TODO Auto-generated constructor stub
	
		// TODO Auto-generated constructor stub
	 
		docDanhSach();
	}

	public void docDanhSach() {
		this.dsBangCCCN = BangChamCongCNDAO.getClass();
	}

	public ArrayList<NhanVien> getDanhSachNhanVien() {
		if (this.dsNhanVien == null)
			docDanhSach();
		return this.dsNhanVien;
	}

}
