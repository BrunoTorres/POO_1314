
public class Statistics {

	private String name;
	private float record;       // que é este record?!
    private double timeSpend;   
    private int calories;
    private float distance;
	
	public Statistics(){
		this.name = "";
		this.record = 0;
        this.timeSpend=0;
        this.calories=0;
        this.distance=0;
	}
    
    public Statistics(double timeSpend,int calories,float distance){
        this.name="to Stats";
        this.record=0;
        this.distance=distance;
        this.calories=calories;
        this.timeSpend=timeSpend;
        
    }
    
    public Statistics(String name,float record){
        this.name = name;
		this.record = record;
        this.timeSpend=0;
        this.calories=0;
        this.distance=0;
    }

	public Statistics(Statistics stat) {
		this.name = stat.getName();
		this.record = stat.getRecord();
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
    
    public float getDistance(){
        return this.distance;
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
	 * @return the record
	 */
	public float getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(float record) {
		this.record = record;
	}
	
    
    public void incrementsTimeDistanceCalories(double time,float distance,int calories){
        this.calories+=calories;
        this.distance+=distance;
        this.timeSpend+=time;
    }
    
    
    
	@Override
	public Statistics clone(){
		return new Statistics(this);
	}
}
