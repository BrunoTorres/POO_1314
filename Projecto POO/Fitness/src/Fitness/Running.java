package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;
import java.util.Objects;

/**
 * Actividade Running.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Running extends Outdoor implements Distance, RecordsActivity, Serializable {

    private double distance;
    private ListRecords recs;

    /**
     * Construtor vazio.
     */
    public Running() {
        super();
        this.distance = 0;
        this.recs = new ListRecords();
    }

    /**
     * Construtor parametrizado.
     *
     * @param name - Nome da actividade.
     * @param date - Data da realização da actividade.
     * @param timeSpent - Tempo gasto em minutos.
     * @param distance - Distancia.
     * @param weather - Clima.
     */
    public Running(String name, GregorianCalendar date, double timeSpent, double distance, String weather) {
        super(name, date, timeSpent, weather);
        this.distance = distance;
        this.recs = createRecord();
    }

    /**
     * Construtor de cópia.
     *
     * @param tb - instancia de Running.
     */
    public Running(Running tb) {
        super(tb);
        this.distance = tb.getDistance();
        this.recs = tb.getListRecords();
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
        double calories = mets * peso * (this.getTimeSpent() / 60);
        this.setActivityCalories(calories);
    }

    private ListRecords createRecord() {
        ListRecords list = new ListRecords("Running");

        Record recCooper = new DistancePerTime("Cooper", 12, this.distance, this.getTimeSpent());
        Record rec1hour = new DistancePerTime("1 hour", 60, this.distance, this.getTimeSpent());
        Record rec1km = new TimePerDistance("1 km", 1, this.distance, this.getTimeSpent());
        Record rec1mile = new TimePerDistance("1 mile", 1.609344, this.distance, this.getTimeSpent());
        Record rec3km = new TimePerDistance("3 km", 3, this.distance, this.getTimeSpent());
        Record rec10km = new TimePerDistance("10 km", 10, this.distance, this.getTimeSpent());
        Record rechalfMarathon = new TimePerDistance("Half Marathon km", 21.097494, this.distance, this.getTimeSpent());

        list.addRecord(recCooper);
        list.addRecord(rec1hour);
        list.addRecord(rec1km);
        list.addRecord(rec1mile);
        list.addRecord(rec3km);
        list.addRecord(rec10km);
        list.addRecord(rechalfMarathon);

        return list;
    }

    ////////////toString equals clone
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distance").append("\n");
        sb.append(this.distance).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }
        if (a == null || this.getClass() != a.getClass()) {
            return false;
        }
        Running act = (Running) a;
        return (super.equals(act)
                && this.distance == act.getDistance());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.recs);
        return hash;
    }

    @Override
    public Running clone() {
        return new Running(this);
    }
}
