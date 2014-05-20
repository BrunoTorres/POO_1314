
import java.util.GregorianCalendar;


public class Distance extends Activity {

	private float distance; // kilómetros
	
	public Distance(){
		super();
		this.distance =  0;
	}
	
	public Distance(String sportName, String name, GregorianCalendar date, GregorianCalendar timeSpent, String weather, float distance){
		super(sportName, name, date, timeSpent, weather);
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
	public void setPerformance() {
	}

	@Override
	public boolean equals(Object a) {
		if(this == a)
			return true;
		if(a == null || this.getClass() != a.getClass())
			return false;
		Distance act = (Distance) a;
                return (super.equals(act) && this.distance == act.getDistance());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Distância percorrida: "); 
		sb.append(this.getDistance()).append("\n");
		return sb.toString();
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
