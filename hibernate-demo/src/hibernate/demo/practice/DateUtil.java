package hibernate.demo.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	public static Date parseDate(String theDate) throws ParseException{
		Date date = formatter.parse(theDate);
		return date;
	}
	public static String formatDate(Date theDate){
		if(theDate == null){
			return null;
		}
		return formatter.format(theDate);
	}
}
