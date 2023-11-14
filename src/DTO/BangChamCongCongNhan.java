package DTO;

import java.time.LocalDate;
import java.util.Objects;

public class BangChamCongCongNhan {
	private String maChamCongCN, maCongNhan;
	private int soNgayLamViec, soNgayNghi, soLuongSanPham;
	private double soGioTangCa;
	private LocalDate ngayChamCong; 
	private int coPhep;
	public BangChamCongCongNhan(String maChamCongCN, String maCongNhan, int soNgayLamViec, int soNgayNghi,
			int soLuongSanPham, double soGioTangCa, LocalDate ngayChamCong, int coPhep) {
		super();
		this.maChamCongCN = maChamCongCN;
		this.maCongNhan = maCongNhan;
		this.soNgayLamViec = soNgayLamViec;
		this.soNgayNghi = soNgayNghi;
		this.soLuongSanPham = soLuongSanPham;
		this.soGioTangCa = soGioTangCa;
		this.ngayChamCong = ngayChamCong;
		this.coPhep = coPhep;
	}
	public BangChamCongCongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaChamCongCN() {
		return maChamCongCN;
	}
	public void setMaChamCongCN(String maChamCongCN) {
		this.maChamCongCN = maChamCongCN;
	}
	public String getMaCongNhan() {
		return maCongNhan;
	}
	public void setMaCongNhan(String maCongNhan) {
		this.maCongNhan = maCongNhan;
	}
	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}
	public void setSoNgayLamViec(int soNgayLamViec) throws Exception {
		if(soNgayLamViec<0) {
			throw new Exception("Số ngày làm việc >=0 ");
		}else {
			this.soNgayLamViec = soNgayLamViec;
		}
	}
	public int getSoNgayNghi() {
		return soNgayNghi;
	}
	public void setSoNgayNghi(int soNgayNghi) throws Exception {
		if(soNgayNghi<0) {
			throw new Exception("Số ngày nghỉ >=0 ");
		}else {
			this.soNgayNghi = soNgayNghi;
		}
		
	}
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) throws Exception {
		if(soLuongSanPham<0) {
			throw new Exception("Số lượng sản phẩm >=0 ");
		}else {
			this.soLuongSanPham = soLuongSanPham;
		}
		
	}
	public double getSoGioTangCa() {
		return soGioTangCa;
	}
	public void setSoGioTangCa(double soGioTangCa) throws Exception {
		if(soGioTangCa<0) {
			throw new Exception("Số giờ tăng ca >=0 ");
		}else {
			this.soGioTangCa = soGioTangCa;
		}
		
	}
	public LocalDate getNgayChamCong() {
		return ngayChamCong;
	}
	public void setNgayChamCong(LocalDate ngayChamCong) throws Exception {
		if(ngayChamCong.isAfter(LocalDate.now())) {
			throw new Exception("Ngày chấm công phải trước ngày hiện tại");
		}else {
			this.ngayChamCong = ngayChamCong;
		}
		
	}

	public int getCoPhep() {
		return coPhep;
	}
	public void setCoPhep(int coPhep) {
		this.coPhep = coPhep;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maChamCongCN);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangChamCongCongNhan other = (BangChamCongCongNhan) obj;
		return Objects.equals(maChamCongCN, other.maChamCongCN);
	}
	@Override
	public String toString() {
		return "BangChamCongCongNhan [maChamCongCN=" + maChamCongCN + ", maCongNhan=" + maCongNhan + ", soNgayLamViec="
				+ soNgayLamViec + ", soNgayNghi=" + soNgayNghi + ", soLuongSanPham=" + soLuongSanPham + ", soGioTangCa="
				+ soGioTangCa + ", ngayChamCong=" + ngayChamCong + ", coPhep=" + coPhep + "]";
	}
	
}
