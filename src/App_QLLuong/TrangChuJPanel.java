package App_QLLuong;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TrangChuJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangChuJPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 499, 340);
		panel.setBackground(new Color(255, 165, 0));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\APP_quanLyLuong\\App_QuanlyluongSP\\src\\Icons\\logo\\logo.png"));
		lblNewLabel.setBounds(0, 0, 498, 340);
		panel.add(lblNewLabel);
	
		
	}

}
