package CommonMethods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {
	public static String date1;

	public static void DateTimeGenerator() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		date1 = dateFormat.format(date);
		System.out.println(date1);
	}
	public static String DateTimeGenerator(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		date1 = dateFormat.format(date);
		System.out.println("generated Date is ======   "+ date1);
		return  date1;
	}
}
