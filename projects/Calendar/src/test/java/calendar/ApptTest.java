package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		int startHour=21;
                int startMinute=30;
		//this found a bug;
                int startDay=17;
                int startMonth=01;
                int startYear=2018;
                String title="Birthday Party";
                String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data      
		Appt appt = new Appt(startHour,
                          startMinute ,
                          startDay ,
                          startMonth ,
                          startYear ,
                          title,
                         description);
		//assertions
		assertTrue(appt.getValid());
                assertEquals(21, appt.getStartHour());
                assertEquals(30, appt.getStartMinute());
		//this found a bug
                assertEquals(17, appt.getStartDay());
                assertEquals(01, appt.getStartMonth());
                assertEquals(2018, appt.getStartYear());
                assertEquals("Birthday Party", appt.getTitle());
                assertEquals("This is my birthday party.", appt.getDescription());       
	 }

	 @Test
	  public void test02()  throws Throwable  {
		int startHour=23;
                int startMinute=00;     //60 broke
		int startDay=1;         //0 broke
		int startMonth=12;      //13 broke
		int startYear=2018;
                String title="";
                String description="";
                //Construct a new Appointment object with the initial data
                Appt appt = new Appt(startHour,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title,
                        description);
        // assertions
        	assertTrue(appt.getValid());
                assertEquals(23, appt.getStartHour());
                assertFalse(startHour>24);
                assertTrue(startHour<24);
                assertFalse(startHour<0);
                assertTrue(startHour>0);
                assertEquals(00, appt.getStartMinute());
                assertEquals(1, appt.getStartDay());
                assertEquals(12, appt.getStartMonth());
                assertEquals(2018, appt.getStartYear());
                assertEquals("", appt.getTitle());
                assertEquals("",appt.getDescription());
        }

	@Test
	public void test03()  throws Throwable  {
                int startHour=0;
                int startMinute=45;
                int startDay=01;
                int startMonth=2;
                int startYear=2017;
                String title="Test3 ";
                String description="This is the third test";
                //Construct a new Appointment object with the initial data
                Appt appt = new Appt(startHour,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title,
                        description);
         // assertions
         	assertTrue(appt.getValid());
                assertEquals(0, appt.getStartHour());
                assertEquals(45, appt.getStartMinute());
                assertEquals(01, appt.getStartDay());
                assertEquals(2, appt.getStartMonth());
                assertEquals(2017, appt.getStartYear());
                assertEquals("Test3 ", appt.getTitle());
                assertEquals("This is the third test", appt.getDescription());
                appt.setStartHour(0);
                appt.setStartMinute(15);
                appt.setStartDay(0);
                appt.setStartMonth(4);
                appt.setStartYear(2019);
                appt.setTitle(null);
                appt.setDescription(null);
		//appt,isValid();
		//      assertEquals(29,CalendarUtil.NumDaysInMonth(2020,1));
	}

	@Test
	public void test04()  throws Throwable  {
                int startHour=0;
                int startMinute=59;
                int startDay=31;
                int startMonth=05;
                int startYear=2000;
                String title="Test4";
                String description="This is the third test";
                //Construct a new Appointment object with the initial data
                Appt appt = new Appt(startHour,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title,
                        description);
        // assertions 
        	assertTrue(appt.getValid());
                assertEquals(0, appt.getStartHour());
                assertEquals(59, appt.getStartMinute());
                assertEquals(31, appt.getStartDay());
                assertEquals(05, appt.getStartMonth());
                assertEquals(2000, appt.getStartYear());
                assertEquals("Test4" , appt.getTitle());
                assertEquals("This is the third test", appt.getDescription());
                appt.setStartHour(2);
                assertTrue(appt.getStartHour()==2);
                appt.setStartMinute(15);
                assertTrue(appt.getStartMinute()==15);
                appt.setStartDay(10);
                assertTrue(appt.getStartDay() == 10);
                appt.setStartMonth(11);
                assertTrue(appt.getStartMonth() == 11);
                appt.setStartYear(2019);
                assertTrue(appt.getStartYear() == 2019);
        }

	@Test
	public void test05()  throws Throwable  {
                int startHour=23;
                int startMinute=59;
                int startDay=31;
                int startMonth=01;
                int startYear=2017;
                String title="Test4";
                String description="This is the third test";
                Appt appt = new Appt(startHour,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title,
                        description);
                assertFalse(appt.isRecurring());
                assertEquals(2,appt.getRecurBy());              //tesed setRecureBy
		assertEquals(0,appt.getRecurIncrement());
                assertEquals(0,appt.getRecurNumber());
                assertEquals(false,CalendarUtil.IsLeapYear(2017));
        }

	@Test
	public void test06()  throws Throwable  {
                int startHour=23;
                int startMinute=15;
                int startDay=20;
                int startMonth=02;
                int startYear=2020;
                String title="Test4";
                String description="This is the third test";
                int [] recurDays = new int [1];
                int recurBy=1;
                int recurIncrement=3;
                int recurNumber=-1;
                Appt appt = new Appt(startHour ,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title ,
                        description );
                assertTrue(appt.getValid());
                //this.represntationApp();
                appt.setRecurrence(recurDays,recurBy,recurIncrement,recurNumber);
                assertEquals(3,appt.getRecurIncrement());
                assertEquals(recurDays,appt.getRecurDays());
                assertEquals(recurNumber,appt.getRecurNumber());
                assertEquals(appt.getStartHour(),startHour);
                assertEquals(31,CalendarUtil.NumDaysInMonth(2020,2));
                assertEquals(true,CalendarUtil.IsLeapYear(2020));
                CalendarMain calM = new CalendarMain();
                CalendarUtil calU = new CalendarUtil();
                }

	@Test
        public void test07()  throws Throwable  {
                int startHour=24;
                int startMinute=60;
                int startDay=0;
                int startMonth=01;
                int startYear=2020;
                String title="Birthday Party";
                String description="This is my birthday party.";
                int [] recurDays = new int [0];
                int recurBy=1;
                int recurIncrement=3;
                int recurNumber=0;
                //Construct a new Appointment object with the initial data
                Appt appt = new Appt(startHour,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title,
                        description);
                assertFalse(appt.getValid());
                appt.setRecurrence(recurDays,recurBy,recurIncrement,recurNumber);
                assertFalse(startHour<24);
                assertEquals(24,appt.getStartHour());
                assertFalse(startMinute<60);
                assertEquals(60,appt.getStartMinute());
                assertFalse(startDay>0);
                assertEquals(0,appt.getStartDay());
        }

	@Test
        public void test08()  throws Throwable  {
                int startHour=12;
                int startMinute=15;
                int startDay=10;
                int startMonth=01;
                int startYear=2000;
                String title="Birthday Party";
                String description="This is my birthday party.";
                Appt appt = new Appt(startHour,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title ,
                        description);
                assertTrue(appt.getValid());
                assertEquals(true,CalendarUtil.IsLeapYear(2000));
                appt.toString();
        }

	@Test
        public void test09()  throws Throwable  {
                int startHour=12;
                int startMinute=15;
                int startDay=0;
                int startMonth=02;
                int startYear=5000;
                String title="Birthday Party";
                String description="This is my birthday party.";
                Appt appt = new Appt(startHour,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title ,
                        description);
                assertFalse(appt.getValid());
                assertEquals(false,CalendarUtil.IsLeapYear(5000));
                appt.toString();
        }

	@Test
        public void test10()  throws Throwable  {
                int startHour=12;
                int startMinute=60;
                int startDay=10;
                int startMonth=01;
                int startYear=2027;
                String title="Birthday Party";
                String description="This is my birthday party.";
                Appt appt = new Appt(startHour,
                        startMinute ,
                        startDay ,
                        startMonth ,
                        startYear ,
                        title ,
                        description);
                assertFalse(appt.getValid());
		//this proves there is a bug,
		//the following line should result in an error but does not
		//the commented out results and an error but shouldn't
		//assertEquals(true,CalendarUtil.IsLeapYear(2027));
		assertEquals(false,CalendarUtil.IsLeapYear(2027));
                assertEquals(29,CalendarUtil.NumDaysInMonth(2020,01));
                CalendarMain calM = new CalendarMain();
        }
} 
