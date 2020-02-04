/***********************************************************************
 *
 * Calendar Model Test Class
 *
 * @author Jonathan Sadocha
 * @version 1.0
 *
 **********************************************************************/
package Project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalendarModelTest {

	CalendarModel model = new CalendarModel();
	
	@Test
	void testSetDate() {
		model.setDate("12/12/1900");
	}
	
	@Test
	void testGetDate() {
		model.setDate("12/12/1900");
		assertEquals("12/12/1900",model.getDate());
	}
	@Test
	void testValidateYear() {
		
		boolean value = true;
		assertEquals(value,model.validateYear("1/1/5555"));
		assertEquals(value,model.validateYear("1/1/1901"));
		assertEquals(value,model.validateYear("1/1/1900"));
		
		value = false;
		assertEquals(value,model.validateYear("1/1/20"));
		assertEquals(value,model.validateYear("1/1/1899"));
	}
	
	@Test
	void testValidateRegexDate1() {
		boolean value = true;
		assertEquals(value,model.validateRegexDate("12/28/2000"));
		assertEquals(value,model.validateRegexDate("12/31/2340"));
		assertEquals(value,model.validateRegexDate("1/1/1900"));
		assertEquals(value,model.validateRegexDate("2/28/2019"));
		assertEquals(value,model.validateRegexDate("2/29/2020"));
		
		value = false;
		assertEquals(value,model.validateRegexDate("00/12/2000"));
		assertEquals(value,model.validateRegexDate("01/32/2000"));
		assertEquals(value,model.validateRegexDate("13/30/2000"));
		assertEquals(value,model.validateRegexDate("11/31/2000"));
		assertEquals(value,model.validateRegexDate("011/12/2000"));
		assertEquals(value,model.validateRegexDate("12/2000"));
		assertEquals(value,model.validateRegexDate("01/1/2"));
		assertEquals(value,model.validateRegexDate("2/29/2019"));
		assertEquals(value,model.validateRegexDate("asdbahvbv"));
		assertEquals(value,model.validateRegexDate("//"));
		assertEquals(value,model.validateRegexDate("745123451"));
	}

	@Test
	void testNextDate() {
		assertEquals("12/29/2000",model.nextDate("12/28/2000"));
		assertEquals("01/01/2001",model.nextDate("12/31/2000"));
		assertEquals("11/01/2000",model.nextDate("10/31/2000"));
		assertEquals("02/29/2000",model.nextDate("02/28/2000"));
		assertEquals("03/01/2001",model.nextDate("02/28/2001"));
	}

	@Test
	void testPreviousDate() {
		assertEquals("12/27/2000",model.previousDate("12/28/2000"));
		assertEquals("12/31/2000",model.previousDate("01/01/2001"));
		assertEquals("10/31/2000",model.previousDate("11/01/2000"));
		assertEquals("02/28/2000",model.previousDate("02/29/2000"));
		assertEquals("02/29/2000",model.previousDate("03/01/2000"));
		assertEquals("02/28/2001",model.previousDate("03/01/2001"));
	}

	@Test
	void testDayOfWeek() {
		assertEquals("Sunday",model.dayOfWeek("12/01/2019"));
		assertEquals("Monday",model.dayOfWeek("12/02/2019"));
		assertEquals("Tuesday",model.dayOfWeek("12/03/2019"));
		assertEquals("Wednesday",model.dayOfWeek("12/04/2019"));
		assertEquals("Thursday",model.dayOfWeek("12/05/2019"));
		assertEquals("Friday",model.dayOfWeek("12/06/2019"));
		assertEquals("Saturday",model.dayOfWeek("12/07/2019"));
	}

	@Test
	void testDaysToChrismas() {
		assertEquals(24,model.daysToChrismas("12/01/2019"));
	}

	@Test
	void testZSign() {
		assertEquals("Aquarius",model.zSign("1/20/2019"));
		assertEquals("Aquarius",model.zSign("1/21/2019"));
		assertEquals("Aquarius",model.zSign("2/17/2019"));
		assertEquals("Aquarius",model.zSign("2/18/2019"));
		
		assertEquals("Pisces",model.zSign("2/19/2019"));
		assertEquals("Pisces",model.zSign("2/20/2019"));
		assertEquals("Pisces",model.zSign("3/19/2019"));
		assertEquals("Pisces",model.zSign("3/20/2019"));
		
		assertEquals("Aries",model.zSign("3/21/2019"));
		assertEquals("Aries",model.zSign("3/22/2019"));
		assertEquals("Aries",model.zSign("4/18/2019"));
		assertEquals("Aries",model.zSign("4/19/2019"));
		
		assertEquals("Taurus",model.zSign("4/20/2019"));
		assertEquals("Taurus",model.zSign("4/21/2019"));
		assertEquals("Taurus",model.zSign("5/19/2019"));
		assertEquals("Taurus",model.zSign("5/20/2019"));
		
		assertEquals("Gemini",model.zSign("5/21/2019"));
		assertEquals("Gemini",model.zSign("5/22/2019"));
		assertEquals("Gemini",model.zSign("6/19/2019"));
		assertEquals("Gemini",model.zSign("6/20/2019"));
		
		assertEquals("Cancer",model.zSign("6/21/2019"));
		assertEquals("Cancer",model.zSign("6/22/2019"));
		assertEquals("Cancer",model.zSign("7/21/2019"));
		assertEquals("Cancer",model.zSign("7/22/2019"));
		
		assertEquals("Leo",model.zSign("7/23/2019"));
		assertEquals("Leo",model.zSign("7/24/2019"));
		assertEquals("Leo",model.zSign("8/21/2019"));
		assertEquals("Leo",model.zSign("8/22/2019"));
		
		assertEquals("Virgo",model.zSign("8/23/2019"));
		assertEquals("Virgo",model.zSign("8/24/2019"));
		assertEquals("Virgo",model.zSign("9/11/2019"));
		assertEquals("Virgo",model.zSign("9/22/2019"));
		
		assertEquals("Libra",model.zSign("9/23/2019"));
		assertEquals("Libra",model.zSign("9/24/2019"));
		assertEquals("Libra",model.zSign("10/21/2019"));
		assertEquals("Libra",model.zSign("10/22/2019"));
		
		assertEquals("Scorpio",model.zSign("10/23/2019"));
		assertEquals("Scorpio",model.zSign("10/24/2019"));
		assertEquals("Scorpio",model.zSign("11/20/2019"));
		assertEquals("Scorpio",model.zSign("11/21/2019"));
		
		assertEquals("Sagittarius",model.zSign("11/22/2019"));
		assertEquals("Sagittarius",model.zSign("11/23/2019"));
		assertEquals("Sagittarius",model.zSign("12/20/2019"));
		assertEquals("Sagittarius",model.zSign("12/21/2019"));
		
		assertEquals("Capricorn",model.zSign("12/22/2019"));
		assertEquals("Capricorn",model.zSign("12/23/2019"));
		assertEquals("Capricorn",model.zSign("1/18/2019"));
		assertEquals("Capricorn",model.zSign("1/19/2019"));
		
	}

}
