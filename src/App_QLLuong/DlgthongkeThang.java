package App_QLLuong;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.ThongKe_BUS;
import CustomGUi.DlgThongkeCN;
import DAO.ConnectDB;
import DTO.tkluong_nam;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class DlgthongkeThang extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTable tbltkcn;
	private DefaultTableModel model= new DefaultTableModel();
	private ThongKe_BUS tk_BUS= new ThongKe_BUS();
	private JButton  btnIn,btntk;
	private DecimalFormat df= new DecimalFormat("###,###,###,###");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgthongkeThang dialog = new DlgthongkeThang();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgthongkeThang() {
		setBounds(100, 100, 649, 504);
		setVisible(true);
		setModal(true);
		 setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BẢNG THỐNG KÊ LƯƠNG CÁC THÁNG");
		lblNewLabel.setBounds(171, 5, 265, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 49, 603, 353);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		String[] cols= {"Năm","Tháng","Số sản phẩm sản xuất","Tổng lương"};
		model= new DefaultTableModel(cols,0);
				tbltkcn = new JTable(model);
		
		scrollPane.setViewportView(tbltkcn);
		
		 btnIn = new JButton("Xuất excel");
		btnIn.setBackground(new Color(30, 144, 255));
		btnIn.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnIn.setBounds(503, 421, 110, 23);
//		btnIn.addActionListener( this);
		btntk= new JButton("Biểu đồ");
		btntk.setBackground(new Color(30, 144, 255));
		btntk.setBorder(new LineBorder(new Color(0, 0, 0)));
		btntk.setBounds(375,421, 110, 23);
//		btntk.addActionListener(this);
		


		panel.add(btntk);
		panel.add(btnIn);
		// láo màu
		 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		 centerRenderer.setBackground(new Color(30,144,255));
		 centerRenderer.setForeground(Color.black);
		 centerRenderer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 
	       for(int i=0;i<tbltkcn.getModel().getColumnCount();i++) {
	    	   tbltkcn.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
	       }
		// load len bang
		ArrayList<tkluong_nam> ds= tk_BUS.gettkNam();
				for(tkluong_nam l: ds) {
					
		Object[] row= {l.getNam(),l.getThang(),l.getSoluong(),df.format(l.getTong_luong())};
		model.addRow(row);}
		
	}
	private static void exportToExcel(JTable table) throws Exception {
		String generatedString = RandomStringUtils.random(4, true, true);
		String filePath = "E:\\PTUD\\APP_LUONG\\App_QLluongSP_nhom16_JV\\src\\data\\BangTK_" + generatedString + ".xlsx";
		TableModel model = table.getModel();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row;
		Cell cell;
		// write the column headers
		row = sheet.createRow(0);
		for (int c = 0; c < model.getColumnCount(); c++) {
			cell = row.createCell(c);
			cell.setCellValue(model.getColumnName(c));
		}
		// write the data rows
		for (int r = 0; r < model.getRowCount(); r++) {
			row = sheet.createRow(r + 1);
			for (int c = 0; c < model.getColumnCount(); c++) {
				cell = row.createCell(c);
				Object value = model.getValueAt(r, c);
				if (value instanceof String) {
					cell.setCellValue((String) value);
				} else if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
			}
		}
		File file = new File(filePath);
		file.getParentFile().mkdirs();
		file.createNewFile();
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		out.close();
		workbook.close();
		JOptionPane.showMessageDialog(null, "Xuất file thành công.\nXem tại: " + filePath, "Kết quả",
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnIn)) {
//			int number = new Random().nextInt(1000, 9999);
			try {
				exportToExcel(tbltkcn);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(o.equals(btntk)) {
			new DlgThongkeCN().setVisible(true);
		}
		
	}
}
