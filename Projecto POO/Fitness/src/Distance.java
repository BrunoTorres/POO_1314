
import java.util.GregorianCalendar;


public class Distance extends Activity {

	private float distance; // kilómetros
	
	public Distance(){
		super();
		this.distance =  0;
	}
	
	public Distance(String sportName, String name, GregorianCalendar date, GregorianCalendar timeSpent, int calories, String weather, float distance){
		super(sportName, name, date, timeSpent, calories, weather);
		this.distance = distance;
	}
	
	public Distance(Distance dist){
		super(dist);
		this.distance = dist.getDistance();
	}
	
	private float getDistance() {
		return this.distance;
	}

	@Override
	public void setCalories() {
		
	}
	
	@Override
	public void setRecords() {
		
	}

	@Override
	public boolean equals(Object a) {
		if(this == a)
			return true;
		if(a == null || this.getClass() != a.getClass())
			return false;
		
		Distance act = (Distance) a;		
		
		return (act.getName().equals(this.getName()) &&
			    act.getCalories() == this.getCalories() &&
			    act.getDate().equals(this.getDate()) &&
			    act.getTimeSpent().equals(this.getTimeSpent()) &&
			    act.getWeather().equals(this.getWeather()) &&
			    act.getActivityRecords().equals(this.getActivityRecords()));
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Distance clone() {
		return new Distance(this);
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Float.floatToIntBits(this.distance);
		return hash;
	}


	
}
