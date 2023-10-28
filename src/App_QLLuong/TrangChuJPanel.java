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
		panel.setBounds(0, 0, 910, 670);
		
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TrangChuJPanel.class.getResource("/Icons/logo/trangchu.png")));
		lblNewLabel.setBounds(0, 0, 910, 670);
		panel.add(lblNewLabel);
		

	
	
		
	}
}
