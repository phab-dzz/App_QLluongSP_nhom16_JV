package Dangnhap;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import App_QLLuong.App_main;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

import BUS.TaiKhoan_BUS;

public class Dangnhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon ImageLogo;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dangnhap frame = new Dangnhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static int type;
	/**
	 * Create the frame.
	 */
	public Dangnhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 469);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		URL url= App_main.class.getResource("icon_main.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		this.setIconImage(img);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Đăng nhập");

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 729, 410);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-11, -11, 395, 421);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblLogo = new JLabel("New label");
		ImageLogo = new ImageIcon(getClass().getResource("/Icons/logo/logo.png"));
		Image scaleLogo = ImageLogo.getImage().getScaledInstance(395, 421, Image.SCALE_SMOOTH);
		ImageLogo = new ImageIcon(scaleLogo);
		lblLogo.setIcon(ImageLogo);
		lblLogo.setBounds(0, 0, 405, 421);

		panel_1.add(lblLogo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 255, 102), null, null, null));
		panel_2.setBackground(new Color(0, 0, 140));
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBounds(382, 0, 368, 410);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblWelcome = new JLabel("Xin Chào!");
		lblWelcome.setForeground(new Color(239, 239, 239));
		lblWelcome.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 22));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(79, 39, 215, 29);
		panel_2.add(lblWelcome);

		textFieldUsername = new JTextField();
		textFieldUsername.setBackground(new Color(255, 255, 255));
		textFieldUsername.setForeground(new Color(0, 0, 0));
		textFieldUsername.setToolTipText("Username:\r\n");
		textFieldUsername.setBounds(79, 164, 234, 29);
		panel_2.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		JLabel lblngNhpTi = new JLabel("Đăng nhập tài khoản");
		lblngNhpTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblngNhpTi.setForeground(new Color(216, 216, 216));
		lblngNhpTi.setFont(new Font("Verdana", Font.BOLD, 24));
		lblngNhpTi.setBounds(35, 79, 294, 29);
		panel_2.add(lblngNhpTi);

		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setFont(new Font("Verdana", Font.BOLD, 14));
		lblMaNhanVien.setForeground(new Color(239, 239, 239));
		lblMaNhanVien.setBounds(51, 139, 169, 14);
		panel_2.add(lblMaNhanVien);

		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setForeground(new Color(239, 239, 239));
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPassword.setBounds(50, 220, 98, 14);
		panel_2.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(79, 245, 234, 29);
		panel_2.add(passwordField);

		JLabel lblImgUser = new JLabel("");
		ImageIcon ImageUser = new ImageIcon(getClass().getResource("/Icons/logo/Username.png"));
		Image scaleUser = ImageUser.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageUser = new ImageIcon(scaleUser);
		lblImgUser.setIcon(ImageUser);
		lblImgUser.setBounds(0, 164, 61, 29);
		panel_2.add(lblImgUser);

		JLabel lblImgPassword = new JLabel("");
		ImageIcon ImagePassword = new ImageIcon(getClass().getResource("/Icons/logo/LogPassword.png"));
		Image scalePW = ImagePassword.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImagePassword = new ImageIcon(scalePW);
		lblImgPassword.setIcon(ImagePassword);
		lblImgPassword.setBounds(35, 245, 61, 29);
		panel_2.add(lblImgPassword);

		JButton btnQuenMK = new JButton("Quên mật khẩu?");
		btnQuenMK.setForeground(new Color(255, 255, 255));
		btnQuenMK.setBackground(new Color(0, 0, 151));
		btnQuenMK.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnQuenMK.setBounds(196, 298, 117, 23);
		panel_2.add(btnQuenMK);

		btnLogin = new JButton("Đăng nhập");

		JCheckBox chckbxXem = new JCheckBox("Xem mật khẩu");
		chckbxXem.setForeground(new Color(255, 255, 255));
		chckbxXem.setBackground(new Color(0, 0, 151));
		chckbxXem.setFont(new Font("Tahoma", Font.ITALIC, 11));
		chckbxXem.setBounds(79, 298, 97, 23);
		panel_2.add(chckbxXem);

		chckbxXem.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (chckbxXem.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else
					passwordField.setEchoChar('*');
			}
		});

		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 0, 72));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(115, 349, 140, 34);
		panel_2.add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object o = e.getSource();
				if (o.equals(btnLogin)) {
					char[] matKhau = passwordField.getPassword();
					String strMatKhau = new String(matKhau);
					String strTaiKhoan = textFieldUsername.getText();
					TaiKhoan_BUS taiKhoanBUS = new TaiKhoan_BUS();
					if (taiKhoanBUS.KiemTraTaiKhoan(strMatKhau, strMatKhau)) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công!!!");
						type = taiKhoanBUS.kiemTraPhanQuyen(strTaiKhoan);
						new App_main().setVisible(true);
						
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Đăng nhập sai, xin vui lòng thử lại!");
						textFieldUsername.setText("");
						passwordField.setText("");
						textFieldUsername.requestFocus();
					}

				}

			}
		});
		btnLogin.setMnemonic(KeyEvent.VK_ENTER);

	}

	
}
