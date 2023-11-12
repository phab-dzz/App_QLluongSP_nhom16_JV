package ChuyenmanController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import App_QLLuong.LuongJpanel;
import App_QLLuong.NhansuJpanel;
import App_QLLuong.PhancongJPanel;
import App_QLLuong.SanphamJpanel;
import App_QLLuong.ChamcongJpanel;
import App_QLLuong.ThongkeJpanel;
import App_QLLuong.TrangChuJPanel;
import DTO.DanhmucApp;

public class Chuyenmanhinhcontroller {
    private JPanel jpnRoot;
    private String kindSelected = "";
    private List<DanhmucApp> ListItem;

    public Chuyenmanhinhcontroller(JPanel jpnRoot) {
        super();
        this.jpnRoot = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel JblItem) {
        kindSelected = "Trangchu";
        jpnItem.setBackground(new Color(76, 175, 80));
        JblItem.setBackground(new Color(76, 175, 80));
        JPanel node = new TrangChuJPanel();

        jpnRoot.removeAll();
        jpnRoot.setLayout(new BorderLayout());
        jpnRoot.add(node);
        jpnRoot.validate();
        jpnRoot.repaint();
    }

    public void setEvent(List<DanhmucApp> ListItem) {
        this.ListItem = ListItem;
        for (DanhmucApp item : ListItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {
        private JPanel node;
        private String Kind;

        private JPanel JpnItem;
        private JLabel JlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            super();
            Kind = kind;
            this.JpnItem = jpnItem;
            this.JlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (JlbItem.isEnabled()) {
                switch (Kind) {
                    case "Trangchu": {
                        node = new TrangChuJPanel();
                        break;
                    }
                    case "Nhansu": {
                        node = new NhansuJpanel();
                        break;
                    }
                    case "Luong": {
                        node = new LuongJpanel();
                        break;
                    }
                    case "Sanpham": {
                        node = new SanphamJpanel();
                        break;
                    }
                    case "Thongke": {
                        node = new ThongkeJpanel();
                        break;
                    }
                    case "Chamcong": {
                        node = new ChamcongJpanel();
                        break;
                    }
                    case "Phancong": {
                        node = new PhancongJPanel();
                        break;
                    }
                    default: {
                        break;
                    }
                }

                jpnRoot.removeAll();
                jpnRoot.setLayout(new BorderLayout());
                jpnRoot.add(node);
                jpnRoot.validate();
                jpnRoot.repaint();

                setChangeBackground(Kind);
            } else {
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(Kind)) {
                JlbItem.setBackground(new Color(0, 0, 255));
                JpnItem.setBackground(new Color(0, 0, 255));
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        	 if (JlbItem.isEnabled()) {
                 kindSelected = Kind;
                 JlbItem.setBackground(new Color(76, 175, 80));
                 JpnItem.setBackground(new Color(76, 175, 80));
                 JlbItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
             }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JlbItem.setBackground(new Color(76, 175, 80));
            JpnItem.setBackground(new Color(76, 175, 80));
            JlbItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    public void setChangeBackground(String kind) {
        for (DanhmucApp item : ListItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJlb().setBackground(new Color(76, 175, 80));
                item.getJpn().setBackground(new Color(76, 175, 80));
            } else {
                item.getJlb().setBackground(new Color(0, 0, 255));
                item.getJpn().setBackground(new Color(0, 0, 255));
            }
        }
    }
}
