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
		CalDay calDay = new CalDay();
		int d=calDay.day;
		boolean v=calDay.valid;
		int m=calDay.month;
		int y=calDay.year;
		boolean test=calDay.isValid();
		assertEquals(false,test);
		int startHour=5;
		int startMinute=30;
		int startDay=0;
		int startMonth=4;
		int startYear=2017;
		String title="new appt";
		String description="new";	
		Appt appts = new Appt(startHour ,
			startMinute ,
			startDay ,
			startMonth ,
			startYear ,
			title ,
			description);
	//assertions
	CalendarMain calM = new CalendarMain();
	assertFalse(calDay.isValid());
	assertEquals(null,calDay.iterator());
	assertFalse(appts.getValid());
	calDay.addAppt(appts);
	//assertEquals(1,calDay.getSizeAppts());
	//calDay.addAppt(appts);
	//assertEquals(3,calDay.getSizeAppts());
	//calDay.setDay(1);
	//assertTrue(calDay.getDay()== 1);
	//assertEquals(3,cal.getDay());
	//assertEquals(0,calDay.getSizeAppts());
	//assertEquals(appts,calDay.getAppts());
	 }

	@Test
	public void test02()  throws Throwable  {
		int startHour=5;
		int startMinute=30;
		int startDay=15;
		int startMonth=4;
		int startYear=2017;
		String title="new appt";
		String description="new";
		GregorianCalendar cal = new GregorianCalendar(2018, 11, 5); 
		CalDay calDay=new CalDay(cal);
		//LinkedList<Appt> apptList = new LinkedList<Appt>();
		Appt appts = new Appt(startHour ,
			startMinute ,
			startDay ,
			startMonth ,
			startYear ,
			title ,
			description);
//		assertTrue(appts.getValid());
		calDay.addAppt(appts);
		assertTrue(appts.getValid());
		//int result= calDay.getSizeAppts();
		//System.out.println(result);
	assertTrue(calDay.isValid());
	//assertEquals((calDay.getAppts().iterator()),iterator());
	assertEquals(2018,calDay.getYear());
	assertEquals(11,calDay.getMonth());
	assertEquals(5,calDay.getDay());
	//assertEquals(null,calDay.iterator());
	//assertEquals(appts.size(),calDay.getSizeAppts());
	//assertEquals(appts,calDay.getAppts());
	}

	@Test
	public void test03()  throws Throwable  {
		int startHour=5;
		int startMinute=30;
		int startDay=15;
		int startMonth=4;
		int startYear=2017;
		String title="new appt";
		String description="new";
		GregorianCalendar cal = new GregorianCalendar(2018, 11, 5);
		CalDay calDay = new CalDay(cal);
		Appt appts = new Appt(startHour ,
			startMinute ,
			startDay ,
			startMonth ,
			startYear ,
			title ,
			description);
		calDay.addAppt(appts);
		assertEquals(1,calDay.getSizeAppts());
		//assertEquals(null,calDay.toString());
		//System.out.println("import");
		//System.out.println(calDay.iterator());
		//assertEquals("java.util.LinkedList$ListItr@3972a855",calDay.iterator());
		String test = calDay.toString();
		assertEquals(test,calDay.toString());
		calDay.iterator();
		calDay.toString();
		CalendarMain calM = new CalendarMain();
	}
	
//add more unit tests as you needed	
}
