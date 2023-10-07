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
		panel.setBackground(new Color(220, 20, 60));
		add(panel);

	}

}
