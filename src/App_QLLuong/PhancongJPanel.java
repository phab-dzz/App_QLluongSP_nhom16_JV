package App_QLLuong;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

import java.awt.Color;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import CustomGUi.ScrollBarCustom;

import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;

public class PhancongJPanel extends JPanel {
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		
		JPanel Jpl_CN = new JPanel();
		Jpl_CN.setBorder(new TitledBorder(null, "C\u00F4ng nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Jpl_CN.setBounds(10, 25, 308, 171);
		panel_1.add(Jpl_CN);
		Jpl_CN.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm theo mã CN:\r\n");
		lblNewLabel.setBounds(10, 21, 113, 21);
		Jpl_CN.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(133, 21, 129, 21);
		Jpl_CN.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnNewButton.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\tim.png"));
		btnNewButton.setBounds(262, 21, 33, 22);
		Jpl_CN.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 53, 285, 115);
		Jpl_CN.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setAutoscrolls(true);
		
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Mã Công nhân", "Tên công nhân"
			}
		));
		table.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollPane.setViewportView(table);
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollPane.setHorizontalScrollBar(sp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "C\u00F4ng \u0111o\u1EA1n v\u00E0 s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(357, 25, 526, 171);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sản phẩm:");
		lblNewLabel_1.setBounds(10, 22, 69, 14);
		panel_2.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setAutoscrolls(true);
		comboBox.setBorder(null);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Áo hoodie", "Áo sơ mi"}));
		comboBox.setBounds(74, 18, 119, 18);
		panel_2.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 47, 208, 113);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm"
			}
		));
		scrollPane_1.setViewportView(table_1);
		scrollPane_1.setVerticalScrollBar(new ScrollBarCustom());
       
        scrollPane_1.setHorizontalScrollBar(sp);
		JLabel lblNewLabel_1_1 = new JLabel("Công đoạn:");
		lblNewLabel_1_1.setBounds(269, 22, 69, 14);
		panel_2.add(lblNewLabel_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setAutoscrolls(true);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Tay áo", "thân áo"}));
		comboBox_1.setBorder(null);
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(370, 20, 119, 18);
		panel_2.add(comboBox_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(261, 47, 255, 113);
		panel_2.add(scrollPane_1_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Mã công đoạn", "Tên công đ"
			}
		));
		scrollPane_1_1.setViewportView(table_2);
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
		lblNewLabel_3.setBounds(34, 11, 71, 24);
		panel_6.add(lblNewLabel_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 151, 880, 234);
		panel_6.add(scrollPane_2);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "Mã công nhân", "Tên công nhân", "Ngày bắt đầu", "Tên sản phẩm", "Tên công đoạn", "Số lượng"
			}
		));
		scrollPane_2.setViewportView(table_3);
		scrollPane_2.setVerticalScrollBar(new ScrollBarCustom());
        
        scrollPane_2.setHorizontalScrollBar(sp);
		JLabel lblNewLabel_3_1 = new JLabel("Họ và tên :");
		lblNewLabel_3_1.setBounds(34, 46, 71, 24);
		panel_6.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Ngày bắt đầu:\r\n");
		lblNewLabel_3_1_1.setBounds(34, 100, 71, 24);
		panel_6.add(lblNewLabel_3_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setAutoscrolls(true);
		dateChooser.setBackground(new Color(255, 255, 255));
		dateChooser.setBorder(null);
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_6.add(dateChooser);
		dateChooser.setBounds(115,100,132,24);
		
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 13, 131, 20);
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 48, 131, 20);
		panel_6.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(389, 13, 131, 20);
		panel_6.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(389, 48, 131, 20);
		panel_6.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(695, 13, 131, 20);
		panel_6.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(695, 48, 131, 20);
		panel_6.add(textField_6);
		
		JButton btnNewButton_1 = new JButton("Thêm\r\n");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\them.png"));
		btnNewButton_1.setBounds(464, 101, 87, 23);
		panel_6.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnNewButton_1_1.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\editing.png"));
		btnNewButton_1_1.setBounds(575, 101, 95, 23);
		panel_6.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("xóa");
		btnNewButton_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnNewButton_1_2.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\chamcong\\xoa.png"));
		btnNewButton_1_2.setBounds(695, 101, 101, 23);
		panel_6.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Làm mới\r\n");
		btnNewButton_1_3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, new Color(0, 0, 0)));
		btnNewButton_1_3.setBackground(new Color(30, 144, 255));
		btnNewButton_1_3.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\icons_sp\\refresh.png"));
		btnNewButton_1_3.setBounds(353, 101, 101, 23);
		panel_6.add(btnNewButton_1_3);

	}
}
