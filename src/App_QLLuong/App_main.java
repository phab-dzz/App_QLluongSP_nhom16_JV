package App_QLLuong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setBounds(70, 40,1150, 684);
		setResizable(false);  // Không cho phép thay đổi kích thước
		setTitle("QUẢN LÝ LƯƠNG SẢN PHẨM");
	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpnroot = new JPanel();
		jpnroot.setBounds(0, 0, 203, 651);
		jpnroot.setBackground(new Color(0, 0, 128));
		contentPane.add(jpnroot);
		jpnroot.setLayout(null);
		
		
	
		
		JPanel JplMenu = new JPanel();
		JplMenu.setBackground(new Color(0, 0, 128));
		JplMenu.setBounds(0, 136, 192, 530);
		jpnroot.add(JplMenu);
		JplMenu.setLayout(null);
		
		JPanel Nhansu = new JPanel();
		Nhansu.setForeground(new Color(192, 192, 192));
		Nhansu.setBounds(10, 68, 182, 38);
		JplMenu.add(Nhansu);
		Nhansu.setBackground(new Color(0, 0, 255));
		Nhansu.setLayout(null);
		
		JLabel Jblns = new JLabel("Nhân sự");
		Jblns.setIcon(new ImageIcon(App_main.class.getResource("/Icons/menu_left/nhansu.png")));
		Jblns.setHorizontalAlignment(SwingConstants.CENTER);
		Jblns.setForeground(Color.WHITE);
		Jblns.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Jblns.setBackground(new Color(76, 175, 80));
		Jblns.setBounds(0, 0, 169, 43);
		Nhansu.add(Jblns);
		
		JPanel Home = new JPanel();
		Home.setBounds(10, 11, 182, 38);
		JplMenu.add(Home);
		Home.setBackground(new Color(0, 0, 255));
		Home.setLayout(null);
		
		JLabel Jblhome = new JLabel("Trang chủ");
		Jblhome.setBackground(new Color(0, 0, 255));
		Jblhome.setForeground(new Color(255, 255, 255));
		Jblhome.setHorizontalAlignment(SwingConstants.CENTER);
		Jblhome.setIcon(new ImageIcon(App_main.class.getResource("/Icons/menu_left/baseline_home_white_24dp.png")));
		Jblhome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Jblhome.setBounds(0, 0, 169, 43);
		Home.add(Jblhome);
		
		//hinh
//		Image imgmenu = Toolkit.getDefaultToolkit().createImage( App_main.class.getResource("nen.jpg"));
//		
//		Jlblogo.setBackground(new ImageIcon(Toolkit.getDefaultToolkit().createImage( App_main.class.getResource("nen.jpg"))));
		JPanel Jplview = new JPanel();
		Jplview.setBounds(222, 11, 912, 623);
		contentPane.add(Jplview);
		
		//
	
//
		
		JPanel Luong = new JPanel();
		Luong.setLayout(null);
		Luong.setForeground(Color.LIGHT_GRAY);
		Luong.setBackground(new Color(0, 0, 255));
		Luong.setBounds(10, 129, 182, 38);
		JplMenu.add(Luong);
		
		JPanel Sanpham = new JPanel();
		Sanpham.setLayout(null);
		Sanpham.setForeground(Color.LIGHT_GRAY);
		Sanpham.setBackground(new Color(0, 0, 255));
		Sanpham.setBounds(10, 189, 182, 38);
		JplMenu.add(Sanpham);
		
		JPanel Thongke = new JPanel();
		Thongke.setLayout(null);
		Thongke.setForeground(Color.LIGHT_GRAY);
		Thongke.setBackground(new Color(0, 0, 255));
		Thongke.setBounds(10, 251, 182, 38);
		JplMenu.add(Thongke);
		
		JLabel jbltk = new JLabel("Thống kê");
//		jbltk.setIcon(new ImageIcon(App_main.class.getResource("/Icons/menu_left/tk.png")));
		ImageIcon ImageTK = new ImageIcon(App_main.class.getResource("/Icons/menu_left/tk.png"));
		Image scaleTK = ImageTK.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
		ImageTK = new ImageIcon(scaleTK);
		jbltk.setIcon(ImageTK);
		jbltk.setHorizontalAlignment(SwingConstants.CENTER);
		jbltk.setForeground(new Color(255, 255, 255));
		jbltk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jbltk.setBackground(new Color(0, 0, 255));
		jbltk.setBounds(0, 0, 169, 43);
		Thongke.add(jbltk);
		
		JPanel Chamcong = new JPanel();
		Chamcong.setLayout(null);
		Chamcong.setForeground(Color.LIGHT_GRAY);
		Chamcong.setBackground(new Color(0, 0, 255));
		Chamcong.setBounds(10, 312, 182, 38);
		JplMenu.add(Chamcong);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-221, -6, 211, 60);
		Jplview.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("src\\Icons\\logo\\logo.png"));
		
		JLabel jblluong = new JLabel("Lương");
		jblluong.setBounds(0, 0, 169, 43);
		Luong.add(jblluong);

		ImageIcon ImageLuong = new ImageIcon(App_main.class.getResource("/Icons/menu_left/luong.png"));
		Image scaleLuong = ImageLuong.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageLuong = new ImageIcon(scaleLuong);
		jblluong.setIcon(ImageLuong);
		jblluong.setHorizontalAlignment(SwingConstants.CENTER);
		jblluong.setForeground(new Color(255, 255, 255));
		jblluong.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jblluong.setBackground(new Color(76,175,80));
		
		
		JLabel jblsp = new JLabel("Sản phẩm");
		jblsp.setBounds(0, 0, 169, 43);
		Sanpham.add(jblsp);
	
		ImageIcon ImageSP = new ImageIcon(App_main.class.getResource("/Icons/menu_left/sp.png"));
		Image scaleSP = ImageSP.getImage().getScaledInstance(33, 27, Image.SCALE_SMOOTH);
		ImageSP = new ImageIcon(scaleSP);
		jblsp.setIcon(ImageSP);
		jblsp.setHorizontalAlignment(SwingConstants.CENTER);
		jblsp.setForeground(new Color(255, 255, 255));
		jblsp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jblsp.setBackground(new Color(76,175,80));
				
		JPanel Phancong = new JPanel();
		Phancong.setLayout(null);
		Phancong.setForeground(Color.LIGHT_GRAY);
		Phancong.setBackground(Color.BLUE);
		Phancong.setBounds(10, 374, 182, 38);
		JplMenu.add(Phancong);
		
		JLabel lblphancong = new JLabel("Phân công");

		ImageIcon Imagepc = new ImageIcon(App_main.class.getResource("/Icons/menu_left/pc.png"));
		Image scalepc = Imagepc.getImage().getScaledInstance(27, 22, Image.SCALE_SMOOTH);
		Imagepc = new ImageIcon(scalepc);
		lblphancong.setIcon(Imagepc);
		lblphancong.setBounds(0, 0, 169, 43);
		Phancong.add(lblphancong);
		lblphancong.setHorizontalAlignment(SwingConstants.CENTER);
		lblphancong.setForeground(Color.WHITE);
		lblphancong.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblphancong.setBackground(new Color(76, 175, 80));
		
		JLabel jblchamcong = new JLabel("Chấm công");
		jblchamcong.setBounds(0, 0, 169, 43);
		Chamcong.add(jblchamcong);
		ImageIcon Imagecc = new ImageIcon(App_main.class.getResource("/Icons/menu_left/cc.png"));
		Image scalecc = Imagecc.getImage().getScaledInstance(27, 22, Image.SCALE_SMOOTH);
		Imagecc = new ImageIcon(scalecc);
		jblchamcong.setIcon(Imagecc);
		jblchamcong.setHorizontalAlignment(SwingConstants.CENTER);
		jblchamcong.setForeground(new Color(255, 255, 255));
		jblchamcong.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jblchamcong.setBackground(new Color(76,175,80));
	
		
		JPanel logo = new JPanel();
		logo.setBounds(10, 11, 182, 114);
		jpnroot.add(logo);
		logo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\Icons\\logo\\Screenshot 2023-10-18 231826.png"));
		lblNewLabel.setBounds(0, 0, 182, 114);
		logo.add(lblNewLabel);
		Jplview.setLayout(null);
		//chuyen panel
		//
			//
			List<DanhmucApp> list= new ArrayList<>();
			list.add(new DanhmucApp("Trangchu",Home,Jblhome));
			list.add(new DanhmucApp("Thongke",Thongke,jbltk));
			list.add(new DanhmucApp("Chamcong",Chamcong,jblchamcong));
			list.add(new DanhmucApp("Sanpham",Sanpham,jblsp));
			list.add(new DanhmucApp("Luong",Luong,jblluong));
			list.add(new DanhmucApp("Nhansu",Nhansu,Jblns));
			list.add(new DanhmucApp("Phancong",Phancong,lblphancong));

			
			Chuyenmanhinhcontroller controller= new Chuyenmanhinhcontroller(Jplview);
			
			JLabel lblNewLabel_2 = new JLabel("Đăng xuất\r\n");
			lblNewLabel_2.setBounds(-67, 499, 172, 38);
			Jplview.add(lblNewLabel_2);
		
				
			
			lblNewLabel_2.setIcon(new ImageIcon("src\\Icons\\menu_left\\baseline_logout_white_24dp.png"));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			controller.setView(Home,Jblhome);
			
			JButton btnNewButton = new JButton("Đăng xuất");
			btnNewButton.setBorder(null);
			btnNewButton.setIcon(new ImageIcon(App_main.class.getResource("/Icons/menu_left/baseline_logout_white_24dp.png")));
			btnNewButton.setSelectedIcon(new ImageIcon("src\\Icons\\logo\\background.jpg"));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object o= e.getSource();
					if(JOptionPane.showConfirmDialog(null,"Bạn có muốn đăng xuất không ?" ," Xác nhận", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(btnNewButton, e);
						System.exit(0);
					}
					else
						JOptionPane.showMessageDialog(null, "Bạn đã hủy thoát !");
				}
			});
			btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
			btnNewButton.setBackground(new Color(0, 0, 255));
			btnNewButton.setBounds(10, 445, 182, 38);
			JplMenu.add(btnNewButton);
		
		controller.setEvent(list);
	}
}
