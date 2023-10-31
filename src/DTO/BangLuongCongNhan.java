package DTO;

import java.util.Objects;

public class BangLuongCongNhan {
	private String maBangLuong;
	private double luongThang, phuCap, tienThuong, baoHiemXH, thucLanh;
	public BangLuongCongNhan(String maBangLuong, double luongThang, double phuCap, double tienThuong, double baoHiemXH,
			double thucLanh) {
		super();
		this.maBangLuong = maBangLuong;
		this.luongThang = luongThang;
		this.phuCap = phuCap;
		this.tienThuong = tienThuong;
		this.baoHiemXH = baoHiemXH;
		this.thucLanh = thucLanh;
	}
	
	public BangLuongCongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaBangLuong() {
		return maBangLuong;
	}
	public void setMaBangLuong(String maBangLuong) {
		this.maBangLuong = maBangLuong;
	}
	public double getLuongThang() {
		return luongThang;
	}
	public void setLuongThang(double luongThang) throws Exception {
		if(luongThang<=0) {
			throw new Exception("Lương tháng >0 ");
		}else {
			this.luongThang = luongThang;
		}
		
	}
	public double getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(double phuCap) throws Exception {
		if(phuCap<=0) {
			throw new Exception("Lương phụ cấp >0 ");
		}else {
			this.phuCap = phuCap;
		}
	}
	public double getTienThuong() {
		return tienThuong;
	}
	public void setTienThuong(double tienThuong) throws Exception {
		if(tienThuong<=0) {
			throw new Exception("Tiền thưởng >0 ");
		}else {
			this.tienThuong = tienThuong;
		}
		
	}
	public double getBaoHiemXH() {
		return baoHiemXH;
	}
	public void setBaoHiemXH(double baoHiemXH) throws Exception {
		if(baoHiemXH<=0) {
			throw new Exception("Bảo hiểm xã hội >0 ");
		}else {
			this.baoHiemXH = baoHiemXH;
		}
	}
	public double getThucLanh() {
		return thucLanh;
	}
	public void setThucLanh(double thucLanh) throws Exception {
		if(thucLanh<=0) {
			throw new Exception("Lương thực lãnh >0 ");
		}else {
			this.thucLanh = thucLanh;
		}
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(maBangLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangLuongCongNhan other = (BangLuongCongNhan) obj;
		return Objects.equals(maBangLuong, other.maBangLuong);
	}

	@Override
	public String toString() {
		return "BangLuongCongNhan [maBangLuong=" + maBangLuong + ", luongThang=" + luongThang + ", phuCap=" + phuCap
				+ ", tienThuong=" + tienThuong + ", baoHiemXH=" + baoHiemXH + ", thucLanh=" + thucLanh + "]";
	}
	
}
