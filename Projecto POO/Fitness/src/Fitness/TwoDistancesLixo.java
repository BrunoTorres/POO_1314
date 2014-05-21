package Fitness;


import java.util.GregorianCalendar;


public class TwoDistancesLixo extends Distance {

	private double secondDistance; // distancia vertical (Kilómetros)
	
	public TwoDistances(){
		super();
		this.secondDistance = 0;
	}
	
	public TwoDistances(String sportName, String name, GregorianCalendar date, double timeSpent, String weather, double distance, double secondDistance){
		super(sportName, name, date, timeSpent, weather, distance);
		this.secondDistance = secondDistance;
	}
	
	public TwoDistances(TwoDistances twoDist){
		super(twoDist);
		this.secondDistance = twoDist.getSecondDistance();
	}

	public double getSecondDistance() {
		return this.secondDistance;
	}
	
	public void setSecondDistance(double secondDistance){
		this.secondDistance = secondDistance;
	}
	
	@Override
	public void setCalories() {
		int formula=((int)super.getDistance()+(int)this.secondDistance)*(int)super.getTimeSpent();
        super.setCaloriesSuper(formula);
        
	}
	/*
	@Override
	public void setPerformance() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
*/
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
