package DTO;

import java.util.Objects;

public class TaiKhoan {
	private String maTK, matKhau;

	public TaiKhoan(String maTK, String matKhau) {
		super();
		this.maTK = maTK;
		this.matKhau = matKhau;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maTK, other.maTK);
	}

	@Override
	public String toString() {
		return "TaiKhoan [maTK=" + maTK + ", matKhau=" + matKhau + "]";
	}

	
	
}
