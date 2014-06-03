package Fitness;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public final class TimePerDistance extends Record implements Serializable {

    private double recordDistance;
    private double time;

    /**
     *
     */
    public TimePerDistance() {
        super();
        this.recordDistance = 0.0;
        this.time = 0.0;
    }

    /**
     *
     * @param name
     * @param recordDistance
     * @param myDistance
     * @param myTime
     */
    public TimePerDistance(String name, double recordDistance, double myDistance, double myTime) {
        super(name);
        this.recordDistance = recordDistance;
        this.setStatistic(myDistance, myTime);
    }

    /**
     *
     * @param stat
     */
    public TimePerDistance(TimePerDistance stat) {
        super(stat);
        this.recordDistance = stat.getRecordDistance();
        this.time = stat.getTime();
    }

    /**
     *
     * @return
     */
    public double getTime() {
        return this.time;
    }

    /**
     *
     * @return
     */
    public double getRecordDistance() {
        return this.recordDistance;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (this.time != 0.0);
    }

    /**
     *
     * @param distance
     * @param time
     */
    public void setStatistic(double distance, double time) {
        double div;
        if (!(distance < this.recordDistance)) {
            div = this.recordDistance / distance;
            this.time = div * time;
        }
    }

    /**
     *
     * @param act
     */
    @Override
    public void update(Record act) {
        TimePerDistance a = (TimePerDistance) act;
        if (this.time < a.getTime()) {
            this.time = a.getTime();
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int h, m;
        double s;
        h = (int) this.time / 60;
        m = (int) this.time % 60;

        s = this.time - ((int) this.time);
        s = s * 60;
        sb.append(super.toString());
        if (this.time > 0) {
            sb.append("Tempo registado: ");
            if (h > 0)  sb.append(h).append("(h):"); 
            sb.append(m).append("(min): ");
            sb.append((int) s).append("(seg)\n");
        } else sb.append("Sem recorde").append("\n");

        return sb.toString();

    }

    @Override
    public TimePerDistance clone() {
        return new TimePerDistance(this);
    }

}
