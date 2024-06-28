import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
        return sdf.format(date);
    }

    public static String timeToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH시mm분");
        return sdf.format(date);
    }
}
