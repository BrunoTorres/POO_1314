
public class Statistics {
     
    private double timeSpend;   
    private int calories;
    private double distance;
	
	public Statistics(){
	
        this.timeSpend=0;
        this.calories=0;
        this.distance=0;
	}
    public Statistics(double timeSpend,int calories){
    
        this.distance=0;
        this.calories=calories;
        this.timeSpend=timeSpend;
        
    }
    
    public Statistics(double timeSpend,int calories,double distance){
    
        this.distance=distance;
        this.calories=calories;
        this.timeSpend=timeSpend;
        
    }
    
 
	public Statistics(Statistics stat) {

        this.timeSpend=stat.getTimeSpend();
        this.calories=stat.getCalories();
        this.distance=stat.getDistance();
       
        
	}
    
    public double getTimeSpend(){
        return this.timeSpend;
    }
    
    public int getCalories(){
        return this.calories;
    }
    
    public double getDistance(){
        return this.distance;
    }
 	
    
    public void incrementsTimeDistanceCalories(double time,double distance,int calories){
        this.calories+=calories;
        this.distance+=distance;
        this.timeSpend+=time;
    }
    
   
    
    public String toStringDistance(){
        StringBuilder sb=new StringBuilder();  
        sb.append("Distance: ");sb.append(this.distance).append("\n");       
        return sb.toString();
    }
    
    public String toStringCalories(){
        StringBuilder sb=new StringBuilder();
        sb.append("Calories: ");sb.append(this.calories).append("\n");  
        return sb.toString();
    }
    
    public String toStringTimeSpend(){
        StringBuilder sb=new StringBuilder();
        
        sb.append("Time Spend: ");sb.append(this.timeSpend).append("\n");
        return sb.toString();
    }
    
	@Override
	public Statistics clone(){
		return new Statistics(this);
	}
}
