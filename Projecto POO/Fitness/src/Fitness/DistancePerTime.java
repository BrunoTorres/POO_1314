package Fitness;


public final class DistancePerTime extends Record{

    private double recordTime;
    private double distance;

    public DistancePerTime(){
        super();
        this.recordTime = 0.0;
        this.distance = 0.0;
    }


    public DistancePerTime(String name, double recordTime,double distance,double time){
        super(name);
        this.recordTime = recordTime;
        this.distance=this.setStatistic(time, distance);     
    }

    public DistancePerTime(DistancePerTime stat){
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

    public void update(Record act){
        DistancePerTime a=(DistancePerTime)act;
        if (this.distance < a.distance)
            this.distance=a.getDistance();

        
        
    }
    public double setStatistic(double time, double distance){
        double div=0;
        if(!(time < this.recordTime)) {
            div = this.recordTime / time;
            div = div * distance;
        }
        return div;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distancia registada: ");sb.append(this.distance).append(" km \n");
        return sb.toString();      
    }

    @Override
    public DistancePerTime clone(){
        return new DistancePerTime(this);
    }


}
