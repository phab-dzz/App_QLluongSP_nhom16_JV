package CustomGUi;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;

public class CustomComboBoxPopup extends BasicComboPopup {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomComboBoxPopup(JComboBox<?> combo) {
        super((JComboBox<Object>) combo);
    }

    @Override
    protected JScrollPane createScroller() {
        // Tạo một JScrollPane để hiển thị mục trong JComboBox
        JScrollPane scroller = super.createScroller();
        // Ẩn thanh trượt
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        return scroller;
    }
}

// Class chính
