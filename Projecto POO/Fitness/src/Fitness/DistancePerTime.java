package Fitness;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public final class DistancePerTime extends Record implements Serializable{

    private double recordTime;
    private double distance;

    /**
     *
     */
    public DistancePerTime(){
        super();
        this.recordTime = 0.0;
        this.distance = 0.0;
    }

    /**
     *
     * @param name
     * @param recordTime
     * @param distance
     * @param time
     */
    public DistancePerTime(String name, double recordTime,double distance,double time){
        super(name);
        this.recordTime = recordTime;
        this.distance=this.setStatistic(time, distance);     
    }

    /**
     *
     * @param stat
     */
    public DistancePerTime(DistancePerTime stat){
        super(stat);
        this.recordTime = stat.getRecordTime();
        this.distance = stat.getDistance();
    }

    /**
     *
     * @return
     */
    public double getDistance(){
        return this.distance;
    }

    /**
     *
     * @return
     */
    public double getRecordTime(){
        return this.recordTime;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty(){
        return (this.distance != 0.0);
    }

    /**
     *
     * @param act
     */
    public void update(Record act){
        DistancePerTime a=(DistancePerTime)act;
        if (this.distance < a.distance)
            this.distance=a.getDistance();

        
        
    }

    /**
     *
     * @param time
     * @param distance
     * @return
     */
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
        if(this.distance > 0){             
             sb.append("Distancia registada: ");
             sb.append((float)this.distance).append(" km \n");
        }
        else
            sb.append("Sem recorde").append("\n");
        return sb.toString();      
    }

    @Override
    public DistancePerTime clone(){
        return new DistancePerTime(this);
    }


}
