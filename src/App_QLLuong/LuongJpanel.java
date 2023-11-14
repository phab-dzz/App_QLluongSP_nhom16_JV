package App_QLLuong;

import java.awt.Font;
import java.awt.Image;


import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import BUS.BangLuongCongNhan_BUS;
import BUS.BangLuongNhanVien_BUS;
import DAO.BangLuongNhanVien_DAO;
import DAO.ConnectDB;
import DAO.NhanVien_DAO;
import DTO.BangLuongCongNhan;
import DTO.BangLuongNhanVien;
import DTO.NhanVien;
import MyCustom.MyDialog;
import utilities.exportExcel;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;


public class LuongJpanel extends JPanel implements ActionListener, MouseListener,ItemListener  {
	private static final long serialVersionUID = 1L;
	private JTextField txtTKCN;
	private JTable tblluongCN;
	private JTable tblluongNV;
	private JComboBox cbbPhongBanNV,cbbMaXuong,cbbThang,cbbNam,cbbThang1,cbbNam1;
	private DefaultTableModel modelluongNV,modelluongCN;
	private JButton btnTimNV,btnreset,btnreset_2,btnIn,btnChitiet,btnChitietCN;
	private JTextField txtTKNV;
	private 	JButton btnTimCN;
	private int indexNV=0,indexCN=0;
	private BangLuongCongNhan_BUS LuongCN_BUS= new BangLuongCongNhan_BUS();
	private BangLuongNhanVien_BUS luongNV_BUS= new BangLuongNhanVien_BUS();
	private BangLuongNhanVien_DAO luongNVDAO= new BangLuongNhanVien_DAO();
	
	private NhanVien_DAO NV_DAO= new NhanVien_DAO();
	private DecimalFormat dcf= new DecimalFormat("###,###,###,###");
	
	public LuongJpanel(){
		
		//setSize(1100,1100);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(912, 623);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setUI(new CustomGUi.CustomTabbedPaneUI());
		tabbedPane.setBounds(0, 0, 915, 623);
		add(tabbedPane);
		    
		JPanel pnNhanVien = new JPanel();
		pnNhanVien.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("Nhân viên", null, pnNhanVien, null);
		tabbedPane.setEnabledAt(0, true);
		pnNhanVien.setLayout(null);
		 try {
				ConnectDB.getInstance().connect();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		JLabel lblPhongBan = new JLabel("Phòng ban :");
		lblPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhongBan.setBounds(26, 67, 90, 17);
		pnNhanVien.add(lblPhongBan);
		
		JLabel lblNam = new JLabel("Năm :");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNam.setBounds(474, 23, 63, 17);
		pnNhanVien.add(lblNam);
		
	 cbbNam = new JComboBox();
		cbbNam.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		cbbNam.setBackground(new Color(255, 255, 255));
		cbbNam.setBorder(null);
		cbbNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbNam.setBounds(562, 20, 101, 22);
		pnNhanVien.add(cbbNam);
		
		JLabel lblTKNV = new JLabel("Tìm kiếm nhân viên : ");
		lblTKNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTKNV.setBounds(20, 23, 145, 17);
		pnNhanVien.add(lblTKNV);
		
		JLabel lblGioLamViecNV = new JLabel("Tháng :");
		lblGioLamViecNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioLamViecNV.setBounds(474, 56, 77, 17);
		pnNhanVien.add(lblGioLamViecNV);
		
		 cbbThang = new JComboBox();
		cbbThang.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbbThang.setAutoscrolls(true);
		cbbThang.setBackground(new Color(255, 255, 255));
		cbbThang.setBorder(null);
		cbbThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThang.setBounds(562, 53, 101, 22);
		pnNhanVien.add(cbbThang);
		
		 btnChitiet = new JButton("Chi tiết\r\n");
		btnChitiet.setBackground(new Color(30, 144, 255));
		btnChitiet.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnChitiet.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\editing.png"));
		
		btnChitiet.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnChitiet.setBounds(623, 107, 90, 31);
		pnNhanVien.add(btnChitiet);
		ArrayList<String> listPB= new ArrayList<String>();
		for(NhanVien nv: NV_DAO.getDanhSachNhanVien()) {
//			if(!(nv.getPhongBan().equalsIgnoreCase(nv.get))
			listPB.add(nv.getPhongBan());
			
		}
		HashSet<String> uniqueSet = new HashSet<>(listPB);
		ArrayList<String> uniquelist= new ArrayList<>(uniqueSet);
		
		DefaultComboBoxModel<String> mldnv= new DefaultComboBoxModel<>(uniquelist.toArray(new String[0]));
		 cbbPhongBanNV = new JComboBox(mldnv);
		cbbPhongBanNV.setBackground(new Color(255, 255, 255));
		cbbPhongBanNV.setBorder(null);
		cbbPhongBanNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbPhongBanNV.setBounds(156, 64, 145, 22);
		pnNhanVien.add(cbbPhongBanNV);
		
		 btnIn = new JButton("Xuất excel");
		btnIn.setBackground(new Color(30, 144, 255));
		btnIn.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnIn.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\baseline_print_black_24dp.png"));
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnIn.setBounds(756, 107, 90, 31);
		pnNhanVien.add(btnIn);
		
		JScrollPane scrollPaneNV = new JScrollPane();
		scrollPaneNV.setBounds(10, 178, 890, 406);
		pnNhanVien.add(scrollPaneNV);
		
		JPanel pnCongNhan = new JPanel();
		pnCongNhan.setBackground(new Color(240, 240, 240));
		pnCongNhan.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("Công nhân", null, pnCongNhan, null);
		tabbedPane.setEnabledAt(1, true);
		pnCongNhan.setLayout(null);
		
		JLabel lblTKCN = new JLabel("Tìm kiếm công nhân :");
		lblTKCN.setBounds(28, 20, 150, 17);
		lblTKCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblTKCN);
		
		txtTKCN = new JTextField();
		txtTKCN.setBounds(169, 18, 167, 20);
		txtTKCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(txtTKCN);
		txtTKCN.setColumns(10);
		
		JLabel lblNam1 = new JLabel("Năm :");
		lblNam1.setBounds(486, 20, 63, 17);
		lblNam1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblNam1);
		
		 cbbNam1 = new JComboBox();
		cbbNam1.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		cbbNam1.setBorder(null);
		cbbNam1.setBackground(new Color(255, 255, 255));
		cbbNam1.setBounds(578, 17, 85, 22);
		cbbNam1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(cbbNam1);
		
		JLabel lblMaXuong = new JLabel("Mã xưởng :");
		lblMaXuong.setBounds(28, 64, 75, 17);
		lblMaXuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblMaXuong);
		
		ArrayList<String> listXuong= new ArrayList<String>();
		for(BangLuongCongNhan lcn: LuongCN_BUS.getDanhSachNhanVien()) {
//			if(!(nv.getPhongBan().equalsIgnoreCase(nv.get))
			listXuong.add(lcn.getCongNhan().getXuong());
			
		}
		HashSet<String> uniqueSet2 = new HashSet<>(listXuong);
		ArrayList<String> uniquelist2= new ArrayList<>(uniqueSet2);
		DefaultComboBoxModel<String> cbbxuongmld= new DefaultComboBoxModel<>(uniquelist2.toArray(new String[0]));
		cbbMaXuong = new JComboBox(cbbxuongmld);
		cbbMaXuong.setAutoscrolls(true);
		cbbMaXuong.setBorder(null);
		cbbMaXuong.setBackground(new Color(255, 255, 255));
		cbbMaXuong.setBounds(169, 61, 165, 22);
		cbbMaXuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(cbbMaXuong);
		
		JLabel lblThang1 = new JLabel("Tháng :");
		lblThang1.setBounds(486, 64, 69, 17);
		lblThang1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(lblThang1);
		
	 cbbThang1 = new JComboBox();
		cbbThang1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbbThang1.setBackground(new Color(255, 255, 255));
		cbbThang1.setBorder(null);
		cbbThang1.setBounds(578, 61, 85, 22);
		cbbThang1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnCongNhan.add(cbbThang1);
		
		
		JScrollPane scrollPaneCN = new JScrollPane();
		scrollPaneCN.setBounds(10, 186, 858, 384);
		pnCongNhan.add(scrollPaneCN);
		
		String[] colsCN= {"STT","Mã Công Nhân","Họ và tên","Số sản phẩm","số ngày nghỉ","Thực lãnh"};
		
		modelluongCN= new DefaultTableModel(colsCN,0);
		
		tblluongCN = new JTable(modelluongCN);
		tblluongCN.setFont(new Font("Tahoma", Font.PLAIN, 12));


		tblluongCN.getColumnModel().getColumn(2).setPreferredWidth(115);
		tblluongCN.getColumnModel().getColumn(4).setPreferredWidth(99);
		tblluongCN.getColumnModel().getColumn(5).setPreferredWidth(102);
		scrollPaneCN.setViewportView(tblluongCN);
		
	 btnChitietCN = new JButton("Chi tiết");
		btnChitietCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChitietCN.setBackground(new Color(30, 144, 255));
		btnChitietCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnChitietCN.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\editing.png"));
		btnChitietCN.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnChitietCN.setBounds(674, 101, 85, 31);
		pnCongNhan.add(btnChitietCN);
		
		JButton btnIn1 = new JButton("Xuất excel");
		btnIn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIn1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnIn1.setBackground(new Color(30, 144, 255));
		btnIn1.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_jplThongke\\baseline_print_black_24dp.png"));
		btnIn1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnIn1.setBounds(783, 100, 85, 32);
		pnCongNhan.add(btnIn1);
		
		JLabel lblDSLcn = new JLabel("Danh sách tiền lương công nhân");
		lblDSLcn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDSLcn.setBounds(280, 143, 336, 43);
		pnCongNhan.add(lblDSLcn);
		
	 btnTimCN = new JButton("");
		btnTimCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnTimCN.setBackground(new Color(30, 144, 255));
		btnTimCN.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\tim.png"));
		btnTimCN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimCN.setBounds(346, 15, 42, 22);
		pnCongNhan.add(btnTimCN);
		
		btnreset_2 = new JButton("Làm mới");
		btnreset_2.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\refresh.png"));
		btnreset_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnreset_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnreset_2.setBackground(new Color(30, 144, 255));
		btnreset_2.setBounds(558, 101, 85, 31);
		pnCongNhan.add(btnreset_2);
		
		String[] colsNV= {"STT","Mã nhân viên","Họ và tên","Tiền thưởng","Thực lãnh"};
		modelluongNV= new DefaultTableModel(colsNV,0);
		
		tblluongNV = new JTable(modelluongNV);
		tblluongNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TableColumn columnID = tblluongNV.getColumnModel().getColumn(0);
        columnID.setPreferredWidth(10);
//		tblluongNV.setModel(new DefaultTableModel(
//			new Object[][] {
//				{new Long(1L), "NV0001", "Nguyen Van A","20", "2", "8000000", "4300000"},
//			},
//			new String[] {
//				"STT", "MA NV", "HoTen", "So Ngay Lam", "So Gio Tang Ca", "Luong Co Ban", "ThucLanh"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				Long.class, String.class, String.class, String.class, String.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
		//table.getColumnModel().getColumn(4).setPreferredWidth(89);
		//table.getColumnModel().getColumn(5).setPreferredWidth(99);
		scrollPaneNV.setViewportView(tblluongNV);
		
		txtTKNV = new JTextField();
		txtTKNV.setBounds(156, 22, 145, 22);
		pnNhanVien.add(txtTKNV);
		txtTKNV.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Danh sách tiền lương nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(287, 138, 299, 40);
		pnNhanVien.add(lblNewLabel);
		
		 btnTimNV = new JButton("");
		btnTimNV.setBackground(new Color(30, 144, 255));
		btnTimNV.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnTimNV.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\tim.png"));
		btnTimNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimNV.setBounds(315, 23, 44, 23);
		pnNhanVien.add(btnTimNV);
		
		 btnreset = new JButton("Làm mới");
		btnreset.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\refresh.png"));
		btnreset.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnreset.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnreset.setBackground(new Color(30, 144, 255));
		btnreset.setBounds(516, 107, 77, 31);
		pnNhanVien.add(btnreset);
		loadtotblLuongNV();
		loadtoLuongCN();
		// gán màu
		 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		 centerRenderer.setBackground(new Color(30,144,255));
		 centerRenderer.setForeground(Color.black);
		 centerRenderer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 
	       for(int i=0;i<tblluongCN.getModel().getColumnCount();i++) {
	    	   tblluongCN.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
	       }
	       
	       for(int i=0;i<tblluongNV.getModel().getColumnCount();i++) {
	    	   tblluongNV.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
	       }

		
		// gán sự kiện
//		btn
		cbbPhongBanNV.addItemListener(this);
		cbbMaXuong.addItemListener(this);
		cbbNam.addItemListener(this);
		cbbThang.addItemListener(this);
		cbbNam1.addItemListener(this);
		cbbThang1.addItemListener(this);
		tblluongCN.addMouseListener(this);
		tblluongNV.addMouseListener(this);
		btnTimNV.addActionListener(this);
		btnTimCN.addActionListener(this);
		btnreset.addActionListener(this);
		btnIn.addActionListener(this);
		btnChitiet.addActionListener(this);
		btnChitietCN.addActionListener(this);
		btnreset_2.addActionListener(this);
	
		
		

	}
	//load data lên bang
	public void loadtotblLuongNV() {
		ArrayList<BangLuongNhanVien> dsBangluongNV= luongNVDAO.getALLbangluongNV();
				int stt=0;
		for(BangLuongNhanVien lcn : dsBangluongNV) {
			stt++;
		String hoten=lcn.getNv().getTen();
			Object[] row= {stt,lcn.getNv().getMaNhanVien(),hoten,lcn.getTienThuong(),dcf.format(lcn.getThucLanh())};
			modelluongNV.addRow(row);
			}
		}
	
	public void loadtoLuongCN() {
		ArrayList<BangLuongCongNhan> dsBangLuongCN= LuongCN_BUS.getDanhSachNhanVien();
		int stt=0;
		for(BangLuongCongNhan l: dsBangLuongCN) {
			stt++;
			String hoten =l.getCongNhan().getTen();
			Object[] row= { stt, l.getCongNhan().getMaCongNhan(),hoten," " ," ",l.getThucLanh()};
			modelluongCN.addRow(row);
			}
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(tblluongNV)) {
			
			int row=tblluongNV.getSelectedRow();
			if(row!=-1) {
				indexNV=row;
//				BangLuongNhanVien l= luongNV_BUS.getDsBangLuongNhanVien().get(row);
//				new DlgLuongNV(l).setVisible(true);
			
			}
		}
		else if(o.equals(tblluongCN)) {
			
			int row1=tblluongCN.getSelectedRow();
			if(row1!=-1) {
				indexCN=row1;
			}
		}
	}
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
		// TODO Auto-generated method stub
		Object o= e.getSource();
		if(o.equals(btnTimNV)) {
			modelluongNV.setRowCount(0);
			timkiemNVtheo_ma();
		}
		else if(o.equals(btnreset)) {
			modelluongNV.setRowCount(0);
			luongNV_BUS.docDanhSach();
			loadtotblLuongNV();
		}
		else if(o.equals(btnreset_2)) {
			modelluongCN.setRowCount(0);
			LuongCN_BUS.docDanhSach();
			loadtoLuongCN();
		}
		else if(o.equals(btnTimCN)) {
			modelluongCN.setRowCount(0);
			timkiemCNtheoma();
		}
//		else if(o.equals(btnIn)) {
//			int number= new Random().nextInt(1000,9999);
//			try {
//			exportToExcel(tblluongNV,"F:\\App_QLluongSP_nhom16_JV\\src\\data"+ number +".xlsx");
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
		else if(o.equals(btnChitiet)) {
			if(indexNV!=-1) {
			ArrayList<BangLuongNhanVien> dslNV= luongNV_BUS.getDsBangLuongNhanVien();
			BangLuongNhanVien l =dslNV.get(indexNV);
			new DlgInPDFNV(l).setVisible(true);
			}
		}
		else if(o.equals(btnChitietCN)) {
			if(indexCN!=-1) {
				JOptionPane.showMessageDialog(null, "so tt "+indexCN);
			ArrayList<BangLuongCongNhan> dslNV= LuongCN_BUS.getDanhSachNhanVien();
			BangLuongCongNhan l =dslNV.get(indexCN);
			new DlgInPDFCN(l).setVisible(true);
			}
		}
		
		
		
	}
	// một số phương thức sự kiện
	public void timkiemNVtheo_ma() {
		String ma= txtTKNV.getText();

		ArrayList<BangLuongNhanVien> dsBangTK=luongNV_BUS.timBangLuongNV(ma);
		boolean flag=false;
		int stt=0;
		for(BangLuongNhanVien l : dsBangTK) {

			String hoten=l.getNv().getTen();
			Object[] row= {stt,l.getNv().getMaNhanVien(),hoten,l.getTienThuong(),dcf.format(l.getThucLanh())};
			modelluongNV.addRow(row);
			flag=true;
		}
		if(modelluongNV.getRowCount()==0) {
			new MyDialog("Nhân viên không có trong danh sách bảng lương.",MyDialog.ERROR_DIALOG);
			
		}
		

	}
	public void timkiemCNtheoma() {
		String ma=txtTKCN.getText();
		ArrayList<BangLuongCongNhan> dsBangCNTK=LuongCN_BUS.timBangLuongCN(ma);
		int stt=0;
		for(BangLuongCongNhan l: dsBangCNTK) {
			
				stt++;
				String hoten =l.getCongNhan().getTen();
				Object[] row= { stt, l.getCongNhan().getMaCongNhan(),hoten," " ," ",l.getThucLanh()};
				modelluongCN.addRow(row);
			
		}
		if(modelluongCN.getRowCount()==0) {
			new MyDialog("Công nhân không có trong danh sách bảng lương.",MyDialog.ERROR_DIALOG);
			
		}
		
	}
	
		
	public void cbbPBNV_ten() {
		String tenPB=cbbPhongBanNV.getSelectedItem().toString();
		modelluongNV.setRowCount(0);
		int stt=0;
		for(BangLuongNhanVien l: luongNV_BUS.getDsBangLuongNhanVien()) {
			if(l.getNv().getPhongBan().equalsIgnoreCase(tenPB)) {
				stt++;
				String hoten=l.getNv().getTen();
				Object[] row= {stt,l.getNv().getMaNhanVien(),hoten,l.getTienThuong(),dcf.format(l.getThucLanh())};
				modelluongNV.addRow(row);
			}
		}
	}
	
	public void cbbmaXuong() {
		String tenPB=cbbMaXuong.getSelectedItem().toString();
		modelluongCN.setRowCount(0);
		int stt=0;
		for(BangLuongCongNhan l: LuongCN_BUS.getDanhSachNhanVien()) {
			if(l.getCongNhan().getXuong().equalsIgnoreCase(tenPB)) {
				stt++;
				String hoten =l.getCongNhan().getTen();
				Object[] row= { stt, l.getCongNhan().getMaCongNhan(),hoten," " ," ",l.getThucLanh()};
				modelluongCN.addRow(row);
			}
		}
	}
	public void cbbThangNV() {
		String thang=cbbThang.getSelectedItem().toString();
		modelluongNV.setRowCount(0);
		int stt=0;
		for(BangLuongNhanVien l: luongNV_BUS.getNVthang(thang)) {
			
				stt++;
				String hoten=l.getNv().getTen();
				Object[] row= {stt,l.getNv().getMaNhanVien(),hoten,l.getTienThuong(),dcf.format(l.getThucLanh())};
				modelluongNV.addRow(row);
			
		}
	}
	public void cbbNamNV() {
		String nam=cbbNam.getSelectedItem().toString();
		modelluongNV.setRowCount(0);
		int stt=0;
		for(BangLuongNhanVien l: luongNV_BUS.getNVnam(nam)) {
			
				stt++;
				String hoten=l.getNv().getTen();
				Object[] row= {stt,l.getNv().getMaNhanVien(),hoten,l.getTienThuong(),dcf.format(l.getThucLanh())};
				modelluongNV.addRow(row);
			
		}
		
	}
	public void cbbThangCN() {
		String thang=cbbThang1.getSelectedItem().toString();
		modelluongCN.setRowCount(0);
		int stt=0;
		for(BangLuongCongNhan l: LuongCN_BUS.getCNthang(thang))
		{
			stt++;
			String hoten =l.getCongNhan().getTen();
			Object[] row= { stt, l.getCongNhan().getMaCongNhan(),hoten," " ," ",l.getThucLanh()};
			modelluongCN.addRow(row);
			
		}
	}
	public void cbbNamCN() {
		String nam=cbbNam1.getSelectedItem().toString();
		modelluongCN.setRowCount(0);
		int stt=0;
		for(BangLuongCongNhan l: LuongCN_BUS.getCNnam(nam)) {
			
			stt++;
			String hoten =l.getCongNhan().getTen();
			Object[] row= { stt, l.getCongNhan().getMaCongNhan(),hoten," " ," ",l.getThucLanh()};
			modelluongCN.addRow(row);		
		}
		
	}
	
	public void loadngaythang() {
		String thang=cbbThang.getSelectedItem().toString();
		String nam=cbbNam.getSelectedItem().toString();
		int stt =0;
		for(BangLuongNhanVien l: luongNV_BUS.getNV_namThang(nam, thang)) {
			
			stt++;
			String hoten=l.getNv().getTen();
			Object[] row= {stt,l.getNv().getMaNhanVien(),hoten,l.getTienThuong(),dcf.format(l.getThucLanh())};
			modelluongNV.addRow(row);
		
	}
	}
		
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(cbbPhongBanNV)) {
			cbbPBNV_ten();
		}
		else if(o.equals(cbbMaXuong))
			cbbmaXuong();
//		else if(o.equals(cbbNam) && o.equals(cbbThang)) {
//			loadngaythang();
//		}
		else if(o.equals(cbbThang))
			cbbThangNV();
		else if(o.equals(cbbNam))
			cbbNamNV();
		else if(o.equals(cbbThang1))
			cbbThangCN();
		else if(o.equals(cbbNam1))
			cbbNamCN();
		
	}
	

}

