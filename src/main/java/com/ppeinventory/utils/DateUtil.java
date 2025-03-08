import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(new Date());
    }

    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(date);
    }

    public static Date parseDate(String dateString) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.parse(dateString);
    }
}