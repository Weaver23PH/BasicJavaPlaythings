package task;

public class GetDayOfWeek {
	public enum days {
		Poniedziałek,
		Wtorek,
		Środa,
		Czwartek,
		Piątek,
		Sobota,
		Niedziela;
	}
	
	public String getWeekDay(int day) {
		switch (day) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				return "Today: " + days.values()[day - 1];
			
			default:
				return "No such day";
			
		}
	}
	
}
