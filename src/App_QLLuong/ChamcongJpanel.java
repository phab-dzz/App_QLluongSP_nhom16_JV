package App_QLLuong;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Dangnhap.Dangnhap;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class ChamcongJpanel extends JPanel  {
	
	public ChamcongJpanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phấn đẹp trai <3\r\n\r\n");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 24, 230, 72);
		add(lblNewLabel);

	}
}
