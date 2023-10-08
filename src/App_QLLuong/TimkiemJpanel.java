package App_QLLuong;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;

public class TimkiemJpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TimkiemJpanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(85, 107, 47));
		add(panel);

	}

}
