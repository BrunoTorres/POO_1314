package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 *
 * Actividade Cycling.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Cycling extends Outdoor implements Distance, RecordsActivity, Serializable {

    private double distance;
    private ListRecords recs;

    /**
     * Construtor vazio.
     */
    public Cycling() {
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
     * @param distance - Distancia feita.
     * @param weather - Clima.
     */
    public Cycling(String name, GregorianCalendar date, double timeSpent, double distance, String weather) {
        super(name, date, timeSpent, weather);
        this.distance = distance;
        this.createRecord();
        this.recs = createRecord();

    }

    /**
     *
     * Construtor de cópia.
     *
     * @param tb - instância de Cycling.
     */
    public Cycling(Cycling tb) {
        super(tb);
        this.distance = tb.getDistance();
        this.recs = tb.getListRecords();

    }

    @Override
    public double getDistance() {
        return this.distance;
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

    @Override
    public ListRecords getListRecords() {
        return this.recs.clone();
    }

    private ListRecords createRecord() {
        ListRecords list = new ListRecords("Cycling");

        Record recCooper = new DistancePerTime("One hour (km)", 60, this.distance, this.getTimeSpent());
        Record rec10miles = new TimePerDistance("10 miles", 16.09344, this.distance, this.getTimeSpent());
        Record rec3km = new TimePerDistance("20 km", 20, this.distance, this.getTimeSpent());
        Record rec10km = new TimePerDistance("50 km", 50, this.distance, this.getTimeSpent());
        Record rec50miles = new TimePerDistance("50 miles", 80.4672, this.distance, this.getTimeSpent());

        list.addRecord(recCooper);
        list.addRecord(rec10miles);
        list.addRecord(rec3km);
        list.addRecord(rec10km);
        list.addRecord(rec50miles);

        return list;

    }

     ////////////toString equals clone
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distancia: ").append("\n");
        sb.append(this.distance).append(" (km)\n");
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
        Cycling act = (Cycling) a;
        return (super.equals(act)
                && this.distance == act.getDistance());

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        return hash;
    }

    @Override
    public Cycling clone() {
        return new Cycling(this);
    }
}
