package Fitness;


public final class TimePerDistance extends Records
{
   private double recordTime;
   private double distance;
   
   public TimePerDistance(){
		super();
		this.recordTime = 0.0;
		this.distance = 0.0;
	}

	
	public TimePerDistance(String name, double recordTime,double distance,double time){
		super(name);
		this.recordTime = recordTime;
        this.setStatistic(time, distance);     
        
        
        
	}

	public TimePerDistance(TimePerDistance stat){
		super(stat);
		this.recordTime = stat.getRecordTime();
		this.distance = stat.getDistance();
	}

	public double getDistance(){
		return this.distance;
	}

	public double getRecordTime(){
		return this.recordTime;
	}

	@Override
	public boolean isEmpty(){
		return (this.distance != 0.0);
	}

	public void setStatistic(double time, double distance){
		double div;
		if(!(time < this.recordTime)) {
			div = this.recordTime / time;
			this.distance = div * distance;
		}
	}
	
	@Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tempo: ");sb.append(this.recordTime).append("\n");
        sb.append("Distancia registada: ");sb.append(this.distance).append("\n");
        return sb.toString();      
    }
    
	@Override
	public TimePerDistance clone(){
		return new TimePerDistance(this);
	}
   
}
