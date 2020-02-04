package Project;

/***********************************************************************
*
* Calendar Model Interface Class
*
* @author Jonathan Sadocha
* @version 1.0
*
**********************************************************************/
public interface IModel {

	/***********************************************************************
	 *
	 * Gets date of the instance
	 *
	 * @return Date of the instance
	 * 
	 *
	 **********************************************************************/
	String getDate();

	/***********************************************************************
	 *
	 * Sets date that is given to it
	 *
	 * @param Date that is passed in to be set
	 *
	 **********************************************************************/
	void setDate(String date);
	
	/***********************************************************************
	 *
	 * Checks if the year of the date that is passed is greater than 1900
	 *
	 * @param dateIn is a string of the date that needs to be validated for the year
	 * 
	 * @return true of false whether the year is is over 1900 
	 *
	 **********************************************************************/
	boolean validateYear(String dateIn);

	/***********************************************************************
	 *
	 * Uses a regular expression to check if the date is in the correct MM/DD/YYYY format to by used other methods in the program
	 *
	 * @param dateIn is a string of the date that needs to be validated
	 * 
	 * @return true of false whether the year is a valid date in MM/DD/YYYY format
	 *
	 **********************************************************************/
	boolean validateRegexDate(String dateIn);

	/***********************************************************************
	 *
	 * Calculates the next calendar date
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return nextDate which is the next calendar date
	 *
	 **********************************************************************/
	String nextDate(String curDate);

	/***********************************************************************
	 *
	 * Calculates the previous calendar date
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return nextDate which is the previous calendar date
	 *
	 **********************************************************************/
	String previousDate(String curDate);

	/***********************************************************************
	 *
	 * Calculates the day of the week of the date that is given
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return The day of the week
	 *
	 **********************************************************************/
	String dayOfWeek(String curDate);

	/***********************************************************************
	 *
	 * Calculates the number of days till Christmas
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return an int of days till Christmas
	 *
	 **********************************************************************/
	int daysToChrismas(String curDate);

	/***********************************************************************
	 *
	 * Calculates the zodiac sign associated to the day of year given
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return returns name sign
	 *
	 **********************************************************************/
	String zSign(String curDate);

}