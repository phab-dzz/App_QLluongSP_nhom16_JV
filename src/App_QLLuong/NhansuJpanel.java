package App_QLLuong;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import BUS.CongNhan_BUS;
import BUS.NhanVien_BUS;
import DTO.CongNhan;
import DTO.NhanVien;
public class NhansuJpanel extends JPanel {

	
	private JTextField txtIDNhanVien;
	private JTextField txtSoDienThoaiNV;
	private JTextField txtDiaChiNV;
	private JTextField txtTenNhanVienNV;
	private JTextField txtEmailNV;
	private JTextField txtLuongCoBanNV;
	private JTextField txtTimKiemNV;
	private JTable tableNhanVien;
	private JTextField textmaCN;
	private JTextField txtSoDienThoaiCN;
	private JTextField txtDiaChiCN;
	private JTextField txtCN;
	private JTextField txtTimKiemCN;
	private JTable tableCongNhan;
	public static NhanVien_BUS nhanVienBUS = new NhanVien_BUS();
	public static CongNhan_BUS congNhanBUS = new CongNhan_BUS();
	private final JButton btnSearchNV = new JButton("Tìm");
	private final JButton btnSearchCN = new JButton("Tìm");
	private static int NVCount, CNCount;

	private JDialog dialog;
	private static boolean confirmationStatus = false; // Biến lưu trạng thái xác nhận

	public void DeleteConfirmationDialog(String maNhanSu, DefaultTableModel model, int selectRow) {
		confirmationStatus = false;
		dialog = new JDialog();
		dialog.setSize(400, 200);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.getContentPane().setLayout(new BorderLayout());

		// Phần màu RGB(249, 166, 26) chứa icon ở giữa
		JPanel iconPanel = new JPanel(new BorderLayout());
		iconPanel.setBackground(new Color(249, 166, 26));

		ImageIcon errorIcon = new ImageIcon(NhansuJpanel.class.getResource("/Icons/IconSanpham.png"));
		JLabel iconLabel = new JLabel(errorIcon);
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		iconPanel.add(iconLabel, BorderLayout.CENTER);

		dialog.getContentPane().add(iconPanel, BorderLayout.NORTH);
		String warnning;
		// Nội dung lỗi
		if (maNhanSu.startsWith("NV")) {
			warnning = "Bạn có muốn xóa nhân viên này ?";
		}else {
			warnning = "Bạn có muốn xóa công nhân này ?";
		}
		JLabel errorMessageLabel = new JLabel("<html>" + warnning + "</html");
		errorMessageLabel.setHorizontalAlignment(JLabel.CENTER);
		errorMessageLabel.setVerticalAlignment(JLabel.CENTER);
		errorMessageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		dialog.getContentPane().add(errorMessageLabel, BorderLayout.CENTER);

		// Nút xác nhận và hủy
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Thêm khoảng cách 20 pixels giữa các nút và 10 pixels dưới

		JButton confirmButton = new JButton("Xác nhận");
		confirmButton.addActionListener(e -> {
			dialog.dispose();
			System.out.println("Xóa");
			if (maNhanSu.startsWith("NV")) {
				nhanVienBUS.xoaNhanVien(maNhanSu);
				model.removeRow(selectRow); // Xóa hàng từ bảng
				tableNhanVien.clearSelection(); // Bỏ chọn hàng
				NVCount--;
				confirmationStatus = true; 
			} else {
				congNhanBUS.xoaCongNhan(maNhanSu);
				model.removeRow(selectRow); // Xóa hàng từ bảng
				tableCongNhan.clearSelection(); // Bỏ chọn hàng
				
				confirmationStatus = true; 
			}
		});

		JButton cancelButton = new JButton("Hủy");
		cancelButton.addActionListener(e -> {
			dialog.dispose();
			System.out.println("Hủy");
			confirmationStatus = false; // Gán false khi hủy
		});

		buttonPanel.add(confirmButton);
		buttonPanel.add(cancelButton);

		// Đặt khoảng trống dưới buttonPanel
		buttonPanel.setBorder(new EmptyBorder(0, 0, 10, 0));

		dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		dialog.setVisible(true);

	}

	public void hienThiThongTinNV(String maNhanVien) {
		NhanVien nv = nhanVienBUS.getNhanVien(maNhanVien);
		String gioiTinh;
		if(nv.isGioiTinh()) {
			gioiTinh = "Nam";
		}else {
			gioiTinh = "Nữ";
		}
		// Lấy mô hình dữ liệu của JTable
		DefaultTableModel tableModel = (DefaultTableModel) tableNhanVien.getModel();

		// Xóa tất cả dữ liệu cũ trong mô hình dữ liệu của JTable
		int rowCount = tableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		tableModel.addRow(new Object[] {
				0,  // STT
				nv.getMaNhanVien(),
				nv.getTen(),
				gioiTinh,
				nv.getNgaySinh(),
				nv.getEmail(),
				nv.getDiaChi(),
				nv.getPhongBan()
		});
	}

	public void hienThiThongTinCN(String maCongNhan) {
		CongNhan cn = congNhanBUS.getCongNhan(maCongNhan);
		String gioiTinh;
		if(cn.isGioiTinh()) {
			gioiTinh = "Nam";
		}else {
			gioiTinh = "Nữ";
		}
		// Lấy mô hình dữ liệu của JTable
		DefaultTableModel tableModel = (DefaultTableModel) tableCongNhan.getModel();

		// Xóa tất cả dữ liệu cũ trong mô hình dữ liệu của JTable
		int rowCount = tableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		tableModel.addRow(new Object[] {
				0,  // STT
				cn.getMaCongNhan(),
				cn.getTen(),
				gioiTinh,
				cn.getNgaySinh(),
				cn.getsDT(),
				cn.getDiaChi(),
				cn.getXuong()
		});
	}

	public void hienThiDanhSachNhanVienPhongBan(String tenPhong) {
		ArrayList<NhanVien> dsNhanVienTheoPhongBan = nhanVienBUS.getDanhSachNhanVienPhongBan(tenPhong);
		String gioiTinh;

		// Lấy mô hình dữ liệu của JTable
		DefaultTableModel tableModel = (DefaultTableModel) tableNhanVien.getModel();

		// Xóa tất cả dữ liệu cũ trong mô hình dữ liệu của JTable
		int rowCount = tableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}

		// Thêm danh sách nhân viên mới vào mô hình dữ liệu
		for (NhanVien nv : dsNhanVienTheoPhongBan) {
			if(nv.isGioiTinh()) {
				gioiTinh = "Nam";
			}else {
				gioiTinh = "Nữ";
			}
			tableModel.addRow(new Object[] {
					null,  // STT
					nv.getMaNhanVien(),
					nv.getTen(),
					gioiTinh,
					nv.getNgaySinh(),
					nv.getEmail(),
					nv.getDiaChi(),
					nv.getPhongBan()
			});
		}
	}

	public void hienThiDanhSachCongNhanXuong(String xuong) {
		ArrayList<CongNhan> dsCongNhanXuong = congNhanBUS.getDanhSachCongNhanXuong(xuong);
		String gioiTinh;

		// Lấy mô hình dữ liệu của JTable
		DefaultTableModel tableModel = (DefaultTableModel) tableCongNhan.getModel();

		// Xóa tất cả dữ liệu cũ trong mô hình dữ liệu của JTable
		int rowCount = tableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}

		// Thêm danh sách nhân viên mới vào mô hình dữ liệu
		for (CongNhan cn : dsCongNhanXuong) {
			if(cn.isGioiTinh()) {
				gioiTinh = "Nam";
			}else {
				gioiTinh = "Nữ";
			}
			tableModel.addRow(new Object[] {
					null,  // STT
					cn.getMaCongNhan(),
					cn.getTen(),
					gioiTinh,
					cn.getNgaySinh(),
					cn.getsDT(),
					cn.getDiaChi(),
					cn.getXuong()
			});
		}
	}


	public void hienThiDanhSachNhanVien() {
		// Lấy danh sách nhân viên từ BUS
		ArrayList<NhanVien> dsNhanVien = nhanVienBUS.getDanhSachNhanVien();
		String gioiTinh;
		//Phát sinh ID Nhân viên
		NVCount = dsNhanVien.size() +1;
		String phatSinhIDNV = "NV00" + String.format("%1d", NVCount);
		// Lấy mô hình dữ liệu của JTable
		DefaultTableModel tableModel = (DefaultTableModel) tableNhanVien.getModel();

		// Xóa tất cả dữ liệu cũ trong mô hình dữ liệu của JTable
		int rowCount = tableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}

		// Thêm danh sách nhân viên mới vào mô hình dữ liệu
		for (NhanVien nv : dsNhanVien) {
			if(nv.isGioiTinh()) {
				gioiTinh = "Nam";
			}else {
				gioiTinh = "Nữ";
			}
			tableModel.addRow(new Object[] {
					null,  // STT
					nv.getMaNhanVien(),
					nv.getTen(),
					gioiTinh,
					nv.getNgaySinh(),
					nv.getEmail(),
					nv.getDiaChi(),
					nv.getPhongBan()
			});
		}
	}


	public void hienThiDanhSachCongNhan() {
		// Lấy danh sách nhân viên từ BUS
		ArrayList<CongNhan> dsCongNhan = congNhanBUS.getDanhSachCongNhan();
		String gioiTinh;
		//Phát sinh ID
		int CNCount = dsCongNhan.size() +1;
		String phatSinhIDCN = "CN00" + String.format("%1d", CNCount);
		textmaCN.setText(phatSinhIDCN);
		// Lấy mô hình dữ liệu của JTable
		DefaultTableModel tableModel = (DefaultTableModel) tableCongNhan.getModel();

		// Xóa tất cả dữ liệu cũ trong mô hình dữ liệu của JTable
		int rowCount = tableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}

		// Thêm danh sách nhân viên mới vào mô hình dữ liệu
		for (CongNhan cn : dsCongNhan) {
			if(cn.isGioiTinh()) {
				gioiTinh = "Nam";
			}else {
				gioiTinh = "Nữ";
			}
			tableModel.addRow(new Object[] {
					null,  // STT
					cn.getMaCongNhan(),
					cn.getTen(),
					gioiTinh,
					cn.getNgaySinh(),
					cn.getsDT(),
					cn.getDiaChi(),
					cn.getXuong()
			});
		}
	}

	/**
	 * Create the panel.
	 */
	public NhansuJpanel() {
		
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(Color.MAGENTA);
		setSize(912,623);
		add(panel);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setUI(new CustomGUi.CustomTabbedPaneUI());
		tabbedPane.setBounds(10, 11, 901, 606);
		panel.add(tabbedPane);

		JPanel tabbedCongNhan = new JPanel();

		tabbedPane.addTab("Công nhân", null, tabbedCongNhan, null);
		tabbedCongNhan.setLayout(null);

		JPanel tabbedNhanVien = new JPanel();
		tabbedPane.addTab("Nhân viên", null, tabbedNhanVien, null);
		tabbedNhanVien.setLayout(null);

		JLabel lblIDNhanVien = new JLabel("Mã nhân viên:");
		lblIDNhanVien.setBounds(101, 11, 95, 14);
		tabbedNhanVien.add(lblIDNhanVien);

		JLabel lblIDCongNhan = new JLabel("Mã công nhân:");
		lblIDCongNhan.setBounds(101, 11, 95, 14);
		tabbedCongNhan.add(lblIDCongNhan);

		textmaCN = new JTextField();
		textmaCN.setBounds(199, 8, 138, 20);
		tabbedCongNhan.add(textmaCN);
		textmaCN.setColumns(10);

		JLabel lblNgayThamGiaCN = new JLabel("Ngày tham gia:");
		lblNgayThamGiaCN.setBounds(101, 42, 95, 14);
		tabbedCongNhan.add(lblNgayThamGiaCN);

		txtSoDienThoaiCN = new JTextField();
		txtSoDienThoaiCN.setColumns(10);
		txtSoDienThoaiCN.setBounds(199, 70, 138, 20);
		tabbedCongNhan.add(txtSoDienThoaiCN);

		txtDiaChiCN = new JTextField();
		txtDiaChiCN.setColumns(10);
		txtDiaChiCN.setBounds(199, 132, 404, 20);
		tabbedCongNhan.add(txtDiaChiCN);

		JLabel lblSoDienThoaiCN = new JLabel("Số điện thoại:");
		lblSoDienThoaiCN.setBounds(101, 73, 95, 14);
		tabbedCongNhan.add(lblSoDienThoaiCN);

		JLabel lblChuyenMonCN = new JLabel("Chuyên môn:");
		lblChuyenMonCN.setBounds(101, 104, 95, 14);
		tabbedCongNhan.add(lblChuyenMonCN);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(101, 135, 95, 14);
		tabbedCongNhan.add(lblDiaChi);

		JLabel lblHoTenCN = new JLabel("Họ tên:");
		lblHoTenCN.setBounds(367, 11, 95, 14);
		tabbedCongNhan.add(lblHoTenCN);

		JLabel lblIDXuongCN = new JLabel("Mã xưởng:");
		lblIDXuongCN.setBounds(367, 42, 95, 14);
		tabbedCongNhan.add(lblIDXuongCN);

		JLabel lblPhuCapCN = new JLabel("Phụ cấp:");
		lblPhuCapCN.setBounds(367, 73, 95, 14);
		tabbedCongNhan.add(lblPhuCapCN);

		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setBounds(367, 104, 95, 14);
		tabbedCongNhan.add(lblTrangThai);

		txtCN = new JTextField();
		txtCN.setColumns(10);
		txtCN.setBounds(465, 8, 138, 20);
		tabbedCongNhan.add(txtCN);

		JLabel lblGioiTinhCN = new JLabel("Giới tính:");
		lblGioiTinhCN.setBounds(632, 11, 66, 14);
		tabbedCongNhan.add(lblGioiTinhCN);

		JRadioButton rdbtnNamCN = new JRadioButton("Nam");
		rdbtnNamCN.setBorder(null);
		rdbtnNamCN.setBounds(725, 7, 66, 23);
		tabbedCongNhan.add(rdbtnNamCN);

		JRadioButton rdbtnNuCN = new JRadioButton("Nữ");
		rdbtnNuCN.setBounds(824, 7, 66, 23);
		tabbedCongNhan.add(rdbtnNuCN);

		JLabel lblNgaySinhCN = new JLabel("Ngày sinh:");
		lblNgaySinhCN.setBounds(632, 42, 87, 18);
		tabbedCongNhan.add(lblNgaySinhCN);


		JLabel lblIDXuongTrinhDoCN = new JLabel("Trình độ:");
		lblIDXuongTrinhDoCN.setBounds(632, 73, 95, 14);
		tabbedCongNhan.add(lblIDXuongTrinhDoCN);

		JComboBox comboBoxTrinhDoCN = new JComboBox();
		comboBoxTrinhDoCN.setModel(new DefaultComboBoxModel(new String[] {"0", "0.2", "0.5", "0.8", "1.2"}));
		comboBoxTrinhDoCN.setBorder(null);
		comboBoxTrinhDoCN.setBackground(Color.WHITE);
		comboBoxTrinhDoCN.setAutoscrolls(true);
		comboBoxTrinhDoCN.setBounds(725, 69, 138, 22);
		tabbedCongNhan.add(comboBoxTrinhDoCN);

		JLabel lblTimKiemCN = new JLabel("Tìm Kiếm:");
		lblTimKiemCN.setBounds(24, 202, 66, 14);
		tabbedCongNhan.add(lblTimKiemCN);

		txtTimKiemCN = new JTextField();
		txtTimKiemCN.setColumns(10);
		txtTimKiemCN.setBounds(92, 199, 125, 20);
		tabbedCongNhan.add(txtTimKiemCN);

		JLabel lblIDSearchIDXuongCN = new JLabel("Mã xưởng:");
		lblIDSearchIDXuongCN.setBounds(278, 202, 87, 14);
		tabbedCongNhan.add(lblIDSearchIDXuongCN);

		JScrollPane scrollPaneCN = new JScrollPane();
		scrollPaneCN.setBounds(10, 236, 876, 331);
		tabbedCongNhan.add(scrollPaneCN);

		tableCongNhan = new JTable();
		tableCongNhan.setModel((TableModel) new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null},
				},
				new String[] {
						"STT", "M\u00E3 c\u00F4ng nh\u00E2n", "H\u1ECD t\u00EAn", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "X\u01B0\u1EDFng"
				}
				) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class, String.class, Object.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableCongNhan.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableCongNhan.getColumnModel().getColumn(3).setPreferredWidth(23);
		tableCongNhan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneCN.setViewportView(tableCongNhan);

		JComboBox comboBoxChuyenMonCN = new JComboBox();
		comboBoxChuyenMonCN.setBorder(null);
		comboBoxChuyenMonCN.setBackground(new Color(255, 255, 255));
		comboBoxChuyenMonCN.setAutoscrolls(true);
		comboBoxChuyenMonCN.setModel(new DefaultComboBoxModel(new String[] {"Vắt sổ", "May áo", "Đính nút", "In hình", "Kiểm tra chất lượng", "Cắt vải", "May Quần", "May đáy quần", "May Túi"}));
		comboBoxChuyenMonCN.setBounds(199, 99, 138, 22);
		tabbedCongNhan.add(comboBoxChuyenMonCN);

		JComboBox comboBoxTrangThaiCN = new JComboBox();
		comboBoxTrangThaiCN.setBackground(new Color(255, 255, 255));
		comboBoxTrangThaiCN.setAutoscrolls(true);
		comboBoxTrangThaiCN.setBorder(null);
		comboBoxTrangThaiCN.setModel(new DefaultComboBoxModel(new String[] {"Còn làm việc", "Ngừng làm việc"}));
		comboBoxTrangThaiCN.setBounds(465, 99, 138, 22);
		tabbedCongNhan.add(comboBoxTrangThaiCN);

		JComboBox comboBoxPhuCapCN = new JComboBox();
		comboBoxPhuCapCN.setBackground(new Color(255, 255, 255));
		comboBoxPhuCapCN.setBorder(null);
		comboBoxPhuCapCN.setAutoscrolls(true);
		comboBoxPhuCapCN.setModel(new DefaultComboBoxModel(new String[] {"2800000", "2900000", "2950000", "2000000", "255000", "600000"}));
		comboBoxPhuCapCN.setBounds(465, 69, 138, 22);
		tabbedCongNhan.add(comboBoxPhuCapCN);

		JComboBox comboBoxIDXuong = new JComboBox();
		comboBoxIDXuong.setBackground(new Color(255, 255, 255));
		comboBoxIDXuong.setBorder(null);
		comboBoxIDXuong.setAutoscrolls(true);
		comboBoxIDXuong.setModel(new DefaultComboBoxModel(new String[] {"Xưởng 1", "Xưởng 2", "Xưởng 3", "Xưởng 4"}));
		comboBoxIDXuong.setBounds(465, 38, 138, 22);
		tabbedCongNhan.add(comboBoxIDXuong);



		JDateChooser dateChooser_NgayThamGiaCN = new JDateChooser();
		dateChooser_NgayThamGiaCN.setDateFormatString("dd/MM/yyyy");
		dateChooser_NgayThamGiaCN.setBounds(199, 39, 138, 20);
		tabbedCongNhan.add(dateChooser_NgayThamGiaCN);

		JDateChooser dateChooser_NgaySinhCN = new JDateChooser();
		dateChooser_NgaySinhCN.setDateFormatString("dd/MM/yyyy");
		dateChooser_NgaySinhCN.setBounds(725, 41, 138, 20);
		tabbedCongNhan.add(dateChooser_NgaySinhCN);





		txtIDNhanVien = new JTextField();
		txtIDNhanVien.setBounds(199, 8, 138, 20);
		tabbedNhanVien.add(txtIDNhanVien);
		txtIDNhanVien.setColumns(10);

		txtSoDienThoaiNV = new JTextField();
		txtSoDienThoaiNV.setColumns(10);
		txtSoDienThoaiNV.setBounds(199, 70, 138, 20);
		tabbedNhanVien.add(txtSoDienThoaiNV);

		JLabel lblSoDienThoaiNV = new JLabel("Số điện thoại:");
		lblSoDienThoaiNV.setBounds(101, 73, 95, 14);
		tabbedNhanVien.add(lblSoDienThoaiNV);

		JLabel lblChucDanh = new JLabel("Chức danh:");
		lblChucDanh.setBounds(101, 104, 95, 14);
		tabbedNhanVien.add(lblChucDanh);

		JLabel lblDiaChiNV = new JLabel("Địa chỉ:");
		lblDiaChiNV.setBounds(101, 132, 95, 14);
		tabbedNhanVien.add(lblDiaChiNV);

		txtDiaChiNV = new JTextField();
		txtDiaChiNV.setColumns(10);
		txtDiaChiNV.setBounds(199, 129, 402, 20);
		tabbedNhanVien.add(txtDiaChiNV);

		JLabel lblTenNhanVien = new JLabel("Họ tên:");
		lblTenNhanVien.setBounds(364, 11, 95, 14);
		tabbedNhanVien.add(lblTenNhanVien);

		txtTenNhanVienNV = new JTextField();
		txtTenNhanVienNV.setColumns(10);
		txtTenNhanVienNV.setBounds(463, 8, 138, 20);
		tabbedNhanVien.add(txtTenNhanVienNV);

		JLabel lblEmailNV = new JLabel("Email:");
		lblEmailNV.setBounds(364, 42, 95, 14);
		tabbedNhanVien.add(lblEmailNV);

		JLabel lblPhuCapNV = new JLabel("Phụ cấp:");
		lblPhuCapNV.setBounds(364, 73, 95, 14);
		tabbedNhanVien.add(lblPhuCapNV);

		JLabel lblPhongBanNV = new JLabel("Phòng ban:");
		lblPhongBanNV.setBounds(364, 104, 95, 14);
		tabbedNhanVien.add(lblPhongBanNV);

		txtEmailNV = new JTextField();
		txtEmailNV.setColumns(10);
		txtEmailNV.setBounds(463, 39, 138, 20);
		tabbedNhanVien.add(txtEmailNV);

		JLabel lblGioiTinhNV = new JLabel("Giới tính:");
		lblGioiTinhNV.setBounds(623, 11, 95, 14);
		tabbedNhanVien.add(lblGioiTinhNV);

		JLabel lblNgaySinhNV = new JLabel("Ngày sinh:");
		lblNgaySinhNV.setBounds(623, 42, 95, 14);
		tabbedNhanVien.add(lblNgaySinhNV);

		JRadioButton rdbtnNamNV = new JRadioButton("Nam");
		rdbtnNamNV.setBounds(724, 7, 70, 23);
		tabbedNhanVien.add(rdbtnNamNV);

		JRadioButton rdbtnNuNV = new JRadioButton("Nữ");
		rdbtnNuNV.setBounds(812, 7, 58, 23);
		tabbedNhanVien.add(rdbtnNuNV);

		JLabel lblHeSoLuongNV = new JLabel("Hệ số lương:");
		lblHeSoLuongNV.setBounds(623, 73, 95, 14);
		tabbedNhanVien.add(lblHeSoLuongNV);

		txtLuongCoBanNV = new JTextField();
		txtLuongCoBanNV.setColumns(10);
		txtLuongCoBanNV.setBounds(721, 101, 138, 20);
		tabbedNhanVien.add(txtLuongCoBanNV);

		JLabel lblLuongCoBanNV = new JLabel("Lương cơ bản");
		lblLuongCoBanNV.setBounds(623, 104, 95, 14);
		tabbedNhanVien.add(lblLuongCoBanNV);

		JLabel lblNgayThamGiaNV = new JLabel("Ngày tham gia:");
		lblNgayThamGiaNV.setBounds(101, 42, 95, 14);
		tabbedNhanVien.add(lblNgayThamGiaNV);

		JComboBox comboBoxHeSoLuongNV = new JComboBox();
		comboBoxHeSoLuongNV.setBackground(new Color(255, 255, 255));
		comboBoxHeSoLuongNV.setAutoscrolls(true);
		comboBoxHeSoLuongNV.setBorder(null);
		comboBoxHeSoLuongNV.setModel(new DefaultComboBoxModel(new String[] {"6.2", "6.56", "6.92", "7.28", "7.64", "8.0"}));
		comboBoxHeSoLuongNV.setBounds(721, 69, 138, 22);
		tabbedNhanVien.add(comboBoxHeSoLuongNV);

		JComboBox comboBoxPhuCapNV = new JComboBox();
		comboBoxPhuCapNV.setAutoscrolls(true);
		comboBoxPhuCapNV.setBackground(new Color(255, 255, 255));
		comboBoxPhuCapNV.setBorder(null);
		comboBoxPhuCapNV.setModel(new DefaultComboBoxModel(new String[] {"200000", "340000", "600000"}));
		comboBoxPhuCapNV.setBounds(463, 69, 138, 22);
		tabbedNhanVien.add(comboBoxPhuCapNV);

		JComboBox comboBoxPhongBanNV = new JComboBox();
		comboBoxPhongBanNV.setBackground(new Color(255, 255, 255));
		comboBoxPhongBanNV.setAutoscrolls(true);
		comboBoxPhongBanNV.setBorder(null);
		comboBoxPhongBanNV.setModel(new DefaultComboBoxModel(new String[] {"Kế toán", "Marketing"}));
		comboBoxPhongBanNV.setBounds(463, 100, 138, 22);
		tabbedNhanVien.add(comboBoxPhongBanNV);

		JComboBox comboBoxChucDanhNV = new JComboBox();
		comboBoxChucDanhNV.setBackground(new Color(255, 255, 255));
		comboBoxChucDanhNV.setAutoscrolls(true);
		comboBoxChucDanhNV.setBorder(null);
		comboBoxChucDanhNV.setModel(new DefaultComboBoxModel(new String[] {"Kế toán", "Marketing"}));
		comboBoxChucDanhNV.setBounds(199, 101, 138, 22);
		tabbedNhanVien.add(comboBoxChucDanhNV);

		JLabel lblTimKiemNV = new JLabel("Tìm Kiếm:");
		lblTimKiemNV.setBounds(25, 201, 64, 14);
		tabbedNhanVien.add(lblTimKiemNV);

		txtTimKiemNV = new JTextField();
		txtTimKiemNV.setColumns(10);
		txtTimKiemNV.setBounds(91, 198, 125, 20);
		tabbedNhanVien.add(txtTimKiemNV);

		JLabel lblSearchPhongBanNV = new JLabel("Phòng ban:");
		lblSearchPhongBanNV.setBounds(277, 201, 81, 14);
		tabbedNhanVien.add(lblSearchPhongBanNV);



		JDateChooser dateChooser_NgayThamGiaNV = new JDateChooser();
		dateChooser_NgayThamGiaNV.setDateFormatString("dd/MM/yyyy");
		dateChooser_NgayThamGiaNV.setBounds(199, 39, 138, 20);
		tabbedNhanVien.add(dateChooser_NgayThamGiaNV);

		JDateChooser dateChooser_NgaySinhNV = new JDateChooser();
		dateChooser_NgaySinhNV.setDateFormatString("dd/MM/yyyy");
		dateChooser_NgaySinhNV.setBounds(721, 36, 138, 20);
		tabbedNhanVien.add(dateChooser_NgaySinhNV);







		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(10, 236, 876, 331);
		tabbedNhanVien.add(scrollPaneNV);

		tableNhanVien = new JTable();
		scrollPaneNV.setViewportView(tableNhanVien);
		tableNhanVien.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null},
				},
				new String[] {
						"STT", "M\u00E3 Nh\u00E2n vi\u00EAn", "H\u1ECD t\u00EAn", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "Email", "\u0110\u1ECBa ch\u1EC9", "Ph\u00F2ng ban"
				}
				) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableNhanVien.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableNhanVien.getColumnModel().getColumn(1).setPreferredWidth(83);
		tableNhanVien.getColumnModel().getColumn(3).setPreferredWidth(23);
		tableNhanVien.getColumnModel().getColumn(5).setPreferredWidth(83);
		tableNhanVien.getColumnModel().getColumn(6).setPreferredWidth(131);
		tableNhanVien.getColumnModel().getColumn(7).setPreferredWidth(108);
		tableNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = tableNhanVien.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tableNhanVien.getSelectedRow();
					if (selectedRow >= 0) {
						Object maNVSelect = tableNhanVien.getValueAt(selectedRow, 1);
						NhanVien nvSelect = nhanVienBUS.getNhanVien(maNVSelect.toString());


						txtIDNhanVien.setText(nvSelect.getMaNhanVien());
						txtTenNhanVienNV.setText(nvSelect.getTen());
						txtSoDienThoaiNV.setText(nvSelect.getsDT());
						txtEmailNV.setText(nvSelect.getEmail());
						txtDiaChiNV.setText(nvSelect.getDiaChi());
						txtLuongCoBanNV.setText(String.valueOf(nvSelect.getLuongCoBan()));

						String phongBanNhanVien = nvSelect.getPhongBan();
						for (int i = 0; i < comboBoxPhongBanNV.getItemCount(); i++) {
							if (phongBanNhanVien.equals(comboBoxPhongBanNV.getItemAt(i))) {
								comboBoxPhongBanNV.setSelectedIndex(i); // Chọn phòng ban tương ứng
								break;
							}
						}
						String chucDanhNhanVien = nvSelect.getChucDanh();
						for (int i = 0; i < comboBoxChucDanhNV.getItemCount(); i++) {
							if (chucDanhNhanVien.equals(comboBoxChucDanhNV.getItemAt(i))) {
								comboBoxChucDanhNV.setSelectedIndex(i); // Chọn phòng ban tương ứng
								break;
							}
						}
						String hsLuongNhanVien = nvSelect.getChucDanh();
						for (int i = 0; i < comboBoxHeSoLuongNV.getItemCount(); i++) {
							if (hsLuongNhanVien.equals(comboBoxHeSoLuongNV.getItemAt(i))) {
								comboBoxHeSoLuongNV.setSelectedIndex(i); // Chọn phòng ban tương ứng
								break;
							}
						}
						String luongPhuCapNhanVien = String.valueOf(nvSelect.getLuongPhuCap()) ;
						for (int i = 0; i < comboBoxPhuCapNV.getItemCount(); i++) {
							if (luongPhuCapNhanVien.equals(comboBoxPhuCapNV.getItemAt(i))) {
								comboBoxPhuCapNV.setSelectedIndex(i); // Chọn phòng ban tương ứng
								break;
							}
						}

						LocalDate ngaySinhNV = nvSelect.getNgaySinh();
						java.util.Date utilNgaySinhNV = Date.from(ngaySinhNV.atStartOfDay(ZoneId.systemDefault()).toInstant());
						java.sql.Date dateNgaySinhNV = new java.sql.Date(utilNgaySinhNV.getTime());
						dateChooser_NgaySinhNV.setDate(dateNgaySinhNV);


						LocalDate ngayThamGiaNV = nvSelect.getNgayThamGia();
						java.util.Date utilngayThamGiaNV = Date.from(ngayThamGiaNV.atStartOfDay(ZoneId.systemDefault()).toInstant());
						java.sql.Date datengayThamGiaNV = new java.sql.Date(utilngayThamGiaNV.getTime());
						dateChooser_NgayThamGiaNV.setDate(datengayThamGiaNV);

						boolean gioiTinh = nvSelect.isGioiTinh();
						if(gioiTinh) {
							rdbtnNamNV.setSelected(true);
							rdbtnNuNV.setSelected(false);
						}else {
							rdbtnNamNV.setSelected(false);
							rdbtnNuNV.setSelected(true);
						}
					}

				}
			}

		});

		ListSelectionModel selectionMode2 = tableCongNhan.getSelectionModel();
		selectionMode2.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tableCongNhan.getSelectedRow();
					if (selectedRow >= 0) {
						Object maCNSelect = tableCongNhan.getValueAt(selectedRow, 1);
						CongNhan cnSelect = congNhanBUS.getCongNhan(maCNSelect.toString());


						textmaCN.setText(cnSelect.getMaCongNhan());
						txtCN.setText(cnSelect.getTen());
						txtSoDienThoaiCN.setText(cnSelect.getsDT());
						txtDiaChiCN.setText(cnSelect.getDiaChi());

						String xuongCongNhan = cnSelect.getXuong();
						for (int i = 0; i < comboBoxIDXuong.getItemCount(); i++) {
							if (xuongCongNhan.equals(comboBoxIDXuong.getItemAt(i))) {
								comboBoxIDXuong.setSelectedIndex(i); // Chọn phòng ban tương ứng
								break;
							}
						}
						String trinhDoCongNhan = String.valueOf(cnSelect.getTrinhDoChuyenMon());
						for (int i = 0; i < comboBoxTrinhDoCN.getItemCount(); i++) {
							if (trinhDoCongNhan.equals(comboBoxTrinhDoCN.getItemAt(i))) {
								comboBoxTrinhDoCN.setSelectedIndex(i); // Chọn phòng ban tương ứng
								break;
							}
						}
						String chuyenMonCongNhan = cnSelect.getChuyenMon();
						for (int i = 0; i < comboBoxChuyenMonCN.getItemCount(); i++) {
							if (chuyenMonCongNhan.equals(comboBoxChuyenMonCN.getItemAt(i))) {
								comboBoxChuyenMonCN.setSelectedIndex(i); // Chọn phòng ban tương ứng
								break;
							}
						}
						String luongPhuCapCongNhan = String.valueOf(cnSelect.getLuongPhuCap()) ;
						for (int i = 0; i < comboBoxPhuCapCN.getItemCount(); i++) {
							if (luongPhuCapCongNhan.equals(comboBoxPhuCapCN.getItemAt(i))) {
								comboBoxPhuCapCN.setSelectedIndex(i); // Chọn phòng ban tương ứng
								break;
							}
						}

						String strTrangThai;
						if(cnSelect.isTrangThai()){
							strTrangThai = "Còn làm việc";
							comboBoxPhuCapCN.setSelectedIndex(1);
						}else {
							strTrangThai = "Ngưng làm việc";
							comboBoxPhuCapCN.setSelectedIndex(2);
						}
						

						LocalDate ngaySinhCN = cnSelect.getNgaySinh();
						java.util.Date utilNgaySinhCN = Date.from(ngaySinhCN.atStartOfDay(ZoneId.systemDefault()).toInstant());
						java.sql.Date dateNgaySinhCN = new java.sql.Date(utilNgaySinhCN.getTime());
						dateChooser_NgaySinhCN.setDate(dateNgaySinhCN);


						LocalDate ngayThamGiaCN = cnSelect.getNgayThamGia();
						java.util.Date utilngayThamGiaCN = Date.from(ngayThamGiaCN.atStartOfDay(ZoneId.systemDefault()).toInstant());
						java.sql.Date datengayThamGiaCN = new java.sql.Date(utilngayThamGiaCN.getTime());
						dateChooser_NgayThamGiaCN.setDate(datengayThamGiaCN);

						boolean gioiTinh = cnSelect.isGioiTinh();
						if(gioiTinh) {
							rdbtnNamCN.setSelected(true);
							rdbtnNuCN.setSelected(false);
						}else {
							rdbtnNamCN.setSelected(false);
							rdbtnNuCN.setSelected(true);
						}
					}

				}
			}

		});

		JComboBox comboBoxSearchPhongBanNV = new JComboBox();
		//		comboBoxSearchPhongBanNV.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Kế toán", "Nhân sự", "Marketing", "Xưởng sản xuất", "Kinh Doanh"}));
		comboBoxSearchPhongBanNV.addItem("Tất cả");
		comboBoxSearchPhongBanNV.addItem("Phòng kế toán");
		comboBoxSearchPhongBanNV.addItem("Phòng nhân sự");
		comboBoxSearchPhongBanNV.addItem("Marketing");
		comboBoxSearchPhongBanNV.addItem("Xưởng sản xuất");
		comboBoxSearchPhongBanNV.addItem("Kinh doanh");
		comboBoxSearchPhongBanNV.setSelectedItem("Tất cả");
		hienThiDanhSachNhanVien();
		comboBoxSearchPhongBanNV.setBackground(new Color(255, 255, 255));
		comboBoxSearchPhongBanNV.setAutoscrolls(true);
		comboBoxSearchPhongBanNV.setBorder(null);
		comboBoxSearchPhongBanNV.setBounds(370, 197, 138, 22);
		comboBoxSearchPhongBanNV.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String tenPhong = comboBoxSearchPhongBanNV.getSelectedItem().toString();
					if(tenPhong.equals("Tất cả")) {
						hienThiDanhSachNhanVien();
					}else {
						hienThiDanhSachNhanVienPhongBan(tenPhong);
					}

				}
			}

		});
		tabbedNhanVien.add(comboBoxSearchPhongBanNV);
		
		

		JComboBox comboBoxSearchIDXuong = new JComboBox();
		comboBoxSearchIDXuong.setBackground(new Color(255, 255, 255));
		comboBoxSearchIDXuong.setAutoscrolls(true);
		comboBoxSearchIDXuong.setBorder(null);
		comboBoxSearchIDXuong.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Xưởng 1", "Xưởng 2", "Xưởng 2"}));
		comboBoxSearchIDXuong.setBounds(373, 198, 138, 22);
		hienThiDanhSachCongNhan();
		comboBoxSearchIDXuong.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String tenXuong = comboBoxSearchIDXuong.getSelectedItem().toString();
					if(tenXuong.equals("Tất cả")) {
						hienThiDanhSachCongNhan();
					}else {
						hienThiDanhSachCongNhanXuong(tenXuong);;
					}

				}
			}

		});
		tabbedCongNhan.add(comboBoxSearchIDXuong);



		//		JButton btnSearchNV = new JButton("Tìm");
		btnSearchNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maNhanVien = txtTimKiemNV.getText();
				hienThiThongTinNV(maNhanVien);
				System.out.println("Click!!!!");
			}
		});
		btnSearchNV.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnSearchNV.setBackground(new Color(30, 144, 255));
		btnSearchNV.setBounds(218, 199, 38, 20);
		tabbedNhanVien.add(btnSearchNV);

		//JButton btnSearchCN = new JButton("Tìm");
		btnSearchCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maCongNhan = txtTimKiemCN.getText();
				hienThiThongTinCN(maCongNhan);
				System.out.println("Click!!!!");
			}
		});
		btnSearchCN.setBounds(218, 199, 38, 20);
		btnSearchCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnSearchCN.setBackground(new Color(30, 144, 255));
		tabbedCongNhan.add(btnSearchCN);

		// Thêm nhân viên
		JButton btnAddNV = new JButton("Thêm");
		btnAddNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy thông tin từ các trường nhập liệu
				String maNhanVien = txtIDNhanVien.getText();
				String hoTen = txtTenNhanVienNV.getText();
				String chucDanh = comboBoxChucDanhNV.getSelectedItem().toString();
				String sDT = txtSoDienThoaiNV.getText();
				String email = txtEmailNV.getText();
				String phongBan = comboBoxPhongBanNV.getSelectedItem().toString();
				String diaChi = txtDiaChiNV.getText();
				double luongCoBan = 0.0;
				if (!txtLuongCoBanNV.getText().isEmpty()) {
					luongCoBan = Double.parseDouble(txtLuongCoBanNV.getText());
				}
				double hsLuong = Double.parseDouble(comboBoxHeSoLuongNV.getSelectedItem().toString());
				double luongPhuCap = Double.parseDouble(comboBoxPhuCapNV.getSelectedItem().toString());
				boolean gioiTinh = rdbtnNamNV.isSelected(); // true nếu giới tính là Nam, false nếu là Nữ

				LocalDate ngayThamGia = getLocalDateFromDateChooser(dateChooser_NgayThamGiaNV);
				LocalDate ngaySinh = getLocalDateFromDateChooser(dateChooser_NgaySinhNV);

				// Thực hiện thêm nhân viên vào cơ sở dữ liệu hoặc bất kỳ thao tác nào khác bạn cần

				boolean checkAddNV = nhanVienBUS.themNhanVien(maNhanVien, hoTen, chucDanh, sDT, email, phongBan, diaChi, luongCoBan, hsLuong, luongPhuCap, gioiTinh, ngayThamGia, ngaySinh);
				if(checkAddNV) {
					DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
					String strGioiTinh;
					if(gioiTinh) {
						strGioiTinh = "Nam";
					}else {
						strGioiTinh = "Nữ";
					}
					model.addRow(new Object[] { 1, maNhanVien, hoTen, strGioiTinh, ngayThamGia, email, diaChi, phongBan });
				}

			}

			private LocalDate getLocalDateFromDateChooser(JDateChooser dateChooser) {
				java.util.Date date = dateChooser.getDate();
				if (date != null) {
					Instant instant = date.toInstant();
					ZoneId zoneId = ZoneId.systemDefault();
					return instant.atZone(zoneId).toLocalDate();
				}
				return null; // Trả về giá trị mặc định nếu ngày là null.
			}


		});
		btnAddNV.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnAddNV.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\them.png"));
		btnAddNV.setBackground(new Color(30, 144, 255));
		btnAddNV.setBounds(654, 197, 89, 23);
		tabbedNhanVien.add(btnAddNV);

		// Thêm Công nhân
		JButton btnAddCN = new JButton("Thêm");
		btnAddCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnAddCN.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\them.png"));
		btnAddCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy thông tin từ các trường nhập liệu
				String maCongNhan = textmaCN.getText();
				String hoTen = txtCN.getText();
				String chuyenMon = comboBoxChuyenMonCN.getSelectedItem().toString();
				String sDT = txtSoDienThoaiCN.getText();
				String xuong = comboBoxIDXuong.getSelectedItem().toString();
				String diaChi = txtDiaChiCN.getText();
				String trangThai = comboBoxTrangThaiCN.getSelectedItem().toString();
				boolean trangThaiBool;
				if(trangThai.equals("Còn làm việc")) {
					trangThaiBool = true;
				}else {
					trangThaiBool = false;
				}

				double trinhDo = Double.parseDouble(comboBoxTrinhDoCN.getSelectedItem().toString());
				double luongPhuCap = Double.parseDouble(comboBoxPhuCapCN.getSelectedItem().toString());
				boolean gioiTinh = rdbtnNamCN.isSelected(); // true nếu giới tính là Nam, false nếu là Nữ

				LocalDate ngayThamGia = getLocalDateFromDateChooser(dateChooser_NgayThamGiaCN);
				LocalDate ngaySinh = getLocalDateFromDateChooser(dateChooser_NgaySinhCN);

				// Thực hiện thêm nhân viên vào cơ sở dữ liệu hoặc bất kỳ thao tác nào khác bạn cần

				boolean checkAddCN = congNhanBUS.themCongNhan(maCongNhan, hoTen, sDT, xuong, diaChi, chuyenMon, trinhDo, luongPhuCap, gioiTinh, trangThaiBool, ngaySinh, ngayThamGia);
				if(checkAddCN) {
					DefaultTableModel model = (DefaultTableModel) tableCongNhan.getModel();
					String strGioiTinh;
					if(gioiTinh) {
						strGioiTinh = "Nam";
					}else {
						strGioiTinh = "Nữ";
					}
					model.addRow(new Object[] { 1, maCongNhan, hoTen, strGioiTinh, ngaySinh, sDT, diaChi, xuong});
				}

			}

			private LocalDate getLocalDateFromDateChooser(JDateChooser dateChooser) {
				java.util.Date date = dateChooser.getDate();
				if (date != null) {
					Instant instant = date.toInstant();
					ZoneId zoneId = ZoneId.systemDefault();
					return instant.atZone(zoneId).toLocalDate();
				}
				return null; // Trả về giá trị mặc định nếu ngày là null.
			}

		});
		btnAddCN.setBackground(new Color(30, 144, 255));
		btnAddCN.setBounds(658, 198, 89, 23);
		tabbedCongNhan.add(btnAddCN);

		// Update nhân viên
		JButton btnSaveNV = new JButton("Lưu");
		btnSaveNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Lấy thông tin từ các trường nhập liệu
				String maNhanVien = txtIDNhanVien.getText();
				String hoTen = txtTenNhanVienNV.getText();
				String chucDanh = comboBoxChucDanhNV.getSelectedItem().toString();
				String sDT = txtSoDienThoaiNV.getText();
				String email = txtEmailNV.getText();
				String phongBan = comboBoxPhongBanNV.getSelectedItem().toString();
				String diaChi = txtDiaChiNV.getText();
				double luongCoBan = 0.0;
				if (!txtLuongCoBanNV.getText().isEmpty()) {
					luongCoBan = Double.parseDouble(txtLuongCoBanNV.getText());
				}
				double hsLuong = Double.parseDouble(comboBoxHeSoLuongNV.getSelectedItem().toString());
				double luongPhuCap = Double.parseDouble(comboBoxPhuCapNV.getSelectedItem().toString());
				boolean gioiTinh = rdbtnNamNV.isSelected(); // true nếu giới tính là Nam, false nếu là Nữ

				LocalDate ngayThamGia = getLocalDateFromDateChooser(dateChooser_NgayThamGiaNV);
				LocalDate ngaySinh = getLocalDateFromDateChooser(dateChooser_NgaySinhNV);

				// Thực hiện thêm nhân viên vào cơ sở dữ liệu hoặc bất kỳ thao tác nào khác bạn cần

				boolean checkAddNV = nhanVienBUS.updateNhanVien(maNhanVien, hoTen, chucDanh, sDT, email, phongBan, diaChi, luongCoBan, hsLuong, luongPhuCap, gioiTinh, ngayThamGia, ngaySinh);
				if(checkAddNV) {
					int selectedRow = tableNhanVien.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
					String strGioiTinh;
					if(gioiTinh) {
						strGioiTinh = "Nam";
					}else {
						strGioiTinh = "Nữ";
					}
					model.setValueAt(maNhanVien, selectedRow, 1);
					model.setValueAt(hoTen, selectedRow, 2);
					model.setValueAt(strGioiTinh, selectedRow, 3);
					model.setValueAt(ngaySinh, selectedRow, 4);
					model.setValueAt(email, selectedRow, 5);
					model.setValueAt(diaChi, selectedRow, 6);
					model.setValueAt(phongBan, selectedRow, 7);
					tableNhanVien.clearSelection();
				}

			}
			private LocalDate getLocalDateFromDateChooser(JDateChooser dateChooser) {
				java.util.Date date = dateChooser.getDate();
				if (date != null) {
					Instant instant = date.toInstant();
					ZoneId zoneId = ZoneId.systemDefault();
					return instant.atZone(zoneId).toLocalDate();
				}
				return null; // Trả về giá trị mặc định nếu ngày là null.
			}
		});
		btnSaveNV.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\luu.png"));
		btnSaveNV.setBackground(new Color(30, 144, 255));
		btnSaveNV.setBounds(770, 197, 89, 23);
		tabbedNhanVien.add(btnSaveNV);

		// Update công nhân
		JButton btnSaveCN = new JButton("Lưu");
		btnSaveCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnSaveCN.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\luu.png"));
		btnSaveCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String maCongNhan = textmaCN.getText();
				String hoTen = txtCN.getText();
				String chuyenMon = comboBoxChuyenMonCN.getSelectedItem().toString();
				String sDT = txtSoDienThoaiCN.getText();
				String xuong = comboBoxIDXuong.getSelectedItem().toString();
				String diaChi = txtDiaChiCN.getText();
				String trangThai = comboBoxTrangThaiCN.getSelectedItem().toString();
				boolean trangThaiBool;
				if(trangThai.equals("Còn làm việc")) {
					trangThaiBool = true;
				}else {
					trangThaiBool = false;
				}

				double trinhDo = Double.parseDouble(comboBoxTrinhDoCN.getSelectedItem().toString());
				double luongPhuCap = Double.parseDouble(comboBoxPhuCapCN.getSelectedItem().toString());
				boolean gioiTinh = rdbtnNamCN.isSelected(); // true nếu giới tính là Nam, false nếu là Nữ

				LocalDate ngayThamGia = getLocalDateFromDateChooser(dateChooser_NgayThamGiaCN);
				LocalDate ngaySinh = getLocalDateFromDateChooser(dateChooser_NgaySinhCN);

				// Thực hiện thêm nhân viên vào cơ sở dữ liệu hoặc bất kỳ thao tác nào khác bạn cần

				boolean checkUpdateCN = congNhanBUS.updateCongNhan(maCongNhan, hoTen, sDT, xuong, diaChi, chuyenMon, trinhDo, luongPhuCap, gioiTinh, trangThaiBool, ngaySinh, ngayThamGia);
				if(checkUpdateCN) {
					int selectedRow = tableCongNhan.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) tableCongNhan.getModel();
					String strGioiTinh;
					if(gioiTinh) {
						strGioiTinh = "Nam";
					}else {
						strGioiTinh = "Nữ";
					}
					model.setValueAt(maCongNhan, selectedRow, 1);
					model.setValueAt(hoTen, selectedRow, 2);
					model.setValueAt(strGioiTinh, selectedRow, 3);
					model.setValueAt(ngaySinh, selectedRow, 4);
					model.setValueAt(sDT, selectedRow, 5);
					model.setValueAt(diaChi, selectedRow, 6);
					model.setValueAt(xuong, selectedRow, 7);
					tableCongNhan.clearSelection();
				}

			}
			private LocalDate getLocalDateFromDateChooser(JDateChooser dateChooser) {
				java.util.Date date = dateChooser.getDate();
				if (date != null) {
					Instant instant = date.toInstant();
					ZoneId zoneId = ZoneId.systemDefault();
					return instant.atZone(zoneId).toLocalDate();
				}
				return null; // Trả về giá trị mặc định nếu ngày là null.
			}
		});
		btnSaveCN.setBackground(new Color(30, 144, 255));
		btnSaveCN.setBounds(774, 198, 89, 23);
		tabbedCongNhan.add(btnSaveCN);
		
		


		// Làm mới nhân viên
		JButton btnRefreshForm = new JButton("Làm mới");
		btnRefreshForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableNhanVien.clearSelection();
				txtIDNhanVien.setText("");
				txtTenNhanVienNV.setText("");
				txtSoDienThoaiNV.setText("");
				txtEmailNV.setText("");
				txtDiaChiNV.setText("");
				txtLuongCoBanNV.setText("");
				comboBoxPhongBanNV.setSelectedIndex(1);
				comboBoxChucDanhNV.setSelectedIndex(1);
				comboBoxHeSoLuongNV.setSelectedIndex(1);
				comboBoxPhuCapNV.setSelectedIndex(1);
				dateChooser_NgaySinhNV.cleanup();
				dateChooser_NgayThamGiaNV.cleanup();
				rdbtnNamNV.setSelected(true);
				rdbtnNuNV.setSelected(false);
			}
		});
		btnRefreshForm.setBackground(new Color(30, 144, 255));
		btnRefreshForm.setBounds(654, 156, 89, 23);
		tabbedNhanVien.add(btnRefreshForm);

		//Làm mới công nhân
		JButton btnRefreshCN = new JButton("Làm mới");
		btnRefreshCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableCongNhan.clearSelection();
				textmaCN.setText("");
				txtCN.setText("");
				txtSoDienThoaiCN.setText("");
				txtDiaChiCN.setText("");
				comboBoxTrinhDoCN.setSelectedIndex(1);
				comboBoxTrangThaiCN.setSelectedIndex(1);
				comboBoxChuyenMonCN.setSelectedIndex(1);
				comboBoxPhuCapCN.setSelectedIndex(1);
				comboBoxIDXuong.setSelectedIndex(1);
				dateChooser_NgaySinhCN.cleanup();
				dateChooser_NgayThamGiaCN.cleanup();
				rdbtnNamCN.setSelected(true);
				rdbtnNuCN.setSelected(false);
			}
		});
		btnRefreshCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnRefreshCN.setBackground(new Color(30, 144, 255));
		btnRefreshCN.setBounds(658, 157, 89, 23);
		tabbedCongNhan.add(btnRefreshCN);
		
		// xóa nhân viên
		JButton btnDeleteNV = new JButton("Xóa");
		btnDeleteNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableNhanVien.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
				if (selectedRow == -1) {
					// Không có hàng nào được chọn
					System.out.println("Chưa chọn hàng nào.");
				} else {
					String maNhanVien = (String) tableNhanVien.getValueAt(selectedRow, 1);
					System.out.println(maNhanVien);
					// Gọi DeleteConfirmationDialog(maNhanVien, model, selectedRow) để hiển thị hộp thoại xác nhận
					DeleteConfirmationDialog(maNhanVien, model, selectedRow);
					if(confirmationStatus) {
						textmaCN.setText("");
						txtCN.setText("");
						txtSoDienThoaiCN.setText("");
						txtDiaChiCN.setText("");
						comboBoxTrinhDoCN.setSelectedIndex(1);
						comboBoxTrangThaiCN.setSelectedIndex(1);
						comboBoxChuyenMonCN.setSelectedIndex(1);
						comboBoxPhuCapCN.setSelectedIndex(1);
						comboBoxIDXuong.setSelectedIndex(1);
						dateChooser_NgaySinhCN.cleanup();
						dateChooser_NgayThamGiaCN.cleanup();
						rdbtnNamCN.setSelected(true);
						rdbtnNuCN.setSelected(false);
					}
				}
			}
		});


		btnDeleteNV.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnDeleteNV.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\xoa.png"));
		btnDeleteNV.setBackground(new Color(30, 144, 255));
		btnDeleteNV.setBounds(539, 197, 89, 23);
		tabbedNhanVien.add(btnDeleteNV);
		
		// xóa công nhân
		JButton btnDeleteCN = new JButton("Xóa");
		btnDeleteCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnDeleteCN.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\xoa.png"));
		btnDeleteCN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableCongNhan.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) tableCongNhan.getModel();
				if (selectedRow == -1) {
					// Không có hàng nào được chọn
					System.out.println("Chưa chọn hàng nào.");
				} else {
					String maCongNhan = (String) tableCongNhan.getValueAt(selectedRow, 1);
					System.out.println(maCongNhan);
					// Gọi DeleteConfirmationDialog(maNhanVien, model, selectedRow) để hiển thị hộp thoại xác nhận
					DeleteConfirmationDialog(maCongNhan, model, selectedRow);
				}

			}
		});
		btnDeleteCN.setBackground(new Color(30, 144, 255));
		btnDeleteCN.setBounds(541, 198, 89, 23);
		tabbedCongNhan.add(btnDeleteCN);
	}
}
