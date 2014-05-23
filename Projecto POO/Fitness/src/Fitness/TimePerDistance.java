package Fitness;

public final class TimePerDistance extends Records {

    private double recordDistance;
    private double time;

    public TimePerDistance() {
        super();
        this.recordDistance = 0.0;
        this.time = 0.0;
    }

    public TimePerDistance(String name, double recordDistance, double myDistance, double myTime) {
        super(name);
        this.recordDistance = recordDistance;
        this.setStatistic(myDistance, myTime);
    }

    public TimePerDistance(TimePerDistance stat) {
        super(stat);
        this.recordDistance = stat.getRecordDistance();
        this.time = stat.getTime();
    }

    public double getTime() {
        return this.time;
    }

    public double getRecordDistance() {
        return this.recordDistance;
    }

    @Override
    public boolean isEmpty() {
        return (this.time != 0.0);
    }

    public void setStatistic(double distance, double time) {
        double div;
        if (!(distance < this.recordDistance)) {
            div = this.recordDistance / distance;
            this.time = div * time;
        }
    }

    public void update(Records act) {
        TimePerDistance a = (TimePerDistance) act;
        if (this.time < a.getTime()) {
            this.time = a.getTime();
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distancia: ");
        sb.append(this.recordDistance).append("\n");
        sb.append("Tempo registado: ");
        sb.append(this.time).append("\n");
        return sb.toString();
    }

    @Override
    public TimePerDistance clone() {
        return new TimePerDistance(this);
    }

}
