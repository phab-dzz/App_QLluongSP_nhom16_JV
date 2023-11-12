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

import BUS.ThongKe_BUS;
import DAO.ConnectDB;
import DTO.tkluong_nam;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class DlgthongkeThang extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tbltkcn;
	private DefaultTableModel model= new DefaultTableModel();
	private ThongKe_BUS tk_BUS= new ThongKe_BUS();
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
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		JButton btnIn = new JButton("Xuất excel");
		btnIn.setBackground(new Color(30, 144, 255));
		btnIn.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnIn.setBounds(503, 421, 110, 23);
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
}
