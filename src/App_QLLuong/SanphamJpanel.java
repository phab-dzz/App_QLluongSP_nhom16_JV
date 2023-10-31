package App_QLLuong;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import CustomGUi.ScrollBarCustom;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class SanphamJpanel extends JPanel {

	/**
	 * Create the panel.
	 */

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tableSanPham;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	public SanphamJpanel() {
	

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(920,630);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		
		panel.setBounds(0, 0, 912, 623);
		
		panel.setLayout(null);
		
		JTabbedPane tabSanPham = new JTabbedPane(JTabbedPane.TOP);
		tabSanPham.setUI(new CustomGUi.CustomTabbedPaneUI());
		tabSanPham.setUI(new CustomGUi.CustomTabbedPaneUI());
		tabSanPham.setBounds(10, 11, 892, 601);
		panel.add(tabSanPham);
		
		JPanel pnlQuanLySanPham = new JPanel();
		tabSanPham.addTab("Quản lý sản phẩm", null, pnlQuanLySanPham, null);
		pnlQuanLySanPham.setLayout(null);
		
		JPanel pnlThongTinSanPham = new JPanel();
		pnlThongTinSanPham.setLayout(null);
		pnlThongTinSanPham.setBorder(new TitledBorder(null, "Th\u00F4ng tin chi ti\u1EBFt s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinSanPham.setBackground(UIManager.getColor("Button.background"));
		pnlThongTinSanPham.setBounds(10, 11, 867, 102);
		pnlQuanLySanPham.add(pnlThongTinSanPham);
		
		JPanel pnlMaSanPham = new JPanel();
		pnlMaSanPham.setLayout(null);
		pnlMaSanPham.setBackground(new Color(237, 214, 214));
		pnlMaSanPham.setBounds(27, 20, 367, 30);
		pnlThongTinSanPham.add(pnlMaSanPham);
		
		JLabel lblMaSanPham = new JLabel("Mã sản phẩm");
		lblMaSanPham.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaSanPham.setBounds(0, 0, 119, 19);
		pnlMaSanPham.add(lblMaSanPham);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(156, 0, 224, 30);
		pnlMaSanPham.add(textField);
		
		JPanel pnlSoLuong = new JPanel();
		pnlSoLuong.setLayout(null);
		pnlSoLuong.setBackground(new Color(237, 214, 214));
		pnlSoLuong.setBounds(27, 61, 380, 30);
		pnlThongTinSanPham.add(pnlSoLuong);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoLuong.setBounds(0, 0, 161, 30);
		pnlSoLuong.add(lblSoLuong);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 0, 224, 30);
		pnlSoLuong.add(textField_1);
		
		JPanel pnlTenSanPham = new JPanel();
		pnlTenSanPham.setLayout(null);
		pnlTenSanPham.setBackground(new Color(237, 214, 214));
		pnlTenSanPham.setBounds(463, 20, 380, 30);
		pnlThongTinSanPham.add(pnlTenSanPham);
		
		JLabel lblTenSanPham = new JLabel("Tên sản phẩm");
		lblTenSanPham.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenSanPham.setBounds(0, 0, 146, 30);
		pnlTenSanPham.add(lblTenSanPham);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(156, 0, 224, 30);
		pnlTenSanPham.add(textField_2);
		
		JPanel pnlSoLuongCD = new JPanel();
		pnlSoLuongCD.setLayout(null);
		pnlSoLuongCD.setBackground(new Color(237, 214, 214));
		pnlSoLuongCD.setBounds(463, 61, 380, 30);
		pnlThongTinSanPham.add(pnlSoLuongCD);
		
		JLabel lblSLngCng = new JLabel("Số lượng công đoạn");
		lblSLngCng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSLngCng.setBounds(0, 0, 151, 30);
		pnlSoLuongCD.add(lblSLngCng);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(156, 0, 224, 30);
		pnlSoLuongCD.add(textField_3);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBackground(UIManager.getColor("Button.background"));
		pnlChucNang.setBounds(10, 124, 867, 55);
		pnlQuanLySanPham.add(pnlChucNang);
		
		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBackground(new Color(237, 214, 214));
		pnlTimKiem.setBounds(10, 11, 191, 35);
		pnlChucNang.add(pnlTimKiem);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(0, 0, 70, 35);
		pnlTimKiem.add(lblTimKiem);
		
		JComboBox cboTimKiem = new JComboBox();
		cboTimKiem.setBackground(new Color(255, 255, 255));
		cboTimKiem.setBorder(null);
		cboTimKiem.setAutoscrolls(true);
		cboTimKiem.setBounds(80, 0, 111, 35);
		pnlTimKiem.add(cboTimKiem);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\add.png"));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBackground(Color.CYAN);
		btnThem.setBounds(260, 11, 101, 35);
		pnlChucNang.add(btnThem);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\refresh.png"));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.CYAN);
		btnLamMoi.setBounds(393, 11, 130, 35);
		pnlChucNang.add(btnLamMoi);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\editing.png"));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCapNhat.setBackground(Color.CYAN);
		btnCapNhat.setBounds(533, 11, 130, 35);
		pnlChucNang.add(btnCapNhat);
		
		JButton btnChiaCD = new JButton("Chia công đoạn");
		btnChiaCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChiaCD.setBackground(Color.CYAN);
		btnChiaCD.setBounds(673, 11, 184, 35);
		pnlChucNang.add(btnChiaCD);
		
		JPanel pnlDanhSachSanPham = new JPanel();
		pnlDanhSachSanPham.setLayout(null);
		pnlDanhSachSanPham.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00E1c s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachSanPham.setBackground(Color.WHITE);
		pnlDanhSachSanPham.setBounds(10, 190, 867, 372);
		pnlQuanLySanPham.add(pnlDanhSachSanPham);
		
		JScrollPane scrollPaneDanhSachSanPham = new JScrollPane();
		scrollPaneDanhSachSanPham.setBounds(10, 18, 847, 343);
		pnlDanhSachSanPham.add(scrollPaneDanhSachSanPham);
		
		tableSanPham = new JTable();
		tableSanPham.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng c\u00F4ng \u0111o\u1EA1n"
			}
		));
		scrollPaneDanhSachSanPham.setViewportView(tableSanPham);
		scrollPaneDanhSachSanPham.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollPaneDanhSachSanPham.setHorizontalScrollBar(sp);
		JPanel pnlChiaCongDoan = new JPanel();
		tabSanPham.addTab("Chia công đoạn sản phẩm", null, pnlChiaCongDoan, null);
		pnlChiaCongDoan.setLayout(null);
		
		JPanel pnlChiaCD = new JPanel();
		pnlChiaCD.setLayout(null);
		pnlChiaCD.setBorder(new TitledBorder(null, "Ph\u00E2n chia c\u00F4ng \u0111o\u1EA1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChiaCD.setBackground(UIManager.getColor("Button.background"));
		pnlChiaCD.setBounds(10, 11, 867, 192);
		pnlChiaCongDoan.add(pnlChiaCD);
		
		JPanel pnlMaSanPham_1 = new JPanel();
		pnlMaSanPham_1.setLayout(null);
		pnlMaSanPham_1.setBackground(new Color(237, 214, 214));
		pnlMaSanPham_1.setBounds(22, 25, 380, 30);
		pnlChiaCD.add(pnlMaSanPham_1);
		
		JLabel lblMaSanPham_1 = new JLabel("Mã sản phẩm");
		lblMaSanPham_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaSanPham_1.setBounds(0, 0, 161, 30);
		pnlMaSanPham_1.add(lblMaSanPham_1);
		
		JComboBox cboMaSanPham = new JComboBox();
		cboMaSanPham.setBackground(new Color(255, 255, 255));
		cboMaSanPham.setAutoscrolls(true);
		cboMaSanPham.setBorder(null);
		cboMaSanPham.setBounds(160, 0, 220, 30);
		pnlMaSanPham_1.add(cboMaSanPham);
		
		JPanel pnlTenSanPham_1 = new JPanel();
		pnlTenSanPham_1.setLayout(null);
		pnlTenSanPham_1.setBackground(new Color(237, 214, 214));
		pnlTenSanPham_1.setBounds(22, 66, 380, 30);
		pnlChiaCD.add(pnlTenSanPham_1);
		
		JLabel lblTenSanPham_1 = new JLabel("Tên sản phẩm");
		lblTenSanPham_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenSanPham_1.setBounds(0, 0, 161, 30);
		pnlTenSanPham_1.add(lblTenSanPham_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(160, 0, 220, 30);
		pnlTenSanPham_1.add(textField_4);
		
		JPanel pnlSoLuong_1 = new JPanel();
		pnlSoLuong_1.setLayout(null);
		pnlSoLuong_1.setBackground(new Color(237, 214, 214));
		pnlSoLuong_1.setBounds(22, 107, 380, 30);
		pnlChiaCD.add(pnlSoLuong_1);
		
		JLabel lblSoLuong_1 = new JLabel("Số lượng sản phẩm");
		lblSoLuong_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoLuong_1.setBounds(0, 0, 161, 30);
		pnlSoLuong_1.add(lblSoLuong_1);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(160, 0, 220, 30);
		pnlSoLuong_1.add(textField_5);
		
		JPanel pnlNgayChiaCD = new JPanel();
		pnlNgayChiaCD.setLayout(null);
		pnlNgayChiaCD.setBackground(new Color(237, 214, 214));
		pnlNgayChiaCD.setBounds(22, 148, 380, 30);
		pnlChiaCD.add(pnlNgayChiaCD);
		
		JLabel lblNgayChiaCD = new JLabel("Ngày chia công đoạn");
		lblNgayChiaCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayChiaCD.setBounds(0, 0, 161, 30);
		pnlNgayChiaCD.add(lblNgayChiaCD);
		
		JDateChooser dateNgayChiaCD = new JDateChooser();
		dateNgayChiaCD.setBounds(160, 0, 220, 30);
		pnlNgayChiaCD.add(dateNgayChiaCD);
		
		JPanel pnlMaCongDoan = new JPanel();
		pnlMaCongDoan.setLayout(null);
		pnlMaCongDoan.setBackground(new Color(237, 214, 214));
		pnlMaCongDoan.setBounds(464, 25, 380, 30);
		pnlChiaCD.add(pnlMaCongDoan);
		
		JLabel lblMaCongDoan = new JLabel("Mã công đoạn");
		lblMaCongDoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaCongDoan.setBounds(0, 0, 161, 30);
		pnlMaCongDoan.add(lblMaCongDoan);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(160, 0, 220, 30);
		pnlMaCongDoan.add(textField_6);
		
		JPanel pnlTenCongDoan = new JPanel();
		pnlTenCongDoan.setLayout(null);
		pnlTenCongDoan.setBackground(new Color(237, 214, 214));
		pnlTenCongDoan.setBounds(464, 66, 380, 30);
		pnlChiaCD.add(pnlTenCongDoan);
		
		JLabel lblTenCongDoan = new JLabel("Tên công đoạn");
		lblTenCongDoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenCongDoan.setBounds(0, 0, 161, 30);
		pnlTenCongDoan.add(lblTenCongDoan);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(160, 0, 220, 30);
		pnlTenCongDoan.add(textField_7);
		
		JPanel pnlNgayThucHien = new JPanel();
		pnlNgayThucHien.setLayout(null);
		pnlNgayThucHien.setBackground(new Color(237, 214, 214));
		pnlNgayThucHien.setBounds(464, 107, 380, 30);
		pnlChiaCD.add(pnlNgayThucHien);
		
		JLabel lblNgayThucHien = new JLabel("Ngày bắt đầu");
		lblNgayThucHien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayThucHien.setBounds(0, 0, 161, 30);
		pnlNgayThucHien.add(lblNgayThucHien);
		
		JDateChooser dateNgayThucHien = new JDateChooser();
		dateNgayThucHien.setBounds(160, 0, 220, 30);
		pnlNgayThucHien.add(dateNgayThucHien);
		
		JPanel pnlDonGia = new JPanel();
		pnlDonGia.setLayout(null);
		pnlDonGia.setBackground(new Color(237, 214, 214));
		pnlDonGia.setBounds(464, 148, 380, 30);
		pnlChiaCD.add(pnlDonGia);
		
		JLabel lblDonGia = new JLabel("Đơn giá");
		lblDonGia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDonGia.setBounds(0, 0, 161, 30);
		pnlDonGia.add(lblDonGia);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(160, 0, 220, 30);
		pnlDonGia.add(textField_8);
		
		JPanel pnlChucNang_1 = new JPanel();
		pnlChucNang_1.setLayout(null);
		pnlChucNang_1.setBackground(UIManager.getColor("Button.background"));
		pnlChucNang_1.setBounds(10, 214, 867, 55);
		pnlChiaCongDoan.add(pnlChucNang_1);
		
		JButton btnLamMoi_1 = new JButton("Làm mới");
		btnLamMoi_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnLamMoi_1.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\refresh.png"));
		btnLamMoi_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi_1.setBackground(new Color(30, 144, 255));
		btnLamMoi_1.setBounds(297, 11, 130, 35);
		pnlChucNang_1.add(btnLamMoi_1);
		
		JButton btnThem_1 = new JButton("Thêm");
		btnThem_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnThem_1.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\add.png"));
		btnThem_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem_1.setBackground(new Color(30, 144, 255));
		btnThem_1.setBounds(157, 11, 130, 35);
		pnlChucNang_1.add(btnThem_1);
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnXoaRong.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\bin.png"));
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoaRong.setBackground(new Color(30, 144, 255));
		btnXoaRong.setBounds(437, 11, 130, 35);
		pnlChucNang_1.add(btnXoaRong);
		
		JButton btnCapNhat_1 = new JButton("Cập nhật");
		btnCapNhat_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnCapNhat_1.setIcon(new ImageIcon("C:\\LTHSKJava\\PTUD_QuanLyLuongSanPham_Nhom16\\img\\editing.png"));
		btnCapNhat_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCapNhat_1.setBackground(new Color(30, 144, 255));
		btnCapNhat_1.setBounds(577, 11, 130, 35);
		pnlChucNang_1.add(btnCapNhat_1);
		
		JPanel pnlDanhSachChiaCD = new JPanel();
		pnlDanhSachChiaCD.setLayout(null);
		pnlDanhSachChiaCD.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00E1c s\u1EA3n ph\u1EA9m \u0111\u01B0\u1EE3c chia c\u00F4ng \u0111o\u1EA1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachChiaCD.setBackground(Color.WHITE);
		pnlDanhSachChiaCD.setBounds(10, 280, 872, 282);
		pnlChiaCongDoan.add(pnlDanhSachChiaCD);
		
		JScrollPane scrollPaneDanhSachChiaCD = new JScrollPane();
		scrollPaneDanhSachChiaCD.setBounds(10, 21, 852, 250);
		pnlDanhSachChiaCD.add(scrollPaneDanhSachChiaCD);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"STT", "M\u00E3 c\u00F4ng \u0111o\u1EA1n", "T\u00EAn c\u00F4ng \u0111o\u1EA1n", "T\u00EAn s\u1EA3n ph\u1EA9m", "Ng\u00E0y chia c\u00F4ng \u0111o\u1EA1n", "Ng\u00E0y b\u1EAFt \u0111\u1EA7u th\u1EF1c hi\u1EC7n", "\u0110\u01A1n gi\u00E1", "Tr\u1EA1ng th\u00E1i"
			}
		));
		table.getColumnModel().getColumn(6).setPreferredWidth(62);
		scrollPaneDanhSachChiaCD.setViewportView(table);
		scrollPaneDanhSachChiaCD.setVerticalScrollBar(new ScrollBarCustom());
	        
		scrollPaneDanhSachChiaCD.setHorizontalScrollBar(sp);
		
	}
}
