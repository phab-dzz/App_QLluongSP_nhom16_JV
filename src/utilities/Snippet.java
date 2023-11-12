package utilities;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
	import java.util.GregorianCalendar;

import com.toedter.calendar.JDateChooser;
public class Snippet {
	
	
	public static LocalDate convertJDateChooserToLocalDate(JDateChooser dateChooser) {
	    Date date = dateChooser.getDate();
	    if (date != null) {
	        // Chuyển đổi từ java.util.Date sang java.util.GregorianCalendar
	        GregorianCalendar calendar = new GregorianCalendar();
	        calendar.setTime(date);
	
	        // Lấy ngày, tháng và năm
	        int year = calendar.get(Calendar.YEAR);
	        int month = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0
	        int day = calendar.get(Calendar.DAY_OF_MONTH);
	
	        // Tạo đối tượng LocalDate
	        LocalDate localDate = LocalDate.of(year, month, day);
	        return localDate;
	    } else {
	        // Xử lý trường hợp người dùng chưa chọn ngày
	        return null;
	    }
	}
}
	


