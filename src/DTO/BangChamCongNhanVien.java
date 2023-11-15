package DTO;

import java.util.Date;
import java.util.Objects;

public class BangChamCongNhanVien {
	private String maChamCongNV, maNhanVien;
	private int soNgayLamViec, soNgayNghi;
	private double soGioTangCa;
	private Date ngayChamCong;
	private int coPhep;
	private NhanVien nv;

	public BangChamCongNhanVien(String maChamCongNV, String maNhanVien, int soNgayLamViec, int soNgayNghi,
			double soGioTangCa, Date ngayChamCong, int coPhep, NhanVien nv) {
		super();
		this.maChamCongNV = maChamCongNV;
		this.maNhanVien = maNhanVien;
		this.soNgayLamViec = soNgayLamViec;
		this.soNgayNghi = soNgayNghi;
		this.soGioTangCa = soGioTangCa;
		this.ngayChamCong = ngayChamCong;
		this.coPhep = coPhep;
		this.nv = nv;
	}
	

	public BangChamCongNhanVien(String maChamCongNV, String maNhanVien, int soNgayLamViec, int soNgayNghi,
			double soGioTangCa, Date ngayChamCong, int coPhep) {
		super();
		this.maChamCongNV = maChamCongNV;
		this.maNhanVien = maNhanVien;
		this.soNgayLamViec = soNgayLamViec;
		this.soNgayNghi = soNgayNghi;
		this.soGioTangCa = soGioTangCa;
		this.ngayChamCong = ngayChamCong;
		this.coPhep = coPhep;
	}


	public NhanVien getNv() {
		return nv;
	}

	public void setNv(NhanVien nv) {
		this.nv = nv;
	}

	public BangChamCongNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaChamCongNV() {
		return maChamCongNV;
	}

	public void setMaChamCongNV(String maChamCong) {
		this.maChamCongNV = maChamCong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) throws Exception {
		if (soNgayLamViec < 0) {
			throw new Exception("Số ngày làm việc >=0 ");
		} else {
			this.soNgayLamViec = soNgayLamViec;
		}
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void setSoNgayNghi(int soNgayNghi) throws Exception {
		if (soNgayNghi < 0) {
			throw new Exception("Số ngày nghỉ >=0 ");
		} else {
			this.soNgayNghi = soNgayNghi;
		}

	}

	public double getSoGioTangCa() {
		return soGioTangCa;
	}

	public void setSoGioTangCa(double soGioTangCa) throws Exception {
		if (soGioTangCa < 0) {
			throw new Exception("Số giờ tăng ca >=0 ");
		} else {
			this.soGioTangCa = soGioTangCa;
		}

	}

	public Date getNgayChamCong() {
		return ngayChamCong;
	}

	public void setNgayChamCong(Date ngayChamCong) throws Exception {

		this.ngayChamCong = ngayChamCong;

	}

	public int getCoPhep() {
		return coPhep;
	}

	public void setCoPhep(int coPhep) {
		this.coPhep = coPhep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maChamCongNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangChamCongNhanVien other = (BangChamCongNhanVien) obj;
		return Objects.equals(maChamCongNV, other.maChamCongNV);
	}

}
