package CustomGUi;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class CustomTabbedPaneUI extends BasicTabbedPaneUI {
    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(isSelected ? Color.decode("#0000FF") : Color.white);
        g2d.fillRect(x, y, w, h);
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        // Do not paint any border
        // Do not paint any border
    	 Color savedColor = g.getColor();
         
    	g.fillRect(rects[tabIndex].x, rects[tabIndex].y, 
    			rects[tabIndex].width, rects[tabIndex].height);
//    	   g.setColor(Color.gray);
      g.drawRect(rects[tabIndex].x, rects[tabIndex].y, 
      rects[tabIndex].width, rects[tabIndex].height);
      g.setColor(savedColor);
    }
}

