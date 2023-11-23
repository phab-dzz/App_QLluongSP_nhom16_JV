package CustomGUi;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.BangChamCongNhanVien_BUS;
import DTO.BangChamCongNhanVien;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ChamCongNhanVienDialog extends JDialog {
	private JTable table;
	private JComboBox<String> comboBoxNam = new JComboBox<>();
	private JComboBox<String> comboBox = new JComboBox<>();
	ArrayList<BangChamCongNhanVien> dsnv;
	private DefaultTableModel modelNv = new DefaultTableModel(null, new String[] { "STT", "Mã nhân viên",
			"Tên nhân viên", "Phòng ban", "Số giờ tăng ca", "Số ngày nghỉ", "Số ngày làm việc" }) {
		Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, Long.class,
				Integer.class, Integer.class };

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	};

	/**
	 * Create the dialog.
	 */
	public ChamCongNhanVienDialog() {
		setBounds(100, 150, 800, 500);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Bảng thống kê chấm công nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(199, 11, 258, 20);
		getContentPane().add(lblNewLabel);

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));

		comboBox.setModel(new DefaultComboBoxModel<>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox.setBounds(199, 48, 82, 22);
		getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangChamCongNhanVien_BUS bus = new BangChamCongNhanVien_BUS();
				ArrayList<BangChamCongNhanVien> ds = bus.getDanhSachNhanVien();
				dsnv = ds;
				ArrayList<BangChamCongNhanVien> newList = new ArrayList<>();
				newList = bus.filterDataByMonthAndYear(dsnv, (String) comboBox.getSelectedItem(),
						(String) comboBoxNam.getSelectedItem());
				resetTable(modelNv, newList);
			}
		});

		JLabel lblThang = new JLabel("Tháng");
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThang.setBounds(129, 51, 56, 16);
		getContentPane().add(lblThang);

		JLabel lblNam = new JLabel("Năm");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNam.setBounds(371, 51, 56, 16);
		getContentPane().add(lblNam);

		comboBoxNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxNam.setModel(new DefaultComboBoxModel<>(new String[] { "2022", "2023" }));
		comboBoxNam.setBounds(435, 48, 56, 22);
		getContentPane().add(comboBoxNam);
		comboBoxNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BangChamCongNhanVien_BUS bus = new BangChamCongNhanVien_BUS();
				ArrayList<BangChamCongNhanVien> ds = bus.getDanhSachNhanVien();
				dsnv = ds;
				ArrayList<BangChamCongNhanVien> newList = new ArrayList<>();
				newList = bus.filterDataByMonthAndYear(dsnv, (String) comboBox.getSelectedItem(),
						(String) comboBoxNam.getSelectedItem());
				resetTable(modelNv, newList);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 760, 300);
		getContentPane().add(scrollPane);

		table = new JTable(modelNv);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		scrollPane.setVerticalScrollBar(new ScrollBarCustom());
		initData(modelNv, null);
		resetTable(modelNv, dsnv);

		JButton btnXuatExcel = new JButton("Xuất Excel");
		btnXuatExcel.setBorder(new LineBorder(new Color(100, 149, 237)));
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
		btnXuatExcel.setBounds(650, 390, 120, 25);
		getContentPane().add(btnXuatExcel);
	}

	private static void exportToExcel(JTable table) throws Exception {
		String generatedString = RandomStringUtils.random(4, true, true);
		String filePath = "E:\\PTUD\\APP_LUONG\\App_QLluongSP_nhom16_JV\\src\\data\\BangChamNhanVien_" + generatedString + ".xlsx";
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

	private void initData(DefaultTableModel modelNv, DefaultTableModel modelCn) {
		BangChamCongNhanVien_BUS chamCongBus = new BangChamCongNhanVien_BUS();
		ArrayList<BangChamCongNhanVien> ds = chamCongBus.getDanhSachNhanVien();
		dsnv = ds;
		resetTable(modelNv, ds);
	}

	private void resetTable(DefaultTableModel modelNv, ArrayList<BangChamCongNhanVien> ds) {
		while (table.getRowCount() > 0) {
			modelNv.removeRow(0);
		}
		int stt = 1;
		for (BangChamCongNhanVien row : ds) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Vector vec = new Vector<>();
			vec.add(stt++);
			vec.add(row.getMaNhanVien());
			vec.add(row.getNv().getTen());
			vec.add(row.getNv().getPhongBan());
			vec.add(row.getSoGioTangCa());
			vec.add(row.getSoNgayNghi());
			vec.add(row.getSoNgayLamViec());
			modelNv.addRow(vec);
		}
	}
}
