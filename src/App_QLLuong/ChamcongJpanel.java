package App_QLLuong;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import Dangnhap.Dangnhap;
import com.toedter.calendar.JDateChooser;

import BUS.BangChamCongCongNhan_BUS;
import BUS.BangChamCongNhanVien_BUS;
import CustomGUi.ChamCongCongNhanDialog;
import CustomGUi.ChamCongNhanVienDialog;
import CustomGUi.ScrollBarCustom;
import DAO.BangChamCongCongNhan_DAO;
import DAO.BangChamCongNhanVien_DAO;
import DTO.BangChamCongCongNhan;
import DTO.BangChamCongNhanVien;

public class ChamcongJpanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField_MaCN;
	private JTextField txt_CongDoan;
	private JTextField txt_soSP;
	private JTextField textField_soluongCL;
	private JTable tableCN;
	private JTextField textField_4;
	private JTextField textField_timkiemNV;
	private JComboBox comboBox_MaXuongLoc;
	private JButton btnTatCaCoMat;
	private JButton btnTatCaVangMat;
	private JButton btnLuu;
	private JButton btnThemCN;
	private JButton btnLuuCN;
	JDateChooser dateChooser;
	JDateChooser dateChooser_NgayChamCongCN;
	String str1, str2;
	BangChamCongNhanVien_BUS bangChamCongNhanVienBUS;
	private DefaultTableModel modelNv = new DefaultTableModel(null,
			new String[] { "Mã CC", "M\u00E3 NV", "H\u1ECD v\u00E0 t\u00EAn", "C\u00F3 m\u1EB7t",
					"S\u1ED1 gi\u1EDD t\u0103ng ca", "C\u00F3/Kh\u00F4ng ph\u00E9p", "Ghi ch\u00FA" }) {
		Class[] columnTypes = new Class[] { String.class, String.class, String.class, Boolean.class, Double.class,
				Boolean.class, String.class };

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	};

	private DefaultTableModel modelCn = new DefaultTableModel(null, new String[] { "Mã CC", "Mã CN", "Họ và tên",
			"Có mặt", "Số hàng tăng ca", "Có/Không phép", "Số lượng", "Số lượng còn lại", "Xưởng" }) {
		Class[] columnTypes = new Class[] { String.class, String.class, String.class, Boolean.class, Integer.class,
				Boolean.class, Integer.class, Integer.class, String.class }; // Thay Long thành Integer

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	};

	private JTable table;
	ArrayList<BangChamCongNhanVien> dsnv;
	ArrayList<BangChamCongCongNhan> dscn;

	public ChamcongJpanel() throws Exception {
		setLayout(null);
		setSize(912, 623);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setUI(new CustomGUi.CustomTabbedPaneUI());
		tabbedPane.setBounds(10, 11, 863, 609);
		add(tabbedPane);

		JPanel pnNhanVien = new JPanel();
		pnNhanVien.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("Nhân viên", null, pnNhanVien, null);
		tabbedPane.setEnabledAt(0, true);
		pnNhanVien.setLayout(null);

		JLabel lblPhngBan = new JLabel("Phòng ban:");
		lblPhngBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhngBan.setBounds(90, 26, 90, 17);
		pnNhanVien.add(lblPhngBan);

		JLabel lblCaLamNV = new JLabel("Ca làm:");
		lblCaLamNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCaLamNV.setBounds(90, 76, 63, 17);
		pnNhanVien.add(lblCaLamNV);

		JComboBox comboBox_CaLamNV = new JComboBox();
		comboBox_CaLamNV.setBackground(new Color(255, 255, 255));
		comboBox_CaLamNV.setBorder(null);
		comboBox_CaLamNV.setAutoscrolls(true);
		comboBox_CaLamNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_CaLamNV.setBounds(207, 73, 166, 27);
		pnNhanVien.add(comboBox_CaLamNV);
		comboBox_CaLamNV.addItem("Ca sáng");
		comboBox_CaLamNV.addItem("Ca chiều");
		comboBox_CaLamNV.addItem("Ca tối");

		JComboBox comboBox_gioLamViec = new JComboBox();
		comboBox_gioLamViec.setAutoscrolls(true);
		comboBox_gioLamViec.setBackground(new Color(255, 255, 255));
		comboBox_gioLamViec.setBorder(null);
		comboBox_gioLamViec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_gioLamViec.setBounds(539, 71, 166, 27);
		comboBox_gioLamViec.setEnabled(false);
		comboBox_gioLamViec.addItem("7:00-10:00");
		comboBox_gioLamViec.addItem("13:00-16:30");
		comboBox_gioLamViec.addItem("17:00-22:00");
		pnNhanVien.add(comboBox_gioLamViec);
		comboBox_CaLamNV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Kiểm tra giá trị được chọn trong comboBox_CaLamNV
				String selectedCa = (String) comboBox_CaLamNV.getSelectedItem();

				// Cập nhật giá trị trong comboBox_gioLamViec tương ứng với lựa chọn của người
				// dùng
				if ("Ca sáng".equals(selectedCa)) {
					comboBox_gioLamViec.setSelectedItem("7:00-10:00");
				} else if ("Ca chiều".equals(selectedCa)) {
					comboBox_gioLamViec.setSelectedItem("13:00-16:30");
				} else if ("Ca tối".equals(selectedCa)) {
					comboBox_gioLamViec.setSelectedItem("17:00-22:00");
				}

				if (!"Ca tối".equals(selectedCa)) {
					// Không cho phép chỉnh sửa cột số giờ tăng ca
					table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JTextField()) {
						@Override
						public boolean isCellEditable(EventObject e) {
							return false;
						}
					});

				} else {
					// Cho phép chỉnh sửa cột số giờ tăng c
					table.getColumnModel().getColumn(4).setCellEditor(null);

				}

			}
		});

		JLabel lblNgayLamNV = new JLabel("Ngày làm:");
		lblNgayLamNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayLamNV.setBounds(432, 26, 63, 17);
		pnNhanVien.add(lblNgayLamNV);

		JLabel lblGioLamViecNV = new JLabel("Giờ làm việc:");
		lblGioLamViecNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioLamViecNV.setBounds(428, 76, 77, 17);
		pnNhanVien.add(lblGioLamViecNV);

		btnTatCaCoMat = new JButton("Tất cả có mặt");
		btnTatCaCoMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTatCaCoMat.setBackground(new Color(30, 144, 255));
		btnTatCaCoMat
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnTatCaCoMat.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/co.png")));
		btnTatCaCoMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int row = 0; row < table.getRowCount(); row++) {
					table.setValueAt(true, row, 3);
				}
			}
		});
		btnTatCaCoMat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTatCaCoMat.setBounds(291, 160, 136, 26);
		pnNhanVien.add(btnTatCaCoMat);

		btnLuu = new JButton("Lưu");
		btnLuu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnLuu.setAutoscrolls(true);
		btnLuu.setBackground(new Color(30, 144, 255));
		btnLuu.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/luu.png")));

		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLuu.setBounds(765, 160, 83, 27);
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy dữ liệu từ các trường hoặc thành phần giao diện người dùng

				// Lưu dữ liệu vào cơ sở dữ liệu (nếu cần)
				BangChamCongNhanVien_BUS chamCongBus = new BangChamCongNhanVien_BUS();
				ArrayList<BangChamCongNhanVien> ds = chamCongBus.getDanhSachNhanVien();
				dsnv = ds;
				BangChamCongNhanVien_BUS bangChamCongNhanVienBUS = new BangChamCongNhanVien_BUS();
				java.util.Date selectedDate = dateChooser.getDate();
				ArrayList<BangChamCongNhanVien> danhSachNhanVien = bangChamCongNhanVienBUS.luuVaoMang(modelNv,
						selectedDate);
				BangChamCongNhanVien_DAO dao = new BangChamCongNhanVien_DAO();
				dao.updateBangChamCongNhanVien(danhSachNhanVien);

				JOptionPane.showMessageDialog(null, "Dữ liệu đã được lưu thành công!", "Thành công",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		pnNhanVien.add(btnLuu);

		JComboBox comboBox_PhongBanNV = new JComboBox();
		comboBox_PhongBanNV.setBackground(new Color(255, 255, 255));
		comboBox_PhongBanNV.setBorder(null);
		comboBox_PhongBanNV.setAutoscrolls(true);
		comboBox_PhongBanNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_PhongBanNV.setBounds(207, 23, 166, 27);
		comboBox_PhongBanNV.addItem("None");
		comboBox_PhongBanNV.addItem("Phòng Kế Toán");
		comboBox_PhongBanNV.addItem("Phòng Nhân Sự");
		comboBox_PhongBanNV.addItem("Kinh Doanh");
		comboBox_PhongBanNV.addItem("Xưởnng sản xuất");
		comboBox_PhongBanNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str1 = (String) comboBox_PhongBanNV.getSelectedItem();
				BangChamCongNhanVien_BUS bus = new BangChamCongNhanVien_BUS();
				ArrayList<BangChamCongNhanVien> newList = new ArrayList<>();
				java.util.Date selectedDate = dateChooser.getDate();
				if (comboBox_PhongBanNV.getSelectedItem() != "None") {

					newList = bus.getDanhSachNhanVienTheoNgayChamCong(selectedDate, dsnv, str1);

				} else {
					newList = dsnv;
				}
				resetTable(modelNv, newList);

			}
		});
		pnNhanVien.add(comboBox_PhongBanNV);

		btnTatCaVangMat = new JButton("Tất cả vắng mặt");
		btnTatCaVangMat
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnTatCaVangMat.setAutoscrolls(true);
		btnTatCaVangMat.setBackground(new Color(30, 144, 255));
		btnTatCaVangMat.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/vang.png")));
		btnTatCaVangMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int row = 0; row < table.getRowCount(); row++) {
					table.setValueAt(false, row, 3);
				}
			}
		});

		btnTatCaVangMat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTatCaVangMat.setBounds(468, 160, 146, 27);
		pnNhanVien.add(btnTatCaVangMat);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 204, 838, 377);
		pnNhanVien.add(scrollPane_1);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");

		java.util.Date currentDate = new java.util.Date();

		// Đặt ngày của dateChooser_NgayChamCongCN là ngày hiện tại
		dateChooser.setDate(currentDate);
		dateChooser.getCalendarButton()
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		dateChooser.getCalendarButton().setBackground(new Color(255, 255, 255));
		dateChooser.setBounds(539, 26, 166, 27);

		// Chọn danh sách nhân viên theo tháng
		dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// Kiểm tra xem sự kiện có phải là ngày được chọn không
				if ("date".equals(evt.getPropertyName())) {
					BangChamCongNhanVien_BUS chamCongBus = new BangChamCongNhanVien_BUS();
					ArrayList<BangChamCongNhanVien> ds = chamCongBus.getDanhSachNhanVien();
					dsnv = ds;
					java.util.Date selectedDate = dateChooser.getDate();
					java.util.Date currentDate = new java.util.Date();
					if (selectedDate.after(currentDate)) {
						// Display an error message
						JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày trước ngày hiện tại.");
						// You might want to reset the dateChooser to the current date or handle it as
						// per your requirements.
						dateChooser.setDate(currentDate);
						disableButtons();
					} else {

						enableButtons();
						str1 = (String) comboBox_PhongBanNV.getSelectedItem();
						ArrayList<BangChamCongNhanVien> newList = chamCongBus
								.getDanhSachNhanVienTheoNgayChamCong(selectedDate, dsnv, str1);
						resetTable(modelNv, newList);
					}

				}
			}
		});

		pnNhanVien.add(dateChooser);

		JLabel lblTmKim_1 = new JLabel("Tìm kiếm");
		lblTmKim_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTmKim_1.setBounds(25, 169, 58, 17);
		pnNhanVien.add(lblTmKim_1);

		textField_timkiemNV = new JTextField();
		textField_timkiemNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_timkiemNV.setColumns(10);
		textField_timkiemNV.setBounds(90, 160, 126, 27);
		pnNhanVien.add(textField_timkiemNV);

		JButton btnTiemKiemNV_1 = new JButton("");
		btnTiemKiemNV_1
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnTiemKiemNV_1.setBackground(new Color(30, 144, 255));
		btnTiemKiemNV_1.setAutoscrolls(true);
		btnTiemKiemNV_1.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/tim.png")));
		btnTiemKiemNV_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTiemKiemNV_1.setBounds(224, 162, 34, 25);
		pnNhanVien.add(btnTiemKiemNV_1);
		// Tìm kiếm nhân viên theo mã
		btnTiemKiemNV_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy mã nhân viên từ textField_timkiemNV
				ArrayList<BangChamCongNhanVien> newList = new ArrayList<>();
				BangChamCongNhanVien_BUS bangChamCongNhanVienBUS = new BangChamCongNhanVien_BUS();
				String maNhanVien = textField_timkiemNV.getText();
				if (!maNhanVien.isEmpty()) {
					// Tìm nhân viên theo mã số
					BangChamCongNhanVien nhanVien = bangChamCongNhanVienBUS.timNhanVienTheoMa(maNhanVien);
					newList.add(nhanVien);
					// Hiển thị kết quả tìm kiếm trong bảng
					if (nhanVien != null) {
						// Xóa dữ liệu hiện tại trong bảng
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);

						// Thêm nhân viên tìm thấy vào bảng
						resetTable(model, newList);
					} else {
						// Hiển thị thông báo khi không tìm thấy nhân viên
						JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên với mã " + maNhanVien,
								"Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					// Hiển thị thông báo khi không nhập mã nhân viên
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mã nhân viên", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JPanel pnCongNhan = new JPanel();
		pnCongNhan.setBackground(new Color(240, 240, 240));
		pnCongNhan.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("Công nhân", null, pnCongNhan, null);
		tabbedPane.setEnabledAt(1, true);
		pnCongNhan.setLayout(null);

		JLabel lblMaCN = new JLabel("Mã công nhân");
		lblMaCN.setBounds(135, 24, 90, 17);
		lblMaCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblMaCN);

		textField_MaCN = new JTextField();
		textField_MaCN.setBounds(251, 21, 132, 20);
		textField_MaCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(textField_MaCN);
		textField_MaCN.setColumns(10);

		JLabel lblSP = new JLabel("Sản phẩm");
		lblSP.setBounds(135, 54, 63, 17);
		lblSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblSP);

		JComboBox comboBox_SP = new JComboBox();
		comboBox_SP.setBackground(new Color(255, 255, 255));
		comboBox_SP.setAutoscrolls(true);
		comboBox_SP.setBorder(null);
		comboBox_SP.setBounds(251, 50, 132, 22);
		comboBox_SP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_SP.addItem("None");
		comboBox_SP.addItem("Áo Polo Nam");
		comboBox_SP.addItem("Áo Sơ Mi Nữ");
		comboBox_SP.addItem("Quần Jean Nam");
		comboBox_SP.addItem("Quần Legging Nữ");
		comboBox_SP.addItem("Áo Thun Trơn Unisex");
		comboBox_SP.addItem("Áo Khoác Nam");
		comboBox_SP.addItem("Quần Shorts Nữ");
		comboBox_SP.addItem("Quần Âu Nam");
		comboBox_SP.addItem("Áo Len Nữ");
		comboBox_SP.addItem("Quần Jogger Nam");
		pnCongNhan.add(comboBox_SP);

		JLabel lblNgayChamCongCN = new JLabel("Ngày chấm công");
		lblNgayChamCongCN.setBounds(120, 85, 110, 17);
		lblNgayChamCongCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblNgayChamCongCN);

		JLabel lblMaXuong = new JLabel("Mã xưởng");
		lblMaXuong.setBounds(415, 24, 63, 17);
		lblMaXuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblMaXuong);

		JComboBox comboBox_MaXuong = new JComboBox();
		comboBox_MaXuong.setBorder(null);
		comboBox_MaXuong.setBackground(new Color(255, 255, 255));
		comboBox_MaXuong.setBounds(527, 20, 132, 22);
		comboBox_MaXuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(comboBox_MaXuong);
		comboBox_MaXuong.addItem("None");
		comboBox_MaXuong.addItem("Xưởng 1");
		comboBox_MaXuong.addItem("Xưởng 2");

		JLabel lblCongDoan = new JLabel("Công đoạn");
		lblCongDoan.setBounds(415, 54, 69, 17);
		lblCongDoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblCongDoan);

		txt_CongDoan = new JTextField();
		txt_CongDoan.setBounds(527, 50, 132, 22);
		txt_CongDoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(txt_CongDoan);
		txt_CongDoan.setColumns(10);

		JLabel lblSoSP = new JLabel("Số sản phẩm");
		lblSoSP.setBounds(415, 85, 82, 17);
		lblSoSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblSoSP);

		txt_soSP = new JTextField();
		txt_soSP.setBounds(527, 81, 132, 22);
		txt_soSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(txt_soSP);
		txt_soSP.setColumns(10);

		JLabel lblSoLuongConLai = new JLabel("Số lượng còn lại");
		lblSoLuongConLai.setBounds(415, 115, 102, 17);
		lblSoLuongConLai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblSoLuongConLai);

		textField_soluongCL = new JTextField();
		textField_soluongCL.setBounds(527, 112, 132, 20);
		textField_soluongCL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_soluongCL.setColumns(10);
		pnCongNhan.add(textField_soluongCL);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 204, 838, 366);
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
		ScrollBarCustom sp = new ScrollBarCustom();
		sp.setOrientation(JScrollBar.HORIZONTAL);
		scrollPane.setHorizontalScrollBar(sp);
		pnCongNhan.add(scrollPane);

		tableCN = new JTable(modelCn) {
			@Override
			public TableCellEditor getCellEditor(int row, int column) {
				// Kiểm tra nếu đang xem cột "Có mặt" (cột thứ 3) hoặc cột "Có/Không phép" (cột
				// thứ 5)
				if (column == 3 || column == 5) {
					boolean isPresent = (boolean) getValueAt(row, 3); // Kiểm tra giá trị của cột "Có mặt"

					if (isPresent) {
						// Nếu có mặt, không cho phép chỉnh sửa cột "Có/Không phép" nhưng cho phép chỉnh
						// sửa cột "Có mặt"
						if (column == 3) {
							return super.getCellEditor(row, column);
						} else {
							return getDefaultEditor(Object.class); // Chặn chỉnh sửa cột "Có/Không phép"
						}
					} else {
						// Nếu không có mặt, cho phép chỉnh sửa cả hai cột "Có mặt" và "Có/Không phép"
						return super.getCellEditor(row, column);
					}
				}
				// Cho các cột khác, cho phép chỉnh sửa bình thường
				return super.getCellEditor(row, column);
			}
		};

		tableCN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableCN.setModel(modelCn);
		tableCN.getColumnModel().getColumn(2).setPreferredWidth(115);
		tableCN.getColumnModel().getColumn(4).setPreferredWidth(99);
		tableCN.getColumnModel().getColumn(5).setPreferredWidth(102);
		scrollPane.setViewportView(tableCN);
		initDataCN(null, modelCn);
		resettableCN(modelCn, dscn);
		ListSelectionModel selectionModel = tableCN.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tableCN.getSelectedRow();
					if (selectedRow >= 0) {
						Object maBCCSelect = tableCN.getValueAt(selectedRow, 0);
						BangChamCongCongNhan_BUS bus = new BangChamCongCongNhan_BUS();
						BangChamCongCongNhan bccSelect = null;
						try {
							bccSelect = bus.timCongNhanTheoMaBCC(maBCCSelect.toString());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						txt_CongDoan.setText(bccSelect.getCd().getTenCongDoan());

						textField_soluongCL.setText(String.valueOf(bccSelect.getPc().getSoLuongCongDoanPhanCong()));

						String Sp = bccSelect.getSp().getTenSanPham();
						for (int i = 0; i < comboBox_SP.getItemCount(); i++) {
							if (Sp.equals(comboBox_SP.getItemAt(i))) {
								comboBox_SP.setSelectedIndex(i); //
								break;
							}
						}

						String maCongNhan = String.valueOf(bccSelect.getMaCongNhan());
						String soSP = tableCN.getValueAt(selectedRow, 6).toString();
						String xuong = String.valueOf(bccSelect.getCn().getXuong());
						txt_soSP.setText(soSP);
						textField_MaCN.setText(maCongNhan);
						for (int i = 0; i < comboBox_MaXuong.getItemCount(); i++) {
							if (xuong.equals(comboBox_MaXuong.getItemAt(i))) {
								comboBox_MaXuong.setSelectedIndex(i); // Chọn phòng ban tương ứng
								break;
							}
						}

					}
				}

			}
		}

		);

		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTmKim.setBounds(10, 172, 58, 17);
		pnCongNhan.add(lblTmKim);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(78, 169, 106, 23);
		pnCongNhan.add(textField_4);

		JLabel lblMaXuongLoc = new JLabel("Mã xưởng");
		lblMaXuongLoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaXuongLoc.setBounds(251, 172, 63, 17);
		pnCongNhan.add(lblMaXuongLoc);

		comboBox_MaXuongLoc = new JComboBox();
		comboBox_MaXuongLoc.setBorder(null);
		comboBox_MaXuongLoc.setBackground(new Color(255, 255, 255));
		comboBox_MaXuongLoc.setAutoscrolls(true);
		comboBox_MaXuongLoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_MaXuongLoc.setBounds(324, 168, 106, 25);
		comboBox_MaXuongLoc.addItem("None");
		comboBox_MaXuongLoc.addItem("Xưởng 1");
		comboBox_MaXuongLoc.addItem("Xưởng 2");
		comboBox_MaXuongLoc.addItem("Xưởng C");
		comboBox_MaXuongLoc.addItem("Xưởng D");

		comboBox_MaXuongLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str1 = (String) comboBox_MaXuongLoc.getSelectedItem();
				ArrayList<BangChamCongCongNhan> newList = new ArrayList<>();
				BangChamCongCongNhan_BUS bus = new BangChamCongCongNhan_BUS();
				java.util.Date selectedDate = dateChooser_NgayChamCongCN.getDate();
				if (comboBox_MaXuongLoc.getSelectedItem() != "None") {
//					for (BangChamCongCongNhan cn : dscn) {
//						if (cn.getCn().getXuong().equals(comboBox_MaXuongLoc.getSelectedItem())) {
//							newList.add(cn);
//						}
//					}

					try {
						newList = bus.getDanhSachCongNhanTheoNgayChamCong(selectedDate, dscn, str1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					newList = dscn;
				}
				resettableCN(modelCn, newList);
			}
		});
		pnCongNhan.add(comboBox_MaXuongLoc);

		btnThemCN = new JButton("Cập nhật");
		btnThemCN.setAutoscrolls(true);
		btnThemCN.setBackground(new Color(30, 144, 255));
		btnThemCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnThemCN.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/them.png")));
		btnThemCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangChamCongCongNhan_BUS bus = new BangChamCongCongNhan_BUS();
				// Kiểm tra tính hợp lệ của dữ liệu trước khi cập nhật bảng
				if (!bus.validateSoSP(txt_soSP, textField_soluongCL)) {
					return; // Nếu không hợp lệ, thoát khỏi phương thức
				}

				// Tiếp tục với logic cập nhật bảng
				int selectedRow = tableCN.getSelectedRow();
				if (selectedRow >= 0) {
					try {
						// Lấy giá trị từ txt_soSP và textField_soluongCL và chuyển đổi thành kiểu int
						int soSPValue = Integer.parseInt(txt_soSP.getText());
						int soLuongCLValue = Integer.parseInt(textField_soluongCL.getText());

						// Tính toán giá trị mới cho cột "Số lượng còn lại" và cập nhật bảng
						int soLuongConLai = soLuongCLValue - soSPValue;
						tableCN.setValueAt(soSPValue, selectedRow, 6);
						tableCN.setValueAt(soLuongConLai, selectedRow, 7);

						// Cập nhật cột "Có mặt" thành true
						tableCN.setValueAt(true, selectedRow, 3);

					} catch (NumberFormatException ex) {
						// Xử lý trường hợp khi giá trị không phải là số nguyên hợp lệ
						ex.printStackTrace();
					}

				}

				txt_soSP.setText("");
				textField_soluongCL.setText("");
			}
		});
		btnThemCN.setBounds(463, 170, 102, 21);
		pnCongNhan.add(btnThemCN);

		JButton btnTKCN = new JButton("Thống kê");
		btnTKCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChamCongCongNhanDialog dialog = null;
				try {
					dialog = new ChamCongCongNhanDialog();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dialog.setVisible(true);
			}
		});
		btnTKCN.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/them.png")));
		btnTKCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTKCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnTKCN.setBackground(new Color(30, 144, 255));
		btnTKCN.setAutoscrolls(true);
		btnTKCN.setBounds(605, 170, 91, 21);
		pnCongNhan.add(btnTKCN);

		btnLuuCN = new JButton("Lưu");
		btnLuuCN.setBackground(new Color(30, 144, 255));
		btnLuuCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnLuuCN.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/luu.png")));
		btnLuuCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLuuCN.setBounds(733, 170, 90, 21);
		pnCongNhan.add(btnLuuCN);
		btnLuuCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				BangChamCongCongNhan_BUS chamCongBus = new BangChamCongCongNhan_BUS();
				ArrayList<BangChamCongCongNhan> ds = null;
				try {
					ds = chamCongBus.getDanhSachCongNhan();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dscn = ds;
				BangChamCongCongNhan_BUS bangChamCongCongNhanBUS = new BangChamCongCongNhan_BUS();
				java.util.Date selectedDate = dateChooser_NgayChamCongCN.getDate();
				ArrayList<BangChamCongCongNhan> danhSachCongNhan = bangChamCongCongNhanBUS.luuVaoMangCn(modelCn, selectedDate);
				BangChamCongCongNhan_DAO daoCN = new BangChamCongCongNhan_DAO();
				daoCN.updateBangChamCongCongNhan(danhSachCongNhan);

//				BangChamCongCongNhan_BUS Bus = new BangChamCongCongNhan_BUS();
//				ArrayList<BangChamCongCongNhan> danhSachPhanCong = Bus.luuVaoMangCn(modelCn);
//				BangChamCongCongNhan_DAO daopc = new BangChamCongCongNhan_DAO();
//				daopc.updatePhanCongCongDoan(danhSachPhanCong);

				JOptionPane.showMessageDialog(null, "Dữ liệu đã được lưu thành công!", "Thành công",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		JButton btnTiemKiemCNMa = new JButton("");
		btnTiemKiemCNMa
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnTiemKiemCNMa.setBackground(new Color(30, 144, 255));
		btnTiemKiemCNMa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnTiemKiemCNMa.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/tim.png")));
		btnTiemKiemCNMa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTiemKiemCNMa.setBounds(194, 169, 34, 25);
		pnCongNhan.add(btnTiemKiemCNMa);
		btnTiemKiemCNMa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy mã CongNhan từ textField_4
				ArrayList<BangChamCongCongNhan> newList = new ArrayList<>();
				BangChamCongCongNhan_BUS bangChamCongCongNhanBUS = new BangChamCongCongNhan_BUS();
				String maCongNhan = textField_4.getText();
				if (!maCongNhan.isEmpty()) {
					// Tìm công nhân theo mã số
					BangChamCongCongNhan CongNhan = null;
					try {
						CongNhan = bangChamCongCongNhanBUS.timCongNhanTheoMa(maCongNhan);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					newList.add(CongNhan);
					// Hiển thị kết quả tìm kiếm trong bảng
					if (CongNhan != null) {
						// Xóa dữ liệu hiện tại trong bảng
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);

						// Thêm công nhân tìm thấy vào bảng
						resettableCN(modelCn, newList);
					} else {
						// Hiển thị thông báo khi không tìm thấy công nhân
						JOptionPane.showMessageDialog(null, "Không tìm thấy công nhân với mã " + maCongNhan,
								"Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					// Hiển thị thông báo khi không nhập mã công nhân
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mã công nhân", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		dateChooser_NgayChamCongCN = new JDateChooser();
		dateChooser_NgayChamCongCN.setDateFormatString("dd/MM/yyyy");
		dateChooser_NgayChamCongCN.getCalendarButton()
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		dateChooser_NgayChamCongCN.getCalendarButton().setBackground(new Color(255, 255, 255));
		dateChooser_NgayChamCongCN.setBounds(251, 85, 132, 20);
		// Lấy ngày hiện tại

		// Đặt ngày của dateChooser_NgayChamCongCN là ngày hiện tại
		dateChooser_NgayChamCongCN.setDate(currentDate);
		dateChooser_NgayChamCongCN.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// Kiểm tra xem sự kiện có phải là ngày được chọn không
				if ("date".equals(evt.getPropertyName())) {
					BangChamCongCongNhan_BUS chamCongBus = new BangChamCongCongNhan_BUS();
					ArrayList<BangChamCongCongNhan> ds = null;
					try {
						ds = chamCongBus.getDanhSachCongNhan();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dscn = ds;
					java.util.Date selectedDate = dateChooser_NgayChamCongCN.getDate();

					java.util.Date currentDate = new java.util.Date();

					if (selectedDate.after(currentDate)) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày trước ngày hiện tại.");
						dateChooser_NgayChamCongCN.setDate(currentDate);

						disableButtonsCN(); // Disable buttons if needed
					} else {
						enableButtonsCN(); // Enable buttons if needed

						ArrayList<BangChamCongCongNhan> newList = null;
						try {
							newList = chamCongBus.getDanhSachCongNhanTheoNgayChamCong(selectedDate, dscn, str1);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						resettableCN(modelCn, newList);
					}

				}
			}
		});
		pnCongNhan.add(dateChooser_NgayChamCongCN);

		scrollPane_1.setHorizontalScrollBar(sp);

		JButton btnTK = new JButton("Thống kê");
		btnTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChamCongNhanVienDialog dialog = new ChamCongNhanVienDialog();
				dialog.setVisible(true);
			}
		});
		btnTK.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/them.png")));
		btnTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTK.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnTK.setBackground(new Color(30, 144, 255));
		btnTK.setAutoscrolls(true);
		btnTK.setBounds(645, 160, 90, 27);
		pnNhanVien.add(btnTK);
		table = new JTable(modelNv) {
			@Override
			public TableCellEditor getCellEditor(int row, int column) {
				// Kiểm tra nếu đang xem cột "Có mặt" (cột thứ 3) hoặc cột "Có/Không phép" (cột
				// thứ 5)
				if (column == 3 || column == 5) {
					boolean isPresent = (boolean) getValueAt(row, 3); // Kiểm tra giá trị của cột "Có mặt"

					if (isPresent) {
						// Nếu có mặt, không cho phép chỉnh sửa cột "Có/Không phép" nhưng cho phép chỉnh
						// sửa cột "Có mặt"
						if (column == 3) {
							return super.getCellEditor(row, column);
						} else {
							return getDefaultEditor(Object.class); // Chặn chỉnh sửa cột "Có/Không phép"
						}
					} else {
						// Nếu không có mặt, cho phép chỉnh sửa cả hai cột "Có mặt" và "Có/Không phép"
						return super.getCellEditor(row, column);
					}
				}
				// Cho các cột khác, cho phép chỉnh sửa bình thường
				return super.getCellEditor(row, column);
			}
		};

		table.setModel(modelNv);
		scrollPane_1.setViewportView(table);
		scrollPane_1.setVerticalScrollBar(new ScrollBarCustom());
		initData(modelNv, null);
		
		if(Dangnhap.type == 3 ) {
        	tabbedPane.setSelectedIndex(1);
        	tabbedPane.setEnabledAt(0, false);
        }else if(Dangnhap.type == 2) {
        	tabbedPane.setSelectedIndex(0);
        	tabbedPane.setEnabledAt(1, false);
        }

	}

	private void initData(DefaultTableModel modelNv, DefaultTableModel modelCn) {
		BangChamCongNhanVien_BUS chamCongBus = new BangChamCongNhanVien_BUS();
		ArrayList<BangChamCongNhanVien> ds = chamCongBus.getDanhSachNhanVien();
		dsnv = ds;
		resetTable(modelNv, ds);
	}

	private void initDataCN(DefaultTableModel modelNv, DefaultTableModel modelCn) throws Exception {

		BangChamCongCongNhan_BUS chamCongCNBus = new BangChamCongCongNhan_BUS();
		ArrayList<BangChamCongCongNhan> dsCN = chamCongCNBus.getDanhSachCongNhan();
		dscn = dsCN;
		resettableCN(modelCn, dsCN);
	}

	private void resetTable(DefaultTableModel modelNv, ArrayList<BangChamCongNhanVien> ds) {
		while (table.getRowCount() > 0) {
			modelNv.removeRow(0);
		}
		int stt = 1;
		for (BangChamCongNhanVien row : ds) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Vector vec = new Vector<>();
			vec.add(row.getMaChamCongNV());
			vec.add(row.getMaNhanVien());
			vec.add(row.getNv().getTen());
			vec.add(false);
			vec.add(0.0);
			vec.add(false);
			vec.add("");
			modelNv.addRow(vec);
		}
	}

	private void resettableCN(DefaultTableModel modelCn, ArrayList<BangChamCongCongNhan> dsCN) {
		while (tableCN.getRowCount() > 0) {
			modelCn.removeRow(0);
		}
		for (BangChamCongCongNhan row : dsCN) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Vector vec = new Vector<>();
			vec.add(row.getMaChamCongCN());
			vec.add(row.getMaCongNhan());
			vec.add(row.getCn().getTen());
			vec.add(false);
			vec.add(0);
			vec.add(false);
			vec.add(0);
			vec.add(row.getPc().getSoLuongCongDoanPhanCong());
			vec.add(row.getCn().getXuong());
			modelCn.addRow(vec);
		}

	}

	private void disableButtons() {
		btnTatCaCoMat.setEnabled(false);
		btnTatCaVangMat.setEnabled(false);
		btnLuu.setEnabled(false);

	}

	// Function to enable buttons
	private void enableButtons() {
		btnTatCaCoMat.setEnabled(true);
		btnTatCaVangMat.setEnabled(true);
		btnLuu.setEnabled(true);

	}

	private void disableButtonsCN() {
		btnLuuCN.setEnabled(false);
		btnThemCN.setEnabled(false);

	}

	// Function to enable buttons
	private void enableButtonsCN() {
		btnThemCN.setEnabled(true);
		btnLuuCN.setEnabled(true);

	}

}
