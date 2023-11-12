package utilities;

import java.io.FileOutputStream;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class exportExcel {

	public static void exportToExcel(JTable table, String filePath) throws Exception {
		TableModel model = table.getModel();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = (Sheet) workbook.createSheet();
		Row row;
		Cell cell;

		// write the column headers
		row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);
		for (int c = 0; c < model.getColumnCount(); c++) {
			cell = row.createCell(c);
			cell.setCellValue(model.getColumnName(c));
		}

		// write the data rows
		for (int r = 0; r < model.getRowCount(); r++) {
			row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(r + 1);
			for (int c = 0; c < model.getColumnCount(); c++) {
				cell = row.createCell(c);
				Object value = model.getValueAt(r, c);
				if (value != null) {
					if (value instanceof String) {
						cell.setCellValue((String) value);
					} else if (value instanceof Double) {
						cell.setCellValue((Double) value);
					} else if (value instanceof Integer) {
						cell.setCellValue((Integer) value);
					} else {
						// Xử lý các kiểu dữ liệu khác nếu cần thiết
					}
				}
			}
		}

		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);
		out.close();
		workbook.close();
		JOptionPane.showMessageDialog(null, "Export success: " + filePath, "Dialog", JOptionPane.INFORMATION_MESSAGE);
	}

}
