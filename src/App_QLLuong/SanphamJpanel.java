package App_QLLuong;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import CustomGUi.CustomDialog;
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
	private DefaultTableCellRenderer centerRenderer;
	private DefaultTableCellRenderer headerRenderer;
	private DefaultTableCellRenderer cellRenderer;
	private JTextField txtTrangThaiSP;
	private JTextField txtDoUuTien;
	private JTextField txtTrangThaiCD;
	private JComboBox cboChuyenMonCD;

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
		panel.setBackground(new Color(0, 0, 128));
		add(panel);

		sp_dao = new SanPham_DAO();
		cd_dao = new CongDoanSanPham_DAO();

		panel.setBounds(0, 0, 912, 623);

		panel.setLayout(null);

		JTabbedPane tabSanPham = new JTabbedPane(JTabbedPane.TOP);
		tabSanPham.setBackground(new Color(0, 0, 128));
		tabSanPham.setUI(new CustomGUi.CustomTabbedPaneUI());
		tabSanPham.setUI(new CustomGUi.CustomTabbedPaneUI());
		tabSanPham.setBounds(10, 11, 900, 608);
		panel.add(tabSanPham);

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

		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		ScrollBarCustom sp = new ScrollBarCustom();
		sp.setOrientation(JScrollBar.HORIZONTAL);

		JPanel pnlQuanLySanPham = new JPanel();
		tabSanPham.addTab("Quản lý sản phẩm", null, pnlQuanLySanPham, null);
		pnlQuanLySanPham.setLayout(null);

		JPanel pnlThongTinSanPham = new JPanel();
		pnlThongTinSanPham.setLayout(null);
		pnlThongTinSanPham.setBorder(new TitledBorder(null, "Th\u00F4ng tin chi ti\u1EBFt s\u1EA3n ph\u1EA9m",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTinSanPham.setBackground(UIManager.getColor("Button.background"));
		pnlThongTinSanPham.setBounds(10, 11, 875, 104);
		pnlQuanLySanPham.add(pnlThongTinSanPham);

		JPanel pnlMaSanPham = new JPanel();
		pnlMaSanPham.setLayout(null);
		pnlMaSanPham.setBackground(UIManager.getColor("Button.background"));
		pnlMaSanPham.setBounds(27, 20, 380, 30);
		pnlThongTinSanPham.add(pnlMaSanPham);

		JLabel lblMaSanPham = new JLabel("Mã sản phẩm");
		lblMaSanPham.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaSanPham.setBounds(0, 0, 102, 30);
		pnlMaSanPham.add(lblMaSanPham);

		txtMaSanPham = new JTextField();
		txtMaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaSanPham.setColumns(10);
		txtMaSanPham.setBounds(156, 0, 224, 30);
		txtMaSanPham.setEditable(false);
		// txtMaSanPham.setText("Mã được phát sinh");
		pnlMaSanPham.add(txtMaSanPham);

		JPanel pnlSoLuong = new JPanel();
		pnlSoLuong.setLayout(null);
		pnlSoLuong.setBackground(UIManager.getColor("Button.background"));
		pnlSoLuong.setBounds(27, 60, 137, 30);
		pnlThongTinSanPham.add(pnlSoLuong);

		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoLuong.setBounds(0, 0, 66, 30);
		pnlSoLuong.add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(76, 0, 60, 30);
		pnlSoLuong.add(txtSoLuong);

		JPanel pnlTenSanPham = new JPanel();
		pnlTenSanPham.setLayout(null);
		pnlTenSanPham.setBackground(UIManager.getColor("Button.background"));
		pnlTenSanPham.setBounds(465, 20, 380, 30);
		pnlThongTinSanPham.add(pnlTenSanPham);

		JLabel lblTenSanPham = new JLabel("Tên sản phẩm");
		lblTenSanPham.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenSanPham.setBounds(0, 0, 107, 30);
		pnlTenSanPham.add(lblTenSanPham);

		txtTenSanPham = new JTextField();
		txtTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenSanPham.setColumns(10);
		txtTenSanPham.setBounds(156, 0, 224, 30);
		pnlTenSanPham.add(txtTenSanPham);

		JPanel pnlSoLuongCD = new JPanel();
		pnlSoLuongCD.setLayout(null);
		pnlSoLuongCD.setBackground(UIManager.getColor("Button.background"));
		pnlSoLuongCD.setBounds(465, 60, 380, 30);
		pnlThongTinSanPham.add(pnlSoLuongCD);

		JLabel lblSLngCng = new JLabel("Số lượng công đoạn");
		lblSLngCng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSLngCng.setBounds(0, 0, 141, 30);
		pnlSoLuongCD.add(lblSLngCng);

		txtSoLuongCDSP = new JTextField();
		txtSoLuongCDSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoLuongCDSP.setColumns(10);
		txtSoLuongCDSP.setBounds(156, 0, 224, 30);
		pnlSoLuongCD.add(txtSoLuongCDSP);

		JPanel pnlTrangThaiSP = new JPanel();
		pnlTrangThaiSP.setLayout(null);
		pnlTrangThaiSP.setBackground(SystemColor.menu);
		pnlTrangThaiSP.setBounds(183, 61, 224, 30);
		pnlThongTinSanPham.add(pnlTrangThaiSP);

		JLabel lblTrangThaiSP = new JLabel("Trạng thái");
		lblTrangThaiSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTrangThaiSP.setBounds(0, 0, 77, 30);
		pnlTrangThaiSP.add(lblTrangThaiSP);

		txtTrangThaiSP = new JTextField();
		txtTrangThaiSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTrangThaiSP.setColumns(10);
		txtTrangThaiSP.setBounds(76, 0, 148, 30);
		pnlTrangThaiSP.add(txtTrangThaiSP);

		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBackground(UIManager.getColor("Button.background"));
		pnlChucNang.setBounds(10, 120, 875, 55);
		pnlQuanLySanPham.add(pnlChucNang);

		// TÌM KIẾM BẰNG MÃ SẢN PHẨM

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBackground(new Color(240, 240, 240));
		pnlTimKiem.setBounds(10, 11, 227, 35);
		pnlChucNang.add(pnlTimKiem);

		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTimKiem.setBounds(0, 0, 65, 35);
		pnlTimKiem.add(lblTimKiem);

		JComboBox cboTimKiem = new JComboBox();
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboTimKiem.setBackground(new Color(255, 255, 255));
		cboTimKiem.setBorder(null);
		cboTimKiem.setAutoscrolls(true);
		cboTimKiem.setBounds(80, 0, 147, 35);
		pnlTimKiem.add(cboTimKiem);

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
//						JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
							new CustomDialog("Không có dữ liệu!",CustomDialog.ERROR_DIALOG);
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
		btnThemSP.setForeground(new Color(255, 255, 255));
		btnThemSP.setBorder(null);
		btnThemSP.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/img/add-product.png")));
		btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemSP.setBackground(new Color(154, 205, 50));
		btnThemSP.setBounds(288, 11, 130, 35);
		pnlChucNang.add(btnThemSP);

		btnThemSP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ThemSanPhamMoi();
			}
		});

		JButton btnLamMoiSP = new JButton("Làm mới");
		btnLamMoiSP.setForeground(new Color(255, 255, 255));
		btnLamMoiSP.setBorder(null);
		btnLamMoiSP.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/img/reload.png")));
		btnLamMoiSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLamMoiSP.setBackground(new Color(51, 204, 255));
		btnLamMoiSP.setBounds(438, 11, 130, 35);
		pnlChucNang.add(btnLamMoiSP);

		btnLamMoiSP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				XoahetDuLieuTrenTable();
				DocDuLieuDanhSachSP();
			}
		});

		JButton btnCapNhatSP = new JButton("Cập nhật");
		btnCapNhatSP.setForeground(new Color(255, 255, 255));
		btnCapNhatSP.setBorder(null);
		btnCapNhatSP.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/img/update.png")));
		btnCapNhatSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhatSP.setBackground(Color.BLUE);
		btnCapNhatSP.setBounds(735, 11, 130, 35);
		pnlChucNang.add(btnCapNhatSP);

		btnCapNhatSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CapNhatSanPham();
			}
		});

		JButton btnXoaRongSP = new JButton("Xóa rỗng");
		btnXoaRongSP.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/img/trash-bin.png")));
		btnXoaRongSP.setForeground(new Color(255, 255, 255));
		btnXoaRongSP.setBorder(null);
		btnXoaRongSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaRongSP.setBackground(Color.RED);
		btnXoaRongSP.setBounds(587, 11, 130, 35);
		pnlChucNang.add(btnXoaRongSP);

		btnXoaRongSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				XoaRongSP();
			}
		});

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(717, 11, 20, 35);
		pnlChucNang.add(horizontalStrut_1);

		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		horizontalStrut_1_2.setBounds(567, 11, 20, 35);
		pnlChucNang.add(horizontalStrut_1_2);

		Component horizontalStrut_1_2_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1_2_1.setBounds(418, 11, 20, 35);
		pnlChucNang.add(horizontalStrut_1_2_1);

		JPanel pnlDanhSachSanPham = new JPanel();
		pnlDanhSachSanPham.setLayout(null);
		pnlDanhSachSanPham.setBorder(
				new TitledBorder(null, "Danh sách sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachSanPham.setBackground(Color.WHITE);
		pnlDanhSachSanPham.setBounds(10, 186, 875, 383);
		pnlQuanLySanPham.add(pnlDanhSachSanPham);

		JScrollPane scrollPaneDanhSachSanPham = new JScrollPane();
		scrollPaneDanhSachSanPham.setBounds(10, 18, 855, 354);
		pnlDanhSachSanPham.add(scrollPaneDanhSachSanPham);

//		cellRenderer = new DefaultTableCellRenderer();
//		cellRenderer.setBorder(new EmptyBorder(1, 10, 1, 1));

		tableDanhSachSP = new JTable();
		tableDanhSachSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableDanhSachSP.setModel(modelSanPham = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"S\u1ED1 l\u01B0\u1EE3ng s\u1EA3n ph\u1EA9m",
						"S\u1ED1 l\u01B0\u1EE3ng c\u00F4ng \u0111o\u1EA1n", "Trạng thái" }));

		tableDanhSachSP.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableDanhSachSP.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableDanhSachSP.getColumnModel().getColumn(2).setPreferredWidth(237);
		tableDanhSachSP.getColumnModel().getColumn(3).setPreferredWidth(130);
		tableDanhSachSP.getColumnModel().getColumn(4).setPreferredWidth(130);
		tableDanhSachSP.getColumnModel().getColumn(5).setPreferredWidth(200);
		tableDanhSachSP.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableDanhSachSP.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		// tableDanhSachSP.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		tableDanhSachSP.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableDanhSachSP.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		scrollPaneDanhSachSanPham.setViewportView(tableDanhSachSP);
		scrollPaneDanhSachSanPham.setVerticalScrollBar(new ScrollBarCustom());
		scrollPaneDanhSachSanPham.setHorizontalScrollBar(sp);

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
				txtTrangThaiSP.setText(tableDanhSachSP.getValueAt(row, 5).toString());

			}
		});

		JPanel pnlChiaCongDoan = new JPanel();
		tabSanPham.addTab("Chia công đoạn sản phẩm", null, pnlChiaCongDoan, null);
		pnlChiaCongDoan.setLayout(null);

		JPanel pnlChiaCD = new JPanel();
		pnlChiaCD.setLayout(null);
		pnlChiaCD.setBorder(new TitledBorder(null, "Ph\u00E2n chia c\u00F4ng \u0111o\u1EA1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlChiaCD.setBackground(UIManager.getColor("Button.background"));
		pnlChiaCD.setBounds(10, 11, 875, 228);
		pnlChiaCongDoan.add(pnlChiaCD);

		JPanel pnlMaSanPham_1 = new JPanel();
		pnlMaSanPham_1.setLayout(null);
		pnlMaSanPham_1.setBackground(UIManager.getColor("Button.background"));
		pnlMaSanPham_1.setBounds(22, 25, 380, 30);
		pnlChiaCD.add(pnlMaSanPham_1);

		JLabel lblMaSanPhamCD = new JLabel("Mã sản phẩm");
		lblMaSanPhamCD.setBackground(new Color(240, 240, 240));
		lblMaSanPhamCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaSanPhamCD.setBounds(0, 0, 161, 30);
		pnlMaSanPham_1.add(lblMaSanPhamCD);

		cboMaSanPham = new JComboBox();
		cboMaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		pnlTenSanPham_1.setBackground(UIManager.getColor("Button.background"));
		pnlTenSanPham_1.setBounds(22, 66, 380, 30);
		pnlChiaCD.add(pnlTenSanPham_1);

		JLabel lblTenSanPhamCD = new JLabel("Tên sản phẩm");
		lblTenSanPhamCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenSanPhamCD.setBounds(0, 0, 161, 30);
		pnlTenSanPham_1.add(lblTenSanPhamCD);

		txtTenSanPhamCD = new JTextField();
		txtTenSanPhamCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenSanPhamCD.setEditable(false);
		txtTenSanPhamCD.setColumns(10);
		txtTenSanPhamCD.setBounds(160, 0, 220, 30);
		pnlTenSanPham_1.add(txtTenSanPhamCD);

		JPanel pnlSoLuong_1 = new JPanel();
		pnlSoLuong_1.setLayout(null);
		pnlSoLuong_1.setBackground(UIManager.getColor("Button.background"));
		pnlSoLuong_1.setBounds(22, 107, 380, 30);
		pnlChiaCD.add(pnlSoLuong_1);

		JLabel lblSoLuongCD = new JLabel("Số lượng sản phẩm");
		lblSoLuongCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoLuongCD.setBounds(0, 0, 161, 30);
		pnlSoLuong_1.add(lblSoLuongCD);

		txtSoLuongSPCD = new JTextField();
		txtSoLuongSPCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoLuongSPCD.setEditable(false);
		txtSoLuongSPCD.setColumns(10);
		txtSoLuongSPCD.setBounds(160, 0, 220, 30);
		pnlSoLuong_1.add(txtSoLuongSPCD);

		JPanel pnlNgayChiaCD = new JPanel();
		pnlNgayChiaCD.setLayout(null);
		pnlNgayChiaCD.setBackground(UIManager.getColor("Button.background"));
		pnlNgayChiaCD.setBounds(22, 148, 380, 30);
		pnlChiaCD.add(pnlNgayChiaCD);

		JLabel lblNgayChiaCD = new JLabel("Ngày chia công đoạn");
		lblNgayChiaCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgayChiaCD.setBounds(0, 0, 161, 30);
		pnlNgayChiaCD.add(lblNgayChiaCD);

		dateNgayChiaCD = new JDateChooser();
		dateNgayChiaCD.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 13));
		java.util.Date date = new java.util.Date();
		dateNgayChiaCD.setDate(date);
		dateNgayChiaCD.setDateFormatString("dd/MM/yyyy");
		dateNgayChiaCD.setBounds(160, 0, 220, 30);
		pnlNgayChiaCD.add(dateNgayChiaCD);

		JPanel pnlMaCongDoan = new JPanel();
		pnlMaCongDoan.setLayout(null);
		pnlMaCongDoan.setBackground(UIManager.getColor("Button.background"));
		pnlMaCongDoan.setBounds(463, 25, 170, 30);
		pnlChiaCD.add(pnlMaCongDoan);

		JLabel lblMaCongDoan = new JLabel("Mã công đoạn");
		lblMaCongDoan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaCongDoan.setBounds(0, 0, 100, 30);
		pnlMaCongDoan.add(lblMaCongDoan);

		txtMaCD = new JTextField();
		txtMaCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaCD.setColumns(10);
		txtMaCD.setBounds(95, 0, 75, 30);
		txtMaCD.setEditable(false);
		pnlMaCongDoan.add(txtMaCD);

		JPanel pnlNgayThucHien = new JPanel();
		pnlNgayThucHien.setLayout(null);
		pnlNgayThucHien.setBackground(UIManager.getColor("Button.background"));
		pnlNgayThucHien.setBounds(22, 189, 380, 30);
		pnlChiaCD.add(pnlNgayThucHien);

		JLabel lblNgayThucHien = new JLabel("Ngày bắt đầu");
		lblNgayThucHien.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgayThucHien.setBounds(0, 0, 161, 30);
		pnlNgayThucHien.add(lblNgayThucHien);

		dateNgayThucHien = new JDateChooser();
		dateNgayThucHien.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateNgayThucHien.setDateFormatString("dd/MM/yyyy");
		dateNgayThucHien.setBounds(161, 0, 219, 30);
		pnlNgayThucHien.add(dateNgayThucHien);

		JPanel pnlDonGia = new JPanel();
		pnlDonGia.setLayout(null);
		pnlDonGia.setBackground(UIManager.getColor("Button.background"));
		pnlDonGia.setBounds(463, 66, 170, 30);
		pnlChiaCD.add(pnlDonGia);

		JLabel lblDonGia = new JLabel("Đơn giá");
		lblDonGia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDonGia.setBounds(0, 0, 55, 30);
		pnlDonGia.add(lblDonGia);

		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(64, 0, 106, 30);
		pnlDonGia.add(txtDonGia);

		JPanel pnlSoLuongTrongCD = new JPanel();
		pnlSoLuongTrongCD.setLayout(null);
		pnlSoLuongTrongCD.setBackground(UIManager.getColor("Button.background"));
		pnlSoLuongTrongCD.setBounds(463, 148, 380, 30);
		pnlChiaCD.add(pnlSoLuongTrongCD);

		JLabel lblSoLuongTrongCD = new JLabel("Số lượng trong công đoạn");
		lblSoLuongTrongCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoLuongTrongCD.setBounds(0, 0, 188, 30);
		pnlSoLuongTrongCD.add(lblSoLuongTrongCD);

		txtSoLuongTrongCD = new JTextField();
		txtSoLuongTrongCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoLuongTrongCD.setColumns(10);
		txtSoLuongTrongCD.setBounds(192, 0, 188, 30);
		pnlSoLuongTrongCD.add(txtSoLuongTrongCD);

		JPanel pnlTrangThai = new JPanel();
		pnlTrangThai.setLayout(null);
		pnlTrangThai.setBackground(UIManager.getColor("Button.background"));
		pnlTrangThai.setBounds(463, 189, 380, 30);
		pnlChiaCD.add(pnlTrangThai);

		JLabel lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTrangThai.setBounds(0, 0, 188, 30);
		pnlTrangThai.add(lblTrangThai);

		txtTrangThaiCD = new JTextField();
		txtTrangThaiCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTrangThaiCD.setColumns(10);
		txtTrangThaiCD.setBounds(192, 0, 188, 30);
		pnlTrangThai.add(txtTrangThaiCD);

		JPanel pnlDoUuTien = new JPanel();
		pnlDoUuTien.setLayout(null);
		pnlDoUuTien.setBackground(SystemColor.menu);
		pnlDoUuTien.setBounds(653, 25, 190, 30);
		pnlChiaCD.add(pnlDoUuTien);

		JLabel lblDoUuTien = new JLabel("Độ ưu tiên");
		lblDoUuTien.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDoUuTien.setBounds(0, 0, 79, 30);
		pnlDoUuTien.add(lblDoUuTien);

		txtDoUuTien = new JTextField();
		txtDoUuTien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDoUuTien.setColumns(10);
		txtDoUuTien.setBounds(89, 0, 100, 30);
		pnlDoUuTien.add(txtDoUuTien);

		JPanel pnlDonGia_1 = new JPanel();
		pnlDonGia_1.setLayout(null);
		pnlDonGia_1.setBackground(SystemColor.menu);
		pnlDonGia_1.setBounds(653, 66, 190, 30);
		pnlChiaCD.add(pnlDonGia_1);

		JLabel lblChuynMn = new JLabel("Chuyên môn");
		lblChuynMn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChuynMn.setBounds(0, 0, 85, 30);
		pnlDonGia_1.add(lblChuynMn);

		cboChuyenMonCD = new JComboBox();
		cboChuyenMonCD.setModel(new DefaultComboBoxModel(new String[] { "Vắt sổ", "May áo", "Đính nút", "In hình",
				"Kiểm tra", "Cắt Vải", "May Quần", "May đáy quần", "May Túi", "Làm Mẫu", "Thân Áo", "Cổ Áo", "Tay Áo",
				"Đính nút", "Máy kim", "In thuê" }));
		cboChuyenMonCD.setBounds(95, 0, 95, 30);
		pnlDonGia_1.add(cboChuyenMonCD);

		JPanel pnlTenCongDoan = new JPanel();
		pnlTenCongDoan.setBounds(463, 107, 380, 30);
		pnlChiaCD.add(pnlTenCongDoan);
		pnlTenCongDoan.setLayout(null);
		pnlTenCongDoan.setBackground(UIManager.getColor("Button.background"));

		JLabel lblTenCongDoan = new JLabel("Tên công đoạn");
		lblTenCongDoan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenCongDoan.setBounds(0, 0, 161, 30);
		pnlTenCongDoan.add(lblTenCongDoan);

		txtTenCD = new JTextField();
		txtTenCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenCD.setColumns(10);
		txtTenCD.setBounds(190, 0, 190, 30);
		pnlTenCongDoan.add(txtTenCD);

		JPanel pnlChucNang_1 = new JPanel();
		pnlChucNang_1.setLayout(null);
		pnlChucNang_1.setBackground(UIManager.getColor("Button.background"));
		pnlChucNang_1.setBounds(10, 250, 875, 55);
		pnlChiaCongDoan.add(pnlChucNang_1);

		JButton btnLamMoiCD = new JButton("Làm mới");
		btnLamMoiCD.setForeground(Color.WHITE);
		btnLamMoiCD.setBorder(null);
		btnLamMoiCD.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/img/reload.png")));
		btnLamMoiCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLamMoiCD.setBackground(new Color(51, 201, 255));
		btnLamMoiCD.setBounds(595, 11, 130, 35);
		pnlChucNang_1.add(btnLamMoiCD);

		btnLamMoiCD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				XoaDuLieuTableCongDoansP();
				DocDuLieuCongDoanSP();
			}
		});

		JButton btnThemCD = new JButton("Thêm");
		btnThemCD.setForeground(Color.WHITE);
		btnThemCD.setBorder(null);
		btnThemCD.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/img/add-product.png")));
		btnThemCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemCD.setBackground(new Color(154, 205, 50));
		btnThemCD.setBounds(315, 11, 130, 35);
		pnlChucNang_1.add(btnThemCD);

		btnThemCD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ThemCongDoan();
			}
		});

		JButton btnXoaRongCD = new JButton("Xóa rỗng");
		btnXoaRongCD.setForeground(Color.WHITE);
		btnXoaRongCD.setBorder(null);
		btnXoaRongCD.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/img/trash-bin.png")));
		btnXoaRongCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaRongCD.setBackground(Color.RED);
		btnXoaRongCD.setBounds(735, 11, 130, 35);
		pnlChucNang_1.add(btnXoaRongCD);

		btnXoaRongCD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				XoaRongCD();
			}
		});

		JButton btnCapNhatCD = new JButton("Cập nhật");
		btnCapNhatCD.setForeground(Color.WHITE);
		btnCapNhatCD.setBorder(null);
		btnCapNhatCD.setIcon(new ImageIcon(SanphamJpanel.class.getResource("/img/update.png")));
		btnCapNhatCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhatCD.setBackground(new Color(51, 201, 255));
		btnCapNhatCD.setBounds(455, 11, 130, 35);
		pnlChucNang_1.add(btnCapNhatCD);

		JPanel pnlSortSP = new JPanel();
		pnlSortSP.setBounds(10, 11, 257, 35);
		pnlChucNang_1.add(pnlSortSP);
		pnlSortSP.setLayout(null);

		JLabel lblSortSP = new JLabel("Lọc sản phẩm");
		lblSortSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSortSP.setBounds(0, 0, 107, 35);
		pnlSortSP.add(lblSortSP);

		JComboBox cboSortSP = new JComboBox();
		cboSortSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboSortSP.setBounds(113, 0, 144, 35);
		pnlSortSP.add(cboSortSP);

		DefaultComboBoxModel<String> duLieuSortSP = new DefaultComboBoxModel<String>();
		ArrayList<SanPham> sortSP = sp_dao.getAllSanPham();
		if (danhSachSanPham != null) {
			for (SanPham sanPham : danhSachSanPham) {
				duLieuSortSP.addElement(sanPham.getMaSanPham());
			}
		} else {
			duLieuSortSP.addElement("Không có dữ liệu");
		}
		cboSortSP.setModel(duLieuSortSP);

		cboSortSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String sortMa = cboSortSP.getSelectedItem().toString();
					ArrayList<CongDoanSanPham> danhSachCongDoan = cd_dao.getCongDoanTheoMaSanPham(sortMa);
					ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();
					if (danhSachCongDoan.size() > 0) {
						XoaDuLieuTableCongDoansP();
						int i = 1;
						String tt = "";
						for (CongDoanSanPham cd : danhSachCongDoan) {
							danhSachSanPham = sp_dao.getSanPhamTheoMa(cd.getSanPham().getMaSanPham());
							for (SanPham sp : danhSachSanPham) {
								if (cd.isTrangThai() == true) {
									tt = "Hoàn thành";
								} else {
									tt = "Chưa hoàn thành";
								}
								modelCongDoan.addRow(new Object[] { i++, cd.getMaCongDoan(), cd.getTenCongDoan(),
										sp.getTenSanPham(), cd.getNgayChiaCD(), cd.getNgayBatDau(), cd.getDonGia(),
										cd.getSoLuong(), tt, cd.getChuyenMon(), cd.getDoUuTien() });
							}

						}
					} else if (danhSachCongDoan.size() <= 0) {
//						JOptionPane.showMessageDialog(null, "Sản phẩm chưa được chia công đoạn!");
						new CustomDialog( "Sản phẩm chưa được chia công đoạn!",CustomDialog.WARNING_DIALOG);
						DocDuLieuCongDoanSP();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		btnCapNhatCD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CapNhatCongDoan();
			}
		});

		JPanel pnlDanhSachChiaCD = new JPanel();
		pnlDanhSachChiaCD.setBorder(new TitledBorder(null,
				"Danh s\u00E1ch c\u00E1c s\u1EA3n ph\u1EA9m \u0111\u01B0\u1EE3c chia c\u00F4ng \u0111o\u1EA1n",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachChiaCD.setBackground(Color.WHITE);
		pnlDanhSachChiaCD.setBounds(10, 316, 875, 253);
		pnlChiaCongDoan.add(pnlDanhSachChiaCD);
		pnlDanhSachChiaCD.setLayout(null);

		JScrollPane scrollPaneDanhSachChiaCD = new JScrollPane();
		scrollPaneDanhSachChiaCD.setBounds(10, 21, 855, 221);
		pnlDanhSachChiaCD.add(scrollPaneDanhSachChiaCD);

		tableDanhSachCD = new JTable();
		tableDanhSachCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableDanhSachCD.setModel(modelCongDoan = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã CD", "Tên công đoạn", "Tên sản phẩm", "Ngày chia CD", "Ngày thực hiện",
						"Đơn giá", "Số lương trong công đoạn", "Trạng thái", "Chuyên môn", "Độ ưu tiên" }));

		tableDanhSachCD.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableDanhSachCD.getColumnModel().getColumn(1).setPreferredWidth(70);
		tableDanhSachCD.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableDanhSachCD.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableDanhSachCD.getColumnModel().getColumn(4).setPreferredWidth(86);
		tableDanhSachCD.getColumnModel().getColumn(5).setPreferredWidth(86);
		tableDanhSachCD.getColumnModel().getColumn(6).setPreferredWidth(80);
		tableDanhSachCD.getColumnModel().getColumn(7).setPreferredWidth(80);
		tableDanhSachCD.getColumnModel().getColumn(8).setPreferredWidth(100);

		tableDanhSachCD.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableDanhSachCD.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableDanhSachCD.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableDanhSachCD.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		tableDanhSachCD.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		tableDanhSachCD.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		tableDanhSachCD.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);

		scrollPaneDanhSachChiaCD.setViewportView(tableDanhSachCD);
		scrollPaneDanhSachChiaCD.setVerticalScrollBar(new ScrollBarCustom());
		scrollPaneDanhSachChiaCD.setHorizontalScrollBar(sp);

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
				int row = tableDanhSachCD.getSelectedRow();
				txtMaCD.setText(tableDanhSachCD.getValueAt(row, 1).toString());
				String maCD = txtMaCD.getText();
				cboMaSanPham.setSelectedItem(cd_dao.maSPtheomaCD(maCD));
				String cmFromTable = tableDanhSachCD.getValueAt(row, 9).toString();
				String cm = cmFromTable.trim().toLowerCase(); // Chuyển đổi sang chữ thường và loại bỏ khoảng trắng ở
																// đầu và cuối
				for (int i = 0; i < cboChuyenMonCD.getItemCount(); i++) {
					String currentItem = ((String) cboChuyenMonCD.getItemAt(i)).trim().toLowerCase();
					if (cm.equals(currentItem)) {
						cboChuyenMonCD.setSelectedIndex(i);
						break;
					}
				}
				txtTenCD.setText(tableDanhSachCD.getValueAt(row, 2).toString());
				txtTenSanPhamCD.setText(tableDanhSachCD.getValueAt(row, 3).toString());
				dateNgayChiaCD.setDate((Date) tableDanhSachCD.getValueAt(row, 4));
				dateNgayThucHien.setDate((Date) tableDanhSachCD.getValueAt(row, 5));
				txtDonGia.setText(tableDanhSachCD.getValueAt(row, 6).toString());
				txtSoLuongTrongCD.setText(tableDanhSachCD.getValueAt(row, 7).toString());
				txtTrangThaiCD.setText(tableDanhSachCD.getValueAt(row, 8).toString());
				txtDoUuTien.setText(tableDanhSachCD.getValueAt(row, 10).toString());
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
		String tt = "";
		for (SanPham sp : list) {
			if (sp.isTrangThaiSP() == true) {
				tt = "Hoàn thành";
			} else {
				tt = "Chưa hoàn thành";
			}
			modelSanPham.addRow(new Object[] { i++, sp.getMaSanPham(), sp.getTenSanPham(), sp.getSoLuongCongDoan(),
					sp.getSoLuong(), tt });
		}
	}

	private void DocDuLieuCongDoanSP() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<CongDoanSanPham> danhSachCD = cd_dao.getAllCongDoanSanPham();
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableDanhSachCD.getModel());
		tableDanhSachCD.setRowSorter(sorter);
		int i = 1;
		String tt = "";
		ArrayList<SanPham> danhSachSP = new ArrayList<SanPham>();
		for (CongDoanSanPham cd : danhSachCD) {
			if (cd.isTrangThai() == true) {
				tt = "Hoàn thành";
			} else {
				tt = "Chưa hoàn thành";
			}
			danhSachSP = sp_dao.getSanPhamTheoMa(cd.getSanPham().getMaSanPham());
			for (SanPham sp : danhSachSP) {

				modelCongDoan.addRow(new Object[] { i++, cd.getMaCongDoan(), cd.getTenCongDoan(), sp.getTenSanPham(),
						cd.getNgayChiaCD(), cd.getNgayBatDau(), cd.getDonGia(), cd.getSoLuong(), tt, cd.getChuyenMon(),
						cd.getDoUuTien() });
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
			String trangThaiText = txtTrangThaiSP.getText();

			// Chuyển đổi giá trị từ chuỗi sang boolean
			boolean tthai = trangThaiText.equalsIgnoreCase("Hoàn thành");

			SanPham sp = new SanPham(maSP, tenSP, sl, slCDofSP, tthai);

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
			CongDoanSanPham_DAO dao;
			String maSP = (String) cboMaSanPham.getSelectedItem();
			SanPham sp = new SanPham(maSP);
			String maCD = maCongDoan();
			String tenCD = txtTenCD.getText();
			Date ngayChiaCD = new Date(dateNgayChiaCD.getDate().getTime());
			Date ngayThucHien = new Date(dateNgayThucHien.getDate().getTime());
			float donGia = Float.parseFloat(txtDonGia.getText());
			int soLuongTrongCD = Integer.parseInt(txtSoLuongTrongCD.getText());

			String trangThaiTextCD = txtTrangThaiCD.getText();

			// Chuyển đổi giá trị từ chuỗi sang boolean
			boolean tthai = trangThaiTextCD.equalsIgnoreCase("Hoàn thành");
			String cMon = (String) cboChuyenMonCD.getSelectedItem();
			int uuTien = Integer.parseInt(txtDoUuTien.getText());

			CongDoanSanPham cd = new CongDoanSanPham(maCD, tenCD, sp, ngayThucHien, ngayChiaCD, donGia, soLuongTrongCD,
					cMon, tthai, 0, uuTien, false);

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
		txtTrangThaiSP.setText("");
	}

	private void XoaRongCD() {
		cboMaSanPham.setSelectedItem(null);
		txtMaCD.setText("");
		txtTenSanPhamCD.setText("");
		txtTenCD.setText("");
		txtSoLuongSPCD.setText("");
		txtDonGia.setText("");
		txtSoLuongTrongCD.setText("");
		dateNgayChiaCD.setDate(null);
		dateNgayThucHien.setDate(null);
		txtTrangThaiCD.setText("");
		cboChuyenMonCD.setSelectedItem(null);
		txtDoUuTien.setText("");
	}

	private void CapNhatSanPham() {
		String maSP = txtMaSanPham.getText();
		String tenSP = txtTenSanPham.getText();
		int soLuongSP = Integer.parseInt(txtSoLuong.getText());
		int soLuongCD = Integer.parseInt(txtSoLuongCDSP.getText());

		// Lấy giá trị từ txtTrangThaiSP
		String trangThaiText = txtTrangThaiSP.getText();

		// Chuyển đổi giá trị từ chuỗi sang boolean

		boolean tthai = false;
		tthai = trangThaiText.equalsIgnoreCase("Hoàn thành");

		SanPham sanPham = new SanPham(maSP, tenSP, soLuongSP, soLuongCD, tthai);
		try {
			if (sp_dao.update(sanPham)) {
//				JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công!");
				new CustomDialog("Cập nhật sản phẩm thành công!",CustomDialog.SUCCESS_DIALOG);
				XoahetDuLieuTrenTable();
				DocDuLieuDanhSachSP();
			}
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
			new CustomDialog("Cập nhật thất bại!",CustomDialog.SUCCESS_DIALOG);
		}
	}

	private void CapNhatCongDoan() {
		CongDoanSanPham_DAO dao = new CongDoanSanPham_DAO();
		String maSP = (String) cboMaSanPham.getSelectedItem();
		SanPham sp = new SanPham(maSP);
		String maCD = txtMaCD.getText();
		String tenCD = txtTenCD.getText();
		Date dateChiaCD = new Date(dateNgayChiaCD.getDate().getTime());
		Date dateTH = new Date(dateNgayThucHien.getDate().getTime());
		float donGia = Float.parseFloat(txtDonGia.getText());
		int soLuongTrongCD = Integer.parseInt(txtSoLuongTrongCD.getText());
		boolean tthai = false;
		String trangThaiText = txtTrangThaiCD.getText();
		tthai = trangThaiText.equalsIgnoreCase("Hoàn thành");
		String cMon = (String) cboChuyenMonCD.getSelectedItem();
		int uuTien = Integer.parseInt(txtDoUuTien.getText());
		boolean tthaipc = dao.getTrangThaiPhanCong(maCD);
		int soLuongHoanThanh = dao.getSoLuongHoanThanh(maCD);

		CongDoanSanPham cd = new CongDoanSanPham(maCD, tenCD, sp, dateTH, dateChiaCD, donGia, soLuongTrongCD, cMon,
				tthai, soLuongHoanThanh, uuTien, tthaipc);

		try {

//			JOptionPane.showMessageDialog(null, "Err");
			if (cd_dao.update(cd)) {
//				JOptionPane.showMessageDialog(this, "Cập nhật công đoạn thành công!");
				new CustomDialog("Cập nhật công đoạn thành công!",CustomDialog.SUCCESS_DIALOG);
				XoaDuLieuTableCongDoansP();
				DocDuLieuCongDoanSP();
			}
		} catch (Exception e) {
			// TODO: handle exception
//			JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
			new CustomDialog("Cập nhật thất bại!",CustomDialog.ERROR_DIALOG);
		}
	}

	private boolean KiemTraDuLieuSP() {
		String tenSP = txtTenSanPham.getText();
		String slString = txtSoLuong.getText();
		int slCD = Integer.parseInt(txtSoLuongCDSP.getText());

		if (!(tenSP.length() > 0 && tenSP.matches("^[\\p{L}' ]+$"))) {
//			JOptionPane.showMessageDialog(null, "Tên sản phẩm không hợp lệ!");
			new CustomDialog("Tên sản phẩm không hợp lệ!",CustomDialog.WARNING_DIALOG);
			txtTenSanPham.selectAll();
			txtTenSanPham.requestFocus();
			return false;
		}

		if (slString.isEmpty()) {
//			JOptionPane.showMessageDialog(null, "Nhập số lượng sản phẩm");
			new CustomDialog("Nhập số lượng sản phẩm",CustomDialog.WARNING_DIALOG);
			txtSoLuong.selectAll();
			txtSoLuong.requestFocus();
			return false;
		} else if (Integer.valueOf(slString) <= 0) {
//			JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!");
			new CustomDialog("Số lượng không hợp lệ!",CustomDialog.WARNING_DIALOG);
			txtSoLuong.selectAll();
			txtSoLuong.requestFocus();
			return false;
		}

		if (slCD <= 0) {
//			JOptionPane.showMessageDialog(null, "Số lượng của công đoạn không hợp lệ!");
			new CustomDialog("Số lượng của công đoạn không hợp lệ!",CustomDialog.WARNING_DIALOG);
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
//			JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm cần chia công đoạn!");
			new CustomDialog("Bạn chưa chọn sản phẩm cần chia công đoạn!",CustomDialog.WARNING_DIALOG);
			return false;
		}
		if (!(tenCD.length() > 0 && tenCD.matches("^[\\p{L}' ]+$"))) {
//			JOptionPane.showMessageDialog(null, "Tên công đoạn không hợp lệ!");
			new CustomDialog("Tên công đoạn không hợp lệ!",CustomDialog.WARNING_DIALOG);
			txtTenCD.selectAll();
			txtTenCD.requestFocus();
			return false;
		}
		if (donGia.isEmpty()) {
//			JOptionPane.showMessageDialog(null, "Nhập đơn giá cho công đoạn!");
			new CustomDialog("Nhập đơn giá cho công đoạn!",CustomDialog.WARNING_DIALOG);
			txtDonGia.selectAll();
			txtDonGia.requestFocus();
			return false;
		} else if (Float.valueOf(donGia) <= 0) {
//			JOptionPane.showMessageDialog(null, "Đơn giá không hợp lệ!");
			new CustomDialog("Đơn giá không hợp lệ!",CustomDialog.WARNING_DIALOG);

			
			txtDonGia.selectAll();
			txtDonGia.requestFocus();
			return false;
		}
		if (SoLuongTrongCD.isEmpty()) {
//			JOptionPane.showMessageDialog(null, "Nhập số lượng công đoạn!");
			new CustomDialog( "Nhập số lượng công đoạn!",CustomDialog.WARNING_DIALOG);
			txtSoLuongCDSP.selectAll();
			txtSoLuongCDSP.requestFocus();
			return false;
		} else if (Integer.parseInt(SoLuongTrongCD) <= 0) {
//			JOptionPane.showMessageDialog(null, "Số lượng công đoạn không hợp lệ!");
			new CustomDialog( "Số lượng công đoạn không hợp lệ!",CustomDialog.WARNING_DIALOG);
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
//				JOptionPane.showMessageDialog(null, "Ngày thực hiện phải sau ngày hiện tại!");
				new CustomDialog(  "Ngày thực hiện phải sau ngày hiện tại!",CustomDialog.WARNING_DIALOG);
				dateNgayThucHien.requestFocus();
				return false;
			} else if (ngayThucHien.before(ngayChiaCD)) {
//				JOptionPane.showMessageDialog(null, "Ngày thực hiện phải sau ngày chia công đoạn");
				new CustomDialog(  "Ngày thực hiện phải sau ngày chia công đoạn",CustomDialog.WARNING_DIALOG);
				dateNgayThucHien.requestFocus();
				return false;
			}

		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Ngày thực hiện không hợp lệ!");
			new CustomDialog( "Ngày thực hiện không hợp lệ!",CustomDialog.WARNING_DIALOG);
		}
		return true;
	}
}