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

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;

public class NhansuJpanel extends JPanel {

	/**
	 * Create the panel.
	 */
//	public NhansuJpanel() {
//		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.PINK);
//		panel.setForeground(Color.MAGENTA);
//		add(panel);
//		panel.setLayout(new CardLayout(0, 0));
//
//	}
	private JTextField txtIDNhanVien;
	private JTextField txtNgayThamGiaNV;
	private JTextField txtSoDienThoaiNV;
	private JTextField txtDiaChiNV;
	private JTextField txtTenNhanVienNV;
	private JTextField txtEmailNV;
	private JTextField CalenNgaySinhNV;
	private JTextField txtLuongCoBanNV;
	private JTextField txtTimKiemNV;
	private JTable tableNhanVien;
	private JTextField textmaCN;
	private JTextField txtNgayThamGiaCN;
	private JTextField txtSoDienThoaiCN;
	private JTextField txtDiaChiCN;
	private JTextField txtCN;
	private JTextField txtNgaySinhCN;
	private JTextField txtTimKiemCN;
	private JTable tableCongNhan;

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
		
		txtNgayThamGiaCN = new JTextField();
		txtNgayThamGiaCN.setColumns(10);
		txtNgayThamGiaCN.setBounds(199, 39, 138, 20);
		tabbedCongNhan.add(txtNgayThamGiaCN);
		
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
		lblNgaySinhCN.setBounds(632, 42, 95, 14);
		tabbedCongNhan.add(lblNgaySinhCN);
		
		txtNgaySinhCN = new JTextField();
		txtNgaySinhCN.setColumns(10);
		txtNgaySinhCN.setBounds(725, 39, 138, 20);
		tabbedCongNhan.add(txtNgaySinhCN);
		
		JLabel lblTimKiemCN = new JLabel("Tìm Kiếm:");
		lblTimKiemCN.setBounds(24, 202, 66, 14);
		tabbedCongNhan.add(lblTimKiemCN);
		
		txtTimKiemCN = new JTextField();
		txtTimKiemCN.setColumns(10);
		txtTimKiemCN.setBounds(92, 199, 138, 20);
		tabbedCongNhan.add(txtTimKiemCN);
		
		JLabel lblIDSearchIDXuongCN = new JLabel("Mã xưởng:");
		lblIDSearchIDXuongCN.setBounds(278, 202, 87, 14);
		tabbedCongNhan.add(lblIDSearchIDXuongCN);
		
		JButton btnDeleteCN = new JButton("Xóa");
		btnDeleteCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnDeleteCN.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\xoa.png"));
		btnDeleteCN.addActionListener(new ActionListener() {
			public void actionPerformed1(ActionEvent e) {
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnDeleteCN.setBackground(new Color(30, 144, 255));
		btnDeleteCN.setBounds(541, 198, 89, 23);
		tabbedCongNhan.add(btnDeleteCN);
		
		JButton btnAddCN = new JButton("Thêm");
		btnAddCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnAddCN.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\them.png"));
		btnAddCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddCN.setBackground(new Color(30, 144, 255));
		btnAddCN.setBounds(658, 198, 89, 23);
		tabbedCongNhan.add(btnAddCN);
		
		JButton btnSaveCN = new JButton("Lưu");
		btnSaveCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnSaveCN.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\luu.png"));
		btnSaveCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveCN.setBackground(new Color(30, 144, 255));
		btnSaveCN.setBounds(774, 198, 89, 23);
		tabbedCongNhan.add(btnSaveCN);
		
		JScrollPane scrollPaneCN = new JScrollPane();
		scrollPaneCN.setBounds(10, 236, 876, 331);
		tabbedCongNhan.add(scrollPaneCN);
		
		tableCongNhan = new JTable();
		tableCongNhan.setModel((TableModel) new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
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
		comboBoxChuyenMonCN.setModel(new DefaultComboBoxModel(new String[] {"Vắt sổ"}));
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
		comboBoxPhuCapCN.setModel(new DefaultComboBoxModel(new String[] {"200000", "255000", "600000"}));
		comboBoxPhuCapCN.setBounds(465, 69, 138, 22);
		tabbedCongNhan.add(comboBoxPhuCapCN);
		
		JComboBox comboBoxIDXuong = new JComboBox();
		comboBoxIDXuong.setBackground(new Color(255, 255, 255));
		comboBoxIDXuong.setBorder(null);
		comboBoxIDXuong.setAutoscrolls(true);
		comboBoxIDXuong.setModel(new DefaultComboBoxModel(new String[] {"X0001", "X0002", "X0003"}));
		comboBoxIDXuong.setBounds(465, 38, 138, 22);
		tabbedCongNhan.add(comboBoxIDXuong);
		
		JComboBox comboBoxSearchIDXuong = new JComboBox();
		comboBoxSearchIDXuong.setBackground(new Color(255, 255, 255));
		comboBoxSearchIDXuong.setAutoscrolls(true);
		comboBoxSearchIDXuong.setBorder(null);
		comboBoxSearchIDXuong.setModel(new DefaultComboBoxModel(new String[] {"X0001", "X0002", "X0003"}));
		comboBoxSearchIDXuong.setBounds(373, 198, 138, 22);
		tabbedCongNhan.add(comboBoxSearchIDXuong);
		
		txtIDNhanVien = new JTextField();
		txtIDNhanVien.setBounds(199, 8, 138, 20);
		tabbedNhanVien.add(txtIDNhanVien);
		txtIDNhanVien.setColumns(10);
		
		txtNgayThamGiaNV = new JTextField();
		txtNgayThamGiaNV.setColumns(10);
		txtNgayThamGiaNV.setBounds(199, 39, 138, 20);
		tabbedNhanVien.add(txtNgayThamGiaNV);
		
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
		
		CalenNgaySinhNV = new JTextField();
		CalenNgaySinhNV.setColumns(10);
		CalenNgaySinhNV.setBounds(721, 39, 138, 20);
		tabbedNhanVien.add(CalenNgaySinhNV);
		
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
		txtTimKiemNV.setBounds(91, 198, 138, 20);
		tabbedNhanVien.add(txtTimKiemNV);
		
		JLabel lblSearchPhongBanNV = new JLabel("Phòng ban:");
		lblSearchPhongBanNV.setBounds(277, 201, 81, 14);
		tabbedNhanVien.add(lblSearchPhongBanNV);
		
		JComboBox comboBoxSearchPhongBanNV = new JComboBox();
		comboBoxSearchPhongBanNV.setBackground(new Color(255, 255, 255));
		comboBoxSearchPhongBanNV.setAutoscrolls(true);
		comboBoxSearchPhongBanNV.setBorder(null);
		comboBoxSearchPhongBanNV.setBounds(370, 197, 138, 22);
		tabbedNhanVien.add(comboBoxSearchPhongBanNV);
		
		JButton btnDeleteNV = new JButton("Xóa");
		btnDeleteNV.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnDeleteNV.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\xoa.png"));
		btnDeleteNV.setBackground(new Color(30, 144, 255));
		btnDeleteNV.setBounds(539, 197, 89, 23);
		tabbedNhanVien.add(btnDeleteNV);
		
		JButton btnAddNV = new JButton("Thêm");
		btnAddNV.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnAddNV.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\them.png"));
		btnAddNV.setBackground(new Color(30, 144, 255));
		btnAddNV.setBounds(654, 197, 89, 23);
		tabbedNhanVien.add(btnAddNV);
		
		JButton btnSaveNV = new JButton("Lưu");
		btnSaveNV.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\luu.png"));
		btnSaveNV.setBackground(new Color(30, 144, 255));
		btnSaveNV.setBounds(770, 197, 89, 23);
		tabbedNhanVien.add(btnSaveNV);
		
		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(10, 236, 876, 331);
		tabbedNhanVien.add(scrollPaneNV);
		
		tableNhanVien = new JTable();
		scrollPaneNV.setViewportView(tableNhanVien);
		tableNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
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

	}
}
