
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TreeSet;

public abstract class Activity {

	private String sportName;                     //Nome do desporto :Corrida
	private String name;                         //Nome pode ser corrida com os amigos
	private GregorianCalendar date;
	private double timeSpent;
	private int calories;
	private String weather;
	private Statistics performance;

	public Activity() {
		this.sportName = "";
		this.name = "";
		this.date = new GregorianCalendar();
		this.timeSpent = 0.0;
		this.calories = 0;
		this.weather = "";
		this.performance = new Statistics();
	}


	public Activity(String sportName, String name, GregorianCalendar date, double timeSpent, String weather) {
		this.sportName = sportName;
		this.name = name;
		this.date = (GregorianCalendar) date.clone();
		this.timeSpent = timeSpent;
		this.setCalories();
		this.weather = weather;
		this.setPerformance();
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
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}


	/**
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return (GregorianCalendar) this.date.clone();
	}


	/**
	 * @return the timeSpent
	 */

	public double getTimeSpent() {
		return  this.timeSpent;
	}

	/**
	 * @param timeSpent the timeSpent to set
         * Precisamos deste método?
	 */
	public void setTimeSpent(double timeSpent) {
		this.timeSpent = timeSpent;
	}

	/**
	 * @return the calories
	 */
	public int getCalories() {
		return this.calories;
	}


	/**
	 * @return the weather
	 */
	public String getWeather() {
		return this.weather;
	}


	/**
	 * @return the activityRecords
	 */
	public Statistics getPerformance() {
		Statistics aux = this.performance.clone();
		return aux;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public abstract void setCalories();


	public abstract void setPerformance();


	@Override
	public boolean equals(Object a){
		if(this == a)
			return true;
		if(a == null || this.getClass() != a.getClass())
			return false;
		
		Activity act = (Activity) a;
		
		return (this.sportName.equals(act.getSportName()) &&
				this.name.equals(act.getName()) &&
				this.date.equals(act.getDate()) &&
				this.timeSpent==act.getTimeSpent() &&
				this.calories == act.getCalories() &&
				this.weather.equals(act.getWeather()) &&
				this.performance.equals(act.getPerformance()));
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 43 * hash + Objects.hashCode(this.sportName);
		hash = 43 * hash + Objects.hashCode(this.name);
		hash = 43 * hash + Objects.hashCode(this.date);
		hash = 43 * hash + Objects.hashCode(this.timeSpent);
		hash = 43 * hash + this.calories;
		hash = 43 * hash + Objects.hashCode(this.weather);
		hash = 43 * hash + Objects.hashCode(this.performance);
		return hash;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Desporto: ");
		sb.append(this.getSportName()).append("\n");
		sb.append("Descrição: ");
		sb.append(this.getName()).append("\n");
		sb.append("Data: ");
		sb.append(this.getDate().toString()).append("\n");
		sb.append("Duração: ");
		sb.append(this.getTimeSpent()).append("\n");
		sb.append("Meteorologia: ");
		sb.append(this.getWeather()).append("\n");
		
		return sb.toString();
	}


	@Override
	public abstract Activity clone();

}

