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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
import CustomGUi.CustomDialog;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.atomic.DoubleAdder;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class PhancongJPanel extends JPanel implements MouseListener,ActionListener,ItemListener {
	private JTable tblCN;
	private JTable tblSP;
	private JTable tblCD;
	private JTable tblPC;
	private JButton btnreset;
	private JButton btnPhanCong;
	private JDateChooser jdcngayBD;
	private DefaultTableModel modelCN, modelSP, modelCD,modelPC;
	private JTextField txtmaCN;
	private JLabel lblTimKiem;
	private JComboBox comboBoxSearchXuong;

	private JTextField txthoTen;
	private JTextField txtmaCD;
	private JTextField txttenCD;
	private JTextField txtmaSP;
	private JTextField txttenSP;
	private	CongNhan_BUS CN_BUS= new CongNhan_BUS();
	private SanPham_DAO  SP_DAO= new SanPham_DAO();
	private CongDoanSanPham_DAO cd_DAO;
	public static int count=0;
	public static int soLuongCan;

	private PhanCongCongDoan_BUS PC_BUS= new PhanCongCongDoan_BUS();
	private CongDoanSanPham_BUS CongDoanSP_BUS1= new CongDoanSanPham_BUS();

	private JTextField txtsl;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyy");
	private JTextField txtTimKiem;


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
		Jpl_CN.setBounds(580, 25, 308, 171);
		panel_1.add(Jpl_CN);
		Jpl_CN.setLayout(null);
		String[] cols = {"Mã Công Nhân","Họ và tên"};
		modelCN= new DefaultTableModel(cols,0);
		ScrollBarCustom sp = new ScrollBarCustom();
		sp.setOrientation(JScrollBar.HORIZONTAL);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 285, 113);
		Jpl_CN.add(scrollPane);
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setAutoscrolls(true);
		tblCN = new JTable(modelCN);

		tblCN.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollPane.setViewportView(tblCN);
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
		scrollPane.setHorizontalScrollBar(sp);

		JLabel lblTableCN = new JLabel("Danh sách công nhân");
		lblTableCN.setBounds(79, 22, 126, 14);
		Jpl_CN.add(lblTableCN);
		tblCN.addMouseListener(this);

		JPanel JblSP_CD = new JPanel();
		JblSP_CD.setBorder(new TitledBorder(null, "C\u00F4ng \u0111o\u1EA1n v\u00E0 s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		JblSP_CD.setBounds(23, 25, 526, 171);
		panel_1.add(JblSP_CD);
		JblSP_CD.setLayout(null);

		ArrayList<String> listtensp= new ArrayList<String>();
		for(SanPham sP : SP_DAO.getAllSanPham()) {
			listtensp.add(sP.getTenSanPham());
		}
		DefaultComboBoxModel<String> modeljcbo= new DefaultComboBoxModel<>(listtensp.toArray(new String[0]));

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
		ArrayList<String> listtencd= new ArrayList<String>();
		for(CongDoanSanPham cd: CongDoanSP_BUS1.getAllCongDoanSP()) {
			listtencd.add(cd.getTenCongDoan());
		}
		DefaultComboBoxModel<String> modelCboCD= new DefaultComboBoxModel<>(listtencd.toArray(new String[0]));

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(228, 47, 288, 113);
		JblSP_CD.add(scrollPane_1_1);
		String[] cols2= {"Mã Công Đoạn" , "Tên Công Đoạn", "Chuyên môn"};
		modelCD= new DefaultTableModel(cols2,0);
		tblCD = new JTable(modelCD);

		scrollPane_1_1.setViewportView(tblCD);
		scrollPane_1_1.setVerticalScrollBar(new ScrollBarCustom());

		scrollPane_1_1.setHorizontalScrollBar(sp);

		JLabel lblTableSP = new JLabel("Danh sách sản phẩm");
		lblTableSP.setBounds(54, 21, 126, 14);
		JblSP_CD.add(lblTableSP);

		JLabel lblTableCongDoan = new JLabel("Danh sách công đoạn");
		lblTableCongDoan.setBounds(309, 22, 126, 14);
		JblSP_CD.add(lblTableCongDoan);
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
		lblNewLabel_3.setBounds(34, 11, 87, 24);
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
		lblNewLabel_3_1.setBounds(34, 46, 87, 24);
		panel_6.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Ngày bắt đầu:\r\n");
		lblNewLabel_3_1_1.setBounds(34, 81, 87, 24);
		panel_6.add(lblNewLabel_3_1_1);

		jdcngayBD = new JDateChooser();
		jdcngayBD.setDateFormatString("dd/MM/yyyy");
		jdcngayBD.setAutoscrolls(true);

		jdcngayBD.setBackground(new Color(255, 255, 255));
		jdcngayBD.setBorder(null);
		jdcngayBD.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_6.add(jdcngayBD);
		jdcngayBD.setBounds(122,85,132,20);

		JLabel lblNewLabel_3_2 = new JLabel("Mã công đoạn :\r\n\r\n");
		lblNewLabel_3_2.setBounds(279, 11, 99, 24);
		panel_6.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Tên công đoạn :\r\n");
		lblNewLabel_3_3.setBounds(279, 46, 103, 24);
		panel_6.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("Mã sản phẩm :\r\n");
		lblNewLabel_3_4.setBounds(551, 11, 99, 24);
		panel_6.add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_5 = new JLabel("Tên sản phẩm :\r\n");
		lblNewLabel_3_5.setBounds(551, 46, 99, 24);
		panel_6.add(lblNewLabel_3_5);

		txtmaCN = new JTextField();
		txtmaCN.setBorder(new LineBorder(Color.BLACK));
		txtmaCN.setEditable(false);
		txtmaCN.setBounds(123, 13, 131, 20);
		panel_6.add(txtmaCN);
		txtmaCN.setColumns(10);

		txthoTen = new JTextField();
		txthoTen.setBorder(new LineBorder(Color.BLACK));
		txthoTen.setEditable(false);
		txthoTen.setColumns(10);
		txthoTen.setBounds(123, 48, 131, 20);
		panel_6.add(txthoTen);

		txtmaCD = new JTextField();
		txtmaCD.setBorder(new LineBorder(Color.BLACK));
		txtmaCD.setEditable(false);
		txtmaCD.setColumns(10);
		txtmaCD.setBounds(388, 13, 131, 20);
		panel_6.add(txtmaCD);

		txttenCD = new JTextField();
		txttenCD.setBorder(new LineBorder(Color.BLACK));
		txttenCD.setEditable(false);
		txttenCD.setColumns(10);
		txttenCD.setBounds(388, 48, 131, 20);
		panel_6.add(txttenCD);

		txtmaSP = new JTextField();
		txtmaSP.setBorder(new LineBorder(Color.BLACK));
		txtmaSP.setEditable(false);
		txtmaSP.setColumns(10);
		txtmaSP.setBounds(648, 13, 131, 20);
		panel_6.add(txtmaSP);

		txttenSP = new JTextField();
		txttenSP.setBorder(new LineBorder(Color.BLACK));
		txttenSP.setEditable(false);
		txttenSP.setColumns(10);
		txttenSP.setBounds(648, 48, 131, 20);
		panel_6.add(txttenSP);

		btnPhanCong = new JButton("Phân công nhanh");
		btnPhanCong.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnPhanCong.setBackground(new Color(30, 144, 255));
		btnPhanCong.setIcon(new ImageIcon(PhancongJPanel.class.getResource("/Icons/chamcong/them.png")));
		btnPhanCong.setBounds(648, 82, 132, 23);
		panel_6.add(btnPhanCong);

		btnreset = new JButton("Làm mới\r\n");
		btnreset.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnreset.setBackground(new Color(30, 144, 255));
		btnreset.setIcon(new ImageIcon(PhancongJPanel.class.getResource("/Icons/icons_sp/refresh.png")));
		btnreset.setBounds(551, 82, 87, 23);
		panel_6.add(btnreset);

		JLabel lblNewLabel_4 = new JLabel("Số lượng :");
		lblNewLabel_4.setBounds(277, 86, 80, 14);
		panel_6.add(lblNewLabel_4);

		txtsl = new JTextField();
		panel_6.add(txtsl);
		txtsl.setColumns(10);
		txtsl.setEditable(false);
		txtsl.setBounds(388, 83, 131, 20);

		lblTimKiem = new JLabel("Tìm kiếm:");
		lblTimKiem.setBounds(34, 126, 71, 14);
		panel_6.add(lblTimKiem);

		comboBoxSearchXuong = new JComboBox();
		comboBoxSearchXuong.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Xưởng 1", "Xưởng 2", "Xưởng 3"}));
		comboBoxSearchXuong.setBounds(387, 122, 132, 22);
		comboBoxSearchXuong.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String tenXuong = comboBoxSearchXuong.getSelectedItem().toString();
					if(tenXuong.equals("Tất cả")) {
						modelPC.setRowCount(0);
						addatatotblePCCD();
					}else {
						modelPC.setRowCount(0);
						addatatotblePCCDTheoXuong(tenXuong);
					}

				}
			}

		});
		panel_6.add(comboBoxSearchXuong);

		JLabel Xưởng = new JLabel("Lọc theo xưởng");
		Xưởng.setBounds(279, 126, 99, 14);
		panel_6.add(Xưởng);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(122, 120, 93, 20);
		panel_6.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JButton btnSearchCN = new JButton("Tìm");
		btnSearchCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maCN = txtTimKiem.getText();
				PhanCongCongDoan pc = PC_BUS.getPhanCongCD(maCN);
				if(pc != null) {
					CongNhan cn= timkiemtheomaCN(pc.getMaCN());
					modelPC.setRowCount(0);
					String ngayBatdau=pc.getNgayBatDau().format(formatter);
					SanPham sp= timkiemtheoten(pc.getMaSP());
					CongDoanSanPham cd=timkiemtheotenCD(pc.getMaCD());
					Object[] row= {pc.getMaCN(),cn.getTen(),ngayBatdau,sp.getTenSanPham(),cd.getTenCongDoan(),pc.getSoLuongCongDoanPhanCong()};
					modelPC.addRow(row);
				}else {
//					new MyDialog("Công nhân không tồn tại.",MyDialog.ERROR_DIALOG );
					new CustomDialog("Công nhân không tồn tại.", CustomDialog.ERROR_DIALOG);
				}
			}
		});
		btnSearchCN.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnSearchCN.setBackground(new Color(30, 144, 255));
		btnSearchCN.setBounds(216, 120, 38, 20);
		panel_6.add(btnSearchCN);

		// set mau table
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		centerRenderer.setBackground(new Color(30,144,255));
		centerRenderer.setForeground(Color.black);
		centerRenderer.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		JTable[] tables = {tblPC, tblCN, tblSP, tblCD};

		for (JTable table : tables) {
			for (int i = 0; i < table.getModel().getColumnCount(); i++) {
				table.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
			}
		}

		setupSPSelectionListener();
		setupCDSelectionListener();
		addatatotbleSP();
		addatatotblePCCD();
		// add sự kiện
		btnreset.addActionListener(this);
		btnPhanCong.addActionListener(this);
		tblSP.addMouseListener(this);
		tblCD.addMouseListener(this);
		tblPC.addMouseListener(this);
	}
	private void clearTableModel(DefaultTableModel model) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

	private void setupSPSelectionListener() {
		ListSelectionModel selectionMode2 = tblSP.getSelectionModel();
		selectionMode2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tblSP.getSelectedRow();
					if (selectedRow != -1) {
						clearTableModel(modelCN);
						clearTableModel(modelCD);
						Object maSP = tblSP.getValueAt(selectedRow, 0);
						addatatotbleCDSP(maSP.toString());
					}
				}
			}
		});
	}

	private void setupCDSelectionListener() {
		ListSelectionModel selectionMode3 = tblCD.getSelectionModel();
		selectionMode3.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tblCD.getSelectedRow();
					if (selectedRow != -1) {
						clearTableModel(modelCN);
						Object maCD = tblCD.getValueAt(selectedRow, 0);
						try {
							ConnectDB.getInstance().connect();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						count=0;
						CongDoanSanPham cd = CongDoanSP_BUS1.getCongDoanSanPham(maCD.toString());
						for(int i=0; i<tblCD.getRowCount(); i++) {
							if(tblCD.getValueAt(i, 2).equals(tblCD.getValueAt(selectedRow, 2))) {
								count++;
							}
						}
						System.out.println(count + "cc");
						adddatatotbleCN(cd.getChuyenMon(), count);
					}
				}
			}
		});
	}

	public void addatatotbleSP() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(SanPham sp : SP_DAO.getAllSanPham()) {
			if(!sp.isTrangThaiSP()) {
				Object[] row= {sp.getMaSanPham(),sp.getTenSanPham()};
				modelSP.addRow(row);
			}
		}
	}
	public void addatatotbleCDSP(String maSP) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<CongDoanSanPham> listCD = new ArrayList<CongDoanSanPham>();
		for(CongDoanSanPham cd:CongDoanSP_BUS1.getAllCongDoanSP()) {
			if(cd.getSanPham().getMaSanPham().equals(maSP) && cd.isTrangThaiPhanCong() == false) {
				listCD.add(cd);
			}
		}
		Collections.sort(listCD, new Comparator<CongDoanSanPham>() {

			@Override
			public int compare(CongDoanSanPham cd1, CongDoanSanPham cd2) {
				// TODO Auto-generated method stub
				Integer congDoan1 = (Integer) cd1.getDoUuTien();
				Integer congDoan2 = (Integer) cd2.getDoUuTien();
				return congDoan1.compareTo(congDoan2);
			}
		});
		for(CongDoanSanPham cd:listCD) {
			if(cd.getDoUuTien() == listCD.get(0).getDoUuTien()) {
				Object[] row= {cd.getMaCongDoan(),cd.getTenCongDoan(), cd.getChuyenMon()};
				modelCD.addRow(row);
			}
		}
	}
	public void adddatatotbleCN(String chuyenMon, int count) {

		modelCN.setRowCount(0);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<PhanCongCongDoan> dsCN= new ArrayList<PhanCongCongDoan>();
		for(PhanCongCongDoan pc : PC_BUS.getDanhSachCanPhanCong(chuyenMon)) {
			if(pc.getSoLuongCongDoanPhanCong() == 0 && timkiemtheomaCN(pc.getMaCN()).isTrangThai()){
				dsCN.add(pc);
			}
		}
		soLuongCan = dsCN.size()/count;
		for (int i=0; i<soLuongCan; i++) {
			String hotenCN= timkiemtheomaCN(dsCN.get(i).getMaCN()).getTen();
			Object[] row = {dsCN.get(i).getMaCN(),hotenCN};
			modelCN.addRow(row);
		}

	}
	public void addatatotblePCCD() {
		modelPC.setRowCount(0);
		ArrayList<PhanCongCongDoan> dsPC = PC_BUS.getAllPhanCongCD();
		for(PhanCongCongDoan pc: dsPC) {
			CongNhan cn= timkiemtheomaCN(pc.getMaCN());

			String ngayBatdau=pc.getNgayBatDau().format(formatter);
			SanPham sp= timkiemtheoten(pc.getMaSP());
			CongDoanSanPham cd=timkiemtheotenCD(pc.getMaCD());

			Object[] row= {pc.getMaCN(),cn.getTen(),ngayBatdau,sp.getTenSanPham(),cd.getTenCongDoan(),pc.getSoLuongCongDoanPhanCong()};
			modelPC.addRow(row);
		}
	}
	public void addatatotblePCCDTheoXuong(String xuong) {
		modelPC.setRowCount(0);
		ArrayList<PhanCongCongDoan> dsPC = PC_BUS.getDanhSachPhanCongTheoXuong(xuong);
		for(PhanCongCongDoan pc: dsPC) {
			CongNhan cn= timkiemtheomaCN(pc.getMaCN());
			
			String ngayBatdau=pc.getNgayBatDau().format(formatter);
			SanPham sp= timkiemtheoten(pc.getMaSP());
			CongDoanSanPham cd=timkiemtheotenCD(pc.getMaCD());
			
			Object[] row= {pc.getMaCN(),cn.getTen(),ngayBatdau,sp.getTenSanPham(),cd.getTenCongDoan(),pc.getSoLuongCongDoanPhanCong()};
			modelPC.addRow(row);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o= e.getSource();
		if(o.equals(tblPC)) {
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
					e1.printStackTrace();
				}
				txtsl.setText(modelPC.getValueAt(row, 5).toString());
				SanPham sp= timkiemtheoten(modelPC.getValueAt(row,3).toString());
				txtmaSP.setText(sp.getMaSanPham());
				txttenSP.setText(modelPC.getValueAt(row, 3).toString());

				CongDoanSanPham cd= timkiemtheotenCD(modelPC.getValueAt(row,4).toString());
				txtmaCD.setText(cd.getMaCongDoan());
				txttenCD.setText(modelPC.getValueAt(row,4).toString());
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

		Object ob=e.getSource();
		if(ob.equals(btnreset)) {
			modelPC.setRowCount(0);
			addatatotblePCCD();
			setTextRong();
		}
		else if(ob.equals(btnPhanCong)) {
			String ma=txtmaCN.getText();
			int selectedRowSP = tblSP.getSelectedRow();
			int selectedRowCD = tblCD.getSelectedRow();
			
			if(selectedRowSP == -1) {
				new CustomDialog("Chưa chọn sản phẩm cần phân công.",CustomDialog.ERROR_DIALOG);
			} else if(selectedRowCD == -1) {
				new CustomDialog("Chưa chọn công đoạn cần phân công.",CustomDialog.ERROR_DIALOG);
			}else {
				CongDoanSanPham congDoanSelect = CongDoanSP_BUS1.getCongDoanSanPham(tblCD.getValueAt(selectedRowCD, 0).toString());
				Object maSP = tblSP.getValueAt(selectedRowSP, 0);
				Object maCD = tblCD.getValueAt(selectedRowCD, 0);
				boolean checkTrangThai = true;
				for (boolean trangThai : CongDoanSP_BUS1.getTrangThaiCongDoanTruocDo(maSP.toString(), congDoanSelect.getDoUuTien()-1)) {
					if(trangThai == false) {
						checkTrangThai = false;
					}
				}
				if(!checkTrangThai) {
//					new MyDialog("Phân công thất bại, công đoạn trước đó chưa hoàn thành.",MyDialog.ERROR_DIALOG );
					new CustomDialog("Công đoạn trước đó chưa hoàn thành.",CustomDialog.ERROR_DIALOG);
				} else {
					LocalDate dateNow = LocalDate.now();
					System.out.println(maCD.toString());
					int soLuongCongDoan = congDoanSelect.getSoLuong();
					int slCNPhanCong = tblCN.getRowCount();
					double result = Math.ceil((double)soLuongCongDoan/slCNPhanCong);
					int slCDPhanCongCN = (int) result;
					boolean check = true;
					int temp=0;
					for (PhanCongCongDoan pc : PC_BUS.getDanhSachCanPhanCong(congDoanSelect.getChuyenMon())) {
						if(temp == soLuongCan) {
							break;
						}
						if(pc.getSoLuongCongDoanPhanCong() ==0 && timkiemtheomaCN(pc.getMaCN()).isTrangThai()) {
							if(pc.getMaSP() == null) {
								pc.setMaCD(maCD.toString());
								pc.setMaSP(maSP.toString());
								pc.setNgayBatDau(dateNow);
								pc.setSoLuongCongDoanPhanCong(slCDPhanCongCN);
								System.out.println(pc.getMaCN()+pc.getMaSP() +pc.getMaCD()  + slCDPhanCongCN +dateNow);
								check = PC_BUS.themPhanCongCongDoan(pc.getMaCN(),pc.getMaSP() ,pc.getMaCD() , slCDPhanCongCN, dateNow);
								temp++;
							}else {
								pc.setMaCD(maCD.toString());
								pc.setMaSP(maSP.toString());
								pc.setNgayBatDau(dateNow);
								pc.setSoLuongCongDoanPhanCong(slCDPhanCongCN);
								check = PC_BUS.updateCongDoan(pc) ;
								temp++;
							}

						}
					}
					if(check && CongDoanSP_BUS1.updateTrangThaiPhanCongCD(maCD.toString())) {
						modelCD.removeRow(selectedRowCD);
						modelCN.setRowCount(0);
//						new MyDialog("Phân công thành công.",MyDialog.SUCCESS_DIALOG );
						new CustomDialog("Phân công thành công.",CustomDialog.SUCCESS_DIALOG);
					}else {
//						new MyDialog("Phân công thất bại.",MyDialog.ERROR_DIALOG );
						new CustomDialog("Phân công thất bại.",CustomDialog.ERROR_DIALOG);
					}
				}
			}
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

	private SanPham timkiemtheoten(String ten) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(SanPham sp: SP_DAO.getAllSanPham()) {
			if((sp.getTenSanPham().equalsIgnoreCase(ten))||(sp.getMaSanPham().equalsIgnoreCase(ten))) {
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
	public void setEditnaltxt() {
		txtmaCN.setEditable(true);
		txthoTen.setEditable(true);
		txtmaCD.setEditable(true);
		txttenCD.setEditable(true);
		txtmaSP.setEditable(true);
		txttenSP.setEditable(true);

	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}
