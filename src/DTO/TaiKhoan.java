package DTO;

public class TaiKhoan {
	private String tenTaiKhoan, matKhau;

	public TaiKhoan(String tenTaiKhoan, String matKhau) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) throws Exception {
		if(tenTaiKhoan == null || tenTaiKhoan.trim().isEmpty()) {
			throw new Exception("Tên tài khoản không được để trống");
		}else {
			this.tenTaiKhoan = tenTaiKhoan;
		}
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) throws Exception {
		if(matKhau == null || matKhau.trim().isEmpty()) {
			throw new Exception("Mật khẩu không được để trống");
		}else {
			this.matKhau = matKhau;
		}
		
	}
	
	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + "]";
	}
	
}
