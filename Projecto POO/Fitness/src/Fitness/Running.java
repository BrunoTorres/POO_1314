package Fitness;

import java.util.GregorianCalendar;

/**
 * Write a description of class Running here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Running extends Outdoor implements Distance, RecordsActivity {

    private double distance;
    private ListRecords recs;

    public Running() {
        super();
        this.distance = 0;
        this.recs = new ListRecords();
    }

    public Running(String name, GregorianCalendar date, double timeSpent, double distance, String weather) {
        super(name, date, timeSpent, weather);
        this.distance = distance;
        this.recs = createRecord();

    }

    public Running(Running tb) {
        super(tb);
        this.distance = tb.getDistance();

    }

    @Override
    public double getDistance() {
        return this.distance;
    }

    @Override
    public ListRecords getListRecords() {
        return this.recs.clone();
    }

    @Override
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public void setCalories(double peso) {
        double mets = 7;
        double calories = mets * peso * this.getTimeSpent();
        this.setActivityCalories(calories);
    }

    private ListRecords createRecord() {
        ListRecords list = new ListRecords("Running");

        Records recCooper = new DistancePerTime("Cooper", 12, this.distance, this.getTimeSpent());
        Records rec1km = new TimePerDistance("1 km", 1, this.distance, this.getTimeSpent());
        Records rec1mile = new TimePerDistance("1 mile", 1.609344, this.distance, this.getTimeSpent());
        Records rec3km = new TimePerDistance("3 km", 3, this.distance, this.getTimeSpent());
        Records rec10km = new TimePerDistance("10 km", 10, this.distance, this.getTimeSpent());
        Records rechalfMarathon = new TimePerDistance("Half Marathon km", 21.097494, this.distance, this.getTimeSpent());

        list.addRecord(recCooper);
        list.addRecord(rec1km);
        list.addRecord(rec1mile);
        list.addRecord(rec3km);
        list.addRecord(rec10km);
        list.addRecord(rechalfMarathon);

        return list;

    }

         ////////////toString equals clone
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distance").append("\n");
        sb.append(this.distance).append("\n");
        return sb.toString();
    }



        @Override
        public boolean equals(Object a){
            if(this == a)
                return true;
            if(a == null || this.getClass() != a.getClass())
                return false;
            Running act = (Running) a;
            return  ( super.equals(act)
                    && this.distance==act.getDistance());
            
        }
        
        @Override
        public Running clone() {
            return new Running(this);
    }

}
