
public class Statistics {
     
    private double timeSpend;   
    private int calories;

	
	public Statistics(){
	
        this.timeSpend=0;
        this.calories=0;
    
	}
    
    public Statistics(double timeSpend,int calories){    
       
        this.calories=calories;
        this.timeSpend=timeSpend;
        
    }
    
 
	public Statistics(Statistics stat) {

        this.timeSpend=stat.getTimeSpend();
        this.calories=stat.getCalories();
        
       
        
	}
    
    public double getTimeSpend(){
        return this.timeSpend;
    }
    
    public int getCalories(){
        return this.calories;
    }
    
   
    
    public void incrementsTimeCalories(double time,int calories){
        this.calories+=calories;
        this.timeSpend+=time;
    }
    
   
    
    public String toString(){
        StringBuilder sb=new StringBuilder();
        
        sb.append("Time Spend: ");sb.append(this.timeSpend).append("\n");
        sb.append("Calories: ");sb.append(this.calories).append("\n");
        
        return sb.toString();
    }
    
	@Override
	public Statistics clone(){
		return new Statistics(this);
	}
}
