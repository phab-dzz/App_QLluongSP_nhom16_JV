package DTO;

import java.util.Date;
import java.util.Objects;

public class BangChamCongCongNhan {
	private String maChamCongCN, maCongNhan;
	private int soNgayLamViec, soNgayNghi, soLuongSanPham;
	private int soSPGioTangCa;
	private Date ngayChamCong;
	private int coPhep;
	private CongNhan cn;
	private PhanCongCongDoan pc;
	private CongDoanSanPham cd;
	private SanPham sp;

	public BangChamCongCongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public BangChamCongCongNhan(String maChamCongCN, String maCongNhan, int soNgayLamViec, int soNgayNghi,
			int soLuongSanPham, int soSPGioTangCa, Date ngayChamCong, int coPhep) {
		super();
		this.maChamCongCN = maChamCongCN;
		this.maCongNhan = maCongNhan;
		this.soNgayLamViec = soNgayLamViec;
		this.soNgayNghi = soNgayNghi;
		this.soLuongSanPham = soLuongSanPham;
		this.soSPGioTangCa = soSPGioTangCa;
		this.ngayChamCong = ngayChamCong;
		this.coPhep = coPhep;
	}



	public BangChamCongCongNhan(String maChamCongCN, String maCongNhan, int soNgayLamViec, int soNgayNghi,
			int soLuongSanPham, int soSPGioTangCa, Date ngayChamCong, int coPhep, CongNhan cn, PhanCongCongDoan pc,
			CongDoanSanPham cd, SanPham sp) {
		super();
		this.maChamCongCN = maChamCongCN;
		this.maCongNhan = maCongNhan;
		this.soNgayLamViec = soNgayLamViec;
		this.soNgayNghi = soNgayNghi;
		this.soLuongSanPham = soLuongSanPham;
		this.soSPGioTangCa = soSPGioTangCa;
		this.ngayChamCong = ngayChamCong;
		this.coPhep = coPhep;
		this.cn = cn;
		this.pc = pc;
		this.cd = cd;
		this.sp = sp;
	}

	public SanPham getSp() {
		return sp;
	}

	public void setSp(SanPham sp) {
		this.sp = sp;
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

	public int getSoSPGioTangCa() {
		return soSPGioTangCa;
	}

	public void setSoSPGioTangCa(int soSPGioTangCa) {
		this.soSPGioTangCa = soSPGioTangCa;
	}

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}

	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}

	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}

	public Date getNgayChamCong() {
		return ngayChamCong;
	}

	public void setNgayChamCong(Date ngayChamCong) {
		this.ngayChamCong = ngayChamCong;
	}

	public int getCoPhep() {
		return coPhep;
	}

	public void setCoPhep(int coPhep) {
		this.coPhep = coPhep;
	}

	public CongNhan getCn() {
		return cn;
	}

	public void setCn(CongNhan cn) {
		this.cn = cn;
	}

	public PhanCongCongDoan getPc() {
		return pc;
	}

	public void setPc(PhanCongCongDoan pc) {
		this.pc = pc;
	}

	public CongDoanSanPham getCd() {
		return cd;
	}

	public void setCd(CongDoanSanPham cd) {
		this.cd = cd;
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

}
