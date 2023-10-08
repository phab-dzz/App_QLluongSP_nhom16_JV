package App_QLLuong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridBagConstraints;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import ChuyenmanController.Chuyenmanhinhcontroller;
import DTO.DanhmucApp;
import Dangnhap.Dangnhap;

import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JMenu;

public class App_main extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		new App_main().setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App_main frame = new App_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App_main() {
		
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Times New Roman", Font.BOLD, 13));
		URL url= App_main.class.getResource("outline_savings_black_24dp.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		
		this.setIconImage(img);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(70, 40,1150, 650);
		setResizable(false);  // Không cho phép thay đổi kích thước
		setTitle("QUẢN LÝ LƯƠNG SẢN PHẨM");
	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpnroot = new JPanel();
		jpnroot.setBounds(0, 0, 212, 611);
		jpnroot.setBackground(new Color(0, 0, 128));
		contentPane.add(jpnroot);
		jpnroot.setLayout(null);
		
		JPanel panel_tittle = new JPanel();
		panel_tittle.setBounds(0, 0, 212, 62);
		panel_tittle.setBackground(new Color(0, 0, 205));
		panel_tittle.setForeground(Color.RED);
		jpnroot.add(panel_tittle);
		panel_tittle.setLayout(null);
		
		JLabel Jlblogo = new JLabel("Quản lý Lương");
		Jlblogo.setBounds(0, 0, 211, 67);
		panel_tittle.add(Jlblogo);
		Jlblogo.setForeground(new Color(255, 255, 255));
		Jlblogo.setEnabled(false);
		Jlblogo.setBackground(new Color(0, 0, 255));
		Jlblogo.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\baseline_manage_accounts_black_24dp.png"));
		Jlblogo.setHorizontalAlignment(SwingConstants.CENTER);
		Jlblogo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		
		
	
		
		JPanel JplMenu = new JPanel();
		JplMenu.setBackground(new Color(0, 0, 128));
		JplMenu.setBounds(10, 70, 192, 530);
		jpnroot.add(JplMenu);
		JplMenu.setLayout(null);
		
		JPanel Danhmuc = new JPanel();
		Danhmuc.setForeground(new Color(192, 192, 192));
		Danhmuc.setBounds(10, 77, 172, 38);
		JplMenu.add(Danhmuc);
		Danhmuc.setBackground(new Color(0, 0, 255));
		Danhmuc.setLayout(null);
		
		JLabel Jblnv = new JLabel("Danh mục");
		Jblnv.setBackground(new Color(76,175,80));
		Jblnv.setBounds(0, 0, 172, 35);
		Danhmuc.add(Jblnv);
		Jblnv.setForeground(new Color(255, 255, 255));
		Jblnv.setHorizontalAlignment(SwingConstants.CENTER);
		Jblnv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Jblnv.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\menu_left\\baseline_list_alt_white_24dp.png"));
		
		JPanel Home = new JPanel();
		Home.setBounds(10, 11, 172, 38);
		JplMenu.add(Home);
		Home.setBackground(new Color(0, 0, 255));
		Home.setLayout(null);
		
		JLabel Jblhome = new JLabel("Trang chủ");
		Jblhome.setBackground(new Color(0, 0, 255));
		Jblhome.setForeground(new Color(255, 255, 255));
		Jblhome.setHorizontalAlignment(SwingConstants.CENTER);
		Jblhome.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\menu_left\\baseline_home_white_24dp.png"));
		Jblhome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Jblhome.setBounds(0, 0, 169, 43);
		Home.add(Jblhome);
		
		//hinh
//		Image imgmenu = Toolkit.getDefaultToolkit().createImage( App_main.class.getResource("nen.jpg"));
//		
//		Jlblogo.setBackground(new ImageIcon(Toolkit.getDefaultToolkit().createImage( App_main.class.getResource("nen.jpg"))));
		JPanel Jplview = new JPanel();
		Jplview.setBounds(222, 11, 912, 600);
		contentPane.add(Jplview);
		
		//
	
//
		
		JPanel Xuly = new JPanel();
		Xuly.setLayout(null);
		Xuly.setForeground(Color.LIGHT_GRAY);
		Xuly.setBackground(new Color(0, 0, 255));
		Xuly.setBounds(10, 142, 172, 38);
		JplMenu.add(Xuly);
		
		JLabel jblcn = new JLabel("Xử lý");
		jblcn.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\menu_left\\baseline_drive_file_rename_outline_white_24dp.png"));
		jblcn.setHorizontalAlignment(SwingConstants.CENTER);
		jblcn.setForeground(new Color(255, 255, 255));
		jblcn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jblcn.setBackground(new Color(76,175,80));
		jblcn.setBounds(0, 0, 169, 43);
		Xuly.add(jblcn);
		
		JPanel Timkiem = new JPanel();
		Timkiem.setLayout(null);
		Timkiem.setForeground(Color.LIGHT_GRAY);
		Timkiem.setBackground(new Color(0, 0, 255));
		Timkiem.setBounds(10, 207, 169, 38);
		JplMenu.add(Timkiem);
		
		JLabel jblsp = new JLabel("Tìm kiếm");
		jblsp.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\menu_left\\baseline_person_search_white_24dp.png"));
		jblsp.setHorizontalAlignment(SwingConstants.CENTER);
		jblsp.setForeground(new Color(255, 255, 255));
		jblsp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jblsp.setBackground(new Color(76,175,80));
		jblsp.setBounds(0, 0, 169, 43);
		Timkiem.add(jblsp);
		
		JPanel Thongke = new JPanel();
		Thongke.setLayout(null);
		Thongke.setForeground(Color.LIGHT_GRAY);
		Thongke.setBackground(new Color(0, 0, 255));
		Thongke.setBounds(13, 272, 166, 38);
		JplMenu.add(Thongke);
		
		JLabel jbltk = new JLabel("Thống kê");
		jbltk.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\menu_left\\baseline_analytics_white_24dp.png"));
		jbltk.setHorizontalAlignment(SwingConstants.CENTER);
		jbltk.setForeground(new Color(255, 255, 255));
		jbltk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jbltk.setBackground(new Color(0, 0, 255));
		jbltk.setBounds(0, 0, 156, 43);
		Thongke.add(jbltk);
		
		JPanel Taikhoan = new JPanel();
		Taikhoan.setLayout(null);
		Taikhoan.setForeground(Color.LIGHT_GRAY);
		Taikhoan.setBackground(new Color(0, 0, 255));
		Taikhoan.setBounds(10, 337, 169, 38);
		JplMenu.add(Taikhoan);
		
		JLabel jblAcc = new JLabel("Tài khoản\r\n");
		jblAcc.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\menu_left\\baseline_account_circle_white_24dp.png"));
		jblAcc.setHorizontalAlignment(SwingConstants.CENTER);
		jblAcc.setForeground(new Color(255, 255, 255));
		jblAcc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jblAcc.setBackground(new Color(76,175,80));
		jblAcc.setBounds(0, 0, 159, 43);
		Taikhoan.add(jblAcc);
		
		JLabel lblNewLabel = new JLabel("Team 16_Toàn đầu gấu\r\n");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 9));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\baseline_pets_black_24dp.png"));
		lblNewLabel.setBounds(0, 484, 192, 46);
		JplMenu.add(lblNewLabel);
		//chuyen panel
	//
		//
		List<DanhmucApp> list= new ArrayList<>();
		list.add(new DanhmucApp("Trangchu",Home,Jblhome));
		list.add(new DanhmucApp("Nhanvien",Danhmuc,Jblnv));
		list.add(new DanhmucApp("Congnhan",Xuly,jblcn));
		list.add(new DanhmucApp("Sanpham",Timkiem,jblsp));
		list.add(new DanhmucApp("Timkiem",Thongke,jbltk));
		list.add(new DanhmucApp("Taikhoan",Taikhoan,jblAcc));
		
		Chuyenmanhinhcontroller controller= new Chuyenmanhinhcontroller(Jplview);
		Jplview.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-221, -6, 211, 60);
		Jplview.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\logo\\logo.png"));
		controller.setView(Home,Jblhome);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(10, 441, 172, 38);
		JplMenu.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Đăng xuất\r\n");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\menu_left\\baseline_logout_white_24dp.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 172, 38);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_2);
		controller.setEvent(list);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object o=e.getSource();
//		if(o.equals(btnthoat)) {
////			new Dangnhap().setVisible(true);
////			dispose();
////			int dialogResult = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
////			if (dialogResult == JOptionPane.YES_OPTION) {
////			    // User clicked Yes button
////				new Dangnhap().setVisible(true);
////					dispose();
////			} else {
////			  JOptionPane.show
////			  }
//			int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng nhập lại không?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
//			if (dialogResult == JOptionPane.YES_OPTION) {
//			    // User clicked Yes button
//				new Dangnhap().setVisible(true);
//				dispose();
//			} else {
//				JOptionPane.showMessageDialog(this, "Hủy thoát thành công!");
////				System.exit(0);
//			    // User clicked No button
//				
//			}
//		}
	
}
