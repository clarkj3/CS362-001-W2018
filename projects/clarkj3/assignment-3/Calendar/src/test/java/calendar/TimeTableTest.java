package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	

//private Appt app1;
//private Appt app2;

//	protected void setUp(){
//		int hour = 10;
//		String description = "testing";
//		app1 = new Appt(hour, description);
//		hour =13;
//		description = "more testing";
//		app2 = new Appt(hour, description);
//	}
//

	@Test
	public void test01()  throws Throwable  {
	int startHour=23;
        int startMinute=59;
        int startDay=31;
        int startMonth=05;
        int startYear=2017;
        String title="Test4";
        String description="This is the third test";
	Appt appt = new Appt(startHour,
		startMinute ,
		startDay ,
		startMonth ,
		startYear ,
		title ,
		description);	
	TimeTable timeTable = new TimeTable();	
	Calendar c = Calendar.getInstance();
	GregorianCalendar day = new GregorianCalendar(2018, 11, 5);
	//GregorianCalendar lastDay = new GregorianCalendar(2018, 11, 10);
	LinkedList<CalDay> calDays = new LinkedList<CalDay>();
	CalendarMain calM = new CalendarMain();
	//TimeTable.getNextApptOccurrence(appt, day);
	//c = new LinkedList<CalDay>();
	//Date firstDate = new Date(c.getTimeInMillis());
	//t.addCalendarDay(firstDate);

	//timeTable.addAppt(appt);
//	timeTable.addAppt(1, app1);	 
	}
	@Test
	public void test02()  throws Throwable  {
	
	CalDay calDay = new CalDay();
 	GregorianCalendar cal = new GregorianCalendar(2018, 11, 5);
	LinkedList<CalDay> calDays = new LinkedList<CalDay>();
	CalendarMain calM = new CalendarMain();
	}
//add more unit tests as you needed
}
