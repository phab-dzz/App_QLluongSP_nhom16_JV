package App_QLLuong;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;

public class LuongJpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LuongJpanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		add(panel);

	}

}
