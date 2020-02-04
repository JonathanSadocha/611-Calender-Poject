/***********************************************************************
 *
 * Calendar View Test Class
 *
 * @author Jonathan Sadocha
 * @version 1.0
 *
 **********************************************************************/

package Project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalendarViewTest {

	CalendarView view = new CalendarView();
	
	@Test
	void testCalendarView() {
		CalendarView view1 = new CalendarView();
	}

	@Test
	void testSettxtDateTextOut() {
		view.settxtDateTextOut("12/12/2000");
	}

	@Test
	void testSettxtNextDateTextOut() {
		view.settxtNextDateTextOut("12/12/2000");
	}

	@Test
	void testSettxtPrevoiusDateTextOut() {
		view.settxtPrevoiusDateTextOut("12/12/2000");
	}

	@Test
	void testSettxtDayOfTheWeekOut() {
		view.settxtDayOfTheWeekOut("Tuesday");
	}

	@Test
	void testSettxtShoppingDays() {
		view.settxtShoppingDays(13);
	}

	@Test
	void testSettxtZodiacSignOut() {
		view.settxtZodiacSignOut("Sagittarius");
	}

	@Test
	void testDisplayErrorMessage() {
		view.displayErrorMessage("Error?");
	}
	
	@Test
	void testDisplayImage() {
		view.displayImage("Sagittarius");
	}
	
	@Test
	void testClear() {
		view.clear();
	}

}
