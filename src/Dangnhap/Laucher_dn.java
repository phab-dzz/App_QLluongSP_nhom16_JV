package Dangnhap;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import App_QLLuong.App_main;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Laucher_dn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
					Laucher_dn frame = new Laucher_dn();
					frame.setVisible(true);
		
		 Timer timer = new Timer(3000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	             new    Dangnhap().setVisible(true);
	             frame.dispose();
	            
	            }
	        });
	        timer.setRepeats(false);
	        timer.start();
	       
	}

	/**
	 * Create the frame.
	 */
	public Laucher_dn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500,380);
		URL url= App_main.class.getResource("icon_main.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		this.setIconImage(img);
		// xoa thanh tiêu đề
		 this.setUndecorated(true);
		
		setResizable(false); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\PTUD\\App_QLluongSP_nhom16_JV\\src\\Icons\\logo\\logo.png"));
		lblNewLabel.setBounds(0, 0, 494, 359);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Đang khởi động app... Vui lòng chờ!\r\n");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(0, 355, 209, 21);
		panel.add(lblNewLabel_1);
	}
}
