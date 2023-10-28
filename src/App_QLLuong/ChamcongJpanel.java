package App_QLLuong;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFormattedTextField.AbstractFormatter;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;


public class ChamcongJpanel extends JPanel  {
	private static final long serialVersionUID = 1L;
	private JTextField textField_MaCN;
	private JTextField textField_MaCongDoan;
	private JTextField textField_soluongCL;
	private JTable tableCN;
	private JTextField textField_4;
	private JTextField textField_timkiemNV;
	private JTable table;
	
	public ChamcongJpanel() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 863, 609);
		add(tabbedPane);
		      
		JPanel pnNhanVien = new JPanel();
		pnNhanVien.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("Nhân viên", null, pnNhanVien, null);
		tabbedPane.setEnabledAt(0, true);
		pnNhanVien.setLayout(null);
		
		JLabel lblPhngBan = new JLabel("Phòng ban");
		lblPhngBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhngBan.setBounds(137, 26, 90, 17);
		pnNhanVien.add(lblPhngBan);
		
		JLabel lblCaLamNV = new JLabel("Ca làm");
		lblCaLamNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCaLamNV.setBounds(137, 62, 63, 17);
		pnNhanVien.add(lblCaLamNV);
		
		JComboBox comboBox_CaLamNV = new JComboBox();
		comboBox_CaLamNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_CaLamNV.setBounds(253, 58, 132, 22);
		pnNhanVien.add(comboBox_CaLamNV);
		
		JLabel lblNgayLamNV = new JLabel("Ngày làm");
		lblNgayLamNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayLamNV.setBounds(417, 26, 63, 17);
		pnNhanVien.add(lblNgayLamNV);
		
		JLabel lblGioLamViecNV = new JLabel("Giờ làm việc");
		lblGioLamViecNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioLamViecNV.setBounds(417, 62, 77, 17);
		pnNhanVien.add(lblGioLamViecNV);
		
		JComboBox comboBox_1_1_2 = new JComboBox();
		comboBox_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1_1_2.setBounds(529, 58, 132, 22);
		pnNhanVien.add(comboBox_1_1_2);
		
		JLabel lblTmKim_1 = new JLabel("Tìm kiếm");
		lblTmKim_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTmKim_1.setBounds(48, 167, 58, 17);
		pnNhanVien.add(lblTmKim_1);
		
		textField_timkiemNV = new JTextField();
		textField_timkiemNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_timkiemNV.setColumns(10);
		textField_timkiemNV.setBounds(112, 164, 104, 23);
		pnNhanVien.add(textField_timkiemNV);
		
		JButton btnTatCaCoMat = new JButton("Tất cả có mặt");
		btnTatCaCoMat.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/co.png")));
		btnTatCaCoMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTatCaCoMat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTatCaCoMat.setBounds(294, 160, 145, 31);
		pnNhanVien.add(btnTatCaCoMat);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/xoa.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(616, 160, 90, 31);
		pnNhanVien.add(btnXoa);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/luu.png")));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLuu.setBounds(716, 160, 90, 31);
		pnNhanVien.add(btnLuu);
		
		JComboBox comboBox_PhongBanNV = new JComboBox();
		comboBox_PhongBanNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_PhongBanNV.setBounds(253, 26, 132, 22);
		pnNhanVien.add(comboBox_PhongBanNV);
		
		JButton btnTatCaVangMat = new JButton("Tất cả vắng mặt");
		btnTatCaVangMat.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/vang.png")));
		btnTatCaVangMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTatCaVangMat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTatCaVangMat.setBounds(449, 160, 157, 31);
		pnNhanVien.add(btnTatCaVangMat);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(48, 206, 754, 339);
		pnNhanVien.add(scrollPane_1);
		
		JButton btnTiemKiemNV = new JButton("Tìm Kiếm");
		btnTiemKiemNV.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/tim.png")));
		btnTiemKiemNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTiemKiemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTiemKiemNV.setBounds(353, 105, 132, 31);
		pnNhanVien.add(btnTiemKiemNV);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(529, 23, 132, 22);
		pnNhanVien.add(dateChooser);
		
		JButton btnTiemKiemNV_1 = new JButton("");
		btnTiemKiemNV_1.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/tim.png")));
		btnTiemKiemNV_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTiemKiemNV_1.setBounds(224, 162, 34, 25);
		pnNhanVien.add(btnTiemKiemNV_1);
		
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
		comboBox_SP.setBounds(251, 50, 132, 22);
		comboBox_SP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(comboBox_SP);
		
		JLabel lblMaCongDoan = new JLabel("Mã công đoạn");
		lblMaCongDoan.setBounds(135, 85, 90, 17);
		lblMaCongDoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblMaCongDoan);
		
		textField_MaCongDoan = new JTextField();
		textField_MaCongDoan.setBounds(251, 82, 132, 20);
		textField_MaCongDoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(textField_MaCongDoan);
		textField_MaCongDoan.setColumns(10);
		
		JLabel lblNgayChamCongCN = new JLabel("Ngày chấm công");
		lblNgayChamCongCN.setBounds(135, 115, 106, 17);
		lblNgayChamCongCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblNgayChamCongCN);
		
		JLabel lblMaXuong = new JLabel("Mã xưởng");
		lblMaXuong.setBounds(415, 24, 63, 17);
		lblMaXuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblMaXuong);
		
		JComboBox comboBox_MaXuong = new JComboBox();
		comboBox_MaXuong.setBounds(527, 20, 132, 22);
		comboBox_MaXuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(comboBox_MaXuong);
		
		JLabel lblCongDoan = new JLabel("Công đoạn");
		lblCongDoan.setBounds(415, 54, 69, 17);
		lblCongDoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblCongDoan);
		
		JComboBox comboBox_CongDoan = new JComboBox();
		comboBox_CongDoan.setBounds(527, 50, 132, 22);
		comboBox_CongDoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(comboBox_CongDoan);
		
		JLabel lblSoSP = new JLabel("Số sản phẩm");
		lblSoSP.setBounds(415, 85, 82, 17);
		lblSoSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblSoSP);
		
		JComboBox comboBox_soSP = new JComboBox();
		comboBox_soSP.setBounds(527, 81, 132, 22);
		comboBox_soSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(comboBox_soSP);
		
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
		scrollPane.setBounds(48, 204, 746, 348);
		pnCongNhan.add(scrollPane);
		
		tableCN = new JTable();
		tableCN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableCN.setModel(new DefaultTableModel(
			new Object[][] {
				{new Long(1L), "CN1", "Test", null, new Long(1L), Boolean.TRUE, new Long(100L)},
			},
			new String[] {
				"STT", "M\u00E3 CN", "H\u1ECD v\u00E0 t\u00EAn", "C\u00F3 m\u1EB7t", "S\u1ED1 gi\u1EDD t\u0103ng ca", "C\u00F3/kh\u00F4ng ph\u00E9p", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, String.class, Boolean.class, Long.class, Boolean.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableCN.getColumnModel().getColumn(2).setPreferredWidth(115);
		tableCN.getColumnModel().getColumn(4).setPreferredWidth(99);
		tableCN.getColumnModel().getColumn(5).setPreferredWidth(102);
		scrollPane.setViewportView(tableCN);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTmKim.setBounds(48, 172, 58, 17);
		pnCongNhan.add(lblTmKim);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(112, 169, 106, 23);
		pnCongNhan.add(textField_4);
		
		JLabel lblMaXuongLoc = new JLabel("Mã xưởng");
		lblMaXuongLoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaXuongLoc.setBounds(279, 173, 63, 17);
		pnCongNhan.add(lblMaXuongLoc);
		
		JComboBox comboBox_MaXuongLoc = new JComboBox();
		comboBox_MaXuongLoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_MaXuongLoc.setBounds(352, 169, 126, 25);
		pnCongNhan.add(comboBox_MaXuongLoc);
		
		JButton btnThemCN = new JButton("Thêm");
		btnThemCN.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/them.png")));
		btnThemCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemCN.setBounds(504, 163, 90, 31);
		pnCongNhan.add(btnThemCN);
		
		JButton btnXoaCN = new JButton("Xóa");
		btnXoaCN.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/xoa.png")));
		btnXoaCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaCN.setBounds(604, 163, 90, 31);
		pnCongNhan.add(btnXoaCN);
		
		JButton btnLuuCN = new JButton("Lưu");
		btnLuuCN.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/luu.png")));
		btnLuuCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLuuCN.setBounds(704, 163, 90, 31);
		pnCongNhan.add(btnLuuCN);
		
		JButton btnTiemKiemCNMa = new JButton("");
		btnTiemKiemCNMa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTiemKiemCNMa.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/tim.png")));
		btnTiemKiemCNMa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTiemKiemCNMa.setBounds(228, 169, 34, 25);
		pnCongNhan.add(btnTiemKiemCNMa);
		
		JButton btnTimKiemCN = new JButton("Tìm kiếm");
		btnTimKiemCN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTimKiemCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiemCN.setIcon(new ImageIcon(ChamcongJpanel.class.getResource("/Icons/chamcong/tim.png")));
		btnTimKiemCN.setBounds(692, 48, 118, 31);
		pnCongNhan.add(btnTimKiemCN);
		
		JDateChooser dateChooser_NgayChamCongCN = new JDateChooser();
		dateChooser_NgayChamCongCN.setBounds(251, 113, 132, 20);
		pnCongNhan.add(dateChooser_NgayChamCongCN);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Long(1L), "NV1", "Test", Boolean.TRUE, new Long(2L), null, "123"},
			},
			new String[] {
				"STT", "M\u00E3 NV", "H\u1ECD v\u00E0 t\u00EAn", "C\u00F3 m\u1EB7t", "S\u1ED1 gi\u1EDD t\u0103ng ca", "C\u00F3/Kh\u00F4ng ph\u00E9p", "Ghi ch\u00FA"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, String.class, Boolean.class, Long.class, Boolean.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(4).setPreferredWidth(89);
		table.getColumnModel().getColumn(5).setPreferredWidth(99);
		scrollPane_1.setViewportView(table);

	}
}
