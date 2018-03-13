package calendar;
/**
 * This class provides a basic set of test cases for the
 * CalDay class.
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
		Appt appts = new Appt(startHour ,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title ,
                        description);
		calDay.addAppt(appts);
                assertTrue(appts.getValid());
	assertTrue(calDay.isValid());
	assertEquals(2018,calDay.getYear());
        assertEquals(11,calDay.getMonth());
        assertEquals(5,calDay.getDay());
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
		assertEquals(0,calDay.getSizeAppts());
                calDay.addAppt(appts);
		//this line proves bug in calDayaddAppt(appt);
                assertEquals(1,calDay.getSizeAppts());
		String test = calDay.toString();
                assertEquals(test,calDay.toString());
                calDay.iterator();
                calDay.toString();
                CalendarMain calM = new CalendarMain();
        }
}
