package CustomGUi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import BUS.ThongKe_BUS;
import DAO.ConnectDB;
import DTO.tkluong_nam;
import MyCustom.MyDialog;

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

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTree;

public class DlgThongkeCN extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private static ThongKe_BUS tk_BUS= new ThongKe_BUS();
	private DefaultTableModel model= new DefaultTableModel();
	private JTable tbltkcn= new JTable();
	private JButton btnIn;
	private DecimalFormat df= new DecimalFormat("###,###,###,###");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgThongkeCN dialog = new DlgThongkeCN();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgThongkeCN() {
		setTitle("BIỂU ĐỒ THỐNG KÊ LƯƠNG");
		setBounds(100, 100, 649, 535);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(225,225,225));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("THỐNG KÊ LƯƠNG 2023");
			lblNewLabel.setBackground(new Color(211, 211, 211));
			lblNewLabel.setForeground(new Color(0, 0, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNewLabel.setBounds(0, 0, 609, 43);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel JplBD = new JPanel();
			JplBD.setBounds(0, 36, 633, 310);
			contentPanel.add(JplBD);
			ChartPanel chartPanel = new ChartPanel(createChart());
			chartPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
			chartPanel.setBackground(new Color(192, 192, 192));
	        chartPanel.setPreferredSize(new java.awt.Dimension(633,300));
	        JplBD.add(chartPanel);
	        
		}
		JLabel lblNewLabel = new JLabel("BẢNG THỐNG KÊ LƯƠNG");
		lblNewLabel.setBackground(new Color(225,225,225));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(0, 346, 609, 25);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 370, 633, 95);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		 btnIn = new JButton("Xuất excel");
		 btnIn.setForeground(new Color(0,0,0));
			btnIn.setBackground(new Color(30, 144, 255));
			btnIn.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnIn.setBounds(503, 470, 110, 23);
			contentPanel.add(btnIn);
		btnIn.addActionListener(this);
//		
		
		
		JScrollPane Jcrolltk = new JScrollPane();
		panel.add(Jcrolltk, BorderLayout.CENTER);
		String[] cols= {"Năm","Tháng","Số sản phẩm sản xuất","Tổng lương"};
		model= new DefaultTableModel(cols,0);
				tbltkcn = new JTable(model);
				Jcrolltk.setViewportView(tbltkcn);
//				
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
	   public static JFreeChart createChart() {
	        JFreeChart barChart = ChartFactory.createBarChart(
	                "BIỂU ĐỒ TỔNG LƯƠNG THÁNG",
	                "Tháng", "Tổng lương",
	                createDataset(), PlotOrientation.VERTICAL, false, false, false);
	        return barChart;
	    }
	  private static CategoryDataset createDataset() {
		  ArrayList<tkluong_nam> dstk= tk_BUS.gettkNam();
	        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        for(tkluong_nam tk:dstk) {
	        	dataset.addValue(tk.getTong_luong(),"Lương",tk.getThang()+"");
	        	
	        }

	        return dataset;
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
			new MyDialog("Xuất file thành công.\nXem tại: thư mục data",MyDialog.SUCCESS_DIALOG);
//			JOptionPane.showMessageDialog(null, "Xuất file thành công.\nXem tại: " + filePath, "Kết quả",
//					JOptionPane.INFORMATION_MESSAGE);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object o= e.getSource();
			if(o.equals(btnIn)) {
				try {
					exportToExcel(tbltkcn);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
}
