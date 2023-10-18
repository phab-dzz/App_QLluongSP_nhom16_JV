package App_QLLuong;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Color;

public class NhansuJpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public NhansuJpanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.MAGENTA);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));

	}

}
