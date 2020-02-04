package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***********************************************************************
*
* Calendar Controller Class
*
* @author Jonathan Sadocha
* @version 1.0
*
**********************************************************************/
public class CalendarController {

	//Initiate Model
	private IModel model;
	//Initiate View
	private CalendarView view;

	
	/***********************************************************************
	 *
	 * Constructor for Calendar controller
	 *
	 * @param model in
	 * @param view in
	 *
	 **********************************************************************/
	public CalendarController(IModel model, CalendarView view){
		this.model = model;
		this.view = view;
		
		this.view.addCalenderListener(new CalendarListener());
		this.view.addClearListener(new ClearListener());
	}

	/***********************************************************************
	 *
	 * Controller for the clear button action listener
	 *
	 **********************************************************************/
	class ClearListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {	
			view.clear();
		}
	}
	
	/***********************************************************************
	 *
	 * Controller for the Enter calendar button action listener
	 *
	 **********************************************************************/
	class CalendarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String Date = "";
			
			try {
				Date = view.getDate();
				model.setDate(Date);
				Date = model.getDate();
			}
			catch(Exception ex) {
				view.displayErrorMessage("Enter a date");
			}
			
			if(model.getDate().isEmpty()) {
				view.displayErrorMessage("Enter a date");
			}else if( !model.validateYear(model.getDate())) {
				view.displayErrorMessage("The year has to be greater than 1900.");
			}else if( !model.validateRegexDate(model.getDate())) {
				view.displayErrorMessage("Date should be in MM/DD/YYYY fromate.");
			}else {
				view.settxtDateTextOut(model.getDate());
				view.settxtNextDateTextOut(model.nextDate(model.getDate()));
				view.settxtPrevoiusDateTextOut(model.previousDate(model.getDate()));
				view.settxtDayOfTheWeekOut(model.dayOfWeek(model.getDate()));
				view.settxtShoppingDays(model.daysToChrismas(model.getDate()));
				String sign = model.zSign(model.getDate());
				view.settxtZodiacSignOut(sign);
				view.displayImage(sign);
			}
		}	
	}
}
