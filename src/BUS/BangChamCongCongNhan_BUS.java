package BUS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.BangChamCongCongNhan_DAO;
import DTO.BangChamCongCongNhan;
import DTO.PhanCongCongDoan;

public class BangChamCongCongNhan_BUS {
	private BangChamCongCongNhan_DAO BangCCCNDAO = new BangChamCongCongNhan_DAO();
	private ArrayList<BangChamCongCongNhan> dsBangCCCN = null;

	public BangChamCongCongNhan_BUS() {

	}

	public void docDanhSach() throws Exception {
		this.dsBangCCCN = BangCCCNDAO.getAllBangChamCongCongNhan();
	}

	public ArrayList<BangChamCongCongNhan> getDanhSachCongNhan() throws Exception {
		if (this.dsBangCCCN == null)
			docDanhSach();
		return this.dsBangCCCN;
	}

	public BangChamCongCongNhan timCongNhanTheoMa(String maCongNhan) throws Exception {
		docDanhSach(); // Đọc danh sách nếu chưa được đọc

		// Duyệt danh sách nhân viên và trả về nhân viên nếu tìm thấy mã số khớp (không
		// phân biệt khoảng trắng)
		for (BangChamCongCongNhan congNhan : this.dsBangCCCN) {
			if (congNhan.getMaCongNhan().trim().equalsIgnoreCase(maCongNhan.trim())) {
				return congNhan;
			}
		}

		// Nếu không tìm thấy nhân viên, trả về null hoặc xử lý tùy theo yêu cầu của bạn
		return null;
	}

	public BangChamCongCongNhan timCongNhanTheoMaBCC(String maBCC) throws Exception {
		docDanhSach(); // Đọc danh sách nếu chưa được đọc

		// Duyệt danh sách nhân viên và trả về nhân viên nếu tìm thấy mã số khớp (không
		// phân biệt khoảng trắng)
		for (BangChamCongCongNhan bcc : this.dsBangCCCN) {
			if (bcc.getMaChamCongCN().trim().equalsIgnoreCase(maBCC.trim())) {
				return bcc;
			}
		}

		// Nếu không tìm thấy nhân viên, trả về null hoặc xử lý tùy theo yêu cầu của bạn
		return null;
	}

	public ArrayList<BangChamCongCongNhan> getDanhSachCongNhanTheoNgayChamCong(Date selectedDate,
			ArrayList<BangChamCongCongNhan> dsnv, String str1) throws Exception {
		docDanhSach(); // Đọc danh sách nếu chưa được đọc

		ArrayList<BangChamCongCongNhan> danhSachTheoNgay = new ArrayList<>();

		// Lấy tháng từ ngày chấm công được chọn
		Calendar calChamCong = Calendar.getInstance();
		calChamCong.setTime(selectedDate);
		int thangChamCong = calChamCong.get(Calendar.MONTH) + 1; // Tháng trong Java bắt đầu từ 0

		// Duyệt danh sách nhân viên và thêm vào danhSachTheoNgay nếu tháng chấm công
		// trùng với tháng được chọn
		for (BangChamCongCongNhan CongNhan : dsnv) {
			// Lấy tháng từ NgayChamCong
			Calendar calCongNhan = Calendar.getInstance();
			calCongNhan.setTime(CongNhan.getNgayChamCong());
			int thangCongNhan = calCongNhan.get(Calendar.MONTH) + 1; // Tháng trong Java bắt đầu từ 0

			// So sánh tháng chấm công của nhân viên với tháng được chọ
			if (thangCongNhan == thangChamCong && CongNhan.getCn().getXuong().equals(str1)) {
				danhSachTheoNgay.add(CongNhan);
			}
		}

		return danhSachTheoNgay;
	}

	public ArrayList<BangChamCongCongNhan> locTheoMaXuong(String maXuong, ArrayList<BangChamCongCongNhan> ds,
			String str1, String str2) {
		ArrayList<BangChamCongCongNhan> danhSachLoc = new ArrayList<>();
		if (!maXuong.equals("None")) {
			for (BangChamCongCongNhan cn : ds) {
				if (cn.getCn().getXuong().equals(maXuong)) {
					danhSachLoc.add(cn);
				}
			}
		} else {
			danhSachLoc.addAll(ds);
		}
		return danhSachLoc;
	}

	public boolean validateSoSP(JTextField txt_soSP, JTextField textField_soluongCL) {
		try {
			int soSP = Integer.parseInt(txt_soSP.getText());
			int soLuongCL = Integer.parseInt(textField_soluongCL.getText());

			if (soSP > soLuongCL) {
				JOptionPane.showMessageDialog(null, "Số sản phẩm công nhân làm phải ít hơn số sản phẩm còn lại");
				// You might want to reset the values or take appropriate action
				txt_soSP.setText("");
				return false; // Validation failed
			} else {
				return true; // Validation successful
			}
		} catch (NumberFormatException ex) {
			// Handle the case where the input is not a valid integer
			JOptionPane.showMessageDialog(null, "Đâu vao không hợp lệ. Vui lòng nhập một số hợp lệ.");
			// You might want to reset the values or take appropriate action
			txt_soSP.setText("");
			return false; // Validation failed
		}
	}

	public ArrayList<BangChamCongCongNhan> luuVaoMangCn(DefaultTableModel modelCn , Date ngayChamCong) {
		int rowCount = modelCn.getRowCount();
		ArrayList<BangChamCongCongNhan> listBangChamCongCn = new ArrayList<>();

		for (int i = 0; i < rowCount; i++) {
			// Lấy giá trị từ các cột của bảng công nhân
			String maChamCongCN = (String) modelCn.getValueAt(i, 0); // Giả sử cột đầu tiên chứa mã chấm công
			String maCongNhan = (String) modelCn.getValueAt(i, 1); // Giả sử cột thứ hai chứa mã công nhân
			String hoTen = (String) modelCn.getValueAt(i, 2); // Giả sử cột thứ ba chứa họ và tên
			boolean coMat = (boolean) modelCn.getValueAt(i, 3); // Giả sử cột thứ tư là cột "Có mặt"
			int soHangTangCa = (int) modelCn.getValueAt(i, 4); // Giả sử cột thứ năm chứa số hàng tăng ca
			boolean coPhepValue = (boolean) modelCn.getValueAt(i, 5); // Giả sử cột thứ sáu là cột "Có/Không phép"
			int soLuong = (int) modelCn.getValueAt(i, 6); // Giả sử cột thứ bảy chứa số lượng
			int soLuongConLai = (int) modelCn.getValueAt(i, 7); // Giả sử cột thứ tám chứa số lượng còn lại
			String xuong = (String) modelCn.getValueAt(i, 8); // Giả sử cột thứ chín chứa thông tin xưởng
			Date ngayCCCN = ngayChamCong;
			// Chuyển đổi giá trị true thành 1 và false thành 0
			int soNgayLamViec = coMat ? 1 : 0;
			int coPhep = coPhepValue ? 1 : 0;
			int soNgayNghi = coMat ? 0 : 1;
			PhanCongCongDoan pc = new PhanCongCongDoan();
			pc.setMaCN(maCongNhan);
			pc.setSoLuongCongDoanPhanCong(soLuongConLai);

			// Tạo đối tượng BangChamCongCongNhan và thêm vào danh sách
			BangChamCongCongNhan bangChamCongCn = new BangChamCongCongNhan(maChamCongCN, maCongNhan, soNgayLamViec,
					soNgayNghi, soLuong, soHangTangCa, ngayCCCN, coPhep, null, pc, null, null);
			listBangChamCongCn.add(bangChamCongCn);

		}

		return listBangChamCongCn;
	}

	public ArrayList<BangChamCongCongNhan> filterDataByMonthAndYear(ArrayList<BangChamCongCongNhan> dscn,
			String selectedMonth, String selectedYear) {
		ArrayList<BangChamCongCongNhan> filteredList = new ArrayList<>();
		if (selectedMonth != null && selectedYear != null) {
			int selectedMonthInt = Integer.parseInt(selectedMonth); // Convert selected month to int
			int selectedYearInt = Integer.parseInt(selectedYear); // Convert selected year to int

			// Assuming that each employee attendance record has a field for the month and
			// year as int
			for (BangChamCongCongNhan record : dscn) {
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

}
