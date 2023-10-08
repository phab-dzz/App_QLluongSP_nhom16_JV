package ChuyenmanController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.constant.DirectMethodHandleDesc.Kind;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import App_QLLuong.XulyJpanel;
import App_QLLuong.DanhmucJpanel;
import App_QLLuong.TimkiemJpanel;
import App_QLLuong.TaikhoanJpanel;
import App_QLLuong.ThongkeJpanel;
import App_QLLuong.TrangChuJPanel;
import DTO.DanhmucApp;

public class Chuyenmanhinhcontroller {
	private JPanel jpnRoot;
	private String kindSelected="";
	private List<DanhmucApp> ListItem;
	
	public Chuyenmanhinhcontroller(JPanel jpnRoot) {
		super();
		this.jpnRoot = jpnRoot;
	}
	public void setView(JPanel jpnItem, JLabel JblItem) {
		kindSelected="Trangchu";
		jpnItem.setBackground(new Color(76,175,80));
		JblItem.setBackground(new Color(76,175,80));
	JPanel node = new TrangChuJPanel();
	
		jpnRoot.removeAll();
		jpnRoot.setLayout(new BorderLayout());
		jpnRoot.add(node);
		jpnRoot.validate();
		jpnRoot.repaint();
		
		
	}
	public void setEvent(List<DanhmucApp> ListItem) {
		this.ListItem=ListItem;
		for (DanhmucApp item: ListItem) {
			item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(), item.getJlb()));
			
		}
	
	}
	class LabelEvent implements MouseListener{
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
			// TODO Auto-generated method stub
			switch (Kind) {
			case "Trangchu": {
				node= new TrangChuJPanel();
				
				break;
			}
			case "Nhanvien":{
				node = new DanhmucJpanel();

				break;
				
			}
			case "Congnhan":{
				node = new XulyJpanel();
				
				break;
			}
			case "Sanpham":{
				node = new TimkiemJpanel();
				
				break;
			}
			case "Timkiem":{
				node= new ThongkeJpanel();
				
				break;
			}
			case "Taikhoan":{
				node = new TaikhoanJpanel();
				
				break;
			}
			default :
			{	
				 break;
			}}
			
		
			jpnRoot.removeAll();
			jpnRoot.setLayout(new BorderLayout());
			jpnRoot.add(node);
			jpnRoot.validate();
			jpnRoot.repaint();
			
			setChangeBackground(Kind);
	
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(!kindSelected.equalsIgnoreCase(Kind)) {
				JlbItem.setBackground( new Color(0,0,255));
				JpnItem.setBackground( new Color(0,0,255));
		}
			
			
	}
		@Override
		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
			kindSelected=Kind;
//			JlbItem.setBackground( new Color(76,175,80));
//			JpnItem.setBackground( new Color(76,175,80));
			JlbItem.setBackground( new Color(76,175,80));
			JpnItem.setBackground( new Color(76,175,80));
			JlbItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			

			
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			JlbItem.setBackground( new Color(76,175,80));
			JpnItem.setBackground( new Color(76,175,80));
//			JlbItem.setBackground( new Color(96,100,191));
//			JpnItem.setBackground( new Color(96,100,191));
			JlbItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		
			
		}
	

	}
	public void setChangeBackground(String kind) {
		for( DanhmucApp item : ListItem) {
			if(item.getKind().equalsIgnoreCase(kind)) {
				
				item.getJlb().setBackground( new Color(76,175,80));
				item.getJpn().setBackground(new Color(76,175,80));
			}
			else {
				item.getJlb().setBackground( new Color(0,0,255));
				item.getJpn().setBackground(new Color(0,0,255));
			}
		}
	}
	

}
