package DTO;

import java.time.LocalDate;
import java.util.Objects;

public class BangLuongNhanVien {
	private String maBangLuong;
	private double luongThang, phuCap, tienThuong, baoHiemXH, thucLanh, luongCoBan;
	private LocalDate ngaytinh ;
	private NhanVien nv;
	
	public BangLuongNhanVien(String maBangLuong, double luongThang, double phuCap, double tienThuong, double baoHiemXH,
			double thucLanh, double luongCoBan, LocalDate ngaytinh, NhanVien nv) {
		super();
		this.maBangLuong = maBangLuong;
		this.luongThang = luongThang;
		this.phuCap = phuCap;
		this.tienThuong = tienThuong;
		this.baoHiemXH = baoHiemXH;
		this.thucLanh = thucLanh;
		this.luongCoBan = luongCoBan;
		this.ngaytinh = ngaytinh;
		this.nv = nv;
	}
	
	public NhanVien getNv() {
		return nv;
	}

	public void setNv(NhanVien nv) {
		this.nv = nv;
	}

	public LocalDate getNgaytinh() {
		return ngaytinh;
	}
	public void setNgaytinh(LocalDate ngaytinh) {
		this.ngaytinh = ngaytinh;
	}
	
// TODO Auto-generated constructor stub
	
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
	public double getLuongCoBan() {
		return luongCoBan;
	}
	public void setLuongCoBan(double luongCoBan) throws Exception {
		if(luongCoBan<=0) {
			throw new Exception("Lương cơ bản >0 ");
		}else {
			this.luongCoBan = luongCoBan;
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
		BangLuongNhanVien other = (BangLuongNhanVien) obj;
		return Objects.equals(maBangLuong, other.maBangLuong);
	}
	
	
}
