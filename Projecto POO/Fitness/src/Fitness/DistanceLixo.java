package Fitness;


import java.util.GregorianCalendar;


public class DistanceLixo {

	private double distance; // kilómetros
	
	public Distance(){
		super();
		this.distance =  0;
	}
	
	public Distance(String sportName, String name, GregorianCalendar date, double timeSpent, String weather, double distance){
		super(sportName, name, date, timeSpent, weather);
		this.distance = distance;
	}
	
	public Distance(Distance dist){
		super(dist);
		this.distance = dist.getDistance();
	}
	
	public double getDistance() {
		return this.distance;
	}

	@Override
	public void setCalories() {
        int formula=(int)super.getTimeSpent()*(int)this.getDistance();              //INVENTADO
    super.setCaloriesSuper(formula);
        
        
	}
	
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
	public Distance clone() {
		return new Distance(this);
	}
    
    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Distância percorrida: "); 
		sb.append(this.getDistance()).append("\n");
		return sb.toString();
	}

	
	
}
