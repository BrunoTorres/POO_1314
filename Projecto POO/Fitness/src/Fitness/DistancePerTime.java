
public class DistancePerTime extends Records {
	
	private double recordDistance;
	private double time;
	
	public DistancePerTime(){
		super();
		this.recordDistance = 0.0;
		this.time = 0.0;
	}
	
	public DistancePerTime(String name, double recordDistance){
		super(name);
		this.recordDistance = recordDistance;
	}

	public DistancePerTime(DistancePerTime stat){
		super(stat);
		this.recordDistance = stat.getRecordDistance();
		this.time = stat.getTime();
	}

	public double getTime(){
		return this.time;
	}

	public double getRecordDistance(){
		return this.recordDistance;
	}

	@Override
	public boolean isEmpty(){
		return (this.time != 0.0);
	}

	public void setStatistic(double distance, double time) {
		double div;
		if(!(distance < this.recordDistance)) {
			div = this.recordDistance / distance;
			this.time = div * time;
		}
	}

	@Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distancia: ");sb.append(this.recordDistance).append("\n");
        sb.append("Tempo registado: ");sb.append(this.time).append("\n");
        return sb.toString();      
    }
    
	@Override
	public DistancePerTime clone(){
		return new DistancePerTime(this);
	}
	
}
