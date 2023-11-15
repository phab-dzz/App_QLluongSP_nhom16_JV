package App_QLLuong;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import CustomGUi.ScrollBarCustom;
import DAO.CongDoanSanPham_DAO;
import DAO.ConnectDB;
import DAO.SanPham_DAO;
import DTO.CongDoanSanPham;
import DTO.SanPham;

public class SanphamJpanel extends JPanel {

	private JTextField txtMaSanPham, txtSoLuong, txtTenSanPham, txtSoLuongCDSP;
	private JTable tableDanhSachSP, tableDanhSachCD;
	private JTextField txtTenSanPhamCD, txtSoLuongSPCD, txtMaCD, txtTenCD, txtDonGia;
	private SanPham_DAO sp_dao;
	private DefaultTableModel modelSanPham;
	private JDateChooser dateNgayChiaCD, dateNgayThucHien;
	private CongDoanSanPham_DAO cd_dao;
	private JComboBox cboMaSanPham;
	private DefaultTableModel modelCongDoan;
	private JTextField txtSoLuongTrongCD;

	public SanphamJpanel() {

		try {
			ConnectDB.getInstance().connect();
			;
		} catch (Exception e) {
			e.printStackTrace();
		}

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(920, 630);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel);

		sp_dao = new SanPham_DAO();
		cd_dao = new CongDoanSanPham_DAO();

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
		pnlThongTinSanPham.setBorder(new TitledBorder(null, "Th\u00F4ng tin chi ti\u1EBFt s\u1EA3n ph\u1EA9m",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinSanPham.setBackground(UIManager.getColor("Button.background"));
		pnlThongTinSanPham.setBounds(10, 11, 867, 102);
		pnlQuanLySanPham.add(pnlThongTinSanPham);

		JPanel pnlMaSanPham = new JPanel();
		pnlMaSanPham.setLayout(null);
		pnlMaSanPham.setBackground(new Color(240, 240, 240));
		pnlMaSanPham.setBounds(27, 20, 380, 30);
		pnlThongTinSanPham.add(pnlMaSanPham);

		JLabel lblMaSanPham = new JLabel("Mã sản phẩm");
		lblMaSanPham.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaSanPham.setBounds(0, 0, 119, 30);
		pnlMaSanPham.add(lblMaSanPham);

		txtMaSanPham = new JTextField();
		txtMaSanPham.setColumns(10);
		txtMaSanPham.setBounds(156, 0, 224, 30);
		txtMaSanPham.setEditable(false);
//		txtMaSanPham.setText("Mã được phát sinh");
		pnlMaSanPham.add(txtMaSanPham);

		JPanel pnlSoLuong = new JPanel();
		pnlSoLuong.setLayout(null);
		pnlSoLuong.setBackground(new Color(240, 240, 240));
		pnlSoLuong.setBounds(27, 61, 380, 30);
		pnlThongTinSanPham.add(pnlSoLuong);

		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoLuong.setBounds(0, 0, 161, 30);
		pnlSoLuong.add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(156, 0, 224, 30);
		pnlSoLuong.add(txtSoLuong);

		JPanel pnlTenSanPham = new JPanel();
		pnlTenSanPham.setLayout(null);
		pnlTenSanPham.setBackground(new Color(240, 240, 240));
		pnlTenSanPham.setBounds(463, 20, 380, 30);
		pnlThongTinSanPham.add(pnlTenSanPham);

		JLabel lblTenSanPham = new JLabel("Tên sản phẩm");
		lblTenSanPham.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenSanPham.setBounds(0, 0, 146, 30);
		pnlTenSanPham.add(lblTenSanPham);

		txtTenSanPham = new JTextField();
		txtTenSanPham.setColumns(10);
		txtTenSanPham.setBounds(156, 0, 224, 30);
		pnlTenSanPham.add(txtTenSanPham);

		JPanel pnlSoLuongCD = new JPanel();
		pnlSoLuongCD.setLayout(null);
		pnlSoLuongCD.setBackground(new Color(240, 240, 240));
		pnlSoLuongCD.setBounds(463, 61, 380, 30);
		pnlThongTinSanPham.add(pnlSoLuongCD);

		JLabel lblSLngCng = new JLabel("Số lượng công đoạn");
		lblSLngCng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSLngCng.setBounds(0, 0, 190, 30);
		pnlSoLuongCD.add(lblSLngCng);

		txtSoLuongCDSP = new JTextField();
		txtSoLuongCDSP.setColumns(10);
		txtSoLuongCDSP.setBounds(156, 0, 224, 30);
		pnlSoLuongCD.add(txtSoLuongCDSP);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBackground(UIManager.getColor("Button.background"));
		pnlChucNang.setBounds(10, 124, 867, 55);
		pnlQuanLySanPham.add(pnlChucNang);

		// TÌM KIẾM BẰNG MÃ SẢN PHẨM

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBackground(new Color(240, 240, 240));
		pnlTimKiem.setBounds(10, 11, 227, 35);
		pnlChucNang.add(pnlTimKiem);

		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(0, 0, 89, 35);
		pnlTimKiem.add(lblTimKiem);

		JComboBox cboTimKiem = new JComboBox();
		cboTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		cboTimKiem.setBackground(new Color(255, 255, 255));
		cboTimKiem.setBorder(null);
		cboTimKiem.setAutoscrolls(true);
		cboTimKiem.setBounds(80, 0, 147, 35);
		pnlTimKiem.add(cboTimKiem);

		DefaultComboBoxModel<String> timKiemMaSP = new DefaultComboBoxModel<String>();
		timKiemMaSP.addElement("Chọn mã sản phẩm");
		ArrayList<SanPham> danhSachTimKiemSP = sp_dao.getAllSanPham();
		if (danhSachTimKiemSP != null) {
			for (SanPham sp : danhSachTimKiemSP) {
				timKiemMaSP.addElement(sp.getMaSanPham());
			}
		} else {
			timKiemMaSP.addElement("Không có dữ liệu");
		}

		cboTimKiem.setModel(timKiemMaSP);

		cboTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String timMa = cboTimKiem.getSelectedItem().toString();
					List<SanPham> danhSachSanPhamTimTheoMa = null;
					if (!timMa.equals("Chọn mã sản phẩm")) {
						danhSachSanPhamTimTheoMa = sp_dao.getSanPhamTheoMa(timMa);
						if (danhSachSanPhamTimTheoMa == null)
							JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
						int i = 1;
						XoahetDuLieuTrenTable();
						for (SanPham sp : danhSachSanPhamTimTheoMa) {
							modelSanPham.addRow(new Object[] { i++, sp.getMaSanPham(), sp.getTenSanPham(),
									sp.getSoLuong(), sp.getSoLuongCongDoan() });
						}
					}
				} catch (Exception e2) {

					e2.printStackTrace();
				}

			}
		});

		JButton btnThemSP = new JButton("Thêm");
		btnThemSP.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/Icons/chamcong/them.png")));
		btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemSP.setBackground(new Color(100, 149, 237));
		btnThemSP.setBounds(278, 11, 130, 35);
		pnlChucNang.add(btnThemSP);

		btnThemSP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ThemSanPhamMoi();
			}
		});

		JButton btnLamMoiSP = new JButton("Làm mới");
		btnLamMoiSP.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/Icons/icons_sp/refresh.png")));
		btnLamMoiSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoiSP.setBackground(new Color(100, 149, 237));
		btnLamMoiSP.setBounds(428, 11, 130, 35);
		pnlChucNang.add(btnLamMoiSP);

		btnLamMoiSP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				XoahetDuLieuTrenTable();
				DocDuLieuDanhSachSP();
			}
		});

		JButton btnCapNhatSP = new JButton("Cập nhật");
		btnCapNhatSP.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/Icons/icons_sp/editing.png")));
		btnCapNhatSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCapNhatSP.setBackground(new Color(100, 149, 237));
		btnCapNhatSP.setBounds(727, 11, 130, 35);
		pnlChucNang.add(btnCapNhatSP);

		btnCapNhatSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CapNhatSanPham();
			}
		});

		JButton btnXoaRongSP = new JButton("Xóa rỗng");
		btnXoaRongSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoaRongSP.setBackground(new Color(100, 149, 237));
		btnXoaRongSP.setBounds(577, 11, 130, 35);
		pnlChucNang.add(btnXoaRongSP);

		btnXoaRongSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				XoaRongSP();
			}
		});

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(707, 11, 20, 35);
		pnlChucNang.add(horizontalStrut_1);

		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		horizontalStrut_1_2.setBounds(557, 11, 20, 35);
		pnlChucNang.add(horizontalStrut_1_2);

		Component horizontalStrut_1_2_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1_2_1.setBounds(408, 11, 20, 35);
		pnlChucNang.add(horizontalStrut_1_2_1);

		JPanel pnlDanhSachSanPham = new JPanel();
		pnlDanhSachSanPham.setLayout(null);
		pnlDanhSachSanPham.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00E1c s\u1EA3n ph\u1EA9m",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachSanPham.setBackground(Color.WHITE);
		pnlDanhSachSanPham.setBounds(10, 190, 867, 372);
		pnlQuanLySanPham.add(pnlDanhSachSanPham);

		JScrollPane scrollPaneDanhSachSanPham = new JScrollPane();
		scrollPaneDanhSachSanPham.setBounds(10, 18, 847, 343);
		pnlDanhSachSanPham.add(scrollPaneDanhSachSanPham);

		tableDanhSachSP = new JTable();
		tableDanhSachSP.setModel(modelSanPham = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"S\u1ED1 l\u01B0\u1EE3ng s\u1EA3n ph\u1EA9m",
						"S\u1ED1 l\u01B0\u1EE3ng c\u00F4ng \u0111o\u1EA1n" }));

		scrollPaneDanhSachSanPham.setViewportView(tableDanhSachSP);
		scrollPaneDanhSachSanPham.setVerticalScrollBar(new ScrollBarCustom());
		ScrollBarCustom sp = new ScrollBarCustom();
		sp.setOrientation(JScrollBar.HORIZONTAL);
		scrollPaneDanhSachSanPham.setHorizontalScrollBar(sp);

		JPanel pnlChiaCongDoan = new JPanel();
		tabSanPham.addTab("Chia công đoạn sản phẩm", null, pnlChiaCongDoan, null);
		pnlChiaCongDoan.setLayout(null);

		JPanel pnlChiaCD = new JPanel();
		pnlChiaCD.setLayout(null);
		pnlChiaCD.setBorder(new TitledBorder(null, "Ph\u00E2n chia c\u00F4ng \u0111o\u1EA1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlChiaCD.setBackground(UIManager.getColor("Button.background"));
		pnlChiaCD.setBounds(10, 11, 867, 214);
		pnlChiaCongDoan.add(pnlChiaCD);

		JPanel pnlMaSanPham_1 = new JPanel();
		pnlMaSanPham_1.setLayout(null);
		pnlMaSanPham_1.setBackground(new Color(240, 240, 240));
		pnlMaSanPham_1.setBounds(22, 25, 380, 30);
		pnlChiaCD.add(pnlMaSanPham_1);

		JLabel lblMaSanPhamCD = new JLabel("Mã sản phẩm");
		lblMaSanPhamCD.setBackground(new Color(240, 240, 240));
		lblMaSanPhamCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaSanPhamCD.setBounds(0, 0, 161, 30);
		pnlMaSanPham_1.add(lblMaSanPhamCD);

		cboMaSanPham = new JComboBox();
		cboMaSanPham.setBackground(new Color(240, 240, 240));
		cboMaSanPham.setAutoscrolls(true);
		cboMaSanPham.setBorder(null);
		cboMaSanPham.setBounds(160, 0, 220, 30);
		cboMaSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = (String) cboMaSanPham.getSelectedItem();
				ArrayList<SanPham> danhSachSanPham = sp_dao.getSanPhamTheoMa(ma);
				for (SanPham sp : danhSachSanPham) {
					txtTenSanPhamCD.setText(sp.getTenSanPham());
					txtSoLuongSPCD.setText(Integer.toString(sp.getSoLuong()));
				}
			}
		});
		pnlMaSanPham_1.add(cboMaSanPham);

		DefaultComboBoxModel<String> duLieuMaSP = new DefaultComboBoxModel<String>();
		duLieuMaSP.addElement("Chọn mã sản phẩm");
		ArrayList<SanPham> danhSachSanPham = sp_dao.getAllSanPham();
		if (danhSachSanPham != null) {
			for (SanPham sanPham : danhSachSanPham) {
				duLieuMaSP.addElement(sanPham.getMaSanPham());
			}
		} else {
			duLieuMaSP.addElement("Không có dữ liệu");
		}
		cboMaSanPham.setModel(duLieuMaSP);

		JPanel pnlTenSanPham_1 = new JPanel();
		pnlTenSanPham_1.setLayout(null);
		pnlTenSanPham_1.setBackground(new Color(240, 240, 240));
		pnlTenSanPham_1.setBounds(22, 66, 380, 30);
		pnlChiaCD.add(pnlTenSanPham_1);

		JLabel lblTenSanPhamCD = new JLabel("Tên sản phẩm");
		lblTenSanPhamCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenSanPhamCD.setBounds(0, 0, 161, 30);
		pnlTenSanPham_1.add(lblTenSanPhamCD);

		txtTenSanPhamCD = new JTextField();
		txtTenSanPhamCD.setEditable(false);
		txtTenSanPhamCD.setColumns(10);
		txtTenSanPhamCD.setBounds(160, 0, 220, 30);
		pnlTenSanPham_1.add(txtTenSanPhamCD);

		JPanel pnlSoLuong_1 = new JPanel();
		pnlSoLuong_1.setLayout(null);
		pnlSoLuong_1.setBackground(new Color(240, 240, 240));
		pnlSoLuong_1.setBounds(22, 107, 380, 30);
		pnlChiaCD.add(pnlSoLuong_1);

		JLabel lblSoLuongCD = new JLabel("Số lượng sản phẩm");
		lblSoLuongCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoLuongCD.setBounds(0, 0, 161, 30);
		pnlSoLuong_1.add(lblSoLuongCD);

		txtSoLuongSPCD = new JTextField();
		txtSoLuongSPCD.setEditable(false);
		txtSoLuongSPCD.setColumns(10);
		txtSoLuongSPCD.setBounds(160, 0, 220, 30);
		pnlSoLuong_1.add(txtSoLuongSPCD);

		JPanel pnlNgayChiaCD = new JPanel();
		pnlNgayChiaCD.setLayout(null);
		pnlNgayChiaCD.setBackground(new Color(240, 240, 240));
		pnlNgayChiaCD.setBounds(22, 148, 380, 30);
		pnlChiaCD.add(pnlNgayChiaCD);

		JLabel lblNgayChiaCD = new JLabel("Ngày chia công đoạn");
		lblNgayChiaCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayChiaCD.setBounds(0, 0, 161, 30);
		pnlNgayChiaCD.add(lblNgayChiaCD);

		dateNgayChiaCD = new JDateChooser();
		java.util.Date date = new java.util.Date();
		dateNgayChiaCD.setDate(date);
		dateNgayChiaCD.setDateFormatString("dd/MM/yyyy");
		dateNgayChiaCD.setBounds(160, 0, 220, 30);
		pnlNgayChiaCD.add(dateNgayChiaCD);

		JPanel pnlMaCongDoan = new JPanel();
		pnlMaCongDoan.setLayout(null);
		pnlMaCongDoan.setBackground(new Color(240, 240, 240));
		pnlMaCongDoan.setBounds(464, 11, 380, 30);
		pnlChiaCD.add(pnlMaCongDoan);

		JLabel lblMaCongDoan = new JLabel("Mã công đoạn");
		lblMaCongDoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaCongDoan.setBounds(0, 0, 161, 30);
		pnlMaCongDoan.add(lblMaCongDoan);

		txtMaCD = new JTextField();
		txtMaCD.setColumns(10);
		txtMaCD.setBounds(191, 0, 189, 30);
		txtMaCD.setEditable(false);
		pnlMaCongDoan.add(txtMaCD);

		JPanel pnlTenCongDoan = new JPanel();
		pnlTenCongDoan.setLayout(null);
		pnlTenCongDoan.setBackground(new Color(240, 240, 240));
		pnlTenCongDoan.setBounds(464, 52, 380, 30);
		pnlChiaCD.add(pnlTenCongDoan);

		JLabel lblTenCongDoan = new JLabel("Tên công đoạn");
		lblTenCongDoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenCongDoan.setBounds(0, 0, 161, 30);
		pnlTenCongDoan.add(lblTenCongDoan);

		txtTenCD = new JTextField();
		txtTenCD.setColumns(10);
		txtTenCD.setBounds(190, 0, 190, 30);
		pnlTenCongDoan.add(txtTenCD);

		JPanel pnlNgayThucHien = new JPanel();
		pnlNgayThucHien.setLayout(null);
		pnlNgayThucHien.setBackground(new Color(240, 240, 240));
		pnlNgayThucHien.setBounds(464, 93, 380, 30);
		pnlChiaCD.add(pnlNgayThucHien);

		JLabel lblNgayThucHien = new JLabel("Ngày bắt đầu");
		lblNgayThucHien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayThucHien.setBounds(0, 0, 161, 30);
		pnlNgayThucHien.add(lblNgayThucHien);

		dateNgayThucHien = new JDateChooser();
		dateNgayThucHien.setDateFormatString("dd/MM/yyyy");
		dateNgayThucHien.setBounds(190, 0, 190, 30);
		pnlNgayThucHien.add(dateNgayThucHien);

		JPanel pnlDonGia = new JPanel();
		pnlDonGia.setLayout(null);
		pnlDonGia.setBackground(new Color(240, 240, 240));
		pnlDonGia.setBounds(464, 134, 380, 30);
		pnlChiaCD.add(pnlDonGia);

		JLabel lblDonGia = new JLabel("Đơn giá");
		lblDonGia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDonGia.setBounds(0, 0, 161, 30);
		pnlDonGia.add(lblDonGia);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(192, 0, 188, 30);
		pnlDonGia.add(txtDonGia);

		JPanel pnlDonGia_1 = new JPanel();
		pnlDonGia_1.setLayout(null);
		pnlDonGia_1.setBackground(UIManager.getColor("Button.background"));
		pnlDonGia_1.setBounds(464, 175, 380, 30);
		pnlChiaCD.add(pnlDonGia_1);

		JLabel lblSoLuongTrongCD = new JLabel("Số lượng trong công đoạn");
		lblSoLuongTrongCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoLuongTrongCD.setBounds(0, 0, 188, 30);
		pnlDonGia_1.add(lblSoLuongTrongCD);

		txtSoLuongTrongCD = new JTextField();
		txtSoLuongTrongCD.setColumns(10);
		txtSoLuongTrongCD.setBounds(192, 0, 188, 30);
		pnlDonGia_1.add(txtSoLuongTrongCD);

		JPanel pnlChucNang_1 = new JPanel();
		pnlChucNang_1.setLayout(null);
		pnlChucNang_1.setBackground(UIManager.getColor("Button.background"));
		pnlChucNang_1.setBounds(10, 236, 867, 40);
		pnlChiaCongDoan.add(pnlChucNang_1);

		JButton btnLamMoiCD = new JButton("Làm mới");
		btnLamMoiCD.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/Icons/icons_sp/refresh.png")));
		btnLamMoiCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoiCD.setBackground(new Color(100, 149, 237));
		btnLamMoiCD.setBounds(283, 11, 130, 23);
		pnlChucNang_1.add(btnLamMoiCD);

		btnLamMoiCD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				XoaDuLieuTableCongDoansP();
				DocDuLieuCongDoanSP();
			}
		});

		JButton btnThemCD = new JButton("Thêm");
		btnThemCD.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/Icons/chamcong/them.png")));
		btnThemCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemCD.setBackground(new Color(100, 149, 237));
		btnThemCD.setBounds(113, 11, 130, 23);
		pnlChucNang_1.add(btnThemCD);

		btnThemCD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ThemCongDoan();
			}
		});

		JButton btnXoaRongCD = new JButton("Xóa rỗng");
		btnXoaRongCD.setIcon(new ImageIcon("C:\\LTHSKJava\\Nhom16_PTUD_QuanLyLuongSanPham\\img\\icons_sp\\bin.png"));
		btnXoaRongCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoaRongCD.setBackground(new Color(100, 149, 237));
		btnXoaRongCD.setBounds(453, 11, 130, 23);
		pnlChucNang_1.add(btnXoaRongCD);

		btnXoaRongCD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				XoaRongCD();
			}
		});

		JButton btnCapNhatCD = new JButton("Cập nhật");
		btnCapNhatCD.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/Icons/icons_sp/editing.png")));
		btnCapNhatCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCapNhatCD.setBackground(new Color(100, 149, 237));
		btnCapNhatCD.setBounds(623, 11, 130, 23);
		pnlChucNang_1.add(btnCapNhatCD);

		btnCapNhatCD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CapNhatCongDoan();
			}
		});

		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1_1.setBounds(253, 11, 20, 35);
		pnlChucNang_1.add(horizontalStrut_1_1);

		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1_1_1.setBounds(423, 11, 20, 35);
		pnlChucNang_1.add(horizontalStrut_1_1_1);

		Component horizontalStrut_1_1_1_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1_1_1_1.setBounds(593, 11, 20, 35);
		pnlChucNang_1.add(horizontalStrut_1_1_1_1);

		JPanel pnlDanhSachChiaCD = new JPanel();
		pnlDanhSachChiaCD.setLayout(null);
		pnlDanhSachChiaCD.setBorder(new TitledBorder(null,
				"Danh s\u00E1ch c\u00E1c s\u1EA3n ph\u1EA9m \u0111\u01B0\u1EE3c chia c\u00F4ng \u0111o\u1EA1n",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachChiaCD.setBackground(Color.WHITE);
		pnlDanhSachChiaCD.setBounds(10, 280, 872, 282);
		pnlChiaCongDoan.add(pnlDanhSachChiaCD);

		JScrollPane scrollPaneDanhSachChiaCD = new JScrollPane();
		scrollPaneDanhSachChiaCD.setBounds(10, 21, 852, 250);
		pnlDanhSachChiaCD.add(scrollPaneDanhSachChiaCD);

		tableDanhSachCD = new JTable();
		tableDanhSachCD.setModel(
				modelCongDoan = new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Mã CD", "Tên công đoạn",
						"Tên sản phẩm", "Ngày chia CD", "Ngày thực hiện", "Đơn giá", "Số lương trong công đoạn" }));

		scrollPaneDanhSachChiaCD.setViewportView(tableDanhSachCD);
		scrollPaneDanhSachChiaCD.setVerticalScrollBar(new ScrollBarCustom());
		scrollPaneDanhSachChiaCD.setHorizontalScrollBar(sp);

		tableDanhSachSP.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableDanhSachSP.getSelectedRow();
				txtMaSanPham.setText(tableDanhSachSP.getValueAt(row, 1).toString());
				txtTenSanPham.setText(tableDanhSachSP.getValueAt(row, 2).toString());
				txtSoLuong.setText(tableDanhSachSP.getValueAt(row, 3).toString());
				txtSoLuongCDSP.setText(tableDanhSachSP.getValueAt(row, 4).toString());

			}
		});

		tableDanhSachCD.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<SanPham> danhSachSP = new ArrayList<SanPham>();
				ArrayList<CongDoanSanPham> danhSachCD = new ArrayList<CongDoanSanPham>();

				int row = tableDanhSachCD.getSelectedRow();
				txtMaCD.setText(tableDanhSachCD.getValueAt(row, 1).toString());
				String maCD = txtMaCD.getText();
				cboMaSanPham.setSelectedItem(cd_dao.maSPtheomaCD(maCD));
				txtTenCD.setText(tableDanhSachCD.getValueAt(row, 2).toString());
				txtTenSanPhamCD.setText(tableDanhSachCD.getValueAt(row, 3).toString());
				dateNgayChiaCD.setDate((Date) tableDanhSachCD.getValueAt(row, 4));
				dateNgayThucHien.setDate((Date) tableDanhSachCD.getValueAt(row, 5));
				txtDonGia.setText(tableDanhSachCD.getValueAt(row, 6).toString());
				txtSoLuongTrongCD.setText(tableDanhSachCD.getValueAt(row, 7).toString());
			}

		});
		DocDuLieuDanhSachSP();
		DocDuLieuCongDoanSP();
	}

	private void DocDuLieuDanhSachSP() {
		List<SanPham> list = sp_dao.getAllSanPham();
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableDanhSachSP.getModel());
		tableDanhSachSP.setRowSorter(sorter);
		int i = 1;
		for (SanPham sp : list) {
			modelSanPham.addRow(new Object[] { i++, sp.getMaSanPham(), sp.getTenSanPham(), sp.getSoLuongCongDoan(),
					sp.getSoLuong() });
		}
	}

	private void DocDuLieuCongDoanSP() {
		List<CongDoanSanPham> danhSachCD = cd_dao.getAllCongDoanSanPham();
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableDanhSachCD.getModel());
		tableDanhSachCD.setRowSorter(sorter);
		int i = 1;
		ArrayList<SanPham> danhSachSP = new ArrayList<SanPham>();
		for (CongDoanSanPham cd : danhSachCD) {
			danhSachSP = sp_dao.getSanPhamTheoMa(cd.getSanPham().getMaSanPham());
			for (SanPham sp : danhSachSP) {
				modelCongDoan.addRow(new Object[] { i++, cd.getMaCongDoan(), cd.getTenCongDoan(), sp.getTenSanPham(),
						cd.getNgayBatDau(), cd.getNgayChiaCD(), cd.getDonGia(), cd.getSoLuong() });
			}
		}
	}

	private void XoahetDuLieuTrenTable() {
		DefaultTableModel md = (DefaultTableModel) tableDanhSachSP.getModel();
		md.getDataVector().removeAllElements();
	}

	private void XoaDuLieuTableCongDoansP() {
		DefaultTableModel md = (DefaultTableModel) tableDanhSachCD.getModel();
		md.getDataVector().removeAllElements();
	}

	private String maSanPham() {
		String maSP = sp_dao.phatSinhMaSanPhamMoi();

		return maSP;
	}

	private String maCongDoan() {
		String maCD = cd_dao.phatSinhMaCongDoan();
		return maCD;
	}

	private void ThemSanPhamMoi() {
		if (KiemTraDuLieuSP()) {
			String maSP = maSanPham();
			String tenSP = txtTenSanPham.getText();
			int sl = Integer.parseInt(txtSoLuongCDSP.getText());
			int slCDofSP = Integer.parseInt(txtSoLuong.getText());

			SanPham sp = new SanPham(maSP, tenSP, sl, slCDofSP);

			try {
				sp_dao.create(sp);
				XoahetDuLieuTrenTable();
				DocDuLieuDanhSachSP();
			} catch (Exception e) {

			}
		}
	}

	private void ThemCongDoan() {
		if (KiemTraDuLieuCD()) {
			String maSP = (String) cboMaSanPham.getSelectedItem();
			SanPham sp = new SanPham(maSP);
			String maCD = maCongDoan();
			String tenCD = txtTenCD.getText();
			Date ngayChiaCD = new Date(dateNgayChiaCD.getDate().getTime());
			Date ngayThucHien = new Date(dateNgayThucHien.getDate().getTime());
			float donGia = Float.parseFloat(txtDonGia.getText());
			int soLuongTrongCD = Integer.parseInt(txtSoLuongTrongCD.getText());

			CongDoanSanPham cd = new CongDoanSanPham(maCD, tenCD, sp, ngayChiaCD, ngayThucHien, donGia, soLuongTrongCD);

			try {
				cd_dao.create(cd);
				XoaDuLieuTableCongDoansP();
				DocDuLieuCongDoanSP();
			} catch (Exception e) {
			}
		}
	}

	private void XoaRongSP() {
		txtMaSanPham.setText("");
		txtTenSanPham.setText("");
		txtSoLuong.setText("");
		txtSoLuongCDSP.setText("");
	}

	private void XoaRongCD() {
		txtMaCD.setText("");
		txtTenSanPhamCD.setText("");
		txtTenCD.setText("");
		txtSoLuongSPCD.setText("");
		txtDonGia.setText("");
		txtSoLuongTrongCD.setText("");
	}

	private void CapNhatSanPham() {
		String maSP = txtMaSanPham.getText();
		String tenSP = txtTenSanPham.getText();
		int soLuongSP = Integer.parseInt(txtSoLuong.getText());
		int soLuongCD = Integer.parseInt(txtSoLuongCDSP.getText());
		SanPham sanPham = new SanPham(maSP, tenSP, soLuongSP, soLuongCD);
		try {
			if (sp_dao.update(sanPham)) {
				JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công!");
				XoahetDuLieuTrenTable();
				DocDuLieuDanhSachSP();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
		}
	}

	private void CapNhatCongDoan() {
		String maSP = (String) cboMaSanPham.getSelectedItem();
		SanPham sp = new SanPham(maSP);
		String maCD = txtMaCD.getText();
		String tenCD = txtTenCD.getText();
		Date dateChiaCD = new Date(dateNgayChiaCD.getDate().getTime());
		Date dateTH = new Date(dateNgayThucHien.getDate().getTime());
		float donGia = Float.parseFloat(txtDonGia.getText());
		int soLuongTrongCD = Integer.parseInt(txtSoLuongTrongCD.getText());
		CongDoanSanPham cd = new CongDoanSanPham(maCD, tenCD, sp, dateChiaCD, dateTH, donGia, soLuongTrongCD);
		try {
//			JOptionPane.showMessageDialog(null, "Err");
			if (cd_dao.update(cd)) {
				JOptionPane.showMessageDialog(this, "Cập nhật công đoạn thành công!");
				XoaDuLieuTableCongDoansP();
				DocDuLieuCongDoanSP();
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
		}
	}

	private boolean KiemTraDuLieuSP() {
		String tenSP = txtTenSanPham.getText();
		String slString = txtSoLuong.getText();
		int slCD = Integer.parseInt(txtSoLuongCDSP.getText());

		if (!(tenSP.length() > 0 && tenSP.matches("^[\\p{L}' ]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên sản phẩm không hợp lệ!");
			txtTenSanPham.selectAll();
			txtTenSanPham.requestFocus();
			return false;
		}

		if (slString.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nhập số lượng sản phẩm");
			txtSoLuong.selectAll();
			txtSoLuong.requestFocus();
			return false;
		} else if (Integer.valueOf(slString) <= 0) {
			JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!");
			txtSoLuong.selectAll();
			txtSoLuong.requestFocus();
			return false;
		}

		if (slCD <= 0) {
			JOptionPane.showMessageDialog(null, "Số lượng của công đoạn không hợp lệ!");
			return false;
		}
		return true;
	}

	private boolean KiemTraDuLieuCD() {
		String tenCD = txtTenCD.getText();
		String donGia = txtDonGia.getText();
		String tenSP = txtTenSanPhamCD.getText();
		String SoLuongTrongCD = txtSoLuongTrongCD.getText();

		if (tenCD.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm cần chia công đoạn!");
//			txtDonGia.selectAll();
//			txtDonGia.requestFocus();
			return false;
		}

		if (!(tenCD.length() > 0 && tenCD.matches("^[\\p{L}' ]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên công đoạn không hợp lệ!");
			txtTenCD.selectAll();
			txtTenCD.requestFocus();
			return false;
		}

		if (donGia.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nhập đơn giá cho công đoạn!");
			txtDonGia.selectAll();
			txtDonGia.requestFocus();
			return false;
		} else if (Float.valueOf(donGia) <= 0) {
			JOptionPane.showMessageDialog(null, "Đơn giá không hợp lệ!");
			txtDonGia.selectAll();
			txtDonGia.requestFocus();
			return false;
		}
		if (SoLuongTrongCD.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nhập số lượng công đoạn!");
			txtSoLuongCDSP.selectAll();
			txtSoLuongCDSP.requestFocus();
			return false;
		} else if (Integer.parseInt(SoLuongTrongCD) <= 0) {
			JOptionPane.showMessageDialog(null, "Số lượng công đoạn không hợp lệ!");
			txtSoLuongCDSP.selectAll();
			txtSoLuongCDSP.requestFocus();
			return false;
		}

		try {
			Date ngayChiaCD = new Date(dateNgayChiaCD.getDate().getTime());
			Date ngayThucHien = new Date(dateNgayThucHien.getDate().getTime());
			long millis = System.currentTimeMillis();
			java.sql.Date ngayHienTai = new java.sql.Date(millis);

			if (ngayThucHien.before(ngayHienTai)) {
				JOptionPane.showMessageDialog(null, "Ngày thực hiện phải sau ngày hiện tại!");
				dateNgayThucHien.requestFocus();
				return false;
			} else if (ngayThucHien.before(ngayChiaCD)) {
				JOptionPane.showMessageDialog(null, "Ngày thực hiện phải sau ngày chia công đoạn");
				dateNgayThucHien.requestFocus();
				return false;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ngày thực hiện không hợp lệ!");
		}

		return true;
	}
}