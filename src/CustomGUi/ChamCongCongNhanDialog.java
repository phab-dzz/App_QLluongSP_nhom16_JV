package CustomGUi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.BangChamCongCongNhan_BUS;
import DTO.BangChamCongCongNhan;

public class ChamCongCongNhanDialog extends JDialog {
	private JTable table;
	private JComboBox<String> comboBox = new JComboBox<>();
	private JComboBox<String> comboBox_1 = new JComboBox<>();
	ArrayList<BangChamCongCongNhan> dscn;
	private DefaultTableModel modelCn = new DefaultTableModel(null,
			new String[] { "STT", "Mã công nhân", "Tên công nhân", "Xưởng", "Số sản phẩm làm được",
					"Số sản phẩm Tăng ca", "Số ngày làm việc", "Số ngày nghỉ" }) {
		Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, Integer.class,
				Integer.class, Integer.class, Integer.class };

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	};

	public ChamCongCongNhanDialog() throws Exception {
		setBounds(100, 150, 800, 500);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Bảng thống kê chấm công công nhân");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(199, 11, 363, 20);
		getContentPane().add(lblNewLabel);

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel<>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox.setBounds(199, 48, 82, 22);
		getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangChamCongCongNhan_BUS bus = new BangChamCongCongNhan_BUS();
				ArrayList<BangChamCongCongNhan> ds = null;
				try {
					ds = bus.getDanhSachCongNhan();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dscn = ds;
				ArrayList<BangChamCongCongNhan> newList = new ArrayList<>();
				newList = bus.filterDataByMonthAndYear(dscn, (String) comboBox.getSelectedItem(),
						(String) comboBox_1.getSelectedItem());
				resettableCN(modelCn, newList);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Tháng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(111, 51, 74, 16);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Năm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(380, 51, 47, 16);
		getContentPane().add(lblNewLabel_1_1);

		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "2022", "2023" }));
		comboBox_1.setBounds(435, 48, 56, 22);
		getContentPane().add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangChamCongCongNhan_BUS bus = new BangChamCongCongNhan_BUS();
				ArrayList<BangChamCongCongNhan> ds = null;
				try {
					ds = bus.getDanhSachCongNhan();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dscn = ds;
				ArrayList<BangChamCongCongNhan> newList = new ArrayList<>();
				newList = bus.filterDataByMonthAndYear(dscn, (String) comboBox.getSelectedItem(),
						(String) comboBox_1.getSelectedItem());
				resettableCN(modelCn, newList);
			}
		});
		getContentPane().add(comboBox_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 760, 300);
		getContentPane().add(scrollPane);

		table = new JTable(modelCn);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
		initDataCN(null, modelCn);
		resettableCN(modelCn, dscn);

		JButton btnXuatExcel = new JButton("Xuất Excel");
		btnXuatExcel.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXuatExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Xuat excel
				try {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Bảng trống", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
					} else {
						exportToExcel(table);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnXuatExcel.setBounds(650, 390, 115, 25);
		getContentPane().add(btnXuatExcel);
	}

	// Xu ly xuat excel
	private static void exportToExcel(JTable table) throws Exception {
		String generatedString = RandomStringUtils.random(4, true, true);
		String filePath = "D:\\XuatExcel\\BangChamCongNhan_" + generatedString + ".xlsx";
		TableModel model = table.getModel();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row;
		Cell cell;
		// write the column headers
		row = sheet.createRow(0);
		for (int c = 0; c < model.getColumnCount(); c++) {
			cell = row.createCell(c);
			cell.setCellValue(model.getColumnName(c));
		}
		// write the data rows
		for (int r = 0; r < model.getRowCount(); r++) {
			row = sheet.createRow(r + 1);
			for (int c = 0; c < model.getColumnCount(); c++) {
				cell = row.createCell(c);
				Object value = model.getValueAt(r, c);
				if (value instanceof String) {
					cell.setCellValue((String) value);
				} else if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
			}
		}
		File file = new File(filePath);
		file.getParentFile().mkdirs();
		file.createNewFile();
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		out.close();
		workbook.close();
		JOptionPane.showMessageDialog(null, "Xuất file thành công.\nXem tại: " + filePath, "Kết quả",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChamCongCongNhanDialog dialog = new ChamCongCongNhanDialog();
					dialog.setModal(true);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initDataCN(DefaultTableModel modelNv, DefaultTableModel modelCn) throws Exception {

		BangChamCongCongNhan_BUS chamCongCNBus = new BangChamCongCongNhan_BUS();
		ArrayList<BangChamCongCongNhan> dsCN = chamCongCNBus.getDanhSachCongNhan();
		dscn = dsCN;
		resettableCN(modelCn, dsCN);
	}

	private void resettableCN(DefaultTableModel modelCn, ArrayList<BangChamCongCongNhan> dsCN) {
		while (table.getRowCount() > 0) {
			modelCn.removeRow(0);
		}
		int stt = 1;
		for (BangChamCongCongNhan row : dsCN) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Vector vec = new Vector<>();
			vec.add(stt++);
			vec.add(row.getMaCongNhan());
			vec.add(row.getCn().getTen());
			vec.add(row.getCn().getXuong());
			vec.add(row.getSoLuongSanPham());
			vec.add(row.getSoSPGioTangCa());
			vec.add(row.getSoNgayLamViec());
			vec.add(row.getSoNgayNghi());
			modelCn.addRow(vec);

		}

	}
}