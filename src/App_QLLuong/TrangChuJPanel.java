package App_QLLuong;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;

public class TrangChuJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangChuJPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
	
		
	}

}
