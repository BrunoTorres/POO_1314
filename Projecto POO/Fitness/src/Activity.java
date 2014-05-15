
import java.util.GregorianCalendar;
import java.util.TreeSet;

public abstract class Activity {

	private String name;
	private GregorianCalendar date;
	private GregorianCalendar timeSpent;
	private int calories;
	private String weather;
	private TreeSet<Statistics> activityRecords;

	public Activity(){
		this.name = "";
		this.date = new GregorianCalendar();
		this.timeSpent = new GregorianCalendar();
		this.calories = 0;
		this.weather = "";
		this.activityRecords = new TreeSet<Statistics>();
	}
	
	public Activity(String name, GregorianCalendar date, GregorianCalendar timeSpent, int calories, String weather){
		this.name = name;
		this.date = (GregorianCalendar) date.clone();
		this.timeSpent = (GregorianCalendar) timeSpent.clone();
		this.calories = calories;
		this.weather = weather;
	}
	
	public Activity(Activity a){
		this.name = a.getName();
		this.date = a.getDate();
		this.timeSpent = a.getTimeSpent();
		this.calories = a.getCalories();
		this.weather = a.getWeather();
		this.activityRecords = a.getActivityRecords();
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
	public TreeSet<Statistics> getActivityRecords() {
		TreeSet<Statistics> aux = new TreeSet<Statistics>();
		for(Statistics stat: this.activityRecords)
			aux.add(stat.clone());
		
		return aux;
	}

	/**
	 * @param activityRecords the activityRecords to set
	 */
	public void setActivityRecords(TreeSet<Statistics> activityRecords) {
		this.activityRecords = activityRecords;
	}
	
	public abstract boolean equals(Activity a);
	
	@Override
	public abstract String toString();
	
	@Override
	public abstract Object clone();
}
