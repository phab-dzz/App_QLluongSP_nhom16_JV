package utilities;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class DateChooserUtils {

    public static boolean isDateBeforeToday(JDateChooser dateChooser) {
        Date selectedDate = dateChooser.getDate();
        if (selectedDate == null) {
            // Nếu không có ngày được chọn, mặc định là hợp lệ
            return false;
        }

        LocalDate selectedLocalDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();

        return selectedLocalDate.isBefore(currentDate);
    }
}