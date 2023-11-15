package App_QLLuong;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BUS.CongDoanSanPham_BUS;
import BUS.CongNhan_BUS;
import BUS.PhanCongCongDoan_BUS;
import BUS.SanPham_BUS;
import DAO.CongDoanSanPham_DAO;
import DAO.CongNhan_DAO;
import DAO.ConnectDB;
import DAO.SanPham_DAO;
import DTO.CongDoanSanPham;
import DTO.CongNhan;
import DTO.NhanVien;
import DTO.PhanCongCongDoan;
import DTO.SanPham;
import MyCustom.MyDialog;
import CustomGUi.ScrollBarCustom;
import utilities.DateChooserUtils;
import utilities.ProcessDate;
import utilities.Snippet;

import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.DoubleAdder;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class PhancongJPanel extends JPanel implements MouseListener,ActionListener,ItemListener {
	private JTextField txtTimCN;
	private JTable tblCN;
	private JTable tblSP;
	private JTable tblCD;
	private JTable tblPC;
	private JButton btnreset;
	private JButton btnthem;
	private JButton btnsua;
	private JButton btnxoa;
	private JButton btntim;
	private JComboBox<String> cboCD;
	private JComboBox<String> cboSP;
	private JDateChooser jdcngayBD;
	private DefaultTableModel modelCN, modelSP, modelCD,modelPC;
	private JTextField txtmaCN;
	
	private JTextField txthoTen;
	private JTextField txtmaCD;
	private JTextField txttenCD;
	private JTextField txtmaSP;
	private JTextField txttenSP;
	private	CongNhan_BUS CN_BUS= new CongNhan_BUS();
	private SanPham_DAO  SP_DAO= new SanPham_DAO();
	private CongDoanSanPham_DAO cd_DAO;
//	private SanPham_DAO SP_BUS;
	private PhanCongCongDoan_BUS PC_BUS= new PhanCongCongDoan_BUS();
	private CongDoanSanPham_BUS CongDoanSP_BUS1= new CongDoanSanPham_BUS();
//	private CongDoanSanPham_DAO CongDoanSP_BUS = new CongDoanSanPham_DAO
	private JTextField txtsl;
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyy");
//	private CongNhan_DAO cnDAO= new CongNhan_DAO();

	/**
	 * Create the panel.
	 */
	public PhancongJPanel() {
		setSize(912,623);
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setLayout(null);
	
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "PH\u00C2N C\u00D4NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 0, 912, 623);
		panel.add(panel_1);
		panel_1.setLayout(null);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel Jpl_CN = new JPanel();
		Jpl_CN.setBorder(new TitledBorder(null, "C\u00F4ng nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Jpl_CN.setBounds(10, 25, 308, 171);
		panel_1.add(Jpl_CN);
		Jpl_CN.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm theo mã CN:\r\n");
		lblNewLabel.setBounds(10, 21, 143, 21);
		Jpl_CN.add(lblNewLabel);
		
		txtTimCN = new JTextField();
		txtTimCN.setBounds(133, 21, 129, 21);
		Jpl_CN.add(txtTimCN);
		txtTimCN.setColumns(10);
		
		 btntim = new JButton("");
		btntim.setBackground(new Color(30, 144, 255));
		btntim.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btntim.setIcon(new ImageIcon("D:\\Desktop\\Kỳ1_23-24\\Phát Triển Ứng Dụng\\CK\\App_QLluongSP_nhom16_JV\\App_QLluongSP_nhom16_JV\\src\\Icons\\chamcong\\tim.png"));
		btntim.setBounds(262, 21, 33, 22);
		Jpl_CN.add(btntim);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 53, 285, 115);
		Jpl_CN.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setAutoscrolls(true);
		
		panel_3.add(scrollPane, BorderLayout.CENTER);
		String[] cols = {"Mã Công Nhân","Họ và tên"};
		modelCN= new DefaultTableModel(cols,0);
		tblCN = new JTable(modelCN);
//		tblCN.setModel(new DefaultTableModel
		tblCN.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollPane.setViewportView(tblCN);
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollPane.setHorizontalScrollBar(sp);
		
		JPanel JblSP_CD = new JPanel();
		JblSP_CD.setBorder(new TitledBorder(null, "C\u00F4ng \u0111o\u1EA1n v\u00E0 s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		JblSP_CD.setBounds(357, 25, 526, 171);
		panel_1.add(JblSP_CD);
		JblSP_CD.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sản phẩm:");
		lblNewLabel_1.setBounds(10, 22, 69, 14);
		JblSP_CD.add(lblNewLabel_1);
		// ComboBox đẩy vào tên sản phẩm
		ArrayList<String> listtensp= new ArrayList<String>();
		for(SanPham sP : SP_DAO.getAllSanPham()) {
			listtensp.add(sP.getTenSanPham());
		}
		DefaultComboBoxModel<String> modeljcbo= new DefaultComboBoxModel<>(listtensp.toArray(new String[0]));
		
		cboSP = new JComboBox(modeljcbo);
		cboSP.setAutoscrolls(true);
		cboSP.setBorder(null);
		cboSP.setBackground(new Color(255, 255, 255));

		cboSP.setBounds(74, 18, 119, 18);
//		  comboBox.setUI(new customgui.ScrollBarCustom());
		JblSP_CD.add(cboSP);
		
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 47, 208, 113);
		JblSP_CD.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, BorderLayout.CENTER);
		String[] cols1= {"Mã Sản Phẩm","Tên Sản Phẩm"};
		modelSP= new DefaultTableModel(cols1,0);
		
	
		tblSP= new JTable(modelSP);
		scrollPane_1.setViewportView(tblSP);
		scrollPane_1.setVerticalScrollBar(new ScrollBarCustom());
       
        scrollPane_1.setHorizontalScrollBar(sp);
		JLabel lblNewLabel_1_1 = new JLabel("Công đoạn:");
		lblNewLabel_1_1.setBounds(269, 22, 69, 14);
		JblSP_CD.add(lblNewLabel_1_1);
		ArrayList<String> listtencd= new ArrayList<String>();
		for(CongDoanSanPham cd: CongDoanSP_BUS1.getAllCongDoanSP()) {
			listtencd.add(cd.getTenCongDoan());
		}
		DefaultComboBoxModel<String> modelCboCD= new DefaultComboBoxModel<>(listtencd.toArray(new String[0]));
		
	cboCD = new JComboBox(modelCboCD);
		cboCD.setAutoscrolls(true);

		cboCD.setBorder(null);
		cboCD.setBackground(new Color(255, 255, 255));
		cboCD.setBounds(370, 20, 119, 18);
		JblSP_CD.add(cboCD);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(261, 47, 255, 113);
		JblSP_CD.add(scrollPane_1_1);
		String[] cols2= {"Mã Công Đoạn" , "Tên Công Đoạn"};
		modelCD= new DefaultTableModel(cols2,0);
		tblCD = new JTable(modelCD);

		scrollPane_1_1.setViewportView(tblCD);
		scrollPane_1_1.setVerticalScrollBar(new ScrollBarCustom());
       
        scrollPane_1_1.setHorizontalScrollBar(sp);
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Th\u00F4ng tin ph\u00E2n c\u00F4ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(20, 207, 892, 405);
		panel_1.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("THÔNG TIN PHÂN CÔNG");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Mã công nhân:");
		lblNewLabel_3.setBounds(34, 11, 95, 24);
		panel_6.add(lblNewLabel_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 151, 880, 212);
		panel_6.add(scrollPane_2);
		String[] colsPC= {"Mã Công Nhân","Tên Công Nhân","Ngày Bắt đầu","Tên sản phẩm","Tên công đoạn", "Số Lượng"};
		modelPC = new DefaultTableModel(colsPC,0);
		tblPC = new JTable(modelPC);

		scrollPane_2.setViewportView(tblPC);
		scrollPane_2.setVerticalScrollBar(new ScrollBarCustom());
        
        scrollPane_2.setHorizontalScrollBar(sp);
		JLabel lblNewLabel_3_1 = new JLabel("Họ và tên :");
		lblNewLabel_3_1.setBounds(34, 46, 71, 24);
		panel_6.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Ngày bắt đầu:\r\n");
		lblNewLabel_3_1_1.setBounds(34, 100, 95, 24);
		panel_6.add(lblNewLabel_3_1_1);
		
		 jdcngayBD = new JDateChooser();
		 jdcngayBD.setDateFormatString("dd-MM-yyyy");
		jdcngayBD.setAutoscrolls(true);
		
		jdcngayBD.setBackground(new Color(255, 255, 255));
		jdcngayBD.setBorder(null);
		jdcngayBD.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_6.add(jdcngayBD);
		jdcngayBD.setBounds(123,100,124,24);
		
		JLabel lblNewLabel_3_2 = new JLabel("Mã công đoạn :\r\n\r\n");
		lblNewLabel_3_2.setBounds(279, 11, 114, 24);
		panel_6.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Tên công đoạn :\r\n");
		lblNewLabel_3_3.setBounds(275, 46, 118, 24);
		panel_6.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Mã sản phẩm :\r\n");
		lblNewLabel_3_4.setBounds(587, 11, 114, 24);
		panel_6.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Tên sản phẩm :\r\n");
		lblNewLabel_3_5.setBounds(583, 51, 118, 24);
		panel_6.add(lblNewLabel_3_5);
		
		txtmaCN = new JTextField();
		txtmaCN.setBorder(new LineBorder(Color.BLACK));
		txtmaCN.setEditable(false);
		txtmaCN.setBounds(116, 13, 131, 20);
		panel_6.add(txtmaCN);
		txtmaCN.setColumns(10);
		
		txthoTen = new JTextField();
		txthoTen.setBorder(new LineBorder(Color.BLACK));
		txthoTen.setEditable(false);
		txthoTen.setColumns(10);
		txthoTen.setBounds(115, 48, 131, 20);
		panel_6.add(txthoTen);
		
		txtmaCD = new JTextField();
		txtmaCD.setBorder(new LineBorder(Color.BLACK));
		txtmaCD.setEditable(false);
		txtmaCD.setColumns(10);
		txtmaCD.setBounds(389, 13, 131, 20);
		panel_6.add(txtmaCD);
		
		txttenCD = new JTextField();
		txttenCD.setBorder(new LineBorder(Color.BLACK));
		txttenCD.setEditable(false);
		txttenCD.setColumns(10);
		txttenCD.setBounds(389, 48, 131, 20);
		panel_6.add(txttenCD);
		
		txtmaSP = new JTextField();
		txtmaSP.setBorder(new LineBorder(Color.BLACK));
		txtmaSP.setEditable(false);
		txtmaSP.setColumns(10);
		txtmaSP.setBounds(695, 13, 131, 20);
		panel_6.add(txtmaSP);
		
		txttenSP = new JTextField();
		txttenSP.setBorder(new LineBorder(Color.BLACK));
		txttenSP.setEditable(false);
		txttenSP.setColumns(10);
		txttenSP.setBounds(705, 53, 131, 20);
		panel_6.add(txttenSP);
		
		btnthem = new JButton("Thêm\r\n");
		btnthem.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnthem.setBackground(new Color(30, 144, 255));
		btnthem.setIcon(new ImageIcon(PhancongJPanel.class.getResource("/Icons/chamcong/them.png")));
		btnthem.setBounds(546, 101, 87, 23);
		panel_6.add(btnthem);
		
	 btnsua = new JButton("Sửa");
		btnsua.setBackground(new Color(30, 144, 255));
		btnsua.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnsua.setIcon(new ImageIcon(PhancongJPanel.class.getResource("/Icons/icons_sp/editing.png")));
		btnsua.setBounds(643, 101, 87, 23);
		panel_6.add(btnsua);
		
	
		btnxoa = new JButton("xóa");
		btnxoa.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnxoa.setBackground(new Color(30, 144, 255));
		btnxoa.setIcon(new ImageIcon(PhancongJPanel.class.getResource("/Icons/icons_sp/bin.png")));
		btnxoa.setBounds(746, 101, 95, 23);
		panel_6.add(btnxoa);
		
		 btnreset = new JButton("Làm mới\r\n");
		btnreset.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnreset.setBackground(new Color(30, 144, 255));
		btnreset.setIcon(new ImageIcon(PhancongJPanel.class.getResource("/Icons/icons_sp/refresh.png")));
		btnreset.setBounds(446, 101, 87, 23);
		panel_6.add(btnreset);
		
		JLabel lblNewLabel_4 = new JLabel("Số lượng :");
		lblNewLabel_4.setBounds(276, 105, 71, 14);
		panel_6.add(lblNewLabel_4);
		
		txtsl = new JTextField();
		txtsl.setBounds(336, 102, 86, 20);
		panel_6.add(txtsl);
		txtsl.setColumns(10);
		
		// set mau table
		 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		 centerRenderer.setBackground(new Color(30,144,255));
		 centerRenderer.setForeground(Color.black);
		 centerRenderer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 
	       for(int i=0;i<tblPC.getModel().getColumnCount();i++) {
	    	   tblPC.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
	       }

	       for(int i=0;i<tblCN.getModel().getColumnCount();i++) {
	    	   tblCN.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
	       }

	       for(int i=0;i<tblSP.getModel().getColumnCount();i++) {
	    	   tblSP.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
	       }

	       for(int i=0;i<tblCD.getModel().getColumnCount();i++) {
	    	   tblCD.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
	       }
		//load lên table
	       for(CongDoanSanPham cd:CongDoanSP_BUS1.getAllCongDoanSP()) {
				
	   		
				Object[] row= {cd.getMaCongDoan(),cd.getTenCongDoan()};
				modelCD.addRow(row);
			}
		addatatotbleSP();
		adddatatotbleCN();
//		ArrayList<PhanCongCongDoan> dsPC = PC_BUS.getAllPhanCongCD();
//		for(PhanCongCongDoan pc: dsPC) {
//			CongNhan cn= timkiemtheomaCN(pc.getMaCN());
////			String date=df.format(pc.getNgayBatDau());
////			ArrayList<SanPham> sp=SP_DAO.getSanPhamTheoMa(pc.getMaSP());
//			String ngayBatdau=pc.getNgayBatDau().format(formatter);
//			String ten=pc.getMaSP();
////			SanPham sp1 = new SanPham() ;
////			for( SanPham sp11 : SP_DAO.getAllSanPham()) {
////				if(sp11.getMaSanPham().equalsIgnoreCase(ten)){
////				if((sp.getMaSanPham().equalsIgnoreCase(ten))) {
////					String tencd=pc.getMaCD();
////					CongDoanSanPham cd2=new CongDoanSanPham();
////					String tenCD= new String();
////					for(CongDoanSanPham cd : CongDoanSP_BUS1.getAllCongDoanSP()) {
////						if(cd.getMaCongDoan().equalsIgnoreCase(ten)) {
////							tenCD.equals( cd.getTenCongDoan());
////						}
////					}
//					
//				
////					ArrayList<CongDoanSanPham> cd= cd_DAO.get
//					Object[] row= {pc.getMaCN(),cn.getTen(),ngayBatdau,pc.getMaSP(),pc.getMaCD(),pc.getSoLuongCongDoanPhanCong()};
//					modelPC.addRow(row);
//					break;
//				}
			
			
			
		
//		addatatotbleCDSP();
		addatatotblePCCD();
		// add sự kiện
		btnreset.addActionListener(this);
		btnsua.addActionListener(this);
		btnthem.addActionListener(this);
		btnxoa.addActionListener(this);
		btntim.addActionListener(this);
		tblCN.addMouseListener(this);
		tblSP.addMouseListener(this);
		tblCD.addMouseListener(this);
		tblPC.addMouseListener(this);
		cboCD.addItemListener(this);
		cboSP.addItemListener(this);
		
		
		
		
	}
	public void addatatotbleSP() {
		
		for(SanPham sp : SP_DAO.getAllSanPham()) {
//			listtensp.add(sP.getTenSanPham());
//		}
//		for(SanPham sp:SP_DAO.getAllSanPham()) {
			
			Object[] row= {sp.getMaSanPham(),sp.getTenSanPham()};
			modelSP.addRow(row);
		}
	}
	public void addatatotbleCDSP() {
		for(CongDoanSanPham cd:CongDoanSP_BUS1.getAllCongDoanSP()) {
			
		
			Object[] row= {cd.getMaCongDoan(),cd.getTenCongDoan()};
			modelCD.addRow(row);
		}
	}
	public void adddatatotbleCN() {
		modelCN.setRowCount(0);
//		CN_BUS.docDanhSachCN();
		ArrayList<CongNhan> dsCN= CN_BUS.getDanhSachCongNhan();
//		ArrayList<NhanVien> dsnv = nhanVienBUS.getDanhSachNhanVien();
			for(CongNhan cn : dsCN) {
				String hotenCN= cn.getTen();
				Object[] row = {cn.getMaCongNhan(),hotenCN};
				modelCN.addRow(row);
			}
		
	}
	public void addatatotblePCCD() {
		modelPC.setRowCount(0);
		ArrayList<PhanCongCongDoan> dsPC = PC_BUS.getAllPhanCongCD();
		for(PhanCongCongDoan pc: dsPC) {
			CongNhan cn= timkiemtheomaCN(pc.getMaCN());
//			String date=df.format(pc.getNgayBatDau());
//			ArrayList<SanPham> sp=SP_DAO.getSanPhamTheoMa(pc.getMaSP());
			String ngayBatdau=pc.getNgayBatDau().format(formatter);
			SanPham sp= timkiemtheoten(pc.getMaSP());
			CongDoanSanPham cd=timkiemtheotenCD(pc.getMaCD());
//			ArrayList<CongDoanSanPham> cd= cd_DAO.get
			Object[] row= {pc.getMaCN(),cn.getTen(),ngayBatdau,sp.getTenSanPham(),cd.getTenCongDoan(),pc.getSoLuongCongDoanPhanCong()};
			modelPC.addRow(row);
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o= e.getSource();
		if(o.equals(tblCN)) {
			int row= tblCN.getSelectedRow();
			if(row!=-1) {
			
			txtmaCN.setText(modelCN.getValueAt(row, 0).toString());
			txthoTen.setText(modelCN.getValueAt(row, 1).toString());
			}
		}
		else if(o.equals(tblSP)) {
			int row= tblSP.getSelectedRow();
			if(row!=-1) {
			txtmaSP.setText(modelSP.getValueAt(row, 0).toString());
			txttenSP.setText(modelSP.getValueAt(row, 1).toString());
			}
		}
		else if(o.equals(tblCD)) {
			try {
				ConnectDB.getInstance().connect();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int row= tblCD.getSelectedRow();
			if(row!=-1) {
			txtmaCD.setText(modelCD.getValueAt(row, 0).toString());
			txttenCD.setText(modelCD.getValueAt(row, 1).toString());
			}
			
		}
		else if(o.equals(tblPC)) {
			try {
				ConnectDB.getInstance().connect();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int row=tblPC.getSelectedRow();
			if(row!=-1) {
			
				txtmaCN.setText(modelPC.getValueAt(row, 0).toString());
			
				txthoTen.setText(modelPC.getValueAt(row, 1).toString());
				java.util.Date ngayBD;
				try {
					String ngayBd=modelPC.getValueAt(row, 2).toString();
					ngayBD = df.parse(ngayBd);
					jdcngayBD.setDate(ngayBD);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtsl.setText(modelPC.getValueAt(row, 5).toString());
				SanPham sp= timkiemtheoten(modelPC.getValueAt(row,3).toString());
				txtmaSP.setText(sp.getMaSanPham());
			txttenSP.setText(modelPC.getValueAt(row, 3).toString());
			
//			for(SanPham sp: SP_DAO.getAllSanPham()) {
//				String ma= modelPC.getValueAt(row, 3).toString();
//				if(sp.getMaSanPham().equalsIgnoreCase(ma)) {
//					txtmaSP.setText(sp.getMaSanPham());
//					txttenSP.setText(sp.getTenSanPham());
//				}
//			}
//			SanPham sp= timkiemtheoten(modelPC.getValueAt(row,3).toString());
//			txtmaSP.setText(sp.getMaSanPham());
			CongDoanSanPham cd= timkiemtheotenCD(modelPC.getValueAt(row,4).toString());
			txtmaCD.setText(cd.getMaCongDoan());
			txttenCD.setText(modelPC.getValueAt(row,4).toString());
			
			
			
//				
//			}
//		}
		
		
	}}}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob.equals(btnreset)) {
			setTextRong();
		}
		else if(ob.equals(btntim)) {
			modelCN.setRowCount(0);
			loadCNtheoma();
		}
//		else if(ob.equals(btntim)) {
//			String ma=txtTimCN.getText();
//			CongNhan cn= timkiemtheomaCN(ma);
//			txtmaCD.setText(ma);
//			txtmaCN.setText(ma);
//			ArrayList<CongNhan> dsCN= CN_BUS.getAllCongNhan();
//			modelCN.setRowCount(0);
//			for(CongNhan cn: dsCN) 
//				if(cn.getMaCongNhan().equalsIgnoreCase(ma)){
//					JOptionPane.showMessageDialog(this, "mã công nhân là "+cn.getTen());
//					String hoten=cn.getHoDem()+" "+cn.getTen();
//					Object[] row01 = {ma,hoten};
//					
//				}
			
//			if(cn!=null) {
			
//			}
//			else {
//				JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại.");
//			}
			
//		}
		else if(ob.equals(btnthem)) {
			String ma=txtmaCN.getText();
			if((txtmaCN.getText().equals("")||txtmaCD.getText().equals("")||txtmaSP.getText().equals("")||txtsl.getText().equals("")||jdcngayBD.getDate()==null)) {
				new MyDialog("Điền đầy đủ thông tin.", MyDialog.WARNING_DIALOG);
			}
			else if(DateChooserUtils.isDateBeforeToday(jdcngayBD)==false) {
				new MyDialog("Phải trước ngày hiện tại", MyDialog.WARNING_DIALOG);
			}
			else if(ktCN_PC(ma))
				new MyDialog("Thêm thất bại.\nCông nhân đã được phân công trước đó.", MyDialog.WARNING_DIALOG);
			else
			{
				LocalDate date= Snippet.convertJDateChooserToLocalDate(jdcngayBD);
				if(PC_BUS.themPhanCongCongDoan(txtmaCN.getText(),txtmaSP.getText(),txtmaCD.getText(),Integer.parseInt(txtsl.getText()) ,date)) {
					String ngayBD=df.format(jdcngayBD.getDate());
					Object[] row= {txtmaCN.getText(),txthoTen.getText(),ngayBD,txttenSP.getText(),txttenCD.getText(),txtsl.getText()
					};
					modelPC.addRow(row);
//					new MyDialog("Thêm thành công!",MyDialog.SUCCESS_DIALOG);
				}
				
			}
//			String date=df.format(jdcngayBD.getDate());
//			Object[] row= {txtmaCN.getText(),txthoTen.getText(),date,txttenSP.getText(),txttenCD.getText(),txtsl.getText()
//			};
//			modelPC.addRow(row);
//			new MyDialog("Thêm thành công!",MyDialog.SUCCESS_DIALOG);
		}
		else if(ob.equals(btnxoa)) {
			int row= tblPC.getSelectedRow();
			if(row==-1) {
				new MyDialog("Vui lòng chọn công nhân cần xóa.",MyDialog.WARNING_DIALOG );
			
			}
			xylyXoaPhanCong();
			setTextRong();
		
		}
		else if(ob.equals(btnsua)) {
			setEditnaltxt();
			xulyupdatePC();
		}
		
		
	}
	public void setTextRong() {
		txthoTen.setText("");
		txtmaCD.setText("");
		txtmaCN.setText("");
		txttenCD.setText("");
		txttenSP.setText("");
		txtmaSP.setText("");
		txtsl.setText("");
		jdcngayBD.setDate(null);
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object obj= e.getSource();
		if(obj.equals(cboSP)) {
			String tenSP=cboSP.getSelectedItem().toString();
			SanPham sptim=timkiemtheoten(tenSP);
			modelSP.setRowCount(0);
			Object[] row = {sptim.getMaSanPham(),sptim.getTenSanPham()};
			modelSP.addRow(row);
		}
		if(obj.equals(cboCD)) {
			String tenCD=cboCD.getSelectedItem().toString();
		CongDoanSanPham cd= timkiemtheotenCD(tenCD);
			modelCD.setRowCount(0);
			Object[] row = {cd.getMaCongDoan(),cd.getTenCongDoan()};
			modelCD.addRow(row);
		}
		
	}
	// một số pp 
	private SanPham timkiemtheoten(String ten) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(SanPham sp: SP_DAO.getAllSanPham()) {
			if((sp.getTenSanPham().equalsIgnoreCase(ten))||(sp.getMaSanPham().equalsIgnoreCase(ten))) {
//			if((sp.getMaSanPham().equalsIgnoreCase(ten))) {
				return sp;
			}
		}
		return null;
	}
	public CongDoanSanPham timkiemtheotenCD(String ten) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(CongDoanSanPham cd : CongDoanSP_BUS1.getAllCongDoanSP()) {
			if((cd.getTenCongDoan().equalsIgnoreCase(ten))||(cd.getMaCongDoan().equalsIgnoreCase(ten))) {
				return cd;
			}
		}
		return null;
	}
	public CongNhan timkiemtheomaCN(String ma) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<CongNhan> dsCN= CN_BUS.getDanhSachCongNhan();
		for(CongNhan cn : dsCN) {
			if(cn.getMaCongNhan().equals(ma)) {
				return cn;
			}
		}
		return null;
	}
	public void loadCNtheoma() {
		String ma=txtTimCN.getText();
		if(!(ma.length()>0&& ma.matches("^CN\\d{4}$"))){
			new MyDialog("Mã Công nhân không hợp lệ, mã phải bắt đầu là CN và tiếp theo là 4 số.", MyDialog.CANCEL_OPTION);
			txtTimCN.requestFocus();
		}
		else {
		ArrayList<CongNhan> dsCN=CN_BUS.getallCNtheoma(ma);
		for(CongNhan cn: dsCN) {
			Object[] row= {
					cn.getMaCongNhan(),cn.getTen()
			};
			modelCN.addRow(row);
		}
		if(modelCN.getRowCount()==0) {
			new MyDialog("Mã công nhân không tồn tại.", MyDialog.CANCEL_OPTION);
		}}
	}
	public void setEditnaltxt() {
		txtmaCN.setEditable(true);
		txthoTen.setEditable(true);
		txtmaCD.setEditable(true);
		txttenCD.setEditable(true);
		txtmaSP.setEditable(true);
		txttenSP.setEditable(true);
	
	}
	public PhanCongCongDoan getPhanCong() {
		PhanCongCongDoan cd= new PhanCongCongDoan();
		cd.setMaCD(txtmaCD.getText());
		cd.setMaCN(txtmaCN.getText());
		cd.setMaSP(txtmaSP.getText());
		LocalDate ngayBd=Snippet.convertJDateChooserToLocalDate(jdcngayBD);
		cd.setNgayBatDau(ngayBd);
		int soluong =Integer.parseInt(txtsl.getText());
		cd.setSoLuongCongDoanPhanCong(soluong);
		return cd;
		
	}
//	
		// xử lý sự kiện
	private void xylyXoaPhanCong() {
		String ma= txtmaCN.getText();
		boolean flag=PC_BUS.xoaPhanCongCongDoan(ma);
		if(flag) {
			PC_BUS.docDanhSach();
			addatatotblePCCD();
		}
	}
	private void xulyupdatePC() {
		PhanCongCongDoan pc=getPhanCong();
		boolean flag= PC_BUS.updateCongDoan(pc);
		if(flag) {
				PC_BUS.docDanhSach();
		addatatotblePCCD();
		}
	}
	public boolean ktCN_PC(String ma) {
		boolean flag=false;
		for(PhanCongCongDoan cd: PC_BUS.getAllPhanCongCD()) 
			if(cd.getMaCN().equals(ma)) 
				flag=true;
		
		return flag;
	}
	
}
