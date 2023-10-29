package App_QLLuong;

import java.awt.Font;
import java.awt.Image;

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
import javax.swing.JFrame;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;


public class LuongJPanel extends JFrame  {
	private static final long serialVersionUID = 1L;
	private JTextField txtTKCN;
	private JTextField txtTienth;
	private JTable tableCN;
	private JTable table;
	private JTextField txtTKNV;
	private JTextField txtTienThuong;
	private JTextField txtTienPhat;
	private JTextField txtTienph;
	
	public LuongJPanel() {
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 883, 609);
		getContentPane().add(tabbedPane);
		      
		JPanel pnNhanVien = new JPanel();
		pnNhanVien.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("Nhân viên", null, pnNhanVien, null);
		tabbedPane.setEnabledAt(0, true);
		pnNhanVien.setLayout(null);
		
		JLabel lblPhongBan = new JLabel("Phòng ban");
		lblPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhongBan.setBounds(48, 26, 90, 17);
		pnNhanVien.add(lblPhongBan);
		
		JLabel lblNam = new JLabel("Năm :");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNam.setBounds(58, 61, 63, 17);
		pnNhanVien.add(lblNam);
		
		JComboBox cbbNam = new JComboBox();
		cbbNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbNam.setBounds(147, 53, 129, 22);
		pnNhanVien.add(cbbNam);
		
		JLabel lblTKNV = new JLabel("Tìm kiếm nhân viên : ");
		lblTKNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTKNV.setBounds(369, 26, 145, 17);
		pnNhanVien.add(lblTKNV);
		
		JLabel lblGioLamViecNV = new JLabel("Tháng :");
		lblGioLamViecNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioLamViecNV.setBounds(417, 62, 77, 17);
		pnNhanVien.add(lblGioLamViecNV);
		
		JComboBox cbbThang = new JComboBox();
		cbbThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThang.setBounds(529, 58, 132, 22);
		pnNhanVien.add(cbbThang);
		
		JButton btnCapNhat = new JButton("Cập Nhật");
		
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBounds(487, 129, 106, 31);
		pnNhanVien.add(btnCapNhat);
		
		JComboBox cbbPhongBanNV = new JComboBox();
		cbbPhongBanNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbPhongBanNV.setBounds(137, 23, 164, 22);
		pnNhanVien.add(cbbPhongBanNV);
		
		JButton btnIn = new JButton("In Bảng Lương");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIn.setBounds(622, 129, 157, 31);
		pnNhanVien.add(btnIn);
		
		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(10, 213, 836, 325);
		pnNhanVien.add(scrollPaneNV);
		
		JPanel pnCongNhan = new JPanel();
		pnCongNhan.setBackground(new Color(240, 240, 240));
		pnCongNhan.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("Công nhân", null, pnCongNhan, null);
		tabbedPane.setEnabledAt(1, true);
		pnCongNhan.setLayout(null);
		
		JLabel lblTKCN = new JLabel("Tìm kiếm công nhân");
		lblTKCN.setBounds(367, 23, 150, 17);
		lblTKCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblTKCN);
		
		txtTKCN = new JTextField();
		txtTKCN.setBounds(519, 21, 167, 20);
		txtTKCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(txtTKCN);
		txtTKCN.setColumns(10);
		
		JLabel lblNam1 = new JLabel("Năm :");
		lblNam1.setBounds(64, 53, 63, 17);
		lblNam1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblNam1);
		
		JComboBox cbbNam1 = new JComboBox();
		cbbNam1.setBounds(151, 50, 132, 22);
		cbbNam1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(cbbNam1);
		
		JLabel lblMaXuong = new JLabel("Mã xưởng");
		lblMaXuong.setBounds(64, 23, 63, 17);
		lblMaXuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblMaXuong);
		
		JComboBox cbbMaXuong = new JComboBox();
		cbbMaXuong.setBounds(151, 20, 165, 22);
		cbbMaXuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(cbbMaXuong);
		
		JLabel lblThang1 = new JLabel("Tháng :");
		lblThang1.setBounds(415, 54, 69, 17);
		lblThang1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblThang1);
		
		JComboBox cbbThang1 = new JComboBox();
		cbbThang1.setBounds(527, 53, 132, 22);
		cbbThang1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(cbbThang1);
		
		JLabel lbltTienph = new JLabel("Tiền phạt :");
		lbltTienph.setBounds(397, 94, 102, 17);
		lbltTienph.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lbltTienph);
		
		txtTienth = new JTextField();
		txtTienth.setBounds(151, 92, 132, 20);
		txtTienth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTienth.setColumns(10);
		pnCongNhan.add(txtTienth);
		
		
		JScrollPane scrollPaneCN = new JScrollPane();
		scrollPaneCN.setBounds(21, 220, 815, 333);
		pnCongNhan.add(scrollPaneCN);
		
		tableCN = new JTable();
		tableCN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableCN.setModel(new DefaultTableModel(
			new Object[][] {
				{new Long(1L), "CN0001", "Nguyen Van B","20" , "4.000.000", "300.000","4.00.000"},
			},
			new String[] {
				"STT", "MA CN", "Ho Ten", "So Ngay Lam", "Luong Ca", "Luong Tang ca", "ThucLanh"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableCN.getColumnModel().getColumn(2).setPreferredWidth(115);
		tableCN.getColumnModel().getColumn(4).setPreferredWidth(99);
		tableCN.getColumnModel().getColumn(5).setPreferredWidth(102);
		scrollPaneCN.setViewportView(tableCN);
		
		JLabel lbltTienTh_1 = new JLabel("Tiền thưởng :");
		lbltTienTh_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbltTienTh_1.setBounds(36, 98, 102, 17);
		pnCongNhan.add(lbltTienTh_1);
		
		txtTienph = new JTextField();
		txtTienph.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTienph.setColumns(10);
		txtTienph.setBounds(527, 95, 132, 20);
		pnCongNhan.add(txtTienph);
		
		JButton btnCapNhat1 = new JButton("Cập Nhật");
		btnCapNhat1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat1.setBounds(466, 125, 102, 31);
		pnCongNhan.add(btnCapNhat1);
		
		JButton btnIn1 = new JButton("In Bảng Lương");
		btnIn1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIn1.setBounds(592, 125, 127, 31);
		pnCongNhan.add(btnIn1);
		
		JLabel lblDSLcn = new JLabel("Danh sách tiền lương công nhân");
		lblDSLcn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDSLcn.setBounds(291, 166, 336, 43);
		pnCongNhan.add(lblDSLcn);
		
		JButton btnTimCN = new JButton("Tìm");
		btnTimCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimCN.setBounds(688, 22, 51, 22);
		pnCongNhan.add(btnTimCN);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Long(1L), "NV0001", "Nguyen Van A","20", "2", "8000000", "4300000"},
			},
			new String[] {
				"STT", "MA NV", "HoTen", "So Ngay Lam", "So Gio Tang Ca", "Luong Co Ban", "ThucLanh"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		//table.getColumnModel().getColumn(4).setPreferredWidth(89);
		//table.getColumnModel().getColumn(5).setPreferredWidth(99);
		scrollPaneNV.setViewportView(table);
		
		txtTKNV = new JTextField();
		txtTKNV.setBounds(524, 26, 181, 22);
		pnNhanVien.add(txtTKNV);
		txtTKNV.setColumns(10);
		
		JLabel lblTienThuong = new JLabel("Tiền thưởng :");
		lblTienThuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTienThuong.setBounds(35, 94, 90, 17);
		pnNhanVien.add(lblTienThuong);
		
		txtTienThuong = new JTextField();
		txtTienThuong.setColumns(10);
		txtTienThuong.setBounds(147, 89, 181, 22);
		pnNhanVien.add(txtTienThuong);
		
		JLabel lblTienPhat = new JLabel("Tiền phạt :");
		lblTienPhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTienPhat.setBounds(392, 94, 90, 17);
		pnNhanVien.add(lblTienPhat);
		
		txtTienPhat = new JTextField();
		txtTienPhat.setColumns(10);
		txtTienPhat.setBounds(525, 90, 181, 22);
		pnNhanVien.add(txtTienPhat);
		
		JLabel lblNewLabel = new JLabel("Danh sách tiền lương nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(294, 170, 299, 40);
		pnNhanVien.add(lblNewLabel);
		
		JButton btnTimNV = new JButton("Tìm");
		btnTimNV.setBounds(703, 26, 51, 22);
		pnNhanVien.add(btnTimNV);
		
		

	}
}
