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

public class App_main extends JFrame  implements ActionListener{

	private JPanel contentPane;
	private 	JButton btnthoat;
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
		jpnroot.setBackground(Color.GRAY);
		contentPane.add(jpnroot);
		jpnroot.setLayout(null);
		
		JPanel panel_tittle = new JPanel();
		panel_tittle.setBounds(0, 0, 212, 62);
		panel_tittle.setBackground(new Color(255, 228, 181));
		panel_tittle.setForeground(Color.RED);
		jpnroot.add(panel_tittle);
		panel_tittle.setLayout(null);
		
		JLabel Jlblogo = new JLabel("Quản lý Lương");
		Jlblogo.setBounds(0, 0, 211, 67);
		panel_tittle.add(Jlblogo);
		Jlblogo.setForeground(Color.RED);
		Jlblogo.setEnabled(false);
		Jlblogo.setBackground(Color.WHITE);
		Jlblogo.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\baseline_manage_accounts_black_24dp.png"));
		Jlblogo.setHorizontalAlignment(SwingConstants.CENTER);
		Jlblogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
	
		
		JPanel JplMenu = new JPanel();
		JplMenu.setBackground(Color.LIGHT_GRAY);
		JplMenu.setBounds(10, 70, 192, 530);
		jpnroot.add(JplMenu);
		JplMenu.setLayout(null);
		
		JPanel Nhanvien = new JPanel();
		Nhanvien.setForeground(new Color(192, 192, 192));
		Nhanvien.setBounds(10, 77, 169, 54);
		JplMenu.add(Nhanvien);
		Nhanvien.setBackground(new Color(76,175,80));
		Nhanvien.setLayout(null);
		
		JLabel Jblnv = new JLabel("Nhân Viên");
		Jblnv.setBackground(new Color(76,175,80));
		Jblnv.setBounds(0, 0, 169, 54);
		Nhanvien.add(Jblnv);
		Jblnv.setForeground(new Color(0, 0, 0));
		Jblnv.setHorizontalAlignment(SwingConstants.CENTER);
		Jblnv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Jblnv.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\baseline_supervisor_account_black_24dp.png"));
		
		JPanel Home = new JPanel();
		Home.setBounds(10, 11, 169, 54);
		JplMenu.add(Home);
		Home.setBackground(new Color(0, 255, 128));
		Home.setLayout(null);
		
		JLabel Jblhome = new JLabel("Trang chủ");
		Jblhome.setBackground(new Color(76,175,80));
		Jblhome.setForeground(new Color(0, 0, 0));
		Jblhome.setHorizontalAlignment(SwingConstants.CENTER);
		Jblhome.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\baseline_home_black_24dp.png"));
		Jblhome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Jblhome.setBounds(0, 0, 170, 54);
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
		
		JPanel Congnhan = new JPanel();
		Congnhan.setLayout(null);
		Congnhan.setForeground(Color.LIGHT_GRAY);
		Congnhan.setBackground(new Color(76,175,80));
		Congnhan.setBounds(10, 142, 169, 54);
		JplMenu.add(Congnhan);
		
		JLabel jblcn = new JLabel("Công nhân\r\n\r\n");
		jblcn.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\iconCN.png"));
		jblcn.setHorizontalAlignment(SwingConstants.CENTER);
		jblcn.setForeground(Color.BLACK);
		jblcn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jblcn.setBackground(new Color(76,175,80));
		jblcn.setBounds(0, 0, 169, 54);
		Congnhan.add(jblcn);
		
		JPanel Sanpham = new JPanel();
		Sanpham.setLayout(null);
		Sanpham.setForeground(Color.LIGHT_GRAY);
		Sanpham.setBackground(new Color(76,175,80));
		Sanpham.setBounds(10, 207, 169, 54);
		JplMenu.add(Sanpham);
		
		JLabel jblsp = new JLabel("Sản phẩm\r\n\r\n");
		jblsp.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\IconSanpham.png"));
		jblsp.setHorizontalAlignment(SwingConstants.CENTER);
		jblsp.setForeground(Color.BLACK);
		jblsp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jblsp.setBackground(new Color(76,175,80));
		jblsp.setBounds(0, 0, 169, 54);
		Sanpham.add(jblsp);
		
		JPanel Timkiem = new JPanel();
		Timkiem.setLayout(null);
		Timkiem.setForeground(Color.LIGHT_GRAY);
		Timkiem.setBackground(new Color(76,175,80));
		Timkiem.setBounds(13, 272, 166, 54);
		JplMenu.add(Timkiem);
		
		JLabel jbltk = new JLabel("Tìm kiếm\r\n\r\n");
		jbltk.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\iconTimkiem.png"));
		jbltk.setHorizontalAlignment(SwingConstants.CENTER);
		jbltk.setForeground(Color.BLACK);
		jbltk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jbltk.setBackground(new Color(76,175,80));
		jbltk.setBounds(0, 0, 159, 54);
		Timkiem.add(jbltk);
		
		JPanel Taikhoan = new JPanel();
		Taikhoan.setLayout(null);
		Taikhoan.setForeground(Color.LIGHT_GRAY);
		Taikhoan.setBackground(new Color(76,175,80));
		Taikhoan.setBounds(10, 337, 169, 54);
		JplMenu.add(Taikhoan);
		
		JLabel jblAcc = new JLabel("Tài khoản\r\n");
		jblAcc.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\iconTaikhoan.png"));
		jblAcc.setHorizontalAlignment(SwingConstants.CENTER);
		jblAcc.setForeground(Color.BLACK);
		jblAcc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jblAcc.setBackground(new Color(76,175,80));
		jblAcc.setBounds(0, 0, 169, 54);
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
		list.add(new DanhmucApp("Nhanvien",Nhanvien,Jblnv));
		list.add(new DanhmucApp("Congnhan",Congnhan,jblcn));
		list.add(new DanhmucApp("Sanpham",Sanpham,jblsp));
		list.add(new DanhmucApp("Timkiem",Timkiem,jbltk));
		list.add(new DanhmucApp("Taikhoan",Taikhoan,jblAcc));
		
		Chuyenmanhinhcontroller controller= new Chuyenmanhinhcontroller(Jplview);
		Jplview.setLayout(null);
		controller.setView(Home,Jblhome);
		
	 btnthoat = new JButton("Thoát");
	 btnthoat.setBackground(Color.PINK);
		btnthoat.setBounds(93, 450, 89, 23);
		JplMenu.add(btnthoat);
		controller.setEvent(list);
		 btnthoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnthoat)) {
//			new Dangnhap().setVisible(true);
//			dispose();
//			int dialogResult = JOptionPane.showOptionDialog(null, "Bạn có muốn tiếp tục?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
//			if (dialogResult == JOptionPane.YES_OPTION) {
//			    // User clicked Yes button
//				new Dangnhap().setVisible(true);
//					dispose();
//			} else {
//			  JOptionPane.show
//			  }
			int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng nhập lại không?", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			if (dialogResult == JOptionPane.YES_OPTION) {
			    // User clicked Yes button
				new Dangnhap().setVisible(true);
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Hủy thoát thành công!");
//				System.exit(0);
			    // User clicked No button
				
			}
		}
	}
}
