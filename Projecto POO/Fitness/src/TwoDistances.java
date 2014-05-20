
import java.util.GregorianCalendar;


public class TwoDistances extends Distance {

	private float secondDistance; // distancia vertical (Kilómetros)
	
	public TwoDistances(){
		super();
		this.secondDistance = 0;
	}
	
	public TwoDistances(String sportName, String name, GregorianCalendar date, GregorianCalendar timeSpent, String weather, float distance, float secondDistance){
		super(sportName, name, date, timeSpent, weather, distance);
		this.secondDistance = secondDistance;
	}
	
	public TwoDistances(TwoDistances twoDist){
		super(twoDist);
		this.secondDistance = twoDist.getSecondDistance();
	}

	public float getSecondDistance() {
		return this.secondDistance;
	}
	
	public void setSecondDistance(float secondDistance){
		this.secondDistance = secondDistance;
	}
	
	@Override
	public void setCalories() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void setPerformance() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean equals(Object a) {
		if(this == a)
			return true;
		if(a == null || this.getClass() != a.getClass())
			return false;
		TwoDistances twoDist = (TwoDistances) a;
		return (super.equals(twoDist) &&
			    this.secondDistance == twoDist.getSecondDistance());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 41 * hash + Float.floatToIntBits(this.secondDistance);
		return hash;
	}
	
	@Override
	public TwoDistances clone(){
		return new TwoDistances(this);
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Distância vertical: "); // Aqui acho que pode ficar assim, porque todos os desportos que tem duas distancias, esta é distancia vertical
		sb.append(this.getSecondDistance()).append("\n");
		return sb.toString();
	}
}
