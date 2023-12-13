package BUS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import DAO.BangChamCongNhanVien_DAO;
import DTO.BangChamCongNhanVien;

public class BangChamCongNhanVien_BUS {
	private BangChamCongNhanVien_DAO BangCCNVDAO = new BangChamCongNhanVien_DAO();
	private ArrayList<BangChamCongNhanVien> dsBangCCNV = null;

	public BangChamCongNhanVien_BUS() {

	}

	public void docDanhSach() {
		this.dsBangCCNV = BangCCNVDAO.getAllBangChamCongNhanVien();
	}

	public ArrayList<BangChamCongNhanVien> getDanhSachNhanVien() {
		if (this.dsBangCCNV == null)
			docDanhSach();
		return this.dsBangCCNV;
	}

	public BangChamCongNhanVien timNhanVienTheoMa(String maNhanVien) {
		docDanhSach(); // Đọc danh sách nếu chưa được đọc

		// Duyệt danh sách nhân viên và trả về nhân viên nếu tìm thấy mã số khớp (không
		// phân biệt khoảng trắng)
		for (BangChamCongNhanVien nhanVien : this.dsBangCCNV) {
			if (nhanVien.getMaNhanVien().trim().equalsIgnoreCase(maNhanVien.trim())) {
				return nhanVien;
			}
		}

		// Nếu không tìm thấy nhân viên, trả về null hoặc xử lý tùy theo yêu cầu của bạn
		return null;
	}

	public ArrayList<BangChamCongNhanVien> getDanhSachNhanVienTheoNgayChamCong(Date selectedDate,
			ArrayList<BangChamCongNhanVien> dsnv, String str2) {
		docDanhSach(); // Đọc danh sách nếu chưa được đọc

		ArrayList<BangChamCongNhanVien> danhSachTheoNgay = new ArrayList<>();

		// Lấy tháng từ ngày chấm công được chọn
		Calendar calChamCong = Calendar.getInstance();
		calChamCong.setTime(selectedDate);
		int thangChamCong = calChamCong.get(Calendar.MONTH) + 1; // Tháng trong Java bắt đầu từ 0

		// Duyệt danh sách nhân viên và thêm vào danhSachTheoNgay nếu tháng chấm công
		// trùng với tháng được chọn
		for (BangChamCongNhanVien nhanVien : dsnv) {
			// Lấy tháng từ NgayChamCong
			Calendar calNhanVien = Calendar.getInstance();
			calNhanVien.setTime(nhanVien.getNgayChamCong());
			int thangNhanVien = calNhanVien.get(Calendar.MONTH) + 1; // Tháng trong Java bắt đầu từ 0

			// So sánh tháng chấm công của nhân viên với tháng được chọn
			if (thangNhanVien == thangChamCong && nhanVien.getNv().getPhongBan().equals(str2)) {
				danhSachTheoNgay.add(nhanVien);
			}
		}

		return danhSachTheoNgay;
	}

	/**
	 * Filter employee attendance data based on the selected month and year.
	 * 
	 * @param selectedMonth The selected month from the combo box.
	 * @param selectedYear  The selected year from the combo box.
	 */
	public ArrayList<BangChamCongNhanVien> filterDataByMonthAndYear(ArrayList<BangChamCongNhanVien> dsnv,
			String selectedMonth, String selectedYear) {
		ArrayList<BangChamCongNhanVien> filteredList = new ArrayList<>();
		if (selectedMonth != null && selectedYear != null) {
			int selectedMonthInt = Integer.parseInt(selectedMonth); // Convert selected month to int
			int selectedYearInt = Integer.parseInt(selectedYear); // Convert selected year to int

			// Assuming that each employee attendance record has a field for the month and
			// year as int
			for (BangChamCongNhanVien record : dsnv) {
				// Lấy tháng và năm từ NgayChamCong
				Calendar calRecord = Calendar.getInstance();
				calRecord.setTime(record.getNgayChamCong());
				int thangRecord = calRecord.get(Calendar.MONTH) + 1; // Tháng trong Java bắt đầu từ 0
				int namRecord = calRecord.get(Calendar.YEAR);

				// So sánh tháng và năm chấm công của nhân viên với tháng và năm được chọn
				if (thangRecord == selectedMonthInt && namRecord == selectedYearInt) {
					filteredList.add(record);
				}
			}

		}
		return filteredList;
	}

	public ArrayList<BangChamCongNhanVien> luuVaoMang(DefaultTableModel modelNv, Date ngayChamCong) {
		int rowCount = modelNv.getRowCount();
		ArrayList<BangChamCongNhanVien> listBangChamCong = new ArrayList<>();

		for (int i = 0; i < rowCount; i++) {
			// ... (Các dòng mã lấy giá trị từ các cột)

			// Chuyển đổi giá trị từ cột "Có mặt" và "Có/Không phép" thành 1 và 0
			boolean coMat = (boolean) modelNv.getValueAt(i, 3); // Giả sử cột thứ tư là cột "Có mặt"
			boolean coPhepValue = (boolean) modelNv.getValueAt(i, 5); // Giả sử cột thứ sáu là cột "Có/Không phép"

			// Chuyển đổi giá trị true thành 1 và false thành 0
			int soNgayLamViec = coMat ? 1 : 0;
			int coPhep = coPhepValue ? 1 : 0;
			int soNgayNghi = coMat ? 0 : 1;

			Date ngayCC = ngayChamCong;
			String maChamCongNV = (String) modelNv.getValueAt(i, 0); // Giả sử cột đầu tiên chứa mã chấm công
			String maNhanVien = (String) modelNv.getValueAt(i, 1); // Giả sử cột thứ hai chứa mã nhân viên
			// Giả sử cột thứ tư chứa số ngày nghỉ
			double soGioTangCa = (double) modelNv.getValueAt(i, 4); // Giả sử cột thứ năm chứa số giờ tăng ca
			// Tạo đối tượng BangChamCongNhanVien và thêm vào danh sách
			BangChamCongNhanVien bangChamCong = new BangChamCongNhanVien(maChamCongNV, maNhanVien, soNgayLamViec,
					soNgayNghi, soGioTangCa, ngayCC, coPhep, null);
			listBangChamCong.add(bangChamCong);

		}
		return listBangChamCong;

	}

	public ArrayList<BangChamCongNhanVien> luuVaoMangChuNhat(DefaultTableModel modelNv, Date ngayChamCong) {
		int rowCount = modelNv.getRowCount();
		ArrayList<BangChamCongNhanVien> listBangChamCong = new ArrayList<>();

		for (int i = 0; i < rowCount; i++) {
			// ... (Các dòng mã lấy giá trị từ các cột)

			// Chuyển đổi giá trị từ cột "Có mặt" và "Có/Không phép" thành 1 và 0
			boolean coMat = (boolean) modelNv.getValueAt(i, 3); // Giả sử cột thứ tư là cột "Có mặt"
			boolean coPhepValue = (boolean) modelNv.getValueAt(i, 5); // Giả sử cột thứ sáu là cột "Có/Không phép"

			// Chuyển đổi giá trị true thành 1 và false thành 0
			int soNgayLamViec = coMat ? 1 : 0;
			int coPhep = coPhepValue ? 1 : 0;
			int soNgayNghi = coMat ? 0 : 1;

			Date ngayCC = ngayChamCong;
			String maChamCongNV = (String) modelNv.getValueAt(i, 0); // Giả sử cột đầu tiên chứa mã chấm công
			String maNhanVien = (String) modelNv.getValueAt(i, 1); // Giả sử cột thứ hai chứa mã nhân viên
			// Giả sử cột thứ tư chứa số ngày nghỉ
			double soGioTangCa = (double) modelNv.getValueAt(i, 4); // Giả sử cột thứ năm chứa số giờ tăng ca
			// Tạo đối tượng BangChamCongNhanVien và thêm vào danh sách
			BangChamCongNhanVien bangChamCong = new BangChamCongNhanVien(maChamCongNV, maNhanVien, 0, 0, soGioTangCa,
					ngayCC, 0, null);
			listBangChamCong.add(bangChamCong);

		}
		return listBangChamCong;

	}

}
