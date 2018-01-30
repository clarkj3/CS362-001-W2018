package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	 public void test01()  throws Throwable  {
	int day = 15;
	int month = 20;
	int year = 2018;
	boolean valid = true;

	CalDay calDay = new CalDay ( day,
		month ,
		year ,
		year );
	assertTrue(CalDay.getValid())	
	assertEquals(15, CalDay.getDay());
	assertEquals(20, CalDay.getMonth());
	assertEquals(2018, CalDay.getYear())
	
	 }
	 @Test
	  public void test02()  throws Throwable  {
	int day = 0;
	int month = 5;
	int year = 2018;
	boolean valid = false;

	CalDay calDay = new CalDay ( day,
		month ,
		year ,
		valid );
	assertTrue(CalDay.getValid())
	assertEquals(0, CalDay.getDay());
	assertEquals(5, CalDay.getMonth());
	assertEquals(2018, CalDay.getYear())


	 }
//add more unit tests as you needed	
}
