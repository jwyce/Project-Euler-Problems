package euler;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Problem_019 {

	public static void main(String[] args) {
		LocalDate start = LocalDate.of(1901, 1, 1);
		LocalDate end = LocalDate.of(2000, 12, 31);
		long startTime = System.currentTimeMillis();
		
		System.out.println("There are " + numberOfSundays(start, end)
			+ " Sundays on the first of the month between\n" + start.toString() + " and " + end.toString());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
		
		long startTime2 = System.currentTimeMillis();
		
		System.out.println("\nThere are " + nonAPINumberOfSundays(1, 1, 1901, 31, 12, 2000)
			+ " Sundays on the first of the month between\nJanuary 1st 1901 and December 31st 2000.");
		
		long endTime2 = System.currentTimeMillis();
		System.out.println("It took " + (endTime2 - startTime2) + " ms.");
	}
	
	private static int numberOfSundays(LocalDate startDay, LocalDate endDay) {
		int numberOfSundays = 0;
		
		while(startDay.isBefore(endDay)) {
			startDay = startDay.plusMonths(1);
			if(startDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
				numberOfSundays++;
			}
		}
		
		return numberOfSundays;
	}
	
	private static int nonAPINumberOfSundays(int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) {
		int numberOfSundays = 0;
		int knownMondayYear = 1900;
		int currentDay = 0; 		// 1 = monday ... 0 = sunday
		ArrayList<Integer> daysInMonths = new ArrayList<Integer>(12);
		daysInMonths.add(31);
		daysInMonths.add(28);
		daysInMonths.add(31);
		daysInMonths.add(30);
		daysInMonths.add(31);
		daysInMonths.add(30);
		daysInMonths.add(31);
		daysInMonths.add(31);
		daysInMonths.add(30);
		daysInMonths.add(31);
		daysInMonths.add(30);
		daysInMonths.add(31);
		
		while(knownMondayYear <= endYear) {
			for(int month = 0; month < daysInMonths.size(); month++) {
				if(month == 1 && startYear % 4 == 0 && (startYear % 100 != 0 || startYear % 400 == 0) ) {		// leap year
					currentDay = (currentDay + daysInMonths.get(month) + 1) % 7;
				} else {
					currentDay = (currentDay + daysInMonths.get(month)) % 7;
				}
				
				if(knownMondayYear >= startYear && month >= startMonth - 1) {		// start counting sundays
					if((currentDay + 1) % 7 == 0) numberOfSundays++;
				}
			}
			knownMondayYear++;
		}
		
		return numberOfSundays;
	}

}
