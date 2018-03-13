package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;

/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
        private static final long TestTimeout = 60 * 500 * 1; //Timeout at 30 seconds 

	private static final int NUM_TESTS=100;

        /**
 	* Return a randomly selected method to be tests !.
 	*/
	public static String RandomSelectMethod(Random random){
		// The list of the of methods to be tested in the Appt class
		String[] methodArray = new String[] {"compareTo","toString","getRecurIncrement","isRecurring","getRecurNumber","getRecurBy","getRecurDays","setTitle","setRecurrence","setDescription", "setStartHour","setStartMinute","setStartDay", "setStartMonth", "setStartYear", "getStartHour","getStartMinute","getStartDay","getStartMonth","getStartYear","getTitle","getDescription"};

                // get a random number between 0 (inclusive) and  methodArray.length (exclusive)
                int n = random.nextInt(methodArray.length);

                return methodArray[n] ; // return the method name 
        }

	/**
 	* Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
 	*/
	public static int RandomSelectRecur(Random random){
		// The list of the of setting appointments to recur Weekly,Monthly, or Yearly
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};

                // get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
                int n = random.nextInt(RecurArray.length);

                return RecurArray[n] ; // return the value of the  appointments to recur 
	}

	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random){

                // The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER
                int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};

                // get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
                int n = random.nextInt(RecurArray.length);

                return RecurArray[n] ; // return appointments to recur forever or Never recur 
	}

	/**
	 *  Generate Random Tests that tests Appt Class.
	 */
/*	@Test
        public void radnomtest()  throws Throwable  {

                long startTime = Calendar.getInstance().getTimeInMillis();
                long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


                System.out.println("Start testing...");

                try{
                        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                                long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

                                int startHour=ValuesGenerator.RandInt(random);
                                int startMinute=ValuesGenerator.RandInt(random);
                                int startDay=ValuesGenerator.RandInt(random);
                                int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                                int startYear=ValuesGenerator.RandInt(random);
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
                        if(!appt.getValid())continue;
                        for (int i = 0; i < NUM_TESTS; i++) {
                                String methodName = ApptRandomTest.RandomSelectMethod(random);
                                if (methodName.equals("setTitle")){
                                        String newTitle=(String) ValuesGenerator.getString(random);
                                        appt.setTitle(newTitle);                                    
                                }
				else if (methodName.equals("setRecurrence")){
                                        int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
                                        int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
                                        int recur=ApptRandomTest.RandomSelectRecur(random);
                                        int recurIncrement = ValuesGenerator.RandInt(random);
                                        int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
                                        appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
                                }
                                else if (methodName.equals("setDescription")){
                                        String newDescription = ValuesGenerator.getString(random);
                                        appt.setDescription(newDescription);
                                }
				else if(methodName.equals("setStartHour")){
                                        int newStartHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
                                        appt.setStartHour(newStartHour);
                                }
                                else if(methodName.equals("setStartMinute")){
                                        int newStartMinute=ValuesGenerator.getRandomIntBetween(random,-1,60);
                                        appt.setStartMinute(newStartMinute);
                                }
                                else if(methodName.equals("setStartDay")){
                                        int newStartDay = ValuesGenerator.getRandomIntBetween(random, 0,31);
                                        appt.setStartDay(newStartDay);
                                }
				else if(methodName.equals("setStartMonth")){
                                        int newStartMonth = ValuesGenerator.getRandomIntBetween (random, 1,12);
                                        appt.setStartMonth(newStartMonth);
                                }
				else if(methodName.equals("setStartYear")){
                                        int newStartYear = ValuesGenerator.getRandomIntBetween (random, 0,2020);
                                        appt.setStartYear(newStartYear);
                                }
                                else if (methodName.equals("getStartHour")){
                                        int hour = appt.getStartHour();
                                }
                                else if (methodName.equals("getStartMinute")){
                                        int min = appt.getStartMinute();
                                }
                                else if (methodName.equals("getStartDay")){
                                        int day = appt.getStartDay();
                                }
                                else if (methodName.equals("getStartMonth")){
                                        int month = appt.getStartMonth();
                                }
                                else if (methodName.equals("getStartYear")){
                                        int year = appt.getStartYear();
                                }
				else if (methodName.equals("getTitle")){
                                        String theTitle = appt.getTitle();
                                }
                                else if (methodName.equals("getDescription")){
                                        String descrip = appt.getDescription();
                                }
                                else if (methodName.equals("getRecurNumber")){
                                        int recNum = appt.getRecurNumber();
                                }
                                else if (methodName.equals("getRecurBy")){
                                        int recBy = appt.getRecurBy();
                                }
                                else if (methodName.equals("getRecurDays")){
                                        int [] recDays = appt.getRecurDays();
                                }
                                else if (methodName.equals("isRecurring")){
                                        boolean rec = appt.isRecurring();
                                }
                                else if (methodName.equals("getRecurIncrement")){
                                        int recInc = appt.getRecurIncrement();
                                }
                                else if (methodName.equals("toString")){
                                        String str = appt.toString();
                                }

                        }
			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                        if((iteration%10000)==0 && iteration!=0 )
                                System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

                        }
                }catch(NullPointerException e){

                }

                System.out.println("Done testing...");
        }
*/
/*
	@Test
	public void radnomtest2()  throws Throwable  {

                long startTime = Calendar.getInstance().getTimeInMillis();
                long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


                System.out.println("Start testing...");

                try{
                        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                                long randomseed =System.currentTimeMillis();
                                Random random = new Random(randomseed);

                                int startHour=ValuesGenerator.RandInt(random);
                                int startMinute=ValuesGenerator.RandInt(random);
                                int startDay=ValuesGenerator.RandInt(random);;
                                int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                                int startYear=ValuesGenerator.RandInt(random);
                                String title="Birthday Party";
                                String description="This is my birthday party.";
                                Appt appt = new Appt(startHour,
                                        startMinute ,
                                        startDay ,
                                        startMonth ,
                                        startYear ,
                                        title,
                                        description);
                                if(!appt.getValid())continue;
				for (int i = 0; i < NUM_TESTS; i++) {
                                        String methodName = ApptRandomTest.RandomSelectMethod(random);
                                        if (methodName.equals("setTitle")){
                                                String newTitle=(String) ValuesGenerator.getString(random);
                                                appt.setTitle(newTitle);
                                        }
                                        else if (methodName.equals("setRecurrence")){
                                                int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
                                                int[] recurDays=null;
                                                int recur=ApptRandomTest.RandomSelectRecur(random);
                                                int recurIncrement = ValuesGenerator.RandInt(random);
                                                int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
                                                appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
                                        }
					else if (methodName.equals("compareTo")){
                                                int newStartH=ValuesGenerator.RandInt(random);
                                                int newstartM=ValuesGenerator.RandInt(random);
                                                int newstartD=ValuesGenerator.RandInt(random);
                                                int newstartMth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                                                int newstartY=ValuesGenerator.RandInt(random);
                                                String newtitle = ValuesGenerator.getString(random);
                                                String newDescription = ValuesGenerator.getString(random);
                                                Appt newAppt = new Appt(newStartH,newstartM,newstartD,newstartMth,newstartY,newtitle,newDescription);
                                                appt.compareTo(newAppt);
                                        }
					else if (methodName.equals("setDescription")){
                                                String newDescription = ValuesGenerator.getString(random);
                                                appt.setDescription(newDescription);
                                        }
                                        else if(methodName.equals("setStartHour")){
                                                int newStartHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
                                                appt.setStartHour(newStartHour);
                                        }
                                        else if(methodName.equals("setStartMinute")){
                                                int newStartMinute=ValuesGenerator.getRandomIntBetween(random,-1,60);
                                                appt.setStartMinute(newStartMinute);
                                        }
                                        else if(methodName.equals("setStartDay")){
                                                int newStartDay = ValuesGenerator.getRandomIntBetween(random, 0,31);
                                                appt.setStartDay(newStartDay);
                                        }
                                        else if(methodName.equals("setStartMonth")){
                                                int newStartMonth = ValuesGenerator.getRandomIntBetween (random, 0,12);
                                                appt.setStartMonth(newStartMonth);
                                        }
					else if(methodName.equals("setStartYear")){
                                                int newStartYear = ValuesGenerator.getRandomIntBetween (random, 0,2020);
                                                appt.setStartYear(newStartYear);
                                        }
                                }
                                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                                if((iteration%10000)==0 && iteration!=0 )
                                        System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
                                }
                        }catch(NullPointerException e){
                        }

                System.out.println("Done testing...");
        }
*/
/*	@Test
	public void radnomtest3()  throws Throwable  {

                long startTime = Calendar.getInstance().getTimeInMillis();
                long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


                System.out.println("Start testing...");

                try{
                        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                                long randomseed =System.currentTimeMillis();
                                Random random = new Random(randomseed);

                                int startHour=ValuesGenerator.RandInt(random);
                                int startMinute=ValuesGenerator.RandInt(random);
                                int startDay=ValuesGenerator.RandInt(random);;
                                int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                                int startYear=ValuesGenerator.RandInt(random);
                                String title="Birthday Party";
                                String description="This is my birthday party.";
                                Appt appt = new Appt(startHour,
                                        startMinute ,
                                        startDay ,
                                        startMonth ,
                                        startYear ,
                                        title,
                                        description);
                                if(!appt.getValid())continue;
				CalendarMain main = new CalendarMain();
                                for (int i = 0; i < NUM_TESTS; i++) {
                                        String methodName = ApptRandomTest.RandomSelectMethod(random);
                                        if (methodName.equals("setTitle")){
                                                String newTitle=(String) ValuesGenerator.getString(random);
                                                appt.setTitle(newTitle);
                                        }
                                        else if (methodName.equals("setRecurrence")){
                                                int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 100);
                                                int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
                                                int recur=ApptRandomTest.RandomSelectRecur(random);
                                                int recurIncrement = ValuesGenerator.RandInt(random);
                                                int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
                                                appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
                                        }
					else if (methodName.equals("setDescription")){
                                                String newDescription = ValuesGenerator.getString(random);
                                                appt.setDescription(newDescription);
                                        }
                                        else if(methodName.equals("setStartHour")){
                                                int newStartHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
                                                appt.setStartHour(newStartHour);
                                        }
                                        else if(methodName.equals("setStartMinute")){
                                                int newStartMinute=ValuesGenerator.getRandomIntBetween(random,-1,60);
                                                appt.setStartMinute(newStartMinute);
                                        }
					else if(methodName.equals("setStartDay")){
                                                int newStartDay = ValuesGenerator.getRandomIntBetween(random, 0,31);
                                                appt.setStartDay(newStartDay);
                                        }
                                        else if(methodName.equals("setStartMonth")){
                                                int newStartMonth = ValuesGenerator.getRandomIntBetween (random, 1,13);
                                                appt.setStartMonth(newStartMonth);
                                        }
                                        else if(methodName.equals("setStartYear")){
                                                int newStartYear = ValuesGenerator.getRandomIntBetween (random, 0,2020);
                                                appt.setStartYear(newStartYear);
                                        }
                                }
                                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                                if((iteration%10000)==0 && iteration!=0 )
                                        System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
                                }
                        }catch(NullPointerException e){
                        }

                System.out.println("Done testing...");
        }*/
}   
