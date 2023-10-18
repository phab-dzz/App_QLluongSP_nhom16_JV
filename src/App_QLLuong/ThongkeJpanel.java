package App_QLLuong;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;

public class ThongkeJpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThongkeJpanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		add(panel);
		
		JLabel lblThngK = new JLabel("Thống kê");
		panel.add(lblThngK);

	}

}
