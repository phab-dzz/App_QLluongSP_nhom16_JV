package Dangnhap;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App_QLLuong.App_main;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class Dangnhap extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtma;
	 private JButton btndn;
	 private JPasswordField pass;
	 private JCheckBox jcbxem;
	 private 	JLabel lblexit;

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

	/**
	 * Create the frame.
	 */
	public Dangnhap() {
		setTitle("Đăng nhập hệ thống quản lý lương");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	       
        this.setUndecorated(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel dangnhap = new JPanel();
		dangnhap.setBounds(0, 0, 450, 300);
		contentPane.add(dangnhap);
		dangnhap.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng Nhập tài khoản");
		lblNewLabel.setForeground(new Color(244, 164, 96));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(52, 11, 304, 60);
		dangnhap.add(lblNewLabel);
		
		txtma = new JTextField();
		txtma.setBounds(155, 82, 213, 34);
		dangnhap.add(txtma);
		txtma.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã số Nhân viên:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 82, 125, 34);
		dangnhap.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(" Mật khẩu :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(30, 127, 99, 34);
		dangnhap.add(lblNewLabel_1_1);
		btndn = new JButton("Đăng nhập");
		btndn.setSelectedIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\baseline_login_black_24dp.png"));
		btndn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btndn.setBackground(new Color(255, 228, 196));
		btndn.setBounds(142, 235, 146, 34);
		 btndn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dangnhap.add(btndn);
		
		pass = new JPasswordField();
		pass.setBounds(155, 127, 213, 33);
		dangnhap.add(pass);
		
		 jcbxem = new JCheckBox("Xem mật khẩu");
		jcbxem.setBounds(153, 177, 124, 23);
		dangnhap.add(jcbxem);
		jcbxem.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(jcbxem.isSelected())
				{
					pass.setEchoChar((char)0);
				}
				else
					pass.setEchoChar('*');
				
			}
		});
		btndn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		btndn.addActionListener(this);
		btndn.setMnemonic(KeyEvent.VK_ENTER);
		
		 lblexit = new JLabel("");
		lblexit.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\btn-close.png"));
		lblexit.setBounds(402, 11, 38, 23);
		lblexit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dangnhap.add(lblexit);
		lblexit.addMouseListener(new MouseListener() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	            System.exit(0);
	         }

	         @Override
	         public void mousePressed(MouseEvent e) {
	        	
	         }
	         

	         @Override
	         public void mouseReleased(MouseEvent e) {
//	        	 lblexit.setIcon(new ImageIcon("Icons/btn-close.png"));
	         }

	         @Override
	         public void mouseEntered(MouseEvent e) {
//	             lblexit.setIcon(new ImageIcon("Icons/btn-close--hover.png"));
	         }

	         @Override
	         public void mouseExited(MouseEvent e) {
//	           lblexit.setIcon(new ImageIcon("Icons/btn-close.png"));
	         }
	     });
		
		
	}
	 
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btndn)) {
			char[] password = pass.getPassword();
			String passwordString = new String(password);
			if(txtma.getText().equals("NV123")&&passwordString.equals("123")) {
				JOptionPane.showMessageDialog( this,"Đăng nhập thành công!!!<");
			 new App_main().setVisible(true);
			dispose();
			}
			else
			{
				JOptionPane.showMessageDialog( this,"Mã nhân viên hay mật khẩu sai,yêu cầu nhập lại!!");
				txtma.setText("");
				pass.setText("");
				txtma.requestFocus();
			}
				
			
		}
		
	}
}
