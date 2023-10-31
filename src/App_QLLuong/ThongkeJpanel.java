package App_QLLuong;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import java.awt.Canvas;
import javax.swing.table.DefaultTableModel;

import CustomGUi.ScrollBarCustom;

import javax.swing.ListSelectionModel;
import java.awt.CardLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.DebugGraphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThongkeJpanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private ScrollBarCustom scrollBarCustom1;
    private ScrollBarCustom sp;

	/**
	 * Create the panel.
	 */
	public ThongkeJpanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_title = new JPanel();
		panel_title.setBackground(new Color(100, 149, 237));
		panel.add(panel_title, BorderLayout.NORTH);
		panel_title.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ TỔNG QUÁT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_title.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_center = new JPanel();
		panel_center.setBackground(UIManager.getColor("Button.background"));
		panel_center.setBorder(new LineBorder(null, 1, true));
		panel.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(null);
		
		JPanel jpl_SP = new JPanel();
		jpl_SP.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		jpl_SP.setBounds(63, 22, 198, 88);
		panel_center.add(jpl_SP);
		jpl_SP.setLayout(new BoxLayout(jpl_SP, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.RED);
		jpl_SP.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Số sản phẩm");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 0, 79, 44);
		panel_4.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(Color.RED);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("250");
		textField.setBorder(null);
		textField.setEditable(false);
		textField.setBounds(20, 49, 58, 39);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		jpl_SP.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIconTextGap(8);
		lblNewLabel_1.setSize(new Dimension(99, 88));
		lblNewLabel_1.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\sp03.png"));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 99, 84);
		panel_5.add(lblNewLabel_1);
		
		JPanel jpl_CongNhan = new JPanel();
		jpl_CongNhan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpl_CongNhan.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		jpl_CongNhan.setBounds(325, 22, 198, 88);
		panel_center.add(jpl_CongNhan);
		jpl_CongNhan.setLayout(new BoxLayout(jpl_CongNhan, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 127));
		jpl_CongNhan.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Số \n Công Nhân");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(0, 11, 94, 35);
		panel_2.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setText("250");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setBorder(null);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(0, 255, 127));
		textField_1.setBounds(20, 49, 58, 39);
		panel_2.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		panel_3.setBackground(Color.PINK);
		jpl_CongNhan.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\cn1.png"));
		lblNewLabel_5.setSize(new Dimension(99, 88));
		lblNewLabel_5.setBounds(0, 0, 99, 88);
		panel_3.add(lblNewLabel_5);
		
		JPanel jpl_NhanVien = new JPanel();
		jpl_NhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpl_NhanVien.setBackground(new Color(245, 255, 250));
		jpl_NhanVien.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		jpl_NhanVien.setBounds(603, 22, 198, 88);
		panel_center.add(jpl_NhanVien);
		jpl_NhanVien.setLayout(new BoxLayout(jpl_NhanVien, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 215, 0));
		jpl_NhanVien.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Số Nhân Viên");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(10, 11, 89, 35);
		panel_1.add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setText("250");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(255, 215, 0));
		textField_2.setBounds(14, 49, 58, 39);
		panel_1.add(textField_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(30, 144, 255));
		panel_6.setLayout(null);
		jpl_NhanVien.add(panel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\nv.png"));
		lblNewLabel_5_1.setSize(new Dimension(99, 88));
		lblNewLabel_5_1.setBounds(0, 0, 97, 84);
		panel_6.add(lblNewLabel_5_1);
		
		JPanel jpl_Luong = new JPanel();
		jpl_Luong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpl_Luong.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		jpl_Luong.setBounds(192, 144, 198, 88);
		panel_center.add(jpl_Luong);
		jpl_Luong.setLayout(new BoxLayout(jpl_Luong, BoxLayout.X_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(128, 128, 128));
		jpl_Luong.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tổng lương");
		lblNewLabel_2_1.setBounds(10, 11, 69, 17);
		panel_8.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_3 = new JTextField();
		textField_3.setBounds(0, 60, 93, 17);
		panel_8.add(textField_3);
		textField_3.setText("15.000.000");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(128, 128, 128));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(139, 0, 0));
		jpl_Luong.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\luong.png"));
		lblNewLabel_5_2.setSize(new Dimension(99, 88));
		lblNewLabel_5_2.setBounds(0, 0, 99, 84);
		panel_9.add(lblNewLabel_5_2);
		
		JPanel jpl_SanPham = new JPanel();
		jpl_SanPham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpl_SanPham.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		jpl_SanPham.setBounds(466, 144, 198, 88);
		panel_center.add(jpl_SanPham);
		jpl_SanPham.setLayout(new BoxLayout(jpl_SanPham, BoxLayout.X_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(119, 136, 153));
		jpl_SanPham.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Công đoạn");
		lblNewLabel_2_1_1.setBounds(10, 11, 69, 17);
		panel_7.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_4 = new JTextField();
		textField_4.setText("250");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(new Color(119, 136, 153));
		textField_4.setBounds(0, 60, 93, 17);
		panel_7.add(textField_4);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 235, 205));
		jpl_SanPham.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_5_3 = new JLabel("");
		lblNewLabel_5_3.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\congdoan.png"));
		lblNewLabel_5_3.setSize(new Dimension(99, 88));
		lblNewLabel_5_3.setBounds(0, 0, 97, 84);
		panel_10.add(lblNewLabel_5_3);
		
		JPanel jplbang = new JPanel();
		jplbang.setBounds(40, 287, 834, 238);
		panel_center.add(jplbang);
		jplbang.setLayout(new BoxLayout(jplbang, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollPane.setHorizontalScrollBar(sp);
		jplbang.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setSelectionBackground(new Color(0, 0, 255));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setGridColor(new Color(0, 0, 0));
		table.setInheritsPopupMenu(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setSize(new Dimension(0, 50));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setRowMargin(10);
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(450, 600));
		table.setFont(new Font("Times New Roman", Font.BOLD, 12));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"CN0025"," Đinh Nhật Khang","Vắt sổ", "0313546521","1500000"},
				{"NV0215","Nguyễn Thiên Hòa", "Kế toán","0354786958", "4500000"},
				{"NV0215","Nguyễn Thiên Hòa", "Kế toán","0354786958", "4500000"},
				{"NV0215","Nguyễn Thiên Hòa", "Kế toán","0354786958", "4500000"},
				{"NV0215","Nguyễn Thiên Hòa", "Kế toán","0354786958", "4500000"},
				{"NV0215","Nguyễn Thiên Hòa", "Kế toán","0354786958", "4500000"},
				{"NV0215","Nguyễn Thiên Hòa", "Kế toán","0354786958", "4500000"},
				{"NV0215","Nguyễn Thiên Hòa", "Kế toán","0354786958", "4500000"},
				{"NV0215","Nguyễn Thiên Hòa", "Kế toán","0354786958", "4500000"},
				
			},
			new String[] {
				"Mã nhân sự", "Họ và tên", "Chức danh/chuyên môn", "Số điện thoại", "tổng lương"}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(79);
		table.getColumnModel().getColumn(0).setMinWidth(19);
		table.getColumnModel().getColumn(0).setMaxWidth(2147483642);
		scrollPane.setViewportView(table);
		
		JPanel pblbangluong = new JPanel();
		pblbangluong.setBackground(new Color(245, 245, 245));
		pblbangluong.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "B\u1EA2NG TH\u1ED0NG K\u00CA NH\u00C2N S\u1EF0 TI\u00CAU BI\u1EC2U", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pblbangluong.setBounds(10, 243, 884, 326);
		panel_center.add(pblbangluong);
		pblbangluong.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tháng:");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(90, 293, 69, 33);
		pblbangluong.add(lblNewLabel_4_1);
		
		JComboBox Jcbthang = new JComboBox();
		Jcbthang.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Jcbthang.setAutoscrolls(true);
		Jcbthang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Jcbthang.setForeground(new Color(0, 0, 0));
		Jcbthang.setBackground(new Color(255, 255, 255));
		Jcbthang.setModel(new DefaultComboBoxModel(new String[] {"12", "11", "10", "09", "08", "07", "05", "0", "03", "02", "01"}));
		Jcbthang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Jcbthang.setBorder(null);
		Jcbthang.setBounds(174, 293, 61, 28);
		pblbangluong.add(Jcbthang);
		
		JLabel lblNewLabel_4 = new JLabel("Năm:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(296, 293, 69, 33);
		pblbangluong.add(lblNewLabel_4);
		
		JButton btnchitiet = new JButton("Chi tiết");
		btnchitiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnchitiet.setBackground(new Color(0, 191, 255));
		btnchitiet.setAutoscrolls(true);
		btnchitiet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnchitiet.setForeground(new Color(0, 0, 0));
		btnchitiet.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\details.png"));
		btnchitiet.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnchitiet.setBounds(517, 293, 114, 30);
		pblbangluong.add(btnchitiet);
		
		JButton btnin = new JButton("In PDF");
		btnin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnin.setDefaultCapable(false);
		btnin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnin.setBackground(new Color(0, 191, 255));
		btnin.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\baseline_print_black_24dp.png"));
		btnin.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnin.setBounds(679, 291, 114, 30);
		pblbangluong.add(btnin);
		
		JComboBox Jcbnam = new JComboBox();
		Jcbnam.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2019", "2018", "2017"}));
		Jcbnam.setForeground(new Color(0, 0, 0));
		Jcbnam.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Jcbnam.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Jcbnam.setBorder(null);
		Jcbnam.setBackground(Color.WHITE);
		Jcbnam.setAutoscrolls(true);
		Jcbnam.setBounds(353, 293, 78, 28);
		pblbangluong.add(Jcbnam);

	}
}
