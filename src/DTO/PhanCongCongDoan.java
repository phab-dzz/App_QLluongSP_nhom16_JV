package DTO;

import java.util.ArrayList;

public class PhanCongCongDoan {
	private int soLuongCongDoanPhanCong;
	private ArrayList<CongNhan> danhSachCongNhan;
	public PhanCongCongDoan() {
		super();
		this.soLuongCongDoanPhanCong = soLuongCongDoanPhanCong;
		this.danhSachCongNhan = new ArrayList<CongNhan>();
	}
	public int getSoLuongCongDoanPhanCong() {
		return soLuongCongDoanPhanCong;
	}
	public void setSoLuongCongDoanPhanCong(int soLuongCongDoanPhanCong) throws Exception {
		if(soLuongCongDoanPhanCong<=0) {
			throw new Exception("Đơn giá >0 ");
		}else {
			this.soLuongCongDoanPhanCong = soLuongCongDoanPhanCong;
		}
		
	}
	public ArrayList<CongNhan> getDanhSachCongNhan() {
		return danhSachCongNhan;
	}
	public void setDanhSachCongNhan(ArrayList<CongNhan> danhSachCongNhan) {
		this.danhSachCongNhan = danhSachCongNhan;
	}
	
}
