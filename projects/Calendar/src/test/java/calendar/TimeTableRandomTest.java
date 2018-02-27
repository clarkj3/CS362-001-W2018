package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1;
        private static final int NUM_TESTS=100;

        /*
        Return a randomly selected method to be tests !.
	*/
	public static String RandomSelectMethod(Random random){ 
		String[] methodArray = new String[] {"getApptRange","deleteAppt","permute"};
		int n = random.nextInt(methodArray.length);
		return methodArray[n];
        }

	/*
 	Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	*/
	public static int RandomSelectRecur(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};
		int n = random.nextInt(RecurArray.length);
                return RecurArray[n] ; // return the value of the  appointments to recur
	}

	/*
 	Return a randomly selected appointments to recur forever or Never recur  !. 
	*/
	public static int RandomSelectRecurForEverNever(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};
		int n = random.nextInt(RecurArray.length);
                return RecurArray[n] ; // return the method name
        }



   /**
     * Generate Random Tests that tests TimeTable Class.
     */
	@Test
	public void radnomtest()  throws Throwable  {
		for (int y = 0; y < 10; y++) {
		long startTime = Calendar.getInstance().getTimeInMillis();
                long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

                System.out.println("Start testing...");

                try{	
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                                long randomseed =System.currentTimeMillis(); //10
                                Random random = new Random(randomseed); 
				TimeTable t = new TimeTable();
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					if (methodName.equals("permute")){
						for (int n = 0; n < 1000; n++) {
						LinkedList<Appt> list= new LinkedList();
						int listSize = ValuesGenerator.RandInt(random);

						for(int x = 0; x < listSize; x++){
							int startHour=ValuesGenerator.getRandomIntBetween(random, 0,23);
							int startMin= ValuesGenerator.getRandomIntBetween(random, 1,59);
							int startDay= ValuesGenerator.getRandomIntBetween(random, 1,27);
							int startMonth= ValuesGenerator.getRandomIntBetween(random, 1,11);
							int startYear= ValuesGenerator.getRandomIntBetween(random, 1900,2020);
							String title=(String) ValuesGenerator.getString(random);
							String description=(String) ValuesGenerator.getString(random);
							Appt appt = new Appt(startHour,startMin,startDay,startMonth,startYear,title,description);
							list.add(appt);	
						}
						int sizeArray = ValuesGenerator.RandInt(random);
						int [] testVal = ValuesGenerator.generateRandomArray(random, sizeArray); 
						t.permute(list, testVal);
						}
					}
					else if(methodName.equals("getApptRange")){
						for (int n = 0; n < 1000; n++) {
						LinkedList<Appt> list= new LinkedList();
                                                int listSize = ValuesGenerator.RandInt(random);

						for(int x = 0; x < listSize; x++){
                                                        int startHour=ValuesGenerator.getRandomIntBetween(random, 0,23);
                                                        int startMin= ValuesGenerator.getRandomIntBetween(random, 1,59);
                                                        int startDay= ValuesGenerator.getRandomIntBetween(random, 1,27);
                                                        int startMonth= ValuesGenerator.getRandomIntBetween(random, 1,11);
                                                        int startYear= ValuesGenerator.getRandomIntBetween(random, 1900,2020);
                                                        String title=(String) ValuesGenerator.getString(random);
                                                        String description=(String) ValuesGenerator.getString(random);
                                                        Appt appt = new Appt(startHour,startMin,startDay,startMonth,startYear,title,description);
                                                        list.add(appt);
                                                }
						int day1 =ValuesGenerator.RandInt(random);
						int day2 = ValuesGenerator.RandInt(random);
						int month1 = ValuesGenerator.RandInt(random);
						int month2 = ValuesGenerator.RandInt(random);
						int year1 = ValuesGenerator.RandInt(random);
						int year2;
						do{
							year2 = ValuesGenerator.RandInt(random);
						} while (year1>year2);
						GregorianCalendar one = new GregorianCalendar(year1, month1, day1);
						GregorianCalendar two = new GregorianCalendar(year2, month2, day2);
						t.getApptRange(list,one,two);
						}
					}
					else if(methodName.equals("deleteAppt")){
						for (int n = 0; n < 1000; n++) {
						LinkedList<Appt> list= new LinkedList();
                                                int listSize = ValuesGenerator.RandInt(random);

                                                for(int x = 0; x < listSize; x++){
                                                        int startHour=ValuesGenerator.getRandomIntBetween(random, 0,23);
                                                        int startMin= ValuesGenerator.getRandomIntBetween(random, 1,59);
                                                        int startDay= ValuesGenerator.getRandomIntBetween(random, 1,27);
                                                        int startMonth= ValuesGenerator.getRandomIntBetween(random, 1,11);
                                                        int startYear= ValuesGenerator.getRandomIntBetween(random, 1900,2020);
                                                        String title=(String) ValuesGenerator.getString(random);
                                                        String description=(String) ValuesGenerator.getString(random);
                                                        Appt appt = new Appt(startHour,startMin,startDay,startMonth,startYear,title,description);
                                                        list.add(appt);
						}
						int startHour=ValuesGenerator.getRandomIntBetween(random, 0,23);
                                                int startMin= ValuesGenerator.getRandomIntBetween(random, 1,59);
                                                int startDay= ValuesGenerator.getRandomIntBetween(random, 1,27);
                                                int startMonth= ValuesGenerator.getRandomIntBetween(random, 1,11);
                                                int startYear= ValuesGenerator.getRandomIntBetween(random, 1900,2020);
                                                String title=(String) ValuesGenerator.getString(random);
                                                String description=(String) ValuesGenerator.getString(random);
                                                Appt appt = new Appt(startHour,startMin,startDay,startMonth,startYear,title,description);
						t.deleteAppt(list,appt);
						}
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
        } 

	@Test
        public void radnomtest2()  throws Throwable  {
		for (int n = 0; n < 10; n++) {
                long startTime = Calendar.getInstance().getTimeInMillis();
                long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

                System.out.println("Start testing...");

                try{
                        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                                long randomseed =System.currentTimeMillis(); //10
                                Random random = new Random(randomseed);
                                TimeTable t = new TimeTable();
                                for (int i = 0; i < NUM_TESTS; i++) {
                                        String methodName = TimeTableRandomTest.RandomSelectMethod(random);
                                        if (methodName.equals("permute")){
                                                LinkedList<Appt> list= new LinkedList();
						int sizeArray = ValuesGenerator.RandInt(random);
                                                int [] testVal = ValuesGenerator.generateRandomArray(random, sizeArray);
                                                t.permute(list, testVal);
                                        }
                                        else if(methodName.equals("getApptRange")){
                                                LinkedList<Appt> list= new LinkedList();
                                                int listSize = ValuesGenerator.getRandomIntBetween(random, 0,50);

                                                int day1 =ValuesGenerator.RandInt(random);
                                                int day2 = ValuesGenerator.RandInt(random);
                                                int month1 = ValuesGenerator.RandInt(random);
                                                int month2 = ValuesGenerator.RandInt(random);
                                                int year1 = ValuesGenerator.RandInt(random);
                                                int year2;
                                                do{
                                                        year2 = ValuesGenerator.RandInt(random);
                                                } while (year1>year2);
                                                GregorianCalendar one = new GregorianCalendar(year1, month1, day1);
                                                GregorianCalendar two = new GregorianCalendar(year2, month2, day2);
                                                t.getApptRange(list,one,two);
                                        }
                                        else if(methodName.equals("deleteAppt")){
						LinkedList<Appt> list= new LinkedList();
                                                int listSize = ValuesGenerator.getRandomIntBetween(random, 0,50);
						//LinkedList<Appt> list=null;
						Appt appt = null;
						assertEquals(appt.getValid(),false);
                                                assertEquals(t.deleteAppt(list,appt),null);
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
                                TimeTable t = new TimeTable();
                                for (int i = 0; i < NUM_TESTS; i++) {
                                        String methodName = TimeTableRandomTest.RandomSelectMethod(random);
                                        if (methodName.equals("permute")){
                                                LinkedList<Appt> list= new LinkedList();
                                                int sizeArray = ValuesGenerator.RandInt(random);
                                                int [] testVal = ValuesGenerator.generateRandomArray(random, sizeArray);
                                                t.permute(list, testVal);
                                        }
                                        else if(methodName.equals("getApptRange")){
                                                LinkedList<Appt> list= new LinkedList();
						int listSize = ValuesGenerator.RandInt(random);

                                                for(int x = 0; x < listSize; x++){
                                                        int startHour=ValuesGenerator.RandInt(random);
                                                        int startMin= ValuesGenerator.RandInt(random);
                                                        int startDay= ValuesGenerator.RandInt(random);
                                                        int startMonth= ValuesGenerator.RandInt(random);
                                                        int startYear= ValuesGenerator.RandInt(random);
                                                        String title=(String) ValuesGenerator.getString(random);
                                                        String description=(String) ValuesGenerator.getString(random);
                                                        Appt appt = new Appt(startHour,startMin,startDay,startMonth,startYear,title,description);
                                                        if(!appt.getValid()) continue;
							list.add(appt);
                                                }
                                                int day1 =ValuesGenerator.RandInt(random);
                                                int day2 = ValuesGenerator.RandInt(random);
                                                int month1 = ValuesGenerator.RandInt(random);
                                                int month2 = ValuesGenerator.RandInt(random);
                                                int year1 = ValuesGenerator.RandInt(random);
                                                int year2 = ValuesGenerator.RandInt(random);
                                                GregorianCalendar one = new GregorianCalendar(year1, month1, day1);
                                                GregorianCalendar two = new GregorianCalendar(year2, month2, day2);
                                                t.getApptRange(list,one,two);
                                        }
                                        else if(methodName.equals("deleteAppt")){
                                                LinkedList<Appt> list= new LinkedList();
						int listSize = ValuesGenerator.RandInt(random);

                                                for(int x = 0; x < listSize; x++){
                                                        int startHour=ValuesGenerator.getRandomIntBetween(random, 0,23);
                                                        int startMin= ValuesGenerator.getRandomIntBetween(random, 1,59);
                                                        int startDay= ValuesGenerator.getRandomIntBetween(random, 1,27);
                                                        int startMonth= ValuesGenerator.getRandomIntBetween(random, 1,11);
                                                        int startYear= ValuesGenerator.getRandomIntBetween(random, 1900,2020);
                                                        String title=(String) ValuesGenerator.getString(random);
                                                        String description=(String) ValuesGenerator.getString(random);
                                                        Appt appt = new Appt(startHour,startMin,startDay,startMonth,startYear,title,description);
                                                        list.add(appt);
                                                }
						int index=ValuesGenerator.getRandomIntBetween(random, 1,listSize);
						Appt appt = list.get(index);
                                               // t.deleteAppt(list,appt);
						assertEquals(t.deleteAppt(list,appt),appt);
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

}
