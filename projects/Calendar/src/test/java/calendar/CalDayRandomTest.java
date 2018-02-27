package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import java.util.Random;

import java.util.HashSet;

import org.junit.Test;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1;
	private static final int NUM_TESTS=100;
	
	/*
 	* Return a randomly selected method to be tests !.
	*/
	public static String RandomSelectMethod(Random random){
		// The list of the of methods to be tested in the Appt class
		 String[] methodArray = new String[] {"CalDay","addAppt", "isValid", "iterator","getAppts","getSizeAppts","getDay","getMonth","getYear","toString"};

		// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
		int n = random.nextInt(methodArray.length);
  		
		return methodArray[n] ; // return the method name
	}

	/*
 	* Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
 	*/
	public static int RandomSelectRecur(Random random){

		// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};

		// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		int n = random.nextInt(RecurArray.length);

		return RecurArray[n] ; // return the value of the  appointments to recur
	}

	/*
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
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
	
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);
				int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int day = ValuesGenerator.getRandomIntBetween(random, 1, 31);
				int year =ValuesGenerator.RandInt(random);
				GregorianCalendar cal = new GregorianCalendar(year, month, day);
				CalDay c = new CalDay(cal);	
				
				//CalDay c = new CalDay(); 
				if(!c.isValid())continue; 
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = CalDayRandomTest.RandomSelectMethod(random);
					/*if(methodName.equals("CalDay")){
                                                int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                                                int day = ValuesGenerator.getRandomIntBetween(random, 1, 31);
                                                int year =ValuesGenerator.RandInt(random);
						LinkedList<Appt> list=null;
                                                GregorianCalendar cal = new GregorianCalendar(year, month, day);
                                                CalDay c = new CalDay(cal);
						c.setAppts(list);
					}*/
					if (methodName.equals("addAppt")){
						int startH,startM,startD,startMth,startY;
						String tit;
						String descrip;
						Appt appt;
					//	int startH=ValuesGenerator.getRandomIntBetween(random, 0, 23);
                                        //        int startM=ValuesGenerator.getRandomIntBetween(random, 0, 59);
                                        //        int startD=ValuesGenerator.getRandomIntBetween(random, 1, 28);;
                                          //      int startMth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                                            //    int startY=ValuesGenerator.getRandomIntBetween(random, 100,2020);
                                              //  String tit=(String) ValuesGenerator.getString(random);
                                               // String descrip=(String) ValuesGenerator.getString(random);
						do{
							startH=ValuesGenerator.getRandomIntBetween(random, 0, 23);
							startM=ValuesGenerator.getRandomIntBetween(random, 0, 59);
							startD=ValuesGenerator.getRandomIntBetween(random, 1, 28);
							startMth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
							startY=ValuesGenerator.getRandomIntBetween(random, 100,2020);
							tit=(String) ValuesGenerator.getString(random);
							descrip=(String) ValuesGenerator.getString(random);
							appt = new Appt(startH, startM, startD, startMth, startY, tit, descrip);
						} while (!appt.getValid());	
						assertEquals(true,appt.getValid());	
					//	if(!appt.getValid())continue;
						c.addAppt(appt);	
					}else if(methodName.equals("isValid")){
						boolean val = c.isValid();
					}
					else if(methodName.equals("iterator")){
						c.iterator();
						boolean test= true;
						if (c.isValid()){
							assertEquals(test,true);
						}
						else{
							assertEquals(test,false);
							assertEquals(c.iterator(),null);
						}
					}
					else if(methodName.equals("getAppts")){
						LinkedList<Appt> list = c.getAppts();
					}
					else if(methodName.equals("getSizeAppts")){
						int sizeA = c.getSizeAppts();
					}
					else if(methodName.equals("getDay")){
						int newDay = c.getDay();
					}
					else if(methodName.equals("getMonth")){
						int newMonth = c.getMonth();
					}
					else if(methodName.equals("getYear")){
						int newYear = c.getYear();
					}
					else if(methodName.equals("toString")){
						String str = c.toString();
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

	@Test
          public void radnomtest3()  throws Throwable  {

                long startTime = Calendar.getInstance().getTimeInMillis();
                long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

                System.out.println("Start testing...");

                try{
                        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                                long randomseed =System.currentTimeMillis(); //10
                                Random random = new Random(randomseed);
                                //int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                                //int day = ValuesGenerator.getRandomIntBetween(random, 1, 31);
                                //int year =ValuesGenerator.RandInt(random);
                                //GregorianCalendar cal = new GregorianCalendar(year, month, day);
                                CalDay c = new CalDay();

				//if(!c.isValid())continue;
				for (int i = 0; i < NUM_TESTS; i++) {
                                        String methodName = CalDayRandomTest.RandomSelectMethod(random);
                                        if (methodName.equals("addAppt")){
                                                int startH=ValuesGenerator.getRandomIntBetween(random, 0, 23);
                                                int startM=ValuesGenerator.getRandomIntBetween(random, 0, 59);
                                                int startD=ValuesGenerator.getRandomIntBetween(random, 1, 28);;
                                                int startMth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                                                int startY=ValuesGenerator.getRandomIntBetween(random, 100,2020);
                                                String tit=(String) ValuesGenerator.getString(random);
                                                String descrip=(String) ValuesGenerator.getString(random);
                                                Appt appt = new Appt(startH, startM, startD, startMth, startY, tit, descrip);
						c.addAppt(appt);
                                        }
					else if(methodName.equals("isValid")){
                                                boolean val = c.isValid();
                                        }
					else if(methodName.equals("iterator")){
						//!c.isValid();
                                                assertEquals(c.iterator(),null);
					}
					else if(methodName.equals("getAppts")){
                                                LinkedList<Appt> list = c.getAppts();
                                        }
                                        else if(methodName.equals("getSizeAppts")){
                                                int sizeA = c.getSizeAppts();
                                        }
                                        else if(methodName.equals("getDay")){
                                                int newDay = c.getDay();
                                        }
                                        else if(methodName.equals("getMonth")){
                                                int newMonth = c.getMonth();
                                        }
                                        else if(methodName.equals("getYear")){
                                                int newYear = c.getYear();
                                        }
                                        else if(methodName.equals("toString")){
                                                String str = c.toString();
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
				
	
	@Test
	public void radnomtest2() {
	/*	System.out.println("Start testing...");
		for (int k = 0; k < 1000000; k++) {
			long randomseed =System.currentTimeMillis();
			Random random = new Random(randomseed);
			int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int day = ValuesGenerator.getRandomIntBetween(random, 1, 31);
			int year =ValuesGenerator.RandInt(random);
                        GregorianCalendar cal = new GregorianCalendar(year, month, day);
                        CalDay c = new CalDay(cal);


//			CalDay c = new CalDay();
			HashSet<Appt> ref=new HashSet<Appt>();
//			long randomseed = System.currentTimeMillis();
//			Random random = new Random(randomseed);
			for (int i = 0; i < NUM_TESTS; i++) {
				String methodName = CalDayRandomTest.RandomSelectMethod(random);
				//int n = ApptRandomTest.RandInt(random);
				if (methodName.equals("addAppt")){
					int startH=ValuesGenerator.RandInt(random);
					int startM=ValuesGenerator.RandInt(random);
					int startD=ValuesGenerator.RandInt(random);
					int startMth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int startY=ValuesGenerator.RandInt(random);
					String tit=(String) ValuesGenerator.getString(random);
					String descrip=(String) ValuesGenerator.getString(random);
					Appt appt = new Appt(startH, startM, startD, startMth, startY, tit, descrip);
					c.addAppt(appt);
					ref.add(appt);
					assertTrue(ref.equals(ref));
				//	assertTrue(ref.equals(appt));
				//	assertEquals(appt,ref.add(appt));
				}
				else if(methodName.equals("setAppts")){
					
				}
			}
		}*/
	}
	@Test
	public void radnomtest4() {
		//CalDay c = new CalDay();
		
	}
}
