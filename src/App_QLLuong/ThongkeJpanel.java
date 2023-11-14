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

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.CongNhan_BUS;
import BUS.ThongKe_BUS;
import DAO.ConnectDB;
import DTO.BangLuongCongNhan;
import DTO.CongNhan;
import DTO.Thongke;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ThongkeJpanel extends JPanel implements ItemListener,ActionListener {
	private JTextField txtsp;
	private JTextField txtCN;
	private JTextField txtNV;
	private JTextField txtLuong;
	private JTextField txtCD;
	private JTable tblTK;
	private JButton btnIn, btnreset, btnCT;
	private JComboBox<String>  cbbnam, cbbthang;
	private DefaultTableModel modeltk;
	private ScrollBarCustom scrollBarCustom1;
    private ScrollBarCustom sp;
    private ThongKe_BUS tkBUS= new ThongKe_BUS();
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private DecimalFormat dctt= new DecimalFormat("###,###,###");
    private CongNhan_BUS CN_BUS = new CongNhan_BUS();
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public ThongkeJpanel()  {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		setSize(912, 623);
		panel.setBackground(new Color(220, 20, 60));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		//
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
		
		txtsp = new JTextField();
		txtsp.setBackground(Color.RED);
		txtsp.setForeground(Color.WHITE);
		txtsp.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtsp.setHorizontalAlignment(SwingConstants.CENTER);
		txtsp.setText("250");
		txtsp.setBorder(null);
		txtsp.setEditable(false);
		txtsp.setBounds(20, 49, 58, 39);
		panel_4.add(txtsp);
		txtsp.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		jpl_SP.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIconTextGap(8);
		lblNewLabel_1.setSize(new Dimension(99, 88));
		lblNewLabel_1.setIcon(new ImageIcon("Icons\\icons_jplThongke\\sp03.png"));
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
		
		txtCN = new JTextField();
		txtCN.setText("250");
		txtCN.setHorizontalAlignment(SwingConstants.CENTER);
		txtCN.setForeground(Color.WHITE);
		txtCN.setBorder(null);
		txtCN.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtCN.setEditable(false);
		txtCN.setColumns(10);
		txtCN.setBackground(new Color(0, 255, 127));
		txtCN.setBounds(20, 49, 58, 39);
		panel_2.add(txtCN);
		
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
		
		txtNV = new JTextField();
		txtNV.setText("250");
		txtNV.setHorizontalAlignment(SwingConstants.CENTER);
		txtNV.setForeground(Color.WHITE);
		txtNV.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtNV.setEditable(false);
		txtNV.setColumns(10);
		txtNV.setBorder(null);
		txtNV.setBackground(new Color(255, 215, 0));
		txtNV.setBounds(14, 49, 58, 39);
		panel_1.add(txtNV);
		
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
		
		txtLuong = new JTextField();
		txtLuong.setBounds(0, 52, 93, 25);
		panel_8.add(txtLuong);
		txtLuong.setText("15.000.000");
		txtLuong.setHorizontalAlignment(SwingConstants.CENTER);
		txtLuong.setForeground(Color.WHITE);
		txtLuong.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtLuong.setEditable(false);
		txtLuong.setColumns(10);
		txtLuong.setBorder(null);
		txtLuong.setBackground(new Color(128, 128, 128));
		
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
		
		txtCD = new JTextField();
		txtCD.setText("250");
		txtCD.setHorizontalAlignment(SwingConstants.CENTER);
		txtCD.setForeground(Color.WHITE);
		txtCD.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtCD.setEditable(false);
		txtCD.setColumns(10);
		txtCD.setBorder(null);
		txtCD.setBackground(new Color(119, 136, 153));
		txtCD.setBounds(0, 60, 93, 17);
		panel_7.add(txtCD);
		
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
		String[] cols= {"Mã nhân sự","Họ và tên","Phụ cấp","tiền thưởng","Tổng lương"};
		modeltk= new DefaultTableModel(cols,0);
		tblTK = 
				new JTable(modeltk);
		tblTK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblTK.setEnabled(false);
		tblTK.setSelectionBackground(new Color(0, 0, 255));
		tblTK.setColumnSelectionAllowed(true);
		tblTK.setCellSelectionEnabled(true);
		tblTK.setGridColor(new Color(0, 0, 0));
		tblTK.setInheritsPopupMenu(true);
		tblTK.setSurrendersFocusOnKeystroke(true);
		tblTK.setSize(new Dimension(0, 50));
		tblTK.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTK.setSelectionForeground(new Color(255, 255, 255));
		tblTK.setRowMargin(10);
		tblTK.setRowHeight(30);
		tblTK.setPreferredScrollableViewportSize(new Dimension(450, 600));
		tblTK.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tblTK.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		 centerRenderer.setBackground(Color.blue);
		 centerRenderer.setForeground(Color.black);
		 centerRenderer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 
	       for(int i=0;i<tblTK.getModel().getColumnCount();i++) {
	    	   tblTK.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
	       }
	     
	    

		tblTK.getColumnModel().getColumn(0).setPreferredWidth(79);
		tblTK.getColumnModel().getColumn(0).setMinWidth(19);
		tblTK.getColumnModel().getColumn(0).setMaxWidth(2147483642);
		scrollPane.setViewportView(tblTK);
		
		JPanel pblbangluong = new JPanel();
		pblbangluong.setBackground(new Color(245, 245, 245));
		pblbangluong.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "B\u1EA2NG TH\u1ED0NG K\u00CA C\u00D4NG NH\u00C2N TI\u00CAU BI\u1EC2U", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pblbangluong.setBounds(10, 243, 884, 326);
		panel_center.add(pblbangluong);
		pblbangluong.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tháng:");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(90, 293, 69, 33);
		pblbangluong.add(lblNewLabel_4_1);
		
		 cbbthang = new JComboBox();
		cbbthang.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cbbthang.setAutoscrolls(true);
		cbbthang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbbthang.setForeground(new Color(0, 0, 0));
		cbbthang.setBackground(new Color(255, 255, 255));
		cbbthang.setModel(new DefaultComboBoxModel(new String[] {"12", "11", "10", "09", "08", "07", "05", "04", "03", "02", "01"}));
		cbbthang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cbbthang.setBorder(null);
		cbbthang.setBounds(174, 293, 61, 28);
		pblbangluong.add(cbbthang);
		
		JLabel lblNewLabel_4 = new JLabel("Năm:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(296, 293, 69, 33);
		pblbangluong.add(lblNewLabel_4);
		
		 btnreset = new JButton("Làm mới");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnreset.setBackground(new Color(0, 191, 255));
		btnreset.setAutoscrolls(true);
		btnreset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnreset.setForeground(new Color(0, 0, 0));
		btnreset.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\details.png"));
		btnreset.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnreset.setBounds(602, 293, 114, 30);
		pblbangluong.add(btnreset);
		
		 btnCT = new JButton("Chi tiết");
	
		btnCT.setDefaultCapable(false);
		btnCT.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCT.setBackground(new Color(0, 191, 255));
		btnCT.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\baseline_print_black_24dp.png"));
		btnCT.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnCT.setBounds(747, 293, 114, 30);
		pblbangluong.add(btnCT);
		
		cbbnam = new JComboBox();
		cbbnam.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2019", "2018", "2017"}));
		cbbnam.setForeground(new Color(0, 0, 0));
		cbbnam.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cbbnam.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cbbnam.setBorder(null);
		cbbnam.setBackground(Color.WHITE);
		cbbnam.setAutoscrolls(true);
		cbbnam.setBounds(353, 293, 78, 28);
		pblbangluong.add(cbbnam);
		HienThiThongKe();
		loaddatatotable();
		
		// gán sự kiện
		cbbnam.addItemListener(this);
		cbbthang.addItemListener(this);
		btnreset.addActionListener(this);
	btnCT.addActionListener(this);
	}
	public void HienThiThongKe() {
		Thongke tk= tkBUS.thongke();
		txtCD.setText(dcf.format(tk.getSoLuongCongDoan()));
		txtCN.setText(dcf.format(tk.getSoLuongCongNhan()));
		txtNV.setText(dcf.format(tk.getSoLuongNhanVien()));
		txtsp.setText(dcf.format(tk.getSoLuongSanPham()));
		txtLuong.setText(dctt.format(tk.getTongLuong()));
		
	}
	public void loaddatatotable() {
		ArrayList<BangLuongCongNhan> dsCN=tkBUS.getALLblcnAVG();
		for(BangLuongCongNhan cn:dsCN) {
			String hoten=cn.getCongNhan().getTen();

			Object[] row= {cn.getCongNhan().getMaCongNhan(),hoten,cn.getPhuCap(), cn.getTienThuong(),dctt.format(cn.getThucLanh())};
			modeltk.addRow(row);
			
		}
		}
	public void cbbThangCN() {
		String thang=cbbthang.getSelectedItem().toString();
		modeltk.setRowCount(0);
		int stt=0;
		for(BangLuongCongNhan cn: tkBUS.getCNthang(thang))
		{
			String hoten=cn.getCongNhan().getTen();

			Object[] row= {cn.getCongNhan().getMaCongNhan(),hoten,cn.getPhuCap(), cn.getTienThuong(),dctt.format(cn.getThucLanh())};
			modeltk.addRow(row);
			
		}
	}
	public void cbbNamCN() {
		String nam=cbbnam.getSelectedItem().toString();
		modeltk.setRowCount(0);
		int stt=0;
		for(BangLuongCongNhan cn: tkBUS.getCNnam(nam)) {
			
			String hoten=cn.getCongNhan().getTen();

			Object[] row= {cn.getCongNhan().getMaCongNhan(),hoten,cn.getPhuCap(), cn.getTienThuong(),dctt.format(cn.getThucLanh())};
			modeltk.addRow(row);		
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnreset)) {
			modeltk.setRowCount(0);
			loaddatatotable();
		}
		if(o.equals(btnCT)) {
			new DlgthongkeThang().setVisible(true);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(cbbthang))
		{
			modeltk.setRowCount(0);
			cbbThangCN();;
		}
		if(o.equals(cbbnam))
		{
			modeltk.setRowCount(0);
			cbbNamCN();
		}
	}
	
}
