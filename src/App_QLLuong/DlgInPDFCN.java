package App_QLLuong;

import MyCustom.MyDialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import DTO.BangLuongCongNhan;

import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;



public class DlgInPDFCN extends JDialog {

    private static final long serialVersionUID = 379142338552281235L;
//	private HoaDonBUS hoadonBUS = new HoaDonBUS();
//    private CTHoaDonBUS ctHoaDonBUS = new CTHoaDonBUS();

    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane txtHoaDon;

    public DlgInPDFCN(BangLuongCongNhan l) {
        checkBanHang = false;
        initComponents(l);
//        URL url= DlgInPDFCN.class.getResource("/Icons/logo/bill.png");
//		Image img = Toolkit.getDefaultToolkit().createImage(url);
//		
//		this.setIconImage(img);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setPreferredSize(new Dimension(600,600));
        Image icon = Toolkit.getDefaultToolkit().getImage("image/ManagerUI/icon-app.png");
        this.setIconImage(icon);
//        customEvents();
        xuLyHienThiHoaDon(l);
    }





    private void xuLyHienThiHoaDon(BangLuongCongNhan l) {
        txtHoaDon.setContentType("text/html");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        DecimalFormat dcf = new DecimalFormat("###,###,### VND");
        int maHDNew = 10;
 
        String hd = "<style> "
                + "table {"
                + "border: 1px solid;"
                + "border-bottom: none"
                + "}"
                + "tr {"
                + "border-bottom: 1px solid;"
                + "}"
                + "td {"
                + "padding: 8px;"
                + "} "
                + "th {"
                + "font-size:16pt"
                + "}"
                + "</style>";
        hd += "<h1 style='text-align:center; color'>thygesen Texttile VietNam\r\n</h1>";
        hd +="<div style='text-align:center;'>Địa chỉ : 12 Nguyễn Văn Bảo,Phường 4,Quận Gò Vấp ,TPHCM</div>";
        hd +="<div style='text-align:center;'>Hotline : 036375906</div>";
        
        hd += "<h1 style='text-align:center;'>PHIẾU LƯƠNG CHI TIẾT</h1>";
        hd +="<p style='text-align:right;'>Mã Phiếu:"+taoMaPL()+"</p>";
        hd += "Mã Nhân viên: " +l.getCongNhan().getMaCongNhan()+"<br/>" ;
       
        hd += "Nhân viên: " + l.getCongNhan().getTen() + "<br/>";
        hd += "Ngày lập: " + dtf.format(now) + "<br/>";
        
       
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        hd += "<div style='text-align:center'>";
       
        hd += "<table style='max-width:100%'>";
        hd += "<tr>"
                + "<th>Tên công đoạn </th>"
                + "<th>Tên sản phẩm</th>"
                + "<th>Số lượng sản phẩm</th>"
                + "<th>Phụ cấp</th>"
                +"<th>Tiền thưởng</th>"
                + "<th>Tiền lương</th>"
                + "</tr>";
//        for (Vector vec : dsGioHang) {
            hd += "<tr>";
            hd += "<td style='text-align:center;'>" +l.getCongNhan().getChuyenMon() + "</td>";
            hd += "<td style='text-align:left;'>" + "Áo hoodie"  + "</td>";
            hd += "<td style='text-align:center;'>" +"150"  + "</td>";
            hd += "<td style='text-align:center;'>" + dcf.format( l.getPhuCap()) + "</td>";
            hd += "<td style='text-align:center;'>" + dcf.format( l.getTienThuong()) + "</td>";
            hd += "<td style='text-align:center;'>" + dcf.format( l.getThucLanh()) + "</td>";
            hd += "</tr>";
//        }
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Tổng cộng</td>";
        hd += "<td style='text-align:center;'>" + dcf.format( l.getThucLanh()) + "</td>";
        hd += "</tr>";

        hd += "</table>";
        hd += "</div>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        hd += "<div style='text-align:center;'>Nếu có gì sai sót, Bạn hay liên hệ phòng kế toán.</div><br/>";
        txtHoaDon.setText(hd);

    }


    private void initComponents(BangLuongCongNhan l) {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnInHoaDon = new javax.swing.JButton();
        btnInHoaDon.setBackground(new Color(30, 144, 255));
        btnInHoaDon.setBorder(null);
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHoaDon = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        jLabel5.setText("jLabel5");

        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("CHI TIẾT PHIẾU LƯƠNG\r\n");
        jPanel1.add(jLabel1);

        btnInHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInHoaDon.setText("In hoá đơn");
     
        btnInHoaDon.setPreferredSize(new java.awt.Dimension(128, 45));
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });
        jPanel2.add(btnInHoaDon);

        txtHoaDon.setEditable(false);
        jScrollPane1.setViewportView(txtHoaDon);

        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 15)); // NOI18N
        jLabel2.setText("Công Nhân:\r\n");
        
        lblNewLabel = new JLabel();
        lblNewLabel.setText(l.getCongNhan().getTen());
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        lblNewLabel_1 = new JLabel("Thông tin Phiếu lương");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setText(l.getNgayTinh().getMonthValue()+"");
        
        lblNewLabel_3 = new JLabel();
        lblNewLabel_3.setText(l.getNgayTinh().getYear()+"");
        lblMCn = new JLabel();
        lblMCn.setText("Mã CN :");
        lblMCn.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        lblCn = new JLabel();
        lblCn.setText(l.getCongNhan().getMaCongNhan());
        lblCn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        lblNewLabel_4 = new JLabel("Tháng :");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        lblNewLabel_5 = new JLabel("Năm :\r\n");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        		.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(24)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblMCn, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblCn, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        					.addGap(138)
        					.addComponent(lblNewLabel_4)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        					.addGap(25))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel2)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(175, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_3)
        						.addComponent(lblNewLabel_2)
        						.addComponent(lblNewLabel_4)
        						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
        					.addGap(53)
        					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        					.addGap(18))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblMCn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblCn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel2)
        						.addComponent(lblNewLabel))
        					.addGap(44)))
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }

    public static boolean checkBanHang = false;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblMCn;
    private JLabel lblCn;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!txtHoaDon.getText().equals("")) {
                txtHoaDon.print();
                this.dispose();
            }
        } catch (PrinterException ex) {
        }
        
    }
    public String taoMaPL() {
    	int so= new Random().nextInt(1000,9999);
    	String ma="PLCN" +so;
    	return ma;
    }


   
}
