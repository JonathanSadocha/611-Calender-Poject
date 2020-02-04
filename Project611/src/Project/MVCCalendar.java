package Project;

/***********************************************************************
*
* Calendar MVC Class
*
* @author Jonathan Sadocha
* @version 1.0
*
**********************************************************************/
public class MVCCalendar {

	/***********************************************************************
	 *
	 * Calculates the zodiac sign associated to the day of year given
	 *
	 * @param curDate is a string of the current date 
	 * 
	 * @return returns name sign
	 *
	 **********************************************************************/
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		CalendarView view = new CalendarView();
		IModel model = new CalendarModel();
		CalendarController controller = new CalendarController(model, view);
		view.setVisible(true);
	}
}
