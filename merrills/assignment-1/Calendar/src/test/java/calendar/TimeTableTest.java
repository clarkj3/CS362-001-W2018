package calendar;
/**
 * This class provides a basic set of test cases for the
 * TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
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
	LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        CalendarMain calM = new CalendarMain();
	}

	@Test
        public void test02()  throws Throwable  {

        CalDay calDay = new CalDay();
        GregorianCalendar cal = new GregorianCalendar(2018, 11, 5);
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        CalendarMain calM = new CalendarMain();
        }
}
