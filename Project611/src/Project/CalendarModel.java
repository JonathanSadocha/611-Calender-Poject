package Project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//source: https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html
import java.util.Calendar;
//source: https://docs.oracle.com/javase/8/docs/api/java/text/ParseException.html
import java.text.ParseException;
//source: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
import java.text.SimpleDateFormat;

/***********************************************************************
*
* Calendar Model Class
*
* @author Jonathan Sadocha
* @version 1.0
*
**********************************************************************/
public class CalendarModel implements IModel {

	private String date;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	Calendar c = Calendar.getInstance();

	
	
	/***********************************************************************
	 *
	 * Gets date of the instance
	 *
	 * @return Date of the instance
	 *
	 **********************************************************************/
	@Override
	public String getDate() {
		return date;
	}
	
	/***********************************************************************
	 *
	 * Sets date that is given to it
	 *
	 * @param Date that is passed in to be set
	 *
	 **********************************************************************/
	@Override
	public void setDate(String date) {
		this.date = date;
	}
	
	private void setTime(String curDate) {
		try {
			c.setTime(sdf.parse(curDate));
		} catch (ParseException e) {
			//Should never be hit
			e.printStackTrace();
		}
	}
	
	/***********************************************************************
	 *
	 * Checks if the year of the date that is passed is greater than 1900
	 *
	 * @param dateIn is a string of the date that needs to be validated for the year
	 * 
	 * @return true of false whether the year is is over 1900 
	 *
	 **********************************************************************/
	public boolean validateYear(String dateIn) {
		try {
			int curdateYear = Integer.parseInt(dateIn.substring(dateIn.lastIndexOf("/")+1));
			
			if(curdateYear >= 1900) {
				return true;
			}else {
				return false;
			}
			
		}
		catch (Exception e) {
			 return true;
		}
	}
	
	
	/***********************************************************************
	 *
	 * Uses a regular expression to check if the date is in the correct MM/DD/YYYY format to by used other methods in the program
	 *
	 * @param dateIn is a string of the date that needs to be validated
	 * 
	 * @return true of false whether the year is a valid date in MM/DD/YYYY format
	 *
	 **********************************************************************/
	@Override
	public boolean validateRegexDate(String dateIn) {
		
		
		//Source: http://regexlib.com/DisplayPatterns.aspx?cattabindex=4&categoryId=5&AspxAutoDetectCookieSupport=1
		String DatePattern = "^(((0?[1-9]|1[012])/(0?[1-9]|1\\d|2[0-8])|(0?[13456789]|1[012])/(29|30)|(0?[13578]|1[02])/31)/(19|[2-9]\\d)\\d{2}|0?2/29/((19|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|(([2468][048]|[3579][26])00)))$";
		
		Pattern checkingRegex = Pattern.compile(DatePattern);
		
		Matcher matchRegex = checkingRegex.matcher(dateIn);
		
		if (matchRegex.find( )) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/***********************************************************************
	 *
	 * Calculates the next calendar date
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return nextDate which is the next calendar date
	 *
	 **********************************************************************/
	@Override
	public String nextDate(String curDate) {
		this.setTime(curDate);
		
		c.add(Calendar.DAY_OF_MONTH, 1); 
		String nextDate = sdf.format(c.getTime());  
		
		return nextDate;
	}
	
	/***********************************************************************
	 *
	 * Calculates the previous calendar date
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return nextDate which is the previous calendar date
	 *
	 **********************************************************************/
	@Override
	public String previousDate(String curDate) {
		this.setTime(curDate);
		
		c.add(Calendar.DAY_OF_MONTH, -1); 
		String nextDate = sdf.format(c.getTime());  
		
		return nextDate;
	}
	
	/***********************************************************************
	 *
	 * Calculates the day of the week of the date that is given
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return The day of the week
	 *
	 **********************************************************************/
	@Override
	public String dayOfWeek(String curDate) {
		this.setTime(curDate);
		
		int dayOfWeekNum = c.get(Calendar.DAY_OF_WEEK);
		
		switch (dayOfWeekNum) {
        case 1:  return "Sunday";
        case 2:  return "Monday";
        case 3:  return "Tuesday";
        case 4:  return "Wednesday";
        case 5:  return "Thursday";
        case 6:  return "Friday";
        case 7:  return "Saturday";
        //Will never be hit
        default: return "";
		}
	}
	
	
	/***********************************************************************
	 *
	 * Calculates the number of days till Christmas
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return an int of days till Christmas
	 *
	 **********************************************************************/
	@Override
	public int daysToChrismas(String curDate) {
		this.setTime(curDate);
		
		int curDayOfYear = c.get(Calendar.DAY_OF_YEAR);

		String christmasDate = "12/25/" + curDate.substring(curDate.lastIndexOf("/") + 1);
		
		this.setTime(christmasDate);
		
		int christmasDayOfYear = c.get(Calendar.DAY_OF_YEAR);
		
		return (christmasDayOfYear - curDayOfYear);	
	}
	
	/***********************************************************************
	 *
	 * Calculates the zodiac sign associated to the day of year given
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return returns name sign
	 *
	 **********************************************************************/
	public String zSign(String curDate) {
		
		String curdateMMDD = curDate.substring(0, curDate.lastIndexOf("/"));
		
		int Month = Integer.parseInt(curdateMMDD.substring(0, (curdateMMDD.indexOf("/"))));
		int Day = Integer.parseInt(curdateMMDD.substring(curdateMMDD.lastIndexOf("/")+1));
		
		
		if((Month == 1 & Day >= 20) || (Month == 2 & Day <= 18) ) {
			return "Aquarius";
		}
		else if((Month == 2 & Day >= 19) || (Month == 3 & Day <= 20) ) {
			return "Pisces";
		}
		else if((Month == 3 & Day >= 21) || (Month == 4 & Day <= 19) ) {
			return "Aries";
		}
		else if((Month == 4 & Day >= 20) || (Month == 5 & Day <= 20) ) {
			return "Taurus";
		}
		else if((Month == 5 & Day >= 21) || (Month == 6 & Day <= 20) ) {
			return "Gemini";
		}
		else if((Month == 6 & Day >= 21) || (Month == 7 & Day <= 22) ) {
			return "Cancer";
		}
		else if((Month == 7 & Day >= 23) || (Month == 8 & Day <= 22) ) {
			return "Leo";
		}
		else if((Month == 8 & Day >= 23) || (Month == 9 & Day <= 22) ) {
			return "Virgo";
		}
		else if((Month == 9 & Day >= 23) || (Month == 10 & Day <= 22) ) {
			return "Libra";
		}
		else if((Month == 10 & Day >= 23) || (Month == 11 & Day <= 21) ) {
			return "Scorpio";
		}
		else if((Month == 11 & Day >= 22) || (Month == 12 & Day <= 21) ) {
			return "Sagittarius";
		}
		else if((Month == 12 & Day >= 22) || (Month == 1 & Day <= 19) ) {
			return "Capricorn";
		}
		//Will never be hit
		return "Error";	
	}
}
