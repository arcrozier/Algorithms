/*
Season calendar takes a month and day as a date and returns a season as follows
Dec 21 - Mar 20: Winter; Mar 21 - Jun 20: Spring; Jun 21 - Sep 20: Summer; Sep 21 - Dec 20: Autumn
You can handle month/day combinations that are invalid as you wish.  Test results:

 Season Calendar
3 20
Winter

Season Calendar
4 27
Spring
 */

public class SeasonCalendar implements ProblemIO {
	private int month; // month of date to calculate season for
	private int day; // day of date to calculate season form

	public SeasonCalendar(int month, int day) {
		this.month = month;
		this.day = day;
	}

	public String calcSeason() {
		String season;
		if (month == 1 || month == 2) {
			season = "Winter";
		} else if (month == 3) {
			season = day <= 20 ? "Winter" : "Sprint";
		} else if (month == 4 || month == 5) {
			season = "Spring";
		} else if (month == 6) {
			season = day <= 20 ? "Spring" : "Summer";
		} else if (month == 7 || month == 8) {
			season = "Summer";
		} else if (month == 9) {
			season = day <= 20 ? "Summer" : "Autumn";
		} else if (month == 10 || month == 11) {
			season = "Autumn";
		} else if (month == 12) {
			season = day <= 20 ? "Autumn" : "Winter";
		} else {
			season = "Unknown";
		}
		return season;
	}

	@Override
	public String problemHeader() {
		return "Season Calendar";
	}

	@Override
	public String problemInput() {
		return month + " " + day;
	}

	@Override
	public String problemOutput() {
		// TODO Auto-generated method stub
		return calcSeason();
	}

}
