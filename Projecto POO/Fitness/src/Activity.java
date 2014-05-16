
import java.util.GregorianCalendar;
import java.util.TreeSet;

public abstract class Activity {

	private String sportName;
	private String name;                         // corrida ao leu
	private GregorianCalendar date;
	private GregorianCalendar timeSpent;
	private int calories;
	private String weather;
	private Statistics performance;

	public Activity() {
		this.sportName = "";
		this.name = "";
		this.date = new GregorianCalendar();
		this.timeSpent = new GregorianCalendar();
		this.calories = 0;
		this.weather = "";
		this.performance = new Statistics();
	}

	public Activity(String sportName, String name, GregorianCalendar date, GregorianCalendar timeSpent, int calories, String weather) {
		this.sportName = sportName;
		this.name = name;
		this.date = (GregorianCalendar) date.clone();
		this.timeSpent = (GregorianCalendar) timeSpent.clone();
		this.calories = calories;
		this.weather = weather;
		this.performance = new Statistics();
	}

	public Activity(Activity a) {
		this.sportName = a.getSportName();
		this.name = a.getName();
		this.date = a.getDate();
		this.timeSpent = a.getTimeSpent();
		this.calories = a.getCalories();
		this.weather = a.getWeather();
		this.performance = a.getPerformance();
	}

	public String getSportName(){
		return this.sportName;
	}
	
	public void setSportName(String sportName){
		this.sportName = sportName;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return (GregorianCalendar) date.clone();
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	/**
	 * @return the timeSpent
	 */
	public GregorianCalendar getTimeSpent() {
		return (GregorianCalendar) timeSpent.clone();
	}

	/**
	 * @param timeSpent the timeSpent to set
	 */
	public void setTimeSpent(GregorianCalendar timeSpent) {
		this.timeSpent = timeSpent;
	}

	/**
	 * @return the calories
	 */
	public int getCalories() {
		return calories;
	}

	public abstract void setCalories();

	/**
	 * @return the weather
	 */
	public String getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}

	/**
	 * @return the activityRecords
	 */
	public Statistics getPerformance() {
		Statistics aux = this.performance.clone();
		return aux;
	}

	/**
	 * @param perf
	 */
	public void setPerformance (float perf) {
		this.performance.setRecord(perf);
	}

	public abstract void setRecords();

	@Override
	public abstract boolean equals(Object a);

	@Override
	public abstract String toString();

	@Override
	public abstract Object clone();

}

