package DTO;

public class tkluong_nam {
	private int nam, thang;
	private double tong_luong;
	private int soluong;
	public tkluong_nam(int nam, int thang, double tong_luong, int soluong) {
		super();
		this.nam = nam;
		this.thang = thang;
		this.tong_luong = tong_luong;
		this.soluong = soluong;
	}
	public tkluong_nam() {
		super();
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public double getTong_luong() {
		return tong_luong;
	}
	public void setTong_luong(double tong_luong) {
		this.tong_luong = tong_luong;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public String toString() {
		return "tkluong_nam [nam=" + nam + ", thang=" + thang + ", tong_luong=" + tong_luong + ", soluong=" + soluong
				+ "]";
	}

	
	
	
}
